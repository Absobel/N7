clear all; close all; clc;

% 3.1
Fe = 48000;
Te = 1/Fe;
Rb = 300;
Ts = 1/Rb;
Ns = floor(Ts/Te);
Nbits = 1000;

bits = randi([0 1],1,Nbits);

% Codage source
NRZ = kron(bits,ones(1,Ns));
long = length(NRZ);
t = 0:Te:(long-1)*Te;
    figure(1)
    tiledlayout("flow");
    ax1 = nexttile;
    plot(t,NRZ);
    axis([0 1 -0.2 1.2]);
    title("Signal NRZ");
    xlabel("Temps (s)"); ylabel("Amplitude");

dsp_NRZ = pwelch(NRZ,[],[],[],Fe,"two-sided");
f = linspace(-Fe/2,Fe/2,length(dsp_NRZ));
dsp_NRZ_th = 1/4*Ts*sinc(f*Ts).^2+1/4*dirac(f);
    ax2 = nexttile;
    semilogy(f,fftshift(dsp_NRZ)); hold on;
    semilogy(f,dsp_NRZ_th); hold off;
    legend(ax2, {"DSP du signal NRZ","DSP théorique"})
    title("DSP du signal NRZ");
    xlabel("Fréquence (Hz)"); ylabel("DSP");

% 3.2

F0 = 6000; F1 = 2000;
phi0 = rand*2*pi; phi1 = rand*2*pi;
x = (1-NRZ).*cos(2*pi*F0*t+phi0) + NRZ.*cos(2*pi*F1*t+phi1);
    figure(2);
    tiledlayout("flow");
    ax1 = nexttile;
    plot(t,x);
    axis([0 0.1 -1.2 1.2]);
    title("Signal modulé");
    xlabel("Temps (s)"); ylabel("Amplitude");

dsp_x = pwelch(x,[],[],[],Fe,"two-sided");
f = linspace(-Fe/2,Fe/2,length(dsp_x));
% dsp_x_th = ...
    ax2 = nexttile;
    semilogy(f,fftshift(dsp_x)); hold on;
    semilogy(f,dsp_x_th); hold off;
    legend(ax2, {"DSP du signal modulé","DSP théorique"})
    title("DSP du signal modulé");
    xlabel("Fréquence (Hz)"); ylabel("DSP");