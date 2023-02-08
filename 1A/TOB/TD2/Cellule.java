public class Cellule<E> {
    private E valeur;
    private Cellule<E> suivante;

    public Cellule(E valeur, Cellule<E> suivante) {
        this.valeur = valeur;
        this.suivante = suivante;
    }

    public E getValeur() {
        return valeur;
    }

    public void setValeur(E valeur) {
        this.valeur = valeur;
    }

    public Cellule<E> getSuivante() {
        return suivante;
    }

    public void setSuivante(Cellule<E> suivante) {
        this.suivante = suivante;
    }
}