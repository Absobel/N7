#include <stdio.h>    /* entrées sorties */
#include <unistd.h>   /* pimitives de base : fork, ...*/
#include <stdlib.h>   /* exit */
#include <sys/wait.h> /* wait */
#include <string.h>   /* opérations sur les chaines */
#include <fcntl.h>    /* opérations sur les fichiers */

#define BUFSIZE 32
#define ERR_CREATE_FILE 1
#define ERR_READ_FILE 2
#define ERR_MEMORY_ALLOCATION 3
#define ERR_FORK 4
#define ERR_WRITE_FILE 5
#define ERR_LSEEK 6

void traitement_erreurs(int code_erreur) {
    switch (code_erreur) {
        case ERR_CREATE_FILE:
            perror("Erreur lors de la création du fichier");
            exit(1);
        case ERR_READ_FILE:
            perror("Erreur lors de la lecture du fichier");
            exit(1);
        case ERR_MEMORY_ALLOCATION:
            perror("Erreur lors de l'allocation de mémoire");
            exit(1);
        case ERR_FORK:
            perror("Erreur lors du fork");
            exit(1);
        case ERR_WRITE_FILE:
            perror("Erreur lors de l'écriture du fichier");
            exit(1);
        case ERR_LSEEK:
            perror("Erreur lors du lseek");
            exit(1);
    }
}

char* to_string(int i) {
    char* str = malloc(10);
    traitement_erreurs(str == NULL ? ERR_MEMORY_ALLOCATION : 0);
    sprintf(str, "%d", i);
    return str;
}

void print_file(int desc) {
    char buf[32];
    int nb_octets_lus = read(desc, buf, 1);
    traitement_erreurs(nb_octets_lus == -1 ? ERR_READ_FILE : 0);
    while (nb_octets_lus > 0) {
        if (nb_octets_lus < 1) {
            buf[nb_octets_lus] = '\0';
        }
        printf("%s", buf);
        nb_octets_lus = read(desc, buf, 1);
        traitement_erreurs(nb_octets_lus == -1 ? ERR_READ_FILE : 0);
    }
    off_t offset = lseek(desc, 0, SEEK_SET);
    traitement_erreurs(offset == -1 ? ERR_LSEEK : 0);
    printf("\n");
}

int main() {
    int pid = fork();
    traitement_erreurs(pid == -1 ? ERR_FORK : 0);

    if (pid == 0) {
        int desc = open("temp", O_WRONLY|O_CREAT|O_TRUNC, 0640);
        traitement_erreurs(desc == -1 ? ERR_CREATE_FILE : 0);
        int compteur = 1;
        for (int i=0; i<3; i++) {
            for (int i=0; i<10; i++) {
                char* buf = to_string(compteur);
                int nb_octets_ecrits = write(desc, buf, strlen(buf));
                traitement_erreurs(nb_octets_ecrits == -1 ? ERR_WRITE_FILE : 0);
                int nb_octets_ecrits2 = write(desc, "\n", 1);
                traitement_erreurs(nb_octets_ecrits2 == -1 ? ERR_WRITE_FILE : 0);
                free(buf);
                compteur++;

                sleep(1);
            }
            off_t offset = lseek(desc, 0, SEEK_SET);
            traitement_erreurs(offset == -1 ? ERR_LSEEK : 0);
        }
        close(desc);
    } else {
        int desc = open("temp", O_RDONLY);
        while (1) {
            sleep(5);
            print_file(desc);
        }
        close(desc);
    }
}