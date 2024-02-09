import java.util.List;
import java.util.ArrayList;

public class GroupeAgenda extends AgendaAbstrait {
    private List<Agenda> agendas;
    private int nbAgendas;
    
    public GroupeAgenda(String nom) {
        super(nom);
        this.agendas = new ArrayList<Agenda>();
    }
    public GroupeAgenda(String nom, List<Agenda> agendas) {
        super(nom);
        this.agendas = agendas;
    }

    @Override
    public void enregistrer(int creneau, String rdv) throws OccupeException {
        verifierCrenauValide(creneau);
        if (rdv == null || rdv.isEmpty()) {
            throw new IllegalArgumentException("Le rendez-vous ne peut pas être vide");
        }
        List<Agenda> agends_modifies = new ArrayList<Agenda>();
        try {
            for (Agenda agenda : this.agendas) {
                agenda.enregistrer(creneau, rdv);
                agends_modifies.add(agenda);
            }
        } catch (OccupeException e) {
            for (Agenda agenda : agends_modifies) {
                agenda.annuler(creneau);
            }
            throw e;
        }
    }

    @Override
    public boolean annuler(int creneau) {
        verifierCrenauValide(creneau);
        boolean modifie = false;
        for (Agenda agenda : this.agendas) {
            modifie = agenda.annuler(creneau) || modifie;
        }
        return modifie;
    }

    @Override
    public String getRendezVous(int creneau) throws LibreException {
        verifierCrenauValide(creneau);
        String rdv = null;
        boolean all_libre = true;
        boolean all_good = true;
        for (Agenda agenda : this.agendas) {
            try {
                String nrdv = agenda.getRendezVous(creneau);
                all_libre = false;
                if (rdv == null) {
                    rdv = nrdv;
                } else if (!rdv.equals(nrdv)) {
                    all_good = false;
                }
            } catch (LibreException e) {
                all_good = false;
            }
        }
        if (all_libre) {
            throw new LibreException("Le créneau " + creneau + " est libre");
        }
        return all_good ? rdv : null;
    }

    public void ajouter(Agenda agenda) {
        this.agendas.add(agenda);
    }
}
