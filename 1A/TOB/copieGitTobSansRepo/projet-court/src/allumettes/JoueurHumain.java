package allumettes;

import java.util.Scanner;

public class JoueurHumain extends Joueur {
    public JoueurHumain(String nom) {
        super(nom);
    }

    @Override
    public int getPrise(Jeu jeu) {
        System.out.print(super.getNom()+", combien d'allumettes ? ");
        Scanner sc = new Scanner(System.in);
        int prise = sc.nextInt();
        sc.close();
        return prise;
    }
}
