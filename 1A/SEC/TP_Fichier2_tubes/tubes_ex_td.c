#include <stdio.h>    /* entrées sorties */
#include <unistd.h>   /* pimitives de base : fork, ...*/
#include <stdlib.h>   /* exit */
#include <sys/wait.h> /* wait */
#include <string.h>   /* opérations sur les chaines */
#include <fcntl.h>    /* opérations sur les fichiers */

void main() {
    int pipefd[2];
    pid_t cpid;
    char buf;

    if (pipe(pipefd)) {
        perror("pipe");
        exit(EXIT_FAILURE);
    }
    cpid = fork();
    if (cpid == -1) {
        perror("fork");
        exit(EXIT_FAILURE);
    }

    if (cpid == 0) {
        close(pipefd[0]);          /* Fermeture de l'extrémité de lecture */
        for (int i = 1; i < 10; i++) {
            char c = i + '0';
            write(pipefd[1], &c, 1);
            write(pipefd[1], " ", 1);
        }
        close(pipefd[1]);          /* Fermeture de l'extrémité d'écriture */
    } else {
        close(pipefd[1]);          /* Fermeture de l'extrémité d'écriture */
        sleep(2);
        int somme = 0;
        while (read(pipefd[0], &buf, 1) > 0)
            somme += atoi(&buf);
        printf("Somme : %d\n", somme);
        close(pipefd[0]);         /* Fermeture de l'extrémité de lecture */
    }

}