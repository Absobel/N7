public class Main {
    public static void main(String[] args) {
        System.out.println("Crible d'Ératosthène avec un ensemble implémenté avec un tableau");
        Ensemble e1 = new EnsembleTableau<Integer>(100);
        Crible c = new Crible(e1);
        c.afficherNbPremiers(100);

        System.out.println("\nCrible d'Ératosthène avec un ensemble implémenté avec une liste chaînée");
        Ensemble e2 = new EnsembleChainee<Integer>();
        c = new Crible(e2);
        c.afficherNbPremiers(100);
    }
}
