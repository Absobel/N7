close all;
clear all;

donnees;


%% Gérération de xe(t)
symboles = 2*bits - 1;                              %Mapping
suite = kron(symboles, [1 zeros(1,Ns - 1)]);        % Génération des impulsions
signal = filter(h,1,suite);                         % L'enveloppe complexe



%% Etude avec erreur de phase et avec bruit avec estimation de l’erreur de phase et correction
Phi = [0;40;100]*pi/180;             % Erreur de phase (rad)
Px = mean(abs(signal).^2);           % Puissance du signal reçu

Eb_N0_db = 0:1:6;
Eb_N0 = 10.^(Eb_N0_db/10);
TEBavecErrPhase_avecBruit = zeros(length(Phi),length(Eb_N0));
for k = 1:length(Eb_N0)
    sigma = (Px*Ns)./ (2*N*Eb_N0(k));
    bruit = (sqrt(sigma)*randn(1, length(signal))) +(i*sqrt(sigma)*randn(1, length(signal)));
    r = signal + bruit;
    r_dephase = r.*exp(1i*Phi);
    z = zeros(length(Phi), length(r_dephase));
    for l = 1:length(Phi)
        z(l,:) = filter(hr,1,r_dephase(l,:));         % reception du signal
    end
    n0 = Ns;                            % Echantillonage aux instants optimaux
    signal_echantillone = z'; 
    signal_echantillone = signal_echantillone(n0:Ns:end);
    signal_echantillone = reshape(signal_echantillone,length(signal_echantillone)/length(Phi), length(Phi))';


    


    % Estimation des angles phi
    Phi_estime = 1/2 * angle(sum(signal_echantillone.^2, 2));

    % Correction des signaux reçus
    signal_echantillone = signal_echantillone .* exp(-i*Phi_estime);

    bits_estimes = (real(signal_echantillone) > 0);                                   % dempaping | decision
    TEB_avec_bruit = sum(bits_estimes ~= repmat(bits,length(Phi),1),2) / nbits; % Calcul du taux d'erreur
    TEBavecErrPhase_avecBruit(:,k)= TEB_avec_bruit;
end


TEB = TEBavecErrPhase_avecBruit;
% Tracer les courbes
figure; hold on;
for i = 1:length(Phi)
    plot(Eb_N0_db, TEB(i, :), 'DisplayName', ['TEB simule (phi = ' num2str(Phi(i) * 180 / pi) '°)'], linewidth=1.5);
end


% Légende et étiquettes des axes
legend('Location', 'best');
xlabel('Eb/N0 (dB)');
ylabel('Taux d''erreur binaire (TEB)');

% Titre du graphique
title('Courbes du TEB en fonction de Eb/N0 pour différentes valeurs de phi Avec Estimation et Correction');








                                     