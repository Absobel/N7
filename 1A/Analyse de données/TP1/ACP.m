function C = ACP(X)
    % Centrer les données
    X = X - mean(X);

    % Calculer la matrice de covariance
    n = size(X, 1);
    sigma = 1/n*(X')*X;

    % Calculer les vecteurs propres et les valeurs propres
    [W, D] = eig(sigma);

    % Trier les valeurs propres
    [D, ind] = sort(diag(D), 'descend');
    W = W(:, ind);  % Trier les vecteurs propres en fonction du tri des valeurs propres

    % Calculer C qui est X dans le nouveau repère par la matrice de passage W
    C = X*W;
end