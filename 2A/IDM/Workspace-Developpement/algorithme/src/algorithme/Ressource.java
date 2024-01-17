/**
 */
package algorithme;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

import tableur.ColonneInput;
import tableur.ColonneOutput;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Ressource</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link algorithme.Ressource#getFile <em>File</em>}</li>
 *   <li>{@link algorithme.Ressource#getStdin <em>Stdin</em>}</li>
 *   <li>{@link algorithme.Ressource#getStdout <em>Stdout</em>}</li>
 * </ul>
 *
 * @see algorithme.AlgorithmePackage#getRessource()
 * @model
 * @generated
 */
public interface Ressource extends EObject {
	/**
	 * Returns the value of the '<em><b>File</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>File</em>' attribute.
	 * @see #setFile(String)
	 * @see algorithme.AlgorithmePackage#getRessource_File()
	 * @model
	 * @generated
	 */
	String getFile();

	/**
	 * Sets the value of the '{@link algorithme.Ressource#getFile <em>File</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>File</em>' attribute.
	 * @see #getFile()
	 * @generated
	 */
	void setFile(String value);

	/**
	 * Returns the value of the '<em><b>Stdin</b></em>' reference list.
	 * The list contents are of type {@link tableur.ColonneInput}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Stdin</em>' reference list.
	 * @see algorithme.AlgorithmePackage#getRessource_Stdin()
	 * @model
	 * @generated
	 */
	EList<ColonneInput> getStdin();

	/**
	 * Returns the value of the '<em><b>Stdout</b></em>' reference list.
	 * The list contents are of type {@link tableur.ColonneOutput}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Stdout</em>' reference list.
	 * @see algorithme.AlgorithmePackage#getRessource_Stdout()
	 * @model
	 * @generated
	 */
	EList<ColonneOutput> getStdout();

} // Ressource
