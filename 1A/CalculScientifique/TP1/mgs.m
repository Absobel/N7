%--------------------------------------------------------------------------
% ENSEEIHT - 1SN - Calcul scientifique
% TP1 - Orthogonalisation de Gram-Schmidt
% mgs.m
%--------------------------------------------------------------------------

function Q = mgs(A)

    % Recuperation du nombre de colonnes de A
    [~, m] = size(A);
    
    % Initialisation de la matrice Q avec la matrice A
    Q = A;
    
    %------------------------------------------------
    % A remplir
    % Algorithme de Gram-Schmidt modifie
    %------------------------------------------------

    for j = 1:m
        Q(:,j) = Q(:,j)/norm(Q(:,j));
        for i = j+1:m
            Q(:,i) = Q(:,i) - dot(Q(:,j),Q(:,i))*Q(:,j);  % dot()
            %Q(:,i) = Q(:,i) - (Q(:,j)'*Q(:,i))*Q(:,j);  % produit scalaire
        end
    end

end