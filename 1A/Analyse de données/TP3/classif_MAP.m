function vecteur_pourcentage_bonne_classification_MAP = classif_MAP(X_app,valeurs_p_1,mu_1,Sigma_1,mu_2,Sigma_2)
    valeurs_p_2 = 1 - valeurs_p_1;
    lX = length(X_app);
    vecteur_pourcentage_bonne_classification_MAP = zeros(1,length(valeurs_p_1));
    
    for j = 1:length(valeurs_p_1)
        Vr = zeros(lX, 1);
        Vb = zeros(lX, 1);
        for i = 1:lX
            p_1 = valeurs_p_1(j);
            p_2 = valeurs_p_2(j);
            Vr(i) = p_1*vraisemblance(X_app(i,1,1), X_app(i,2,1), mu_1, Sigma_1) - p_2*vraisemblance(X_app(i,1,1), X_app(i,2,1), mu_2, Sigma_2);
            Vb(i) = p_2*vraisemblance(X_app(i,1,2), X_app(i,2,2), mu_2, Sigma_2) - p_1*vraisemblance(X_app(i,1,2), X_app(i,2,2), mu_1, Sigma_1);
        end
        vecteur_pourcentage_bonne_classification_MAP(j) = 100*(sum(Vr > 0) + sum(Vb > 0)) / (2 * lX);
    end
end