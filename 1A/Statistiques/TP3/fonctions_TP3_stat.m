
% TP3 de Statistiques : fonctions a completer et rendre sur Moodle
% Nom :
% Prenom : 
% Groupe : 1SN-

function varargout = fonctions_TP3_stat(nom_fonction,varargin)

    switch nom_fonction
        case 'estimation_F'
            [varargout{1},varargout{2},varargout{3}] = estimation_F(varargin{:});
        case 'choix_indices_points'
            [varargout{1}] = choix_indices_points(varargin{:});
        case 'RANSAC_2'
            [varargout{1},varargout{2}] = RANSAC_2(varargin{:});
        case 'G_et_R_moyen'
            [varargout{1},varargout{2},varargout{3}] = G_et_R_moyen(varargin{:});
        case 'estimation_C_et_R'
            [varargout{1},varargout{2},varargout{3}] = estimation_C_et_R(varargin{:});
        case 'RANSAC_3'
            [varargout{1},varargout{2}] = RANSAC_3(varargin{:});
    end

end

% Fonction estimation_F (exercice_1.m) ------------------------------------
function [rho_F,theta_F,ecart_moyen] = estimation_F(rho,theta)
    A = [cos(theta) sin(theta)];
    B = rho;
    X = A\B;  % X = [xF;yF]
    rho_F = sqrt(X(1)^2+X(2)^2);
    theta_F = atan2(X(2),X(1));
    n = length(rho);
    ecart_moyen = sum(abs(rho-rho_F*cos(theta - theta_F)))/n;
end

% Fonction choix_indice_elements (exercice_2.m) ---------------------------
function tableau_indices_points_choisis = choix_indices_points(k_max,n,n_indices)
    tableau_indices_points_choisis = zeros(k_max,n_indices);
    for k = 1:k_max
        tableau_indices_points_choisis(k,:) = randperm(n,n_indices);
    end    
end

% Fonction RANSAC_2 (exercice_2.m) ----------------------------------------
function [rho_F_estime,theta_F_estime] = RANSAC_2(rho,theta,parametres,tableau_indices_2droites_choisies)
    S1 = parametres(1);
    S2 = parametres(2);
    k_max = parametres(3);
    n = length(rho);
    min_ecart = inf;

    for k = 1:k_max
        rho_theta_indices_choisis = tableau_indices_2droites_choisies(k,:);
        rho_choisi = rho(rho_theta_indices_choisis);
        theta_choisi = theta(rho_theta_indices_choisis);
        [rho_F,theta_F,~] = estimation_F(rho_choisi,theta_choisi);
        indices_conformes = abs(rho-rho_F*cos(theta-theta_F)) < S1;
        if sum(indices_conformes)/n > S2
            [~,~,ecart_moyen] = estimation_F(rho(indices_conformes),theta(indices_conformes));
            if ecart_moyen < min_ecart
                min_ecart = ecart_moyen;
                rho_F_estime = rho_F;
                theta_F_estime = theta_F;
            end
        end
    end
end

% Fonction G_et_R_moyen (exercice_3.m, bonus, fonction du TP1) ------------
function [G, R_moyen, distances] = ...
         G_et_R_moyen(x_donnees_bruitees,y_donnees_bruitees)

end

% Fonction tirages_aleatoires (exercice_3.m, bonus, fonction du TP1) ----------------
function [tirages_C,tirages_R] = tirages_aleatoires_uniformes(n_tirages,G,R_moyen)

end

% Fonction estimation_C_et_R (exercice_3.m, bonus, fonction du TP1) -------
function [C_estime, R_estime, critere] = ...
         estimation_C_et_R(x_donnees_bruitees,y_donnees_bruitees,tirages_C,tirages_R)



end

% Fonction RANSAC_3 (exercice_3, bonus) -----------------------------------
function [C_estime,R_estime] = ...
         RANSAC_3(x_donnees_bruitees,y_donnees_bruitees,parametres,tableau_indices_3points_choisis)
     


end
