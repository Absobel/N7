/**
 */
package tableur.tests;

import junit.textui.TestRunner;

import tableur.OperateurBinaire;
import tableur.TableurFactory;

/**
 * <!-- begin-user-doc -->
 * A test case for the model object '<em><b>Operateur Binaire</b></em>'.
 * <!-- end-user-doc -->
 * @generated
 */
public class OperateurBinaireTest extends OperationTest {

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static void main(String[] args) {
		TestRunner.run(OperateurBinaireTest.class);
	}

	/**
	 * Constructs a new Operateur Binaire test case with the given name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public OperateurBinaireTest(String name) {
		super(name);
	}

	/**
	 * Returns the fixture for this Operateur Binaire test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected OperateurBinaire getFixture() {
		return (OperateurBinaire)fixture;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see junit.framework.TestCase#setUp()
	 * @generated
	 */
	@Override
	protected void setUp() throws Exception {
		setFixture(TableurFactory.eINSTANCE.createOperateurBinaire());
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

} //OperateurBinaireTest
