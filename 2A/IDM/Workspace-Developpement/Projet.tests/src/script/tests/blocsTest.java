/**
 */
package script.tests;

import junit.framework.TestCase;

import junit.textui.TestRunner;

import script.ScriptFactory;
import script.blocs;

/**
 * <!-- begin-user-doc -->
 * A test case for the model object '<em><b>blocs</b></em>'.
 * <!-- end-user-doc -->
 * @generated
 */
public class blocsTest extends TestCase {

	/**
	 * The fixture for this blocs test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected blocs fixture = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static void main(String[] args) {
		TestRunner.run(blocsTest.class);
	}

	/**
	 * Constructs a new blocs test case with the given name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public blocsTest(String name) {
		super(name);
	}

	/**
	 * Sets the fixture for this blocs test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void setFixture(blocs fixture) {
		this.fixture = fixture;
	}

	/**
	 * Returns the fixture for this blocs test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected blocs getFixture() {
		return fixture;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see junit.framework.TestCase#setUp()
	 * @generated
	 */
	@Override
	protected void setUp() throws Exception {
		setFixture(ScriptFactory.eINSTANCE.createblocs());
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

} //blocsTest
