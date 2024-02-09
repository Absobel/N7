package editeur.commande;

import editeur.Ligne;

public class CommandeSupprimer extends CommandeLigne {
        public CommandeSupprimer(Ligne l) {
            super(l);
        }
    
        public void executer() {
            ligne.supprimer();
        }
    
        public boolean estExecutable() {
            return ligne.getLongueur() > 0;
        }    
}