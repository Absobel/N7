/**
 */
package Bonjour;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>fdp</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link Bonjour.fdp#getVfjdo <em>Vfjdo</em>}</li>
 *   <li>{@link Bonjour.fdp#getConnard <em>Connard</em>}</li>
 * </ul>
 *
 * @see Bonjour.BonjourPackage#getfdp()
 * @model
 * @generated
 */
public interface fdp extends EObject {
	/**
	 * Returns the value of the '<em><b>Vfjdo</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Vfjdo</em>' attribute.
	 * @see #setVfjdo(String)
	 * @see Bonjour.BonjourPackage#getfdp_Vfjdo()
	 * @model
	 * @generated
	 */
	String getVfjdo();

	/**
	 * Sets the value of the '{@link Bonjour.fdp#getVfjdo <em>Vfjdo</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Vfjdo</em>' attribute.
	 * @see #getVfjdo()
	 * @generated
	 */
	void setVfjdo(String value);

	/**
	 * Returns the value of the '<em><b>Connard</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Connard</em>' reference.
	 * @see #setConnard(connard)
	 * @see Bonjour.BonjourPackage#getfdp_Connard()
	 * @model
	 * @generated
	 */
	connard getConnard();

	/**
	 * Sets the value of the '{@link Bonjour.fdp#getConnard <em>Connard</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Connard</em>' reference.
	 * @see #getConnard()
	 * @generated
	 */
	void setConnard(connard value);

} // fdp
