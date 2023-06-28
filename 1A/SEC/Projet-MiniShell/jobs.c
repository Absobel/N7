#define _XOPEN_SOURCE 700   // Permet que le compilateur reconnaisse certaines fonctions
#include "jobs.h"
#include <stdlib.h>
#include <stdio.h>
#include <string.h>
#include <sys/wait.h>
#include <unistd.h>
#include <signal.h>

bool suspend_flag = false;

void init_jobs(job jobs[]) {
    for (int i = 0; i < NB_JOBS_MAX; i++) {
        jobs[i] = (job) {-1, TERMINE, NULL};
    }
}

// returns -1 if error, id of the job otherwise
int add_job(job jobs[], job job) {
    for (int i = 0; i < NB_JOBS_MAX; i++) {
        if (jobs[i].state == TERMINE) {
            free(jobs[i].cmd);
            jobs[i] = job;
            return i;
        }
    }
    fprintf(stderr, "minishell: too many process\n");
    return -1;
}

void maj_jobs(job jobs[]) {
    int status;
    int pid = waitpid(-1, &status, WNOHANG);
    while(pid > 0) {
        for (int i = 0; i < NB_JOBS_MAX; i++) {
            if (jobs[i].pid == pid && jobs[i].state != TERMINE && WIFEXITED(status)) {
                jobs[i].state = TERMINE;
                break;
            }
        }
        pid = waitpid(-1, &status, WNOHANG);
    }
}

void destroy_job(job jobs[], int id) {
    if (id <= NB_JOBS_MAX && jobs[id].state != TERMINE) {
        jobs[id].state = TERMINE;
        free(jobs[id].cmd);
        jobs[id].cmd = NULL;
        return;
    }
    fprintf(stderr, "minishell: bg: job not found: %d\n", id);
}

void destroy_job_pid(job jobs[], pid_t pid) {
    for (int i = 0; i < NB_JOBS_MAX; i++) {
        if (jobs[i].pid == pid) {
            jobs[i].state = TERMINE;
            free(jobs[i].cmd);
            jobs[i].cmd = NULL;
            return;
        }
    }
}

// lj
void list_jobs(job jobs[]) {
    printf("%-4s %-6s %s\n", "id", "state", "command");
    for (int i = 0; i < NB_JOBS_MAX; i++) {
        if (jobs[i].state != TERMINE) {
            printf("%-4d %-6s %s\n", i, jobs[i].state == ACTIF ? "actif" : "suspendu", jobs[i].cmd);
        }
    }
}

// sj
void stop_job(job jobs[], int id) {
    if (id <= NB_JOBS_MAX && jobs[id].state != TERMINE) {
        kill(jobs[id].pid, SIGSTOP);
        jobs[id].state = SUSPENDU;
        return;
    }
    fprintf(stderr, "minishell: sj: job not found: %d\n", id);
}

// bg
void continue_job(job jobs[], int id) {
    if (id <= NB_JOBS_MAX && jobs[id].state != TERMINE) {
        kill(jobs[id].pid, SIGCONT);
        jobs[id].state = ACTIF;
        return;
    }
    fprintf(stderr, "minishell: bg: job not found: %d\n", id);
}

// fg
void foreground_job(job jobs[], int id) {
    if (id <= NB_JOBS_MAX && jobs[id].state != TERMINE) {
        kill(jobs[id].pid, SIGCONT);
        jobs[id].state = ACTIF;
        int status;
        waitpid(jobs[id].pid, &status, 0);
        jobs[id].state = suspend_flag ? SUSPENDU : TERMINE;
        suspend_flag = false;
        return;
    }
    fprintf(stderr, "minishell: fg: job not found: %d\n", id);
}

void suspend_fg_job(job jobs[]) {
    for (int i = 0; i < NB_JOBS_MAX; i++) {
        if (jobs[i].state == ACTIF) {
            kill(jobs[i].pid, SIGSTOP);
            jobs[i].state = SUSPENDU;
            return;
        }
    }
}
void destroy_fg_job(job jobs[]) {
    for (int i = 0; i < NB_JOBS_MAX; i++) {
        if (jobs[i].state == ACTIF) {
            jobs[i].state = TERMINE;
            kill(jobs[i].pid, SIGINT);
            return;
        }
    }
}

/* return :
    0 : la commande est une built-in commande
    1 : ça ne l'est pas
*/
int unpipable_cmd(job jobs[], char*** seq) {
    // built-in commands
    if (strcmp(seq[0][0], "exit") == 0 && seq[1] == NULL) {
        if (seq[0][1] == NULL) {
            exit(EXIT_SUCCESS);
        } else {
            fprintf(stderr, "exit: too many arguments\n");
        }
    }
    else if (strcmp(seq[0][0], "cd") == 0 && seq[1] == NULL) {
        if (seq[0][1] == NULL) {
            chdir(getenv("HOME"));
        } else if (seq[0][1] != NULL && seq[0][2] == NULL) {
            int err = chdir(seq[0][1]);
            if (err == -1) {
                fprintf(stderr, "cd: The directory '%s' does not exist\n", seq[0][1]);
            }
        } else {
            fprintf(stderr, "cd: too many arguments\n");
        }
    }
    else if (strcmp(seq[0][0], "sj") == 0 && seq[1] == NULL) {
        if (seq[0][1] == NULL) {
            fprintf(stderr, "sj: missing argument\n");
        } else if (seq[0][2] == NULL) {
            stop_job(jobs, atoi(seq[0][1]));
        } else {
            fprintf(stderr, "sj: too many arguments\n");
        }
    }
    else if (strcmp(seq[0][0], "bg") == 0 && seq[1] == NULL) {
        if (seq[0][1] == NULL) {
            fprintf(stderr, "bg: missing argument\n");
        } else if (seq[0][2] == NULL) {
            continue_job(jobs, atoi(seq[0][1]));
        } else {
            fprintf(stderr, "bg: too many arguments\n");
        }
    }
    else if (strcmp(seq[0][0], "fg") == 0 && seq[1] == NULL) {
        if (seq[0][1] == NULL) {
            fprintf(stderr, "fg: missing argument\n");
        } else if (seq[0][2] == NULL) {
            foreground_job(jobs, atoi(seq[0][1]));
        } else {
            fprintf(stderr, "fg: too many arguments\n");
        }
    }
    else {
        return 1;
    }
    return 0;
}

int pipable_cmd(job jobs[], char** seqi) {
    if (strcmp(seqi[0], "lj") == 0) {
        if (seqi[1] == NULL) {
            list_jobs(jobs);
        } else {
            fprintf(stderr, "lj: too many arguments\n");
        }
        return 0;
    }
    return 1;
}