package allumettes;

public interface Jeu {

	/** Nombre maximal d'allumettes pouvant être prises. */
	final int PRISE_MAX = 3;

	/**
	 * Vérifier si le nombre d'allumettes prises est valide.
	 *
	 * @param prise nombre d'allumettes prises
	 * @return vrai si le nombre d'allumettes prises est valide
	 */
	boolean checkPrise(int prise);

	/**
	 * Obtenir le nombre d'allumettes encore en jeu.
	 *
	 * @return nombre d'allumettes encore en jeu
	 */
	int getNombreAllumettes();

	/**
	 * Retirer des allumettes. Le nombre d'allumettes doit être compris
	 * entre 1 et PRISE_MAX, dans la limite du nombre d'allumettes encore
	 * en jeu.
	 *
	 * @param nbPrises nombre d'allumettes prises.
	 * @throws CoupInvalideException       tentative de prendre un nombre invalide
	 *                                     d'allumettes
	 * @throws OperationInterditeException tentative de triche
	 */
	void retirer(int nbPrises);

}
