import java.awt.Color;
import org.junit.*;
import static org.junit.Assert.*;

/** Classe de test pour la robustesse de la classe Cercle.
  * @author	Absobel <imkonnu@gmail.com>
  */
public class CercleTest {
    // précision pour les comparaisons réelle
	public final static double EPSILON = 0.001;
    protected Cercle c1;
    private Point A, B;

    @Before public void setUp() {
        // Construire les cercles
        c1 = new Cercle(new Point(1, 2), 10);

        // Construire les points
        A = new Point(1,2);
        B = new Point(2,4);
    }

    /** Vérifier si deux points ont mêmes coordonnées.
	  * @param p1 le premier point
	  * @param p2 le deuxième point
	  */
    static void memesCoordonnees(String message, Point p1, Point p2) {
		assertEquals(message + " (x)", p1.getX(), p2.getX(), EPSILON);
		assertEquals(message + " (y)", p1.getY(), p2.getY(), EPSILON);
	}
    /** Centre entre deux points
     * @param p1 le premier point
     * @param p2 le deuxième point
     */
    static Point centre(Point p1, Point p2) {
        return new Point((p1.getX() + p2.getX()) / 2, (p1.getY() + p2.getY()) / 2);
    }


    @Test public void testerE12() {
        this.c1 = new Cercle(A,B);
        assertEquals("E12 : rayon incorrect", A.distance(B), this.c1.getDiametre(), EPSILON);
        memesCoordonnees("E12 : Centre de C1 incorrect", centre(A, B), this.c1.getCentre());
        assertEquals("E12 : Couleur incorrecte", Color.blue, this.c1.getCouleur());
    }

    @Test public void testerE13() {
        this.c1 = new Cercle(A,B, Color.yellow);
        assertEquals("E13 : rayon incorrect", A.distance(B), this.c1.getDiametre(), EPSILON);
        memesCoordonnees("E13 : Centre de C1 incorrect", centre(A, B), this.c1.getCentre());
        assertEquals("E13 : Couleur incorrecte", Color.yellow, this.c1.getCouleur());
    }

    @Test public void testerE14() {
        this.c1 = Cercle.creerCercle(A,B);
        assertEquals("E14 : rayon incorrect", A.distance(B), this.c1.getRayon(), EPSILON);
        memesCoordonnees("E14 : Centre de C1 incorrect", A, this.c1.getCentre());
        assertEquals("E14 : Couleur incorrecte", Color.blue, this.c1.getCouleur());
    }
}