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
    % figure(1)
    % tiledlayout("flow");
    % ax1 = nexttile;
    % plot(t,NRZ);
    % axis([0 1 -0.2 1.2]);
    % title("Signal NRZ");
    % xlabel("Temps (s)"); ylabel("Amplitude");

dsp_NRZ = pwelch(NRZ,[],[],[],Fe,"two-sided");
f = linspace(-Fe/2,Fe/2,length(dsp_NRZ));
dsp_NRZ_th = 1/4*Ts*sinc(f*Ts).^2+1/4*dirac(f);
    % ax2 = nexttile;
    % semilogy(f,fftshift(dsp_NRZ)); hold on;
    % semilogy(f,dsp_NRZ_th); hold off;
    % legend(ax2, {"DSP du signal NRZ","DSP théorique"})
    % title("DSP du signal NRZ");
    % xlabel("Fréquence (Hz)"); ylabel("DSP");

% 3.2 : SIGNAL MODULÉ

F0 = 6000; F1 = 2000; FC = (F0+F1)/2;
phi0 = rand*2*pi; phi1 = rand*2*pi;
x = (1-NRZ).*cos(2*pi*F0*t+phi0) + NRZ.*cos(2*pi*F1*t+phi1);
    % figure(2);
    % tiledlayout("flow");
    % ax1 = nexttile;
    % plot(t,x);
    % axis([0 0.1 -1.2 1.2]);
    % title("Signal modulé");
    % xlabel("Temps (s)"); ylabel("Amplitude");

dsp_x = pwelch(x,[],[],[],Fe,"two-sided");
f = linspace(-Fe/2,Fe/2,length(dsp_x));
    % ax2 = nexttile;
    % semilogy(f,fftshift(dsp_x));
    % title("DSP du signal modulé");
    % xlabel("Fréquence (Hz)"); ylabel("DSP");

% 4 : BRUITAGE

N = length(x);
SNR = 5;
Px = mean(abs(x).^2);
sigma = sqrt(Px/(10^(SNR/10)));
bruit = sigma*randn(1,N);
x_bruite = x + bruit;
%     figure(3);
%     tiledlayout("flow");
%     ax1 = nexttile;
%     plot(t,x_bruite);
%     axis([0 0.1 -1.2 1.2]);
%     title("Signal bruité");
%     xlabel("Temps (s)"); ylabel("Amplitude");

% 5 : FILTRE

ordre = 61;
k = -(ordre-1)/2:(ordre-1)/2;
h_passe_bas = 2*FC/Fe.*sinc(2*FC/Fe.*k);
h_passe_haut = -h_passe_bas;
h_passe_haut((ordre-1)/2+1) = 1 - 2*FC/Fe;
    figure(4);
    tiledlayout("flow");
    ax1 = nexttile;
    plot(h_passe_bas);
    title("Réponse impulsionnelle du filtre passe bas");
    xlabel("Points"); ylabel("Amplitude");
    ax2 = nexttile;
    plot(h_passe_haut);
    title("Réponse impulsionnelle du filtre passe haut");
    xlabel("Points"); ylabel("Amplitude");

    figure(5);
    tiledlayout("flow");
    ax1 = nexttile;
    H = fft(h_passe_bas, length(dsp_x));
    semilogy(f,fftshift(abs(H)));
    title("Réponse fréquentielle du filtre passe bas");
    xlabel("Fréquence"); ylabel("Amplitude");
    ax2 = nexttile;
    H = fft(h_passe_haut, length(dsp_x));
    semilogy(f,fftshift(abs(H)));
    title("Réponse fréquentielle du filtre passe haut");
    xlabel("Fréquence"); ylabel("Amplitude");

x_bruite_filtre_pb = filter(h_passe_bas,1,x_bruite);
x_bruite_filtre_ph = filter(h_passe_haut,1,x_bruite);