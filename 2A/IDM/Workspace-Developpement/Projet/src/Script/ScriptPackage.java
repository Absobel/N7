/**
 */
package Script;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

import Script.impl.ScriptPackageImpl;

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
 * @see Script.ScriptFactory
 * @model kind="package"
 * @generated
 */
public interface ScriptPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "Script";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "https://Script.ecore";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "Script.ecore";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 */
	ScriptPackage eINSTANCE = ScriptPackageImpl.init();

	/**
	 * The meta object id for the '{@link Script.impl.DataImpl <em>Data</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see Script.impl.DataImpl
	 * @see Script.impl.ScriptPackageImpl#getData()
	 * @generated
	 */
	int DATA = 0;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA__NAME = 0;

	/**
	 * The feature id for the '<em><b>Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA__TYPE = 1;

	/**
	 * The number of structural features of the '<em>Data</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_FEATURE_COUNT = 2;

	/**
	 * The number of operations of the '<em>Data</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link Script.impl.ScriptImpl <em>Script</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see Script.impl.ScriptImpl
	 * @see Script.impl.ScriptPackageImpl#getScript()
	 * @generated
	 */
	int SCRIPT = 1;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCRIPT__NAME = 0;

	/**
	 * The feature id for the '<em><b>Blocs</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCRIPT__BLOCS = 1;

	/**
	 * The feature id for the '<em><b>Final Output</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCRIPT__FINAL_OUTPUT = 2;

	/**
	 * The feature id for the '<em><b>Initial Input</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCRIPT__INITIAL_INPUT = 3;

	/**
	 * The number of structural features of the '<em>Script</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCRIPT_FEATURE_COUNT = 4;

	/**
	 * The number of operations of the '<em>Script</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCRIPT_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link Script.impl.BlocsImpl <em>Blocs</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see Script.impl.BlocsImpl
	 * @see Script.impl.ScriptPackageImpl#getBlocs()
	 * @generated
	 */
	int BLOCS = 2;

	/**
	 * The feature id for the '<em><b>Operations</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BLOCS__OPERATIONS = 0;

	/**
	 * The feature id for the '<em><b>Output</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BLOCS__OUTPUT = 1;

	/**
	 * The feature id for the '<em><b>Inputs</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BLOCS__INPUTS = 2;

	/**
	 * The number of structural features of the '<em>Blocs</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BLOCS_FEATURE_COUNT = 3;

	/**
	 * The number of operations of the '<em>Blocs</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BLOCS_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link Script.impl.OperationsImpl <em>Operations</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see Script.impl.OperationsImpl
	 * @see Script.impl.ScriptPackageImpl#getOperations()
	 * @generated
	 */
	int OPERATIONS = 3;

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
	 * The meta object id for the '{@link Script.impl.UnaireImpl <em>Unaire</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see Script.impl.UnaireImpl
	 * @see Script.impl.ScriptPackageImpl#getUnaire()
	 * @generated
	 */
	int UNAIRE = 4;

	/**
	 * The feature id for the '<em><b>Fonctions</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNAIRE__FONCTIONS = OPERATIONS_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Unaire</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNAIRE_FEATURE_COUNT = OPERATIONS_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Unaire</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNAIRE_OPERATION_COUNT = OPERATIONS_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link Script.impl.BinaireImpl <em>Binaire</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see Script.impl.BinaireImpl
	 * @see Script.impl.ScriptPackageImpl#getBinaire()
	 * @generated
	 */
	int BINAIRE = 5;

	/**
	 * The feature id for the '<em><b>Operateur</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BINAIRE__OPERATEUR = OPERATIONS_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Binaire</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BINAIRE_FEATURE_COUNT = OPERATIONS_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Binaire</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BINAIRE_OPERATION_COUNT = OPERATIONS_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link Script.OperationsBinairesType <em>Operations Binaires Type</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see Script.OperationsBinairesType
	 * @see Script.impl.ScriptPackageImpl#getOperationsBinairesType()
	 * @generated
	 */
	int OPERATIONS_BINAIRES_TYPE = 6;

	/**
	 * The meta object id for the '{@link Script.FonctionsType <em>Fonctions Type</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see Script.FonctionsType
	 * @see Script.impl.ScriptPackageImpl#getFonctionsType()
	 * @generated
	 */
	int FONCTIONS_TYPE = 7;


	/**
	 * Returns the meta object for class '{@link Script.Data <em>Data</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Data</em>'.
	 * @see Script.Data
	 * @generated
	 */
	EClass getData();

	/**
	 * Returns the meta object for the attribute '{@link Script.Data#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see Script.Data#getName()
	 * @see #getData()
	 * @generated
	 */
	EAttribute getData_Name();

	/**
	 * Returns the meta object for the attribute '{@link Script.Data#getType <em>Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Type</em>'.
	 * @see Script.Data#getType()
	 * @see #getData()
	 * @generated
	 */
	EAttribute getData_Type();

	/**
	 * Returns the meta object for class '{@link Script.Script <em>Script</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Script</em>'.
	 * @see Script.Script
	 * @generated
	 */
	EClass getScript();

	/**
	 * Returns the meta object for the attribute '{@link Script.Script#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see Script.Script#getName()
	 * @see #getScript()
	 * @generated
	 */
	EAttribute getScript_Name();

	/**
	 * Returns the meta object for the containment reference list '{@link Script.Script#getBlocs <em>Blocs</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Blocs</em>'.
	 * @see Script.Script#getBlocs()
	 * @see #getScript()
	 * @generated
	 */
	EReference getScript_Blocs();

	/**
	 * Returns the meta object for the reference list '{@link Script.Script#getFinalOutput <em>Final Output</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Final Output</em>'.
	 * @see Script.Script#getFinalOutput()
	 * @see #getScript()
	 * @generated
	 */
	EReference getScript_FinalOutput();

	/**
	 * Returns the meta object for the containment reference list '{@link Script.Script#getInitialInput <em>Initial Input</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Initial Input</em>'.
	 * @see Script.Script#getInitialInput()
	 * @see #getScript()
	 * @generated
	 */
	EReference getScript_InitialInput();

	/**
	 * Returns the meta object for class '{@link Script.Blocs <em>Blocs</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Blocs</em>'.
	 * @see Script.Blocs
	 * @generated
	 */
	EClass getBlocs();

	/**
	 * Returns the meta object for the containment reference '{@link Script.Blocs#getOperations <em>Operations</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Operations</em>'.
	 * @see Script.Blocs#getOperations()
	 * @see #getBlocs()
	 * @generated
	 */
	EReference getBlocs_Operations();

	/**
	 * Returns the meta object for the containment reference list '{@link Script.Blocs#getOutput <em>Output</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Output</em>'.
	 * @see Script.Blocs#getOutput()
	 * @see #getBlocs()
	 * @generated
	 */
	EReference getBlocs_Output();

	/**
	 * Returns the meta object for the reference list '{@link Script.Blocs#getInputs <em>Inputs</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Inputs</em>'.
	 * @see Script.Blocs#getInputs()
	 * @see #getBlocs()
	 * @generated
	 */
	EReference getBlocs_Inputs();

	/**
	 * Returns the meta object for class '{@link Script.Operations <em>Operations</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Operations</em>'.
	 * @see Script.Operations
	 * @generated
	 */
	EClass getOperations();

	/**
	 * Returns the meta object for class '{@link Script.Unaire <em>Unaire</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Unaire</em>'.
	 * @see Script.Unaire
	 * @generated
	 */
	EClass getUnaire();

	/**
	 * Returns the meta object for the attribute '{@link Script.Unaire#getFonctions <em>Fonctions</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Fonctions</em>'.
	 * @see Script.Unaire#getFonctions()
	 * @see #getUnaire()
	 * @generated
	 */
	EAttribute getUnaire_Fonctions();

	/**
	 * Returns the meta object for class '{@link Script.Binaire <em>Binaire</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Binaire</em>'.
	 * @see Script.Binaire
	 * @generated
	 */
	EClass getBinaire();

	/**
	 * Returns the meta object for the attribute '{@link Script.Binaire#getOperateur <em>Operateur</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Operateur</em>'.
	 * @see Script.Binaire#getOperateur()
	 * @see #getBinaire()
	 * @generated
	 */
	EAttribute getBinaire_Operateur();

	/**
	 * Returns the meta object for enum '{@link Script.OperationsBinairesType <em>Operations Binaires Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Operations Binaires Type</em>'.
	 * @see Script.OperationsBinairesType
	 * @generated
	 */
	EEnum getOperationsBinairesType();

	/**
	 * Returns the meta object for enum '{@link Script.FonctionsType <em>Fonctions Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Fonctions Type</em>'.
	 * @see Script.FonctionsType
	 * @generated
	 */
	EEnum getFonctionsType();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	ScriptFactory getScriptFactory();

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
		 * The meta object literal for the '{@link Script.impl.DataImpl <em>Data</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see Script.impl.DataImpl
		 * @see Script.impl.ScriptPackageImpl#getData()
		 * @generated
		 */
		EClass DATA = eINSTANCE.getData();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DATA__NAME = eINSTANCE.getData_Name();

		/**
		 * The meta object literal for the '<em><b>Type</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DATA__TYPE = eINSTANCE.getData_Type();

		/**
		 * The meta object literal for the '{@link Script.impl.ScriptImpl <em>Script</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see Script.impl.ScriptImpl
		 * @see Script.impl.ScriptPackageImpl#getScript()
		 * @generated
		 */
		EClass SCRIPT = eINSTANCE.getScript();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SCRIPT__NAME = eINSTANCE.getScript_Name();

		/**
		 * The meta object literal for the '<em><b>Blocs</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SCRIPT__BLOCS = eINSTANCE.getScript_Blocs();

		/**
		 * The meta object literal for the '<em><b>Final Output</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SCRIPT__FINAL_OUTPUT = eINSTANCE.getScript_FinalOutput();

		/**
		 * The meta object literal for the '<em><b>Initial Input</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SCRIPT__INITIAL_INPUT = eINSTANCE.getScript_InitialInput();

		/**
		 * The meta object literal for the '{@link Script.impl.BlocsImpl <em>Blocs</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see Script.impl.BlocsImpl
		 * @see Script.impl.ScriptPackageImpl#getBlocs()
		 * @generated
		 */
		EClass BLOCS = eINSTANCE.getBlocs();

		/**
		 * The meta object literal for the '<em><b>Operations</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference BLOCS__OPERATIONS = eINSTANCE.getBlocs_Operations();

		/**
		 * The meta object literal for the '<em><b>Output</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference BLOCS__OUTPUT = eINSTANCE.getBlocs_Output();

		/**
		 * The meta object literal for the '<em><b>Inputs</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference BLOCS__INPUTS = eINSTANCE.getBlocs_Inputs();

		/**
		 * The meta object literal for the '{@link Script.impl.OperationsImpl <em>Operations</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see Script.impl.OperationsImpl
		 * @see Script.impl.ScriptPackageImpl#getOperations()
		 * @generated
		 */
		EClass OPERATIONS = eINSTANCE.getOperations();

		/**
		 * The meta object literal for the '{@link Script.impl.UnaireImpl <em>Unaire</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see Script.impl.UnaireImpl
		 * @see Script.impl.ScriptPackageImpl#getUnaire()
		 * @generated
		 */
		EClass UNAIRE = eINSTANCE.getUnaire();

		/**
		 * The meta object literal for the '<em><b>Fonctions</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute UNAIRE__FONCTIONS = eINSTANCE.getUnaire_Fonctions();

		/**
		 * The meta object literal for the '{@link Script.impl.BinaireImpl <em>Binaire</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see Script.impl.BinaireImpl
		 * @see Script.impl.ScriptPackageImpl#getBinaire()
		 * @generated
		 */
		EClass BINAIRE = eINSTANCE.getBinaire();

		/**
		 * The meta object literal for the '<em><b>Operateur</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute BINAIRE__OPERATEUR = eINSTANCE.getBinaire_Operateur();

		/**
		 * The meta object literal for the '{@link Script.OperationsBinairesType <em>Operations Binaires Type</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see Script.OperationsBinairesType
		 * @see Script.impl.ScriptPackageImpl#getOperationsBinairesType()
		 * @generated
		 */
		EEnum OPERATIONS_BINAIRES_TYPE = eINSTANCE.getOperationsBinairesType();

		/**
		 * The meta object literal for the '{@link Script.FonctionsType <em>Fonctions Type</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see Script.FonctionsType
		 * @see Script.impl.ScriptPackageImpl#getFonctionsType()
		 * @generated
		 */
		EEnum FONCTIONS_TYPE = eINSTANCE.getFonctionsType();

	}

} //ScriptPackage
