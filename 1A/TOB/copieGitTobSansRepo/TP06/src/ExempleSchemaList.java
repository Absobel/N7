import java.util.ArrayList;
import java.util.List;
import afficheur.Ecran;

/** Schéma de points et de segments. Utilisation d'une liste.
 * @author  Absobel
 */
public class ExempleSchemaList {
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

        // Créer la liste (vide)
        List<ObjetGeometrique> liste = new ArrayList<ObjetGeometrique>();

        // Ajouter les objets géométriques dans la liste
        liste.add(s12);
        liste.add(s23);
        liste.add(s31);
        liste.add(barycentre);

		// Afficher le schéma
		System.out.println("Le schéma est composé de : ");
        for (ObjetGeometrique o : liste) {
            o.afficher();
            System.out.println();
        }

		// Créer l'écran d'affichage
		Ecran ecran = new Ecran("ExempleSchemaTab", 600, 400, 20);
		ecran.dessinerAxes();

		// Dessiner le schéma sur l'écran graphique
		for (ObjetGeometrique o : liste) {
            o.dessiner(ecran);
        }

		// Translater le schéma
		System.out.println("Translater le schéma de (4, -3) : ");
		for (ObjetGeometrique o : liste) {
            o.translater(4, -3);
        }

		// Afficher le schéma
		System.out.println("Le schéma est composé de : ");
		for (ObjetGeometrique o : liste) {
            o.afficher();
            System.out.println();
        }

		// Dessiner le schéma sur l'écran graphique
		for (ObjetGeometrique o : liste) {
            o.dessiner(ecran);
        }

		// Forcer l'affichage du schéma (au cas où...)
		ecran.rafraichir();
    }
}
