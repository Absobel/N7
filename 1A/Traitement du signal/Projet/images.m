% PARAMÈTRES

Fe = 48000;          % Fréquence d'échantillonage
Rb = 300;            % Débit binaire
Nbits = 1000;        % Nombre de bits à transmettre
F0 = 1180;           % Fréquence des bits à 0 
F1 = 980;            % Fréquence des bits à 0 

theta0 = rand*2*pi; theta1 = rand*2*pi;


load 'FICHIERS POUR ELEVES IMAGES/fichier1.mat';
img1 = demoduler(signal,Fe,Rb,F0,F1,theta0,theta1);
load 'FICHIERS POUR ELEVES IMAGES/fichier2.mat';
img2 = demoduler(signal,Fe,Rb,F0,F1,theta0,theta1);
load 'FICHIERS POUR ELEVES IMAGES/fichier3.mat';
img3 = demoduler(signal,Fe,Rb,F0,F1,theta0,theta1);
load 'FICHIERS POUR ELEVES IMAGES/fichier4.mat';
img4 = demoduler(signal,Fe,Rb,F0,F1,theta0,theta1);
load 'FICHIERS POUR ELEVES IMAGES/fichier5.mat';
img5 = demoduler(signal,Fe,Rb,F0,F1,theta0,theta1);
load 'FICHIERS POUR ELEVES IMAGES/fichier6.mat';
img6 = demoduler(signal,Fe,Rb,F0,F1,theta0,theta1);

nimg1 = reconstitution_image(img1);
nimg2 = reconstitution_image(img2);
nimg3 = reconstitution_image(img3);
nimg4 = reconstitution_image(img4);
nimg5 = reconstitution_image(img5);
nimg6 = reconstitution_image(img6);

img_total = [nimg6 nimg1 nimg5;...
             nimg2 nimg4 nimg3];
image(img_total);