clear all; close all; clc;

Fe = 24000; Te = 1/Fe;
Rb = 3000; Tb = 1/Rb;
nbits = 1000;

function [Ns] = nb_symbole(nb_chaine,Tb,Te)
    if nb_chaine == 1 || nb_chaine == 2
        n = 1
    elseif nb_chaine == 3
        n = 2
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
    elseif nb_chaine == 3
        a_kron = zeros(1,length(bits)/2);
        for i = 1:2:length(bits)
            if bits(i) == 0 && bits(i+1) == 0
                a_kron((i+1)/2) = 1;
            elseif bits(i) == 0 && bits(i+1) == 1
                a_kron((i+1)/2) = 1i;
            elseif bits(i) == 1 && bits(i+1) == 0
                a_kron((i+1)/2) = -1;
            elseif bits(i) == 1 && bits(i+1) == 1
                a_kron((i+1)/2) = -1i;
            end
        end
    end
    signal_mappe = kron(a_kron,ones(1,Ns-1));
end

function [signa_mis_en_forme] = mise_en_forme(signal_mappe,Ns)
    h = ones(1,Ns);
    signa_mis_en_forme = conv(signal_mappe,h);
end

function [signal_propage] = propagation(signa_mis_en_forme,Ns,M)
    Px = mean(abs(signa_mis_en_forme).^2);
    sigman = sqrt(Px*Ns/(2*log2(M)*Eb/N0))
    bruit = sigman*randn(1,length(signa_mis_en_forme));
end

function [signal_recu] = reception(nb_chaine,signal_propage,Ns)
    if nb_chaine == 1 || nb_chaine == 3
        hr = ones(1,Ns);
    elseif nb_chaine == 2
        hr = ones(1,Ns/2);
    end
    signal_recu = conv(signal_propage,hr);
end

function [signal_echantillion] = echantillonage(signal_recu,Ns)
    
end