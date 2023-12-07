import annotations.UnTest;

/** Tester quelques cas limites.
  * @author	Xavier Crégut
  * @version	$Revision$
  */
public class CasLimitesTest {

	@UnTest
	public void ok() {
		// OK.
	}

	@UnTest
	private void methodePrivee() {
		throw new RuntimeException("Une méthode privée n'est pas un test !");
	}

	@UnTest
	protected void methodeProtegee() {
		throw new RuntimeException("Une méthode protected n'est pas un test !");
	}

	@UnTest
	void methodePaquetage() {
		throw new RuntimeException("Une méthode de droit d'accès paquetage n'est pas un test !");
	}

	@UnTest
	public static void methodeDeClasse() {
		throw new RuntimeException("Une méthode de classe n'est pas un test !");
	}

	@UnTest
	public void avecParametre(int a) {
		throw new RuntimeException("Une méthode avec des paramètres n'est pas un test !");
	}

	@UnTest
	public void avecParametre2(int a) {
		throw new RuntimeException("Une méthode avec des paramètres n'est pas un test !");
	}

}
