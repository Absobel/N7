#ifndef JOBS_H
#define JOBS_H

#include <stdbool.h>
#include <unistd.h>

#define NB_JOBS_MAX 50

extern bool suspend_flag;

typedef enum state {
    ACTIF,
    SUSPENDU,
    TERMINE,
} state;

typedef struct job {
    int pid;
    state state;
    char* cmd;
} job;

void init_jobs(job jobs[]);
int add_job(job jobs[], job job);
void maj_jobs(job jobs[]);
void destroy_job(job jobs[], int id);
void destroy_job_pid(job jobs[], pid_t pid);
void list_jobs(job jobs[]);
void stop_job(job jobs[], int id);
void continue_job(job jobs[], int id);
void foreground_job(job jobs[], int id);
void suspend_fg_job(job jobs[]);
void destroy_fg_job(job jobs[]);
int unpipable_cmd(job jobs[], char*** seq);
int pipable_cmd(job jobs[], char** seqi);

#endif //JOBS_H
