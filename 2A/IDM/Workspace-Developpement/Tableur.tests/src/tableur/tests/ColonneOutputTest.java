/**
 */
package tableur.tests;

import junit.textui.TestRunner;

import tableur.ColonneOutput;
import tableur.TableurFactory;

/**
 * <!-- begin-user-doc -->
 * A test case for the model object '<em><b>Colonne Output</b></em>'.
 * <!-- end-user-doc -->
 * @generated
 */
public class ColonneOutputTest extends ColonneTest {

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static void main(String[] args) {
		TestRunner.run(ColonneOutputTest.class);
	}

	/**
	 * Constructs a new Colonne Output test case with the given name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ColonneOutputTest(String name) {
		super(name);
	}

	/**
	 * Returns the fixture for this Colonne Output test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected ColonneOutput getFixture() {
		return (ColonneOutput)fixture;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see junit.framework.TestCase#setUp()
	 * @generated
	 */
	@Override
	protected void setUp() throws Exception {
		setFixture(TableurFactory.eINSTANCE.createColonneOutput());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see junit.framework.TestCase#tearDown()
	 * @generated
	 */
	@Override
	protected void tearDown() throws Exception {
		setFixture(null);
	}

} //ColonneOutputTest
