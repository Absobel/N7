clear all;
close all;
format long;

%%%%%%%%%%%%
% PARAMÈTRES
%%%%%%%%%%%%
n = 300;
    figure;
    for imat = 1:4


% taille de la matrice symétrique
%n = 200;

% type de la matrice (voir matgen_csad)
% imat == 1 valeurs propres D(i) = i
% imat == 2 valeurs propres D(i) = random(1/cond, 1) avec leur logarithmes
%                                  uniformément répartie, cond = 1e10
% imat == 3 valeurs propres D(i) = cond**(-(i-1)/(n-1)) avec cond = 1e5
% imat == 4 valeurs propres D(i) = 1 - ((i-1)/(n-1))*(1 - 1/cond) avec cond = 1e2
%imat = 1;

% on génère la matrice (1) ou on lit dans un fichier (0)
genere = 0;

% méthode de calcul
v = 10; % subspace iteration v2

[W, V, flag, q, qv] = eigen_2023(imat, n, v, [], [], [], [], [], genere);
        
plot(sort(diag(V), 'descend')); hold on;

    end
    hold off;
    legend('imat = 1', 'imat = 2', 'imat = 3', 'imat = 4');
    title("Distribution des valeurs propres en fonction du type (taille : " + n + ")");
    xlabel("Valeurs propres");
