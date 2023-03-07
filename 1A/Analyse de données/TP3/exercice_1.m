clear;
close all;

taille_ecran = get(0,'ScreenSize');
L = taille_ecran(3);
H = taille_ecran(4);
azimuth = -72;
elevation = 42;

load exercice_0;
[nb_app,nb_carac,nb_classes] = size(X_app);

% Choix de la paire de caracteristiques la plus discriminante (a modifier !) :
ind_carac_1 = 2;
ind_carac_2 = 1;

% Recuperation des colonnes de X correspondant aux deux caracteristiques choisies :
X_app = X_app(:,[ind_carac_1 ind_carac_2],:);
nom_carac_1 = noms_carac{ind_carac_1};
nom_carac_2 = noms_carac{ind_carac_2};

% Maillage pour l'affichage des vraisemblances des 2 classes :
pas = 0.002;
marge = 0.005;
valeurs_carac_1 = min(min(X_app(:,1,:)))-marge:pas:max(max(X_app(:,1,:)))+marge;
valeurs_carac_2 = min(min(X_app(:,2,:)))-marge:pas:max(max(X_app(:,2,:)))+marge;
limites_affichage = [valeurs_carac_1(1) valeurs_carac_1(end) valeurs_carac_2(1) valeurs_carac_2(end)];

% Affichage des donnees d'apprentissage de la classe 1 (fibromes) :
figure('Name','Vraisemblances','Position',[0.1*L,0.1*H,0.8*L,0.7*H]);
subplot(1,2,1);
plot3(X_app(:,1,1),X_app(:,2,1),zeros(1,nb_app),'bx','MarkerSize',10,'LineWidth',2);
grid on;
xlabel(nom_carac_1,'FontSize',30);
ylabel(nom_carac_2,'FontSize',30);
zlabel('Vraisemblance','FontSize',30,'Rotation',90);
set(gca,'FontSize',20);
title('Classe 1 : fibromes','FontSize',20);
view(azimuth,elevation);
axis(limites_affichage);
hold on;

% Estimation des parametres de la classe 1 (fibromes) :
[mu_1,Sigma_1] = estimation_mu_Sigma(X_app(:,:,1));

% Calcul et affichage de la vraisemblance :
nb_1 = length(valeurs_carac_1);
nb_2 = length(valeurs_carac_2);
V_1 = zeros(nb_2,nb_1);
for i = 1:nb_1
    for j = 1:nb_2
        V_1(j,i) = vraisemblance(valeurs_carac_1(i),valeurs_carac_2(j),mu_1,Sigma_1);
    end
end
surface(valeurs_carac_1,valeurs_carac_2,V_1,'EdgeColor',[0.5 0.5 1],'FaceColor','none');

% Affichage des donnees d'apprentissage de la classe 2 (melanomes) :
subplot(1,2,2);
plot3(X_app(:,1,2),X_app(:,2,2),zeros(1,nb_app),'ro','MarkerSize',10,'LineWidth',2);
grid on;
xlabel(nom_carac_1,'FontSize',30);
ylabel(nom_carac_2,'FontSize',30);
zlabel('Vraisemblance','FontSize',30,'Rotation',90);
set(gca,'FontSize',20);
title('Classe 2 : melanomes','FontSize',20);
view(azimuth,elevation);
axis(limites_affichage);
hold on;

% Estimation des parametres de la classe 2 (melanomes) :
[mu_2,Sigma_2] = estimation_mu_Sigma(X_app(:,:,2));

% Calcul et affichage de la vraisemblance :
nb_1 = length(valeurs_carac_1);
nb_2 = length(valeurs_carac_2);
V_2 = zeros(nb_2,nb_1);
for i = 1:nb_1
    for j = 1:nb_2
        V_2(j,i) = vraisemblance(valeurs_carac_1(i),valeurs_carac_2(j),mu_2,Sigma_2);
    end
end
surface(valeurs_carac_1,valeurs_carac_2,V_2,'EdgeColor',[1 0.5 0.5],'FaceColor','none');

save exercice_1;
