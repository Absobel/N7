package src;

import java.util.ArrayList;
import java.util.List;

public class Banque {
    private List<CompteSimple> comptes;

    public Banque() {
        comptes = new ArrayList<CompteSimple>();
    }

    public void ouvrirCompteSimple(Personne titulaire, double solde) {
        CompteSimple cs = new CompteSimple(titulaire, solde);
        comptes.add(cs);
    }

    public void ouvrirCompteCourant(Personne titulaire, double solde) {
        CompteCourant cc = new CompteCourant(titulaire, solde);
        comptes.add(cc);
    }

    public double cumulSoldes() {
        double cumul = 0;
        for (CompteSimple compte : comptes) {
            cumul += compte.getSolde();
        }
        return cumul;
    }

    public double nbComptesDebiteurs() {
        double nb = 0;
        for (CompteSimple compte : comptes) {
            if (compte.getSolde() < 0) {
                nb++;
            }
        }
        return nb;
    }

    public double cumulSoldesDebiteurs() {
        double cumul = 0;
        for (CompteSimple compte : comptes) {
            if (compte.getSolde() < 0) {
                cumul += compte.getSolde();
            }
        }
        return cumul;
    }

    public void fraisDeGestion() {
        for (CompteSimple compte : comptes) {
            compte.debiter(2);
        }
    }

    public void editerReleves() {
        for (CompteSimple compte : comptes) {
            if (compte instanceof CompteCourant) {
                ((CompteCourant) compte).editerReleve();
            }
        }
    }
}
