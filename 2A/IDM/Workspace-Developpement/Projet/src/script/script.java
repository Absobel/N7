/**
 */
package script;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>script</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link script.script#getName <em>Name</em>}</li>
 *   <li>{@link script.script#getBlocs <em>Blocs</em>}</li>
 *   <li>{@link script.script#getInitialInput <em>Initial Input</em>}</li>
 *   <li>{@link script.script#getFinalOutput <em>Final Output</em>}</li>
 * </ul>
 *
 * @see script.ScriptPackage#getscript()
 * @model
 * @generated
 */
public interface script extends EObject {
	/**
	 * Returns the value of the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Name</em>' attribute.
	 * @see #setName(String)
	 * @see script.ScriptPackage#getscript_Name()
	 * @model required="true"
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link script.script#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

	/**
	 * Returns the value of the '<em><b>Blocs</b></em>' containment reference list.
	 * The list contents are of type {@link script.blocs}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Blocs</em>' containment reference list.
	 * @see script.ScriptPackage#getscript_Blocs()
	 * @model containment="true"
	 * @generated
	 */
	EList<blocs> getBlocs();

	/**
	 * Returns the value of the '<em><b>Initial Input</b></em>' containment reference list.
	 * The list contents are of type {@link script.Data}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Initial Input</em>' containment reference list.
	 * @see script.ScriptPackage#getscript_InitialInput()
	 * @model containment="true" required="true"
	 * @generated
	 */
	EList<Data> getInitialInput();

	/**
	 * Returns the value of the '<em><b>Final Output</b></em>' reference list.
	 * The list contents are of type {@link script.Data}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Final Output</em>' reference list.
	 * @see script.ScriptPackage#getscript_FinalOutput()
	 * @model required="true"
	 * @generated
	 */
	EList<Data> getFinalOutput();

} // script
