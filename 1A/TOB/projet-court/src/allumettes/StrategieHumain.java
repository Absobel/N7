package allumettes;

import java.util.Scanner;

/**
 * Joueur humain d'une partie de 13 allumettes. L'utilisateur doit saisir les
 * nombres d'allumettes pris.
 *
 * @author Absobel
 */
public class StrategieHumain implements Strategie {
    /** Scanner pour la saisie, ouvert une seule fois pour tout le programme. */
    private static Scanner sc = new Scanner(System.in);
    /** Nom du joueur. */
    private String nom;

    /**
     * Créer un joueur humain.
     *
     * @param nom le nom du joueur
     */
    public StrategieHumain(String nom) {
        this.nom = nom;
    }

    @Override
    public int getPrise(Jeu jeu) {
        // Permet au joueur de jouer son tour après la triche
        // ou s'il y a une erreur de saisie
        boolean coupValide;
        // Initialisation de prise pour éviter une erreur de compilation mais il y a
        // garantie que la prise sera initialisé
        int prise = -1;

        do {
            System.out.print(nom + ", combien d'allumettes ? ");
            String input = sc.nextLine();

            if (input.equals("triche")) {

                if (jeu.getNombreAllumettes() > 1) {
                    System.out.println(
                            "[Une allumette en moins, plus que "
                            + (jeu.getNombreAllumettes() - 1) + ". Chut !]"
                    );
                    jeu.retirer(1);
                } else {
                    System.out.println(
                        "[Il ne reste qu'une allumette,"
                        + " pas la peine de tricher, tu as perdu !]");
                }
                coupValide = false;

            } else {

                try {
                    prise = Integer.parseInt(input);
                    coupValide = true;
                } catch (NumberFormatException e) {
                    System.out.println("Vous devez donner un entier.");
                    coupValide = false;
                }
            }
        } while (!coupValide);
        return prise;
    }
}
