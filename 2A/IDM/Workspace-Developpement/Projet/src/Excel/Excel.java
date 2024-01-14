/**
 */
package Excel;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Excel</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link Excel.Excel#getTable <em>Table</em>}</li>
 * </ul>
 *
 * @see Excel.ExcelPackage#getExcel()
 * @model
 * @generated
 */
public interface Excel extends EObject {
	/**
	 * Returns the value of the '<em><b>Table</b></em>' containment reference list.
	 * The list contents are of type {@link Excel.Table}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Table</em>' containment reference list.
	 * @see Excel.ExcelPackage#getExcel_Table()
	 * @model containment="true" required="true"
	 * @generated
	 */
	EList<Table> getTable();

} // Excel
