#include <stdio.h>
#include <stdlib.h>
#include "aux.h"
#include "omp.h"

#define NB_RESOURCES 5

int main(int argc, char **argv){
  long   t_start, t_end;
  int    np, p, s;
  procedure_t procedure;

  if ( argc == 2 ) {
    np = atoi(argv[1]);
  } else {
    printf("Usage:\n\n ./main np\n\nwhere np is the number of procedures to execute.\n");
    return 1;
  }
  init(np);
  
  // Locks for each of the resources
  omp_lock_t *locks;
  locks = (omp_lock_t*) malloc(NB_RESOURCES*sizeof(omp_lock_t));
  for(int i=0; i<NB_RESOURCES; i++) omp_init_lock(locks+i);

  t_start = usecs();
  #pragma omp parallel for private(p, s, procedure)
  for(p=0; p<np; p++){
    #pragma omp critical
    get_procedure(&procedure);

    for(s=0; s<procedure.nsteps; s++){
      int ps = procedure.steps[s];
      omp_set_lock(&locks[ps]);
      switch (ps) {
      case PRINTER:
        /* printf("%3d  %2d -- Using printer %d\n",p,s,procedure.data[s]); */
        use_printer(procedure, s);
        break;
      case CPU:
        /* printf("%3d  %2d -- Using CPU     %d\n",p,s,procedure.data[s]); */
        use_cpu(procedure, s);
        break;
      case SCREEN:
        /* printf("%3d  %2d -- Using screen  %d\n",p,s,procedure.data[s]); */
        use_screen(procedure, s);
        break;
      case DISK:
        /* printf("%3d  %2d -- Using disk    %d\n",p,s,procedure.data[s]); */
        use_disk(procedure, s);
        break;
      case MEMORY:
        /* printf("%3d  %2d -- Using memory  %d\n",p,s,procedure.data[s]); */
        use_memory(procedure, s);
        break;
      }
      omp_unset_lock(&locks[ps]);
    }
  }  
  t_end = usecs();
  printf("Execution time: %.4f\n",((double)t_end-t_start)/1000.0);
  check_result();
}
