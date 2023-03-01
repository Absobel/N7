package allumettes;

public class OrdinateurExpert extends Joueur {
    public OrdinateurExpert(String nom) {
        super(nom);
    }

    @Override
    public int getPrise(Jeu jeu) {
        int nb_allumettes = jeu.getNombreAllumettes();
        int reste = (nb_allumettes-1) % (Jeu.PRISE_MAX + 1);
        int prise = 1;
        if (reste != 0) {
            prise = reste;
        }
        return prise;
    }
}
