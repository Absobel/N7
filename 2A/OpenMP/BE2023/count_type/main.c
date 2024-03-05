#include <stdio.h>
#include <stdlib.h>
#include <sys/time.h>
#include "omp.h"
#include "aux.h"

void work(data_t *data, unsigned int *typecounts, int ndata, int ntype);
void work_par_critical(data_t *data, unsigned int *typecounts, int ndata, int ntype);
void work_par_atomic(data_t *data, unsigned int *typecounts, int ndata, int ntype);
void work_par_locks(data_t *data, unsigned int *typecounts, int ndata, int ntype);


int main(int argc, char **argv) {
  int i, ndata, ntype;
  long t_start, t_end, save;
  data_t *data;
  unsigned int *typecounts;
  
  // Command line arguments
  if ( argc == 3 ) {
    ndata    = atoi(argv[1]);    /* number of data */
    ntype    = atoi(argv[2]);    /* number of data types*/
  } else {
    printf("Usage:\n\n ./main ndata ntype\n where ndata is the number of data and ntypes the number of possible types.\n");
    return 1;
  }

  data = (data_t*)malloc(ndata*sizeof(data_t));
  typecounts = (unsigned int*)malloc(ntype*sizeof(unsigned int));
  
  init_data(data, ndata, ntype);

  for(i=0; i<ntype; i++){
    typecounts[i] = 0;
  }
  printf("========= Sequential routine \n");
  t_start = usecs();
  /* Launch the sequential routine */
  work(data, typecounts, ndata, ntype);
  t_end = usecs();
  printf("Elapsed time seq.    : %ld\n",t_end-t_start);
  check(typecounts, ntype);

  /* Re-initialize the typecounts */
  for(i=0; i<ntype; i++){
    printf("type %2d:  %4d\n",i,typecounts[i]);
    typecounts[i] = 0;
  }
  printf("\n========= Parallel (critical) routine\n");
  t_start = usecs();
  /* Launch the parallel routine based on critical sections */
  work_par_critical(data, typecounts, ndata, ntype);
  t_end = usecs();
  printf("Elapsed time critical: %ld\n",t_end-t_start);
  /* check the result */
  check(typecounts, ntype);

  /* Re-initialize the typecounts */
  for(i=0; i<ntype; i++){
    printf("type %2d:  %4d\n",i,typecounts[i]);
    typecounts[i] = 0;
  }
  printf("\n========= Parallel (locks) routine\n");
  t_start = usecs();
  /* Launch the parallel routine based on locks */
  work_par_locks(data, typecounts, ndata, ntype);
  t_end = usecs();
  printf("Elapsed time locks   : %ld\n",t_end-t_start);
  /* check the result */
  check(typecounts, ntype);

  /* Re-initialize the typecounts */
  for(i=0; i<ntype; i++){
    printf("type %2d:  %4d\n",i,typecounts[i]);
    typecounts[i] = 0;
  }
  printf("\n========= Parallel (atomic) routine\n");
  t_start = usecs();
  /* Launch the parallel routine based on atomic */
  work_par_atomic(data, typecounts, ndata, ntype);
  t_end = usecs();
  /* check the result */
  printf("Elapsed time locks   : %ld\n",t_end-t_start);
  /* check the result */
  check(typecounts, ntype);
  for(i=0; i<ntype; i++){
    printf("type %2d:  %4d\n",i,typecounts[i]);
  }
  return 0;
  
}


void work(data_t *data, unsigned int *typecounts, int ndata, int ntype){
  int i;
  
  for(i=0; i<ndata; i++){
    
    typecounts[analyze(data[i])]++;
    
  }
  return;
}



void work(data_t *data, unsigned int *typecounts, int ndata, int ntype){
  int i;
  
  #pragma omp parallel for
  for(i=0; i<ndata; i++){
    
    #pragma omp critical
    typecounts[analyze(data[i])]++;
    
  }
  return;
}

/* PAS CORRIGÉ */

void work_par_locks(data_t *data, unsigned int *typecounts, int ndata, int ntype){
  int i;
  omp_lock_t *locks;

  locks = (omp_lock_t*)malloc(ntype*sizeof(omp_lock_t));
  for (i=0; i<ntype; i++){
    omp_init_lock(locks+i);
  }

  #pragma omp parallel for private(i)
  for(i=0; i<ndata; i++){
    #pragma omp critical
    {
      omp_set_lock(locks+analyze(data[i]));
      typecounts[analyze(data[i])]++;
      omp_unset_lock(locks+analyze(data[i]));
    }    
  }

  for (i=0; i<ntype; i++){
    omp_destroy_lock(locks+i);
  }
  return;
}



void work_par_atomic(data_t *data, unsigned int *typecounts, int ndata, int ntype){
  int i;
  
  #pragma omp parallel for
  for(i=0; i<ndata; i++){
    
    #pragma omp atomic update
    typecounts[analyze(data[i])]++;
    
  }
  return;
}





