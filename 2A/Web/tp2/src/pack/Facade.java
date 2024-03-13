package pack;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class Facade {
    private static Collection<Personne> personnes = new ArrayList<>();
    private static Collection<Adresse> adresses = new ArrayList<>();
    private static HashMap<Personne, Set<Adresse>> assoc = new HashMap<>();

    public static void ajoutPersonne(String nom, String prenom) {
        personnes.add(new Personne(nom, prenom));
    }

    public static void ajoutAdresse(String rue, String ville) {
        adresses.add(new Adresse(rue, ville));
    }

    public static HashMap<Personne, Set<Adresse>> lister() {
        return assoc;
    }

    public static Collection<Personne> listePersonnes() {
        return personnes;
    }

    public static Collection<Adresse> listeAdresses() {
        return adresses;
    }

    public static void associer(int personneId, int adresseId) {
        Personne personne = (Personne) personnes.toArray()[personneId];
        Adresse adresse = (Adresse) adresses.toArray()[adresseId];
        if (!assoc.containsKey(personne)) {
            Set<Adresse> adresses = new HashSet<>();
            adresses.add(adresse);
            assoc.put(personne, adresses);
        } else {
            assoc.get(personne).add(adresse);
        }
    } 
}
