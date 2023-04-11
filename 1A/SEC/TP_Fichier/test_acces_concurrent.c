#include <stdio.h>    /* entrées sorties */
#include <unistd.h>   /* pimitives de base : fork, ...*/
#include <stdlib.h>   /* exit */
#include <sys/wait.h> /* wait */
#include <string.h>   /* opérations sur les chaines */
#include <fcntl.h>    /* opérations sur les fichiers */

int main() {
    

    int pid = fork();
    if (pid == 0) {
        int desc = open("temp.txt", O_WRONLY|O_CREAT|O_TRUNC, 0640);
        for (int i=0; i<10; i++) {
            write(desc, "FILS\n", 5);
            sleep(1);
        }
        close(desc);
    } else {
        int desc = open("temp.txt", O_WRONLY|O_CREAT|O_TRUNC, 0640);
        for (int i=0; i<10; i++) {
            write(desc, "PERE\n", 5);
            sleep(1);
        }
        close(desc);
    }

    
}