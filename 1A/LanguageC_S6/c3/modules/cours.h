#ifndef _COURS_H
#define _COURS_H

#include "salle.h"
#include "enseignant.h"

struct cours{
	Date debut;
	Date fin;
	char* nom;
};
typedef struct cours cours;

void initialiser_cours(cours *c, salle s, enseignant e);

#endif