/**
 */
package catalogue;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Stdin</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link catalogue.Stdin#isDefaultValue <em>Default Value</em>}</li>
 * </ul>
 *
 * @see catalogue.CataloguePackage#getStdin()
 * @model
 * @generated
 */
public interface Stdin extends Data {
	/**
	 * Returns the value of the '<em><b>Default Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Default Value</em>' attribute.
	 * @see #setDefaultValue(boolean)
	 * @see catalogue.CataloguePackage#getStdin_DefaultValue()
	 * @model required="true"
	 * @generated
	 */
	boolean isDefaultValue();

	/**
	 * Sets the value of the '{@link catalogue.Stdin#isDefaultValue <em>Default Value</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Default Value</em>' attribute.
	 * @see #isDefaultValue()
	 * @generated
	 */
	void setDefaultValue(boolean value);

} // Stdin
