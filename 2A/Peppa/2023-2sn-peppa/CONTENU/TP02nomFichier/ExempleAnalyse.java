import java.util.*;
import static java.lang.System.out;

/**
  * Exemple d'utilisation de l'afficheur.
  */
public class ExempleAnalyse {

	/** Afficher les rÃ©sultats d'une analyse. */
	public static void analyser(Analyseur analyseur, String nomFichier) {
		Collection<Position> nouvelles = analyseur.traiter(nomFichier);

		out.println("Nombres de positions lues/modifiÃ©es : " + nouvelles.size());
		out.println("Nombres de positions stockÃ©es : " + analyseur.positions().size());
		out.println("FrÃ©quence de la positions (1,2) : "
				+ Collections.frequency(analyseur.positions(), new Position(1,2)));
		Map<Position, Double> donnees = analyseur.donnees();
		out.println("DonnÃ©es mises Ã  jour : " + nouvelles.size());
		for (Position p : nouvelles) {
			out.println(" - " + p + " --> " + donnees.get(p));
		}

		out.println("Toutes les donnÃ©es : " + donnees.entrySet().size());
		for (Map.Entry<Position, Double> entree : donnees.entrySet()) {
			out.println(" - " + entree.getKey() + " --> " + entree.getValue());
		}
	}

	/** Analyser des donnÃ©es. */
	public static void main(String[] args) {
		Analyseur a = new Analyseur();
		out.println("\n" + "=== PremiÃ¨re analyse ===");
		analyser(a, "donnees.txt");
	}
}
