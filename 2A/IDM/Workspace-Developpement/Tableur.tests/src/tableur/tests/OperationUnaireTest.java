/**
 */
package tableur.tests;

import junit.textui.TestRunner;

import tableur.OperationUnaire;
import tableur.TableurFactory;

/**
 * <!-- begin-user-doc -->
 * A test case for the model object '<em><b>Operation Unaire</b></em>'.
 * <!-- end-user-doc -->
 * @generated
 */
public class OperationUnaireTest extends OperationTest {

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static void main(String[] args) {
		TestRunner.run(OperationUnaireTest.class);
	}

	/**
	 * Constructs a new Operation Unaire test case with the given name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public OperationUnaireTest(String name) {
		super(name);
	}

	/**
	 * Returns the fixture for this Operation Unaire test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected OperationUnaire getFixture() {
		return (OperationUnaire)fixture;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see junit.framework.TestCase#setUp()
	 * @generated
	 */
	@Override
	protected void setUp() throws Exception {
		setFixture(TableurFactory.eINSTANCE.createOperationUnaire());
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

} //OperationUnaireTest
