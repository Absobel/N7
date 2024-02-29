#include "aux.h"

void tree_dist_seq(node_t *nodes, int n);
void tree_dist_par(node_t *nodes, int n);

int main(int argc, char **argv) {

  int n, s;
  long ts, te;
  node_t *nodes;
  
  if ( argc == 3 ) {
    n = atoi(argv[1]);    /* the number of nodes in the tree */
    s = atoi(argv[2]);    /* the seed for the random number generation */
  } else {
    printf("Usage:\n\n ./main n s\n\nwhere n is the number of nodes in the tree and s the seed for the random number generation.\n");
    return 1;
  }
  
  treeinit(&nodes, n, s);


  printf("==================================================\n");
  printf("Starting sequential execution\n");
  
  ts = usecs();
  tree_dist_seq(nodes, n);
  te = usecs()-ts;

  printf("Sequential execution time: %6ld  msec.\n",te/1000);
  check(nodes, n);



  treereinit(nodes, n);

  printf("\n==================================================\n");
  printf("Starting parallel execution\n");
  
  ts = usecs();
  tree_dist_par(nodes, n);
  te = usecs()-ts;

  printf("Parallel execution time: %6ld  msec.\n",te/1000);
  check(nodes, n);
  


  treeprint(nodes, n);


  
  return 0;

}





