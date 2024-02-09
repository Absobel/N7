package menu;

import editeur.Ligne;

public class SousMenu extends Menu implements Commande {
    private Ligne ligne;

    public SousMenu(String nom, Ligne ligne) {
        super(nom);
        this.ligne = ligne;
    }
    
    public void executer() {
		do {
			// Afficher la ligne
			System.out.println();
			ligne.afficher();
			System.out.println();

			// Afficher le menu
			afficher();

			// Sélectionner une entrée dans le menu
			selectionner();

			// Valider l'entrée sélectionnée
			valider();

		} while (!estQuitte());
    }
    
    public boolean estExecutable() {
        return true;
    }
}
