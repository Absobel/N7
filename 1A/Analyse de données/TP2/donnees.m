clear;
close all;

taille_ecran = get(0,'ScreenSize');
L = taille_ecran(3);
H = taille_ecran(4);

load donnees;

% Affichage des silhouettes de la flamme :
figure('Name','Silhouettes d''une flamme de bougie','Position',[0.4*L,0.05*H,0.6*L,0.7*H]);
[p,n] = size(bord_inf);
x = transpose(0:1/(p-1):1);
for j = 1:n
	plot(x,bord_inf(:,j),'k','LineWidth',2);
	hold on;
	plot(x,bord_sup(:,j),'k','LineWidth',2);
	axis([0,1.01,60,150]);
	axis ij;
	set(gca,'FontSize',20);
	xlabel('$x$','FontSize',30,'Interpreter','Latex');
	ylabel('$y$','FontSize',30,'Interpreter','Latex','Rotation',0);
	pause(0.5);
	hold off;
end
