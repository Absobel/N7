/**
 */
package script;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
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
	String eNS_URI = "http://script.ecore";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "script.ecore";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	ScriptPackage eINSTANCE = script.impl.ScriptPackageImpl.init();

	/**
	 * The meta object id for the '{@link script.impl.ScriptImpl <em>Script</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see script.impl.ScriptImpl
	 * @see script.impl.ScriptPackageImpl#getScript()
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
	 * The feature id for the '<em><b>Initial Inputs</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCRIPT__INITIAL_INPUTS = 1;

	/**
	 * The feature id for the '<em><b>Operation</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCRIPT__OPERATION = 2;

	/**
	 * The feature id for the '<em><b>Final Outputs</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCRIPT__FINAL_OUTPUTS = 3;

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
	 * The meta object id for the '{@link script.impl.OperationImpl <em>Operation</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see script.impl.OperationImpl
	 * @see script.impl.ScriptPackageImpl#getOperation()
	 * @generated
	 */
	int OPERATION = 1;

	/**
	 * The feature id for the '<em><b>Inputs</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATION__INPUTS = 0;

	/**
	 * The number of structural features of the '<em>Operation</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATION_FEATURE_COUNT = 1;

	/**
	 * The number of operations of the '<em>Operation</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATION_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link script.impl.OperationUnaireImpl <em>Operation Unaire</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see script.impl.OperationUnaireImpl
	 * @see script.impl.ScriptPackageImpl#getOperationUnaire()
	 * @generated
	 */
	int OPERATION_UNAIRE = 2;

	/**
	 * The feature id for the '<em><b>Inputs</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATION_UNAIRE__INPUTS = OPERATION__INPUTS;

	/**
	 * The feature id for the '<em><b>Fonction</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATION_UNAIRE__FONCTION = OPERATION_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Output</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATION_UNAIRE__OUTPUT = OPERATION_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Operation Unaire</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATION_UNAIRE_FEATURE_COUNT = OPERATION_FEATURE_COUNT + 2;

	/**
	 * The number of operations of the '<em>Operation Unaire</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATION_UNAIRE_OPERATION_COUNT = OPERATION_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link script.impl.OperationBinaireImpl <em>Operation Binaire</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see script.impl.OperationBinaireImpl
	 * @see script.impl.ScriptPackageImpl#getOperationBinaire()
	 * @generated
	 */
	int OPERATION_BINAIRE = 3;

	/**
	 * The feature id for the '<em><b>Inputs</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATION_BINAIRE__INPUTS = OPERATION__INPUTS;

	/**
	 * The feature id for the '<em><b>Operateur</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATION_BINAIRE__OPERATEUR = OPERATION_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Output</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATION_BINAIRE__OUTPUT = OPERATION_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Operation Binaire</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATION_BINAIRE_FEATURE_COUNT = OPERATION_FEATURE_COUNT + 2;

	/**
	 * The number of operations of the '<em>Operation Binaire</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATION_BINAIRE_OPERATION_COUNT = OPERATION_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link script.impl.InputsImpl <em>Inputs</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see script.impl.InputsImpl
	 * @see script.impl.ScriptPackageImpl#getInputs()
	 * @generated
	 */
	int INPUTS = 4;

	/**
	 * The number of structural features of the '<em>Inputs</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INPUTS_FEATURE_COUNT = 0;

	/**
	 * The number of operations of the '<em>Inputs</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INPUTS_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link script.impl.OutputImpl <em>Output</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see script.impl.OutputImpl
	 * @see script.impl.ScriptPackageImpl#getOutput()
	 * @generated
	 */
	int OUTPUT = 5;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OUTPUT__NAME = INPUTS_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Output</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OUTPUT_FEATURE_COUNT = INPUTS_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Output</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OUTPUT_OPERATION_COUNT = INPUTS_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link script.impl.RealInputsImpl <em>Real Inputs</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see script.impl.RealInputsImpl
	 * @see script.impl.ScriptPackageImpl#getRealInputs()
	 * @generated
	 */
	int REAL_INPUTS = 8;

	/**
	 * The number of structural features of the '<em>Real Inputs</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REAL_INPUTS_FEATURE_COUNT = INPUTS_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Real Inputs</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REAL_INPUTS_OPERATION_COUNT = INPUTS_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link script.impl.ConstanteImpl <em>Constante</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see script.impl.ConstanteImpl
	 * @see script.impl.ScriptPackageImpl#getConstante()
	 * @generated
	 */
	int CONSTANTE = 6;

	/**
	 * The feature id for the '<em><b>Valeur</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONSTANTE__VALEUR = REAL_INPUTS_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Constante</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONSTANTE_FEATURE_COUNT = REAL_INPUTS_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Constante</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONSTANTE_OPERATION_COUNT = REAL_INPUTS_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link script.impl.InputImpl <em>Input</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see script.impl.InputImpl
	 * @see script.impl.ScriptPackageImpl#getInput()
	 * @generated
	 */
	int INPUT = 7;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INPUT__NAME = REAL_INPUTS_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Input</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INPUT_FEATURE_COUNT = REAL_INPUTS_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Input</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INPUT_OPERATION_COUNT = REAL_INPUTS_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link script.OperationBinaireType <em>Operation Binaire Type</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see script.OperationBinaireType
	 * @see script.impl.ScriptPackageImpl#getOperationBinaireType()
	 * @generated
	 */
	int OPERATION_BINAIRE_TYPE = 9;

	/**
	 * The meta object id for the '{@link script.FonctionType <em>Fonction Type</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see script.FonctionType
	 * @see script.impl.ScriptPackageImpl#getFonctionType()
	 * @generated
	 */
	int FONCTION_TYPE = 10;

	/**
	 * Returns the meta object for class '{@link script.Script <em>Script</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Script</em>'.
	 * @see script.Script
	 * @generated
	 */
	EClass getScript();

	/**
	 * Returns the meta object for the attribute '{@link script.Script#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see script.Script#getName()
	 * @see #getScript()
	 * @generated
	 */
	EAttribute getScript_Name();

	/**
	 * Returns the meta object for the containment reference list '{@link script.Script#getInitialInputs <em>Initial Inputs</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Initial Inputs</em>'.
	 * @see script.Script#getInitialInputs()
	 * @see #getScript()
	 * @generated
	 */
	EReference getScript_InitialInputs();

	/**
	 * Returns the meta object for the containment reference list '{@link script.Script#getOperation <em>Operation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Operation</em>'.
	 * @see script.Script#getOperation()
	 * @see #getScript()
	 * @generated
	 */
	EReference getScript_Operation();

	/**
	 * Returns the meta object for the containment reference list '{@link script.Script#getFinalOutputs <em>Final Outputs</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Final Outputs</em>'.
	 * @see script.Script#getFinalOutputs()
	 * @see #getScript()
	 * @generated
	 */
	EReference getScript_FinalOutputs();

	/**
	 * Returns the meta object for class '{@link script.Operation <em>Operation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Operation</em>'.
	 * @see script.Operation
	 * @generated
	 */
	EClass getOperation();

	/**
	 * Returns the meta object for the reference list '{@link script.Operation#getInputs <em>Inputs</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Inputs</em>'.
	 * @see script.Operation#getInputs()
	 * @see #getOperation()
	 * @generated
	 */
	EReference getOperation_Inputs();

	/**
	 * Returns the meta object for class '{@link script.OperationUnaire <em>Operation Unaire</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Operation Unaire</em>'.
	 * @see script.OperationUnaire
	 * @generated
	 */
	EClass getOperationUnaire();

	/**
	 * Returns the meta object for the attribute '{@link script.OperationUnaire#getFonction <em>Fonction</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Fonction</em>'.
	 * @see script.OperationUnaire#getFonction()
	 * @see #getOperationUnaire()
	 * @generated
	 */
	EAttribute getOperationUnaire_Fonction();

	/**
	 * Returns the meta object for the containment reference '{@link script.OperationUnaire#getOutput <em>Output</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Output</em>'.
	 * @see script.OperationUnaire#getOutput()
	 * @see #getOperationUnaire()
	 * @generated
	 */
	EReference getOperationUnaire_Output();

	/**
	 * Returns the meta object for class '{@link script.OperationBinaire <em>Operation Binaire</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Operation Binaire</em>'.
	 * @see script.OperationBinaire
	 * @generated
	 */
	EClass getOperationBinaire();

	/**
	 * Returns the meta object for the attribute '{@link script.OperationBinaire#getOperateur <em>Operateur</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Operateur</em>'.
	 * @see script.OperationBinaire#getOperateur()
	 * @see #getOperationBinaire()
	 * @generated
	 */
	EAttribute getOperationBinaire_Operateur();

	/**
	 * Returns the meta object for the containment reference '{@link script.OperationBinaire#getOutput <em>Output</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Output</em>'.
	 * @see script.OperationBinaire#getOutput()
	 * @see #getOperationBinaire()
	 * @generated
	 */
	EReference getOperationBinaire_Output();

	/**
	 * Returns the meta object for class '{@link script.Inputs <em>Inputs</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Inputs</em>'.
	 * @see script.Inputs
	 * @generated
	 */
	EClass getInputs();

	/**
	 * Returns the meta object for class '{@link script.Output <em>Output</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Output</em>'.
	 * @see script.Output
	 * @generated
	 */
	EClass getOutput();

	/**
	 * Returns the meta object for the attribute '{@link script.Output#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see script.Output#getName()
	 * @see #getOutput()
	 * @generated
	 */
	EAttribute getOutput_Name();

	/**
	 * Returns the meta object for class '{@link script.Constante <em>Constante</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Constante</em>'.
	 * @see script.Constante
	 * @generated
	 */
	EClass getConstante();

	/**
	 * Returns the meta object for the attribute '{@link script.Constante#getValeur <em>Valeur</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Valeur</em>'.
	 * @see script.Constante#getValeur()
	 * @see #getConstante()
	 * @generated
	 */
	EAttribute getConstante_Valeur();

	/**
	 * Returns the meta object for class '{@link script.Input <em>Input</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Input</em>'.
	 * @see script.Input
	 * @generated
	 */
	EClass getInput();

	/**
	 * Returns the meta object for the attribute '{@link script.Input#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see script.Input#getName()
	 * @see #getInput()
	 * @generated
	 */
	EAttribute getInput_Name();

	/**
	 * Returns the meta object for class '{@link script.RealInputs <em>Real Inputs</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Real Inputs</em>'.
	 * @see script.RealInputs
	 * @generated
	 */
	EClass getRealInputs();

	/**
	 * Returns the meta object for enum '{@link script.OperationBinaireType <em>Operation Binaire Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Operation Binaire Type</em>'.
	 * @see script.OperationBinaireType
	 * @generated
	 */
	EEnum getOperationBinaireType();

	/**
	 * Returns the meta object for enum '{@link script.FonctionType <em>Fonction Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Fonction Type</em>'.
	 * @see script.FonctionType
	 * @generated
	 */
	EEnum getFonctionType();

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
		 * The meta object literal for the '{@link script.impl.ScriptImpl <em>Script</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see script.impl.ScriptImpl
		 * @see script.impl.ScriptPackageImpl#getScript()
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
		 * The meta object literal for the '<em><b>Initial Inputs</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SCRIPT__INITIAL_INPUTS = eINSTANCE.getScript_InitialInputs();

		/**
		 * The meta object literal for the '<em><b>Operation</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SCRIPT__OPERATION = eINSTANCE.getScript_Operation();

		/**
		 * The meta object literal for the '<em><b>Final Outputs</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SCRIPT__FINAL_OUTPUTS = eINSTANCE.getScript_FinalOutputs();

		/**
		 * The meta object literal for the '{@link script.impl.OperationImpl <em>Operation</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see script.impl.OperationImpl
		 * @see script.impl.ScriptPackageImpl#getOperation()
		 * @generated
		 */
		EClass OPERATION = eINSTANCE.getOperation();

		/**
		 * The meta object literal for the '<em><b>Inputs</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference OPERATION__INPUTS = eINSTANCE.getOperation_Inputs();

		/**
		 * The meta object literal for the '{@link script.impl.OperationUnaireImpl <em>Operation Unaire</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see script.impl.OperationUnaireImpl
		 * @see script.impl.ScriptPackageImpl#getOperationUnaire()
		 * @generated
		 */
		EClass OPERATION_UNAIRE = eINSTANCE.getOperationUnaire();

		/**
		 * The meta object literal for the '<em><b>Fonction</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute OPERATION_UNAIRE__FONCTION = eINSTANCE.getOperationUnaire_Fonction();

		/**
		 * The meta object literal for the '<em><b>Output</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference OPERATION_UNAIRE__OUTPUT = eINSTANCE.getOperationUnaire_Output();

		/**
		 * The meta object literal for the '{@link script.impl.OperationBinaireImpl <em>Operation Binaire</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see script.impl.OperationBinaireImpl
		 * @see script.impl.ScriptPackageImpl#getOperationBinaire()
		 * @generated
		 */
		EClass OPERATION_BINAIRE = eINSTANCE.getOperationBinaire();

		/**
		 * The meta object literal for the '<em><b>Operateur</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute OPERATION_BINAIRE__OPERATEUR = eINSTANCE.getOperationBinaire_Operateur();

		/**
		 * The meta object literal for the '<em><b>Output</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference OPERATION_BINAIRE__OUTPUT = eINSTANCE.getOperationBinaire_Output();

		/**
		 * The meta object literal for the '{@link script.impl.InputsImpl <em>Inputs</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see script.impl.InputsImpl
		 * @see script.impl.ScriptPackageImpl#getInputs()
		 * @generated
		 */
		EClass INPUTS = eINSTANCE.getInputs();

		/**
		 * The meta object literal for the '{@link script.impl.OutputImpl <em>Output</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see script.impl.OutputImpl
		 * @see script.impl.ScriptPackageImpl#getOutput()
		 * @generated
		 */
		EClass OUTPUT = eINSTANCE.getOutput();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute OUTPUT__NAME = eINSTANCE.getOutput_Name();

		/**
		 * The meta object literal for the '{@link script.impl.ConstanteImpl <em>Constante</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see script.impl.ConstanteImpl
		 * @see script.impl.ScriptPackageImpl#getConstante()
		 * @generated
		 */
		EClass CONSTANTE = eINSTANCE.getConstante();

		/**
		 * The meta object literal for the '<em><b>Valeur</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CONSTANTE__VALEUR = eINSTANCE.getConstante_Valeur();

		/**
		 * The meta object literal for the '{@link script.impl.InputImpl <em>Input</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see script.impl.InputImpl
		 * @see script.impl.ScriptPackageImpl#getInput()
		 * @generated
		 */
		EClass INPUT = eINSTANCE.getInput();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute INPUT__NAME = eINSTANCE.getInput_Name();

		/**
		 * The meta object literal for the '{@link script.impl.RealInputsImpl <em>Real Inputs</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see script.impl.RealInputsImpl
		 * @see script.impl.ScriptPackageImpl#getRealInputs()
		 * @generated
		 */
		EClass REAL_INPUTS = eINSTANCE.getRealInputs();

		/**
		 * The meta object literal for the '{@link script.OperationBinaireType <em>Operation Binaire Type</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see script.OperationBinaireType
		 * @see script.impl.ScriptPackageImpl#getOperationBinaireType()
		 * @generated
		 */
		EEnum OPERATION_BINAIRE_TYPE = eINSTANCE.getOperationBinaireType();

		/**
		 * The meta object literal for the '{@link script.FonctionType <em>Fonction Type</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see script.FonctionType
		 * @see script.impl.ScriptPackageImpl#getFonctionType()
		 * @generated
		 */
		EEnum FONCTION_TYPE = eINSTANCE.getFonctionType();

	}

} //ScriptPackage
