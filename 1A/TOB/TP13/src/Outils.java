import java.util.List;

/** Quelques outils (méthodes) sur les listes.  */
public class Outils {

	/** Retourne vrai ssi tous les éléments de la collection respectent le critère. */
	public static <E> boolean tous(
			List<E> elements,
			Critere<? super E> critere)
	{
		for (E element : elements) {
			if (! critere.satisfaitSur(element)) {
				return false;
			}
		}
		return true;
	}


	/** Ajouter dans resultat tous les éléments de la source
	 * qui satisfont le critère aGarder.
	 */
	public static <E> void filtrer(
			List<E> source,
			Critere<? super E> aGarder,
			List<? super E> resultat)
	{
		for (E element : source) {
			if (aGarder.satisfaitSur(element)) {
				resultat.add(element);
			}
		}
	}

}
