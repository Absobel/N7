#include <stdio.h> /* printf */
#include <unistd.h> /* fork */
#include <stdlib.h> /* EXIT_SUCCESS */

int main () {
    fork(); printf("fork i : processus %d, de père %d\n", getpid(), getppid());
    fork(); printf("fork i : processus %d, de père %d\n", getpid(), getppid());
    fork(); printf("fork i : processus %d, de père %d\n", getpid(), getppid());

    sleep(1);
    return EXIT_SUCCESS ;
}