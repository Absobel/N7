public class LigneTab implements Ligne {
    private int taille;
    private char[] tab;
    private int curseur;

    public LigneTab(int capacite) {
        tab = new char[capacite];
        curseur = 0;
        taille = 0;
    }

    public int getLongueur() {
        return taille;
    }

    public int getCurseur() {
        return curseur;
    }

    public char ieme(int i) {
        return tab[i];
    }

    public char getCourant() { 
        return tab[curseur];
    }

    public void avancer() {
        curseur++;
    }

    public void reculer() {
        curseur--;
    }

    public void raz() {
        curseur = 1;
    }

    public void remplacer(char c) {
        tab[curseur] = c;
    }

    public void supprimer() {
        for (int i = curseur; i < tab.length - 1; i++) {
            tab[i] = tab[i + 1];
        }
        taille--;
    }

    public void ajouterAvant(char c) {
        for (int i = tab.length - 1; i > curseur; i--) {
            tab[i] = tab[i - 1];
        }
        tab[curseur] = c;
        taille++;
    }

    public void ajouterApres(char c) {
        for (int i = tab.length - 1; i > curseur + 1; i--) {
            tab[i] = tab[i - 1];
        }
        tab[curseur + 1] = c;
        taille++;
    }

    public void afficher() {
        for (int i = 0; i < tab.length; i++) {
            System.out.print((char) tab[i]);
        }
        System.out.println();
    }

    public void ajouterFin(char c) {
        tab[tab.length - 1] = c;
        taille++;
    }

    public void ajouterDebut(char c) {
        for (int i = tab.length - 1; i > 0; i--) {
            tab[i] = tab[i - 1];
        }
        tab[0] = c;
        taille++;
    }

    public void supprimerPremier() {
        for (int i = 0; i < tab.length - 1; i++) {
            tab[i] = tab[i + 1];
        }
        taille--;
    }

    public void supprimerDernier() {
        tab[tab.length - 1] = 0;
        taille--;
    }        
}
