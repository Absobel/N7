package allumettes;

/**
 * Jeu contenant les allumettes.
 *
 * @author Absobel
 */
public class JeuReel implements Jeu {
    /** Nombre d'allumettes restantes. */
    private int nombreAllumettes;

    /**
     * Créer un jeu avec le nombre d'allumettes spécifié.
     *
     * @param nombreAllumettes le nombre d'allumettes
     */
    public JeuReel(int nombreAllumettes) {
        this.nombreAllumettes = nombreAllumettes;
    }

    @Override
    public boolean checkPrise(int prise) {
        int seuil = Math.min(getNombreAllumettes(), Jeu.PRISE_MAX);
        if (prise > seuil || prise < 1) {
            String strSupInf = prise > seuil ? " (> " + seuil + ")" : " (< 1)";
            System.out.println("Impossible ! Nombre invalide : " + prise + strSupInf);
            System.out.println();
            System.out.println("Allumettes restantes : " + getNombreAllumettes());
            return false;
        }
        return true;
    }

    @Override
    public int getNombreAllumettes() {
        return nombreAllumettes;
    }

    @Override
    public void retirer(int nbPrises) {
        nombreAllumettes -= nbPrises;
    }
}
