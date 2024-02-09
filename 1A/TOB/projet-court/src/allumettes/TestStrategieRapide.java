package allumettes;

import org.junit.*;

public class TestStrategieRapide {
    /** Test de la méthode getPrise. */
    private StrategieRapide strat;
    /** Jeu de 13 allumettes. */
    private Jeu jeu;

    /** Initialisation des tests.*/
    @Before
    public void setUp() {
        strat = new StrategieRapide();
        jeu = new JeuReel(13);
    }

    /** Test de la méthode getPrise. */
    @Test
    public void testGetPrise() {
        Assert.assertEquals(3, strat.getPrise(jeu));
    }

    /** Test de la methode getPrise quand il reste moins de 3 allumettes. */
    @Test
    public void testGetPrise2() {
        jeu = new JeuReel(2);
        Assert.assertEquals(2, strat.getPrise(jeu));
    }

    /** Test de la méthode getPrise avec un jeu null. La méthode doit lever une
     * exception. */
    @Test(expected = AssertionError.class)
    public void testGetPriseNull() {
        strat.getPrise(null);
    }
}
