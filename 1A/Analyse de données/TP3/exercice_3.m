clear;
close all;

taille_ecran = get(0,'ScreenSize');
L = taille_ecran(3);
H = taille_ecran(4);

load exercice_1;

% Classification par maximum de vraisemblance :
V_max = max(V_1,V_2);
code_classe = zeros(length(valeurs_carac_2),length(valeurs_carac_1));
code_classe(V_1==V_max) = 1;
code_classe(V_2==V_max) = 2;

% Affichage du maximum de vraisemblance :
figure('Name','Comparaison entre MV et MAP','Position',[0.01*L,0.15*H,0.98*L,0.6*H]);
subplot(1,3,1);
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

pourcentage_bonne_classification_MV = classif_MV(X_app,mu_1,Sigma_1,mu_2,Sigma_2);
title({'Classification par maximum de vraisemblance' ...
	   [num2str(pourcentage_bonne_classification_MV,'%.1f') '% de bonnes classifications']},...
	  'FontSize',20);

% Valeurs de l'a priori testees :
valeurs_p_1 = 0:0.01:1;

% Comptage des images correctement classees :
vecteur_pourcentage_bonne_classification_MAP = classif_MAP(X_app,valeurs_p_1,mu_1,Sigma_1,mu_2,Sigma_2);

% Recherche du meilleur maximum a posteriori :
[pourcentage_bonne_classification_MAP,ind_MAP] = max(vecteur_pourcentage_bonne_classification_MAP);
p_1_max = valeurs_p_1(ind_MAP);
p_2_max = 1-p_1_max;

% Trace du pourcentage de bonnes classifications en fonction de p_1 :
subplot(1,3,2);
plot(valeurs_p_1,vecteur_pourcentage_bonne_classification_MAP,'r','LineWidth',2,'HandleVisibility','off');
hold on
plot([0.5 0.5],[0.5 pourcentage_bonne_classification_MV],'b--','LineWidth',2);
plot([p_1_max p_1_max],[0.5 pourcentage_bonne_classification_MAP],'b','LineWidth',2);
xlabel('Probabilite a priori de la classe 1','FontSize',30);
ylabel('Pourcentage de bonnes classifications','FontSize',30);
set(gca,'FontSize',20);
axis([0 1 50 100]);
grid on
legend('MV','MAP')
title('Recherche de l''a priori optimal',...
	  'FontSize',20);

% Classification par maximum a posteriori :
V_max = max(p_1_max*V_1,p_2_max*V_2);
code_classe = zeros(length(valeurs_carac_2),length(valeurs_carac_1));
code_classe(p_1_max*V_1==V_max) = 1;
code_classe(p_2_max*V_2==V_max) = 2;

% Affichage du maximum a posteriori :
subplot(1,3,3);
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

title({'Classification par maximum a posteriori' ...
	   [num2str(pourcentage_bonne_classification_MAP,'%.1f') '% de bonnes classifications']},...
	  'FontSize',20);
