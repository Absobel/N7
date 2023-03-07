function vecteur_pourcentage_bonne_classification_MAP = classif_MAP_4(X_fibrome,X_melanome,valeurs_p_1,mu_1,Sigma_1,mu_2,Sigma_2)
    valeurs_p_2 = 1 - valeurs_p_1;
    lXf = length(X_fibrome);
    lXm = length(X_melanome);
    vecteur_pourcentage_bonne_classification_MAP = zeros(1,length(valeurs_p_1));
    
    for j = 1:length(valeurs_p_1)
        Vf = zeros(lXf, 1);
        Vm = zeros(lXf, 1);
        p_1 = valeurs_p_1(j);
        p_2 = valeurs_p_2(j);
        for i = 1:lXf
            Vf(i) = p_1*vraisemblance(X_fibrome(i,1), X_fibrome(i,2), mu_1, Sigma_1) - p_2*vraisemblance(X_fibrome(i,1), X_fibrome(i,2), mu_2, Sigma_2);
        end
        for i = 1:lXm
            Vm(i) = p_2*vraisemblance(X_melanome(i,1), X_melanome(i,2), mu_2, Sigma_2) - p_1*vraisemblance(X_melanome(i,1), X_melanome(i,2), mu_1, Sigma_1);
        end
        vecteur_pourcentage_bonne_classification_MAP(j) = 100*(sum(Vf > 0) + sum(Vm > 0)) / (lXf + lXm);
    end
end