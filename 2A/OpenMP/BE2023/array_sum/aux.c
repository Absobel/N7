#include "aux.h"

int    *data, *bp;
int    cnt;

long usecs (){
  struct timeval t;

  gettimeofday(&t,NULL);
  return t.tv_sec*1000000+t.tv_usec;
}



double superfast_sum(long n, double *x){
  int i;
  double sum;

  sum = 0;

  for(i=0; i<n; i++)
    sum += x[i];

  return sum;
}
