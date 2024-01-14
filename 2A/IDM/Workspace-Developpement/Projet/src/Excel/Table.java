/**
 */
package excel;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Table</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link excel.Table#getColonne <em>Colonne</em>}</li>
 * </ul>
 *
 * @see excel.ExcelPackage#getTable()
 * @model
 * @generated
 */
public interface Table extends EObject {
	/**
	 * Returns the value of the '<em><b>Colonne</b></em>' containment reference list.
	 * The list contents are of type {@link excel.Colonne}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Colonne</em>' containment reference list.
	 * @see excel.ExcelPackage#getTable_Colonne()
	 * @model containment="true" required="true"
	 * @generated
	 */
	EList<Colonne> getColonne();

} // Table
