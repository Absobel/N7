    clear;
close all;
clc;

% Parametres pour l'affichage des donnees :
taille_ecran = get(0,'ScreenSize');
L = taille_ecran(3);
H = taille_ecran(4);

load donnees_app;

% Donnees non filtrees :
X = X_app;
Y = Y_app;

% Estimation du SVM avec noyau gaussien :
sigmaINF= 0.0001380318739541181474699;	% Ecart-type du noyau gaussien
NbPoints = 1000;
sigmas = linspace(0.000001,0.01, NbPoints);
ratios = zeros(1, NbPoints);

for k=1:NbPoints

    sigma = sigmas(k);
    [X_VS,Y_VS,Alpha_VS,c,code_retour] = SVM_3(X,Y,sigma);
    
    % Si l'optimisation n'a pas converge :
    if code_retour ~= 1
	    return;
    end



    pas = 0.002;
    marge = 0.005;
    valeurs_carac_1 = min(min(X(:,1)))-marge:pas:max(max(X(:,1)))+marge;
    valeurs_carac_2 = min(min(X(:,2)))-marge:pas:max(max(X(:,2)))+marge;
    limites_affichage = [valeurs_carac_1(1) valeurs_carac_1(end) ...
                         valeurs_carac_2(1) valeurs_carac_2(end)];
    nom_carac_1 = 'Compacite';
    nom_carac_2 = 'Contraste';
    
    % Regle de decision du SVM :
    nb_1 = length(valeurs_carac_1);
    nb_2 = length(valeurs_carac_2);
    SVM_predict = zeros(nb_2,nb_1);
    for i = 1:nb_1
	    for j = 1:nb_2
		    x_ij = [valeurs_carac_1(i) ; valeurs_carac_2(j)];
		    SVM_predict(j,i) = sign(exp(-sum((X_VS-x_ij').^2,2)/(2*sigma^2))'*diag(Y_VS)*Alpha_VS-c);
	    end
    end
    
    % Pourcentage de bonnes classifications des donnees de test :
    load donnees_test;
    nb_donnees_test = size(X_test,1);
    nb_classif_OK = 0;
    for i = 1:nb_donnees_test
	    x_i = X_test(i,:);
	    prediction = sign(exp(-sum((X_VS-x_i).^2,2)/(2*sigma^2))'*diag(Y_VS)*Alpha_VS-c);
	    if prediction==Y_test(i)
		    nb_classif_OK = nb_classif_OK+1;
	    end
    end
    ratios(k) = double(nb_classif_OK/nb_donnees_test*100);
end

plot(sigmas, ratios)
title("Taux de bonne classification en fonction de sigma")
xlabel("sigma")
ylabel("taux de bonne classification")
