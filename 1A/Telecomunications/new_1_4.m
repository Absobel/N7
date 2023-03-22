clear all; close all; clc;

Fe = 24000;
Te = 1/Fe;
Rb = 3000;
Tb = 1/Rb;
Ts = Tb;
Ns = floor(Tb/Te);
nbits = 1000;

% Générer des bits aléatoires
bits = randi([0 1], 1, nbits);

% Chaines de transmission
% Chaine 1
[x1, h1, g1] = chaine_transmission(bits, Ns, 1);
% Chaine 2
[x2, h2, g2] = chaine_transmission(bits, Ns, 2);
% Chaine 3
[x3, h3, g3] = chaine_transmission(bits, Ns, 3);

% Ajout de bruit
EbN0 = 0:8;
TEB = zeros(3, length(EbN0));

for idx = 1:length(EbN0)
    % Ajout du bruit
    z1 = ajouter_bruit(x1, EbN0(idx), Ns, 2);
    z2 = ajouter_bruit(x2, EbN0(idx), Ns, 2);
    z3 = ajouter_bruit(x3, EbN0(idx), Ns, 4);

    % Obtenir les décisions
    decisions1 = obtenir_decisions(z1, Ns, g1);
    decisions2 = obtenir_decisions(z2, Ns, g2);
    decisions3 = obtenir_decisions(z3, Ns, g3);

    % Calculer le TEB
    TEB(1, idx) = sum(decisions1 ~= bits) / length(bits);
    TEB(2, idx) = sum(decisions2 ~= bits) / length(bits);
    TEB(3, idx) = sum(decisions3 ~= qamdemod(2*bits-1, 4)) / length(bits);
end

% Tracer les TEB
figure;
semilogy(EbN0, TEB(1, :), 'b-o', 'LineWidth', 2); hold on;
semilogy(EbN0, TEB(2, :), 'r-+', 'LineWidth', 2); hold on;
semilogy(EbN0, TEB(3, :), 'g-x', 'LineWidth', 2); hold off;
grid on;
xlabel('Eb/N0 (dB)');
ylabel('TEB');
legend('Chaine 1', 'Chaine 2', 'Chaine 3');
title('TEB pour les trois chaînes de transmission');

% Fonction pour ajouter du bruit
function z = ajouter_bruit(x, EbN0, Ns, M)
    EbN0_lin = 10^(EbN0 / 10);
    Px = mean(abs(x).^2);
    sigma_n = sqrt((2 * Px * Ns) / (EbN0_lin * log2(M)));
    bruit = sigma_n * randn(1, length(x));
    z = x + bruit;
end

% Fonction pour obtenir les décisions
function decisions = obtenir_decisions(z, Ns, g)
    z_filtre = filter(g, 1, z);
    z_echant = z_filtre(1:Ns:end);
    if length(g) == Ns
        decisions = z_echant > 0;
    else
        decisions = qamdemod(z_echant, 4);
    end
end

% Fonction de chaine de transmission
function [x, h, g] = chaine_transmission(bits, Ns, chaine)
    % Mapping
    if chaine ~= 3
        ak = 2 * bits - 1;
    else
        ak = qammod(bits, 4);
    end
    
    x = kron(ak, [1 zeros(1, Ns - 1)]);
    
    % Filtre de mise en forme
    h = ones(1, Ns);
    
    % Filtre de réception
    if chaine == 1
        g = conv(h, h);
    elseif chaine == 2
        g = conv(h, ones(1, floor(Ns / 2)));
    else
        g = conv(h, h);
    end
end