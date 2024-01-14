/**
 */
package catalogue.tests;

import catalogue.Algorithme;
import catalogue.CatalogueFactory;

import junit.textui.TestRunner;

/**
 * <!-- begin-user-doc -->
 * A test case for the model object '<em><b>Algorithme</b></em>'.
 * <!-- end-user-doc -->
 * @generated
 */
public class AlgorithmeTest extends AlgorithmeElementTest {

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static void main(String[] args) {
		TestRunner.run(AlgorithmeTest.class);
	}

	/**
	 * Constructs a new Algorithme test case with the given name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AlgorithmeTest(String name) {
		super(name);
	}

	/**
	 * Returns the fixture for this Algorithme test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected Algorithme getFixture() {
		return (Algorithme)fixture;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see junit.framework.TestCase#setUp()
	 * @generated
	 */
	@Override
	protected void setUp() throws Exception {
		setFixture(CatalogueFactory.eINSTANCE.createAlgorithme());
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

} //AlgorithmeTest
