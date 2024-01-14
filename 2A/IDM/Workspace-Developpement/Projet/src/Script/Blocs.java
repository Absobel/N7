/**
 */
package Script;

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
 *   <li>{@link Script.Blocs#getOperations <em>Operations</em>}</li>
 *   <li>{@link Script.Blocs#getOutput <em>Output</em>}</li>
 *   <li>{@link Script.Blocs#getInputs <em>Inputs</em>}</li>
 * </ul>
 *
 * @see Script.ScriptPackage#getBlocs()
 * @model
 * @generated
 */
public interface Blocs extends EObject {
	/**
	 * Returns the value of the '<em><b>Operations</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Operations</em>' containment reference.
	 * @see #setOperations(Operations)
	 * @see Script.ScriptPackage#getBlocs_Operations()
	 * @model containment="true" required="true"
	 * @generated
	 */
	Operations getOperations();

	/**
	 * Sets the value of the '{@link Script.Blocs#getOperations <em>Operations</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Operations</em>' containment reference.
	 * @see #getOperations()
	 * @generated
	 */
	void setOperations(Operations value);

	/**
	 * Returns the value of the '<em><b>Output</b></em>' containment reference list.
	 * The list contents are of type {@link Script.Data}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Output</em>' containment reference list.
	 * @see Script.ScriptPackage#getBlocs_Output()
	 * @model containment="true" required="true"
	 * @generated
	 */
	EList<Data> getOutput();

	/**
	 * Returns the value of the '<em><b>Inputs</b></em>' reference list.
	 * The list contents are of type {@link Script.Data}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Inputs</em>' reference list.
	 * @see Script.ScriptPackage#getBlocs_Inputs()
	 * @model required="true"
	 * @generated
	 */
	EList<Data> getInputs();

} // Blocs
