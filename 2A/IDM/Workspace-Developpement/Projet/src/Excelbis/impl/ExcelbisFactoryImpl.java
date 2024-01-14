/**
 */
package Excelbis.impl;

import Excelbis.*;

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
public class ExcelbisFactoryImpl extends EFactoryImpl implements ExcelbisFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static ExcelbisFactory init() {
		try {
			ExcelbisFactory theExcelbisFactory = (ExcelbisFactory)EPackage.Registry.INSTANCE.getEFactory(ExcelbisPackage.eNS_URI);
			if (theExcelbisFactory != null) {
				return theExcelbisFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new ExcelbisFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ExcelbisFactoryImpl() {
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
			case ExcelbisPackage.EXCEL: return createExcel();
			case ExcelbisPackage.TABLE: return createTable();
			case ExcelbisPackage.COLONNE_OUTPUT: return createColonneOutput();
			case ExcelbisPackage.COLONNE_INPUT: return createColonneInput();
			case ExcelbisPackage.DATA: return createData();
			case ExcelbisPackage.OPERATIONS_UNAIRES: return createOperationsUnaires();
			case ExcelbisPackage.OPERATIONS_BINAIRES: return createOperationsBinaires();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Excel createExcel() {
		ExcelImpl excel = new ExcelImpl();
		return excel;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Table createTable() {
		TableImpl table = new TableImpl();
		return table;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public ColonneOutput createColonneOutput() {
		ColonneOutputImpl colonneOutput = new ColonneOutputImpl();
		return colonneOutput;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public ColonneInput createColonneInput() {
		ColonneInputImpl colonneInput = new ColonneInputImpl();
		return colonneInput;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Data createData() {
		DataImpl data = new DataImpl();
		return data;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public OperationsUnaires createOperationsUnaires() {
		OperationsUnairesImpl operationsUnaires = new OperationsUnairesImpl();
		return operationsUnaires;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public OperationsBinaires createOperationsBinaires() {
		OperationsBinairesImpl operationsBinaires = new OperationsBinairesImpl();
		return operationsBinaires;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public ExcelbisPackage getExcelbisPackage() {
		return (ExcelbisPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static ExcelbisPackage getPackage() {
		return ExcelbisPackage.eINSTANCE;
	}

} //ExcelbisFactoryImpl
