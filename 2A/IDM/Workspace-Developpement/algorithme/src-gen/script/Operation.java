/**
 */
package script;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Operation</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link script.Operation#getInputs <em>Inputs</em>}</li>
 * </ul>
 *
 * @see script.ScriptPackage#getOperation()
 * @model abstract="true"
 * @generated
 */
public interface Operation extends EObject {
	/**
	 * Returns the value of the '<em><b>Inputs</b></em>' reference list.
	 * The list contents are of type {@link script.Inputs}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Inputs</em>' reference list.
	 * @see script.ScriptPackage#getOperation_Inputs()
	 * @model required="true" upper="2"
	 * @generated
	 */
	EList<Inputs> getInputs();

} // Operation
