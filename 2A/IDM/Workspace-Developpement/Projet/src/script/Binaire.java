/**
 */
package script;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Binaire</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link script.Binaire#getOperateur <em>Operateur</em>}</li>
 * </ul>
 *
 * @see script.ScriptPackage#getBinaire()
 * @model
 * @generated
 */
public interface Binaire extends Operations {
	/**
	 * Returns the value of the '<em><b>Operateur</b></em>' attribute.
	 * The literals are from the enumeration {@link script.OperationsBinaires}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Operateur</em>' attribute.
	 * @see script.OperationsBinaires
	 * @see #setOperateur(OperationsBinaires)
	 * @see script.ScriptPackage#getBinaire_Operateur()
	 * @model required="true"
	 * @generated
	 */
	OperationsBinaires getOperateur();

	/**
	 * Sets the value of the '{@link script.Binaire#getOperateur <em>Operateur</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Operateur</em>' attribute.
	 * @see script.OperationsBinaires
	 * @see #getOperateur()
	 * @generated
	 */
	void setOperateur(OperationsBinaires value);

} // Binaire
