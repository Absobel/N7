package allumettes;

/**
 * Proxy de la classe Jeu vérifiant l'éventuel triche des joueurs.
 *
 * @author Absobel
 */
public class JeuProcuration implements Jeu {
    /** Jeu dont cette classe est le proxy. */
    private Jeu jeu;

    /**
     * Créer un proxy pour un jeu.
     *
     * @param jeu le jeu à protéger
     */
    public JeuProcuration(Jeu jeu) {
        this.jeu = jeu;
    }

    @Override
    public boolean checkPrise(int prise) {
        return jeu.checkPrise(prise);
    }

    @Override
    public int getNombreAllumettes() {
        return jeu.getNombreAllumettes();
    }

    @Override
    public void retirer(int nbPrises) {
        // Detecte qui a appelé la méthode via la trace et renvoie une exception si
        // c'est pas l'arbitre
        Throwable t = new Throwable();

        StackTraceElement[] stackTrace = t.getStackTrace();
        if (stackTrace[1].getClassName() != "allumettes.Arbitre") {
            throw new OperationInterditeException("Tentative de triche");
        }
        jeu.retirer(nbPrises);
    }
}
