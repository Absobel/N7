public interface Ligne {
    int getLongueur();
    int getCurseur();
    char ieme(int i);
    char getCourant();
    void avancer();
    void reculer();
    void raz();
    void remplacer(char c);
    void supprimer();
    void ajouterAvant(char c);
    void ajouterApres(char c);
    void afficher();
    void ajouterFin(char c);
    void ajouterDebut(char c);
    void supprimerPremier();
    void supprimerDernier();
}