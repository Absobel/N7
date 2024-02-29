#include "aux.h"

void tree_dist_seq(node_t *nodes, int n){

  int node;
  
  for(node=0; node<n; node++){
    
    nodes[node].weight = process(nodes[node]);
    nodes[node].dist    = nodes[node].weight;
    if(nodes[node].p) nodes[node].dist += (nodes[node].p)->dist;
    
  }
  

}




