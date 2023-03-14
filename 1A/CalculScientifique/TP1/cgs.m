%--------------------------------------------------------------------------
% ENSEEIHT - 1SN - Calcul scientifique
% TP1 - Orthogonalisation de Gram-Schmidt
% cgs.m
%--------------------------------------------------------------------------

function Q = cgs(A)

    % Recuperation du nombre de colonnes de A
    [~, m] = size(A);
    
    % Initialisation de la matrice Q avec la matrice A
    Q = A;
    
    %------------------------------------------------
    % A remplir
    % Algorithme de Gram-Schmidt classique
    %------------------------------------------------
    
    Q(:,1) = A(:,1)/norm(A(:,1));
    for j = 2:m
        sum = 0;
        for i = 1:j-1
            sum = sum + dot(Q(:,i),A(:,j))*Q(:,i);  % dot()
            %sum = sum + (Q(:,i)'*A(:,j))*Q(:,i);  % produit scalaire
        end
        Q(:,j) = A(:,j) - sum;
        Q(:,j) = Q(:,j)/norm(Q(:,j));
    end
end