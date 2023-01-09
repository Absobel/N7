
% TP2 de Statistiques : fonctions a completer et rendre sur Moodle
% Nom :
% Prénom : 
% Groupe : 1SN-

function varargout = fonctions_TP2_stat(nom_fonction,varargin)

    switch nom_fonction
        case 'tirages_aleatoires_uniformes'
            [varargout{1},varargout{2}] = tirages_aleatoires_uniformes(varargin{:});
        case 'estimation_Dyx_MV'
            [varargout{1},varargout{2}] = estimation_Dyx_MV(varargin{:});
        case 'estimation_Dyx_MC'
            [varargout{1},varargout{2}] = estimation_Dyx_MC(varargin{:});
        case 'estimation_Dyx_MV_2droites'
            [varargout{1},varargout{2},varargout{3},varargout{4}] = estimation_Dyx_MV_2droites(varargin{:});
        case 'probabilites_classe'
            [varargout{1},varargout{2}] = probabilites_classe(varargin{:});
        case 'classification_points'
            [varargout{1},varargout{2},varargout{3},varargout{4}] = classification_points(varargin{:});
        case 'estimation_Dyx_MCP'
            [varargout{1},varargout{2}] = estimation_Dyx_MCP(varargin{:});
        case 'iteration_estimation_Dyx_EM'
            [varargout{1},varargout{2},varargout{3},varargout{4},varargout{5},varargout{6},varargout{7},varargout{8}] = ...
            iteration_estimation_Dyx_EM(varargin{:});
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

% Fonction tirages_aleatoires_uniformes (exercice_1.m) ------------------------
function [tirages_angles,tirages_G] = tirages_aleatoires_uniformes(n_tirages,taille)

    tirages_angles = pi*rand(1,n_tirages)-pi/2;

    % Tirages aleatoires de points pour se trouver sur la droite (sur [-20,20])
    tirages_G = 2*taille*rand(2,n_tirages)-taille*ones(2,n_tirages); % A MODIFIER DANS L'EXERCICE 2

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

% Fonction estimation_Dyx_MC (exercice_1.m) -------------------------------
function [a_Dyx,b_Dyx] = ...
                   estimation_Dyx_MC(x_donnees_bruitees,y_donnees_bruitees)

    A = [x_donnees_bruitees',ones(length(x_donnees_bruitees),1)];
    B = y_donnees_bruitees';
    X = (A'*A)\(A'*B); 
    a_Dyx = X(1); b_Dyx = X(2);  
end

% Fonction estimation_Dyx_MV_2droites (exercice_2.m) -----------------------------------
function [a_Dyx_1,b_Dyx_1,a_Dyx_2,b_Dyx_2] = ... 
         estimation_Dyx_MV_2droites(x_donnees_bruitees,y_donnees_bruitees,sigma, ...
                                    tirages_G_1,tirages_psi_1,tirages_G_2,tirages_psi_2)    

    n = length(x_donnees_bruitees);
    n_tirages = length(tirages_G_1);

    tanpsi_1 = tan(tirages_psi_1);
    tanpsi_2 = tan(tirages_psi_2);
    y_donnees_bruitees_centrees_1 = ones(n_tirages,1)*y_donnees_bruitees - tirages_G_1(2,:)'*ones(1,n);
    y_donnees_bruitees_centrees_2 = ones(n_tirages,1)*y_donnees_bruitees - tirages_G_2(2,:)'*ones(1,n);
    x_donnees_bruitees_centrees_1 = ones(n_tirages,1)*x_donnees_bruitees - tirages_G_1(1,:)'*ones(1,n);
    x_donnees_bruitees_centrees_2 = ones(n_tirages,1)*x_donnees_bruitees - tirages_G_2(1,:)'*ones(1,n);
    residus_1 = y_donnees_bruitees_centrees_1 - (tanpsi_1'*ones(1,n)).*x_donnees_bruitees_centrees_1;
    residus_2 = y_donnees_bruitees_centrees_2 - (tanpsi_2'*ones(1,n)).*x_donnees_bruitees_centrees_2;

    D = log(exp(-residus_1.^2/(2*sigma^2)) + exp(-residus_2.^2/(2*sigma^2)));
    [~,indice] = max(sum(D,2));
    a_Dyx_1 = tanpsi_1(indice);
    b_Dyx_1 = tirages_G_1(2,indice) - a_Dyx_1*tirages_G_1(1,indice);
    a_Dyx_2 = tanpsi_2(indice);
    b_Dyx_2 = tirages_G_2(2,indice) - a_Dyx_2*tirages_G_2(1,indice);

end

% Fonction probabilites_classe (exercice_3.m) ------------------------------------------
function [probas_classe_1,probas_classe_2] = probabilites_classe(x_donnees_bruitees,y_donnees_bruitees,sigma,...
                                                                 a_1,b_1,proportion_1,a_2,b_2,proportion_2)
    residus_1 = y_donnees_bruitees - a_1*x_donnees_bruitees - b_1;
    residus_2 = y_donnees_bruitees - a_2*x_donnees_bruitees - b_2;
    probas_classe_1 = proportion_1*exp(-residus_1.^2/(2*sigma^2));
    probas_classe_2 = proportion_2*exp(-residus_2.^2/(2*sigma^2));
end

% Fonction classification_points (exercice_3.m) ----------------------------
function [x_classe_1,y_classe_1,x_classe_2,y_classe_2] = classification_points ...
              (x_donnees_bruitees,y_donnees_bruitees,probas_classe_1,probas_classe_2)

    x_classe_1 = x_donnees_bruitees(probas_classe_1 > probas_classe_2);
    y_classe_1 = y_donnees_bruitees(probas_classe_1 > probas_classe_2);
    x_classe_2 = x_donnees_bruitees(probas_classe_1 <= probas_classe_2);
    y_classe_2 = y_donnees_bruitees(probas_classe_1 <= probas_classe_2);
end

% Fonction estimation_Dyx_MCP (exercice_4.m) -------------------------------
function [a_Dyx,b_Dyx] = estimation_Dyx_MCP(x_donnees_bruitees,y_donnees_bruitees,probas_classe)
    n = length(x_donnees_bruitees);
    A = [x_donnees_bruitees'.*probas_classe' , probas_classe'];
    B = y_donnees_bruitees'.*probas_classe';
    X = A\B;
    a_Dyx = X(1);
    b_Dyx = X(2);   
end

% Fonction iteration_estimation_Dyx_EM (exercice_4.m) ---------------------
function [probas_classe_1,proportion_1,a_1,b_1,probas_classe_2,proportion_2,a_2,b_2] =...
         iteration_estimation_Dyx_EM(x_donnees_bruitees,y_donnees_bruitees,sigma,...
         proportion_1,a_1,b_1,proportion_2,a_2,b_2)

    n = length(x_donnees_bruitees);
    [probas_classe_1,probas_classe_2] = probabilites_classe(x_donnees_bruitees,y_donnees_bruitees,sigma,...
                                                            a_1,b_1,proportion_1,a_2,b_2,proportion_2);
    proportion_1 = sum(probas_classe_1)/n;
    proportion_2 = sum(probas_classe_2)/n;
    [a_1,b_1] = estimation_Dyx_MCP(x_donnees_bruitees,y_donnees_bruitees,probas_classe_1);
    [a_2,b_2] = estimation_Dyx_MCP(x_donnees_bruitees,y_donnees_bruitees,probas_classe_2);
end
