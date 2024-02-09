package allumettes;

/**
 * Arbitre d'une partie de 13 allumettes.
 *
 * @author Absobel
 */
public class Arbitre {
    /** Joueur n°1. */
    private Joueur joueur1;
    /** Joueur n°2. */
    private Joueur joueur2;
    /** Indique si l'arbitre est confiant. */
    private boolean confiant;

    /**
     * Créer un arbitre pour une partie entre deux joueurs.
     *
     * @param joueur1 le premier joueur
     * @param joueur2 le second joueur
     */
    public Arbitre(Joueur joueur1, Joueur joueur2, boolean confiant) {
        this.joueur1 = joueur1;
        this.joueur2 = joueur2;
        this.confiant = confiant;
    }

    /**
     * Récupérer la prise d'un joueur.
     *
     * @param jeu           le jeu à arbitrer
     * @param joueurCourant le joueur courant
     * @return la prise du joueur
     * @throws OperationInterditeException si le joueur triche et que l'arbitre
     *                                     n'est pas confiant
     */
    private int getPrise(Jeu jeu, Joueur joueurCourant) {
        // Initialisation de prise pour éviter une erreur de compilation mais il y a
        // garantie que la prise sera initialisée
        int prise = -1;
        try {
            prise = joueurCourant.getPrise(jeu);
        } catch (OperationInterditeException e) {
            // Pas besoin de vérifier la confiance car l'exception n'est envoyée
            // que par le proxy qui n'est pas présent si l'arbitre est confiant
            System.out.println(
                "Abandon de la partie car " + joueurCourant.getNom() + " triche !"
            );
            throw e; // Permet de remonter l'erreur pour terminer la partie
        }
        return prise;
    }

    /**
     * Lancer une partie.
     *
     * @param jeu le jeu à arbitrer
     * @throws OperationInterditeException si un joueur triche et que l'arbitre
     *                                     n'est pas confiant
     */
    public void arbitrer(Jeu jeu) throws OperationInterditeException {
        Joueur joueurCourant = joueur1;
        Joueur joueurSuivant = joueur2;
        Jeu jeuADonner = confiant ? jeu : new JeuProcuration(jeu);
        while (jeuADonner.getNombreAllumettes() > 0) { // Boucle principale du jeu
            System.out.println("Allumettes restantes : " + jeuADonner.getNombreAllumettes());

            int prise = -1;
            boolean coupValide = false;
            do { // Boucle pour demander une prise valide
                prise = getPrise(jeuADonner, joueurCourant);
                String strpluriel = prise > 1 ? "s" : "";
                System.out.println(joueurCourant.getNom() + " prend "
                        + prise + " allumette" + strpluriel + ".");
                coupValide = jeuADonner.checkPrise(prise);
            } while (!coupValide);

            try {
                jeuADonner.retirer(prise);
            } catch (OperationInterditeException e) {
                System.out.println(
                    "Abandon de la partie car " + joueurCourant.getNom() + " triche !"
                );
                throw e;
            }

            System.out.println();
            Joueur tmp = joueurCourant;
            joueurCourant = joueurSuivant;
            joueurSuivant = tmp;
        }
        System.out.println(joueurSuivant.getNom() + " perd !");
        System.out.println(joueurCourant.getNom() + " gagne !");
    }
}
