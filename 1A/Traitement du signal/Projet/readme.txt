README : PROJET TRAITEMENT DU SIGNAL
AUTEURS : Ayoub Diouri et Absobel

Fichiers rendus :
- readme.txt :             ce fichier
- modem_filtrage.m :       modulateur/démodulateur par filtrage
- modem_V21 :              modulateur/démodulateur V21
- modem_V21_phase :        modulateur/démodulateur V21 avec gestion d'un problème de synchronisation de phase porteuse
- demoduler.m :            fonction de démodulation V21 avec phase utilisée dans images.m
- reconstitution_image.m : fonction fournie permettant de reconstituer une image à partir d'un signal de bits
- images.m :               reconstitution de six parties d'une image à partir de six signaux utilisant le modem V21 avec gestion de phase

Fonctionnement :

Les trois fichiers modems sont utilisables de la même façon. Les paramètres changeables sont au début du fichiers et sont les suivants :
Fe : Fréquence d'échantillonage
Rb : Débit binaire
Nbits : Nombre de bits à transmettre
F0 : Fréquence des bits à 0 
F1 : Fréquence des bits à 0 

Le résultat, signal décodé et taux d'erreur est en fin de fichier. Il est accessible en enlevant le point virgule pour afficher les résultats.

Le fichier images.m permet de reconstituer une image à partir de six signaux de bits appelés fichieri.mat fournis avec le projet. Le résultat est affiché dans une fenêtre.