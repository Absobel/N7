/**
 */
package tableur.tests;

import junit.textui.TestRunner;

import tableur.OperateurUnaire;
import tableur.TableurFactory;

/**
 * <!-- begin-user-doc -->
 * A test case for the model object '<em><b>Operateur Unaire</b></em>'.
 * <!-- end-user-doc -->
 * @generated
 */
public class OperateurUnaireTest extends OperationTest {

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static void main(String[] args) {
		TestRunner.run(OperateurUnaireTest.class);
	}

	/**
	 * Constructs a new Operateur Unaire test case with the given name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public OperateurUnaireTest(String name) {
		super(name);
	}

	/**
	 * Returns the fixture for this Operateur Unaire test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected OperateurUnaire getFixture() {
		return (OperateurUnaire)fixture;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see junit.framework.TestCase#setUp()
	 * @generated
	 */
	@Override
	protected void setUp() throws Exception {
		setFixture(TableurFactory.eINSTANCE.createOperateurUnaire());
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

} //OperateurUnaireTest
