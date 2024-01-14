/**
 */
package Algorithme;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Algorithme</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link Algorithme.Algorithme#getRessource <em>Ressource</em>}</li>
 *   <li>{@link Algorithme.Algorithme#getName <em>Name</em>}</li>
 * </ul>
 *
 * @see Algorithme.AlgorithmePackage#getAlgorithme()
 * @model
 * @generated
 */
public interface Algorithme extends AlgorithmeElement {
	/**
	 * Returns the value of the '<em><b>Ressource</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Ressource</em>' reference.
	 * @see #setRessource(Ressource)
	 * @see Algorithme.AlgorithmePackage#getAlgorithme_Ressource()
	 * @model required="true"
	 * @generated
	 */
	Ressource getRessource();

	/**
	 * Sets the value of the '{@link Algorithme.Algorithme#getRessource <em>Ressource</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Ressource</em>' reference.
	 * @see #getRessource()
	 * @generated
	 */
	void setRessource(Ressource value);

	/**
	 * Returns the value of the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Name</em>' attribute.
	 * @see #setName(String)
	 * @see Algorithme.AlgorithmePackage#getAlgorithme_Name()
	 * @model
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link Algorithme.Algorithme#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

} // Algorithme
