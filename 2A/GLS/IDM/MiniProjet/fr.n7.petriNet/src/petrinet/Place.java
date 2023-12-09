/**
 */
package petrinet;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Place</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link petrinet.Place#getArcs <em>Arcs</em>}</li>
 *   <li>{@link petrinet.Place#getNbJetons <em>Nb Jetons</em>}</li>
 *   <li>{@link petrinet.Place#getName <em>Name</em>}</li>
 * </ul>
 *
 * @see petrinet.PetrinetPackage#getPlace()
 * @model
 * @generated
 */
public interface Place extends PetriNetElement {
	/**
	 * Returns the value of the '<em><b>Arcs</b></em>' reference list.
	 * The list contents are of type {@link petrinet.Arc}.
	 * It is bidirectional and its opposite is '{@link petrinet.Arc#getPlace <em>Place</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Arcs</em>' reference list.
	 * @see petrinet.PetrinetPackage#getPlace_Arcs()
	 * @see petrinet.Arc#getPlace
	 * @model opposite="place"
	 * @generated
	 */
	EList<Arc> getArcs();

	/**
	 * Returns the value of the '<em><b>Nb Jetons</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Nb Jetons</em>' attribute.
	 * @see #setNbJetons(int)
	 * @see petrinet.PetrinetPackage#getPlace_NbJetons()
	 * @model
	 * @generated
	 */
	int getNbJetons();

	/**
	 * Sets the value of the '{@link petrinet.Place#getNbJetons <em>Nb Jetons</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Nb Jetons</em>' attribute.
	 * @see #getNbJetons()
	 * @generated
	 */
	void setNbJetons(int value);

	/**
	 * Returns the value of the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Name</em>' attribute.
	 * @see #setName(String)
	 * @see petrinet.PetrinetPackage#getPlace_Name()
	 * @model
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link petrinet.Place#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

} // Place
