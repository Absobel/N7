clear;
close all;

taille_ecran = get(0,'ScreenSize');
L = taille_ecran(3);
H = taille_ecran(4);

load exercice_1;

% Recherche du maximum de vraisemblance entre les 2 classes :
V_max = max(V_1,V_2);
code_classe = zeros(length(valeurs_carac_2),length(valeurs_carac_1));
code_classe(V_1==V_max) = 1;
code_classe(V_2==V_max) = 2;

% Affichage du maximum de vraisemblance :
figure('Name','Classification par maximum de vraisemblance','Position',[0.25*L,0.1*H,0.5*L,0.7*H]);
surface(valeurs_carac_1,valeurs_carac_2,code_classe,'EdgeColor','none')
carte_couleurs = [0.5 0.5 1 ; 1 0.5 0.5];
colormap(carte_couleurs);
xlabel(nom_carac_1,'FontSize',30);
ylabel(nom_carac_2,'FontSize',30);
view(-90,90);
set(gca,'FontSize',20);
axis(limites_affichage);
hold on;

% Affichage des points de l'ensemble d'apprentissage :
[nb_app,nb_carac,~] = size(X_app);
for i = 1:nb_app
	carac_1_classe_1 = X_app(i,1,1);
	carac_2_classe_1 = X_app(i,2,1);
	plot3(carac_1_classe_1,carac_2_classe_1,nb_carac+1,'bx','MarkerSize',10,'LineWidth',3)

	carac_1_classe_2 = X_app(i,1,2);
	carac_2_classe_2 = X_app(i,2,2);
	plot3(carac_1_classe_2,carac_2_classe_2,nb_carac+1,'ro','MarkerSize',10,'LineWidth',3)
end

% Calcul et affichage du taux de bonnes classifications :
pourcentage_bonne_classification = classif_MV(X_app,mu_1,Sigma_1,mu_2,Sigma_2);
title({'Classification par maximum de vraisemblance' ...
	   [num2str(pourcentage_bonne_classification,'%.1f') '% de bonnes classifications']},...
	  'FontSize',20);
