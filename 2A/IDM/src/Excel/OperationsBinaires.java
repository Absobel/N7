/**
 */
package Excel;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Operations Binaires</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link Excel.OperationsBinaires#getData <em>Data</em>}</li>
 * </ul>
 *
 * @see Excel.ExcelPackage#getOperationsBinaires()
 * @model
 * @generated
 */
public interface OperationsBinaires extends Operations {
	/**
	 * Returns the value of the '<em><b>Data</b></em>' reference list.
	 * The list contents are of type {@link Excel.Data}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Data</em>' reference list.
	 * @see Excel.ExcelPackage#getOperationsBinaires_Data()
	 * @model lower="2" upper="2"
	 * @generated
	 */
	EList<Data> getData();

} // OperationsBinaires
