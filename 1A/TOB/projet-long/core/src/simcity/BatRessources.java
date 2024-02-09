package simcity;

import com.badlogic.gdx.graphics.g2d.TextureRegion;

import simcity.Ressource.RessourceType;

import java.util.Map;
import java.util.HashMap;

public class BatRessources { // moyen que ce soit la classe batiment directement 

    private Map<RessourceType, Double> ressources;
    public TextureRegion texture;
    private double prix;

    public BatRessources(TextureRegion texture, double prix, double eau, double elec, double Bonheur, double argent, double habitants) {
        this.texture = texture;
        this.prix = prix;
        this.ressources = new HashMap<>();
        this.ressources.put(RessourceType.EAU, eau);
        this.ressources.put(RessourceType.ELECTRICITE, elec);
        this.ressources.put(RessourceType.BONHEUR, Bonheur);
        this.ressources.put(RessourceType.ARGENT, argent);
        this.ressources.put(RessourceType.HABITANTS, habitants);
    }

    public Map<RessourceType, Double> getRessources() {
        return ressources;
    }

    public TextureRegion getTexture() {
        return this.texture;
    }

    public void setTexture(TextureRegion texture) {
        this.texture = texture;
    }

    public double getPrix() {
        return this.prix;
    }

    public void setPrix(double prix) {
        this.prix = prix ;
    }
}
