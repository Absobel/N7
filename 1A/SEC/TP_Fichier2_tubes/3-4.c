#include <stdio.h>    /* entrées sorties */
#include <unistd.h>   /* pimitives de base : fork, ...*/
#include <stdlib.h>   /* exit */
#include <sys/wait.h> /* wait */
#include <string.h>   /* opérations sur les chaines */
#include <fcntl.h>    /* opérations sur les fichiers */

#define LECTURE 0
#define ECRITURE 1

#define N 3

void handler(int sig) {
    printf("signal %d\n", sig);
}

int main() {
    for (int i = 0; i < 32; i++) {
        signal(i, handler);
    }

    int arr[N];
    for (int i = 0; i < N; i++) {
        arr[i] = i;
    }

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
        wait(NULL);
        for (int i = 0; i < 10*N; i++) {
            char char_read;
            int r = read(pipefd[SORTIE], &char_read, 1);
            if (r == -1) {
                perror("read");
                exit(1);
            } else if (r == 0) {
                perror("pipe vide");
                exit(1);
            }
            printf("%c ", char_read);
        }
        printf("\n");
        close(pipefd[SORTIE]);
    } else {
        close(pipefd[SORTIE]); 
        while (1) {
            int w;
            for (int i = 0; i < N; i++) {
                char* entier = calloc(N/10+1, sizeof(char));
                sprintf(entier, "%d", arr[i]);
                w = write(pipefd[ENTREE], entier, N/10);
                if (w == -1) {
                    perror("write");
                    exit(1);
                }
            }
            printf("w = %d\n", w);
            close(pipefd[ENTREE]);
        }
    }
}