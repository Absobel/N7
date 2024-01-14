/**
 */
package catalogue;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Comment</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link catalogue.Comment#getAlgorithmEelement <em>Algorithm Eelement</em>}</li>
 *   <li>{@link catalogue.Comment#getComment <em>Comment</em>}</li>
 * </ul>
 *
 * @see catalogue.CataloguePackage#getComment()
 * @model
 * @generated
 */
public interface Comment extends EObject {
	/**
	 * Returns the value of the '<em><b>Algorithm Eelement</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Algorithm Eelement</em>' containment reference.
	 * @see #setAlgorithmEelement(AlgorithmeElement)
	 * @see catalogue.CataloguePackage#getComment_AlgorithmEelement()
	 * @model containment="true" required="true"
	 * @generated
	 */
	AlgorithmeElement getAlgorithmEelement();

	/**
	 * Sets the value of the '{@link catalogue.Comment#getAlgorithmEelement <em>Algorithm Eelement</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Algorithm Eelement</em>' containment reference.
	 * @see #getAlgorithmEelement()
	 * @generated
	 */
	void setAlgorithmEelement(AlgorithmeElement value);

	/**
	 * Returns the value of the '<em><b>Comment</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Comment</em>' attribute.
	 * @see #setComment(String)
	 * @see catalogue.CataloguePackage#getComment_Comment()
	 * @model required="true"
	 * @generated
	 */
	String getComment();

	/**
	 * Sets the value of the '{@link catalogue.Comment#getComment <em>Comment</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Comment</em>' attribute.
	 * @see #getComment()
	 * @generated
	 */
	void setComment(String value);

} // Comment
