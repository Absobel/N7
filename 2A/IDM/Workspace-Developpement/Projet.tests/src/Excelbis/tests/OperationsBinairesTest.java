/**
 */
package Excelbis.tests;

import Excelbis.ExcelbisFactory;
import Excelbis.OperationsBinaires;

import junit.textui.TestRunner;

/**
 * <!-- begin-user-doc -->
 * A test case for the model object '<em><b>Operations Binaires</b></em>'.
 * <!-- end-user-doc -->
 * @generated
 */
public class OperationsBinairesTest extends OperationsTest {

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static void main(String[] args) {
		TestRunner.run(OperationsBinairesTest.class);
	}

	/**
	 * Constructs a new Operations Binaires test case with the given name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public OperationsBinairesTest(String name) {
		super(name);
	}

	/**
	 * Returns the fixture for this Operations Binaires test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected OperationsBinaires getFixture() {
		return (OperationsBinaires)fixture;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see junit.framework.TestCase#setUp()
	 * @generated
	 */
	@Override
	protected void setUp() throws Exception {
		setFixture(ExcelbisFactory.eINSTANCE.createOperationsBinaires());
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

} //OperationsBinairesTest
