function [moyennes,ecarts_types] = estimation_lois(liste_parametres)
    moyennes = mean(liste_parametres,2);
    ecarts_types = std(liste_parametres,0,2);
end