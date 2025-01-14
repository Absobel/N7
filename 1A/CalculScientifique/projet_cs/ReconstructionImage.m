%%  Application de la SVD : compression d'images

clear all
close all

% Lecture de l'image
I = imread('bd/BD_Asterix_0.png');
I = rgb2gray(I);
I = double(I);

[q, p] = size(I)

% Décomposition par SVD
fprintf('Décomposition en valeurs singulières\n')
tic
[U, S, V] = svd(I);
toc

l = min(p,q);

%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
% On choisit de ne considérer que 200 vecteurs
%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%

% vecteur pour stocker la différence entre l'image et l'image reconstuite
inter = 1:40:(240+40);
inter(end) = 240;
differenceSVD = zeros(size(inter,2), 1);

% images reconstruites en utilisant de 1 à 200 vecteurs (avec un pas de 40)
ti = 0;
td = 0;
for k = inter

    % Calcul de l'image de rang k
    Im_k = U(:, 1:k)*S(1:k, 1:k)*V(:, 1:k)';

    % Affichage de l'image reconstruite
    ti = ti+1;
    figure(ti)
    colormap('gray')
    imagesc(Im_k)
    
    % Calcul de la différence entre les 2 images
    td = td + 1;
    differenceSVD(td) = sqrt(sum(sum((I-Im_k).^2)));
    %pause
end

% Figure des différences entre image réelle et image reconstruite
ti = ti+1;
figure(ti)
hold on
plot(inter, differenceSVD, '-x', 'LineWidth', 2, 'MarkerSize', 10);
ylabel('RMSE')
xlabel('rank k')

%pause


% Plugger les différentes méthodes : eig, puissance itérée et les 4 versions de la "subspace iteration method" 

%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
% QUELQUES VALEURS PAR DÉFAUT DE PARAMÈTRES, 
% VALEURS QUE VOUS POUVEZ/DEVEZ FAIRE ÉVOLUER
%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%

% tolérance
eps = 1e-8;
% nombre d'itérations max pour atteindre la convergence
maxit = 10000;

% taille de l'espace de recherche (m)
search_space = 400;

% pourcentage que l'on se fixe
percentage = 0.995;

% p pour les versions 2 et 3 (attention p déjà utilisé comme taille)
puiss = 2;

%%%%%%%%%%%%%
% À COMPLÉTER
%%%%%%%%%%%%%

%close all;

isALEndroit = p <= q;
if ~isALEndroit
    I = I';
    [p,q] = size(I);
end

% 0 : eig
% 1 : power_v12
% 2 : subspace_iter_v0
% 3 : subspace_iter_v1
% 4 : subspace_iter_v2
% 5 : subspace_iter_v3

nb_function = 5;

switch nb_function
    case 0 %eig
        [Uk, diag_eigenU] = eig(I*I');
    case 1   % ne fonctionne pas, à réparer
        [Uk, diag_eigenU,n_ev, itv, flag] = power_v12(I*I', k, percentage, eps, maxit);          % A m percentage eps maxit
    case 2
        [Uk, diag_eigenU] = subspace_iter_v0(I*I', k, eps, maxit);
    case 3
        [Uk, diag_eigenU] = subspace_iter_v1(I*I', k, percentage, eps, maxit);
    case 4
        [Uk, diag_eigenU] = subspace_iter_v2(I*I', k, percentage, p, eps, maxit);
    case 5
        [Uk, diag_eigenU] = subspace_iter_v3(I*I', k, percentage, p, eps, maxit);
end

singularU = sqrt(diag(diag_eigenU));
[singularU, index] = sort(singularU, 'descend');
singularUk = singularU(1:k);
Uk = Uk(:,index(1:k));

SigmaK = diag(singularUk);

Vk = zeros(q,k);
for i = 1:k
    Vk(:,i) = I'*Uk(:,i)/SigmaK(i,i);
end

image_compressed = Uk*SigmaK*Vk';

if ~isALEndroit
    image_compressed = image_compressed';
end

figure(ti+1)
colormap('gray')
imagesc(image_compressed)