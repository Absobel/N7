/**
 */
package script.tests;

import junit.textui.TestRunner;

import script.ScriptFactory;
import script.Unaire;

/**
 * <!-- begin-user-doc -->
 * A test case for the model object '<em><b>Unaire</b></em>'.
 * <!-- end-user-doc -->
 * @generated
 */
public class UnaireTest extends OperationsTest {

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static void main(String[] args) {
		TestRunner.run(UnaireTest.class);
	}

	/**
	 * Constructs a new Unaire test case with the given name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public UnaireTest(String name) {
		super(name);
	}

	/**
	 * Returns the fixture for this Unaire test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected Unaire getFixture() {
		return (Unaire)fixture;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see junit.framework.TestCase#setUp()
	 * @generated
	 */
	@Override
	protected void setUp() throws Exception {
		setFixture(ScriptFactory.eINSTANCE.createUnaire());
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

} //UnaireTest
