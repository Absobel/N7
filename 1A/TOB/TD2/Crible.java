public class Crible {
    private Ensemble<Integer> e;

    public Crible(Ensemble<Integer> e) {
        this.e = e;
    }

    public void crible(int n) {
        for (int i = 2; i <= n; i++) {
            e.ajouter(i);
        }
        for (int i = 2; i <= n; i++) {
            if (e.contient(i)) {
                for (int j = 2 * i; j <= n; j += i) {
                    e.supprimer(j);
                }
            }
        }
    }

    public void afficherNbPremiers(int n) {
        crible(n);
        System.out.println("Il y a " + e.cardinal() + " nombres premiers inférieurs ou égaux à " + n);
    }
}
