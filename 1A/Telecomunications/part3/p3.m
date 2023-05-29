clear all;
close all;
clc;

Fe = 24000;
Te = 1/Fe;
Rb = 6000;
Tb = 1/Rb;
N = 1;       % Nombre de bits par symbole
Ts = N*Tb;
Ns = floor(Ts/Te);

nbits = 10000;

% Generate random bits
bits = randi([0 1],1,nbits);

mapping = 2*bits-1;
x = kron(mapping, [1 zeros(1,Ns-1)]);
h = ones(1,Ns);
x_filtre = filter(h,1,x);




%%%%%%%%% AVEC BRUIT - AVEC PHASE - CORRECTION %%%%%%%
phase = [0, 40, 100]*pi/180;
Px = mean(abs(x_filtre).^2);

Eb_N0_db = 0:6;
Eb_N0 = 10.^(Eb_N0_db/10);
TEB_phase_bruit = zeros(lenght(phase), lenght(Eb_N0));

for j = 1:length(Eb_N0)
    sigma = (Px*Ns)./(2*Eb_N0(j));
    bruit = (sqrt(sigma) + i*sqrt(sigma))*randn(1,length(x_filtre));
    signal_bruite = x_filtre + bruit;
    signal_dephase = signal_bruite.*exp(i*phase);
    z = zeros(lenght(phase), lenght(x_filtre));
    for k = 1:lenght(phase)
        z(k,:) = filter(h,1,signal_dephase(k,:));
    end
    n0 = Ns;
    signal_echantillone = z';
    signal_echantillone = signal_echantillone(n0:Ns:end);
    signal_echantillone = reshape(signal_echantillone, lenght(phase)/lenght(phase), lenght(phase))';

    phase_estime = 