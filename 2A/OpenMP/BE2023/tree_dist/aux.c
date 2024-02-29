#include "aux.h"
#include <stdio.h>
#include <omp.h>

#define AVGN 4

unsigned int *weights;

long usecs (){
  struct timeval t;

  gettimeofday(&t,NULL);
  return t.tv_sec*1000000+t.tv_usec;
}


void mysleep(double sec){

  long s, e;
  s=0; e=0;
  s = usecs();
  while(((double) e-s)/1000000 < sec)
    {
      e = usecs();
    }
  return;
}


void treeinit(node_t **nodes, int n, int s){
  
  int id, cnt, i, c, nc, r;
  
  id = 0;
  
  srand(s);
  
  *nodes  = (node_t*)malloc(n*sizeof(node_t));
  weights = (unsigned int*)malloc(n*sizeof(unsigned int));
  
  (*nodes)[0].id     = id;
  (*nodes)[0].dist    = 0.0;
  (*nodes)[0].p      = NULL;
  (*nodes)[0].weight = 0;
  weights[0] = rand()%10+1;

  cnt = 1;

  for(i=0; i<n; i++){
    r = rand()%AVGN;
    nc = MIN(r,n-cnt);
    nc = MAX(nc,1);
    printf("node %3d will have %2d children. r:%2d budget:%d\n",i,nc,r, n-cnt);
    for(c=cnt; c<cnt+nc; c++){
      weights[c] = rand()%10+1;
      (*nodes)[c].id     = c;
      (*nodes)[c].dist    = 0;
      (*nodes)[c].p      = (*nodes)+i;
      (*nodes)[c].weight = 0.0;
    }
    cnt+=nc;

    if(cnt>=n) break;
  }

  return ;
}


void treereinit(node_t *nodes, int n){
  
  int i;
  
  for(i=0; i<n; i++){
      nodes[i].dist    = 0;
      nodes[i].weight = 0.0;
  }

  return ;
}



unsigned int process(node_t node){

  printf("%2d -- Processing node %d\n",omp_get_thread_num(), node.id);
  mysleep(((double)weights[node.id])/50.0);
  return weights[node.id];

}


void treeprint(node_t *nodes, int n){

  FILE *pfile;
  int i;
  
  pfile = fopen ("tree.dot","w");


  fprintf(pfile, "graph G {\n");
  fprintf(pfile, "node [color=black,\n");
  fprintf(pfile, "fillcolor=white,\n");
  fprintf(pfile, "shape=circle,\n");
  fprintf(pfile, "style=filled\n");
  fprintf(pfile, "];\n");
  
  for(i=0; i<n; i++){
    if(nodes[i].p==NULL){
      fprintf(pfile, "node%4.4d[label=\"id:%d\\lweight:%d\\ldist:%d\\l\"];\n",nodes[i].id,nodes[i].id, nodes[i].weight, nodes[i].dist);
    } else {
      fprintf(pfile, "node%4.4d[label=\"id:%d\\lp:%d\\lweight:%d\\ldist:%d\\l\"];\n",nodes[i].id,nodes[i].id, (nodes[i].p)->id, nodes[i].weight, nodes[i].dist);
      fprintf(pfile, "node%4.4d -- node%4.4d\n",(nodes[i].p)->id, nodes[i].id);

    }
    
    
  }
  
  fprintf(pfile, "}");

  fclose(pfile);

}

void check(node_t *nodes, int n){

    int node;
  
  for(node=0; node<n; node++){

    if(nodes[node].weight != weights[node]){
      printf("The result is wrong!!!\n");
      return;
    }

    if(nodes[node].p)
      if(nodes[node].dist != (nodes[node].p)->dist + nodes[node].weight){
        printf("The result is wrong!!!\n");
        return;
      }
  }

  printf("The result is correct.\n");

}

