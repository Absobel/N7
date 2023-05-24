close all;
clear all;

donnees;


%% Gérération de xe(t)
symboles = 2*bits - 1;                              %Mapping
suite = kron(symboles, [1 zeros(1,Ns - 1)]);        % Génération des impulsions
signal = filter(h,1,suite);                         % L'enveloppe complexe

%% Signal recu sans erreur de phase et sans bruit
z = filter(hr,1,signal);


% Tracé du Signal echantilloné
n0 = Ns;                                            % Instant optimal d'échantillonnage
signal_echantillone = z(n0:Ns:end);
plot(signal_echantillone);
title("la constellation en sortie de l'échantillonneur");
xlabel("m");
ylabel("amplitude");

bits_estimes = signal_echantillone > 0;
TEB_sansErrPhase_sansBruit = length(find( (bits_estimes - bits) ~= 0 )) / nbits % Calcul du taux d'erreur

%% Etude avec erreur de phase et sans bruit
Phi = [0,40,100,180]*pi/180;                % Erreur de phase (rad)
r_dephase = exp(1i*Phi)'*signal;
z = zeros(length(Phi), length(r_dephase));
for k = 1:length(Phi)
    z(k,:) = filter(hr,1,r_dephase(k,:));   % reception du signal
end

% Calcul du TEB

% Echantillonage du signal pour differents erreurs de phase
signal_echantillone = z'; 
signal_echantillone = signal_echantillone(n0:Ns:end);
signal_echantillone = reshape(signal_echantillone,length(signal_echantillone)/length(Phi), length(Phi))';

bits_estimes = (real(signal_echantillone) > 0); % Decision
TEB_avecErrPhase_sansBruit = sum((bits_estimes - repmat(bits,length(Phi),1)) ~= 0,2) / nbits % Calcul du taux d'erreur pour differents erreurs de phase


%% Etude avec erreur de phase et avec bruit
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

THEO = true; % Boolean indiquant si on veut tracer les courbes theoriques ou pas
for i = 1:length(Phi)
    if THEO
       TEB_theorique = qfunc(real(exp(1i*Phi(i)))*sqrt(2*Eb_N0));
       plot(Eb_N0_db, TEB_theorique, 'DisplayName', ['TEB theorique (phi = ' num2str(Phi(i) * 180 / pi) '°)'],linewidth=2, linestyle=':');
    end
end

% Légende et étiquettes des axes
legend('Location', 'best');
xlabel('Eb/N0 (dB)');
ylabel('Taux d''erreur binaire (TEB)');

% Titre du graphique
title('Courbes du TEB en fonction de Eb/N0 pour différentes valeurs de phi');








                                     