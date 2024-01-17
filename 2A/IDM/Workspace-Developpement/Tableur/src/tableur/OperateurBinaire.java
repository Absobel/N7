/**
 */
package tableur;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Operateur Binaire</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link tableur.OperateurBinaire#getKind <em>Kind</em>}</li>
 * </ul>
 *
 * @see tableur.TableurPackage#getOperateurBinaire()
 * @model
 * @generated
 */
public interface OperateurBinaire extends Operation {
	/**
	 * Returns the value of the '<em><b>Kind</b></em>' attribute.
	 * The literals are from the enumeration {@link tableur.OperateurBinaireType}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Kind</em>' attribute.
	 * @see tableur.OperateurBinaireType
	 * @see #setKind(OperateurBinaireType)
	 * @see tableur.TableurPackage#getOperateurBinaire_Kind()
	 * @model required="true"
	 * @generated
	 */
	OperateurBinaireType getKind();

	/**
	 * Sets the value of the '{@link tableur.OperateurBinaire#getKind <em>Kind</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Kind</em>' attribute.
	 * @see tableur.OperateurBinaireType
	 * @see #getKind()
	 * @generated
	 */
	void setKind(OperateurBinaireType value);

} // OperateurBinaire
