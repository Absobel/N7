#include <stdio.h>
#include <unistd.h>
#include <stdlib.h>
#include <sys/wait.h> /* wait */

int main(int argc, char *argv[]) {
    if (argc != 2) {
        printf("Usage: ./test_exec <nom du fichier>\n");
    } else {
    execlp("ls", "-l", "argv[1]", NULL);
    exit(EXIT_SUCCESS);
}}