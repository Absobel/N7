/* version 0.2.2 (PM, 16/5/22) :
	Le serveur de conversation
	- crée un tube (fifo) d'écoute (avec un nom fixe : ./ecoute)
	- gère un maximum de maxParticipants conversations : attente (select) sur
		* tube d'écoute : accepter le(s) nouveau(x) participant(s) si possible
			-> initialiser et ouvrir les tubes de service (entrée/sortie) fournis
		* tubes (fifo) de service en entrée -> diffuser sur les tubes de service en sortie
	- détecte les déconnexions lors du select
	- se termine lorsqu'un client de pseudo "fin" se connecte
	Protocole
	- suppose que les clients ont créé les tubes d'entrée/sortie avant la demande de connexion,
		et que ces tubes sont nommés par le nom du client, suffixé par _C2S/_S2C.
	- les échanges par les tubes se font par blocs de taille fixe, dans l'idée d'éviter
	  le mode non bloquant
*/

#include <unistd.h>
#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <fcntl.h>

#include <stdbool.h>
#include <sys/stat.h>
#include <sys/select.h>

#define MAXPARTICIPANTS 5		/* seuil au delà duquel la prise en compte de nouvelles
								 						 	   connexions sera différée */
#define TAILLE_MSG 128			/* nb caractères message complet (nom+texte) */
#define TAILLE_NOM 25			/* nombre de caractères d'un pseudo */
#define NBDESC FD_SETSIZE-1		/* pour le select (macros non definies si >= FD_SETSIZE) */
#define TAILLE_RECEPTION 512	/* capacité du tampon de messages reçus */

typedef struct ptp { 			/* descripteur de participant */
    bool actif; /* indique si le descripteur correspond à un client effectivement connecté */
    char nom [TAILLE_NOM];    /* nom du participant */
    int in;		/* tube d'entrée (C2S) */
    int out;	/* tube de sortie (S2C) */
} participant;


participant participants [MAXPARTICIPANTS];

char buf[TAILLE_RECEPTION]; 	/* tampon de messages reçus/à rediffuser */
int nbactifs = 0;				/* nombre de clients effectivement connectés */

void effacer(int i) { /* efface le descripteur pour le participant i */
    participants[i].actif = false;
    bzero(participants[i].nom, TAILLE_NOM*sizeof(char));
    participants[i].in = -1;
    participants[i].out = -1;
}

/* diffuser : diffuse le message référencé par dep à tous les actifs
	- dep : message à diffuser
*/
void diffuser(char *dep) { 
	/* envoi du message référencé par dep à tous les actifs */
	dep[strcspn(dep, "\n")] = 0; // enlève le \n a la fin du message
	for (int i = 0; i < MAXPARTICIPANTS; i++) {
		if (participants[i].actif) {
			write(participants[i].out, dep, strlen(dep));
		}
	}
}

/* ajouter : ajoute un nouveau participant, part du principe que c'est possible
	- dep : nom du participant à ajouter
	- si dep == "fin", le serveur se termine
*/
void ajouter(char *dep) { 
	char c2s[TAILLE_NOM+5];
	char s2c[TAILLE_NOM+5];

	if (strcmp(dep,"fin")==0) {
		unlink("./ecoute");		/* suppression du tube d'écoute */
		exit(0);
	} else {
		for (int i = 0; i < MAXPARTICIPANTS; i++) {         // on cherche un descripteur de participant libre
			if (!participants[i].actif) {
				sprintf(c2s, "./%s_c2s", dep);
				sprintf(s2c, "./%s_s2c", dep);

				participants[i].actif = true;
				strcpy(participants[i].nom, dep);
				participants[i].out = open(s2c, O_WRONLY);
				participants[i].in = open(c2s, O_RDONLY);
			
				nbactifs++;
				memset(buf, 0, TAILLE_RECEPTION);
				sprintf(buf, "[service] %s rejoint la discussion.", dep);
				diffuser(buf);

				break;
			}
		}
	}
}

/* desactiver : désactive le participant p
	- p : indice du participant à désactiver
*/
void desactiver (int p) {
	nbactifs--;
	memset(buf, 0, TAILLE_RECEPTION);
	sprintf(buf, "[service] %s quitte la discussion.", participants[p].nom);
	effacer(p);  // effacer le descripteur du participant p avant que le message soit diffusé
	diffuser(buf);
}

int main () {
    int i,nlus;
    int ecoute;				/* descripteur d'écoute */
    fd_set readfds; 		/* ensemble de descripteurs écoutés par le select */
    char * prochainMessage; /* pour parcourir le contenu du tampon de réception */
	char bufDemandes [TAILLE_NOM*sizeof(char)*MAXPARTICIPANTS]; 
	/* tampon requêtes de connexion. Inutile de lire plus de MAXPARTICIPANTS requêtes */

    /* création (puis ouverture) du tube d'écoute */
    mkfifo("./ecoute",S_IRUSR|S_IWUSR); // mmnémoniques sys/stat.h: S_IRUSR|S_IWUSR = 0600
    ecoute=open("./ecoute",O_RDONLY);

	/* initialisation des descripteurs de participants */
    for (i=0; i< MAXPARTICIPANTS; i++) {
        effacer(i);
    }
	
	/* (**** à faire [éventuellement] ****) : autres initialisations */
    while (true) {
        printf("participants actifs : %d\n",nbactifs);
	/* boucle du serveur : traiter les requêtes en attente 
				 * 	sur le tube d'écoute : ajouter de nouveaux participants 
				 	(tant qu'il y a moins de MAXPARTICIPANTS actifs)
				 * 	sur les tubes d'entrée : lire les messages, et les diffuser.
		   			Note : 
		   			- tous les messages comportent TAILLE_MSG caractères, et les tailles sont
		   			  fixées pour qu'il n'y ait pas de message tronqué, pour simplifier la gestion. 
		   			- un tampon peut contenir plusieurs messages (et prochainMessage est destiné
				  	  à repérer le prochain message du tampon du tube c2s à diffuser)
					- Enfin, on ne traite pas plus de TAILLE_RECEPTION/TAILLE_MSG*sizeof(char)
					  à chaque itération.
    				- dans le cas où la terminaison d'un participant est détectée, gérer sa déconnexion
    				- Attention : le serveur doit fonctionner même lorsqu'aucun client n'est
    				 connecté (de nouveaux clients peuvent se connecter à tout moment)
	*/
		FD_ZERO(&readfds);
		FD_SET(ecoute, &readfds);
		for (int i = 0; i < MAXPARTICIPANTS; i++) {
			if (participants[i].actif) {
				FD_SET(participants[i].in, &readfds);
			}
		}

		int ret_select = select(NBDESC, &readfds, NULL, NULL, NULL);
		if (ret_select == -1) {
			perror("select_ecoute");
			exit(1);
		}
		memset(bufDemandes, 0, sizeof(bufDemandes));   // Vider le buffer pour enlever le texte résiduel
		if (nbactifs < MAXPARTICIPANTS && FD_ISSET(ecoute, &readfds) && read(ecoute, bufDemandes, sizeof(bufDemandes)) > 0) {
			ajouter(bufDemandes); 
		}

		for (int i = 0; i < MAXPARTICIPANTS; i++) {
			if (participants[i].actif && FD_ISSET(participants[i].in, &readfds)) {
				memset(buf, 0, TAILLE_RECEPTION);
				// Tout lire dans buf
				if ((nlus = read(participants[i].in, buf, TAILLE_RECEPTION)) == -1) {
					perror("read");
					exit(1);
				} else if (nlus == 0) {  // EOF du client
					desactiver(i);
					continue;
				}

				// Traiter chacun des messages individuellement
				int j = 0;
				while (j*TAILLE_MSG*sizeof(char) < (long unsigned int) nlus) {
					prochainMessage = buf + j*TAILLE_MSG*sizeof(char);
					char message_a_diffuser[TAILLE_MSG+TAILLE_NOM+3];
					memset(message_a_diffuser, 0, sizeof(message_a_diffuser));
					sprintf(message_a_diffuser, "[%s] %s", participants[i].nom, prochainMessage);
					diffuser(message_a_diffuser);

					j++;
				}
			}
		}
    }
}