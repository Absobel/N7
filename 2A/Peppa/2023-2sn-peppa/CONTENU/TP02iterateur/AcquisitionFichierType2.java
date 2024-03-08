/**
  * AcquisitionFichierType2 
  *
  * @author	Xavier CrÃ©gut <Prenom.Nom@enseeiht.fr>
  */
import static java.util.AbstractMap.SimpleImmutableEntry;

public class AcquisitionFichierType2 extends AcquisitionFichier {

	public AcquisitionFichierType2(String nomFichier) throws java.io.FileNotFoundException {
		super(nomFichier);
	}

	@Override
	protected SimpleImmutableEntry<Position, Double> informationsLigne(String line) {
		String[] words = line.split("\\s+");
		assert words.length == 6 : "words count: " + words.length;	// 6 words on each line
		int x = Integer.parseInt(words[1]);
		int y = Integer.parseInt(words[2]);
		Position position = new Position(x, y);
		double valeur = Double.parseDouble(words[4]);
		return new SimpleImmutableEntry<Position, Double>(position, valeur);
	}

}
