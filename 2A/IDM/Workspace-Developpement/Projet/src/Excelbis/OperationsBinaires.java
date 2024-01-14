/**
 */
package Excelbis;

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
 *   <li>{@link Excelbis.OperationsBinaires#getDatas <em>Datas</em>}</li>
 * </ul>
 *
 * @see Excelbis.ExcelbisPackage#getOperationsBinaires()
 * @model
 * @generated
 */
public interface OperationsBinaires extends Operations {
	/**
	 * Returns the value of the '<em><b>Datas</b></em>' reference list.
	 * The list contents are of type {@link Excelbis.Data}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Datas</em>' reference list.
	 * @see Excelbis.ExcelbisPackage#getOperationsBinaires_Datas()
	 * @model lower="2" upper="2"
	 * @generated
	 */
	EList<Data> getDatas();

} // OperationsBinaires
