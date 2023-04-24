#include <stdlib.h> 
#include <stdio.h>
#include <assert.h>
#include <stdbool.h>

#define TAILLE 5

// Definition du type monnaie
struct monnaie {
    int valeur;
    char devise;
};

typedef struct monnaie monnaie;

/**
 * \brief Initialiser une monnaie 
 * \param[in out] m la monnaie a initialiser
 * \param[in] valeur la valeur de la monnaie
 * \param[in] devise la devise de la monnaie
 * \pre valeur > 0
 * \post m.valeur = valeur et m.devise = devise
 */ 
void initialiser(monnaie* m, int valeur, char devise) {
    m->valeur = valeur;
    m->devise = devise;
}


/**
 * \brief Ajouter une monnaie m2 à une monnaie m1 
 * \param[in out] m2 la monnaie a laquelle on ajoute m1
 * \param[in] m1 la monnaie a ajouter
 * \param[out] booleen indiquant si l'opération a réussie
 * \pre
 * \post non booleen ou m1.valeur = m1.valeur + m2.valeur
 */ 
bool ajouter(monnaie* m1, monnaie* m2) {
    if (m2->devise == m1->devise) {
        m2->valeur += m1->valeur;
        return true;
    } else {
        return false;
    }
}


/**
 * \brief Programme de test pour l'initialisation 
 */ 
void tester_initialiser() {
    monnaie m;
    initialiser(&m, 10, 'E');
    assert(m.valeur == 10);
    assert(m.devise == 'E');
}

/**
 * \brief Programme de test pour l'ajout  
 */ 
void tester_ajouter() {
    monnaie m1, m2;
    initialiser(&m1, 10, 'E');
    initialiser(&m2, 5, 'E');
    assert(ajouter(&m1, &m2));
    assert(m2.valeur == 15);
    initialiser(&m2, 5, 'D');
    assert(!ajouter(&m1, &m2));
}



void initialiser_tableau_monnaie(monnaie* tableau) {
    //Initialiser les monnaies
    for (int i = 0; i < 5; i++) {
        int valeur;
        char devise;
        printf("Valeur de m%d : ", i);
        scanf("%d", &valeur);
        printf("Devise de m%d : ", i);
        scanf(" %c", &devise);
        initialiser(&tableau[i], valeur, devise);
    }
}

int somme_device_tableau(monnaie* tableau, char devise) {
    int somme = 0;
    for (int i = 0; i < TAILLE; i++) {
        if (tableau[i].devise == devise) {
            somme += tableau[i].valeur;
        }
    }
    return somme;
}


int main(void){
    tester_initialiser();
    tester_ajouter();

    monnaie porte_monnaie[TAILLE];
    printf("Initialisation du tableau de monnaie : \n\n");
    initialiser_tableau_monnaie(porte_monnaie);
 
    // Afficher la somme des toutes les monnaies qui sont dans une devise entrée par l'utilisateur.
    char devise;
    printf("\nEntrer une devise: ");
    scanf(" %c", &devise);
    int somme = somme_device_tableau(porte_monnaie, devise);
    printf("\nLa somme des monnaies dans la devise %c est %d%c\n", devise, somme, devise);

    return EXIT_SUCCESS;
}
