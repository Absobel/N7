/**
 */
package tableur;

import algorithme.Catalogue;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

import script.Script;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Tableur</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link tableur.Tableur#getName <em>Name</em>}</li>
 *   <li>{@link tableur.Tableur#getTable <em>Table</em>}</li>
 *   <li>{@link tableur.Tableur#getCatalogues <em>Catalogues</em>}</li>
 *   <li>{@link tableur.Tableur#getScripts <em>Scripts</em>}</li>
 * </ul>
 *
 * @see tableur.TableurPackage#getTableur()
 * @model
 * @generated
 */
public interface Tableur extends EObject {
	/**
	 * Returns the value of the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Name</em>' attribute.
	 * @see #setName(String)
	 * @see tableur.TableurPackage#getTableur_Name()
	 * @model
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link tableur.Tableur#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

	/**
	 * Returns the value of the '<em><b>Table</b></em>' containment reference list.
	 * The list contents are of type {@link tableur.Table}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Table</em>' containment reference list.
	 * @see tableur.TableurPackage#getTableur_Table()
	 * @model containment="true"
	 * @generated
	 */
	EList<Table> getTable();

	/**
	 * Returns the value of the '<em><b>Catalogues</b></em>' containment reference list.
	 * The list contents are of type {@link algorithme.Catalogue}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Catalogues</em>' containment reference list.
	 * @see tableur.TableurPackage#getTableur_Catalogues()
	 * @model containment="true"
	 * @generated
	 */
	EList<Catalogue> getCatalogues();

	/**
	 * Returns the value of the '<em><b>Scripts</b></em>' containment reference list.
	 * The list contents are of type {@link script.Script}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Scripts</em>' containment reference list.
	 * @see tableur.TableurPackage#getTableur_Scripts()
	 * @model containment="true"
	 * @generated
	 */
	EList<Script> getScripts();

} // Tableur
