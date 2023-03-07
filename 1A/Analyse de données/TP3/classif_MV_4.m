function pourcentage_bonne_classification = classif_MV_4(X_fibrome,X_melanome,mu_1,Sigma_1,mu_2,Sigma_2)
    lXf = length(X_fibrome);
    lXm = length(X_melanome);
    Vf = zeros(lXf, 1);
    Vm = zeros(lXm, 1);
    for i = 1:lXf
        Vf(i) = vraisemblance(X_fibrome(i,1), X_fibrome(i,2), mu_1, Sigma_1) - vraisemblance(X_fibrome(i,1), X_fibrome(i,2), mu_2, Sigma_2);
    end
    for i = 1:lXm
        Vm(i) = vraisemblance(X_melanome(i,1), X_melanome(i,2), mu_2, Sigma_2) - vraisemblance(X_melanome(i,1), X_melanome(i,2), mu_1, Sigma_1);
    end
    pourcentage_bonne_classification = 100*(sum(Vf > 0) + sum(Vm > 0)) / (lXf + lXm);
end