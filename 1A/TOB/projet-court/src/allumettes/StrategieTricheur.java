package allumettes;

/**
 * Joueur tricheur d'une partie de 13 allumettes. Il triche en prenant toutes
 * les allumettes restantes sauf une.
 *
 * @author Absobel
 */
public class StrategieTricheur implements Strategie {

    @Override
    public int getPrise(Jeu jeu) {
        // N'as pas besoin de tricher si il reste moins de 5
        // allumettes car il peut gagner sans.
        if (jeu.getNombreAllumettes() >= Jeu.PRISE_MAX + 2) {

            System.out.println("[Je triche...]");
        }

        // Si il reste plus de PRISE_MAX allumettes, on en prend toutes sauf 2,
        // on en prend une sans tricher et on en laisse une pour le prochain.
        if (jeu.getNombreAllumettes() >= Jeu.PRISE_MAX) {
            jeu.retirer(jeu.getNombreAllumettes() - 2);
        }
        System.out.println("[Allumettes restantes : " + jeu.getNombreAllumettes() + "]");
        return 1; // Prendre l'avant dernière allumette
    }
}
