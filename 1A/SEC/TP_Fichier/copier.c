#include <stdio.h>    /* entrées sorties */
#include <unistd.h>   /* pimitives de base : fork, ...*/
#include <stdlib.h>   /* exit */
#include <sys/wait.h> /* wait */
#include <string.h>   /* opérations sur les chaines */
#include <fcntl.h>    /* opérations sur les fichiers */

#define BUFSIZE 32
#define ERR_OPEN_SOURCE 1
#define ERR_OPEN_DESTINATION 2
#define ERR_LECTURE 3
#define ERR_ECRITURE 4

void traitement_erreurs(int code_erreur) {
    switch (code_erreur) {
        case ERR_OPEN_SOURCE:
            perror("Erreur lors de l'ouverture du fichier source");
            exit(1);
        case ERR_OPEN_DESTINATION:
            perror("Erreur lors de l'ouverture du fichier destination");
            exit(1);
        case ERR_LECTURE:
            perror("Erreur lors de la lecture du fichier source");
            exit(1);
        case ERR_ECRITURE:
            perror("Erreur lors de l'écriture du fichier destination");
            exit(1);
    }
}

int main(int argc, char *argv[]) {
    char buf[BUFSIZE];

    int fichier_source = open(argv[1], O_RDONLY);
    traitement_erreurs(fichier_source == -1 ? ERR_OPEN_SOURCE : 0);
    int fichier_destination = open(argv[2], O_WRONLY | O_CREAT | O_TRUNC, 0640);
    traitement_erreurs(fichier_destination == -1 ? ERR_OPEN_DESTINATION : 0);

    int nb_octets_lus = read(fichier_source, buf, BUFSIZE);
    traitement_erreurs(nb_octets_lus == -1 ? ERR_LECTURE : 0);
    while (nb_octets_lus > 0) {
        if (nb_octets_lus < BUFSIZE) {
            buf[nb_octets_lus] = '\0';
        }
        write(fichier_destination, buf, nb_octets_lus);
        traitement_erreurs(nb_octets_lus == -1 ? ERR_ECRITURE : 0);
        nb_octets_lus = read(fichier_source, buf, BUFSIZE);
        traitement_erreurs(nb_octets_lus == -1 ? ERR_LECTURE : 0);
    }

    close(fichier_source);
    close(fichier_destination);
    return 0;
}