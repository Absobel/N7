/**
 */
package Excel;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Operations Unaires</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link Excel.OperationsUnaires#getData <em>Data</em>}</li>
 * </ul>
 *
 * @see Excel.ExcelPackage#getOperationsUnaires()
 * @model
 * @generated
 */
public interface OperationsUnaires extends Operations {
	/**
	 * Returns the value of the '<em><b>Data</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Data</em>' reference.
	 * @see #setData(Data)
	 * @see Excel.ExcelPackage#getOperationsUnaires_Data()
	 * @model required="true"
	 * @generated
	 */
	Data getData();

	/**
	 * Sets the value of the '{@link Excel.OperationsUnaires#getData <em>Data</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Data</em>' reference.
	 * @see #getData()
	 * @generated
	 */
	void setData(Data value);

} // OperationsUnaires
