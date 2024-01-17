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
	 * The feature id for the '<em><b>Calcul</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCRIPT__CALCUL = 1;

	/**
	 * The number of structural features of the '<em>Script</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCRIPT_FEATURE_COUNT = 2;

	/**
	 * The number of operations of the '<em>Script</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCRIPT_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link script.impl.CalculImpl <em>Calcul</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see script.impl.CalculImpl
	 * @see script.impl.ScriptPackageImpl#getCalcul()
	 * @generated
	 */
	int CALCUL = 1;

	/**
	 * The feature id for the '<em><b>Operation</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CALCUL__OPERATION = 0;

	/**
	 * The feature id for the '<em><b>Outputs</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CALCUL__OUTPUTS = 1;

	/**
	 * The feature id for the '<em><b>Inputs</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CALCUL__INPUTS = 2;

	/**
	 * The number of structural features of the '<em>Calcul</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CALCUL_FEATURE_COUNT = 3;

	/**
	 * The number of operations of the '<em>Calcul</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CALCUL_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link script.impl.OperationImpl <em>Operation</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see script.impl.OperationImpl
	 * @see script.impl.ScriptPackageImpl#getOperation()
	 * @generated
	 */
	int OPERATION = 2;

	/**
	 * The number of structural features of the '<em>Operation</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATION_FEATURE_COUNT = 0;

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
	int OPERATION_UNAIRE = 3;

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
	 * The feature id for the '<em><b>Input</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATION_UNAIRE__INPUT = OPERATION_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Operation Unaire</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATION_UNAIRE_FEATURE_COUNT = OPERATION_FEATURE_COUNT + 3;

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
	int OPERATION_BINAIRE = 4;

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
	 * The feature id for the '<em><b>Input1</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATION_BINAIRE__INPUT1 = OPERATION_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Input2</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATION_BINAIRE__INPUT2 = OPERATION_FEATURE_COUNT + 3;

	/**
	 * The number of structural features of the '<em>Operation Binaire</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATION_BINAIRE_FEATURE_COUNT = OPERATION_FEATURE_COUNT + 4;

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
	int INPUTS = 5;

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
	 * The meta object id for the '{@link script.impl.InputImpl <em>Input</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see script.impl.InputImpl
	 * @see script.impl.ScriptPackageImpl#getInput()
	 * @generated
	 */
	int INPUT = 8;

	/**
	 * The meta object id for the '{@link script.impl.OutputImpl <em>Output</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see script.impl.OutputImpl
	 * @see script.impl.ScriptPackageImpl#getOutput()
	 * @generated
	 */
	int OUTPUT = 6;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OUTPUT__NAME = 0;

	/**
	 * The number of structural features of the '<em>Output</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OUTPUT_FEATURE_COUNT = 1;

	/**
	 * The number of operations of the '<em>Output</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OUTPUT_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link script.impl.ConstanteImpl <em>Constante</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see script.impl.ConstanteImpl
	 * @see script.impl.ScriptPackageImpl#getConstante()
	 * @generated
	 */
	int CONSTANTE = 7;

	/**
	 * The feature id for the '<em><b>Valeur</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONSTANTE__VALEUR = INPUTS_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Constante</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONSTANTE_FEATURE_COUNT = INPUTS_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Constante</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONSTANTE_OPERATION_COUNT = INPUTS_OPERATION_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INPUT__NAME = INPUTS_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Input</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INPUT_FEATURE_COUNT = INPUTS_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Input</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INPUT_OPERATION_COUNT = INPUTS_OPERATION_COUNT + 0;

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
	 * Returns the meta object for the containment reference '{@link script.Script#getCalcul <em>Calcul</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Calcul</em>'.
	 * @see script.Script#getCalcul()
	 * @see #getScript()
	 * @generated
	 */
	EReference getScript_Calcul();

	/**
	 * Returns the meta object for class '{@link script.Calcul <em>Calcul</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Calcul</em>'.
	 * @see script.Calcul
	 * @generated
	 */
	EClass getCalcul();

	/**
	 * Returns the meta object for the containment reference list '{@link script.Calcul#getOperation <em>Operation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Operation</em>'.
	 * @see script.Calcul#getOperation()
	 * @see #getCalcul()
	 * @generated
	 */
	EReference getCalcul_Operation();

	/**
	 * Returns the meta object for the containment reference list '{@link script.Calcul#getOutputs <em>Outputs</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Outputs</em>'.
	 * @see script.Calcul#getOutputs()
	 * @see #getCalcul()
	 * @generated
	 */
	EReference getCalcul_Outputs();

	/**
	 * Returns the meta object for the containment reference list '{@link script.Calcul#getInputs <em>Inputs</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Inputs</em>'.
	 * @see script.Calcul#getInputs()
	 * @see #getCalcul()
	 * @generated
	 */
	EReference getCalcul_Inputs();

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
	 * Returns the meta object for the reference '{@link script.OperationUnaire#getInput <em>Input</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Input</em>'.
	 * @see script.OperationUnaire#getInput()
	 * @see #getOperationUnaire()
	 * @generated
	 */
	EReference getOperationUnaire_Input();

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
	 * Returns the meta object for the reference '{@link script.OperationBinaire#getInput1 <em>Input1</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Input1</em>'.
	 * @see script.OperationBinaire#getInput1()
	 * @see #getOperationBinaire()
	 * @generated
	 */
	EReference getOperationBinaire_Input1();

	/**
	 * Returns the meta object for the reference '{@link script.OperationBinaire#getInput2 <em>Input2</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Input2</em>'.
	 * @see script.OperationBinaire#getInput2()
	 * @see #getOperationBinaire()
	 * @generated
	 */
	EReference getOperationBinaire_Input2();

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
		 * The meta object literal for the '<em><b>Calcul</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SCRIPT__CALCUL = eINSTANCE.getScript_Calcul();

		/**
		 * The meta object literal for the '{@link script.impl.CalculImpl <em>Calcul</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see script.impl.CalculImpl
		 * @see script.impl.ScriptPackageImpl#getCalcul()
		 * @generated
		 */
		EClass CALCUL = eINSTANCE.getCalcul();

		/**
		 * The meta object literal for the '<em><b>Operation</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CALCUL__OPERATION = eINSTANCE.getCalcul_Operation();

		/**
		 * The meta object literal for the '<em><b>Outputs</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CALCUL__OUTPUTS = eINSTANCE.getCalcul_Outputs();

		/**
		 * The meta object literal for the '<em><b>Inputs</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CALCUL__INPUTS = eINSTANCE.getCalcul_Inputs();

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
		 * The meta object literal for the '<em><b>Input</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference OPERATION_UNAIRE__INPUT = eINSTANCE.getOperationUnaire_Input();

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
		 * The meta object literal for the '<em><b>Input1</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference OPERATION_BINAIRE__INPUT1 = eINSTANCE.getOperationBinaire_Input1();

		/**
		 * The meta object literal for the '<em><b>Input2</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference OPERATION_BINAIRE__INPUT2 = eINSTANCE.getOperationBinaire_Input2();

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
