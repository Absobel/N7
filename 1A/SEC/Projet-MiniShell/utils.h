#ifndef UTILS_H
#define UTILS_H

#include "readcmd.h"

char* cmd_to_str(char** seqi);
void checkCommand(char*** seq, char* invalid_cmd);
void print_prompt();
void free_memory(char *inexistant_command);

#endif