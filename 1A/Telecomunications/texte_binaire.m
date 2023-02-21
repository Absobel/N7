%Texte à transmettre
texte='Ceci est un exemple pour les TP de télécom de 1A SN,  même s''il n''est pas très long. Avec un texte encore plus long on aurait plus de chance d''avoir des bits équiprobables, mais jusqu''à combien de caractères faut-il écrire pour se rapprocher de 0.5 ...?';
%Passage du texte à une suite de bits
bits_texte = str2bin(texte).';
%TRANSMISSION
    %...
    bits_retrouves=bits_texte;
%Récupération du texte à partir des bits récupérés
texte_retrouve = bin2str(bits_retrouves)

