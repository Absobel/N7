/**
 */
package script;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>blocs</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link script.blocs#getInputs <em>Inputs</em>}</li>
 *   <li>{@link script.blocs#getOutputs <em>Outputs</em>}</li>
 *   <li>{@link script.blocs#getOperation <em>Operation</em>}</li>
 * </ul>
 *
 * @see script.ScriptPackage#getblocs()
 * @model
 * @generated
 */
public interface blocs extends EObject {
	/**
	 * Returns the value of the '<em><b>Inputs</b></em>' reference list.
	 * The list contents are of type {@link script.Data}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Inputs</em>' reference list.
	 * @see script.ScriptPackage#getblocs_Inputs()
	 * @model required="true"
	 * @generated
	 */
	EList<Data> getInputs();

	/**
	 * Returns the value of the '<em><b>Outputs</b></em>' containment reference list.
	 * The list contents are of type {@link script.Data}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Outputs</em>' containment reference list.
	 * @see script.ScriptPackage#getblocs_Outputs()
	 * @model containment="true" required="true"
	 * @generated
	 */
	EList<Data> getOutputs();

	/**
	 * Returns the value of the '<em><b>Operation</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Operation</em>' containment reference.
	 * @see #setOperation(Operations)
	 * @see script.ScriptPackage#getblocs_Operation()
	 * @model containment="true" required="true"
	 * @generated
	 */
	Operations getOperation();

	/**
	 * Sets the value of the '{@link script.blocs#getOperation <em>Operation</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Operation</em>' containment reference.
	 * @see #getOperation()
	 * @generated
	 */
	void setOperation(Operations value);

} // blocs
