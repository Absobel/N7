/**
 */
package Bonjour;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each operation of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see Bonjour.BonjourFactory
 * @model kind="package"
 * @generated
 */
public interface BonjourPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "Bonjour";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "https://Bonjour.ecore";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "Bonjour.ecore";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	BonjourPackage eINSTANCE = Bonjour.impl.BonjourPackageImpl.init();

	/**
	 * The meta object id for the '{@link Bonjour.impl.connardImpl <em>connard</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see Bonjour.impl.connardImpl
	 * @see Bonjour.impl.BonjourPackageImpl#getconnard()
	 * @generated
	 */
	int CONNARD = 0;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONNARD__NAME = 0;

	/**
	 * The number of structural features of the '<em>connard</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONNARD_FEATURE_COUNT = 1;

	/**
	 * The number of operations of the '<em>connard</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONNARD_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link Bonjour.impl.fdpImpl <em>fdp</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see Bonjour.impl.fdpImpl
	 * @see Bonjour.impl.BonjourPackageImpl#getfdp()
	 * @generated
	 */
	int FDP = 1;

	/**
	 * The feature id for the '<em><b>Vfjdo</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FDP__VFJDO = 0;

	/**
	 * The feature id for the '<em><b>Connard</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FDP__CONNARD = 1;

	/**
	 * The number of structural features of the '<em>fdp</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FDP_FEATURE_COUNT = 2;

	/**
	 * The number of operations of the '<em>fdp</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FDP_OPERATION_COUNT = 0;


	/**
	 * The meta object id for the '{@link Bonjour.impl.enculeImpl <em>encule</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see Bonjour.impl.enculeImpl
	 * @see Bonjour.impl.BonjourPackageImpl#getencule()
	 * @generated
	 */
	int ENCULE = 2;

	/**
	 * The feature id for the '<em><b>Fdp</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENCULE__FDP = 0;

	/**
	 * The number of structural features of the '<em>encule</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENCULE_FEATURE_COUNT = 1;

	/**
	 * The number of operations of the '<em>encule</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENCULE_OPERATION_COUNT = 0;


	/**
	 * Returns the meta object for class '{@link Bonjour.connard <em>connard</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>connard</em>'.
	 * @see Bonjour.connard
	 * @generated
	 */
	EClass getconnard();

	/**
	 * Returns the meta object for the attribute '{@link Bonjour.connard#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see Bonjour.connard#getName()
	 * @see #getconnard()
	 * @generated
	 */
	EAttribute getconnard_Name();

	/**
	 * Returns the meta object for class '{@link Bonjour.fdp <em>fdp</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>fdp</em>'.
	 * @see Bonjour.fdp
	 * @generated
	 */
	EClass getfdp();

	/**
	 * Returns the meta object for the attribute '{@link Bonjour.fdp#getVfjdo <em>Vfjdo</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Vfjdo</em>'.
	 * @see Bonjour.fdp#getVfjdo()
	 * @see #getfdp()
	 * @generated
	 */
	EAttribute getfdp_Vfjdo();

	/**
	 * Returns the meta object for the reference '{@link Bonjour.fdp#getConnard <em>Connard</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Connard</em>'.
	 * @see Bonjour.fdp#getConnard()
	 * @see #getfdp()
	 * @generated
	 */
	EReference getfdp_Connard();

	/**
	 * Returns the meta object for class '{@link Bonjour.encule <em>encule</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>encule</em>'.
	 * @see Bonjour.encule
	 * @generated
	 */
	EClass getencule();

	/**
	 * Returns the meta object for the containment reference list '{@link Bonjour.encule#getFdp <em>Fdp</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Fdp</em>'.
	 * @see Bonjour.encule#getFdp()
	 * @see #getencule()
	 * @generated
	 */
	EReference getencule_Fdp();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	BonjourFactory getBonjourFactory();

	/**
	 * <!-- begin-user-doc -->
	 * Defines literals for the meta objects that represent
	 * <ul>
	 *   <li>each class,</li>
	 *   <li>each feature of each class,</li>
	 *   <li>each operation of each class,</li>
	 *   <li>each enum,</li>
	 *   <li>and each data type</li>
	 * </ul>
	 * <!-- end-user-doc -->
	 * @generated
	 */
	interface Literals {
		/**
		 * The meta object literal for the '{@link Bonjour.impl.connardImpl <em>connard</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see Bonjour.impl.connardImpl
		 * @see Bonjour.impl.BonjourPackageImpl#getconnard()
		 * @generated
		 */
		EClass CONNARD = eINSTANCE.getconnard();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CONNARD__NAME = eINSTANCE.getconnard_Name();

		/**
		 * The meta object literal for the '{@link Bonjour.impl.fdpImpl <em>fdp</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see Bonjour.impl.fdpImpl
		 * @see Bonjour.impl.BonjourPackageImpl#getfdp()
		 * @generated
		 */
		EClass FDP = eINSTANCE.getfdp();

		/**
		 * The meta object literal for the '<em><b>Vfjdo</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute FDP__VFJDO = eINSTANCE.getfdp_Vfjdo();

		/**
		 * The meta object literal for the '<em><b>Connard</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference FDP__CONNARD = eINSTANCE.getfdp_Connard();

		/**
		 * The meta object literal for the '{@link Bonjour.impl.enculeImpl <em>encule</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see Bonjour.impl.enculeImpl
		 * @see Bonjour.impl.BonjourPackageImpl#getencule()
		 * @generated
		 */
		EClass ENCULE = eINSTANCE.getencule();

		/**
		 * The meta object literal for the '<em><b>Fdp</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ENCULE__FDP = eINSTANCE.getencule_Fdp();

	}

} //BonjourPackage
