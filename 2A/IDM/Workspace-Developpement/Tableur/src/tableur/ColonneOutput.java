/**
 */
package tableur;

import algorithme.Algorithme;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Colonne Output</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link tableur.ColonneOutput#getAlgo <em>Algo</em>}</li>
 *   <li>{@link tableur.ColonneOutput#getColonnes <em>Colonnes</em>}</li>
 *   <li>{@link tableur.ColonneOutput#getOperation <em>Operation</em>}</li>
 * </ul>
 *
 * @see tableur.TableurPackage#getColonneOutput()
 * @model
 * @generated
 */
public interface ColonneOutput extends Colonne {
	/**
	 * Returns the value of the '<em><b>Algo</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Algo</em>' reference.
	 * @see #setAlgo(Algorithme)
	 * @see tableur.TableurPackage#getColonneOutput_Algo()
	 * @model
	 * @generated
	 */
	Algorithme getAlgo();

	/**
	 * Sets the value of the '{@link tableur.ColonneOutput#getAlgo <em>Algo</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Algo</em>' reference.
	 * @see #getAlgo()
	 * @generated
	 */
	void setAlgo(Algorithme value);

	/**
	 * Returns the value of the '<em><b>Colonnes</b></em>' reference list.
	 * The list contents are of type {@link tableur.Colonne}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Colonnes</em>' reference list.
	 * @see tableur.TableurPackage#getColonneOutput_Colonnes()
	 * @model required="true" upper="2"
	 * @generated
	 */
	EList<Colonne> getColonnes();

	/**
	 * Returns the value of the '<em><b>Operation</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Operation</em>' containment reference.
	 * @see #setOperation(Operation)
	 * @see tableur.TableurPackage#getColonneOutput_Operation()
	 * @model containment="true" required="true"
	 * @generated
	 */
	Operation getOperation();

	/**
	 * Sets the value of the '{@link tableur.ColonneOutput#getOperation <em>Operation</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Operation</em>' containment reference.
	 * @see #getOperation()
	 * @generated
	 */
	void setOperation(Operation value);

} // ColonneOutput
