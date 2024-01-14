/**
 */
package catalogue;

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
 *   <li>{@link catalogue.Catalogue#getAlgorithmeelement <em>Algorithmeelement</em>}</li>
 * </ul>
 *
 * @see catalogue.CataloguePackage#getCatalogue()
 * @model
 * @generated
 */
public interface Catalogue extends EObject {
	/**
	 * Returns the value of the '<em><b>Algorithmeelement</b></em>' reference list.
	 * The list contents are of type {@link catalogue.AlgorithmeElement}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Algorithmeelement</em>' reference list.
	 * @see catalogue.CataloguePackage#getCatalogue_Algorithmeelement()
	 * @model
	 * @generated
	 */
	EList<AlgorithmeElement> getAlgorithmeelement();

} // Catalogue
