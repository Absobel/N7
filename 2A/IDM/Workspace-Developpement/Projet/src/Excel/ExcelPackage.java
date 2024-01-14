/**
 */
package excel;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each operation of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see excel.ExcelFactory
 * @model kind="package"
 * @generated
 */
public interface ExcelPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "excel";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "https://excel.ecore";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "excel.ecore";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	ExcelPackage eINSTANCE = excel.impl.ExcelPackageImpl.init();

	/**
	 * The meta object id for the '{@link excel.impl.ExcelImpl <em>Excel</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see excel.impl.ExcelImpl
	 * @see excel.impl.ExcelPackageImpl#getExcel()
	 * @generated
	 */
	int EXCEL = 0;

	/**
	 * The feature id for the '<em><b>Table</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXCEL__TABLE = 0;

	/**
	 * The number of structural features of the '<em>Excel</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXCEL_FEATURE_COUNT = 1;

	/**
	 * The number of operations of the '<em>Excel</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXCEL_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link excel.impl.DataImpl <em>Data</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see excel.impl.DataImpl
	 * @see excel.impl.ExcelPackageImpl#getData()
	 * @generated
	 */
	int DATA = 6;

	/**
	 * The number of structural features of the '<em>Data</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_FEATURE_COUNT = 0;

	/**
	 * The number of operations of the '<em>Data</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link excel.impl.ColonneImpl <em>Colonne</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see excel.impl.ColonneImpl
	 * @see excel.impl.ExcelPackageImpl#getColonne()
	 * @generated
	 */
	int COLONNE = 1;

	/**
	 * The number of structural features of the '<em>Colonne</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLONNE_FEATURE_COUNT = DATA_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Colonne</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLONNE_OPERATION_COUNT = DATA_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link excel.impl.TableImpl <em>Table</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see excel.impl.TableImpl
	 * @see excel.impl.ExcelPackageImpl#getTable()
	 * @generated
	 */
	int TABLE = 2;

	/**
	 * The feature id for the '<em><b>Colonne</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TABLE__COLONNE = 0;

	/**
	 * The number of structural features of the '<em>Table</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TABLE_FEATURE_COUNT = 1;

	/**
	 * The number of operations of the '<em>Table</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TABLE_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link excel.impl.ColonneInputImpl <em>Colonne Input</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see excel.impl.ColonneInputImpl
	 * @see excel.impl.ExcelPackageImpl#getColonneInput()
	 * @generated
	 */
	int COLONNE_INPUT = 3;

	/**
	 * The number of structural features of the '<em>Colonne Input</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLONNE_INPUT_FEATURE_COUNT = COLONNE_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Colonne Input</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLONNE_INPUT_OPERATION_COUNT = COLONNE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link excel.impl.ColonneOutputImpl <em>Colonne Output</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see excel.impl.ColonneOutputImpl
	 * @see excel.impl.ExcelPackageImpl#getColonneOutput()
	 * @generated
	 */
	int COLONNE_OUTPUT = 4;

	/**
	 * The feature id for the '<em><b>Operation</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLONNE_OUTPUT__OPERATION = COLONNE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Colonne Output</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLONNE_OUTPUT_FEATURE_COUNT = COLONNE_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Colonne Output</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLONNE_OUTPUT_OPERATION_COUNT = COLONNE_OPERATION_COUNT + 0;


	/**
	 * The meta object id for the '{@link excel.impl.OperationsImpl <em>Operations</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see excel.impl.OperationsImpl
	 * @see excel.impl.ExcelPackageImpl#getOperations()
	 * @generated
	 */
	int OPERATIONS = 5;

	/**
	 * The number of structural features of the '<em>Operations</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATIONS_FEATURE_COUNT = DATA_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Operations</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATIONS_OPERATION_COUNT = DATA_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link excel.impl.OperationsBinairesImpl <em>Operations Binaires</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see excel.impl.OperationsBinairesImpl
	 * @see excel.impl.ExcelPackageImpl#getOperationsBinaires()
	 * @generated
	 */
	int OPERATIONS_BINAIRES = 7;

	/**
	 * The feature id for the '<em><b>Data</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATIONS_BINAIRES__DATA = OPERATIONS_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Operations Binaires</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATIONS_BINAIRES_FEATURE_COUNT = OPERATIONS_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Operations Binaires</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATIONS_BINAIRES_OPERATION_COUNT = OPERATIONS_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link excel.impl.OperationsUnairesImpl <em>Operations Unaires</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see excel.impl.OperationsUnairesImpl
	 * @see excel.impl.ExcelPackageImpl#getOperationsUnaires()
	 * @generated
	 */
	int OPERATIONS_UNAIRES = 8;

	/**
	 * The feature id for the '<em><b>Data</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATIONS_UNAIRES__DATA = OPERATIONS_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Operations Unaires</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATIONS_UNAIRES_FEATURE_COUNT = OPERATIONS_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Operations Unaires</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATIONS_UNAIRES_OPERATION_COUNT = OPERATIONS_OPERATION_COUNT + 0;


	/**
	 * Returns the meta object for class '{@link excel.Excel <em>Excel</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Excel</em>'.
	 * @see excel.Excel
	 * @generated
	 */
	EClass getExcel();

	/**
	 * Returns the meta object for the containment reference list '{@link excel.Excel#getTable <em>Table</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Table</em>'.
	 * @see excel.Excel#getTable()
	 * @see #getExcel()
	 * @generated
	 */
	EReference getExcel_Table();

	/**
	 * Returns the meta object for class '{@link excel.Colonne <em>Colonne</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Colonne</em>'.
	 * @see excel.Colonne
	 * @generated
	 */
	EClass getColonne();

	/**
	 * Returns the meta object for class '{@link excel.Table <em>Table</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Table</em>'.
	 * @see excel.Table
	 * @generated
	 */
	EClass getTable();

	/**
	 * Returns the meta object for the containment reference list '{@link excel.Table#getColonne <em>Colonne</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Colonne</em>'.
	 * @see excel.Table#getColonne()
	 * @see #getTable()
	 * @generated
	 */
	EReference getTable_Colonne();

	/**
	 * Returns the meta object for class '{@link excel.ColonneInput <em>Colonne Input</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Colonne Input</em>'.
	 * @see excel.ColonneInput
	 * @generated
	 */
	EClass getColonneInput();

	/**
	 * Returns the meta object for class '{@link excel.ColonneOutput <em>Colonne Output</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Colonne Output</em>'.
	 * @see excel.ColonneOutput
	 * @generated
	 */
	EClass getColonneOutput();

	/**
	 * Returns the meta object for the containment reference '{@link excel.ColonneOutput#getOperation <em>Operation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Operation</em>'.
	 * @see excel.ColonneOutput#getOperation()
	 * @see #getColonneOutput()
	 * @generated
	 */
	EReference getColonneOutput_Operation();

	/**
	 * Returns the meta object for class '{@link excel.Operations <em>Operations</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Operations</em>'.
	 * @see excel.Operations
	 * @generated
	 */
	EClass getOperations();

	/**
	 * Returns the meta object for class '{@link excel.Data <em>Data</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Data</em>'.
	 * @see excel.Data
	 * @generated
	 */
	EClass getData();

	/**
	 * Returns the meta object for class '{@link excel.OperationsBinaires <em>Operations Binaires</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Operations Binaires</em>'.
	 * @see excel.OperationsBinaires
	 * @generated
	 */
	EClass getOperationsBinaires();

	/**
	 * Returns the meta object for the reference list '{@link excel.OperationsBinaires#getData <em>Data</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Data</em>'.
	 * @see excel.OperationsBinaires#getData()
	 * @see #getOperationsBinaires()
	 * @generated
	 */
	EReference getOperationsBinaires_Data();

	/**
	 * Returns the meta object for class '{@link excel.OperationsUnaires <em>Operations Unaires</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Operations Unaires</em>'.
	 * @see excel.OperationsUnaires
	 * @generated
	 */
	EClass getOperationsUnaires();

	/**
	 * Returns the meta object for the reference '{@link excel.OperationsUnaires#getData <em>Data</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Data</em>'.
	 * @see excel.OperationsUnaires#getData()
	 * @see #getOperationsUnaires()
	 * @generated
	 */
	EReference getOperationsUnaires_Data();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	ExcelFactory getExcelFactory();

	/**
	 * <!-- begin-user-doc -->
	 * Defines literals for the meta objects that represent
	 * <ul>
	 *   <li>each class,</li>
	 *   <li>each feature of each class,</li>
	 *   <li>each operation of each class,</li>
	 *   <li>each enum,</li>
	 *   <li>and each data type</li>
	 * </ul>
	 * <!-- end-user-doc -->
	 * @generated
	 */
	interface Literals {
		/**
		 * The meta object literal for the '{@link excel.impl.ExcelImpl <em>Excel</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see excel.impl.ExcelImpl
		 * @see excel.impl.ExcelPackageImpl#getExcel()
		 * @generated
		 */
		EClass EXCEL = eINSTANCE.getExcel();

		/**
		 * The meta object literal for the '<em><b>Table</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference EXCEL__TABLE = eINSTANCE.getExcel_Table();

		/**
		 * The meta object literal for the '{@link excel.impl.ColonneImpl <em>Colonne</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see excel.impl.ColonneImpl
		 * @see excel.impl.ExcelPackageImpl#getColonne()
		 * @generated
		 */
		EClass COLONNE = eINSTANCE.getColonne();

		/**
		 * The meta object literal for the '{@link excel.impl.TableImpl <em>Table</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see excel.impl.TableImpl
		 * @see excel.impl.ExcelPackageImpl#getTable()
		 * @generated
		 */
		EClass TABLE = eINSTANCE.getTable();

		/**
		 * The meta object literal for the '<em><b>Colonne</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TABLE__COLONNE = eINSTANCE.getTable_Colonne();

		/**
		 * The meta object literal for the '{@link excel.impl.ColonneInputImpl <em>Colonne Input</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see excel.impl.ColonneInputImpl
		 * @see excel.impl.ExcelPackageImpl#getColonneInput()
		 * @generated
		 */
		EClass COLONNE_INPUT = eINSTANCE.getColonneInput();

		/**
		 * The meta object literal for the '{@link excel.impl.ColonneOutputImpl <em>Colonne Output</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see excel.impl.ColonneOutputImpl
		 * @see excel.impl.ExcelPackageImpl#getColonneOutput()
		 * @generated
		 */
		EClass COLONNE_OUTPUT = eINSTANCE.getColonneOutput();

		/**
		 * The meta object literal for the '<em><b>Operation</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference COLONNE_OUTPUT__OPERATION = eINSTANCE.getColonneOutput_Operation();

		/**
		 * The meta object literal for the '{@link excel.impl.OperationsImpl <em>Operations</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see excel.impl.OperationsImpl
		 * @see excel.impl.ExcelPackageImpl#getOperations()
		 * @generated
		 */
		EClass OPERATIONS = eINSTANCE.getOperations();

		/**
		 * The meta object literal for the '{@link excel.impl.DataImpl <em>Data</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see excel.impl.DataImpl
		 * @see excel.impl.ExcelPackageImpl#getData()
		 * @generated
		 */
		EClass DATA = eINSTANCE.getData();

		/**
		 * The meta object literal for the '{@link excel.impl.OperationsBinairesImpl <em>Operations Binaires</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see excel.impl.OperationsBinairesImpl
		 * @see excel.impl.ExcelPackageImpl#getOperationsBinaires()
		 * @generated
		 */
		EClass OPERATIONS_BINAIRES = eINSTANCE.getOperationsBinaires();

		/**
		 * The meta object literal for the '<em><b>Data</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference OPERATIONS_BINAIRES__DATA = eINSTANCE.getOperationsBinaires_Data();

		/**
		 * The meta object literal for the '{@link excel.impl.OperationsUnairesImpl <em>Operations Unaires</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see excel.impl.OperationsUnairesImpl
		 * @see excel.impl.ExcelPackageImpl#getOperationsUnaires()
		 * @generated
		 */
		EClass OPERATIONS_UNAIRES = eINSTANCE.getOperationsUnaires();

		/**
		 * The meta object literal for the '<em><b>Data</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference OPERATIONS_UNAIRES__DATA = eINSTANCE.getOperationsUnaires_Data();

	}

} //ExcelPackage
