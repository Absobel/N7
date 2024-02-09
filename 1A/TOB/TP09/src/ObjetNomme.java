/**
 * Un objet nommé est un objet qui a un nom.
 */
public abstract class ObjetNomme {

	private String nom;

	/**
	 * Initialiser le nom de l'agenda.
	 *
	 * @param nom le nom de l'agenda
	 * @throws IllegalArgumentException si nom n'a pas au moins un caractère
	 */
	public ObjetNomme(String nom) {
		if (nom == null || nom.length() == 0) {
			throw new IllegalArgumentException("Le nom ne peut pas être vide");
		}
		this.nom = nom;
	}
	public ObjetNomme() {
		throw new IllegalArgumentException("Le nom ne peut pas être vide");
	}

	/**
	 * Obtenir le nom de cet objet.
	 * @return le nom de cet objet
	 */
	public String getNom() {
		return this.nom;
	}


}
