import java.util.ArrayList;
import java.util.List;
import afficheur.Ecran;

/** Schéma de points et de segments. Utilisation d'un groupe.
 * @author  Absobel
 */
public class ExempleSchemaGroupe {
    /** Construire le schéma et le manipuler.
	  * Le schéma est affiché.
	  * Ensuite, il est translaté et affiché de nouveau.
	  * @param args les arguments de la ligne de commande
	  */
    public static void main(String[] args) {
		// Créer les trois segments
		Point p1 = new PointNomme(3, 2, "A");
		Point p2 = new PointNomme(6, 9, "S");
		Point p3 = new Point(11, 4);
		Segment s12 = new Segment(p1, p2);
		Segment s23 = new Segment(p2, p3);
		Segment s31 = new Segment(p3, p1);

		// Créer le barycentre
		double sx = p1.getX() + p2.getX() + p3.getX();
		double sy = p1.getY() + p2.getY() + p3.getY();
		Point barycentre = new PointNomme(sx / 3, sy / 3, "C");

        // Créer la liste pour initialiser le groupe
        List<ObjetGeometrique> liste = new ArrayList<ObjetGeometrique>();

        // Ajouter les objets géométriques dans la liste
        liste.add(s12);
        liste.add(s23);
        liste.add(s31);
        liste.add(barycentre);

        // Créer le groupe
        Groupe groupe = new Groupe(liste);

        // Afficher le schéma
        System.out.println("Le schéma est composé de : ");
        groupe.afficher();

        // Créer l'écran d'affichage
        Ecran ecran = new Ecran("ExempleSchemaTab", 600, 400, 20);
        ecran.dessinerAxes();
        
        // Dessiner le schéma sur l'écran graphique
        groupe.dessiner(ecran);

        // Translater le schéma
        System.out.println("Translater le schéma de (4, -3) : ");
        groupe.translater(4, -3);

        // Afficher le schéma
        System.out.println("Le schéma est composé de : ");
        groupe.afficher();

        // Dessiner le schéma sur l'écran graphique
        groupe.dessiner(ecran);
    }
}
        


