package allumettes;

/**
 * Joueur d'une partie de 13 allumettes.
 *
 * @author Absobel
 */
public class Joueur {
    /** Nom du joueur. */
    private String nom;
    /** Stratégie du joueur. */
    private Strategie strat;

    /**
     * Créer un joueur avec le nom spécifié.
     *
     * @param nom le nom du joueur
     * @param strat la stratégie du joueur
     */
    public Joueur(String nom, Strategie strat) {
        this.nom = nom;
        this.strat = strat;
    }

    /**
     * Récupérer le nom du joueur.
     *
     * @return le nom du joueur
     */
    public String getNom() {
        return this.nom;
    }

    /**
     * Récupérer la prise du joueur.
     *
     * @param jeu le jeu à arbitrer
     * @return la prise du joueur
     * @throws OperationInterditeException si le joueur triche
     */
    public int getPrise(Jeu jeu) {
        return strat.getPrise(jeu);
    }
}
