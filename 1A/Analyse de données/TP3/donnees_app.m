clear;
close all;

taille_ecran = get(0,'ScreenSize');
L = taille_ecran(3);
H = taille_ecran(4);

load /mnt/n7fs/ens/tp_carlier/AD/Bayes/donnees_app.mat
% Si donnees telechargees sur votre ordinateur, remplacez par :
% load donnees_app;

% Affichage de paires d'images des deux classes :
nb_app = size(I_fibrome,4);
txt = 'O';
while txt=='O'
    
    fig = figure('Name','Exemples d''images et de masques','Position',[0.1*L,0.1*H,0.6*L,0.7*H]);
    
	i_fibrome = randi(nb_app);

	image = I_fibrome(:,:,:,i_fibrome);
	subplot(2,2,1);
	imagesc(image);
	axis equal;
	axis off;
	title('Fibrome','FontSize',20);

	masque = M_fibrome(:,:,i_fibrome);
	subplot(2,2,2);
	imagesc(masque);
	colormap gray;
	axis equal;
	axis off;
	title('Masque du fibrome','FontSize',20);

	i_melanome = randi(nb_app);

	image = I_melanome(:,:,:,i_melanome);
	subplot(2,2,3);
	imagesc(image);
	axis equal;
	axis off;
	title('Melanome','FontSize',20);

	masque = M_melanome(:,:,i_melanome);
	subplot(2,2,4);
	imagesc(masque);
	colormap gray;
	axis equal;
	axis off;
	title('Masque du melanome','FontSize',20);

	txt = input('Autre exemple ? O/N [O] : ','s');
	if isempty(txt)
        close(fig)
		txt = 'O';
	end
end
