#include <stdio.h>    /* entrées sorties */
#include <unistd.h>   /* pimitives de base : fork, ...*/
#include <stdlib.h>   /* exit */
#include <sys/wait.h> /* wait */
#include <string.h>   /* opérations sur les chaines */
#include <fcntl.h>    /* opérations sur les fichiers */

int main() {
    int pipefd[2];

    if (pipe(pipefd)) {
        perror("pipe");
        exit(1);
    }

    char entier = 9 + '0';
    write(pipefd[1], &entier, 1);

    pid_t pid = fork();
    if (pid == -1) {
        perror("fork");
        exit(1);
    }
    if (pid == 0) {
        close(pipefd[1]);
        char char_read;
        int r = read(pipefd[0], &char_read, 1);
        if (r == -1) {
            perror("read");
            exit(1);
        } else if (r == 0) {
            perror("fichier vide");
            exit(1);
        }
        printf("char_read = %c\n", char_read);
        close(pipefd[0]);
    }
}