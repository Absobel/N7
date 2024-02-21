import java.io.*;
import java.net.URLConnection;
import java.util.*;

/** Analyser des donnÃ©es d'un fichier, une donnÃ©e par ligne avec 4 informations
 * sÃ©parÃ©es par des blancs : x, y, ordre (ignorÃ©e), valeur.
 */
public class Analyseur {
	/** Conserve la somme des valeurs associÃ©es Ã  une position. */
	private Map<Position, Double> cumuls;

	/** Construire un analyseur vide. */
	public Analyseur() {
		cumuls = new HashMap<>();
	}

	private static class MalformedFileException extends RuntimeException {
		public MalformedFileException(String message) {
			super(message);
		}
	}

	private static String getMimeType(String filePath) {
        return URLConnection.guessContentTypeFromName(filePath);
    }

	/** Charger l'analyseur avec les donnÃ©es du fichier "donnees.java". */
	public void charger_txt(String path) {
		try (BufferedReader in = new BufferedReader(new FileReader(path))) {
			String ligne = null;
			while ((ligne = in.readLine()) != null) {
				String[] mots = ligne.split("\\s+");
				int x, y;
				double valeur;
				if (mots.length == 4) {
					x = Integer.parseInt(mots[0]);
					y = Integer.parseInt(mots[1]);
					valeur = Double.parseDouble(mots[3]);
				} else if (mots.length == 6) {
					x = Integer.parseInt(mots[1]);
					y = Integer.parseInt(mots[2]);
					valeur = Double.parseDouble(mots[4]);
				} else {
					throw new MalformedFileException("Nombre de colonnes incorrect : " + mots.length);
				}
				if (x < 0 || y < 0 || valeur < 0) throw new MalformedFileException("Valeurs négatives");
				Position p = new Position(x, y);
				cumuls.put(p, valeur(p) + valeur);
				// p.setY(p.getY() + 1);	//  p.y += 1;
			}
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}

	public void charger_csv(String path) {
		try (BufferedReader in = new BufferedReader(new FileReader(path))) {
			String ligne = null;
			while ((ligne = in.readLine()) != null) {
				String[] mots = ligne.split(",(?=(?:[^\"]*\"[^\"]*\")*[^\"]*$)");
				int x, y;
				double valeur;
				if (mots.length == 4) {
					x = Integer.parseInt(mots[0]);
					y = Integer.parseInt(mots[1]);
					valeur = Double.parseDouble(mots[3]);
				} else if (mots.length == 6) {
					x = Integer.parseInt(mots[1]);
					y = Integer.parseInt(mots[2]);
					valeur = Double.parseDouble(mots[4]);
				} else {
					throw new MalformedFileException("Nombre de colonnes incorrect : " + mots.length);
				}
				if (x < 0 || y < 0 || valeur < 0) throw new MalformedFileException("Valeurs négatives");
				Position p = new Position(x, y);
				cumuls.put(p, valeur(p) + valeur);
				// p.setY(p.getY() + 1);	//  p.y += 1;
			}
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}

	public void charger_xml(String path) {
		// TODO
	}

	public void charger(String path) {
		String mimeType = getMimeType(path);
		switch (mimeType) {
			case "text/plain":
				charger_txt(path);
				break;
			case "text/csv":
				charger_csv(path);
				break;
			case "text/xml":
				charger_xml(path);
				break;
			default:
				throw new RuntimeException("Type de fichier non supporté");
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

	/** Affichier les donnÃ©es. */
	public static void main(String[] args) {
		if (args.length != 1) {
			System.out.println("Path of the file : ");
			Scanner sc = new Scanner(System.in);
			args = new String[1];
			args[0] = sc.nextLine();
		}

		Analyseur a = new Analyseur();
		a.charger(args[0]);
		System.out.println(a.donnees());
		System.out.println("Nombres de positions : " + a.donnees().size());
	}
}
