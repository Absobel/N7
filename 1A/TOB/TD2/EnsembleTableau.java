public class EnsembleTableau<E> implements Ensemble<E>{
    private E[] tab;
    private int nbElements;

    public EnsembleTableau(int taille) {
        tab = (E[]) new Object[taille];
        nbElements = 0;
    }

    public void ajouter(E n) {
        if (contient(n)) {
            throw new RuntimeException("L'entier " + n + " est déjà dans l'ensemble");
        }
        tab[nbElements] = n;
        nbElements++;
    }

    public void supprimer(E n) {
        if (!contient(n)) {
            throw new RuntimeException("L'entier " + n + " n'est pas dans l'ensemble");
        }
        int i = 0;
        while (!tab[i].equals(n)) {
            i++;
        }
        tab[i] = tab[nbElements - 1];
        nbElements--;
    }

    public boolean contient(E n) {
        int i = 0;
        while (i < nbElements && !tab[i].equals(n)) {
            i++;
        }
        return i < nbElements;
    }

    public boolean estVide() {
        return nbElements == 0;
    }

    public int cardinal() {
        return nbElements;
    }

    public E min() {
        if (estVide()) {
            throw new RuntimeException("L'ensemble est vide");
        }
        E min = tab[0];
        for (int i = 1; i < nbElements; i++) {
            if (tab[i].compareTo(min) < 0) {
                min = tab[i];
            }
        }
        return min;
    }
}
