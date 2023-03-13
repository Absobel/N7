clear all; close all; clc;

Fe = 24000; Te = 1/Fe;
Rb = 3000; Tb = 1/Rb;
nbits = 1000;

Ns = nb_symbole(3,Tb,Te)
taux_erreur = BdB(3,nbits,Ns,12)

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
        a_kron = zeros(1,length(bits)/2);
        for i = 1:2:length(bits)
            if bits(i) == 0 && bits(i+1) == 0
                a_kron((i+1)/2) = -2;
            elseif bits(i) == 0 && bits(i+1) == 1
                a_kron((i+1)/2) = -1;
            elseif bits(i) == 1 && bits(i+1) == 0
                a_kron((i+1)/2) = 2;
            elseif bits(i) == 1 && bits(i+1) == 1
                a_kron((i+1)/2) = 1;
            end
        end
        signal_mappe = kron(a_kron,ones(1,Ns));
    end
    size(a_kron)
    
    size(signal_mappe)
end

function [signa_mis_en_forme,h] = mise_en_forme(signal_mappe,Ns)
    h = ones(1,Ns);
    signa_mis_en_forme = filter(h, 1, signal_mappe);
    size(signa_mis_en_forme)
end

function [signal_propage] = propagation(nb_chaine,signa_mis_en_forme,Ns,Eb_N0)
    if nb_chaine == 1 || nb_chaine == 2
        M = 2;
    else
        M = 4;
    end
    Px = mean(abs(signa_mis_en_forme).^2);
    sigman = sqrt(Px*Ns/(2*log2(M)*Eb_N0));
    bruit = sigman*randn(1,length(signa_mis_en_forme));
    signal_propage = signa_mis_en_forme + bruit;
    size(signal_propage)
end

function [signal_recu,hr] = reception(nb_chaine,signal_propage,Ns)
    if nb_chaine == 1 || nb_chaine == 3
        hr = ones(1,Ns);
    elseif nb_chaine == 2
        hr = ones(1,Ns/2);
    end
    signal_recu = filter(hr,1,signal_propage);
    size(signal_recu)
end

function [signal_echantillion] = echantillonage(signal_recu,Ns)
    signal_echantillion = zeros(1,length(signal_recu));
    for i = Ns:Ns:length(signal_recu)
        signal_echantillion(i:(i+Ns-1)) = signal_recu(i);
    end
end

function [taux_erreur] = demapping(nb_chaine,signal_echantillion, bits, Ns)
    size(signal_echantillion)

    if nb_chaine == 1 || nb_chaine == 2
        decisions = signal_echantillion(Ns:Ns:end)>0;
    elseif nb_chaine == 3
        decisions = signal_echantillion(Ns:Ns/2:end)>0;
    end
    size(decisions)
    size(bits)
    taux_erreur = sum(decisions~=bits)/length(bits);
end

function [g] = filtre_total(h,hr)
    g = conv(h,hr);
end

function [taux_erreur] = BdB(nb_chaine,nbits,Ns,Eb_N0)
    bits = bits_aleatoire(nbits);
    signal_mappe = mapping(nb_chaine,bits,Ns);
    [signal_mis_en_forme,h] = mise_en_forme(signal_mappe,Ns);
    signal_propage = propagation(nb_chaine,signal_mis_en_forme,Ns,Eb_N0);
    [signal_recu,hr] = reception(nb_chaine,signal_propage,Ns);
    signal_echantillion = echantillonage(signal_recu,Ns);
    len_g = length(filtre_total(h,hr));
    taux_erreur = demapping(nb_chaine,signal_echantillion, bits, Ns);
end