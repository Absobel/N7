<%@ page language="java" import="pack.*, java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Empty JSP File</title>
</head>
<body>
    <form action="Serv" method="post">
        <input type="hidden" name="op" value="associer">
        Choisir la personne :<br>
        <%
            List<Personne> pers = new ArrayList<>(Facade.listePersonnes());
            if (pers.isEmpty()) {
        %>
        <label>Aucune personne inscrite</label><br>
        <%
            } else {
                for (int idx = 0; idx < pers.size(); idx++) {
                    Personne p = pers.get(idx);
        %>
        <input type="radio" id="personne<%=idx%>" name="personneId" value="<%=idx%>" required>
        <label for="personne<%=idx%>"><%=p.getNom() + " " + p.getPrenom()%></label><br>
        <%
                }
            }
        %>
        <br>

        Choisir l'adresse :<br>
        <%
            List<Adresse> adrs = new ArrayList<>(Facade.listeAdresses());
            if (adrs.isEmpty()) {
        %>
        <label>Aucune adresse renseignée</label><br>
        <%
            } else {
                for (int idx = 0; idx < adrs.size(); idx++) {
                    Adresse a = adrs.get(idx);
        %>
        <input type="radio" id="adresse<%=idx%>" name="adresseId" value="<%=idx%>" required>
        <label for="adresse<%=idx%>"><%=a.getRue() + " " + a.getVille()%></label><br>
        <%
                }
            }
        %>
        <br>
        <%
            if (!(pers.isEmpty() || adrs.isEmpty())) {
        %>
        <input type="submit" value="OK">
        <%
            }
        %>
    </form>
</body>
</html>
