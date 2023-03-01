package allumettes;

import java.util.InputMismatchException;

/**
 * Arbitre d'une partie de 13 allumettes.
 * @author	Absobel
 */
public class Arbitre {
    /** Joueur n°1 */
    Joueur joueur1;
    /** Joueur n°2 */
    Joueur joueur2;
    
    /** Créer un arbitre pour une partie entre deux joueurs.
     * @param joueur1 le premier joueur
     * @param joueur2 le second joueur
     */
    public Arbitre (Joueur joueur1, Joueur joueur2) {
        this.joueur1 = joueur1;
        this.joueur2 = joueur2;
    }

    /** Lancer une partie.
     * @param jeu le jeu à arbitrer
     */
    public void arbitrer(Jeu jeu) {
        Joueur joueurCourant = joueur1;
        Joueur joueurSuivant = joueur2;
        while (jeu.getNombreAllumettes() > 0) {
            System.out.println("Allumettes restantes : " + jeu.getNombreAllumettes());
            int prise = -1;
            do {
                try {
                    prise = joueurCourant.getPrise(jeu);
                    System.out.println(joueurCourant.getNom() + " prend " + prise + " allumette" + (prise <= 1 ? "" : "s") + ".");
                    jeu.retirer(prise);
                } catch (CoupInvalideException e) {
                    System.out.println("Impossible ! Nombre invalide : " + prise + (prise > Jeu.PRISE_MAX ? " (> " + Jeu.PRISE_MAX + ")" : " (< 1)"));
                } catch (InputMismatchException e) {
                    System.out.println("Vous devez donner un entier.");
                }
            } while (prise < 1 || prise > Jeu.PRISE_MAX);
            System.out.println();
            Joueur tmp = joueurCourant;
            joueurCourant = joueurSuivant;
            joueurSuivant = tmp;
        }
        System.out.println(joueurSuivant.getNom() + " perd !");
        System.out.println(joueurCourant.getNom() + " gagne !");
    }
}
