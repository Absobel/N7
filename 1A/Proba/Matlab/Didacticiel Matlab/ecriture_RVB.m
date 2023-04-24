
% Fonction ecriture_RVB ---------------------------------------------------

function image_RVB = ecriture_RVB(image_originale)
    
    [nb_ligne,nb_colonne] = size(image_originale);
    nb_ligne = round(nb_ligne/2);
    nb_colonne = round(nb_colonne/2);
    res = zeros(nb_ligne,nb_colonne,3);

    for i = 1:nb_ligne
        for j = 1:nb_colonne
            V1 = image_originale(2*i-1,2*j-1);
            R = image_originale(2*i-1,2*j);
            V2 = image_originale(2*i,2*j-1);
            B = image_originale(2*i,2*j);
            res(i,j,:) = cat(3,R,(V1+V2)/2,B);
        end
    end

    image_RVB = res;
end