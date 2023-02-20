package src;
public class Personne {
    private String prenom;
    private String nom;
    private boolean masculin;

    public Personne(String prenom, String nom, boolean masculin) {
        this.prenom = prenom;
        this.nom = nom;
        this.masculin = masculin;
    }

    public String getNom() {
        return nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public boolean estHomme() {
        return masculin;
    }

    public boolean estFemme() {
        return !masculin;
    }

    public void afficher() {
        System.out.println(prenom + " " + nom + " : " + (masculin ? "M" : "F"));
    }
}
