/**
 */
package Excelbis;

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
 * @see Excelbis.ExcelbisFactory
 * @model kind="package"
 * @generated
 */
public interface ExcelbisPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "Excelbis";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "https://Excelbis.ecore";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "Excelbis.ecore";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	ExcelbisPackage eINSTANCE = Excelbis.impl.ExcelbisPackageImpl.init();

	/**
	 * The meta object id for the '{@link Excelbis.impl.ExcelImpl <em>Excel</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see Excelbis.impl.ExcelImpl
	 * @see Excelbis.impl.ExcelbisPackageImpl#getExcel()
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
	 * The meta object id for the '{@link Excelbis.impl.DataImpl <em>Data</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see Excelbis.impl.DataImpl
	 * @see Excelbis.impl.ExcelbisPackageImpl#getData()
	 * @generated
	 */
	int DATA = 5;

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
	 * The meta object id for the '{@link Excelbis.impl.TableImpl <em>Table</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see Excelbis.impl.TableImpl
	 * @see Excelbis.impl.ExcelbisPackageImpl#getTable()
	 * @generated
	 */
	int TABLE = 1;

	/**
	 * The feature id for the '<em><b>Colonne</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TABLE__COLONNE = DATA_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Table</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TABLE_FEATURE_COUNT = DATA_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Table</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TABLE_OPERATION_COUNT = DATA_OPERATION_COUNT + 0;


	/**
	 * The meta object id for the '{@link Excelbis.impl.ColonneImpl <em>Colonne</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see Excelbis.impl.ColonneImpl
	 * @see Excelbis.impl.ExcelbisPackageImpl#getColonne()
	 * @generated
	 */
	int COLONNE = 4;

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
	 * The meta object id for the '{@link Excelbis.impl.ColonneOutputImpl <em>Colonne Output</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see Excelbis.impl.ColonneOutputImpl
	 * @see Excelbis.impl.ExcelbisPackageImpl#getColonneOutput()
	 * @generated
	 */
	int COLONNE_OUTPUT = 2;

	/**
	 * The feature id for the '<em><b>Operations</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLONNE_OUTPUT__OPERATIONS = COLONNE_FEATURE_COUNT + 0;

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
	 * The meta object id for the '{@link Excelbis.impl.ColonneInputImpl <em>Colonne Input</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see Excelbis.impl.ColonneInputImpl
	 * @see Excelbis.impl.ExcelbisPackageImpl#getColonneInput()
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
	 * The meta object id for the '{@link Excelbis.impl.OperationsImpl <em>Operations</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see Excelbis.impl.OperationsImpl
	 * @see Excelbis.impl.ExcelbisPackageImpl#getOperations()
	 * @generated
	 */
	int OPERATIONS = 6;

	/**
	 * The number of structural features of the '<em>Operations</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATIONS_FEATURE_COUNT = 0;

	/**
	 * The number of operations of the '<em>Operations</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATIONS_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link Excelbis.impl.OperationsUnairesImpl <em>Operations Unaires</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see Excelbis.impl.OperationsUnairesImpl
	 * @see Excelbis.impl.ExcelbisPackageImpl#getOperationsUnaires()
	 * @generated
	 */
	int OPERATIONS_UNAIRES = 7;

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
	 * The meta object id for the '{@link Excelbis.impl.OperationsBinairesImpl <em>Operations Binaires</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see Excelbis.impl.OperationsBinairesImpl
	 * @see Excelbis.impl.ExcelbisPackageImpl#getOperationsBinaires()
	 * @generated
	 */
	int OPERATIONS_BINAIRES = 8;

	/**
	 * The feature id for the '<em><b>Datas</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATIONS_BINAIRES__DATAS = OPERATIONS_FEATURE_COUNT + 0;

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
	 * Returns the meta object for class '{@link Excelbis.Excel <em>Excel</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Excel</em>'.
	 * @see Excelbis.Excel
	 * @generated
	 */
	EClass getExcel();

	/**
	 * Returns the meta object for the containment reference list '{@link Excelbis.Excel#getTable <em>Table</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Table</em>'.
	 * @see Excelbis.Excel#getTable()
	 * @see #getExcel()
	 * @generated
	 */
	EReference getExcel_Table();

	/**
	 * Returns the meta object for class '{@link Excelbis.Table <em>Table</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Table</em>'.
	 * @see Excelbis.Table
	 * @generated
	 */
	EClass getTable();

	/**
	 * Returns the meta object for the containment reference list '{@link Excelbis.Table#getColonne <em>Colonne</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Colonne</em>'.
	 * @see Excelbis.Table#getColonne()
	 * @see #getTable()
	 * @generated
	 */
	EReference getTable_Colonne();

	/**
	 * Returns the meta object for class '{@link Excelbis.ColonneOutput <em>Colonne Output</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Colonne Output</em>'.
	 * @see Excelbis.ColonneOutput
	 * @generated
	 */
	EClass getColonneOutput();

	/**
	 * Returns the meta object for the containment reference '{@link Excelbis.ColonneOutput#getOperations <em>Operations</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Operations</em>'.
	 * @see Excelbis.ColonneOutput#getOperations()
	 * @see #getColonneOutput()
	 * @generated
	 */
	EReference getColonneOutput_Operations();

	/**
	 * Returns the meta object for class '{@link Excelbis.ColonneInput <em>Colonne Input</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Colonne Input</em>'.
	 * @see Excelbis.ColonneInput
	 * @generated
	 */
	EClass getColonneInput();

	/**
	 * Returns the meta object for class '{@link Excelbis.Colonne <em>Colonne</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Colonne</em>'.
	 * @see Excelbis.Colonne
	 * @generated
	 */
	EClass getColonne();

	/**
	 * Returns the meta object for class '{@link Excelbis.Data <em>Data</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Data</em>'.
	 * @see Excelbis.Data
	 * @generated
	 */
	EClass getData();

	/**
	 * Returns the meta object for class '{@link Excelbis.Operations <em>Operations</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Operations</em>'.
	 * @see Excelbis.Operations
	 * @generated
	 */
	EClass getOperations();

	/**
	 * Returns the meta object for class '{@link Excelbis.OperationsUnaires <em>Operations Unaires</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Operations Unaires</em>'.
	 * @see Excelbis.OperationsUnaires
	 * @generated
	 */
	EClass getOperationsUnaires();

	/**
	 * Returns the meta object for the reference '{@link Excelbis.OperationsUnaires#getData <em>Data</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Data</em>'.
	 * @see Excelbis.OperationsUnaires#getData()
	 * @see #getOperationsUnaires()
	 * @generated
	 */
	EReference getOperationsUnaires_Data();

	/**
	 * Returns the meta object for class '{@link Excelbis.OperationsBinaires <em>Operations Binaires</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Operations Binaires</em>'.
	 * @see Excelbis.OperationsBinaires
	 * @generated
	 */
	EClass getOperationsBinaires();

	/**
	 * Returns the meta object for the reference list '{@link Excelbis.OperationsBinaires#getDatas <em>Datas</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Datas</em>'.
	 * @see Excelbis.OperationsBinaires#getDatas()
	 * @see #getOperationsBinaires()
	 * @generated
	 */
	EReference getOperationsBinaires_Datas();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	ExcelbisFactory getExcelbisFactory();

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
		 * The meta object literal for the '{@link Excelbis.impl.ExcelImpl <em>Excel</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see Excelbis.impl.ExcelImpl
		 * @see Excelbis.impl.ExcelbisPackageImpl#getExcel()
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
		 * The meta object literal for the '{@link Excelbis.impl.TableImpl <em>Table</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see Excelbis.impl.TableImpl
		 * @see Excelbis.impl.ExcelbisPackageImpl#getTable()
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
		 * The meta object literal for the '{@link Excelbis.impl.ColonneOutputImpl <em>Colonne Output</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see Excelbis.impl.ColonneOutputImpl
		 * @see Excelbis.impl.ExcelbisPackageImpl#getColonneOutput()
		 * @generated
		 */
		EClass COLONNE_OUTPUT = eINSTANCE.getColonneOutput();
		/**
		 * The meta object literal for the '<em><b>Operations</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference COLONNE_OUTPUT__OPERATIONS = eINSTANCE.getColonneOutput_Operations();
		/**
		 * The meta object literal for the '{@link Excelbis.impl.ColonneInputImpl <em>Colonne Input</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see Excelbis.impl.ColonneInputImpl
		 * @see Excelbis.impl.ExcelbisPackageImpl#getColonneInput()
		 * @generated
		 */
		EClass COLONNE_INPUT = eINSTANCE.getColonneInput();
		/**
		 * The meta object literal for the '{@link Excelbis.impl.ColonneImpl <em>Colonne</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see Excelbis.impl.ColonneImpl
		 * @see Excelbis.impl.ExcelbisPackageImpl#getColonne()
		 * @generated
		 */
		EClass COLONNE = eINSTANCE.getColonne();
		/**
		 * The meta object literal for the '{@link Excelbis.impl.DataImpl <em>Data</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see Excelbis.impl.DataImpl
		 * @see Excelbis.impl.ExcelbisPackageImpl#getData()
		 * @generated
		 */
		EClass DATA = eINSTANCE.getData();
		/**
		 * The meta object literal for the '{@link Excelbis.impl.OperationsImpl <em>Operations</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see Excelbis.impl.OperationsImpl
		 * @see Excelbis.impl.ExcelbisPackageImpl#getOperations()
		 * @generated
		 */
		EClass OPERATIONS = eINSTANCE.getOperations();
		/**
		 * The meta object literal for the '{@link Excelbis.impl.OperationsUnairesImpl <em>Operations Unaires</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see Excelbis.impl.OperationsUnairesImpl
		 * @see Excelbis.impl.ExcelbisPackageImpl#getOperationsUnaires()
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
		/**
		 * The meta object literal for the '{@link Excelbis.impl.OperationsBinairesImpl <em>Operations Binaires</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see Excelbis.impl.OperationsBinairesImpl
		 * @see Excelbis.impl.ExcelbisPackageImpl#getOperationsBinaires()
		 * @generated
		 */
		EClass OPERATIONS_BINAIRES = eINSTANCE.getOperationsBinaires();
		/**
		 * The meta object literal for the '<em><b>Datas</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference OPERATIONS_BINAIRES__DATAS = eINSTANCE.getOperationsBinaires_Datas();

	}

} //ExcelbisPackage
