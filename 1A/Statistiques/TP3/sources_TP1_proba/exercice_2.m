exercice_1;

n_tirages = 500;

% Estimation de la position du centre :
tirages_C = fonctions_TP1_proba('tirages_aleatoires_uniformes',n_tirages,G,R_moyen);
C_estime = fonctions_TP1_proba('estimation_C',...
                  x_donnees_bruitees,y_donnees_bruitees,tirages_C,R_moyen);

% Affichage du cercle estime :
theta_cercle = 2*pi/100:2*pi/100:2*pi;
x_cercle_estime = C_estime(1) + R_moyen*cos(theta_cercle);
y_cercle_estime = C_estime(2) + R_moyen*sin(theta_cercle);
plot(x_cercle_estime([1:end 1]),y_cercle_estime([1:end 1]),'g','LineWidth',3);
legend(' Cercle initial', ...
	   ' Donnees bruitees', ...
       ' Estimation avec G et R_{moyen}', ...
	   ' Estimation avec tirages uniformes de C', ...
	   'Location','Best')
   
clear n_tirages theta_cercle x_cercle_estime y_cercle_estime
