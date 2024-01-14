/**
 */
package Excelbis;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Colonne Output</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link Excelbis.ColonneOutput#getOperations <em>Operations</em>}</li>
 * </ul>
 *
 * @see Excelbis.ExcelbisPackage#getColonneOutput()
 * @model
 * @generated
 */
public interface ColonneOutput extends Colonne {

	/**
	 * Returns the value of the '<em><b>Operations</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Operations</em>' containment reference.
	 * @see #setOperations(Operations)
	 * @see Excelbis.ExcelbisPackage#getColonneOutput_Operations()
	 * @model containment="true" required="true"
	 * @generated
	 */
	Operations getOperations();

	/**
	 * Sets the value of the '{@link Excelbis.ColonneOutput#getOperations <em>Operations</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Operations</em>' containment reference.
	 * @see #getOperations()
	 * @generated
	 */
	void setOperations(Operations value);
} // ColonneOutput
