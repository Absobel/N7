#include <math.h>
#include <stdio.h>
#include <stdlib.h>
#include "treetrav.h"
#include "omp.h"

extern int countnodes[MAXTHREADS];

/* This is simply a wrapper for the recursive tree traversal
   routine */

/* This nth argument defines the number of threads to be used in the
   recursive tree traversal. */

void treetraverse_par(TreeNode *root, int nth) {
   int depth, i, max_tasks;

   /* To be used in the second part of the excercise */
   max_tasks = 5*nth;
   depth = root->l - log2(max_tasks);

   omp_set_num_threads(nth);

   /* Initialize the counter to 0. MAXTHREADS is the maximum numbeQr of
      allowed threads. */
   for (i = 0; i < MAXTHREADS; i++)
      countnodes[i] = 0;

   /* Start the tree traversal by calling the recursive routine */
   #pragma omp parallel num_threads(nth)
   #pragma omp master
   treetraverserec_par(root, depth);

   return;
}

/* This recursive routine performs a topological order tree traversal
   starting from the root node pointed by *root */

/* In the second part of the excercise, the depth argument will be
   used to define a layer in the tree below which tasks will be
   undeferred and immediately executed; this allows to reduce the
   overhead of creating and handling submitted tasks. */

void treetraverserec_par(TreeNode *root, int depth) {
   double sum;
   int i, iam, it;

   if (root->l != 1) {
      /* If this node is not a leaf...*/

      /* ...visit the left subtree... */
      #pragma omp task untied if(root->l > depth)
      treetraverserec_par(root->left, depth);

      /* ...visit the right subtree... */
      #pragma omp task untied if(root->l > depth)
      treetraverserec_par(root->right, depth);

      /* ...compute root->v as the sum of the v values on the left and
         right children... */
      #pragma omp taskwait
      root->v += (root->right)->v + (root->left)->v;
   }

   /* ...add root->n to root->v... */
   root->v += root->n;

   /* ...do some random work... */
   for (it = 0; it < NIT; it++)
      for (i = 1; i < DATASIZE; i++)
         root->data[0] += root->data[i];

   /* ...increment the counter of the number of nodes treated by the
      executing thread. */
   iam = omp_get_thread_num();
   countnodes[iam] += 1;

   return;
}
