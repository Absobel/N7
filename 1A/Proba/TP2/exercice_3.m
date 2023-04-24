clear;
close all;
clc;

% Lecture d'une image interne a Matlab et conversion en doubles :
I = rgb2gray(imread('autumn.tif'));
I = double(I);

% Codage de Huffman de l'image initiale :
I_encodee = fonctions_TP2_proba('encodage_image',I);

% Calcul du coefficient de compression obtenu par le codage de Huffman :
coeff_compression_avant_decorrelation = fonctions_TP2_proba('coeff_compression',I(:),I_encodee);
fprintf('Coefficient de compression avant decorrelation : %.4f\n',coeff_compression_avant_decorrelation);

% Calcul de l'image decorrelee :
I_decorrelee = fonctions_TP2_proba('decorrelation_colonnes',I);

% Codage de Huffman de l'image decorrelee :
set(0,'RecursionLimit',550);	% Plus de 500 appels recursifs (nombre d'entiers a coder : 2*I_max+1 = 511 > 500)
I_encodee = fonctions_TP2_proba('encodage_image',I_decorrelee);

% Calcul du coefficient de compression obtenu par decorrelation prealable au codage de Huffman :
coeff_compression_apres_decorrelation = fonctions_TP2_proba('coeff_compression',I_decorrelee(:),I_encodee);
fprintf('Coefficient de compression apres decorrelation : %.4f\n',coeff_compression_apres_decorrelation);

% Calcul du gain en compression :
gain_compression_apres_decorrelation = fonctions_TP2_proba('gain_compression', ...
     coeff_compression_avant_decorrelation,coeff_compression_apres_decorrelation);
fprintf('Gain en compression : %.4f\n',gain_compression_apres_decorrelation);
