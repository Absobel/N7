/**
 */
package Algorithme;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Comment</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link Algorithme.Comment#getAlgorithmeElement <em>Algorithme Element</em>}</li>
 *   <li>{@link Algorithme.Comment#getComment <em>Comment</em>}</li>
 * </ul>
 *
 * @see Algorithme.AlgorithmePackage#getComment()
 * @model
 * @generated
 */
public interface Comment extends AlgorithmeElement {
	/**
	 * Returns the value of the '<em><b>Algorithme Element</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Algorithme Element</em>' containment reference.
	 * @see #setAlgorithmeElement(AlgorithmeElement)
	 * @see Algorithme.AlgorithmePackage#getComment_AlgorithmeElement()
	 * @model containment="true" required="true"
	 * @generated
	 */
	AlgorithmeElement getAlgorithmeElement();

	/**
	 * Sets the value of the '{@link Algorithme.Comment#getAlgorithmeElement <em>Algorithme Element</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Algorithme Element</em>' containment reference.
	 * @see #getAlgorithmeElement()
	 * @generated
	 */
	void setAlgorithmeElement(AlgorithmeElement value);

	/**
	 * Returns the value of the '<em><b>Comment</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Comment</em>' attribute.
	 * @see #setComment(String)
	 * @see Algorithme.AlgorithmePackage#getComment_Comment()
	 * @model
	 * @generated
	 */
	String getComment();

	/**
	 * Sets the value of the '{@link Algorithme.Comment#getComment <em>Comment</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Comment</em>' attribute.
	 * @see #getComment()
	 * @generated
	 */
	void setComment(String value);

} // Comment
