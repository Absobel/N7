/**
 *  \author Xavier Cr�gut <nom@n7.fr>
 *  \file file.c
 *
 *  Objectif :
 *	Implantation des op�rations de la file
*/

#include <malloc.h>
#include <assert.h>

#include "file.h"


void initialiser(File *f)
{
    f->tete = NULL;
    f->queue = NULL;

    assert(est_vide(*f));
}



void detruire(File *f)
{
    Cellule *current = f->tete;
    Cellule *next;
    while (current != NULL) {
        next = current->suivante;
        free(current);
        current = next;
    }
    f = NULL;
}



char tete(File f)
{
    assert(! est_vide(f));

    return f.tete->valeur;
}


bool est_vide(File f)
{
    return f.tete == NULL && f.queue == NULL;
}

/**
 * Obtenir une nouvelle cellule allou�e dynamiquement
 * initialis�e avec la valeur et la cellule suivante pr�cis� en param�tre.
 */
static Cellule * cellule(char valeur, Cellule *suivante)
{
    Cellule *c = malloc(sizeof(Cellule));
    c->valeur = valeur;
    c->suivante = suivante;
    return c;
}


void inserer(File *f, char v)
{
    assert(f != NULL);
    if (est_vide(*f)) {
        f->tete = cellule(v, NULL);
        f->queue = f->tete;
    } else {
        f->queue->suivante = cellule(v, NULL);
        f->queue = f->queue->suivante;
    }
}

void extraire(File *f, char *v)
{
    assert(f != NULL);
    assert(! est_vide(*f));

    Cellule *c = f->tete;
    *v = c->valeur;
    f->tete = c->suivante;
    if (f->tete == NULL) {
        f->queue = NULL;
    }
    free(c);
}


int longueur(File f)
{
    int i = 0;
    for (Cellule *c = f.tete; c != NULL; c = c->suivante) {
        i++;
    }
    return i;
}
