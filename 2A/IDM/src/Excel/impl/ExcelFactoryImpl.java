/**
 */
package Excel.impl;

import Excel.*;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class ExcelFactoryImpl extends EFactoryImpl implements ExcelFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static ExcelFactory init() {
		try {
			ExcelFactory theExcelFactory = (ExcelFactory)EPackage.Registry.INSTANCE.getEFactory(ExcelPackage.eNS_URI);
			if (theExcelFactory != null) {
				return theExcelFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new ExcelFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ExcelFactoryImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EObject create(EClass eClass) {
		switch (eClass.getClassifierID()) {
			case ExcelPackage.TABLE: return createTable();
			case ExcelPackage.EXCEL: return createExcel();
			case ExcelPackage.COLONNE_INPUT: return createColonneInput();
			case ExcelPackage.COLONNE_OUTPUT: return createColonneOutput();
			case ExcelPackage.OPERATIONS: return createOperations();
			case ExcelPackage.DATA: return createData();
			case ExcelPackage.OPERATIONS_BINAIRES: return createOperationsBinaires();
			case ExcelPackage.OPERATIONS_UNAIRES: return createOperationsUnaires();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Table createTable() {
		TableImpl table = new TableImpl();
		return table;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Excel createExcel() {
		ExcelImpl excel = new ExcelImpl();
		return excel;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ColonneInput createColonneInput() {
		ColonneInputImpl colonneInput = new ColonneInputImpl();
		return colonneInput;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ColonneOutput createColonneOutput() {
		ColonneOutputImpl colonneOutput = new ColonneOutputImpl();
		return colonneOutput;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Operations createOperations() {
		OperationsImpl operations = new OperationsImpl();
		return operations;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Data createData() {
		DataImpl data = new DataImpl();
		return data;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public OperationsBinaires createOperationsBinaires() {
		OperationsBinairesImpl operationsBinaires = new OperationsBinairesImpl();
		return operationsBinaires;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public OperationsUnaires createOperationsUnaires() {
		OperationsUnairesImpl operationsUnaires = new OperationsUnairesImpl();
		return operationsUnaires;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ExcelPackage getExcelPackage() {
		return (ExcelPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static ExcelPackage getPackage() {
		return ExcelPackage.eINSTANCE;
	}

} //ExcelFactoryImpl
