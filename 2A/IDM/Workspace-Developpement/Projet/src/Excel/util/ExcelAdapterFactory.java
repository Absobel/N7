/**
 */
package excel.util;

import excel.*;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;

import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * The <b>Adapter Factory</b> for the model.
 * It provides an adapter <code>createXXX</code> method for each class of the model.
 * <!-- end-user-doc -->
 * @see excel.ExcelPackage
 * @generated
 */
public class ExcelAdapterFactory extends AdapterFactoryImpl {
	/**
	 * The cached model package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static ExcelPackage modelPackage;

	/**
	 * Creates an instance of the adapter factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ExcelAdapterFactory() {
		if (modelPackage == null) {
			modelPackage = ExcelPackage.eINSTANCE;
		}
	}

	/**
	 * Returns whether this factory is applicable for the type of the object.
	 * <!-- begin-user-doc -->
	 * This implementation returns <code>true</code> if the object is either the model's package or is an instance object of the model.
	 * <!-- end-user-doc -->
	 * @return whether this factory is applicable for the type of the object.
	 * @generated
	 */
	@Override
	public boolean isFactoryForType(Object object) {
		if (object == modelPackage) {
			return true;
		}
		if (object instanceof EObject) {
			return ((EObject)object).eClass().getEPackage() == modelPackage;
		}
		return false;
	}

	/**
	 * The switch that delegates to the <code>createXXX</code> methods.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ExcelSwitch<Adapter> modelSwitch =
		new ExcelSwitch<Adapter>() {
			@Override
			public Adapter caseExcel(Excel object) {
				return createExcelAdapter();
			}
			@Override
			public Adapter caseColonne(Colonne object) {
				return createColonneAdapter();
			}
			@Override
			public Adapter caseTable(Table object) {
				return createTableAdapter();
			}
			@Override
			public Adapter caseColonneInput(ColonneInput object) {
				return createColonneInputAdapter();
			}
			@Override
			public Adapter caseColonneOutput(ColonneOutput object) {
				return createColonneOutputAdapter();
			}
			@Override
			public Adapter caseOperations(Operations object) {
				return createOperationsAdapter();
			}
			@Override
			public Adapter caseData(Data object) {
				return createDataAdapter();
			}
			@Override
			public Adapter caseOperationsBinaires(OperationsBinaires object) {
				return createOperationsBinairesAdapter();
			}
			@Override
			public Adapter caseOperationsUnaires(OperationsUnaires object) {
				return createOperationsUnairesAdapter();
			}
			@Override
			public Adapter defaultCase(EObject object) {
				return createEObjectAdapter();
			}
		};

	/**
	 * Creates an adapter for the <code>target</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param target the object to adapt.
	 * @return the adapter for the <code>target</code>.
	 * @generated
	 */
	@Override
	public Adapter createAdapter(Notifier target) {
		return modelSwitch.doSwitch((EObject)target);
	}


	/**
	 * Creates a new adapter for an object of class '{@link excel.Excel <em>Excel</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see excel.Excel
	 * @generated
	 */
	public Adapter createExcelAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link excel.Colonne <em>Colonne</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see excel.Colonne
	 * @generated
	 */
	public Adapter createColonneAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link excel.Table <em>Table</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see excel.Table
	 * @generated
	 */
	public Adapter createTableAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link excel.ColonneInput <em>Colonne Input</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see excel.ColonneInput
	 * @generated
	 */
	public Adapter createColonneInputAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link excel.ColonneOutput <em>Colonne Output</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see excel.ColonneOutput
	 * @generated
	 */
	public Adapter createColonneOutputAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link excel.Operations <em>Operations</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see excel.Operations
	 * @generated
	 */
	public Adapter createOperationsAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link excel.Data <em>Data</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see excel.Data
	 * @generated
	 */
	public Adapter createDataAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link excel.OperationsBinaires <em>Operations Binaires</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see excel.OperationsBinaires
	 * @generated
	 */
	public Adapter createOperationsBinairesAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link excel.OperationsUnaires <em>Operations Unaires</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see excel.OperationsUnaires
	 * @generated
	 */
	public Adapter createOperationsUnairesAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for the default case.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @generated
	 */
	public Adapter createEObjectAdapter() {
		return null;
	}

} //ExcelAdapterFactory
