clear;
close all;

taille_ecran = get(0,'ScreenSize');
L = taille_ecran(3);
H = taille_ecran(4);

load donnees_test;
X_melanome(475,:,:) = [];

% Choix de la paire de caracteristiques la plus discriminante (a modifier !) :
ind_carac_1 = 2;
ind_carac_2 = 1;

% Recuperation des colonnes de X correspondant aux deux caracteristiques choisies :
X_fibrome = X_fibrome(:,[ind_carac_1 ind_carac_2],:);
X_melanome = X_melanome(:,[ind_carac_1 ind_carac_2],:);
noms_carac = {'Compacite','Contraste','Texture'};
nom_carac_1 = noms_carac{ind_carac_1};
nom_carac_2 = noms_carac{ind_carac_2};

% Maillage pour l'affichage des vraisemblances des 2 classes :
pas = 0.002;
marge = 0.005;
xmin = min([min(X_fibrome(:,1)) min(X_melanome(:,1))]);
xmax = max([max(X_fibrome(:,1)) max(X_melanome(:,1))]);
ymin = min([min(X_fibrome(:,2)) min(X_melanome(:,2))]);
ymax = max([max(X_fibrome(:,2)) max(X_melanome(:,2))]);
valeurs_carac_1 = xmin-marge:pas:xmax+marge;
valeurs_carac_2 = ymin-marge:pas:ymax+marge;
limites_affichage = [valeurs_carac_1(1) valeurs_carac_1(end) valeurs_carac_2(1) valeurs_carac_2(end)];

% Estimation des parametres de la classe 1 (fibromes) :
[mu_1,Sigma_1] = estimation_mu_Sigma(X_fibrome);

% Calcul et affichage de la vraisemblance :
nb_1 = length(valeurs_carac_1);
nb_2 = length(valeurs_carac_2);
V_1 = zeros(nb_2,nb_1);
for i = 1:nb_1
    for j = 1:nb_2
        V_1(j,i) = vraisemblance(valeurs_carac_1(i),valeurs_carac_2(j),mu_1,Sigma_1);
    end
end

% Estimation des parametres de la classe 2 (melanomes) :
[mu_2,Sigma_2] = estimation_mu_Sigma(X_melanome);

% Calcul et affichage de la vraisemblance :
nb_1 = length(valeurs_carac_1);
nb_2 = length(valeurs_carac_2);
V_2 = zeros(nb_2,nb_1);
for i = 1:nb_1
    for j = 1:nb_2
        V_2(j,i) = vraisemblance(valeurs_carac_1(i),valeurs_carac_2(j),mu_2,Sigma_2);
    end
end


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
[nb_app_f,nb_carac_f,~] = size(X_fibrome);
for i = 1:nb_app_f
	carac_1_classe_1 = X_fibrome(i,1);
	carac_2_classe_1 = X_fibrome(i,2);
	plot3(carac_1_classe_1,carac_2_classe_1,nb_carac_f+1,'bx','MarkerSize',10,'LineWidth',3)
end
[nb_app_m,nb_carac_m,~] = size(X_melanome);
for i = 1:nb_app_m
	carac_1_classe_2 = X_melanome(i,1);
	carac_2_classe_2 = X_melanome(i,2);
	plot3(carac_1_classe_2,carac_2_classe_2,nb_carac_m+1,'ro','MarkerSize',10,'LineWidth',3)
end

pourcentage_bonne_classification_MV = classif_MV_4(X_fibrome,X_melanome,mu_1,Sigma_1,mu_2,Sigma_2);
title({'Classification par maximum de vraisemblance' ...
	   [num2str(pourcentage_bonne_classification_MV,'%.1f') '% de bonnes classifications']},...
	  'FontSize',20);

% Valeurs de l'a priori testees :
valeurs_p_1 = 0:0.01:1;

% Comptage des images correctement classees :
vecteur_pourcentage_bonne_classification_MAP = classif_MAP_4(X_fibrome,X_melanome,valeurs_p_1,mu_1,Sigma_1,mu_2,Sigma_2);

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
[nb_app_f,nb_carac_f,~] = size(X_fibrome);
for i = 1:nb_app_f
	carac_1_classe_1 = X_fibrome(i,1);
	carac_2_classe_1 = X_fibrome(i,2);
	plot3(carac_1_classe_1,carac_2_classe_1,nb_carac_f+1,'bx','MarkerSize',10,'LineWidth',3)
end
[nb_app_m,nb_carac_m,~] = size(X_melanome);
for i = 1:nb_app_m
	carac_1_classe_2 = X_melanome(i,1);
	carac_2_classe_2 = X_melanome(i,2);
	plot3(carac_1_classe_2,carac_2_classe_2,nb_carac_m+1,'ro','MarkerSize',10,'LineWidth',3)
end

title({'Classification par maximum a posteriori' ...
	   [num2str(pourcentage_bonne_classification_MAP,'%.1f') '% de bonnes classifications']},...
	  'FontSize',20);
