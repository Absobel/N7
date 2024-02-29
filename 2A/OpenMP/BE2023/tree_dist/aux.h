#include <math.h>
#include <stdio.h>
#include <stdlib.h>
#include <sys/time.h>

#define MIN(a,b) (((a)<(b))?(a):(b))
#define MAX(a,b) (((a)>(b))?(a):(b))

typedef struct nodestruct{
  unsigned int dist;
  unsigned int weight;
  unsigned int id;
  struct nodestruct *p;
} node_t;


long usecs ();
void treeinit(node_t **nodes, int n, int s);
void treereinit(node_t *nodes, int n);
unsigned int process(node_t node);
void treeprint(node_t *nodes, int n);
void check(node_t *nodes, int n);
