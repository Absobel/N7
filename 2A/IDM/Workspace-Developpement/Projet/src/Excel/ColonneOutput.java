/**
 */
package Excel;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Colonne Output</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link Excel.ColonneOutput#getOperation <em>Operation</em>}</li>
 * </ul>
 *
 * @see Excel.ExcelPackage#getColonneOutput()
 * @model
 * @generated
 */
public interface ColonneOutput extends Colonne {
	/**
	 * Returns the value of the '<em><b>Operation</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Operation</em>' containment reference.
	 * @see #setOperation(Operations)
	 * @see Excel.ExcelPackage#getColonneOutput_Operation()
	 * @model containment="true" required="true"
	 * @generated
	 */
	Operations getOperation();

	/**
	 * Sets the value of the '{@link Excel.ColonneOutput#getOperation <em>Operation</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Operation</em>' containment reference.
	 * @see #getOperation()
	 * @generated
	 */
	void setOperation(Operations value);

} // ColonneOutput
