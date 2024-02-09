package allumettes;

/**
 * Lance une partie des 13 allumettes en fonction des arguments fournis
 * sur la ligne de commande.
 *
 * @author Xavier Crégut
 * @version $Revision: 1.5 $
 */
public class Jouer {
	/** Nombre d'allumettes au début de la partie. */
	private static final int NB_ALLUMETTES = 13;

	/**
	 * Permet de parser un joueur à partir d'un tableau de String.
	 *
	 * @param str le joueur@stratégie donné en argument
	 * @return le joueur
	 */
	private static Joueur parseArgJoueur(String str) {
		String[] joueur = str.split("@");
		return parseJoueur(joueur);
	}

	/**
	 * Lancer une partie. En argument sont donnés les deux joueurs sous
	 * la forme nom@stratégie.
	 *
	 * @param args la description des deux joueurs
	 */
	public static void main(String[] args) {
		try {
			verifierNombreArguments(args);

			Joueur j1;
			Joueur j2;
			Jeu jeu = new JeuReel(NB_ALLUMETTES);
			boolean confiant = args[0].equals("-confiant");

			j1 = parseArgJoueur(args[confiant ? 1 : 0]);
			j2 = parseArgJoueur(args[confiant ? 2 : 1]);

			Arbitre arbitre = new Arbitre(j1, j2, confiant);
			arbitre.arbitrer(jeu);

		} catch (ConfigurationException e) {
			System.out.println();
			System.out.println("Erreur : " + e.getMessage());
			afficherUsage();
			System.exit(1);
		} catch (OperationInterditeException e) {
			// Le programme s'arrête pour cause de triche
		}
	}

	/**
	 * Vérifier le nombre d'arguments fournis sur la ligne de commande.
	 *
	 * @param args les arguments fournis
	 * @throws ConfigurationException si le nombre d'arguments est incorrect
	 */
	private static void verifierNombreArguments(String[] args) {
		final int nbJoueurs = 2;
		if (args.length < nbJoueurs) {
			throw new ConfigurationException("Trop peu d'arguments : "
					+ args.length);
		}
		if (args.length > nbJoueurs + 1) {
			throw new ConfigurationException("Trop d'arguments : "
					+ args.length);
		}
	}

	/**
	 * Créer un joueur à partir de sa strategie.
	 *
	 * @param joueur contient le nom et la strategie du joueur
	 * @return le joueur correspondant
	 * @throws ConfigurationException si la strategie est inconnue
	 */
	private static Joueur parseJoueur(String[] joueur) {
		if (joueur.length != 2) {
			throw new ConfigurationException("Joueur mal défini : "
					+ joueur);
		}
		String nom = joueur[0];
		String strategie = joueur[1];

		switch (strategie) {
		case "naif":
			return new Joueur(nom, new StrategieNaif());
		case "rapide":
			return new Joueur(nom, new StrategieRapide());
		case "expert":
			return new Joueur(nom, new StrategieExpert());
		case "humain":
			return new Joueur(nom, new StrategieHumain(nom));
		case "tricheur":
			return new Joueur(nom, new StrategieTricheur());
		default:
			throw new ConfigurationException("Stratégie inconnue : "
					+ strategie);
		}
	}

	/** Afficher des indications sur la manière d'exécuter cette classe. */
	public static void afficherUsage() {
		System.out.println("\n" + "Usage :"
				+ "\n\t" + "java allumettes.Jouer joueur1 joueur2"
				+ "\n\t\t" + "joueur est de la forme nom@stratégie"
				+ "\n\t\t" + "strategie = naif | rapide | expert | humain | tricheur"
				+ "\n"
				+ "\n\t" + "Exemple :"
				+ "\n\t" + "	java allumettes.Jouer Xavier@humain "
				+ "Ordinateur@naif"
				+ "\n");
	}

}
