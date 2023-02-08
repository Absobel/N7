import java.awt.Color;

/** 
 * Un cercle est défini par son centre et son rayon. Un cercle peut être translaté.
 *
 * @author	Absobel
 * @version	1.0
 */
public class Cercle implements Mesurable2D {
    public static final double PI = Math.PI;
    private Point centre;
    private double rayon;
    private Color couleur;

    /** Méthode de classe permettant de créer un cercle à partir du centre et d'un point sur le cercle. Sa couleur est bleue par défaut.
     * @param centre	Le centre du cercle.
     * @param p	Un point sur le cercle.
     * @return	Le cercle créé.
     */
    public static Cercle creerCercle(Point centre, Point p) {
        assert centre != null : "Erreur : le centre est null";
        assert p != null : "Erreur : le point est null";
        return new Cercle(centre, centre.distance(p));
    }

    /** Constructeur de la classe Cercle à partir de son centre et de son rayon. Sa couleur est bleue par défaut.
     * @param centre	Le centre du cercle.
     * @param rayon		Le rayon du cercle.
     */
    public Cercle(Point centre, double rayon) {
        assert centre != null : "Erreur : le centre est null";
        assert rayon > 0 : "Erreur : le rayon est négatif ou nul";		
        this.centre = new Point(centre.getX(), centre.getY());
        this.rayon = rayon;
        this.couleur = Color.BLUE;
    }

    /** Constructeur de la classe Cercle à partir de deux points diamétralement opposés. Sa couleur est bleue par défaut.
     * @param p1	Un point du cercle.
     * @param p2	L'autre point du cercle.
     */
    public Cercle(Point p1, Point p2) {
        assert p1 != null : "Erreur : le premier point est null";
        assert p2 != null : "Erreur : le deuxième point est null";
        assert !(p1.getX() == p2.getX() && p1.getY() == p2.getY()) : "Erreur : les deux points sont identiques";
        this.centre = new Point((p1.getX() + p2.getX()) / 2, (p1.getY() + p2.getY()) / 2);
        this.rayon = p1.distance(p2) / 2;
        this.couleur = Color.BLUE;
    }

    /** Constructeur de la classe Cercle à partir de deux points diamétralement opposés et de sa couleur.
     * @param p1	Un point du cercle.
     * @param p2	L'autre point du cercle.
     * @param couleur	La couleur du cercle.
     */
    public Cercle(Point p1, Point p2, Color couleur) {
        this(p1,p2);
        this.couleur = couleur;
    }

    /** Retourne une copie du centre du cercle.
     * @return	Le centre du cercle.
     */
    public Point getCentre() {
        return new Point(centre.getX(), centre.getY());
    }

    /** Retourne le rayon du cercle.
     * @return	Le rayon du cercle.
     */
    public double getRayon() {
        return rayon;
    }

    /** Retourne le diamètre du cercle.
     * @return	Le diamètre du cercle.
     */
    public double getDiametre() {
        return rayon * 2;
    }

    /** Retourne la couleur du cercle.
     * @return	La couleur du cercle.
     */
    public Color getCouleur() {
        return couleur;
    }

    /** Modifie le rayon du cercle.
     * @param rayon	Le nouveau rayon du cercle.
     */
    public void setRayon(double rayon) {
        assert rayon > 0 : "Erreur : le rayon est négatif ou nul";
        this.rayon = rayon;
    }

    /** Modifie le diamètre du cercle.
     * @param diametre	Le nouveau diamètre du cercle.
     */
    public void setDiametre(double diametre) {
        assert diametre > 0 : "Erreur : le diamètre est négatif ou nul";
        this.rayon = diametre / 2;
    }

    /** Modifie la couleur du cercle.
     * @param couleur	La nouvelle couleur du cercle.
     */
    public void setCouleur(Color couleur) {
        assert couleur != null : "Erreur : la couleur est null";
        this.couleur = couleur;
    }

    /** Déplace le cercle de dx en abscisse et de dy en ordonnée.
     * @param dx	Le déplacement en abscisse.
     * @param dy	Le déplacement en ordonnée.
     */
    public void translater(double dx, double dy) {
        centre.translater(dx, dy);
    }

    /** Permet de savoir si un point est à l'intérieur du cercle.
     * @return true si le point est à l'intérieur du cercle, false sinon.
     */
    public boolean contient(Point p) {
        assert p != null : "Erreur : le point est null";
        return centre.distance(p) <= rayon;
    }

    /** Renvoie le périmètre du cercle.
     * @return Le périmètre du cercle.
     */
    public double perimetre() {
        return 2 * PI * rayon;
    }

    /** Renvoie l'aire du cercle.
     * @return L'aire du cercle.
     */
    public double aire() {
        return PI * rayon * rayon;
    }

    /** Affiche le cercle sous la forme suivante Cr@(a, b) où r est la valeur du rayon et (a, b) le centre du cercle.
     * @return une chaîne de caractères représentant le cercle.
    */
    public String toString() {
        return "C" + rayon + "@" + "(" + centre.getX() + ", " + centre.getY() + ")";
    }

}   