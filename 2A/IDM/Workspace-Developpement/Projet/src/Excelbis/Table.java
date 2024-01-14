/**
 */
package Excelbis;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Table</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link Excelbis.Table#getColonne <em>Colonne</em>}</li>
 * </ul>
 *
 * @see Excelbis.ExcelbisPackage#getTable()
 * @model
 * @generated
 */
public interface Table extends Data {

	/**
	 * Returns the value of the '<em><b>Colonne</b></em>' containment reference list.
	 * The list contents are of type {@link Excelbis.Colonne}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Colonne</em>' containment reference list.
	 * @see Excelbis.ExcelbisPackage#getTable_Colonne()
	 * @model containment="true" required="true"
	 * @generated
	 */
	EList<Colonne> getColonne();
} // Table
