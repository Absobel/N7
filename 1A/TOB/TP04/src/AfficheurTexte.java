import afficheur.Afficheur;
import java.awt.Color;

public class AfficheurTexte implements Afficheur{
    public void dessinerPoint(double x, double y, Color couleur) {
        System.out.println("Point {\n\tx = " + x + "\n\ty = " + y + "\n\tcouleur = " + couleur + "\n}");
    }

    public void dessinerLigne(double x1, double y1, double x2, double y2, Color couleur) {
        System.out.println("Ligne {\n\tx1 = " + x1 + "\n\ty1 = " + y1 + "\n\tx2 = " + x2 + "\n\ty2 = " + y2 + "\n\tcouleur = " + couleur + "\n}");
    }

    public void dessinerCercle(double x, double y, double rayon, Color couleur) {
        System.out.println("Cercle {\n\tcentre_x = " + x + "\n\tcentre_y = " + y + "\n\trayon = " + rayon + "\n\tcouleur = " + couleur + "\n}");
    }

    public void dessinerTexte(double x, double y, String texte, Color couleur) {
        System.out.println("Texte {\n\tx = " + x + "\n\ty = " + y + "\n\tvaleur = " + texte + "\n\tcouleur = " + couleur + "\n}");
    }
}
