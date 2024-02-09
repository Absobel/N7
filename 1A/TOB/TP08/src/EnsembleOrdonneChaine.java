public class EnsembleOrdonneChaine extends EnsembleChaine implements EnsembleOrdonne {
    /**
     * Obtenir le plus petit élément de l'ensemble.
     * @return le plus petit élément de l'ensemble
     */
    public int min() {
        Cellule cellule = getCelluleInitiale();
        int min = cellule.getElement();
        while (cellule.getSuivant() != null) {
            if (cellule.getSuivant().getElement() < min) {
                min = cellule.getSuivant().getElement();
            }
            cellule = cellule.getSuivant();
        }
        return min;
    }
}
