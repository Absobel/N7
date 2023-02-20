package src;
public class CompteSimple {
    private double solde;
    private Personne titulaire;

    public CompteSimple(Personne titulaire, double solde) {
        assert titulaire != null;
        assert solde >= 0;
        this.titulaire = titulaire;
        this.solde = solde;
    }

    public CompteSimple(Personne titulaire) {
        this(titulaire, 0);
    }

    public void crediter(double montant) {
        assert montant >= 0;
        solde += montant;
    }

    public void debiter(double montant) {
        assert montant >= 0;
        solde -= montant;
    }

    public double getSolde() {
        return solde;
    }

    public Personne getTitulaire() {
        return titulaire;
    }

    public void afficher() {
        System.out.print("Titulaire : ");
        titulaire.afficher();
        System.out.println("Solde : " + solde + " euros");
    }
}