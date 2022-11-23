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
 * \pre
 * \post m.valeur = valeur et m.devise = devise
 */ 
void initialiser(monnaie* m, int valeur, char devise) {
    m->valeur = valeur;
    m->devise = devise;
}


/**
 * \brief Ajouter une monnaie m2 à une monnaie m1 
 * \param[in out] m1 la monnaie a laquelle on ajoute m2
 * \param[in] m2 la monnaie a ajouter
 * \pre
 * \post m1.valeur = m1.valeur + m2.valeur
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
 */ 
void tester_initialiser() {
    monnaie m;
    initialiser(&m, 10, 'E');
    assert(m.valeur == 10);
    assert(m.devise == 'E');
}

/**
 * \brief Tester Ajouter 
 */ 
void tester_ajouter() {
    monnaie m1, m2;
    initialiser(&m1, 10, 'E');
    initialiser(&m2, 5, 'E');
    ajouter(&m1, &m2);
    assert(m1.valeur == 15);
    assert(m1.devise == 'E');
    initialiser(&m2, 5, 'D');
    assert(!ajouter(&m1, &m2));
}



int main(void){
    printf("Tester Initialiser\n");
    tester_initialiser();
    printf("Tester Ajouter\n");
    tester_ajouter();

    printf("\nTest tableau de monnaie : \n\n");
    // Un tableau de TAILLE monnaies
    monnaie porte_monnaie[TAILLE];

    printf("Initialiser le tableau de monnaie : \n");
    //Initialiser les monnaies
    for (int i = 0; i < 5; i++) {
        int valeur;
        char devise;
        printf("Valeur de m%d : ", i);
        scanf("%d", &valeur);
        printf("Devise de m%d : ", i);
        scanf(" %c", &devise);
        initialiser(&porte_monnaie[i], valeur, devise);
    }
    //Tester les initialisations
    for (int i = 0; i < 5; i++) {
        tester_initialiser(porte_monnaie[i], 0, 'e');
    }
 
    // Afficher la somme des toutes les monnaies qui sont dans une devise entrée par l'utilisateur.
    char devise;
    printf("\nEntrer une devise: ");
    scanf("%c", &devise);
    int somme = 0;
    for (int i = 1; i < 5; i++) {
        ajouter(&porte_monnaie[0], &porte_monnaie[i]);
    }
    printf("\nLa somme des monnaies dans la devise %c est %d%c", devise, somme, devise);

    // Tester ajouter
    printf("Tester ajouter: ");
    monnaie m1 = {0, 'y'};
    monnaie m2 = {10, 'y'};
    tester_ajouter(&m1, &m2);
    printf("La somme des monnaies dans la devise %c est %d%c", devise, somme, devise);

    return EXIT_SUCCESS;
}
