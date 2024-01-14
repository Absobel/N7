/**
 */
package Bonjour;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see Bonjour.BonjourPackage
 * @generated
 */
public interface BonjourFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	BonjourFactory eINSTANCE = Bonjour.impl.BonjourFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>connard</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>connard</em>'.
	 * @generated
	 */
	connard createconnard();

	/**
	 * Returns a new object of class '<em>fdp</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>fdp</em>'.
	 * @generated
	 */
	fdp createfdp();

	/**
	 * Returns a new object of class '<em>encule</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>encule</em>'.
	 * @generated
	 */
	encule createencule();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	BonjourPackage getBonjourPackage();

} //BonjourFactory
