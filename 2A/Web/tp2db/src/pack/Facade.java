package pack;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Facade {
    private Connection con;

    public Facade() {
        String db_url = "jdbc:hsqldb:hsql://localhost/xdb";
        String db_user = "sa";
        try {
            Class.forName("org.hsqldb.jdbcDriver");
            this.con = DriverManager.getConnection(db_url, db_user, null);
        } catch (Throwable e) {
            e.printStackTrace();
        }
    }

    public void ajoutPersonne(String nom, String prenom) {
        String query = "INSERT INTO Personne (nom, prenom) VALUES ('" + nom + "', '" + prenom + "')";
        try(Statement stmt = con.createStatement()) {
            stmt.executeUpdate(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void ajoutAdresse(String rue, String ville) {
        String query = "INSERT INTO Adresse (rue, ville) VALUES ('" + rue + "', '" + ville + "')";
        try(Statement stmt = con.createStatement()) {
            stmt.executeUpdate(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public HashMap<Personne, Set<Adresse>> lister() {
        String query = "SELECT a.rue, a.ville, p.nom, p.prenom FROM Adresse a LEFT JOIN Personne p ON a.personneid = p.id";
        HashMap<Personne, Set<Adresse>> assoc = new HashMap<>();
        
        try(Statement stmt = con.createStatement()) {
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                String nom = rs.getString("nom");
                String prenom = rs.getString("prenom");
                if (nom != null && prenom != null) {
                    Personne personne = new Personne(nom, prenom);
                    Adresse adresse = new Adresse(rs.getString("rue"), rs.getString("ville"));
                    if (!assoc.containsKey(personne)) {
                        Set<Adresse> adresses = new HashSet<>();
                        adresses.add(adresse);
                        assoc.put(personne, adresses);
                    } else {
                        assoc.get(personne).add(adresse);
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return assoc;
    }

    public Collection<Personne> listePersonnes() {
        String query = "SELECT * FROM Personne";
        ArrayList<Personne> personnes = new ArrayList<>();

        try(Statement stmt = con.createStatement()) {
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                personnes.add(new Personne(rs.getString("nom"), rs.getString("prenom")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return personnes;
    }

    public Collection<Adresse> listeAdresses() {
        String query = "SELECT * FROM Adresse";
        ArrayList<Adresse> adresses = new ArrayList<>();

        try(Statement stmt = con.createStatement()) {
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                adresses.add(new Adresse(rs.getString("rue"), rs.getString("ville")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return adresses;
    }

    public void associer(int personneId, int adresseId) {
        // +1 because ids in the database start at 1
        String query = "UPDATE Adresse SET personneid = " + (personneId+1) + " WHERE id = " + (adresseId+1);
        try(Statement stmt = con.createStatement()) {
            stmt.executeUpdate(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    } 
}
