import java.util.*;
import static java.util.AbstractMap.SimpleImmutableEntry;
import static java.lang.System.out;

/**
  * ExempleAnalyse2 
  *
  * @author	Xavier CrÃ©gut <Prenom.Nom@enseeiht.fr>
  */
public class ExempleAnalyse2 {
	public static void main(String[] args) throws java.io.FileNotFoundException {
		Analyseur a = new Analyseur();
		out.println("=== PremiÃ¨re analyse ===");
		ExempleAnalyse.analyser(a, "donnees.txt", LecteurFichier.TYPE1);

		// IncrÃ©menter l'ordonnÃ©e des positions des donnÃ©es de l'analyseur.
		out.println("IncrÃ©menter l'ordonnÃ©e des positions");
		for (Position p : a.donnees().keySet()) {
			p.y += 1;
		}

		// Afficher toutes les donnÃ©es
		out.println("Toutes les donnÃ©es :");
		for (Map.Entry<Position, Double> entree : a.donnees().entrySet()) {
			out.println(" - " + entree.getKey() + " --> " + entree.getValue());
		}

		// Afficher toutes les donnÃ©es (autre approche)
		out.println("Toutes les donnÃ©es (bis) :");
		for (Position p : a.donnees().keySet()) {
			out.println(" - Somme en " + p + " = " + a.donnees().get(p));
		}
	}

}
