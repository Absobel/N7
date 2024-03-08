/**
  * AcquisitionFichier 
  *
  * @author	Xavier CrÃ©gut <Prenom.Nom@enseeiht.fr>
  */
import java.io.*;
import java.util.*;
import static java.util.AbstractMap.SimpleImmutableEntry;

abstract public class AcquisitionFichier implements
		Iterable<SimpleImmutableEntry<Position, Double>>,
		Iterator<SimpleImmutableEntry<Position, Double>>,
		AutoCloseable
{
	private BufferedReader in ;
	private String ligneSuivante;

	public AcquisitionFichier(String nomFichier) throws FileNotFoundException {
		this.in = new BufferedReader(new FileReader(nomFichier));
		this.lireLigne();
	}

	@Override
	public Iterator<SimpleImmutableEntry<Position, Double>> iterator() {
		return this;
	}

	@Override
	public void close() {
		try {
			if (this.in != null) {
				this.in.close();
				this.in = null;
			}
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	final public boolean hasNext() {
		return this.ligneSuivante != null;
	}

	/** Retourner les informations d'une ligne : une position et une valeur.
	 * @param ligne la ligne Ã  dÃ©coder
	 * @return la postion (clÃ©) et la valeur (value) dÃ©finies sur ligne
	 */
	abstract protected SimpleImmutableEntry<Position, Double> informationsLigne(String ligne);

	@Override
	final public SimpleImmutableEntry<Position, Double> next() {
		String ligne = this.ligneSuivante;
		this.lireLigne();
		return informationsLigne(ligne);
	}

	@Override
	final public void remove() {
		throw new UnsupportedOperationException();
	}

	/** Lire un nouvelle ligne. Ferme le fichier si la fin est atteinte. */
	private void lireLigne() {
		try {
			this.ligneSuivante = this.in.readLine();
			if (this.ligneSuivante == null) {	// On peut donc fermer le fichier
				this.close();
			}
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}

}
