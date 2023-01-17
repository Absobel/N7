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

%F0 = 6000; F1 = 2000;
F0 = 1180; F1 = 980; %5.6.2
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
%SNR = 5;
SNR = 100; %5.6.2
Px = mean(abs(x).^2);
sigma = sqrt(Px/(10^(SNR/10)));
bruit = sigma*randn(1,N);
x_bruite = x + bruit;
    % figure(3);
    % tiledlayout("flow");
    % ax1 = nexttile;
    % plot(t,x_bruite);
    % axis([0 0.1 -1.2 1.2]);
    % title("Signal bruité");
    % xlabel("Temps (s)"); ylabel("Amplitude");

% 5 : FILTRE

FC = (F0+F1)/2;
ordre = 61;    % Avant 5.6.1
%ordre = 201;
k = -(ordre-1)/2:(ordre-1)/2;
h_passe_bas = 2*FC/Fe*sinc(2*FC/Fe.*k);
h_passe_haut = -h_passe_bas;
h_passe_haut((ordre-1)/2+1) = 1 - 2*FC/Fe;

    %5.4.1

    % figure(4);
    % tiledlayout("flow");
    % ax1 = nexttile;
    % plot(h_passe_bas);
    % title("Réponse impulsionnelle du filtre passe bas");
    % xlabel("Points"); ylabel("Amplitude");
    % ax2 = nexttile;
Hpb = fft(h_passe_bas, length(dsp_x));
    % semilogy(f,fftshift(abs(Hpb)));
    % title("Réponse fréquentielle du filtre passe bas");
    % xlabel("Fréquence"); ylabel("Amplitude");

    % figure(5);
    % tiledlayout("flow");
    % ax1 = nexttile;
    % plot(h_passe_haut);
    % title("Réponse impulsionnelle du filtre passe haut");
    % xlabel("Points"); ylabel("Amplitude");
    % ax2 = nexttile;
Hph = fft(h_passe_haut, length(dsp_x));
    % semilogy(f,fftshift(abs(Hph)));
    % title("Réponse fréquentielle du filtre passe haut");
    % xlabel("Fréquence"); ylabel("Amplitude");

dsp_x_bruite = pwelch(x_bruite,[],[],[],Fe,"two-sided");
x_bruite_filtre_pb = filter(h_passe_bas,1,x_bruite);
x_bruite_filtre_ph = filter(h_passe_haut,1,x_bruite);
dsp_x_bruite_filtre_pb = pwelch(x_bruite_filtre_pb,[],[],[],Fe,"two-sided");
dsp_x_bruite_filtre_ph = pwelch(x_bruite_filtre_ph,[],[],[],Fe,"two-sided");

    % %5.4.2
    % figure(6);
    % tiledlayout("flow");
    % ax1 = nexttile;
    % semilogy(f,fftshift(abs(dsp_x_bruite))); hold on;
    % semilogy(f,fftshift(1/ordre*abs(Hpb.^2))); hold off;
    % title("DSP du signal bruité et DSP du filtre passe bas");
    % xlabel("Fréquence (Hz)"); ylabel("Amplitude");
    % legend(ax1, {"DSP du signal bruité","DSP du filtre passe bas"})
    % ax2 = nexttile;
    % semilogy(f,fftshift(abs(dsp_x_bruite))); hold on;
    % semilogy(f,fftshift(1/ordre*abs(Hph.^2))); hold off;
    % title("DSP du signal bruité et DSP du filtre passe haut");
    % xlabel("Fréquence (Hz)"); ylabel("Amplitude");
    % legend(ax2, {"DSP du signal bruité","DSP du filtre passe haut"})



    % %5.4.3
    % figure(8);
    % tiledlayout("flow");
    % ax1 = nexttile;
    % plot(t,x_bruite_filtre_ph);
    % axis([0 0.1 -1.2 1.2]);
    % title("Signal bruité et filtré passe haut");
    % xlabel("Temps (s)"); ylabel("Amplitude");
    % ax2 = nexttile;
    % semilogy(f,fftshift(dsp_x_bruite_filtre_ph));
    % title("DSP du signal bruité et filtré passe haut");
    % xlabel("Fréquence (Hz)"); ylabel("DSP");

    % figure(9);
    % tiledlayout("flow");
    % ax1 = nexttile;
    % plot(t,x_bruite_filtre_pb);
    % axis([0 0.1 -1.2 1.2]);
    % title("Signal bruité et filtré passe bas");
    % xlabel("Temps (s)"); ylabel("Amplitude");
    % ax2 = nexttile;
    % semilogy(f,fftshift(dsp_x_bruite_filtre_pb));
    % title("DSP du signal bruité et filtré passe bas");
    % xlabel("Fréquence (Hz)"); ylabel("DSP");

%5.5 Detection d'energie

x_bruite_filtre_pb_reshape = reshape(x_bruite_filtre_pb,Ns,Nbits);
energie = sum(x_bruite_filtre_pb_reshape.^2);
K = (max(energie)+min(energie))/2;    %Detrminer experimentalement

bits_1_detectes = energie > K;
difference = bits_1_detectes - bits;
taux_erreur = length(find(difference ~= 0))/Nbits;


% 5.6
% En changeant l'ordre a 201 : erreur 0.3950 au lieu de 0.qqch

% Gestion retard
x_bruite_filtre_nonretard = filter(h_passe_bas, 1, [x_bruite zeros(1, (ordre -1)/2)]);
x_bruite_filtre_nonretard_fixe = x_bruite_filtre_nonretard(1,(ordre-1)/2+1:end);
x_bruite_filtre_nonretard_fixe_reshape = reshape(x_bruite_filtre_nonretard_fixe,Ns,Nbits);

energie = sum(x_bruite_filtre_nonretard_fixe_reshape.^2);
K = (max(energie)+min(energie))/2;

bits_1_detectes = energie > K;
difference = bits_1_detectes - bits;
taux_erreur = length(find(difference ~= 0))/Nbits;