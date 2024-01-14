/**
 */
package Excel;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Colonne</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link Excel.Colonne#getIdentifiant <em>Identifiant</em>}</li>
 * </ul>
 *
 * @see Excel.ExcelPackage#getColonne()
 * @model abstract="true"
 * @generated
 */
public interface Colonne extends Data {
	/**
	 * Returns the value of the '<em><b>Identifiant</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Identifiant</em>' attribute.
	 * @see #setIdentifiant(int)
	 * @see Excel.ExcelPackage#getColonne_Identifiant()
	 * @model
	 * @generated
	 */
	int getIdentifiant();

	/**
	 * Sets the value of the '{@link Excel.Colonne#getIdentifiant <em>Identifiant</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Identifiant</em>' attribute.
	 * @see #getIdentifiant()
	 * @generated
	 */
	void setIdentifiant(int value);

} // Colonne
