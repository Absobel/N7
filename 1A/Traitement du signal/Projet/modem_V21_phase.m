clear all; close all; clc;

% PARAMÈTRES
Fe = 48000;          % Fréquence d'échantillonage
Rb = 300;            % Débit binaire
Nbits = 1000;        % Nombre de bits à transmettre
F0 = 1180;           % Fréquence des bits à 0 
F1 = 980;            % Fréquence des bits à 0 
SNR = 100;           % Rapport signal sur bruit en dB


Te = 1/Fe;
Ts = 1/Rb;
Ns = floor(Ts/Te);

bits = randi([0 1],1,Nbits);

% Codage source
NRZ = kron(bits,ones(1,Ns));
long = length(NRZ);
t = 0:Te:(long-1)*Te;

phi0 = rand*2*pi; phi1 = rand*2*pi;


x = (1-NRZ).*cos(2*pi*F0*t+phi0) + NRZ.*cos(2*pi*F1*t+phi1);

N = length(x);
Px = mean(abs(x).^2);
sigma = sqrt(Px/(10^(SNR/10)));
bruit = sigma*randn(1,N);
x_bruite = x + bruit;



theta0 = rand*2*pi; theta1 = rand*2*pi;


% TEST MODEM V21 AVEC CHANGEMENT DE PHASE

x_int0 = reshape(x_bruite.*cos(2*pi*F0*t+theta0),Ns,Nbits);
x_int00 = trapz(x_int0);

x_int1 = reshape(x_bruite.*cos(2*pi*F1*t+theta1),Ns,Nbits);
x_int11 = trapz(x_int1);

new_energie = x_int11 - x_int00;
bits_1_detectes = new_energie > 0;
difference = bits_1_detectes - bits;
taux_erreur = length(find(difference ~= 0))/Nbits;

% MODEM V21 PHASE

x_int0_0 = reshape(x_bruite.*cos(2*pi*F0*t+theta0),Ns,Nbits);
x_int00_0 = trapz(x_int0_0);
x_int00_1 = x_int00_0.^2;

x_int0_1 = reshape(x_bruite.*sin(2*pi*F0*t+theta0),Ns,Nbits);
x_int00_2 = trapz(x_int0_1);
x_int00_3 = x_int00_2.^2;

x_int1_0 = reshape(x_bruite.*cos(2*pi*F1*t+theta1),Ns,Nbits);
x_int11_0 = trapz(x_int1_0);
x_int11_1 = x_int11_0.^2;

x_int1_1 = reshape(x_bruite.*sin(2*pi*F1*t+theta1),Ns,Nbits);
x_int11_2 = trapz(x_int1_1);
x_int11_3 = x_int11_2.^2;

new_energie = (x_int11_1 + x_int11_3) - (x_int00_1 + x_int00_3);
bits_1_detectes = new_energie > 0;
difference = bits_1_detectes - bits;
taux_erreur = length(find(difference ~= 0))/Nbits








































