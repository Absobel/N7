package pack;

public class Adresse {
    private String rue;
    private String ville;
    private Personne personne; // can be null

    public Adresse(String rue, String ville) {
        this.rue = rue;
        this.ville = ville;
    }

    public String getRue() {
        return rue;
    }

    public String getVille() {
        return ville;
    }    

    public Personne getPersonne() {
        return personne;
    }

    public void setPersonne(Personne personne) {
        this.personne = personne;
    }

    // DEBUG
    public String toString() {
        return rue + " " + ville;
    }
}
