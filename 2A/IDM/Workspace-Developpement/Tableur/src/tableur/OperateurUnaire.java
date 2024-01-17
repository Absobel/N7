/**
 */
package tableur;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Operateur Unaire</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link tableur.OperateurUnaire#getKind <em>Kind</em>}</li>
 * </ul>
 *
 * @see tableur.TableurPackage#getOperateurUnaire()
 * @model
 * @generated
 */
public interface OperateurUnaire extends Operation {
	/**
	 * Returns the value of the '<em><b>Kind</b></em>' attribute.
	 * The literals are from the enumeration {@link tableur.OperateurUnaireType}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Kind</em>' attribute.
	 * @see tableur.OperateurUnaireType
	 * @see #setKind(OperateurUnaireType)
	 * @see tableur.TableurPackage#getOperateurUnaire_Kind()
	 * @model required="true"
	 * @generated
	 */
	OperateurUnaireType getKind();

	/**
	 * Sets the value of the '{@link tableur.OperateurUnaire#getKind <em>Kind</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Kind</em>' attribute.
	 * @see tableur.OperateurUnaireType
	 * @see #getKind()
	 * @generated
	 */
	void setKind(OperateurUnaireType value);

} // OperateurUnaire
