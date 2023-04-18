#include <stdio.h>    /* entrées sorties */
#include <unistd.h>   /* pimitives de base : fork, ...*/
#include <stdlib.h>   /* exit */
#include <sys/wait.h> /* wait */
#include <string.h>   /* opérations sur les chaines */
#include <fcntl.h>    /* opérations sur les fichiers */

#define LECTURE 0
#define ECRITURE 1

int main() {
    int pipefd[2];

    if (pipe(pipefd)) {
        perror("pipe");
        exit(1);
    }

    pid_t pid = fork();
    if (pid == -1) {
        perror("fork");
        exit(1);
    }
    if (pid == 0) {
        close(pipefd[ENTREE]);
        char char_read;
        int r = read(pipefd[SORTIE], &char_read, 1);
        while (r > 0) {
            if (r == -1) {
                perror("read");
                exit(1);
            } else if (r == 0) {
                perror("fichier vide");
                exit(1);
            }
            printf("char_read = %c | r = %d\n", char_read, r);
            r = read(pipefd[SORTIE], &char_read, 1);
        }
        printf("\n sortie de boucle\n");
        close(pipefd[SORTIE]);
    } else {
        close(pipefd[SORTIE]); 
        for (char i = '0'; i <= '9'; i++) {
            write(pipefd[ENTREE], &i, 1);
        }
        close(pipefd[ENTREE]);

        wait(NULL);
        exit(0);
    }
}