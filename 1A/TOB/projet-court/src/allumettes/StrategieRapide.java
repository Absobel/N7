package allumettes;

/**
 * Joueur d'une partie de 13 allumettes contrôlé par un ordinateur qui joue en
 * prenant le nombre maximum d'allumettes.
 *
 * @author Absobel
 */
public class StrategieRapide implements Strategie {
    @Override
    public int getPrise(Jeu jeu) {
        assert jeu != null;
        return Math.min(jeu.getNombreAllumettes(), Jeu.PRISE_MAX);
    }
}
