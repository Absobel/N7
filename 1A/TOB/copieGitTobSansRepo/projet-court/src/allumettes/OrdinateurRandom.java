package allumettes;

import java.util.Random;

public class OrdinateurRandom extends Joueur {
    public OrdinateurRandom(String nom) {
        super(nom);
    }

    @Override
    public int getPrise(Jeu jeu) {
        Random rand = new Random();
        int nb_allumettes = jeu.getNombreAllumettes();
        int prise_max = nb_allumettes > Jeu.PRISE_MAX ? Jeu.PRISE_MAX : nb_allumettes;
        int prise = rand.nextInt(prise_max) + 1;
        return prise;
    }    
}
