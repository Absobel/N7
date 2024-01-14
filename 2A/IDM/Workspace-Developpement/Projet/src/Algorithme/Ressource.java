/**
 */
package Algorithme;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Ressource</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link Algorithme.Ressource#getStout <em>Stout</em>}</li>
 *   <li>{@link Algorithme.Ressource#getStdin <em>Stdin</em>}</li>
 *   <li>{@link Algorithme.Ressource#getFile <em>File</em>}</li>
 * </ul>
 *
 * @see Algorithme.AlgorithmePackage#getRessource()
 * @model
 * @generated
 */
public interface Ressource extends AlgorithmeElement {
	/**
	 * Returns the value of the '<em><b>Stout</b></em>' reference list.
	 * The list contents are of type {@link Algorithme.Stout}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Stout</em>' reference list.
	 * @see Algorithme.AlgorithmePackage#getRessource_Stout()
	 * @model
	 * @generated
	 */
	EList<Stout> getStout();

	/**
	 * Returns the value of the '<em><b>Stdin</b></em>' reference list.
	 * The list contents are of type {@link Algorithme.Stdin}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Stdin</em>' reference list.
	 * @see Algorithme.AlgorithmePackage#getRessource_Stdin()
	 * @model
	 * @generated
	 */
	EList<Stdin> getStdin();

	/**
	 * Returns the value of the '<em><b>File</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>File</em>' attribute.
	 * @see #setFile(String)
	 * @see Algorithme.AlgorithmePackage#getRessource_File()
	 * @model
	 * @generated
	 */
	String getFile();

	/**
	 * Sets the value of the '{@link Algorithme.Ressource#getFile <em>File</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>File</em>' attribute.
	 * @see #getFile()
	 * @generated
	 */
	void setFile(String value);

} // Ressource
