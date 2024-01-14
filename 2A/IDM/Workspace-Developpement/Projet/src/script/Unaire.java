/**
 */
package script;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Unaire</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link script.Unaire#getFonctions <em>Fonctions</em>}</li>
 * </ul>
 *
 * @see script.ScriptPackage#getUnaire()
 * @model
 * @generated
 */
public interface Unaire extends Operations {
	/**
	 * Returns the value of the '<em><b>Fonctions</b></em>' attribute.
	 * The literals are from the enumeration {@link script.Fonctions}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Fonctions</em>' attribute.
	 * @see script.Fonctions
	 * @see #setFonctions(Fonctions)
	 * @see script.ScriptPackage#getUnaire_Fonctions()
	 * @model required="true"
	 * @generated
	 */
	Fonctions getFonctions();

	/**
	 * Sets the value of the '{@link script.Unaire#getFonctions <em>Fonctions</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Fonctions</em>' attribute.
	 * @see script.Fonctions
	 * @see #getFonctions()
	 * @generated
	 */
	void setFonctions(Fonctions value);

} // Unaire
