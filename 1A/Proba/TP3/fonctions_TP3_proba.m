
% TP3 de Probabilites : fonctions a completer et rendre sur Moodle
% Nom :
% Prénom : 
% Groupe : 1SN-

function varargout = fonctions_TP3_proba(nom_fonction,varargin)

    switch nom_fonction
        case 'ensemble_E_recursif'
            [varargout{1},varargout{2},varargout{3}] = ensemble_E_recursif(varargin{:});
        case 'matrice_inertie'
            [varargout{1},varargout{2}] = matrice_inertie(varargin{:});
        case 'calcul_proba'
            [varargout{1},varargout{2},varargout{3}] = calcul_proba(varargin{:});
    end
    
end

% Fonction ensemble_E_recursif (exercie_1.m) ------------------------------
function [E,contour,G_somme] = ...
    ensemble_E_recursif(E,contour,G_somme,i,j,voisins,G_x,G_y,card_max,cos_alpha)

    % Mise à 0 de la valeur contour du pixel courant pour ne pas retourner dessus
    contour(i,j) = 0;
    % Nombre de voisins (ici 8)
    nb_voisins = size(voisins,1);
    % Initialisation du comptage des 8 voisins a parcourir
    k = 1;
    % Parcours des differents voisins si E n'est pas deja trop grand

    while (length(E) <= card_max && k <= 8)
        ij_voisins = [i,j] + voisins(k,:);
        i_voisin = ij_voisins(1);
        j_voisin = ij_voisins(2);
        if contour(i_voisin,j_voisin) == 1
            Gij = [G_x(i_voisin,j_voisin),G_y(i_voisin,j_voisin)];
            norme_Gij = sqrt(sum(Gij.^2));
            norme_G_somme = sqrt(sum(G_somme.^2));
            if Gij*G_somme'/(norme_G_somme*norme_Gij) >= cos_alpha
                E = [E;[i_voisin,j_voisin]];
                G_somme = G_somme + Gij;
                [E,contour,G_somme] = ensemble_E_recursif(E,contour,G_somme,i_voisin,j_voisin,G_x,G_y,card_max,cos_alpha);
            end
        end
        k = k+1;
    end
end

% Fonction matrice_inertie (exercice_2.m) ---------------------------------
function [M_inertie,C] = matrice_inertie(E,G_norme_E) 
    pi_maj = sum(G_norme_E);
    y_C = sum(G_norme_E.*E(:,1))/pi_maj;
    x_C = sum(G_norme_E.*E(:,2))/pi_maj;
    C = [x_C,y_C];
    M_inertie = zeros(2,2);
    M_inertie(1,1) = sum(G_norme_E.*(E(:,2)-x_C).^2)/pi_maj;
    M_inertie(2,2) = sum(G_norme_E.*(E(:,1)-y_C).^2)/pi_maj;
    M_inertie(1,2) = sum(G_norme_E.*(E(:,1)-y_C).*(E(:,2)-x_C))/pi_maj;
    M_inertie(2,1) = M_inertie(1,2);

end

% Fonction calcul_proba (exercice_2.m) ------------------------------------
function [x_min,x_max,probabilite] = calcul_proba(E_nouveau_repere,p)
    x_min = min(E_nouveau_repere(:,1));
    x_max = max(E_nouveau_repere(:,1));
    y_min = min(E_nouveau_repere(:,2));
    y_max = max(E_nouveau_repere(:,2));

    N = floor((y_max-y_min)*(x_max-x_min));
    n = length(E_nouveau_repere);
    
    n-1
    N
    probabilite = 1 - binocdf(n-1,N,p);

    
end
