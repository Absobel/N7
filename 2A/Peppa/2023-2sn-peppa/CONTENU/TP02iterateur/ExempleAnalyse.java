import java.util.*;
import java.io.*;
import static java.util.AbstractMap.SimpleImmutableEntry;
import static java.lang.System.out;

/**
  * Exemple d'utilisation de l'afficheur.
  */
public class ExempleAnalyse {

	/** Afficher les rÃ©sultats d'une analyse. */
	public static void analyser(Analyseur analyseur, String nomFichier, LecteurFichier lecteur) throws java.io.FileNotFoundException {
		Collection<Position> nouvelles = null;
		try (AcquisitionFichier source =
					lecteur.lecteur(nomFichier)
		) {
			nouvelles = analyseur.traiter(source);
		}

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
	public static void main(String[] args) throws java.io.FileNotFoundException {
		Analyseur a = new Analyseur();
		out.println("\n" + "=== PremiÃ¨re analyse ===");
		analyser(a, "donnees.txt", LecteurFichier.TYPE1);

		out.println("\n" + "=== DeuxiÃ¨me analyse ===");
		analyser(a, "donnees2-f2.txt", LecteurFichier.TYPE2);
	}
}
