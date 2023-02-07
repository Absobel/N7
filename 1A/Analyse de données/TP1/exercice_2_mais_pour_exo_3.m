clear;
close all;
clc;

taille_ecran = get(0,'ScreenSize');
L = taille_ecran(3);
H = taille_ecran(4);

load exercice_3;

figure('Name','ACP d''une image RVB',...
       'Position',[0.1*L,0.05*H,0.8*L,0.75*H]);

% Affichage de l'image RVB :
subplot(2,3,1);
imagesc(I);
axis image off;
title('Image RVB','FontSize',20);

% Analyse en composantes principales de la matrice X des donnees :
C = ACP(X);

% Affichage de la premiere composante principale :
colormap gray;				% Pour afficher les images en niveaux de gris
subplot(2,3,2);
imagesc(reshape(C(:,1),size(R)));
axis image off;
title('Premiere composante principale','FontSize',20);

% Affichage de la deuxieme composante principale :
subplot(2,3,4);
imagesc(reshape(C(:,2),size(V)));
axis image off;
title('Deuxieme composante principale','FontSize',20);

% Affichage de la troisieme composante principale :
subplot(2,3,5);
imagesc(reshape(C(:,3),size(B)));
axis image off;
title('Troisieme composante principale','FontSize',20);

% Affichage du nuage de pixels dans le repere des composantes principales :
subplot(1,3,3);
plot3(C(:,1),C(:,2),C(:,3),'.','MarkerSize',3,'Color',"#4DBEEE")
axis equal;
set(gca,'FontSize',10);
xlabel('C1','FontWeight','bold','FontSize',15)
ylabel('C2','FontWeight','bold','FontSize',15)
zlabel('C3','FontWeight','bold','FontSize',15)
view([105 30])
rotate3d;
grid on;
title({'Representation 3D des pixels dans' ...
       'l''espace des composantes principales'},'FontSize',20)

[correlation,contraste] = correlation_contraste(C);

% Affichage des resultats :
fprintf('Correlation entre R et V = %.3f\n',correlation(1));
fprintf('Correlation entre R et B = %.3f\n',correlation(2));
fprintf('Correlation entre V et B = %.3f\n',correlation(3));

fprintf('Proportion de contraste dans le canal R = %.3f\n',contraste(1));
fprintf('Proportion de contraste dans le canal V = %.3f\n',contraste(2));
fprintf('Proportion de contraste dans le canal B = %.3f\n',contraste(3));
