/**
 */
package Excelbis;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see Excelbis.ExcelbisPackage
 * @generated
 */
public interface ExcelbisFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	ExcelbisFactory eINSTANCE = Excelbis.impl.ExcelbisFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>Excel</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Excel</em>'.
	 * @generated
	 */
	Excel createExcel();

	/**
	 * Returns a new object of class '<em>Table</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Table</em>'.
	 * @generated
	 */
	Table createTable();

	/**
	 * Returns a new object of class '<em>Colonne Output</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Colonne Output</em>'.
	 * @generated
	 */
	ColonneOutput createColonneOutput();

	/**
	 * Returns a new object of class '<em>Colonne Input</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Colonne Input</em>'.
	 * @generated
	 */
	ColonneInput createColonneInput();

	/**
	 * Returns a new object of class '<em>Data</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Data</em>'.
	 * @generated
	 */
	Data createData();

	/**
	 * Returns a new object of class '<em>Operations Unaires</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Operations Unaires</em>'.
	 * @generated
	 */
	OperationsUnaires createOperationsUnaires();

	/**
	 * Returns a new object of class '<em>Operations Binaires</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Operations Binaires</em>'.
	 * @generated
	 */
	OperationsBinaires createOperationsBinaires();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	ExcelbisPackage getExcelbisPackage();

} //ExcelbisFactory
