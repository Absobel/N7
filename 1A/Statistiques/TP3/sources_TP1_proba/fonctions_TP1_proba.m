
% TP1 de Probabilites : fonctions a completer et rendre sur Moodle
% Nom :
% Prénom : 
% Groupe : 1SN-

function varargout = fonctions_TP1_proba(nom_fonction, varargin)

    switch nom_fonction
        case 'G_et_R_moyen'
            [varargout{1},varargout{2},varargout{3}] = G_et_R_moyen(varargin{:});
        case 'tirages_aleatoires_uniformes'
            [varargout{1},varargout{2}] = tirages_aleatoires_uniformes(varargin{:});
        case 'estimation_C'
            varargout{1} = estimation_C(varargin{:});
        case 'estimation_C_et_R'
            [varargout{1},varargout{2}] = estimation_C_et_R(varargin{:});
        case 'occultation_donnees'
            [varargout{1},varargout{2}] = occultation_donnees(varargin{:});
    end

end

% Fonction G_et_R_moyen (exercice_0.m) ------------------------------------
function [G, R_moyen, distances] = ...
                        G_et_R_moyen(x_donnees_bruitees,y_donnees_bruitees)



end

% Fonction tirages_aleatoires (exercice_1.m) ------------------------------
function [tirages_C,tirages_R] = tirages_aleatoires_uniformes(n_tirages,G,R_moyen)
    


end

% Fonction estimation_C (exercice_1.m) ------------------------------------
function C_estime = estimation_C(x_donnees_bruitees,y_donnees_bruitees,tirages_C,R_moyen)



end

% Fonction estimation_C_et_R (exercice_2.m) -------------------------------
function [C_estime, R_estime] = ...
         estimation_C_et_R(x_donnees_bruitees,y_donnees_bruitees,tirages_C,tirages_R)



end

% Fonction occultation_donnees (donnees_occultees.m) ----------------------
function [x_donnees_bruitees_visibles, y_donnees_bruitees_visibles] = ...
         occultation_donnees(x_donnees_bruitees, y_donnees_bruitees, ...
                             theta_donnees_bruitees, theta_1, theta_2)
    


end

