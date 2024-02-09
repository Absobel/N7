package allumettes;

/**
 * Joueur d'une partie de 13 allumettes contrôlé par un ordinateur qui joue en
 * suivant la meilleure stratégie.
 *
 * @author Absobel
 */
public class StrategieExpert implements Strategie {

    @Override
    public int getPrise(Jeu jeu) {
        int nbAllumettes = jeu.getNombreAllumettes();
        // On fait en sorte que le joueur advrese se retrouve toujours
        // avec 1+k*(PRISE_MAX+1) allumettes.
        int reste = (nbAllumettes - 1) % (Jeu.PRISE_MAX + 1);
        int prise;
        if (reste != 0) {
            prise = reste;
        } else {
            prise = 1;
            // Si c'est l'ordinateur qui se retrouve dans ce cas, il prend 1 allumette par
            // défaut.
        }
        return prise;
    }
}
