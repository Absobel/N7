#include <stdio.h>
#include <stdlib.h>
#include <sys/time.h>
#include "omp.h"
#include "aux.h"

unsigned int *types, *cnt;


void init_data(data_t *data, int ndata, int ntype){
  int i;

  types = (unsigned int*)malloc(ndata*sizeof(unsigned int));
  cnt   = (unsigned int*)malloc(ntype*sizeof(unsigned int));

  for(i=0; i<ntype; i++)
    cnt[i]=0;
  
  for(i=0; i<ndata; i++){
    data[i].id=i;
    types[i] = rand()%ntype;
    cnt[types[i]]++;
  }
  
  return;
}

void check(unsigned int *typecounts, int ntype){
  int i;
  
  for(i=0; i<ntype; i++){
    if(typecounts[i]!=cnt[i]){
      printf("The result is wrong!\n");
      return;
    }
  }
  printf("The result is correct.\n");
  return;
}


unsigned int analyze(data_t data){

  mysleep(200);
  return types[data.id];
  
}


long usecs (){
  struct timeval t;

  gettimeofday(&t,NULL);
  return t.tv_sec*1000000+t.tv_usec;
}


void mysleep(long t){
  long t_start, t_end;

  t_start = usecs();
  do{
    t_end = usecs();
  } while(t_end-t_start < t);

  return;
}

  
