#include "trace.h"
#include "common.h"
#include <omp.h>


/* This is a sequential routine for the LU factorization of a square
   matrix in block-columns */

void lu_par_tasks(Matrix A, info_type info){

  int i, j;

  /* Initialize the tracing system */
  trace_init();
  
  #pragma omp parallel
  {
  #pragma omp master
  {
  for(i=0; i<info.NB; i++){
    
    /* Do the Panel operation on column i */
    #pragma omp task depend(inout: A[i]) firstprivate(i) priority(2)
    panel(A[i], i, info);
    
    /* Parallelize this loop     */
    
    for(j=i+1; j<info.NB; j++) {
      int p = j == i+1 ? 2 : 1;
      /* Update column j with respect to the result of panel(A, i) */
      #pragma omp task depend(inout: A[j]) depend(in: A[i]) firstprivate(i, j) priority(p)
      update(A[i], A[j], i, j, info);
    }
  }
  }
  }
  
  /* This routine applies permutations resulting from numerical
     pivoting. It has to be executed sequentially. */
  backperm(A, info);
  
  /* Write the trace in file (ignore) */
  trace_dump("trace_par_tasks.svg");
  
  return;
  
}
