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

phi0 = rand*2*pi; phi1 = rand*2*pi;

F0 = 1180; F1 = 980;
x = (1-NRZ).*cos(2*pi*F0*t+phi0) + NRZ.*cos(2*pi*F1*t+phi1);

N = length(x);
%SNR = 5;
SNR = 100; %5.6.2
Px = mean(abs(x).^2);
sigma = sqrt(Px/(10^(SNR/10)));
bruit = sigma*randn(1,N);
x_bruite = x + bruit;



% 6 Demodulateur adapté norme V21

% 6.1.1

func = @(t,Fa,Fb,phia,phib) cos(2*pi*Fa.*t+phia).*cos(2*pi*Fb.*t+phib);
func1 = @(t) func(t,F0,F0,phi0,phi0);
func2 = @(t) func(t,F1,F1,phi1,phi1);
func3 = @(t) func(t,F1,F0,phi1,phi0);
integral(func1,0,Ts); % 0.0017
integral(func2,0,Ts); % 0.0016            % Les écrire à la main sur le rapport
integral(func3,0,Ts); % 9.1890e-05

% 6.1.2

% le signal juste avant le bloc H0 >< H1 0 sur figure 5 est NRZ -Ts/2 Ts/2, equivalent à energie dans partie d'avant

x_int0 = reshape(x_bruite.*cos(2*pi*F0*t+phi0),Ns,Nbits);
x_int00 = trapz(x_int0);

x_int1 = reshape(x_bruite.*cos(2*pi*F1*t+phi1),Ns,Nbits);
x_int11 = trapz(x_int1);

new_energie = x_int11 - x_int00;
bits_1_detectes = new_energie > 0;
difference = bits_1_detectes - bits;
taux_erreur = length(find(difference ~= 0))/Nbits