/**
  * AcquisitionFichierType1 
  *
  * @author	Xavier CrÃ©gut <Prenom.Nom@enseeiht.fr>
  */
import static java.util.AbstractMap.SimpleImmutableEntry;

public class AcquisitionFichierType1 extends AcquisitionFichier {

	public AcquisitionFichierType1(String nomFichier) throws java.io.FileNotFoundException {
		super(nomFichier);
	}

	@Override
	protected SimpleImmutableEntry<Position, Double> informationsLigne(String line) {
		String[] words = line.split("\\s+");
		assert words.length == 4 : "words count: " + words.length;	// 4 words on each line
		int x = Integer.parseInt(words[0]);
		int y = Integer.parseInt(words[1]);
		Position position = new Position(x, y);
		double valeur = Double.parseDouble(words[3]);
		return new SimpleImmutableEntry<Position, Double>(position, valeur);
	}

}
