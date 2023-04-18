#include <stdio.h>
#include <unistd.h>
#include <stdlib.h>
#include <sys/wait.h>
#include <fcntl.h>

#define ERR_CREATE_FILE 1
#define ERR_READ_FILE 2
#define ERR_FORK 3
#define ERR_WRITE_FILE 4
#define ERR_LSEEK 5

void traitement_erreurs(int code_erreur) {
    switch (code_erreur) {
        case ERR_CREATE_FILE:
            perror("Erreur lors de la création du fichier");
            exit(1);
        case ERR_READ_FILE:
            perror("Erreur lors de la lecture du fichier");
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

void print_file(int desc) {
    int buf;
    ssize_t nb_octets_lus = read(desc, &buf, sizeof(int));
    traitement_erreurs(nb_octets_lus == -1 ? ERR_READ_FILE : 0);
    while (nb_octets_lus > 0) {
        printf("%d\n", buf);
        nb_octets_lus = read(desc, &buf, sizeof(int));
        traitement_erreurs(nb_octets_lus == -1 ? ERR_READ_FILE : 0);
    }
    off_t offset = lseek(desc, 0, SEEK_SET);
    traitement_erreurs(offset == -1 ? ERR_LSEEK : 0);
}

int main() {
    int pid = fork();
    traitement_erreurs(pid == -1 ? ERR_FORK : 0);

    if (pid == 0) {
        int desc = open("temp", O_WRONLY | O_CREAT | O_TRUNC, 0640);
        traitement_erreurs(desc == -1 ? ERR_CREATE_FILE : 0);
        int compteur = 1;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 10; j++) {
                ssize_t nb_octets_ecrits = write(desc, &compteur, sizeof(int));
                traitement_erreurs(nb_octets_ecrits == -1 ? ERR_WRITE_FILE : 0);
                compteur++;
                sleep(1);
            }
            off_t offset = lseek(desc, 0, SEEK_SET);
            traitement_erreurs(offset == -1 ? ERR_LSEEK : 0);
        }
        close(desc);
    } else {
        int desc = open("temp", O_RDONLY);
        int compteur_temps = 0;
        while (compteur_temps < 35) {
            sleep(5);
            compteur_temps += 5;
            print_file(desc);
        }
        close(desc);
    }
}
