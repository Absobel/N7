/**
 */
package script;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Script</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link script.Script#getName <em>Name</em>}</li>
 *   <li>{@link script.Script#getCalcul <em>Calcul</em>}</li>
 * </ul>
 *
 * @see script.ScriptPackage#getScript()
 * @model
 * @generated
 */
public interface Script extends EObject {
	/**
	 * Returns the value of the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Name</em>' attribute.
	 * @see #setName(String)
	 * @see script.ScriptPackage#getScript_Name()
	 * @model
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link script.Script#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

	/**
	 * Returns the value of the '<em><b>Calcul</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Calcul</em>' containment reference.
	 * @see #setCalcul(Calcul)
	 * @see script.ScriptPackage#getScript_Calcul()
	 * @model containment="true" required="true"
	 * @generated
	 */
	Calcul getCalcul();

	/**
	 * Sets the value of the '{@link script.Script#getCalcul <em>Calcul</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Calcul</em>' containment reference.
	 * @see #getCalcul()
	 * @generated
	 */
	void setCalcul(Calcul value);

} // Script
