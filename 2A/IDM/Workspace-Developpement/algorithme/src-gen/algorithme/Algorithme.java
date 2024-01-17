/**
 */
package algorithme;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Algorithme</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link algorithme.Algorithme#getName <em>Name</em>}</li>
 *   <li>{@link algorithme.Algorithme#getRessource <em>Ressource</em>}</li>
 *   <li>{@link algorithme.Algorithme#getDocumentation <em>Documentation</em>}</li>
 * </ul>
 *
 * @see algorithme.AlgorithmePackage#getAlgorithme()
 * @model
 * @generated
 */
public interface Algorithme extends AlgorithmeElement {
	/**
	 * Returns the value of the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Name</em>' attribute.
	 * @see #setName(String)
	 * @see algorithme.AlgorithmePackage#getAlgorithme_Name()
	 * @model
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link algorithme.Algorithme#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

	/**
	 * Returns the value of the '<em><b>Ressource</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Ressource</em>' containment reference.
	 * @see #setRessource(Ressource)
	 * @see algorithme.AlgorithmePackage#getAlgorithme_Ressource()
	 * @model containment="true" required="true"
	 * @generated
	 */
	Ressource getRessource();

	/**
	 * Sets the value of the '{@link algorithme.Algorithme#getRessource <em>Ressource</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Ressource</em>' containment reference.
	 * @see #getRessource()
	 * @generated
	 */
	void setRessource(Ressource value);

	/**
	 * Returns the value of the '<em><b>Documentation</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Documentation</em>' containment reference.
	 * @see #setDocumentation(Documentation)
	 * @see algorithme.AlgorithmePackage#getAlgorithme_Documentation()
	 * @model containment="true" required="true"
	 * @generated
	 */
	Documentation getDocumentation();

	/**
	 * Sets the value of the '{@link algorithme.Algorithme#getDocumentation <em>Documentation</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Documentation</em>' containment reference.
	 * @see #getDocumentation()
	 * @generated
	 */
	void setDocumentation(Documentation value);

} // Algorithme
