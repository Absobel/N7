package allumettes;

import java.util.Random;

/**
 * Joueur d'une partie de 13 allumettes contrôlé par un ordinateur qui joue de
 * manière aléatoire.
 *
 * @author Absobel
 */
public class StrategieNaif implements Strategie {

    @Override
    public int getPrise(Jeu jeu) {
        Random rand = new Random();
        int priseMax = Math.min(jeu.getNombreAllumettes(), Jeu.PRISE_MAX);
        return rand.nextInt(priseMax) + 1;
    }
}
