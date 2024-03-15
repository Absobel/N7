package pack;

import java.util.Objects;

public class Personne {
    private String nom;
    private String prenom;

    public Personne(String nom, String prenom) {
        this.nom = nom;
        this.prenom = prenom;
    }

    public String getNom() {
        return nom;
    }

    public String getPrenom() {
        return prenom;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Personne personne = (Personne) o;
        return this.prenom == personne.prenom && this.nom == personne.nom;
    }

    @Override
    public int hashCode() {
        return Objects.hash(nom, prenom);
    }
}
