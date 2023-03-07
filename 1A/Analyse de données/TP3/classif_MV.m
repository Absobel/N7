function pourcentage_bonne_classification = classif_MV(X_app,mu_1,Sigma_1,mu_2,Sigma_2)
    lX = length(X_app);
    Vr = zeros(lX, 1);
    Vb = zeros(lX, 1);
    for i = 1:lX
        Vr(i) = vraisemblance(X_app(i,1,1), X_app(i,2,1), mu_1, Sigma_1) - vraisemblance(X_app(i,1,1), X_app(i,2,1), mu_2, Sigma_2);
        Vb(i) = vraisemblance(X_app(i,1,2), X_app(i,2,2), mu_2, Sigma_2) - vraisemblance(X_app(i,1,2), X_app(i,2,2), mu_1, Sigma_1);
    end
    pourcentage_bonne_classification = 100*(sum(Vr > 0) + sum(Vb > 0)) / (2 * lX);
end