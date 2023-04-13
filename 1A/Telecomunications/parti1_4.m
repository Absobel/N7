clear all; close all; clc;

Fe = 24000; Te = 1/Fe;
Rb = 3000; Tb = 1/Rb;
nbits = 100000;

SNR_dB = 0:8;
SNR = 10.^(SNR_dB/10);

tableaux_TEB1_pra = zeros(9,1);
tableaux_TEB1_the = zeros(9,1) ;
for i = 1:length(SNR)
    Ns = nb_symbole(1, Tb, Te);
    [tableaux_TEB1_pra(i)] = BdB(1,nbits,Ns,SNR(i));
    tableaux_TEB1_the(i) = qfunc(sqrt(2*SNR(i)));
end

figure;
semilogy(SNR_dB,tableaux_TEB1_pra,'b', 'LineWidth', 2); hold on;
semilogy(SNR_dB,tableaux_TEB1_the, 'r', 'LineWidth', 2); hold off;
title("Comparaison TEB pratique/théorique pour différentes bandes passantes (chaine 1)")
xlabel("log10(BandePassante)")
ylabel("TEB")
legend("pratique", "theorique")

tableaux_TEB2_pra = zeros(9,1);
tableaux_TEB2_the = zeros(9,1);
for i = 1:length(SNR)
    Ns = nb_symbole(2, Tb, Te);
    [tableaux_TEB2_pra(i)] = BdB(2,nbits,Ns,SNR(i));
    tableaux_TEB2_the(i) = qfunc(sqrt(SNR(i)));

end 

figure;
semilogy(SNR_dB,tableaux_TEB2_pra,'b', 'LineWidth', 2); hold on;
semilogy(SNR_dB,tableaux_TEB2_the, 'r', 'LineWidth', 2); hold off;
title("Comparaison TEB pratique/théorique pour différentes bandes passantes (chaine 2)")
xlabel("log10(BandePassante)")
ylabel("TEB")
legend("pratique", "theorique")

tableaux_TEB3_pra = zeros(9,1);
tableaux_TEB3_the = zeros(9,1) ;
for i = 1:length(SNR)
    Ns = nb_symbole(3, Tb, Te);
    [tableaux_TEB3_pra(i)] = BdB(3,nbits,Ns,SNR(i));
    tableaux_TEB3_the(i) = (3/4)*qfunc(sqrt(0.8*SNR(i)));
end 

figure;
semilogy(SNR_dB,tableaux_TEB3_pra,'b', 'LineWidth', 2); hold on;
semilogy(SNR_dB,tableaux_TEB3_the, 'r', 'LineWidth', 2); hold off;
title("Comparaison TEB pratique/théorique pour différentes bandes passantes (chaine 3)")
xlabel("log10(BandePassante)")
ylabel("TEB")
legend("pratique", "theorique")

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

function [signa_mis_en_forme,h] = mise_en_forme(nb_chaine, bits, Ns)
    mappage = zeros(Ns, 1);  % Permet de créer des impulsions de durée Ns
    mappage(1) = 1;
    if nb_chaine == 1 || nb_chaine == 2
        signal_mappe = kron(2*bits-1, mappage);
        h = ones(1,Ns);
    elseif nb_chaine == 3
        signal_mappe = kron(([1 -2]*reshape((2*bits-1),2,length(bits)/2))',mappage);
        h = ones(1,Ns/2);
    end
    signa_mis_en_forme = filter(h,1,signal_mappe);
end

function [signal_propage] = propagation(signa_mis_en_forme,Ns,SNR)
    Px = mean(abs(signa_mis_en_forme).^2);
    sigman = sqrt(Px*Ns/(2*SNR));
    bruit = sigman*randn(1,length(signa_mis_en_forme));
    signal_propage = signa_mis_en_forme' + bruit;
    %signal_propage = signa_mis_en_forme';
end

function [signal_recu] = reception(nb_chaine,signal_propage,Ns)
    if nb_chaine == 1 || nb_chaine == 3
        hr = ones(1,Ns);
    elseif nb_chaine == 2
        hr = [ones(1, (floor(Ns/2))),zeros(1, (floor(Ns/2)))];
    end
    signal_recu = filter(hr,1,signal_propage);
end

function [taux_erreur] = demapping(nb_chaine, signal_recu, nbits, bits,Ns,h)
    if nb_chaine == 1
        resultat = reshape(signal_recu, [], nbits)';
        resultat = (resultat(:,end)/Ns+1)/2>0.5;
        taux_erreur = sum(abs(resultat-bits))/nbits;
    elseif nb_chaine == 2
        resultat = reshape(signal_recu, [], nbits)';
        resultat = (resultat(:,floor(Ns/2)+1)/Ns+1)/2>0.5;
        taux_erreur = sum(abs(resultat-bits))/nbits;
    elseif nb_chaine == 3
        resultat = zeros(1,nbits);
        for i = 1:(nbits/2)
            resultat(i) = signal_recu(i * Ns);
        end
        resultat = resultat';

        gt0 = sum(abs(h).^2);
        symboles = [-1 3 -3 1];

        distances = zeros(length(resultat), length(symboles));
        for i = 1:length(symboles)
            distances(:, i) = abs(resultat - symboles(i) * gt0);
        end
        
        [~, min_indices] = min(distances, [], 2);
        
        decoded_bits = dec2bin(min_indices-1, 2) - '0';
        decoded_bits = decoded_bits(:)';

        taux_erreur = length(find(bits~=resultat))/nbits;
    end
end

function [taux_erreur] = BdB(nb_chaine,nbits,Ns,SNR)
    bits = bits_aleatoire(nbits);
    [signal_mis_en_forme,h] = mise_en_forme(nb_chaine,bits,Ns);
    
        % figure;
        % plot(reshape(signal_mis_en_forme,Ns,length(signal_mis_en_forme)/Ns));
    
    [signal_propage] = propagation(signal_mis_en_forme,Ns,SNR);
    [signal_recu] = reception(nb_chaine,signal_propage,Ns);
    [taux_erreur] = demapping(nb_chaine, signal_recu, nbits, bits, Ns,h);
end