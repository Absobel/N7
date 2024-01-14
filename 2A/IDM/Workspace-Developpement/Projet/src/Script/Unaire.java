/**
 */
package Script;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Unaire</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link Script.Unaire#getFonctions <em>Fonctions</em>}</li>
 * </ul>
 *
 * @see Script.ScriptPackage#getUnaire()
 * @model
 * @generated
 */
public interface Unaire extends Operations {
	/**
	 * Returns the value of the '<em><b>Fonctions</b></em>' attribute.
	 * The literals are from the enumeration {@link Script.FonctionsType}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Fonctions</em>' attribute.
	 * @see Script.FonctionsType
	 * @see #setFonctions(FonctionsType)
	 * @see Script.ScriptPackage#getUnaire_Fonctions()
	 * @model required="true"
	 * @generated
	 */
	FonctionsType getFonctions();

	/**
	 * Sets the value of the '{@link Script.Unaire#getFonctions <em>Fonctions</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Fonctions</em>' attribute.
	 * @see Script.FonctionsType
	 * @see #getFonctions()
	 * @generated
	 */
	void setFonctions(FonctionsType value);

} // Unaire
