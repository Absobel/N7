import java.lang.reflect.*;
import java.util.*;

/**
 * L'objectif est de faire un lanceur simple sans utiliser toutes les clases
 * de notre architecture JUnit. Il permet juste de valider la compréhension
 * de l'introspection en Java.
 */
public class LanceurIndependant {
	private int nbTestsLances = 0;
	private int nbErreurs = 0;
	private int nbEchecs = 0;
	private List<Throwable> erreurs = new ArrayList<>();

	public LanceurIndependant(String... nomsClasses) {
		System.out.println();

		// Lancer les tests pour chaque classe
		for (String nom : nomsClasses) {
			try {
				System.out.print(nom + " : ");
				this.testerUneClasse(nom);
				System.out.println();
			} catch (ClassNotFoundException e) {
				System.out.println(" Classe inconnue !");
			} catch (Exception e) {
				System.out.println(" Problème : " + e);
				e.printStackTrace();
			}
		}

		// Afficher les erreurs
		for (Throwable e : erreurs) {
			System.out.println();
			e.printStackTrace();
		}

		// Afficher un bilan
		System.out.println();
		System.out.printf("%d tests lancés dont %d échecs et %d erreurs.\n",
				nbTestsLances, nbEchecs, nbErreurs);
	}

	public int getNbTests() {
		return this.nbTestsLances;
	}

	public int getNbErreurs() {
		return this.nbErreurs;
	}

	public int getNbEchecs() {
		return this.nbEchecs;
	}

	private void testerUneClasse(String nomClasse)
			throws ClassNotFoundException, InstantiationException,
			IllegalAccessException {
		// Récupérer la classe
		Class<?> classe = Class.forName(nomClasse);

		// Récupérer les méthodes "preparer" et "nettoyer"
		Method preparer;
		try {
			preparer = classe.getMethod("preparer");
		} catch (NoSuchMethodException e) {
			preparer = null;
		}

		Method nettoyer;
		try {
			nettoyer = classe.getMethod("nettoyer");
		} catch (NoSuchMethodException e) {
			nettoyer = null;
		}

		// Instancier l'objet qui sera le récepteur des tests
		Object objet;
		try {
			objet = classe.getConstructor().newInstance();
		} catch (Exception e) {
			System.out.println("Erreur lors de l'instanciation de la classe :");
			e.printStackTrace();
			return;
		}

		// Exécuter les méthods de test
		if (preparer != null) {
			try {
				preparer.invoke(objet);
			} catch (InvocationTargetException e) {
				System.out.println("Erreur dans la méthode preparer :");
				e.getCause().printStackTrace();
				return;
			}
		}

		for (Method methode : classe.getMethods()) {
			if (methode.getName().startsWith("test") && !Modifier.isStatic(methode.getModifiers())) {
				try {
					methode.invoke(objet);
				} catch (InvocationTargetException e) {
					Throwable cause = e.getCause();
					if (cause instanceof Echec) {
						System.out.println("Echec du test " + methode.getName() + " : ");
						System.out.println(cause.getMessage());
						nbEchecs++;
					} else {
						System.out.println("Erreur dans le test " + methode.getName() + " : ");
						nbErreurs++;
						erreurs.add(cause);
					}
				} catch (Exception e) {
					System.out.println("Erreur dans le test " + methode.getName() + " : ");
					nbErreurs++;
					erreurs.add(e);
				}
				nbTestsLances++;
			}
		}

		if (nettoyer != null) {
			try {
				nettoyer.invoke(objet);
			} catch (InvocationTargetException e) {
				System.out.println("Erreur dans la méthode nettoyer :");
				e.getCause().printStackTrace();
				return;
			}
		}
	}

	public static void main(String... args) {
		LanceurIndependant lanceur = new LanceurIndependant(args);
	}

}
