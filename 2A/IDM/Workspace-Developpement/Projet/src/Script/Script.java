/**
 */
package Script;

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
 *   <li>{@link Script.Script#getName <em>Name</em>}</li>
 *   <li>{@link Script.Script#getBlocs <em>Blocs</em>}</li>
 *   <li>{@link Script.Script#getFinalOutput <em>Final Output</em>}</li>
 *   <li>{@link Script.Script#getInitialInput <em>Initial Input</em>}</li>
 * </ul>
 *
 * @see Script.ScriptPackage#getScript()
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
	 * @see Script.ScriptPackage#getScript_Name()
	 * @model required="true"
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link Script.Script#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

	/**
	 * Returns the value of the '<em><b>Blocs</b></em>' containment reference list.
	 * The list contents are of type {@link Script.Blocs}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Blocs</em>' containment reference list.
	 * @see Script.ScriptPackage#getScript_Blocs()
	 * @model containment="true"
	 * @generated
	 */
	EList<Blocs> getBlocs();

	/**
	 * Returns the value of the '<em><b>Final Output</b></em>' reference list.
	 * The list contents are of type {@link Script.Data}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Final Output</em>' reference list.
	 * @see Script.ScriptPackage#getScript_FinalOutput()
	 * @model required="true"
	 * @generated
	 */
	EList<Data> getFinalOutput();

	/**
	 * Returns the value of the '<em><b>Initial Input</b></em>' containment reference list.
	 * The list contents are of type {@link Script.Data}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Initial Input</em>' containment reference list.
	 * @see Script.ScriptPackage#getScript_InitialInput()
	 * @model containment="true" required="true"
	 * @generated
	 */
	EList<Data> getInitialInput();

} // Script
