#include <stdio.h>    /* entrées sorties */
#include <unistd.h>   /* pimitives de base : fork, ...*/
#include <stdlib.h>   /* exit */
#include <sys/wait.h> /* wait */
#include <string.h>   /* opérations sur les chaines */
#include <fcntl.h>    /* opérations sur les fichiers */

#define SORTIE 0
#define ENTREE 1

void traitement_error_fork(pid_t pid) {
    if (pid == -1) {
        perror("fork");
        exit(1);
    }
}

// equivalent of who | grep <nom_utilisateur> | wc -l
int main(int argc, char* argv[]) {
    if (argc != 2) {
        perror("usage: ./a.out <nom_utilisateur>");
        exit(1);
    }

    int p1[2];
    int p2[2];

    if (pipe(p1)) {
        perror("pipe entre who et grep");
        exit(1);
    }
    if (pipe(p2)) {
        perror("pipe entre grep et wc");
        exit(1);
    }

    pid_t pid2 = fork();
    traitement_error_fork(pid2);
    if (pid2 == 0) {        // exec who
        close(p1[SORTIE]);
        close(p2[ENTREE]);
        close(p2[SORTIE]);
        dup2(p1[ENTREE], STDOUT_FILENO);
        execlp("who", "who", NULL);
        perror("exec");
        exit(1);
    } else {
        close(p1[ENTREE]);
        pid_t pid = fork();
        traitement_error_fork(pid);
        if (pid == 0) {             // exec grep
            close(p1[ENTREE]);
            close(p2[SORTIE]);
            dup2(p1[SORTIE], STDIN_FILENO);
            dup2(p2[ENTREE], STDOUT_FILENO);
            execlp("grep", "grep", argv[1], NULL);
            perror("exec");
            exit(1);
        } else {
            close(p1[SORTIE]);
            close(p2[ENTREE]);
            pid_t pid3 = fork();
            traitement_error_fork(pid3);
            if (pid3 == 0) {        // exec wc
                close(p1[ENTREE]);
                close(p1[SORTIE]);
                close(p2[ENTREE]);
                dup2(p2[SORTIE], STDIN_FILENO);
                execlp("wc", "wc", "-l", NULL);
                perror("exec");
                exit(1);
            } else {
                close(p2[SORTIE]);
                exit(0);
            }
        }
    }
}