#include <stdio.h>    /* entrées/sorties */
#include <unistd.h>   /* primitives de base : fork, ...*/
#include <stdlib.h>   /* exit */
#include <signal.h>   /* traitement des signaux */

#define MAX_PAUSES 10     /* nombre d'attentes maximum */

void handler(int sig) {
    switch (sig) {
        case SIGUSR1: case SIGUSR2:
            printf("Reception %d\n", sig);
            break;
    }
    printf("Reception %d\n", sig);
}

int main(int argc, char *argv[]) {
    struct sigaction mon_action;
	int ret;
	
	mon_action.sa_handler = handler;
    sigemptyset(&mon_action.sa_mask);
	mon_action.sa_flags = 0;

    // Associe le handler aux signaux SIGUSR1 et SIGUSR2
	ret = sigaction(SIGUSR1, &mon_action, NULL);
    ret = sigaction(SIGUSR2, &mon_action, NULL);

    // Masquer les signaux SIGINT et SIGUSR1
    sigaddset(&mon_action.sa_mask, SIGINT);
    sigaddset(&mon_action.sa_mask, SIGUSR1);

    sleep(10);

    kill(getpid(), SIGUSR1);
    kill(getpid(), SIGUSR1);

    sleep(5);

    kill(getpid(), SIGUSR2);
    kill(getpid(), SIGUSR2);

    sigdelset(&mon_action.sa_mask, SIGUSR1);

    sleep(10);

    sigdelset(&mon_action.sa_mask, SIGINT);

	printf("Salut !\n");
	
    return EXIT_SUCCESS;
}
