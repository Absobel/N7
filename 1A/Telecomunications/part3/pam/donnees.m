Fe = 24000;                     % Fréquence d'échantillonnage
Te = 1/Fe;                      % Période d'échantiollonnage
Rb = 6000;                      % Débit binaire
Tb = 1/Rb;                      % Période binaire
N=1;                            % Nombre de bits par symbole   
Ts = N*Tb;                      % Période symbole
Rs = 1/Ts;                      % Débit symbole
Ns = floor(Ts/Te);              % Nombre de bits par symbole
nbits = 10000;                     % Nombre de bits total
t = 0:Te:Te*(Ns*nbits/N - 1);   % axe temporelle
M = 2^N;

h = ones(1,Ns);                 % filtre de mise en forme
hr = h;                         % filtre de réception

% Bits generes
bits = randi([0 1],1,nbits);

