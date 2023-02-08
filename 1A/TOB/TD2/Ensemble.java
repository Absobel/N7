/** 
 * Interface pour les ensembles d'entiers.
 */
public interface Ensemble<E> {
    /**
     * Ajoute l'entier n à l'ensemble.
     * pre : !contient(n)
     * post : contient(n)
     * @param n l'entier à ajouter
     */
    public void ajouter(E n);

    /**
     * Supprime l'entier n de l'ensemble.
     * pre : contient(n)
     * post : !contient(n)
     * @param n l'entier à supprimer
     */
    public void supprimer(E n);

    /**
     * Teste si l'entier n est dans l'ensemble.
     * post : estVide() => !result
     * @param n l'entier à tester
     * @return true si l'entier est dans l'ensemble, false sinon
     */
    public boolean contient(E n);

    /**
     * Teste si l'ensemble est vide.
     * @return true si l'ensemble est vide, false sinon
     */
    public boolean estVide();

    /**
     * Retourne le nombre d'entiers dans l'ensemble.
     * @return le nombre d'entiers dans l'ensemble
     */
    public int cardinal();

    /**
     * Retourne le plus petit entier de l'ensemble.
     * invariant : cardinal() > 0
     * invariant : estVide() <==> cardinal() == 0
     * @return le plus petit entier de l'ensemble
     */
    public E min();
}