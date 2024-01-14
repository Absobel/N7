/**
 */
package Script;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Binaire</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link Script.Binaire#getOperateur <em>Operateur</em>}</li>
 * </ul>
 *
 * @see Script.ScriptPackage#getBinaire()
 * @model
 * @generated
 */
public interface Binaire extends Operations {
	/**
	 * Returns the value of the '<em><b>Operateur</b></em>' attribute.
	 * The literals are from the enumeration {@link Script.OperationsBinairesType}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Operateur</em>' attribute.
	 * @see Script.OperationsBinairesType
	 * @see #setOperateur(OperationsBinairesType)
	 * @see Script.ScriptPackage#getBinaire_Operateur()
	 * @model required="true"
	 * @generated
	 */
	OperationsBinairesType getOperateur();

	/**
	 * Sets the value of the '{@link Script.Binaire#getOperateur <em>Operateur</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Operateur</em>' attribute.
	 * @see Script.OperationsBinairesType
	 * @see #getOperateur()
	 * @generated
	 */
	void setOperateur(OperationsBinairesType value);

} // Binaire
