/**
 */
package script;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Blocs</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link script.Blocs#getOutput <em>Output</em>}</li>
 *   <li>{@link script.Blocs#getInputs <em>Inputs</em>}</li>
 *   <li>{@link script.Blocs#getOperation <em>Operation</em>}</li>
 * </ul>
 *
 * @see script.ScriptPackage#getBlocs()
 * @model
 * @generated
 */
public interface Blocs extends EObject {
	/**
	 * Returns the value of the '<em><b>Output</b></em>' containment reference list.
	 * The list contents are of type {@link script.Data}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Output</em>' containment reference list.
	 * @see script.ScriptPackage#getBlocs_Output()
	 * @model containment="true" required="true"
	 * @generated
	 */
	EList<Data> getOutput();

	/**
	 * Returns the value of the '<em><b>Inputs</b></em>' reference list.
	 * The list contents are of type {@link script.Data}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Inputs</em>' reference list.
	 * @see script.ScriptPackage#getBlocs_Inputs()
	 * @model required="true"
	 * @generated
	 */
	EList<Data> getInputs();

	/**
	 * Returns the value of the '<em><b>Operation</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Operation</em>' containment reference.
	 * @see #setOperation(Operations)
	 * @see script.ScriptPackage#getBlocs_Operation()
	 * @model containment="true" required="true"
	 * @generated
	 */
	Operations getOperation();

	/**
	 * Sets the value of the '{@link script.Blocs#getOperation <em>Operation</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Operation</em>' containment reference.
	 * @see #getOperation()
	 * @generated
	 */
	void setOperation(Operations value);

} // Blocs
