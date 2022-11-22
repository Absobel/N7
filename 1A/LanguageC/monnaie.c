#include <stdlib.h> 
#include <stdio.h>
#include <assert.h>
#include <stdbool.h>

// Definition du type monnaie
struct monnaie {
    int valeur;
    char devise;
};

typedef struct monnaie monnaie;

/**
 * \brief Initialiser une monnaie 
 * \param[]
 * \pre 
 * // TODO
 */ 
void initialiser(monnaie* m, int valeur, char devise) {
    m->valeur = 0;
    m->devise = '€';
}


/**
 * \brief Ajouter une monnaie m2 à une monnaie m1 
 * \param[]
 * // TODO
 */ 
bool ajouter(monnaie* m1, monnaie* m2) {
    if (m1->devise == m2->devise) {
        m1->valeur += m2->valeur;
        return true;
    } else {
        return false;
    }
}


/**
 * \brief Tester Initialiser 
 * \param[]
 * // TODO
 */ 
void tester_initialiser(){
    monnaie m;
    initialiser(&m, 0, '€');
    assert(m.valeur == 0);
    assert(m.devise == '€');
}

/**
 * \brief Tester Ajouter 
 * \param[]
 * // TODO
 */ 
void tester_ajouter(){
    monnaie m1;
    monnaie m2;
    initialiser(&m1, 2, '€');
    initialiser(&m2, 5, '€');
    ajouter(&m1, &m2);
    assert(m1.valeur == 7);
    assert(m1.devise == '€');
}



int main(void){
    // Un tableau de 5 monnaies
    monnaie* tab_monnaie[5];

    //Initialiser les monnaies
    for (int i = 0; i < 5; i++) {
        initialiser(tab_monnaie[i], 0, '€');
    }
 
    // Afficher la somme des toutes les monnaies qui sont dans une devise entrée par l'utilisateur.
    char devise;
    printf("Entrer une devise: ");
    scanf("%c", &devise);
    int somme = 0;
    for (int i = 0; i < 5; i++) {
        if (tab_monnaie[i]->devise == devise) {
            somme += tab_monnaie[i]->valeur;
        }
    }
    printf("La somme des monnaies dans la devise %c est %d", devise, somme);

    return EXIT_SUCCESS;
}
