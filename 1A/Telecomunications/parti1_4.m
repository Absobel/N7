clear all; close all; clc;

Fe = 24000; Te = 1/Fe;
Rb = 3000; Tb = 1/Rb;
nbits = 1000;

Ns = nb_symbole(3,Tb,Te);
log10bwmax = 8;
range = linspace(0,log10bwmax);

tableaux_TEB1_pra = zeros(9,1);
tableaux_TEB1_the = zeros(9,1) ;
for i = 1:length(range)
      [tableaux_TEB1_pra(i),gt01,sigman1] = BdB(1,nbits,Ns,10.^range(i));
      tableaux_TEB1_the(i) = qfunc(gt01/sigman1);
end

figure;
semilogy(range,tableaux_TEB1_pra,'b', 'LineWidth', 2); hold on;
semilogy(range,tableaux_TEB1_the, 'r', 'LineWidth', 2); hold off;
title("Comparaison TEB pratique/théorique pour différentes bandes passantes (chaine 1)")
xlabel("log10(BandePassante)")
ylabel("TEB")
legend("pratique", "theorique")

tableaux_TEB2_pra = zeros(9,1);
tableaux_TEB2_the = zeros(9,1) ;
for i = 1:length(range)
      [tableaux_TEB2_pra(i),gt02,sigman2] = BdB(2,nbits,Ns,10.^range(i));
      tableaux_TEB2_the(i) = qfunc(gt02/sigman2);

end 

figure;
semilogy(range,tableaux_TEB2_pra,'b', 'LineWidth', 2); hold on;
semilogy(range,tableaux_TEB2_the, 'r', 'LineWidth', 2); hold off;
title("Comparaison TEB pratique/théorique pour différentes bandes passantes (chaine 2)")
xlabel("log10(BandePassante)")
ylabel("TEB")
legend("pratique", "theorique")

tableaux_TEB3_pra = zeros(9,1);
tableaux_TEB3_the = zeros(9,1) ;
for i = 1:length(range)
      [tableaux_TEB3_pra(i),gt03,sigman3] = BdB(3,nbits,Ns,10.^range(i));
      tableaux_TEB3_the(i) = (3/2)*qfunc(gt03/sigman3);
end 

figure;
semilogy(range,tableaux_TEB3_pra,'b', 'LineWidth', 2); hold on;
semilogy(range,tableaux_TEB3_the, 'r', 'LineWidth', 2); hold off;
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
    bits = randi([0 1],1,nbits);
end

function [signal_mappe] = mapping(nb_chaine,bits,Ns)
    if nb_chaine == 1 || nb_chaine == 2
        a_kron = 2*bits-1;
        signal_mappe = kron(a_kron,ones(1,Ns));
    elseif nb_chaine == 3
        mapping = [-3, -1, 3, 1];
        a_kron = reshape(bits, 2, []);
        a_kron = mapping(bi2de(a_kron', 'left-msb')+1);
        signal_mappe = kron(a_kron,ones(1,Ns));
    end
end

function [signa_mis_en_forme,h] = mise_en_forme(signal_mappe,Ns)
    h = ones(1,Ns);
    signa_mis_en_forme = filter(h, 1, signal_mappe);
end

function [signal_propage,sigman] = propagation(nb_chaine,signa_mis_en_forme,Ns,Eb_N0)
    if nb_chaine == 1 || nb_chaine == 2
        M = 2;
    else
        M = 4;
    end
    Px = mean(abs(signa_mis_en_forme).^2);
    sigman = sqrt(Px*Ns/(2*log2(M)*Eb_N0));
    bruit = sigman*randn(1,length(signa_mis_en_forme));
    signal_propage = signa_mis_en_forme + bruit;
end

function [signal_recu,hr] = reception(nb_chaine,signal_propage,Ns)
    if nb_chaine == 1 || nb_chaine == 3
        hr = ones(1,Ns);
    elseif nb_chaine == 2
        hr = ones(1,Ns/2);
    end
    signal_recu = filter(hr,1,signal_propage);
end

function [signal_echantillion] = echantillonage(signal_recu,Ns)
    signal_echantillion = zeros(1,length(signal_recu));
    for i = Ns:Ns:length(signal_recu)
        signal_echantillion(i:(i+Ns-1)) = signal_recu(i);
    end
end

function [taux_erreur] = demapping(nb_chaine,signal_echantillion, bits, Ns)
    if nb_chaine == 1 || nb_chaine == 2
        decisions = signal_echantillion(Ns:Ns:end)>0;
    elseif nb_chaine == 3
        pre_decisions = signal_echantillion(Ns:Ns:end);
        decisions = zeros(1,length(bits));
        for i = 1:length(pre_decisions)
            nb = pre_decisions(i);
            if nb <= -256
                decisions(2*i) = 0;
                decisions(2*i+1) = 0;
            elseif nb <= 0
                decisions (2*i) = 0;
                decisions(2*i+1) = 1;
            elseif nb >= 256
                decisions(2*i) = 1;
                decisions(2*i+1) = 0;
            else
                decisions(2*i) = 1;
                decisions(2*i+1) = 1;
            end
        end
        decisions = decisions(2:end);
    end
    taux_erreur = sum(decisions~=bits)/length(bits);
end

function [g] = filtre_total(h,hr)
    g = conv(h,hr);
end

function [taux_erreur,gt0,sigman ] = BdB(nb_chaine,nbits,Ns,Eb_N0)
    bits = bits_aleatoire(nbits);
    signal_mappe = mapping(nb_chaine,bits,Ns);
    [signal_mis_en_forme,h] = mise_en_forme(signal_mappe,Ns);
    [signal_propage,sigman] = propagation(nb_chaine,signal_mis_en_forme,Ns,Eb_N0);
    [signal_recu,hr] = reception(nb_chaine,signal_propage,Ns);
    g = filtre_total(h,hr);
    signal_echantillion = echantillonage(signal_recu,Ns);
    gt0 = g(Ns);
    taux_erreur = demapping(nb_chaine,signal_echantillion, bits, Ns);
end


