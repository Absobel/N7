clear all; close all; clc;

affichage_eyediagram = false;
affichage_comparaison_chaine = true;


Fe = 24000; Te = 1/Fe;
Rb = 3000; Tb = 1/Rb;
% Pour eviter que le code prenne trop de temps a s'executer
if affichage_eyediagram
    nbits = 1000;
else
    nbits = 100000;
end

if affichage_eyediagram
    SNR_dB = 0:5:20;
else
    SNR_dB = 0:8;
end
len_SNR = length(SNR_dB);
SNR = 10.^(SNR_dB/10);

tableaux_TEB1_pra = zeros(len_SNR,1);
tableaux_TEB1_the = zeros(len_SNR,1);
tableaux_TEB2_pra = zeros(len_SNR,1);
tableaux_TEB2_the = zeros(len_SNR,1);
tableaux_TEB3_pra = zeros(len_SNR,1);
tableaux_TEB3_the = zeros(len_SNR,1);

for i = 1:length(SNR)
    Ns = nb_symbole(1, Tb, Te);
    [tableaux_TEB1_pra(i), signal_recu] = BdB(1,nbits,Ns,SNR(i));

    if affichage_eyediagram
        eyediagram(signal_recu(Ns+1:end), 2*Ns, 2*Ns, Ns-1);
        title("Diagramme d'oeil pour SNR = " + SNR_dB(i) + " dB de la chaine 1");
    end

    tableaux_TEB1_the(i) = qfunc(sqrt(2*SNR(i)));

    Ns = nb_symbole(2, Tb, Te);
    [tableaux_TEB2_pra(i), signal_recu] = BdB(2,nbits,Ns,SNR(i));
    tableaux_TEB2_the(i) = qfunc(sqrt(SNR(i)));

    if affichage_eyediagram
        eyediagram(signal_recu(Ns+1:end), 2*Ns, 2*Ns, Ns-1);
        title("Diagramme d'oeil pour SNR = " + SNR_dB(i) + " dB de la chaine 2");
    end

    Ns = nb_symbole(3, Tb, Te);
    [tableaux_TEB3_pra(i),signal_recu] = BdB(3,nbits,Ns,SNR(i));
    tableaux_TEB3_the(i) = 3/4*qfunc(sqrt(4/5*SNR(i)));

    if affichage_eyediagram
        eyediagram(signal_recu(Ns+1:end), 2*Ns, 2*Ns, Ns-1);
        title("Diagramme d'oeil pour SNR = " + SNR_dB(i) + " dB de la chaine 3");
    end
end

semilogy(SNR_dB,tableaux_TEB1_pra,'b', 'LineWidth', 2); hold on;
semilogy(SNR_dB,tableaux_TEB1_the, 'r', 'LineWidth', 2); hold off;
title("Comparaison TEB pratique/théorique pour différentes bandes passantes (chaine 1)")
xlabel("log10(BandePassante)")
ylabel("TEB")
legend("pratique", "theorique")

figure;
semilogy(SNR_dB,tableaux_TEB2_pra,'b', 'LineWidth', 2); hold on;
semilogy(SNR_dB,tableaux_TEB2_the, 'r', 'LineWidth', 2); hold off;
title("Comparaison TEB pratique/théorique pour différentes bandes passantes (chaine 2)")
xlabel("log10(BandePassante)")
ylabel("TEB")
legend("pratique", "theorique")

figure;
semilogy(SNR_dB,tableaux_TEB3_pra,'b', 'LineWidth', 2); hold on;
semilogy(SNR_dB,tableaux_TEB3_the, 'r', 'LineWidth', 2); hold off;
title("Comparaison TEB pratique/théorique pour différentes bandes passantes (chaine 3)")
xlabel("log10(BandePassante)")
ylabel("TEB")
legend("pratique", "theorique")

% Comparaison 1/2 et 1/3
if affichage_comparaison_chaine
    figure;
    semilogy(SNR_dB,tableaux_TEB1_pra,'b', 'LineWidth', 2); hold on;
    semilogy(SNR_dB,tableaux_TEB2_pra,'r', 'LineWidth', 2); hold on;
    title("Comparaison TEB pratique entre chaine 1 et chaine 2")
    xlabel("log10(BandePassante)")
    ylabel("TEB")
    legend("chaine 1", "chaine 2")

    figure;
    semilogy(SNR_dB,tableaux_TEB1_pra,'b', 'LineWidth', 2); hold on;
    semilogy(SNR_dB,tableaux_TEB3_pra,'r', 'LineWidth', 2); hold on;
    title("Comparaison TEB pratique entre chaine 1 et chaine 3")
    xlabel("log10(BandePassante)")
    ylabel("TEB")
    legend("chaine 1", "chaine 3")
end

function [Ns] = nb_symbole(nb_chaine,Tb,Te)
    if nb_chaine == 1 || nb_chaine == 2
        n = 1;
    elseif nb_chaine == 3
        n = 2;
    end
    Ts = n*Tb;
    Ns = floor(Ts/Te);
end

function [bits] = bits_aleatoire(nbits)
    bits = randi([0 1],nbits, 1);
end

function [signa_mis_en_forme] = mise_en_forme(nb_chaine, bits, Ns)
    mappage = zeros(Ns, 1);  % Permet de créer des impulsions de durée Ns
    mappage(1) = 1;
    if nb_chaine == 1 || nb_chaine == 2
        signal_mappe = kron(2*bits-1, mappage);
    elseif nb_chaine == 3
        signal = reshape(bits', [2 length(bits)/2]);
        signal = sum(signal.*[2; 1]);

        % code de gray

        signal(signal == 0) = -3;
        signal(signal == 1) = -1;
        signal(signal == 3) = 1;
        signal(signal == 2) = 3;

        signal_mappe = kron(signal', mappage);
    end
    h = ones(1,Ns);
    signa_mis_en_forme = filter(h,1,signal_mappe);
end

function [signal_propage] = propagation(nb_chaine,signa_mis_en_forme,Ns,SNR)
    Px = mean(abs(signa_mis_en_forme).^2);
    if nb_chaine == 1 || nb_chaine == 2
        sigman = sqrt(Px*Ns/(2*SNR));
    elseif nb_chaine == 3
        sigman = sqrt(Px*Ns/(4*SNR));
    end
    bruit = sigman*randn(1,length(signa_mis_en_forme))';
    signal_propage = signa_mis_en_forme + bruit;
    %signal_propage = signa_mis_en_forme;
end

function [signal_recu] = reception(nb_chaine,signal_propage,Ns)
    if nb_chaine == 1 || nb_chaine == 3
        hr = ones(1,Ns);
    elseif nb_chaine == 2
        hr = [ones(1, (floor(Ns/2))),zeros(1, (floor(Ns/2)))];
    end
    signal_recu = filter(hr,1,signal_propage);
end

function [taux_erreur] = demapping(nb_chaine, signal_recu, nbits, bits,Ns)
    if nb_chaine == 1
        resultat = reshape(signal_recu, [], nbits)';
        resultat = (resultat(:,end)/Ns+1)/2>0.5;
        taux_erreur = sum(abs(resultat-bits))/nbits;
    elseif nb_chaine == 2
        resultat = reshape(signal_recu, [], nbits)';
        resultat = (resultat(:,floor(Ns/2)+1)/Ns+1)/2>0.5;
        taux_erreur = sum(abs(resultat-bits))/nbits;
    elseif nb_chaine == 3
        signal_echantillone = reshape(signal_recu, [Ns nbits/2])';
        signal_echantillone = signal_echantillone(:,end);

        resultat = zeros(1,nbits/2);

        decisions_10 = signal_echantillone >= (2*Ns);
        decisions_11 = signal_echantillone < (2*Ns) & signal_echantillone >= 0;
        decisions_01 = signal_echantillone < 0 & signal_echantillone >= (-2*Ns);
        decisions_00 = signal_echantillone < (-2*Ns);

        resultat(decisions_00) = 0;
        resultat(decisions_01) = 1;
        resultat(decisions_10) = 2;
        resultat(decisions_11) = 3;
        resultat = int2bit(resultat, 2);
        resultat = reshape(resultat, [nbits, 1]);

        taux_erreur = sum(abs(resultat-bits))/nbits;
    end
end

function [taux_erreur, signal_recu] = BdB(nb_chaine,nbits,Ns,SNR)
    bits = bits_aleatoire(nbits);
    [signal_mis_en_forme] = mise_en_forme(nb_chaine,bits,Ns);
    
        % figure;
        % plot(reshape(signal_mis_en_forme,Ns,length(signal_mis_en_forme)/Ns));
    
    [signal_propage] = propagation(nb_chaine,signal_mis_en_forme,Ns, SNR);
    [signal_recu] = reception(nb_chaine,signal_propage,Ns);
    [taux_erreur] = demapping(nb_chaine, signal_recu, nbits, bits, Ns);
end