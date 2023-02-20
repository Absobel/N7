package src;

import java.util.ArrayList;
import java.util.List;

public class Historique {
    private List<Double> historique;

    public Historique() {
        historique = new ArrayList<Double>();
    }

    public void enregistrer(double info) {
        historique.add(info);
    }

    public double getValeur(int i) {
        return historique.get(i);
    }

    public int getNbValeurs() {
        return historique.size();
    }
}