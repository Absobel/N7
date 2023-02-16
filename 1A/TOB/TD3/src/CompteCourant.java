package src;

public class CompteCourant extends CompteSimple {
    private Historique historique;

    public CompteCourant(Personne titulaire, double solde) {
        super(titulaire, solde);
        historique = new Historique();
        historique.enregistrer(solde);
    }

    public CompteCourant(Personne titulaire) {
        this(titulaire, 0);
        historique = new Historique();
    }

    public void editerReleve() {
        System.out.println("Relevé du compte courant de " + getTitulaire().getPrenom() + " " + getTitulaire().getNom());
        System.out.println("Solde : " + getSolde() + " euros");
        System.out.println("Historique :");
        for (int i = 0; i < historique.getNbValeurs(); i++) {
            System.out.println("  " + historique.getValeur(i));
        }
    }

    public void afficherReleveCredit() {
        System.out.println("Relevé des crédits du compte courant de " + getTitulaire().getPrenom() + " " + getTitulaire().getNom());
        System.out.println("Solde : " + getSolde() + " euros");
        System.out.println("Historique des crédits :");
        for (int i = 0; i < historique.getNbValeurs(); i++) {
            if (historique.getValeur(i) > 0) {
                System.out.println("  " + historique.getValeur(i));
            }
        }
    }

    public void afficherReleveDebit() {
        System.out.println("Relevé des débits du compte courant de " + getTitulaire().getPrenom() + " " + getTitulaire().getNom());
        System.out.println("Solde : " + getSolde() + " euros");
        System.out.println("Historique des débits :");
        for (int i = 0; i < historique.getNbValeurs(); i++) {
            if (historique.getValeur(i) < 0) {
                System.out.println("  " + historique.getValeur(i));
            }
        }
    }

    public void crediter(double montant) {
        super.crediter(montant);
        historique.enregistrer(montant);
    }

    public void debiter(double montant) {
        super.debiter(montant);
        historique.enregistrer(-montant);
    }
}
