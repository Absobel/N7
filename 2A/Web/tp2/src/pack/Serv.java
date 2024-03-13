package pack;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Set;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class Serv extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String op = req.getParameter("op");
        switch (op) {
            case "associer":
                req.getRequestDispatcher("associer.jsp").forward(req, resp);
                break;
            case "lister":
                resp.setContentType("text/html;charset=UTF-8");
                HashMap<Personne, Set<Adresse>> assoc = Facade.lister();
                try(PrintWriter out = resp.getWriter()) {
                    if (assoc.isEmpty()) {
                        out.println("Aucune association");
                    } else {
                        for (Personne personne : assoc.keySet()) {
                            out.println(personne.getNom() + " " + personne.getPrenom());
                            for (Adresse adresse : assoc.get(personne)) {
                                out.println("  " + adresse.getRue() + " " + adresse.getVille());
                            }
                        }
                    }
                }
                break;
            case null:
                try(PrintWriter out = resp.getWriter()) {
                    out.println("Opération non spécifiée");
                }
                break;
            default:
                try(PrintWriter out = resp.getWriter()) {
                    out.println("Opération inconnue");
                }
                break;
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String op = req.getParameter("op");
        switch (op) {
            case "ajoutpersonne":
                String nom = req.getParameter("nom");
                String prenom = req.getParameter("prenom");
                if (nom != null && prenom != null) {
                    Facade.ajoutPersonne(nom, prenom);
                    req.getRequestDispatcher(".").forward(req, resp);
                } else {
                    try(PrintWriter out = resp.getWriter()) {
                        out.println("Nom ou prénom non spécifié");
                    }
                }
                break;
            case "ajoutadresse":
                String rue = req.getParameter("rue");
                String ville = req.getParameter("ville");
                if (rue != null && ville != null) {
                    Facade.ajoutAdresse(rue, ville);
                    req.getRequestDispatcher(".").forward(req, resp);
                } else {
                    try(PrintWriter out = resp.getWriter()) {
                        out.println("Rue ou ville non spécifiée");
                    }
                }
                break;
            case "associer":
                // if it errors it's a bug
                int personneId = Integer.parseInt(req.getParameter("personneId"));
                int adresseId = Integer.parseInt(req.getParameter("adresseId"));
                Facade.associer(personneId, adresseId);
                req.getRequestDispatcher(".").forward(req, resp);
                break;
            default:
                try(PrintWriter out = resp.getWriter()) {
                    out.println("Opération inconnue");
                }
                break;
        }
    }
}