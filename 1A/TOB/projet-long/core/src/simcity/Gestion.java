package simcity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import simcity.Ressource.RessourceType;

public class Gestion {

    private Double monnaie;
    private Map<RessourceType, Double> finances;
    private List<BatRessources> batimentsConstruits;
    private Textures texture;
    protected CityManager citymanager;

    public Gestion(double monnaie ,double eau, double electricite, double bonheur, double habitants, double argent) {
        this.monnaie = monnaie;
        this.finances = new HashMap<>();
        finances.put(RessourceType.EAU, eau);
        finances.put(RessourceType.ELECTRICITE, electricite);
        finances.put(RessourceType.BONHEUR, bonheur);
        finances.put(RessourceType.HABITANTS, habitants);
        finances.put(RessourceType.ARGENT, argent);
        this.batimentsConstruits = new ArrayList<BatRessources>();
        //this.batimentsConstruits.add(new BatRessources(new TextureRegion(Textures.publics.get(0)), (double) 0, (double) 0,(double) 0,(double) 0,(double) 0,(double) 0));
        this.citymanager = new CityManager();
    }
    

    public void ajouterRessource(RessourceType type, double quantite) {
        double nouvelleQuantite = finances.get(type) + quantite;
        finances.put(type, nouvelleQuantite);
    }

    public double getQuantite(RessourceType type) {
        return finances.get(type);
    }

    public void miseAJour() {
        finances.put(RessourceType.EAU, 10.0);
        finances.put(RessourceType.ELECTRICITE, 10.0);
        finances.put(RessourceType.BONHEUR, 50.0);
        finances.put(RessourceType.HABITANTS, 0.0);
        finances.put(RessourceType.ARGENT, 0.0);
        
        for (BatRessources batiments : this.batimentsConstruits) {
            for (RessourceType ressource : batiments.getRessources().keySet()) {
                Double count = finances.get(ressource);
                finances.put(ressource, count + batiments.getRessources().get(ressource));
                System.out.println("ressource : " + ressource + " count : " + count + " batiments.getRessources().get(ressource) : " + batiments.getRessources().get(ressource));
            }
        }
    }

    public void ajouterBatiment(BatRessources batiment) {
        batimentsConstruits.add(batiment);
        miseAJour();
        this.citymanager.updateScore(true);
        boolean isLevelUp =this.citymanager.updateLevel();
        if(isLevelUp) {
        	this.monnaie = this.monnaie + 1500;
        }
    }

    public void retirerBatiment(BatRessources batiment) {
        batimentsConstruits.remove(batiment);
        miseAJour();
        this.citymanager.updateScore(false);
        boolean isLevelUp = this.citymanager.updateLevel();
        
    }

    public void impots() {
        this.monnaie = this.monnaie + finances.get(RessourceType.ARGENT);
    }

    /*payer un batiment
     * 
     */
    public void payer(double prix) {
        this.monnaie = this.monnaie - prix; // on retire le prix du batiment de la monnaie
    }

    public double getMonnaie() {
        return monnaie;
    }   

    public void setMonnaie(double monnaie) {
        this.monnaie = monnaie;
    }

    public Map<RessourceType, Double> getFinances() {
        return finances;
    }

    public void setFinances(Map<RessourceType, Double> finances) {
        this.finances = finances;
    }

    public List<BatRessources> getBatimentsConstruits() {
        return batimentsConstruits;
    }

    public void setBatimentsConstruits(List<BatRessources> batimentsConstruits) {
        this.batimentsConstruits = batimentsConstruits;
    }

    public Boolean centraleAchetable() {
        return ((monnaie >= 200) && (finances.get(RessourceType.BONHEUR) >= 5) ) ;
    }

    public BatRessources centrale() {
        BatRessources batiment = new BatRessources(Textures.publics.get(3), (double) 200, (double)0, (double) 50, -5, -20, -5);
        this.payer(batiment.getPrix());
        this.ajouterBatiment(batiment);
        return batiment;
    }

    public Boolean pompeEauAchetable() {
        return ((monnaie >= 200) && (finances.get(RessourceType.BONHEUR) >= 5) && (finances.get(RessourceType.HABITANTS) >= 5)) ;
    }

    public BatRessources pompeEau() {
        BatRessources batiment = new BatRessources(Textures.publics.get(4), 200, 50, 0, -5, -20, -5);
        this.payer(batiment.getPrix());
        this.ajouterBatiment(batiment);
        return batiment;
    }

    public Boolean ecoleAchetable() {
        return (monnaie >= 300 ) ;
    }

    public BatRessources ecole() {
        BatRessources batiment = new BatRessources(Textures.publics.get(7), 300, -5, -5, 10, -10, 10);
        this.payer(batiment.getPrix());
        this.ajouterBatiment(batiment);
        return batiment;
    }

    public Boolean maisonAchetable() {
        return (monnaie >= 300 && (finances.get(RessourceType.ELECTRICITE) >= 5) && (finances.get(RessourceType.EAU) >= 5));
    }

    public BatRessources maison() {
        BatRessources batiment = new BatRessources(Textures.habitats.get(0), 300, -5, -5, 5, 60, 5);
        this.payer(batiment.getPrix());
        this.ajouterBatiment(batiment);
        return batiment;
    }

    public Boolean immeubleAchetable() {
        return ((monnaie >= 500) && (finances.get(RessourceType.ELECTRICITE) > 10) && (finances.get(RessourceType.EAU) > 10)) ;
    }

    public BatRessources immeuble() {
        BatRessources batiment = new BatRessources(Textures.habitats.get(1), 1000, -10, -10, -5, 200, 25);
        this.payer(batiment.getPrix());
        this.ajouterBatiment(batiment);
        return batiment;
    }

    public Boolean dkoAchetable() {
        return ((monnaie >= 10)) ;
    }

    public BatRessources dko() {
        BatRessources batiment = new BatRessources(Textures.deco.get(0), 20, 0, 0, 5, 5, 0);
        this.payer(batiment.getPrix());
        this.ajouterBatiment(batiment);
        return batiment;
    }

    public Gestion getgest() {
        return this;
    }

    public String getRessourceValue(RessourceType ressource) {
        return String.valueOf(finances.get(ressource));
    }


}

