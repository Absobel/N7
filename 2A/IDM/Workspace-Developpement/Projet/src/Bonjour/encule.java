/**
 */
package Bonjour;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>encule</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link Bonjour.encule#getFdp <em>Fdp</em>}</li>
 * </ul>
 *
 * @see Bonjour.BonjourPackage#getencule()
 * @model
 * @generated
 */
public interface encule extends EObject {
	/**
	 * Returns the value of the '<em><b>Fdp</b></em>' containment reference list.
	 * The list contents are of type {@link Bonjour.fdp}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Fdp</em>' containment reference list.
	 * @see Bonjour.BonjourPackage#getencule_Fdp()
	 * @model containment="true"
	 * @generated
	 */
	EList<fdp> getFdp();

} // encule
