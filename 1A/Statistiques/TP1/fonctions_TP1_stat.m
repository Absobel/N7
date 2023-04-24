
% TP1 de Statistiques : fonctions a completer et rendre sur Moodle
% Nom :
% Prénom : 
% Groupe : 1SN-

function varargout = fonctions_TP1_stat(nom_fonction,varargin)

    switch nom_fonction
        case 'tirages_aleatoires_uniformes'
            varargout{1} = tirages_aleatoires_uniformes(varargin{:});
        case 'estimation_Dyx_MV'
            [varargout{1},varargout{2}] = estimation_Dyx_MV(varargin{:});
        case 'estimation_Dyx_MC'
            [varargout{1},varargout{2}] = estimation_Dyx_MC(varargin{:});
        case 'estimation_Dorth_MV'
            [varargout{1},varargout{2}] = estimation_Dorth_MV(varargin{:});
        case 'estimation_Dorth_MC'
            [varargout{1},varargout{2}] = estimation_Dorth_MC(varargin{:});
    end

end

% Fonction centrage_des_donnees (exercice_1.m) ----------------------------
function [x_G, y_G, x_donnees_bruitees_centrees, y_donnees_bruitees_centrees] = ...
                centrage_des_donnees(x_donnees_bruitees,y_donnees_bruitees)

    n = length(x_donnees_bruitees);
    x_G = sum(x_donnees_bruitees)/n;
    y_G = sum(y_donnees_bruitees)/n;
    x_donnees_bruitees_centrees = x_donnees_bruitees - x_G;
    y_donnees_bruitees_centrees = y_donnees_bruitees - y_G; 
end

% Fonction tirages_aleatoires (exercice_1.m) ------------------------------
function tirages_angles = tirages_aleatoires_uniformes(n_tirages)

    tirages_angles = pi*rand(1,n_tirages)-pi/2;
end

% Fonction estimation_Dyx_MV (exercice_1.m) -------------------------------
function [a_Dyx,b_Dyx] = ...
           estimation_Dyx_MV(x_donnees_bruitees,y_donnees_bruitees,tirages_psi)

    [x_G,y_G,x_donnees_bruitees_centrees,y_donnees_bruitees_centrees] = centrage_des_donnees(x_donnees_bruitees,y_donnees_bruitees);
    n = length(x_donnees_bruitees);
    n_tirages = length(tirages_psi);

    tanpsi = tan(tirages_psi);
    D = ones(n_tirages,1)*y_donnees_bruitees_centrees - (tanpsi')*x_donnees_bruitees_centrees;
    [~,indice] = min(sum(D.^2,2));
    a_Dyx = tanpsi(indice);
    b_Dyx = y_G - a_Dyx*x_G;
end

% Fonction estimation_Dyx_MC (exercice_2.m) -------------------------------
function [a_Dyx,b_Dyx] = ...
                   estimation_Dyx_MC(x_donnees_bruitees,y_donnees_bruitees)

    A = [x_donnees_bruitees',ones(length(x_donnees_bruitees),1)];
    B = y_donnees_bruitees';
    X = (A'*A)\(A'*B); 
    a_Dyx = X(1); b_Dyx = X(2);  
end

% Fonction estimation_Dorth_MV (exercice_3.m) -----------------------------
function [theta_Dorth,rho_Dorth] = ...
         estimation_Dorth_MV(x_donnees_bruitees,y_donnees_bruitees,tirages_theta)

    [x_G,y_G,x_donnees_bruitees_centrees,y_donnees_bruitees_centrees] = centrage_des_donnees(x_donnees_bruitees,y_donnees_bruitees);

    cos_theta = cos(tirages_theta);
    sin_theta = sin(tirages_theta);
    D = (cos_theta')*x_donnees_bruitees_centrees + (sin_theta')*y_donnees_bruitees_centrees;
    [~,indice] = min(sum(D.^2,2));
    theta_Dorth = tirages_theta(indice);
    rho_Dorth = x_G*cos(theta_Dorth) + y_G*sin(theta_Dorth);
end

% Fonction estimation_Dorth_MC (exercice_4.m) -----------------------------
function [theta_Dorth,rho_Dorth] = ...
                 estimation_Dorth_MC(x_donnees_bruitees,y_donnees_bruitees)

    [x_G,y_G,x_donnees_bruitees_centrees,y_donnees_bruitees_centrees] = centrage_des_donnees(x_donnees_bruitees,y_donnees_bruitees);

    C = [x_donnees_bruitees_centrees',y_donnees_bruitees_centrees'];
    [V,D] = eig(C'*C);
    eigen_val = sum(D,1);
    [~,indice] = min(eigen_val);
    Y_etoile = V(:,indice);
    theta_Dorth = atan(Y_etoile(2)/Y_etoile(1));
    rho_Dorth = x_G*cos(theta_Dorth) + y_G*sin(theta_Dorth);

end
