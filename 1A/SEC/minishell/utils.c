#define _XOPEN_SOURCE 700   // Permet que le compilateur reconnaisse certaines fonctions
#include "utils.h"
#include <stdlib.h>  /* getenv */
#include <string.h> /* strcmp */
#include <unistd.h> /* access */
#include <stdbool.h>  /* booleans */
#include <stdio.h>  /* sprintf */

// Define some color and style codes
#define COLOR_LIGHT_BLUE "\x1b[1;94m"
#define COLOR_RED "\x1b[1;31m"
#define COLOR_DARK_GRAY "\x1b[1;90m"
#define RESET "\x1b[0m"


char* cmd_to_str(char** seqi) {
    int needed_size = 0;
    for (int i = 0; seqi[i]; i++) {
        needed_size += strlen(seqi[i]) + 1; // +1 pour l'espace
    }
    char* str = malloc(needed_size);
    if (!str) {
        return NULL;
    }
    str[0] = '\0'; // Initialise la chaîne à la chaîne vide
    for (int i = 0; seqi[i]; i++) {
        strcat(str, seqi[i]);
        strcat(str, " "); // Ajouter un espace entre chaque arguments
    }
    return str;
}


void checkCommand(char*** seq, char* invalid_cmd) {
    char *path = getenv("PATH");
    char *path_copy = strdup(path); // strtok modifie la chaîne
    char *dir = strtok(path_copy, ":"); // On récupère le premier chemin

    for(int i = 0; seq[i] != NULL; i++) {
        char* cmd_name = seq[i][0]; 

        if(strcmp(cmd_name, "cd") != 0 && strcmp(cmd_name, "fg") != 0 && strcmp(cmd_name, "bg") != 0 
            && strcmp(cmd_name, "sj") != 0 && strcmp(cmd_name, "lj") != 0 && strcmp(cmd_name, "exit") != 0) {

            bool command_found = false;

            // Premièrement, on vérifie si c'est une commande de chemin relatif "./file" ou "../file" ou qui contient "/../"
            if((strncmp(cmd_name, "./", 2) == 0 || strncmp(cmd_name, "../", 3) == 0 
                || strstr(cmd_name, "/../") != NULL || strchr(cmd_name, '/') != NULL) 
                && access(cmd_name, X_OK) == 0) {
                
                command_found = true;
            }
            else {
                // Si ce n'est pas une commande "./file" ou "../file" ou qui contient "/../", on parcourt les chemins dans PATH
                while (dir) {
                    char *full_path = malloc(strlen(dir) + strlen(cmd_name) + 2); // +2 pour '/' et '\0'
                    sprintf(full_path, "%s/%s", dir, cmd_name);

                    if(access(full_path, X_OK) == 0) {
                        command_found = true;
                        free(full_path);
                        break;
                    }

                    free(full_path);
                    dir = strtok(NULL, ":"); // On récupère le chemin suivant
                }
            }

            if (!command_found) {
                strcpy(invalid_cmd, cmd_name);
                return;
            }
        }
    }
    strcpy(invalid_cmd, "");
}



void print_prompt() {
    char cwd[1024];
    getcwd(cwd, sizeof(cwd));  // get current directory
    printf(COLOR_DARK_GRAY "┌─[" RESET COLOR_LIGHT_BLUE "%s" COLOR_DARK_GRAY "]\n" RESET, cwd);
    printf(COLOR_DARK_GRAY "└─[" RESET COLOR_RED "$" RESET COLOR_DARK_GRAY "]› " RESET);
}

void free_memory(char *inexistant_command) {
    if (inexistant_command != NULL) {
        free(inexistant_command);
    }
}