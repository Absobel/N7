import java.io.FileNotFoundException;

/**
  * LecteurFichier 
  *
  * @author	Xavier CrÃ©gut <Prenom.Nom@enseeiht.fr>
  */
public enum LecteurFichier {
	TYPE1 {
		@Override
		public AcquisitionFichier lecteur(String nomFichier) throws FileNotFoundException {
			return new AcquisitionFichierType1(nomFichier);
		}
	},
	TYPE2 {
		@Override
		public AcquisitionFichier lecteur(String nomFichier) throws FileNotFoundException {
			return new AcquisitionFichierType2(nomFichier);
		}
	};

	public abstract AcquisitionFichier lecteur(String nomFichier) throws FileNotFoundException;
}
