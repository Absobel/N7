#define SIZE_BUFFER 30
#define SIZE_COMMAND 10

#include <stdio.h>
#include <string.h>
#include <unistd.h>
#include <stdlib.h>
#include <sys/wait.h> /* wait */

void parse_command(char input[], char* (*arguments)[]) {
    // Transformation de la chaine de caractères en tableau de mots
    int arg_index = 0;
    char* token = strtok(input, " ");
    while (token != NULL && arg_index < SIZE_COMMAND) {
        (*arguments)[arg_index++] = token;
        token = strtok(NULL, " ");
    }
    (*arguments)[arg_index] = NULL;
}

void empty_stdin() {
    int c = getchar();

    while (c != '\n' && c != EOF)
        c = getchar();
}

int main(int argc, char *argv[]) {
    while (1) {
        char buf[SIZE_BUFFER]; // Contient la commande saisie au clavier
        int ret; // La valeur de retour de scanf
        printf(">>>");
        ret=scanf("%29[^\n]", buf); // Lit et range dans buf la chaine entrée au clavier
/*         printf("### input : %s\n", buf);  */
        empty_stdin(); // Permet d'éviter que le prochain scanf reprenne la saisie de l'input précédent

        if (ret == EOF) {    // Ctrl+D pour quitter
            break;
        } else if (ret == 0) {    // Si l'utilisateur n'a rien saisi
            continue;
        }

        // Initialisation du tableau comprenant la commande et ses arguments
        char* mots[SIZE_COMMAND];
        for (int i = 0; i < SIZE_COMMAND; i++) {
            mots[i] = malloc(SIZE_BUFFER);
            if (mots[i] == NULL) {
                printf("Manque de mémoire");
                exit(1);
            }
        }


        int command_exit_code;
        pid_t pidFils = fork();
        if (pidFils == -1) {
            printf("Erreur fork");
            exit(1);
        }
        if (pidFils == 0) { // Fils
            parse_command(buf, &mots);

/*             printf("### command: %s\n", mots[0]);
            printf("### arguments: ");
            for (int i = 1; i < SIZE_COMMAND; i++) {
                if (mots[i] != NULL) {
                    printf("%s ", mots[i]);
                }
            }
            printf("\n"); */

            if (strcmp(mots[0], "exit") == 0) {
                exit(10);
            }

            command_exit_code = execvp(mots[0], mots);
            exit(command_exit_code);
        } else { // Père
            int status;
            wait(&status);

            if (WEXITSTATUS(status) == EXIT_SUCCESS) {
                printf("SUCCESS\n");
            } else if (WEXITSTATUS(status) == 10) {
                break;
            } else {
                printf("ECHEC\n");
            }
        }
    }

    printf("\nSalut.\n");
    return EXIT_SUCCESS;
}