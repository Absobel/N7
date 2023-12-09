import annotations.UnTest;

/** ErreurTest est un programme de test qui définit trois méthodes de test
  * dont une provoque une erreur.
  */
public class ErreurTest {
	
	@UnTest(enabled = false)
	public void tester1() {
	}

	@UnTest(expected = Echec.class)
	public void tester2() {
		Assert.assertTrue(false);
	}

	@UnTest
	public void tester3() {
		Assert.assertTrue(true);
	}

}
