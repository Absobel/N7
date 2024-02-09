package exercices;

import org.junit.*;
import static exercices.Range.range;

/** Classe de test de la classe {@ Range}.  */
public class TestRangeParametresOptionnels {

	@Test
	public void testBonusRangeSansPas() {
		TestRange.verifierRange(5, 15, 1, range(5, 15));
	}

	@Test
	public void testBonusRangeFinSeule() {
		TestRange.verifierRange(0, 7, 1, range(7));
	}

}
