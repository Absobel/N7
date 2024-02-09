import java.util.List;
import java.util.ArrayList;

/** Groupe d'objetGeometriques
 * @author Absobel
 */
public class Groupe extends ObjetGeometrique {
    private List<ObjetGeometrique> listeObjets;

    /** Constructeur du groupe
     * @param listeObjets : liste des objets
     */
    public Groupe(List<ObjetGeometrique> listeObjets) {
        this.listeObjets = new ArrayList<>(listeObjets);
    }

    /** afficher le groupe élement par élement */
    public void afficher() {
        for (ObjetGeometrique o : this.listeObjets) {
            o.afficher();
            System.out.println();
        }
    }

    /** translater le groupe élement par élement
     * @param dx déplacement suivant l'axe des X
     * @param dy déplacement suivant l'axe des Y
     */
    public void translater(double dx, double dy) {
        for (ObjetGeometrique o : this.listeObjets) {
            o.translater(dx, dy);
        }
    }

    /** dessiner le groupe élement par élement
     * @param afficheur l'afficheur à utiliser
     */
    public void dessiner(afficheur.Afficheur afficheur) {
        for (ObjetGeometrique o : this.listeObjets) {
            o.dessiner(afficheur);
        }
    }
}
