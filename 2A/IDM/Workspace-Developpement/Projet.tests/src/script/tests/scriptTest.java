/**
 */
package script.tests;

import junit.framework.TestCase;

import junit.textui.TestRunner;

import script.ScriptFactory;
import script.script;

/**
 * <!-- begin-user-doc -->
 * A test case for the model object '<em><b>script</b></em>'.
 * <!-- end-user-doc -->
 * @generated
 */
public class scriptTest extends TestCase {

	/**
	 * The fixture for this script test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected script fixture = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static void main(String[] args) {
		TestRunner.run(scriptTest.class);
	}

	/**
	 * Constructs a new script test case with the given name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public scriptTest(String name) {
		super(name);
	}

	/**
	 * Sets the fixture for this script test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void setFixture(script fixture) {
		this.fixture = fixture;
	}

	/**
	 * Returns the fixture for this script test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected script getFixture() {
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
		setFixture(ScriptFactory.eINSTANCE.createscript());
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

} //scriptTest
