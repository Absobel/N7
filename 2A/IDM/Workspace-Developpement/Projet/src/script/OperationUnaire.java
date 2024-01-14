/**
 */
package script;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Operation Unaire</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link script.OperationUnaire#getFonction <em>Fonction</em>}</li>
 * </ul>
 *
 * @see script.ScriptPackage#getOperationUnaire()
 * @model
 * @generated
 */
public interface OperationUnaire extends Operations {
	/**
	 * Returns the value of the '<em><b>Fonction</b></em>' attribute.
	 * The literals are from the enumeration {@link script.FonctionType}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Fonction</em>' attribute.
	 * @see script.FonctionType
	 * @see #setFonction(FonctionType)
	 * @see script.ScriptPackage#getOperationUnaire_Fonction()
	 * @model required="true"
	 * @generated
	 */
	FonctionType getFonction();

	/**
	 * Sets the value of the '{@link script.OperationUnaire#getFonction <em>Fonction</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Fonction</em>' attribute.
	 * @see script.FonctionType
	 * @see #getFonction()
	 * @generated
	 */
	void setFonction(FonctionType value);

} // OperationUnaire
