/**
 * Classe représentant la cellule d'un ensemble chainé.
 */
public class Cellule {
    private int element;
    private Cellule suivant;

    /**
     * Constructeur de la cellule.
     * @param element l'élément à stocker dans la cellule
     * @param suivant la cellule suivante
     */
    public Cellule(int element, Cellule suivant) {
        this.element = element;
        this.suivant = suivant;
    }

    /**
     * Obtenir l'élément stocké dans la cellule.
     * @return l'élément stocké dans la cellule
     */
    public int getElement() {
        return element;
    }

    /**
     * Obtenir la cellule suivante.
     * @return la cellule suivante
     */
    public Cellule getSuivant() {
        return suivant;
    }

    /**
     * Modifier l'élément stocké dans la cellule.
     * @param element le nouvel élément à stocker dans la cellule
     */
    public void setElement(int element) {
        this.element = element;
    }

    /**
     * Modifier la cellule suivante.
     * @param suivant la nouvelle cellule suivante
     */
    public void setSuivant(Cellule suivant) {
        this.suivant = suivant;
    }
}
