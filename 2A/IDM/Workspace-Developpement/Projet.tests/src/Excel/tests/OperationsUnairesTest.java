/**
 */
package Excel.tests;

import Excel.ExcelFactory;
import Excel.OperationsUnaires;

import junit.textui.TestRunner;

/**
 * <!-- begin-user-doc -->
 * A test case for the model object '<em><b>Operations Unaires</b></em>'.
 * <!-- end-user-doc -->
 * @generated
 */
public class OperationsUnairesTest extends OperationsTest {

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static void main(String[] args) {
		TestRunner.run(OperationsUnairesTest.class);
	}

	/**
	 * Constructs a new Operations Unaires test case with the given name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public OperationsUnairesTest(String name) {
		super(name);
	}

	/**
	 * Returns the fixture for this Operations Unaires test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected OperationsUnaires getFixture() {
		return (OperationsUnaires)fixture;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see junit.framework.TestCase#setUp()
	 * @generated
	 */
	@Override
	protected void setUp() throws Exception {
		setFixture(ExcelFactory.eINSTANCE.createOperationsUnaires());
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

} //OperationsUnairesTest
