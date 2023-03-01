package allumettes;

public abstract class Joueur {
    private String nom;
    
    public Joueur (String nom) {
        this.nom = nom;
    }
    
    public String getNom() {
        return this.nom;
    }
    
    public abstract int getPrise(Jeu jeu);
}
