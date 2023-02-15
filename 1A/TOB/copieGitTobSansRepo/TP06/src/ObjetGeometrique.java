import java.awt.Color;

/** Objet géométrique. Classe abstraite dont héritent tous les objets comme Point ou Segment.
 * @author  Absobel
*/
public abstract class ObjetGeometrique {
    private Color couleur;

    /** Constructeur de l'objet géometrique
     * @param couleur couleur de l'objet géometrique
     */
    public ObjetGeometrique() {
        this.couleur = Color.GREEN;
    }

    /** Obtenir la couleur de l'objet géometrique
     * @return couleur de l'objet géometrique
     */
    public Color getCouleur() {
        return this.couleur;
    }

    /** Changer la couleur de l'objet géometrique
     * @param couleur nouvelle couleur de l'objet géometrique
     */
    public void setCouleur(Color couleur) {
        this.couleur = couleur;
    }

    /** Afficher l'objet géometrique */
    public abstract void afficher();

    /** Translater l'objet géometrique
     * @param dx déplacement suivant l'axe des X
     * @param dy déplacement suivant l'axe des Y
     */
    public abstract void translater(double dx, double dy);

    /** Dessiner l'objet géometrique sur l'afficheur
     * @param afficheur l'afficheur à utiliser
     */
    public abstract void dessiner(afficheur.Afficheur afficheur);
}