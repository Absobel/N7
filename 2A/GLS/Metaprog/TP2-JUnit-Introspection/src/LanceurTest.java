import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;

public class LanceurTest {
    PrintStream originalOut;
    OutputStream nullOutputStream = new ByteArrayOutputStream();
    PrintStream silentOut = new PrintStream(nullOutputStream);
    
    public void preparer() {
        originalOut = System.out;
    }
    
    public void testerCasLimiteTest() {
        System.setOut(silentOut);
        LanceurIndependant lanceur = new LanceurIndependant("CasLimitesTest");
        System.setOut(originalOut);
        Assert.assertTrue(lanceur.getNbTests() == 3 && lanceur.getNbEchecs() == 0 && lanceur.getNbErreurs() == 2);
    }

    public void testerMonnaieTest() {
        System.setOut(silentOut);
        LanceurIndependant lanceur = new LanceurIndependant("MonnaieTest");
        System.setOut(originalOut);
        Assert.assertTrue(lanceur.getNbTests() == 2 && lanceur.getNbEchecs() == 1 && lanceur.getNbErreurs() == 0);
    }

    public void testerMonnaieTest2() {
        System.setOut(silentOut);
        LanceurIndependant lanceur = new LanceurIndependant("MonnaieTest2");
        System.setOut(originalOut);
        Assert.assertTrue(lanceur.getNbTests() == 3 && lanceur.getNbEchecs() == 1 && lanceur.getNbErreurs() == 0);
    }

    public void testerErreurTest() {
        System.setOut(silentOut);
        LanceurIndependant lanceur = new LanceurIndependant("ErreurTest");
        System.setOut(originalOut);
        Assert.assertTrue(lanceur.getNbTests() == 3 && lanceur.getNbEchecs() == 1 && lanceur.getNbErreurs() == 0);   
    }
}
