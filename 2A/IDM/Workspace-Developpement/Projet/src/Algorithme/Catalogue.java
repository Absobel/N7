/**
 */
package Algorithme;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Catalogue</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link Algorithme.Catalogue#getAlgorithmes <em>Algorithmes</em>}</li>
 *   <li>{@link Algorithme.Catalogue#getName <em>Name</em>}</li>
 * </ul>
 *
 * @see Algorithme.AlgorithmePackage#getCatalogue()
 * @model
 * @generated
 */
public interface Catalogue extends EObject {
	/**
	 * Returns the value of the '<em><b>Algorithmes</b></em>' reference list.
	 * The list contents are of type {@link Algorithme.AlgorithmeElement}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Algorithmes</em>' reference list.
	 * @see Algorithme.AlgorithmePackage#getCatalogue_Algorithmes()
	 * @model
	 * @generated
	 */
	EList<AlgorithmeElement> getAlgorithmes();

	/**
	 * Returns the value of the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Name</em>' attribute.
	 * @see #setName(String)
	 * @see Algorithme.AlgorithmePackage#getCatalogue_Name()
	 * @model
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link Algorithme.Catalogue#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

} // Catalogue
