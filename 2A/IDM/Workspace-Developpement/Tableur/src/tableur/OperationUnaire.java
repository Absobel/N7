/**
 */
package tableur;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Operation Unaire</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link tableur.OperationUnaire#getKind <em>Kind</em>}</li>
 *   <li>{@link tableur.OperationUnaire#getColonne <em>Colonne</em>}</li>
 * </ul>
 *
 * @see tableur.TableurPackage#getOperationUnaire()
 * @model
 * @generated
 */
public interface OperationUnaire extends Operation {
	/**
	 * Returns the value of the '<em><b>Kind</b></em>' attribute.
	 * The literals are from the enumeration {@link tableur.operateurUnaire}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Kind</em>' attribute.
	 * @see tableur.operateurUnaire
	 * @see #setKind(operateurUnaire)
	 * @see tableur.TableurPackage#getOperationUnaire_Kind()
	 * @model
	 * @generated
	 */
	operateurUnaire getKind();

	/**
	 * Sets the value of the '{@link tableur.OperationUnaire#getKind <em>Kind</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Kind</em>' attribute.
	 * @see tableur.operateurUnaire
	 * @see #getKind()
	 * @generated
	 */
	void setKind(operateurUnaire value);

	/**
	 * Returns the value of the '<em><b>Colonne</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Colonne</em>' reference.
	 * @see #setColonne(Colonne)
	 * @see tableur.TableurPackage#getOperationUnaire_Colonne()
	 * @model required="true"
	 * @generated
	 */
	Colonne getColonne();

	/**
	 * Sets the value of the '{@link tableur.OperationUnaire#getColonne <em>Colonne</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Colonne</em>' reference.
	 * @see #getColonne()
	 * @generated
	 */
	void setColonne(Colonne value);

} // OperationUnaire
