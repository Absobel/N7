public class EditeurLigne {
    private int capacite;
    private Ligne l;


    public EditeurLigne(int capacite) {
        this.capacite = capacite;
        this.l = new LigneTab(capacite);
    }
    public EditeurLigne(Ligne l) {
        this.l = l;
    }

    public boolean[] commandes_indisponibles() {
        boolean[] tab = {
            l.getLongueur() != this.capacite,
            l.getLongueur() != this.capacite,
            l.getLongueur() != 0,
            l.getLongueur() != 0 || l.getCurseur() != l.getLongueur(),
            l.getLongueur() != 0 || l.getCurseur() != 0,
            l.getLongueur() != 0,
            l.getLongueur() != 0,
            l.getLongueur() != 0,
            l.getLongueur() != 0,
            true,
        };
        return tab;
    }

    public void afficher_menu(boolean[] tab) {
        for (int i=0; i < 10; i++) {
            if (tab[i]) {
                System.out.println(i+")");
            } else {
                System.out.println("-)");
            }
        }
    }

    public void editer() {
        int choix;
        do {
            boolean[] tab = commandes_indisponibles();
            afficher_menu(tab);
            // choix = 
            //char caractere =
            if (tab[choix-1]) {
                switch (choix-1) {
                    case 0:
                        l.ajouterDebut('a');
                        break;
                    case 1:
                        l.ajouterFin('a');
                        break;
                    case 2:
                        l.raz();
                        break;
                    case 3:
                        l.avancer();
                        break;
                    case 4:
                        l.reculer();
                        break;
                    case 5:
                        l.remplacer('a');
                        break;
                    case 6:
                        l.supprimer();
                        break;
                    case 7:
                        l.ajouterAvant('a');
                        break;
                    case 8:
                        l.ajouterApres('a');
                        break;
                    case 9: //Supprimer la ligne
                        l = new LigneTab(capacite);
                        break;
                    case 10:
                        break;
                    default:
                        System.out.println("Choix invalide");
                }
            }
            l.afficher();
        } while (choix != 11);
    }
}   
