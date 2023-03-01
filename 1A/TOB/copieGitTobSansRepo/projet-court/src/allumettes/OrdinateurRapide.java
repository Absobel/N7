package allumettes;

public class OrdinateurRapide extends Joueur {
        public OrdinateurRapide(String nom) {
            super(nom);
        }
    
        @Override
        public int getPrise(Jeu jeu) {
            int nb_allumettes = jeu.getNombreAllumettes();
            int prise_max = nb_allumettes > Jeu.PRISE_MAX ? Jeu.PRISE_MAX : nb_allumettes;
            return prise_max;
        }
    
}
