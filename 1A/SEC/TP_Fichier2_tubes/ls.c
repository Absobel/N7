#include <stdio.h>    /* entrées sorties */
#include <unistd.h>   /* pimitives de base : fork, ...*/
#include <stdlib.h>   /* exit */
#include <sys/wait.h> /* wait */
#include <string.h>   /* opérations sur les chaines */
#include <fcntl.h>    /* opérations sur les fichiers */

void main(int argc, char *argv[]) {
    if (argc != 2) {
        printf("Usage: ls <path>\n");
        exit(1);
    }

    char* path = argv[1];
    int fd = open(path, O_CREAT | O_WRONLY | O_TRUNC, 0666);
    if (fd == -1) {
        perror("open");
        exit(1);
    }

    dup2(fd, 1);

    int res = execlp("ls", "ls", "-lt", NULL);
    close(fd);
    exit(res);
}