/**
 * Définition d'un agenda individuel.
 */
public class AgendaIndividuel extends AgendaAbstrait {

	private String[] rendezVous;	// le texte des rendezVous


	/**
	 * Créer un agenda vide (avec aucun rendez-vous).
	 *
	 * @param nom le nom de l'agenda
	 * @throws IllegalArgumentException si nom nul ou vide
	 */
	public AgendaIndividuel(String nom) {
		super(nom);
		this.rendezVous = new String[Agenda.CRENEAU_MAX + 1];
			// On gaspille une case (la première qui ne sera jamais utilisée)
			// mais on évite de nombreux « creneau - 1 »
	}


	@Override
	public void enregistrer(int creneau, String rdv) throws OccupeException {
		this.verifierCrenauValide(creneau);
		if (rdv == null || rdv.isEmpty()) {
			throw new IllegalArgumentException("Le rendez-vous ne peut pas être vide");
		}
		if (this.rendezVous[creneau] != null) {
			throw new OccupeException("Le créneau " + creneau + " est déjà occupé");
		}
		this.rendezVous[creneau] = rdv;
	}


	@Override
	public boolean annuler(int creneau) {
		this.verifierCrenauValide(creneau);
		boolean modifie = this.rendezVous[creneau] != null;
		this.rendezVous[creneau] = null;
		return modifie;
	}


	@Override
	public String getRendezVous(int creneau) throws LibreException {
		this.verifierCrenauValide(creneau);
		if (this.rendezVous[creneau] == null) {
			throw new LibreException("Le créneau " + creneau + " est libre");
		}
		return this.rendezVous[creneau];
	}


}
