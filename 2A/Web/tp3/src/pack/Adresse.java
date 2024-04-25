package pack;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Adresse {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "rue", nullable = false)
    private String rue;
    
    @Column(name = "ville", nullable = false)
    private String ville;

    @ManyToOne
    @JoinColumn(name = "personneid", referencedColumnName = "id")
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
