/**
 */
package tableur;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Operation Binaire</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link tableur.OperationBinaire#getKind <em>Kind</em>}</li>
 *   <li>{@link tableur.OperationBinaire#getColonne <em>Colonne</em>}</li>
 * </ul>
 *
 * @see tableur.TableurPackage#getOperationBinaire()
 * @model
 * @generated
 */
public interface OperationBinaire extends Operation {
	/**
	 * Returns the value of the '<em><b>Kind</b></em>' attribute.
	 * The literals are from the enumeration {@link tableur.operateurBinaire}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Kind</em>' attribute.
	 * @see tableur.operateurBinaire
	 * @see #setKind(operateurBinaire)
	 * @see tableur.TableurPackage#getOperationBinaire_Kind()
	 * @model
	 * @generated
	 */
	operateurBinaire getKind();

	/**
	 * Sets the value of the '{@link tableur.OperationBinaire#getKind <em>Kind</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Kind</em>' attribute.
	 * @see tableur.operateurBinaire
	 * @see #getKind()
	 * @generated
	 */
	void setKind(operateurBinaire value);

	/**
	 * Returns the value of the '<em><b>Colonne</b></em>' reference list.
	 * The list contents are of type {@link tableur.Colonne}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Colonne</em>' reference list.
	 * @see tableur.TableurPackage#getOperationBinaire_Colonne()
	 * @model lower="2" upper="2"
	 * @generated
	 */
	EList<Colonne> getColonne();

} // OperationBinaire
