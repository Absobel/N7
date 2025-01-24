/**
 */
package script;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Operation Binaire</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link script.OperationBinaire#getOperateur <em>Operateur</em>}</li>
 *   <li>{@link script.OperationBinaire#getOutput <em>Output</em>}</li>
 * </ul>
 *
 * @see script.ScriptPackage#getOperationBinaire()
 * @model
 * @generated
 */
public interface OperationBinaire extends Operation {
	/**
	 * Returns the value of the '<em><b>Operateur</b></em>' attribute.
	 * The literals are from the enumeration {@link script.OperationBinaireType}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Operateur</em>' attribute.
	 * @see script.OperationBinaireType
	 * @see #setOperateur(OperationBinaireType)
	 * @see script.ScriptPackage#getOperationBinaire_Operateur()
	 * @model
	 * @generated
	 */
	OperationBinaireType getOperateur();

	/**
	 * Sets the value of the '{@link script.OperationBinaire#getOperateur <em>Operateur</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Operateur</em>' attribute.
	 * @see script.OperationBinaireType
	 * @see #getOperateur()
	 * @generated
	 */
	void setOperateur(OperationBinaireType value);

	/**
	 * Returns the value of the '<em><b>Output</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Output</em>' containment reference.
	 * @see #setOutput(Output)
	 * @see script.ScriptPackage#getOperationBinaire_Output()
	 * @model containment="true" required="true"
	 * @generated
	 */
	Output getOutput();

	/**
	 * Sets the value of the '{@link script.OperationBinaire#getOutput <em>Output</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Output</em>' containment reference.
	 * @see #getOutput()
	 * @generated
	 */
	void setOutput(Output value);

} // OperationBinaire
