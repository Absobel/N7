clear;
close all;

taille_ecran = get(0,'ScreenSize');
L = taille_ecran(3);
H = taille_ecran(4);

load donnees_app;
% Pour les etudiants 
% load /mnt/n7fs/ens/tp_carlier/AD/Bayes/donnees_app.mat

% Matrice des caracteristiques des donnees d'apprentissage :
nb_app = size(I_fibrome,4);
nb_carac = 3;
noms_carac = {'Compacite','Contraste','Texture'};
nb_classes = 2;
X_app = zeros(nb_app,nb_carac,nb_classes);

% Calcul des caracteristiques des images de fibromes :
for i = 1:nb_app
	image_RVB = I_fibrome(:,:,:,i);
	image_Ycbcr = rgb2ycbcr(image_RVB);
	image_Y = image_Ycbcr(:,:,1);
	masque = M_fibrome(:,:,i);

	% Caracteristique 1 (compacite de la tache) :
	aire_tache = bwarea(masque);
	image_bord_tache = bwperim(masque,8);
	perimetre_tache = length(find(image_bord_tache>0));
	X_app(i,1,1) = sqrt(aire_tache)/perimetre_tache;

	% Caracteristique 2 (contraste de la tache) :
	Y = double(image_Y);
	tache_Y = Y(masque);
	tache_Y_normalisee = tache_Y/mean(Y(:));
	X_app(i,2,1) = sqrt(var(tache_Y_normalisee));

	% Caracteristique 3 (texture de la tache) :
	glcms = graycomatrix(image_Y);			% Matrice de co-occurrence
	stats = graycoprops(glcms);
	X_app(i,3,1) = stats.Correlation;
end

% Calcul des caracteristiques des images de melanomes :
for i = 1:nb_app
	image_RVB = I_melanome(:,:,:,i);
	image_Ycbcr = rgb2ycbcr(image_RVB);
	image_Y = image_Ycbcr(:,:,1);
	masque = M_melanome(:,:,i);

	% Caracteristique 1 (compacite de la tache) :
	aire_tache = bwarea(masque);
	image_bord_tache = bwperim(masque,8);
	perimetre_tache = length(find(image_bord_tache>0));
	X_app(i,1,2) = sqrt(aire_tache)/perimetre_tache;

	% Caracteristique 2 (contraste de la tache) :
	Y = double(image_Y);
	tache_Y = Y(masque);
	tache_Y_normalisee = tache_Y/mean(Y(:));
	X_app(i,2,2) = sqrt(var(tache_Y_normalisee));

	% Caracteristique 3 (texture de la tache) :
	glcms = graycomatrix(image_Y);			% Matrice de co-occurrence
	stats = graycoprops(glcms);
	X_app(i,3,2) = stats.Correlation;
end


% Affichage des deux nuages de points 3D :
figure('Name','Representation des images par des points 3D','Position',[0.2*L,0.1*H,0.6*L,0.7*H]);
plot3(X_app(:,1,1),X_app(:,2,1),X_app(:,3,1),'bx','MarkerSize',10,'LineWidth',3);
hold on;
plot3(X_app(:,1,2),X_app(:,2,2),X_app(:,3,2),'ro','MarkerSize',10,'LineWidth',3);
set(gca,'FontSize',20);
xlabel(noms_carac(1),'FontSize',30);
ylabel(noms_carac(2),'FontSize',30);
zlabel(noms_carac(3),'FontSize',30);
marge = 0.005;
axis([min(min(X_app(:,1,:)))-marge max(max(X_app(:,1,:)))+marge ...
      min(min(X_app(:,2,:)))-marge max(max(X_app(:,2,:)))+marge ...
      min(min(X_app(:,3,:)))-marge max(max(X_app(:,3,:)))+marge]);
grid on
legend('Dermatofibromes','Melanomes','FontSize',20,'Location','NorthWest');

save exercice_0 X_app noms_carac;
