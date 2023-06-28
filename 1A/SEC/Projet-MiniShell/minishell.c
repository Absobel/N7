#define _XOPEN_SOURCE 700   // Permet que le compilateur reconnaisse certaines fonctions
#include <stdio.h>    /* entrées sorties */
#include <unistd.h>   /* pimitives de base : fork, ...*/
#include <stdlib.h>   /* exit */
#include <sys/wait.h> /* wait */
#include <string.h>   /* opérations sur les chaines */
#include <fcntl.h>    /* opérations sur les fichiers */
#include <stdbool.h>  /* booleans */
#include <signal.h>   /* signaux */
#include <errno.h>   /* gestion des erreurs */

#include "readcmd.h"
#include "utils.h"
#include "jobs.h"

#define CMD_SIZE 4096
#define LECTURE 0
#define ECRITURE 1


job jobs[NB_JOBS_MAX];
int fd_in; int saved_stdin;
int fd_out; int saved_stdout;

void handler_sig(int sig) {
    switch (sig) {
        case SIGTSTP:
            suspend_fg_job(jobs);
            suspend_flag = true;
            break;
        case SIGINT:
            if (!suspend_flag) {
                printf("\n");
                destroy_fg_job(jobs);
            }
            break;
    }
}

int main() {
    // Signal handler
    struct sigaction sa;
    sa.sa_handler = handler_sig;
    sa.sa_flags = 0;  // Renvoie moins de signaux SIGCHLD
    sigemptyset(&sa.sa_mask);
    sigaction(SIGTSTP, &sa, NULL);
    sigaction(SIGINT, &sa, NULL);


    struct cmdline *cmd;
    init_jobs(jobs);

    sigset_t mask, oldmask;
    sigemptyset(&mask);

    // Bloquer SIGTSTP et SIGINT
    sigaddset(&mask, SIGTSTP);
    sigaddset(&mask, SIGINT);

    do {
        print_prompt();
        
        // Bloquer SIGTSTP et SIGINT avant readcmd
        if (sigprocmask(SIG_BLOCK, &mask, &oldmask) < 0) {
            perror("sigprocmask block");
            exit(EXIT_FAILURE);
        }
        cmd = readcmd();
        // Débloquer SIGTSTP et SIGINT après readcmd
        if (sigprocmask(SIG_SETMASK, &oldmask, NULL) < 0) {
            perror("sigprocmask unblock");
            exit(EXIT_FAILURE);
        }

        if (cmd == NULL) {  // EOF (ne devrait pas être un signal car bloqué)
            printf("\n");
            break;
        }
        if (cmd->err != NULL) {
            fprintf(stderr, "Syntax error: %s\n", cmd->err);
            continue;
        }
        if (cmd->seq[0] == NULL) {   // ligne vide
            continue;
        }

        // Check avant redirections pour éviter de créer des fichiers inutiles
        char* inexistant_command = malloc(CMD_SIZE);
        checkCommand(cmd->seq, inexistant_command);
        if (strcmp(inexistant_command, "") != 0) {
            fprintf(stderr, "minishell: %s: command not found\n", inexistant_command);
            free_memory(inexistant_command);
            continue;
        }

        // Redirections
        if (cmd->in != NULL) {
            fd_in = open(cmd->in, O_RDONLY);
            if (fd_in == -1) {
                if (errno == ENOENT) {
                    fprintf(stderr, "minishell: %s: No such file or directory\n", cmd->in);
                    continue;
                } else {
                    perror("open");
                    exit(EXIT_FAILURE);
                }
            }
            saved_stdin = dup(STDIN_FILENO);
            if (dup2(fd_in, STDIN_FILENO) == -1) {
                perror("dup2");
                exit(EXIT_FAILURE);
            }
        }
        if (cmd->out != NULL) {
            fd_out = open(cmd->out, O_WRONLY | O_CREAT | O_TRUNC, 0644);
            if (fd_out == -1) {
                perror("open");
                exit(EXIT_FAILURE);
            }
            saved_stdout = dup(STDOUT_FILENO);
            if (dup2(fd_out, STDOUT_FILENO) == -1) {
                perror("dup2");
                exit(EXIT_FAILURE);
            }
        }


        if (unpipable_cmd(jobs, cmd->seq) != 0) {
            int in = 0;
            for (int i = 0; cmd->seq[i] != NULL; i++) {
                int pipefd[2];
                if (pipe(pipefd) == -1) {
                    perror("pipe");
                    exit(EXIT_FAILURE);
                }

                pid_t pid = fork();
                if (pid == -1) {
                    perror("fork");
                    exit(EXIT_FAILURE);
                }
                if (pid == 0) {
                    close(pipefd[LECTURE]);
                    dup2(in, STDIN_FILENO);
                    if (cmd->seq[i+1] != NULL) {
                        dup2(pipefd[ECRITURE], STDOUT_FILENO);
                    }
                    if (pipable_cmd(jobs, cmd->seq[i])) {
                        execvp(cmd->seq[i][0], cmd->seq[i]);
                    }
                    exit(0);
                } else {
                    int id_or_error = add_job(jobs, (job) {pid, ACTIF, cmd_to_str(cmd->seq[i])});
                    if (id_or_error == -1) {
                        continue;
                    }
                    int status;
                    if (cmd->backgrounded == NULL) {
                        waitpid(pid, &status, 0);
                        jobs[id_or_error].state = suspend_flag ? SUSPENDU : TERMINE;
                        suspend_flag = false;
                    }
                    if (WIFEXITED(status) && WEXITSTATUS(status) == 255) {
                        fprintf(stderr, "minishell: %s: command not found\n", cmd->seq[i][0]);
                    }
                    close(pipefd[ECRITURE]);
                    in = pipefd[LECTURE];
                }
            }
        }

        if (cmd->in != NULL) {
            close(fd_in);
            if (dup2(saved_stdin, STDIN_FILENO) == -1) {
                perror("dup2");
                exit(EXIT_FAILURE);
            }
        }
        if (cmd->out != NULL) {
            close(fd_out);
            if (dup2(saved_stdout, STDOUT_FILENO) == -1) {
                perror("dup2");
                exit(EXIT_FAILURE);
            }
        }

        free_memory(inexistant_command);
        maj_jobs(jobs);
    } while (1);

    return EXIT_SUCCESS;
}