/**
 */
package Excel;

import Excel.impl.*;
import org.eclipse.emf.ecore.EAttribute;
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
 * @see Excel.ExcelFactory
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
	String eNAME = "Excel";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://www.example.org/Excel";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "Excel";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	ExcelPackage eINSTANCE = ExcelPackageImpl.init();

	/**
	 * The meta object id for the '{@link Excel.impl.TableImpl <em>Table</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see Excel.impl.TableImpl
	 * @see Excel.impl.ExcelPackageImpl#getTable()
	 * @generated
	 */
	int TABLE = 0;

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
	 * The meta object id for the '{@link Excel.impl.ExcelImpl <em>Excel</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see Excel.impl.ExcelImpl
	 * @see Excel.impl.ExcelPackageImpl#getExcel()
	 * @generated
	 */
	int EXCEL = 1;

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
	 * The meta object id for the '{@link Excel.impl.DataImpl <em>Data</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see Excel.impl.DataImpl
	 * @see Excel.impl.ExcelPackageImpl#getData()
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
	 * The meta object id for the '{@link Excel.impl.ColonneImpl <em>Colonne</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see Excel.impl.ColonneImpl
	 * @see Excel.impl.ExcelPackageImpl#getColonne()
	 * @generated
	 */
	int COLONNE = 3;

	/**
	 * The feature id for the '<em><b>Identifiant</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLONNE__IDENTIFIANT = DATA_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Colonne</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLONNE_FEATURE_COUNT = DATA_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Colonne</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLONNE_OPERATION_COUNT = DATA_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link Excel.impl.ColonneInputImpl <em>Colonne Input</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see Excel.impl.ColonneInputImpl
	 * @see Excel.impl.ExcelPackageImpl#getColonneInput()
	 * @generated
	 */
	int COLONNE_INPUT = 2;

	/**
	 * The feature id for the '<em><b>Identifiant</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLONNE_INPUT__IDENTIFIANT = COLONNE__IDENTIFIANT;

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
	 * The meta object id for the '{@link Excel.impl.ColonneOutputImpl <em>Colonne Output</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see Excel.impl.ColonneOutputImpl
	 * @see Excel.impl.ExcelPackageImpl#getColonneOutput()
	 * @generated
	 */
	int COLONNE_OUTPUT = 4;

	/**
	 * The feature id for the '<em><b>Identifiant</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLONNE_OUTPUT__IDENTIFIANT = COLONNE__IDENTIFIANT;

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
	 * The meta object id for the '{@link Excel.impl.OperationsImpl <em>Operations</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see Excel.impl.OperationsImpl
	 * @see Excel.impl.ExcelPackageImpl#getOperations()
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
	 * The meta object id for the '{@link Excel.impl.OperationsBinairesImpl <em>Operations Binaires</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see Excel.impl.OperationsBinairesImpl
	 * @see Excel.impl.ExcelPackageImpl#getOperationsBinaires()
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
	 * The meta object id for the '{@link Excel.impl.OperationsUnairesImpl <em>Operations Unaires</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see Excel.impl.OperationsUnairesImpl
	 * @see Excel.impl.ExcelPackageImpl#getOperationsUnaires()
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
	 * Returns the meta object for class '{@link Excel.Table <em>Table</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Table</em>'.
	 * @see Excel.Table
	 * @generated
	 */
	EClass getTable();

	/**
	 * Returns the meta object for the containment reference list '{@link Excel.Table#getColonne <em>Colonne</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Colonne</em>'.
	 * @see Excel.Table#getColonne()
	 * @see #getTable()
	 * @generated
	 */
	EReference getTable_Colonne();

	/**
	 * Returns the meta object for class '{@link Excel.Excel <em>Excel</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Excel</em>'.
	 * @see Excel.Excel
	 * @generated
	 */
	EClass getExcel();

	/**
	 * Returns the meta object for the containment reference list '{@link Excel.Excel#getTable <em>Table</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Table</em>'.
	 * @see Excel.Excel#getTable()
	 * @see #getExcel()
	 * @generated
	 */
	EReference getExcel_Table();

	/**
	 * Returns the meta object for class '{@link Excel.ColonneInput <em>Colonne Input</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Colonne Input</em>'.
	 * @see Excel.ColonneInput
	 * @generated
	 */
	EClass getColonneInput();

	/**
	 * Returns the meta object for class '{@link Excel.Colonne <em>Colonne</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Colonne</em>'.
	 * @see Excel.Colonne
	 * @generated
	 */
	EClass getColonne();

	/**
	 * Returns the meta object for the attribute '{@link Excel.Colonne#getIdentifiant <em>Identifiant</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Identifiant</em>'.
	 * @see Excel.Colonne#getIdentifiant()
	 * @see #getColonne()
	 * @generated
	 */
	EAttribute getColonne_Identifiant();

	/**
	 * Returns the meta object for class '{@link Excel.ColonneOutput <em>Colonne Output</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Colonne Output</em>'.
	 * @see Excel.ColonneOutput
	 * @generated
	 */
	EClass getColonneOutput();

	/**
	 * Returns the meta object for the containment reference '{@link Excel.ColonneOutput#getOperations <em>Operations</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Operations</em>'.
	 * @see Excel.ColonneOutput#getOperations()
	 * @see #getColonneOutput()
	 * @generated
	 */
	EReference getColonneOutput_Operations();

	/**
	 * Returns the meta object for class '{@link Excel.Operations <em>Operations</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Operations</em>'.
	 * @see Excel.Operations
	 * @generated
	 */
	EClass getOperations();

	/**
	 * Returns the meta object for class '{@link Excel.Data <em>Data</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Data</em>'.
	 * @see Excel.Data
	 * @generated
	 */
	EClass getData();

	/**
	 * Returns the meta object for class '{@link Excel.OperationsBinaires <em>Operations Binaires</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Operations Binaires</em>'.
	 * @see Excel.OperationsBinaires
	 * @generated
	 */
	EClass getOperationsBinaires();

	/**
	 * Returns the meta object for the reference list '{@link Excel.OperationsBinaires#getData <em>Data</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Data</em>'.
	 * @see Excel.OperationsBinaires#getData()
	 * @see #getOperationsBinaires()
	 * @generated
	 */
	EReference getOperationsBinaires_Data();

	/**
	 * Returns the meta object for class '{@link Excel.OperationsUnaires <em>Operations Unaires</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Operations Unaires</em>'.
	 * @see Excel.OperationsUnaires
	 * @generated
	 */
	EClass getOperationsUnaires();

	/**
	 * Returns the meta object for the reference '{@link Excel.OperationsUnaires#getData <em>Data</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Data</em>'.
	 * @see Excel.OperationsUnaires#getData()
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
		 * The meta object literal for the '{@link Excel.impl.TableImpl <em>Table</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see Excel.impl.TableImpl
		 * @see Excel.impl.ExcelPackageImpl#getTable()
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
		 * The meta object literal for the '{@link Excel.impl.ExcelImpl <em>Excel</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see Excel.impl.ExcelImpl
		 * @see Excel.impl.ExcelPackageImpl#getExcel()
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
		 * The meta object literal for the '{@link Excel.impl.ColonneInputImpl <em>Colonne Input</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see Excel.impl.ColonneInputImpl
		 * @see Excel.impl.ExcelPackageImpl#getColonneInput()
		 * @generated
		 */
		EClass COLONNE_INPUT = eINSTANCE.getColonneInput();

		/**
		 * The meta object literal for the '{@link Excel.impl.ColonneImpl <em>Colonne</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see Excel.impl.ColonneImpl
		 * @see Excel.impl.ExcelPackageImpl#getColonne()
		 * @generated
		 */
		EClass COLONNE = eINSTANCE.getColonne();

		/**
		 * The meta object literal for the '<em><b>Identifiant</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute COLONNE__IDENTIFIANT = eINSTANCE.getColonne_Identifiant();

		/**
		 * The meta object literal for the '{@link Excel.impl.ColonneOutputImpl <em>Colonne Output</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see Excel.impl.ColonneOutputImpl
		 * @see Excel.impl.ExcelPackageImpl#getColonneOutput()
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
		 * The meta object literal for the '{@link Excel.impl.OperationsImpl <em>Operations</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see Excel.impl.OperationsImpl
		 * @see Excel.impl.ExcelPackageImpl#getOperations()
		 * @generated
		 */
		EClass OPERATIONS = eINSTANCE.getOperations();

		/**
		 * The meta object literal for the '{@link Excel.impl.DataImpl <em>Data</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see Excel.impl.DataImpl
		 * @see Excel.impl.ExcelPackageImpl#getData()
		 * @generated
		 */
		EClass DATA = eINSTANCE.getData();

		/**
		 * The meta object literal for the '{@link Excel.impl.OperationsBinairesImpl <em>Operations Binaires</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see Excel.impl.OperationsBinairesImpl
		 * @see Excel.impl.ExcelPackageImpl#getOperationsBinaires()
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
		 * The meta object literal for the '{@link Excel.impl.OperationsUnairesImpl <em>Operations Unaires</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see Excel.impl.OperationsUnairesImpl
		 * @see Excel.impl.ExcelPackageImpl#getOperationsUnaires()
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
