/**
 * Ensemble chainé
 */
public class EnsembleChaine implements Ensemble {
    private Cellule cellule_initiale;

    /**
     * Constructeur de l'ensemble chainé.
     */
    public EnsembleChaine() {
        cellule_initiale = null;
    }

    // Les méthodes suivantes sont documentées dans Ensemble.java

    public int cardinal() {
        Cellule cellule = cellule_initiale;
        int cardinal = 0;
        if (cellule != null) {
            cardinal += 1;
            while (cellule.getSuivant() != null) {
                cardinal += 1;
                cellule = cellule.getSuivant();
            }
        }
        return cardinal;
    }

    public boolean estVide() {
        return cellule_initiale == null;
    }

    public boolean contient(int x) {
        Cellule cellule = cellule_initiale;
        boolean contient = false;
        if (cellule != null) {
            if (cellule.getElement() == x) {
                contient = true;
            } else {
                while (cellule.getSuivant() != null) {
                    if (cellule.getSuivant().getElement() == x) {
                        contient = true;
                    }
                    cellule = cellule.getSuivant();
                }
            }
        }
        else {
            contient = false;
        }
        return contient;
    }

    public void ajouter(int x) {
        if (!this.contient(x)) {
            cellule_initiale = new Cellule(x, cellule_initiale);
        }
    }

    public void supprimer(int x) {
        Cellule cellule = cellule_initiale;
        while (cellule != null) {
            if (cellule.getElement() == x) {
                cellule_initiale = cellule.getSuivant();
            } else if (cellule.getSuivant() != null) {
                if (cellule.getSuivant().getElement() == x) {
                    cellule.setSuivant(cellule.getSuivant().getSuivant());
                }
            }
            cellule = cellule.getSuivant();
        }
    }
}
