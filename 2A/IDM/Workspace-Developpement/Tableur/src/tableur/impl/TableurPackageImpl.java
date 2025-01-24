/**
 */
package tableur.impl;

import algorithme.AlgorithmePackage;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

import org.eclipse.emf.ecore.impl.EPackageImpl;

import tableur.Colonne;
import tableur.ColonneInput;
import tableur.ColonneOutput;
import tableur.OperateurBinaire;
import tableur.OperateurBinaireType;
import tableur.OperateurUnaire;
import tableur.OperateurUnaireType;
import tableur.Operation;
import tableur.Table;
import tableur.Tableur;
import tableur.TableurFactory;
import tableur.TableurPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class TableurPackageImpl extends EPackageImpl implements TableurPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass tableurEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass tableEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass colonneEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass colonneInputEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass colonneOutputEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass operationEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass operateurBinaireEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass operateurUnaireEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum operateurUnaireTypeEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum operateurBinaireTypeEEnum = null;

	/**
	 * Creates an instance of the model <b>Package</b>, registered with
	 * {@link org.eclipse.emf.ecore.EPackage.Registry EPackage.Registry} by the package
	 * package URI value.
	 * <p>Note: the correct way to create the package is via the static
	 * factory method {@link #init init()}, which also performs
	 * initialization of the package, or returns the registered package,
	 * if one already exists.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.ecore.EPackage.Registry
	 * @see tableur.TableurPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private TableurPackageImpl() {
		super(eNS_URI, TableurFactory.eINSTANCE);
	}
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static boolean isInited = false;

	/**
	 * Creates, registers, and initializes the <b>Package</b> for this model, and for any others upon which it depends.
	 *
	 * <p>This method is used to initialize {@link TableurPackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static TableurPackage init() {
		if (isInited) return (TableurPackage)EPackage.Registry.INSTANCE.getEPackage(TableurPackage.eNS_URI);

		// Obtain or create and register package
		Object registeredTableurPackage = EPackage.Registry.INSTANCE.get(eNS_URI);
		TableurPackageImpl theTableurPackage = registeredTableurPackage instanceof TableurPackageImpl ? (TableurPackageImpl)registeredTableurPackage : new TableurPackageImpl();

		isInited = true;

		// Initialize simple dependencies
		AlgorithmePackage.eINSTANCE.eClass();

		// Create package meta-data objects
		theTableurPackage.createPackageContents();

		// Initialize created meta-data
		theTableurPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theTableurPackage.freeze();

		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(TableurPackage.eNS_URI, theTableurPackage);
		return theTableurPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getTableur() {
		return tableurEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getTableur_Name() {
		return (EAttribute)tableurEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getTableur_Table() {
		return (EReference)tableurEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getTableur_Catalogues() {
		return (EReference)tableurEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getTable() {
		return tableEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getTable_Name() {
		return (EAttribute)tableEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getTable_Colonne() {
		return (EReference)tableEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getColonne() {
		return colonneEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getColonne_Name() {
		return (EAttribute)colonneEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getColonneInput() {
		return colonneInputEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getColonneOutput() {
		return colonneOutputEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getColonneOutput_Algo() {
		return (EReference)colonneOutputEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getColonneOutput_Colonnes() {
		return (EReference)colonneOutputEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getColonneOutput_Operation() {
		return (EReference)colonneOutputEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getOperation() {
		return operationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getOperateurBinaire() {
		return operateurBinaireEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getOperateurBinaire_Kind() {
		return (EAttribute)operateurBinaireEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getOperateurUnaire() {
		return operateurUnaireEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getOperateurUnaire_Kind() {
		return (EAttribute)operateurUnaireEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EEnum getOperateurUnaireType() {
		return operateurUnaireTypeEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EEnum getOperateurBinaireType() {
		return operateurBinaireTypeEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public TableurFactory getTableurFactory() {
		return (TableurFactory)getEFactoryInstance();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isCreated = false;

	/**
	 * Creates the meta-model objects for the package.  This method is
	 * guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void createPackageContents() {
		if (isCreated) return;
		isCreated = true;

		// Create classes and their features
		tableurEClass = createEClass(TABLEUR);
		createEAttribute(tableurEClass, TABLEUR__NAME);
		createEReference(tableurEClass, TABLEUR__TABLE);
		createEReference(tableurEClass, TABLEUR__CATALOGUES);

		tableEClass = createEClass(TABLE);
		createEAttribute(tableEClass, TABLE__NAME);
		createEReference(tableEClass, TABLE__COLONNE);

		colonneEClass = createEClass(COLONNE);
		createEAttribute(colonneEClass, COLONNE__NAME);

		colonneInputEClass = createEClass(COLONNE_INPUT);

		colonneOutputEClass = createEClass(COLONNE_OUTPUT);
		createEReference(colonneOutputEClass, COLONNE_OUTPUT__ALGO);
		createEReference(colonneOutputEClass, COLONNE_OUTPUT__COLONNES);
		createEReference(colonneOutputEClass, COLONNE_OUTPUT__OPERATION);

		operationEClass = createEClass(OPERATION);

		operateurBinaireEClass = createEClass(OPERATEUR_BINAIRE);
		createEAttribute(operateurBinaireEClass, OPERATEUR_BINAIRE__KIND);

		operateurUnaireEClass = createEClass(OPERATEUR_UNAIRE);
		createEAttribute(operateurUnaireEClass, OPERATEUR_UNAIRE__KIND);

		// Create enums
		operateurUnaireTypeEEnum = createEEnum(OPERATEUR_UNAIRE_TYPE);
		operateurBinaireTypeEEnum = createEEnum(OPERATEUR_BINAIRE_TYPE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isInitialized = false;

	/**
	 * Complete the initialization of the package and its meta-model.  This
	 * method is guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void initializePackageContents() {
		if (isInitialized) return;
		isInitialized = true;

		// Initialize package
		setName(eNAME);
		setNsPrefix(eNS_PREFIX);
		setNsURI(eNS_URI);

		// Obtain other dependent packages
		AlgorithmePackage theAlgorithmePackage = (AlgorithmePackage)EPackage.Registry.INSTANCE.getEPackage(AlgorithmePackage.eNS_URI);

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes
		colonneInputEClass.getESuperTypes().add(this.getColonne());
		colonneOutputEClass.getESuperTypes().add(this.getColonne());
		operateurBinaireEClass.getESuperTypes().add(this.getOperation());
		operateurUnaireEClass.getESuperTypes().add(this.getOperation());

		// Initialize classes, features, and operations; add parameters
		initEClass(tableurEClass, Tableur.class, "Tableur", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getTableur_Name(), ecorePackage.getEString(), "name", null, 0, 1, Tableur.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTableur_Table(), this.getTable(), null, "table", null, 0, -1, Tableur.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTableur_Catalogues(), theAlgorithmePackage.getCatalogue(), null, "catalogues", null, 0, -1, Tableur.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(tableEClass, Table.class, "Table", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getTable_Name(), ecorePackage.getEString(), "name", null, 0, 1, Table.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTable_Colonne(), this.getColonne(), null, "colonne", null, 0, -1, Table.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(colonneEClass, Colonne.class, "Colonne", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getColonne_Name(), ecorePackage.getEString(), "name", null, 0, 1, Colonne.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(colonneInputEClass, ColonneInput.class, "ColonneInput", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(colonneOutputEClass, ColonneOutput.class, "ColonneOutput", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getColonneOutput_Algo(), theAlgorithmePackage.getAlgorithme(), null, "algo", null, 0, 1, ColonneOutput.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getColonneOutput_Colonnes(), this.getColonne(), null, "colonnes", null, 1, 2, ColonneOutput.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getColonneOutput_Operation(), this.getOperation(), null, "operation", null, 1, 1, ColonneOutput.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(operationEClass, Operation.class, "Operation", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(operateurBinaireEClass, OperateurBinaire.class, "OperateurBinaire", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getOperateurBinaire_Kind(), this.getOperateurBinaireType(), "kind", null, 1, 1, OperateurBinaire.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(operateurUnaireEClass, OperateurUnaire.class, "OperateurUnaire", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getOperateurUnaire_Kind(), this.getOperateurUnaireType(), "kind", null, 1, 1, OperateurUnaire.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		// Initialize enums and add enum literals
		initEEnum(operateurUnaireTypeEEnum, OperateurUnaireType.class, "OperateurUnaireType");
		addEEnumLiteral(operateurUnaireTypeEEnum, OperateurUnaireType.OPPOSE);

		initEEnum(operateurBinaireTypeEEnum, OperateurBinaireType.class, "OperateurBinaireType");
		addEEnumLiteral(operateurBinaireTypeEEnum, OperateurBinaireType.ADDITION);
		addEEnumLiteral(operateurBinaireTypeEEnum, OperateurBinaireType.SOUSTRACTION);
		addEEnumLiteral(operateurBinaireTypeEEnum, OperateurBinaireType.MULTIPLICATION);
		addEEnumLiteral(operateurBinaireTypeEEnum, OperateurBinaireType.DIVISION);

		// Create resource
		createResource(eNS_URI);
	}

} //TableurPackageImpl
