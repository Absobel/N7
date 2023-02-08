public class EnsembleChainee<E> implements Ensemble<E> {
    private Cellule<E> tete;
    private int nbElements;

    public EnsembleChainee() {
        tete = null;
        nbElements = 0;
    }

    public void ajouter(E n) {
        if (contient(n)) {
            throw new RuntimeException("L'entier " + n + " est déjà dans l'ensemble");
        }
        tete = new Cellule<E>(n, tete);
        nbElements++;
    }

    public void supprimer(E n) {
        if (!contient(n)) {
            throw new RuntimeException("L'entier " + n + " n'est pas dans l'ensemble");
        }
        if (tete.getValeur().equals(n)) {
            tete = tete.getSuivante();
        } else {
            Cellule<E> c = tete;
            while (!c.getSuivante().getValeur().equals(n)) {
                c = c.getSuivante();
            }
            c.setSuivante(c.getSuivante().getSuivante());
        }
        nbElements--;
    }

    public boolean contient(E n) {
        Cellule<E> c = tete;
        while (c != null && !c.getValeur().equals(n)) {
            c = c.getSuivante();
        }
        return c != null;
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
        E min = tete.getValeur();
        Cellule<E> c = tete.getSuivante();
        while (c != null) {
            if (c.getValeur().compareTo(min) < 0) {
                min = c.getValeur();
            }
            c = c.getSuivante();
        }
        return min;
    }
}
