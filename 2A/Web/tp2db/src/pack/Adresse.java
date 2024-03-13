package pack;

public class Adresse {
    private String rue;
    private String ville;

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
}
