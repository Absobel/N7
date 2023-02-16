package src;
import org.junit.*;
import static org.junit.Assert.*;

public class TestCompteSimple {
    private Personne p1;
    private CompteSimple c1, c2;

    @Before public void setUp() {
        p1 = new Personne("Jean", "Dupont", true);
        c1 = new CompteSimple(p1, 1000);
        c2 = new CompteSimple(p1);
    }

    @Test public void testerConstructeur1() {
        assertEquals("Solde incorrect", 1000, c1.getSolde(), 0.001);
        assertEquals("Titulaire incorrect", p1, c1.getTitulaire());
    }

    @Test public void testerConstructeur2() {
        assertEquals("Solde incorrect", 0, c2.getSolde(), 0.001);
        assertEquals("Titulaire incorrect", p1, c2.getTitulaire());
    }

    @Test public void testerCrediter() {
        c1.crediter(100);
        assertEquals("Solde incorrect", 1100, c1.getSolde(), 0.001);
    }

    @Test public void testerDebiterPositif() {
        c1.debiter(100);
        assertEquals("Solde incorrect", 900, c1.getSolde(), 0.001);
    }

    @Test public void testerDebiterNegatif() {
        c1.debiter(1200);
        assertEquals("Solde incorrect", -200, c1.getSolde(), 0.001);
    }

    @Test(expected=AssertionError.class)
    public void testerConstructeur1a() {
        c1 = new CompteSimple(null, 1000);
    }

    @Test(expected=AssertionError.class)
    public void testerConstructeur1b() {
        c1 = new CompteSimple(p1, -1000);
    }

    @Test(expected=AssertionError.class)
    public void testerConstructeur2a() {
        c1 = new CompteSimple(null);
    }

    @Test(expected=AssertionError.class)
    public void testerDebitera() {
        c1.debiter(-100);
    }
}