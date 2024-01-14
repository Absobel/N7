/**
 */
package catalogue;

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
 *   <li>{@link catalogue.Ressource#getStdout <em>Stdout</em>}</li>
 *   <li>{@link catalogue.Ressource#getStdin <em>Stdin</em>}</li>
 *   <li>{@link catalogue.Ressource#getFile <em>File</em>}</li>
 * </ul>
 *
 * @see catalogue.CataloguePackage#getRessource()
 * @model
 * @generated
 */
public interface Ressource extends AlgorithmeElement {
	/**
	 * Returns the value of the '<em><b>Stdout</b></em>' reference list.
	 * The list contents are of type {@link catalogue.Stdout}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Stdout</em>' reference list.
	 * @see catalogue.CataloguePackage#getRessource_Stdout()
	 * @model
	 * @generated
	 */
	EList<Stdout> getStdout();

	/**
	 * Returns the value of the '<em><b>Stdin</b></em>' reference list.
	 * The list contents are of type {@link catalogue.Stdin}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Stdin</em>' reference list.
	 * @see catalogue.CataloguePackage#getRessource_Stdin()
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
	 * @see catalogue.CataloguePackage#getRessource_File()
	 * @model required="true"
	 * @generated
	 */
	String getFile();

	/**
	 * Sets the value of the '{@link catalogue.Ressource#getFile <em>File</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>File</em>' attribute.
	 * @see #getFile()
	 * @generated
	 */
	void setFile(String value);

} // Ressource
