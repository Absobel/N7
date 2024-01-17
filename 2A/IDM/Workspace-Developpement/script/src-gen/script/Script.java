/**
 */
package script;

import org.eclipse.emf.common.util.EList;

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
 *   <li>{@link script.Script#getInitialInputs <em>Initial Inputs</em>}</li>
 *   <li>{@link script.Script#getOperation <em>Operation</em>}</li>
 *   <li>{@link script.Script#getFinalOutputs <em>Final Outputs</em>}</li>
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
	 * Returns the value of the '<em><b>Initial Inputs</b></em>' containment reference list.
	 * The list contents are of type {@link script.RealInputs}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Initial Inputs</em>' containment reference list.
	 * @see script.ScriptPackage#getScript_InitialInputs()
	 * @model containment="true"
	 * @generated
	 */
	EList<RealInputs> getInitialInputs();

	/**
	 * Returns the value of the '<em><b>Operation</b></em>' containment reference list.
	 * The list contents are of type {@link script.Operation}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Operation</em>' containment reference list.
	 * @see script.ScriptPackage#getScript_Operation()
	 * @model containment="true" required="true"
	 * @generated
	 */
	EList<Operation> getOperation();

	/**
	 * Returns the value of the '<em><b>Final Outputs</b></em>' containment reference list.
	 * The list contents are of type {@link script.Output}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Final Outputs</em>' containment reference list.
	 * @see script.ScriptPackage#getScript_FinalOutputs()
	 * @model containment="true"
	 * @generated
	 */
	EList<Output> getFinalOutputs();

} // Script
