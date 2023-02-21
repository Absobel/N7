clear;
close all;

taille_ecran = get(0,'ScreenSize');
L = taille_ecran(3);
H = taille_ecran(4);

load donnees;
beta_0 = bord_inf(1,1);
gamma_0 = bord_sup(1,1);

load points_de_controle;

% Estimation des lois normales :
[moyennes,ecarts_types] = estimation_lois(liste_parametres);
d = (length(moyennes)-1)/2;

% Simulation de silhouettes par tirages aleatoires :
figure('Name','Tirage aleatoire de silhouettes','Position',[0.4*L,0.05*H,0.6*L,0.7*H]);
p = size(bord_inf,1);
x = transpose(0:1/(p-1):1);
nb_images = 50;				% Longueur de la sequence simulee
for j = 1:nb_images
	[y_inf,y_sup] = tirage_aleatoire(x,moyennes,ecarts_types,beta_0,gamma_0);

	if sum(y_inf<y_sup)==0
		plot(x,y_inf,'Color','r','LineWidth',2);
		hold on;
		plot(x,y_sup,'Color','r','LineWidth',2);
		axis([0,1.01,60,150]);
		axis ij;
		set(gca,'FontSize',20);
		xlabel('$x$','FontSize',30,'Interpreter','Latex');
		ylabel('$y$','FontSize',30,'Interpreter','Latex','Rotation',0);

		pause(0.2);
		hold off;
	end
end

save parametres_lois moyennes ecarts_types;
