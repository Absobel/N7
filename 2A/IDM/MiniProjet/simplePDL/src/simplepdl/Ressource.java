/**
 */
package simplepdl;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Ressource</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link simplepdl.Ressource#getType <em>Type</em>}</li>
 *   <li>{@link simplepdl.Ressource#getTotalQuantity <em>Total Quantity</em>}</li>
 * </ul>
 *
 * @see simplepdl.SimplepdlPackage#getRessource()
 * @model
 * @generated
 */
public interface Ressource extends ProcessElement {
	/**
	 * Returns the value of the '<em><b>Type</b></em>' attribute.
	 * The literals are from the enumeration {@link simplepdl.ResourceType}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Type</em>' attribute.
	 * @see simplepdl.ResourceType
	 * @see #setType(ResourceType)
	 * @see simplepdl.SimplepdlPackage#getRessource_Type()
	 * @model required="true"
	 * @generated
	 */
	ResourceType getType();

	/**
	 * Sets the value of the '{@link simplepdl.Ressource#getType <em>Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Type</em>' attribute.
	 * @see simplepdl.ResourceType
	 * @see #getType()
	 * @generated
	 */
	void setType(ResourceType value);

	/**
	 * Returns the value of the '<em><b>Total Quantity</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Total Quantity</em>' attribute.
	 * @see #setTotalQuantity(int)
	 * @see simplepdl.SimplepdlPackage#getRessource_TotalQuantity()
	 * @model required="true"
	 * @generated
	 */
	int getTotalQuantity();

	/**
	 * Sets the value of the '{@link simplepdl.Ressource#getTotalQuantity <em>Total Quantity</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Total Quantity</em>' attribute.
	 * @see #getTotalQuantity()
	 * @generated
	 */
	void setTotalQuantity(int value);

} // Ressource
