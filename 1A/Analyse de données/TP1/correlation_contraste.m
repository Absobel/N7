function [correlation,contraste] = correlation_contraste(X)
    % Centrer les données
    Xc = X - mean(X);

    % Calculer la matrice de covariance
    n = size(Xc,1);
    sigma = 1/n*(Xc')*Xc;

    r = sigma./sqrt(diag(sigma)*diag(sigma)');
    correlation = [r(1,2) r(1,3) r(2,3)];
    contraste = diag(sigma)/(sigma(1,1)+sigma(2,2)+sigma(3,3));    
end