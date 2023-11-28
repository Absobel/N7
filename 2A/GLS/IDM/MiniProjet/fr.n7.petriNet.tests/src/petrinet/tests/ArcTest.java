/**
 */
package petrinet.tests;

import junit.textui.TestRunner;

import petrinet.Arc;
import petrinet.PetrinetFactory;

/**
 * <!-- begin-user-doc -->
 * A test case for the model object '<em><b>Arc</b></em>'.
 * <!-- end-user-doc -->
 * @generated
 */
public class ArcTest extends PetriNetElementTest {

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static void main(String[] args) {
		TestRunner.run(ArcTest.class);
	}

	/**
	 * Constructs a new Arc test case with the given name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ArcTest(String name) {
		super(name);
	}

	/**
	 * Returns the fixture for this Arc test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected Arc getFixture() {
		return (Arc)fixture;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see junit.framework.TestCase#setUp()
	 * @generated
	 */
	@Override
	protected void setUp() throws Exception {
		setFixture(PetrinetFactory.eINSTANCE.createArc());
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

} //ArcTest
