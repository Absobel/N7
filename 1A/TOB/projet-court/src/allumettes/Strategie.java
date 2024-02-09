package allumettes;

public interface Strategie {
    /** Nombre d'allumettes prises par le joueur.
     * @param jeu le jeu à arbitrer
     * @return le nombre d'allumettes prises
     * @throws OperationInterditeException si le joueur triche et que l'arbitre
     *                                    n'est pas confiant
     */
    int getPrise(Jeu jeu);
}
