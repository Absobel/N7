package pack;

import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class Facade {
    private EntityManagerFactory emf;
    private EntityManager em;

    public Facade() {
        emf = Persistence.createEntityManagerFactory("MaPU");
        em = emf.createEntityManager();
    }

    public void ajoutPersonne(String nom, String prenom) {
        Personne personne = new Personne(nom, prenom);
        em.getTransaction().begin();
        em.persist(personne);
        em.getTransaction().commit();
    }

    public void ajoutAdresse(String rue, String ville) {
        Adresse adresse = new Adresse(rue, ville);
        em.getTransaction().begin();
        em.persist(adresse);
        em.getTransaction().commit();
    }

    public HashMap<Personne, Set<Adresse>> lister() {
        List<Personne> personnes = em.createQuery("SELECT p FROM Personne p LEFT JOIN FETCH p.adresses", Personne.class).getResultList();
        HashMap<Personne, Set<Adresse>> assoc = new HashMap<>();
        for (Personne p : personnes) {
            assoc.put(p, new HashSet<>(p.getAdresses()));
        }
        return assoc;
    }

    public Collection<Personne> listePersonnes() {
        return em.createQuery("SELECT p FROM Personne p", Personne.class).getResultList();
    }

    public Collection<Adresse> listeAdresses() {
        return em.createQuery("SELECT a FROM Adresse a", Adresse.class).getResultList();
    }

    public void associer(int personneId, int adresseId) {
        em.getTransaction().begin();
        Personne personne = em.find(Personne.class, personneId);
        Adresse adresse = em.find(Adresse.class, adresseId);
        adresse.setPersonne(personne);
        em.getTransaction().commit();
    } 
}