function [mu,Sigma] = estimation_mu_Sigma(X)
        mu = mean(X)';
        n = length(X);
        Xc = X - ones(n,1)*mu';
        Sigma = (Xc'*Xc)/n;
end