/**
 */
package script;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

import script.impl.*;
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
 * @see script.ScriptFactory
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
	String eNAME = "script";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://www.example.org/script";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "script";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	ScriptPackage eINSTANCE = ScriptPackageImpl.init();

	/**
	 * The meta object id for the '{@link script.impl.scriptImpl <em>script</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see script.impl.scriptImpl
	 * @see script.impl.ScriptPackageImpl#getscript()
	 * @generated
	 */
	int SCRIPT = 0;

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
	 * The feature id for the '<em><b>Initial Input</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCRIPT__INITIAL_INPUT = 2;

	/**
	 * The feature id for the '<em><b>Final Output</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCRIPT__FINAL_OUTPUT = 3;

	/**
	 * The number of structural features of the '<em>script</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCRIPT_FEATURE_COUNT = 4;

	/**
	 * The number of operations of the '<em>script</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCRIPT_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link script.impl.blocsImpl <em>blocs</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see script.impl.blocsImpl
	 * @see script.impl.ScriptPackageImpl#getblocs()
	 * @generated
	 */
	int BLOCS = 1;

	/**
	 * The feature id for the '<em><b>Inputs</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BLOCS__INPUTS = 0;

	/**
	 * The feature id for the '<em><b>Outputs</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BLOCS__OUTPUTS = 1;

	/**
	 * The feature id for the '<em><b>Operation</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BLOCS__OPERATION = 2;

	/**
	 * The number of structural features of the '<em>blocs</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BLOCS_FEATURE_COUNT = 3;

	/**
	 * The number of operations of the '<em>blocs</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BLOCS_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link script.impl.OperationsImpl <em>Operations</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see script.impl.OperationsImpl
	 * @see script.impl.ScriptPackageImpl#getOperations()
	 * @generated
	 */
	int OPERATIONS = 2;

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
	 * The meta object id for the '{@link script.impl.UnaireImpl <em>Unaire</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see script.impl.UnaireImpl
	 * @see script.impl.ScriptPackageImpl#getUnaire()
	 * @generated
	 */
	int UNAIRE = 3;

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
	 * The meta object id for the '{@link script.impl.BinaireImpl <em>Binaire</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see script.impl.BinaireImpl
	 * @see script.impl.ScriptPackageImpl#getBinaire()
	 * @generated
	 */
	int BINAIRE = 4;

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
	 * The meta object id for the '{@link script.impl.DataImpl <em>Data</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see script.impl.DataImpl
	 * @see script.impl.ScriptPackageImpl#getData()
	 * @generated
	 */
	int DATA = 5;

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
	 * The meta object id for the '{@link script.OperationsBinaires <em>Operations Binaires</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see script.OperationsBinaires
	 * @see script.impl.ScriptPackageImpl#getOperationsBinaires()
	 * @generated
	 */
	int OPERATIONS_BINAIRES = 6;

	/**
	 * The meta object id for the '{@link script.Fonctions <em>Fonctions</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see script.Fonctions
	 * @see script.impl.ScriptPackageImpl#getFonctions()
	 * @generated
	 */
	int FONCTIONS = 7;


	/**
	 * Returns the meta object for class '{@link script.script <em>script</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>script</em>'.
	 * @see script.script
	 * @generated
	 */
	EClass getscript();

	/**
	 * Returns the meta object for the attribute '{@link script.script#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see script.script#getName()
	 * @see #getscript()
	 * @generated
	 */
	EAttribute getscript_Name();

	/**
	 * Returns the meta object for the containment reference list '{@link script.script#getBlocs <em>Blocs</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Blocs</em>'.
	 * @see script.script#getBlocs()
	 * @see #getscript()
	 * @generated
	 */
	EReference getscript_Blocs();

	/**
	 * Returns the meta object for the containment reference list '{@link script.script#getInitialInput <em>Initial Input</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Initial Input</em>'.
	 * @see script.script#getInitialInput()
	 * @see #getscript()
	 * @generated
	 */
	EReference getscript_InitialInput();

	/**
	 * Returns the meta object for the reference list '{@link script.script#getFinalOutput <em>Final Output</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Final Output</em>'.
	 * @see script.script#getFinalOutput()
	 * @see #getscript()
	 * @generated
	 */
	EReference getscript_FinalOutput();

	/**
	 * Returns the meta object for class '{@link script.blocs <em>blocs</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>blocs</em>'.
	 * @see script.blocs
	 * @generated
	 */
	EClass getblocs();

	/**
	 * Returns the meta object for the reference list '{@link script.blocs#getInputs <em>Inputs</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Inputs</em>'.
	 * @see script.blocs#getInputs()
	 * @see #getblocs()
	 * @generated
	 */
	EReference getblocs_Inputs();

	/**
	 * Returns the meta object for the containment reference list '{@link script.blocs#getOutputs <em>Outputs</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Outputs</em>'.
	 * @see script.blocs#getOutputs()
	 * @see #getblocs()
	 * @generated
	 */
	EReference getblocs_Outputs();

	/**
	 * Returns the meta object for the containment reference '{@link script.blocs#getOperation <em>Operation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Operation</em>'.
	 * @see script.blocs#getOperation()
	 * @see #getblocs()
	 * @generated
	 */
	EReference getblocs_Operation();

	/**
	 * Returns the meta object for class '{@link script.Operations <em>Operations</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Operations</em>'.
	 * @see script.Operations
	 * @generated
	 */
	EClass getOperations();

	/**
	 * Returns the meta object for class '{@link script.Unaire <em>Unaire</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Unaire</em>'.
	 * @see script.Unaire
	 * @generated
	 */
	EClass getUnaire();

	/**
	 * Returns the meta object for the attribute '{@link script.Unaire#getFonctions <em>Fonctions</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Fonctions</em>'.
	 * @see script.Unaire#getFonctions()
	 * @see #getUnaire()
	 * @generated
	 */
	EAttribute getUnaire_Fonctions();

	/**
	 * Returns the meta object for class '{@link script.Binaire <em>Binaire</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Binaire</em>'.
	 * @see script.Binaire
	 * @generated
	 */
	EClass getBinaire();

	/**
	 * Returns the meta object for the attribute '{@link script.Binaire#getOperateur <em>Operateur</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Operateur</em>'.
	 * @see script.Binaire#getOperateur()
	 * @see #getBinaire()
	 * @generated
	 */
	EAttribute getBinaire_Operateur();

	/**
	 * Returns the meta object for class '{@link script.Data <em>Data</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Data</em>'.
	 * @see script.Data
	 * @generated
	 */
	EClass getData();

	/**
	 * Returns the meta object for the attribute '{@link script.Data#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see script.Data#getName()
	 * @see #getData()
	 * @generated
	 */
	EAttribute getData_Name();

	/**
	 * Returns the meta object for the attribute '{@link script.Data#getType <em>Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Type</em>'.
	 * @see script.Data#getType()
	 * @see #getData()
	 * @generated
	 */
	EAttribute getData_Type();

	/**
	 * Returns the meta object for enum '{@link script.OperationsBinaires <em>Operations Binaires</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Operations Binaires</em>'.
	 * @see script.OperationsBinaires
	 * @generated
	 */
	EEnum getOperationsBinaires();

	/**
	 * Returns the meta object for enum '{@link script.Fonctions <em>Fonctions</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Fonctions</em>'.
	 * @see script.Fonctions
	 * @generated
	 */
	EEnum getFonctions();

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
		 * The meta object literal for the '{@link script.impl.scriptImpl <em>script</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see script.impl.scriptImpl
		 * @see script.impl.ScriptPackageImpl#getscript()
		 * @generated
		 */
		EClass SCRIPT = eINSTANCE.getscript();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SCRIPT__NAME = eINSTANCE.getscript_Name();

		/**
		 * The meta object literal for the '<em><b>Blocs</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SCRIPT__BLOCS = eINSTANCE.getscript_Blocs();

		/**
		 * The meta object literal for the '<em><b>Initial Input</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SCRIPT__INITIAL_INPUT = eINSTANCE.getscript_InitialInput();

		/**
		 * The meta object literal for the '<em><b>Final Output</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SCRIPT__FINAL_OUTPUT = eINSTANCE.getscript_FinalOutput();

		/**
		 * The meta object literal for the '{@link script.impl.blocsImpl <em>blocs</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see script.impl.blocsImpl
		 * @see script.impl.ScriptPackageImpl#getblocs()
		 * @generated
		 */
		EClass BLOCS = eINSTANCE.getblocs();

		/**
		 * The meta object literal for the '<em><b>Inputs</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference BLOCS__INPUTS = eINSTANCE.getblocs_Inputs();

		/**
		 * The meta object literal for the '<em><b>Outputs</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference BLOCS__OUTPUTS = eINSTANCE.getblocs_Outputs();

		/**
		 * The meta object literal for the '<em><b>Operation</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference BLOCS__OPERATION = eINSTANCE.getblocs_Operation();

		/**
		 * The meta object literal for the '{@link script.impl.OperationsImpl <em>Operations</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see script.impl.OperationsImpl
		 * @see script.impl.ScriptPackageImpl#getOperations()
		 * @generated
		 */
		EClass OPERATIONS = eINSTANCE.getOperations();

		/**
		 * The meta object literal for the '{@link script.impl.UnaireImpl <em>Unaire</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see script.impl.UnaireImpl
		 * @see script.impl.ScriptPackageImpl#getUnaire()
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
		 * The meta object literal for the '{@link script.impl.BinaireImpl <em>Binaire</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see script.impl.BinaireImpl
		 * @see script.impl.ScriptPackageImpl#getBinaire()
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
		 * The meta object literal for the '{@link script.impl.DataImpl <em>Data</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see script.impl.DataImpl
		 * @see script.impl.ScriptPackageImpl#getData()
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
		 * The meta object literal for the '{@link script.OperationsBinaires <em>Operations Binaires</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see script.OperationsBinaires
		 * @see script.impl.ScriptPackageImpl#getOperationsBinaires()
		 * @generated
		 */
		EEnum OPERATIONS_BINAIRES = eINSTANCE.getOperationsBinaires();

		/**
		 * The meta object literal for the '{@link script.Fonctions <em>Fonctions</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see script.Fonctions
		 * @see script.impl.ScriptPackageImpl#getFonctions()
		 * @generated
		 */
		EEnum FONCTIONS = eINSTANCE.getFonctions();

	}

} //ScriptPackage
