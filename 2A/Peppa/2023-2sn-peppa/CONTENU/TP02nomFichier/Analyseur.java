import java.io.*;
import java.util.*;

/** Analyser des donnÃ©es d'un fichier, une donnÃ©e par ligne avec 4 informations
 * sÃ©parÃ©es par des blancs : x, y, ordre (ignorÃ©e), valeur.
 */
public class Analyseur {
	/** Conserve la somme des valeurs associÃ©es Ã  une position. */
	private Map<Position, Double> cumuls = new HashMap<>();
	private List<Position> positions = new ArrayList<>();
	private List<Double> valeurs = new ArrayList<>();

	/** Charger l'analyseur avec les donnÃ©es du fichier "donnees.java". */
	public Set<Position> traiter(String nomFichier) {
		try (BufferedReader in = new BufferedReader(new FileReader(nomFichier))) {
			Set<Position> positionsLues = new HashSet<>();
			String ligne = null;
			while ((ligne = in.readLine()) != null) {
				String[] mots = ligne.split("\\s+");
				assert mots.length == 4;	// 4 mots sur chaque ligne
				double valeur = Double.parseDouble(mots[3]);
				int x = Integer.parseInt(mots[0]);
				int y = Integer.parseInt(mots[1]);
				Position p = new Position(x, y);
				positionsLues.add(p);
				positions.add(p);
				valeurs.add(valeur);
				cumuls.put(p, valeur(p) + valeur);
			}
			return positionsLues;
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}

	/** Obtenir la valeur associÃ©e Ã  une position. */
	public double valeur(Position position) {
		Double valeur = cumuls.get(position);
		return valeur == null ? 0.0 : valeur;
	}

	/** Obtenir toutes les donnÃ©es. */
	public Map<Position, Double> donnees() {
		return Collections.unmodifiableMap(this.cumuls);
	}

	/** Obtenir toutes les positions dans l'ordre de lecture. */
	public List<Position> positions() {
		return Collections.unmodifiableList(this.positions);
	}

	/** Obtenir toutes les valeur dans l'ordre de lecture. */
	public List<Double> valeurs() {
		return Collections.unmodifiableList(this.valeurs);
	}

}
