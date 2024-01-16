/**
 */
package tableur.tests;

import junit.textui.TestRunner;

import tableur.OperationBinaire;
import tableur.TableurFactory;

/**
 * <!-- begin-user-doc -->
 * A test case for the model object '<em><b>Operation Binaire</b></em>'.
 * <!-- end-user-doc -->
 * @generated
 */
public class OperationBinaireTest extends OperationTest {

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static void main(String[] args) {
		TestRunner.run(OperationBinaireTest.class);
	}

	/**
	 * Constructs a new Operation Binaire test case with the given name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public OperationBinaireTest(String name) {
		super(name);
	}

	/**
	 * Returns the fixture for this Operation Binaire test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected OperationBinaire getFixture() {
		return (OperationBinaire)fixture;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see junit.framework.TestCase#setUp()
	 * @generated
	 */
	@Override
	protected void setUp() throws Exception {
		setFixture(TableurFactory.eINSTANCE.createOperationBinaire());
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

} //OperationBinaireTest
