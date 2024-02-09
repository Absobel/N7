package editeur.commande;

import editeur.Ligne;

public class CommandeDebutLigne extends CommandeLigne {
        public CommandeDebutLigne(Ligne l) {
            super(l);
        }
    
        public void executer() {
            ligne.raz();
        }
    
        public boolean estExecutable() {
            return ligne.getCurseur() > 1;
        }    
}
