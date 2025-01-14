#include <stdio.h>    /* entrées/sorties */
#include <unistd.h>   /* primitives de base : fork, ...*/
#include <stdlib.h>   /* exit */
#include <signal.h>   /* traitement des signaux */

#define MAX_PAUSES 10     /* nombre d'attentes maximum */

void handler_sigint(int sig) {
	printf("Signal %d reçu par %d\n", sig, getpid());
}

int main(int argc, char *argv[]) {
	struct sigaction mon_action;
	int i, ret;
	
	mon_action.sa_handler = handler_sigint;
	sigemptyset(&mon_action.sa_mask);
	mon_action.sa_flags = 0;

	for (int i = 1; i <= SIGRTMAX; i++) {
		ret = sigaction(i, &mon_action, NULL);
	}

	int nbPauses;
	
	nbPauses = 0;
	printf("Processus de pid %d\n", getpid());
	for (nbPauses = 0 ; nbPauses < MAX_PAUSES ; nbPauses++) {
		pause();		// Attente d'un signal
		printf("pid = %d - NbPauses = %d\n", getpid(), nbPauses);
    } ;
    return EXIT_SUCCESS;
}
