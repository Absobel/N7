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

mapping = 2*bits - 1;
x = kron(mapping, [1 zeros(1,Ns-1)]);

h = ones(1,Ns);
x_filtre = filter(h,1,x);




%%%%%%%%% SANS BRUIT - SANS PHASE %%%%%%%%%


hr = ones(1,Ns);
z1 = filter(hr,1,x);

% Signal échantilloné
n0 = Ns;
signal_echantillone = z1(n0:Ns:end);

figure();
plot(signal_echantillone);
title('Signal échantilloné sans bruit ni phase');
xlabel('m');
ylabel('Amplitude');

% Démodulation
bits_recup = signal_echantillone > 0;
TEB1 = length(find(bits_recup ~= bits))/nbits



%%%%%%%%% SANS BRUIT - AVEC PHASE %%%%%%%%%

phase = [40, 100, 180]*pi/180;
signal_dephase = exp(1i*phase)'*x_filtre;
z2 = zeros(length(phase), length(signal_dephase));
for i = 1:length(phase)
    z2(i,:) = filter(hr,1,signal_dephase(i,:));
end

% Signal échantilloné
n0 = Ns;
signal_echantillone = z2';
signal_echantillone = signal_echantillone(n0:Ns:end);
signal_echantillone = reshape(signal_echantillone, length(signal_echantillone)/length(phase), length(phase))';

figure();
tiledlayout('flow');
for i = 1:length(phase)
    nexttile;
    plot(signal_echantillone(i,:));
    title(['Signal échantilloné sans bruit avec phase = ' num2str(phase(i)*180/pi) '°']);
    xlabel('m');
    ylabel('Amplitude');
end


% démodulation
bits_recup = real(signal_echantillone) > 0;
TEB2 = sum((bits_recup - repmat(bits, length(phase), 1)) ~= 0, 2)/nbits



%%%%%%%%% AVEC BRUIT - AVEC PHASE %%%%%%%%%

phase = [0, 40, 100]*pi/180;
Px = mean(abs(x_filtre).^2);
Eb_N0_db = 0:6;
Eb_N0 = 10.^(Eb_N0_db/10);

TEB3 = zeros(length(phase), length(Eb_N0));

for j = 1:length(Eb_N0)
    % bruit
    sigma = (Px*Ns)/(2*N*Eb_N0(j));
    bruit = (sqrt(sigma) + i*sqrt(sigma))*randn(1,length(x_filtre));

    signal_bruite = x_filtre + bruit;
    signal_dephase = exp(1i*phase)'*signal_bruite;
    z3 = zeros(length(phase), length(signal_dephase));
    for i = 1:length(phase)
        z3(i,:) = filter(hr,1,signal_dephase(i,:));
    end

    % Signal échantilloné
    n0 = Ns;
    signal_echantillone = z3';
    signal_echantillone = signal_echantillone(n0:Ns:end);
    signal_echantillone = reshape(signal_echantillone, length(signal_echantillone)/length(phase), length(phase))';

    % démodulation
    bits_recup = real(signal_echantillone) > 0;
    TEB3(:,j) = sum(bits_recup - repmat(bits, length(phase), 1) ~= 0, 2)/nbits
end

TEH3_th = zeros(length(phase), length(Eb_N0));
for j = 1:length(phase)
    TEB3_th(j,:) = qfunc(real(exp(1i*phase(j))*sqrt(2*Eb_N0)));
end

% plots
figure();
plot(Eb_N0_db, TEB3(2,:)); hold on; % 40°
plot(Eb_N0_db, TEB3_th(2,:)); hold off;
title('TEB théorique et simulée en fonction de Eb/N0 pour 40°');
xlabel('Eb/N0 (dB)');
ylabel('TEB');
legend('Simulé', 'Théorique');

figure();
plot(Eb_N0_db, TEB3(2,:)); hold on; % 40°
plot(Eb_N0_db, TEB3(1,:)); hold off; % 0°
title('TEB en fonction de Eb/N0 pour 0° et 40°');
xlabel('Eb/N0 (dB)');
ylabel('TEB');
legend('40°', '0°');

figure();
plot(Eb_N0_db, TEB3(2,:)); hold on; % 40°
plot(Eb_N0_db, TEB3(3,:)); hold off; % 100°
title('TEB en fonction de Eb/N0 pour 40° et 100°');
xlabel('Eb/N0 (dB)');
ylabel('TEB');
legend('40°', '100°');