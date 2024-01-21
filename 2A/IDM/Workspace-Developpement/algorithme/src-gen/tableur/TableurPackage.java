/**
 */
package tableur;

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
 * @see tableur.TableurFactory
 * @model kind="package"
 * @generated
 */
public interface TableurPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "tableur";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://tableur.ecore";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "tableur.ecore";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	TableurPackage eINSTANCE = tableur.impl.TableurPackageImpl.init();

	/**
	 * The meta object id for the '{@link tableur.impl.TableurImpl <em>Tableur</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see tableur.impl.TableurImpl
	 * @see tableur.impl.TableurPackageImpl#getTableur()
	 * @generated
	 */
	int TABLEUR = 0;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TABLEUR__NAME = 0;

	/**
	 * The feature id for the '<em><b>Table</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TABLEUR__TABLE = 1;

	/**
	 * The feature id for the '<em><b>Catalogues</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TABLEUR__CATALOGUES = 2;

	/**
	 * The feature id for the '<em><b>Scripts</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TABLEUR__SCRIPTS = 3;

	/**
	 * The number of structural features of the '<em>Tableur</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TABLEUR_FEATURE_COUNT = 4;

	/**
	 * The number of operations of the '<em>Tableur</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TABLEUR_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link tableur.impl.TableImpl <em>Table</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see tableur.impl.TableImpl
	 * @see tableur.impl.TableurPackageImpl#getTable()
	 * @generated
	 */
	int TABLE = 1;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TABLE__NAME = 0;

	/**
	 * The feature id for the '<em><b>Colonne</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TABLE__COLONNE = 1;

	/**
	 * The number of structural features of the '<em>Table</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TABLE_FEATURE_COUNT = 2;

	/**
	 * The number of operations of the '<em>Table</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TABLE_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link tableur.impl.ColonneImpl <em>Colonne</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see tableur.impl.ColonneImpl
	 * @see tableur.impl.TableurPackageImpl#getColonne()
	 * @generated
	 */
	int COLONNE = 2;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLONNE__NAME = 0;

	/**
	 * The number of structural features of the '<em>Colonne</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLONNE_FEATURE_COUNT = 1;

	/**
	 * The number of operations of the '<em>Colonne</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLONNE_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link tableur.impl.ColonneInputImpl <em>Colonne Input</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see tableur.impl.ColonneInputImpl
	 * @see tableur.impl.TableurPackageImpl#getColonneInput()
	 * @generated
	 */
	int COLONNE_INPUT = 3;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLONNE_INPUT__NAME = COLONNE__NAME;

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
	 * The meta object id for the '{@link tableur.impl.ColonneOutputImpl <em>Colonne Output</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see tableur.impl.ColonneOutputImpl
	 * @see tableur.impl.TableurPackageImpl#getColonneOutput()
	 * @generated
	 */
	int COLONNE_OUTPUT = 4;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLONNE_OUTPUT__NAME = COLONNE__NAME;

	/**
	 * The feature id for the '<em><b>Algo</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLONNE_OUTPUT__ALGO = COLONNE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Colonnes</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLONNE_OUTPUT__COLONNES = COLONNE_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Operation</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLONNE_OUTPUT__OPERATION = COLONNE_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Colonne Output</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLONNE_OUTPUT_FEATURE_COUNT = COLONNE_FEATURE_COUNT + 3;

	/**
	 * The number of operations of the '<em>Colonne Output</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLONNE_OUTPUT_OPERATION_COUNT = COLONNE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link tableur.impl.OperationImpl <em>Operation</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see tableur.impl.OperationImpl
	 * @see tableur.impl.TableurPackageImpl#getOperation()
	 * @generated
	 */
	int OPERATION = 5;

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
	 * The meta object id for the '{@link tableur.impl.OperateurBinaireImpl <em>Operateur Binaire</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see tableur.impl.OperateurBinaireImpl
	 * @see tableur.impl.TableurPackageImpl#getOperateurBinaire()
	 * @generated
	 */
	int OPERATEUR_BINAIRE = 6;

	/**
	 * The feature id for the '<em><b>Kind</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATEUR_BINAIRE__KIND = OPERATION_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Operateur Binaire</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATEUR_BINAIRE_FEATURE_COUNT = OPERATION_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Operateur Binaire</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATEUR_BINAIRE_OPERATION_COUNT = OPERATION_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link tableur.impl.OperateurUnaireImpl <em>Operateur Unaire</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see tableur.impl.OperateurUnaireImpl
	 * @see tableur.impl.TableurPackageImpl#getOperateurUnaire()
	 * @generated
	 */
	int OPERATEUR_UNAIRE = 7;

	/**
	 * The feature id for the '<em><b>Kind</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATEUR_UNAIRE__KIND = OPERATION_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Operateur Unaire</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATEUR_UNAIRE_FEATURE_COUNT = OPERATION_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Operateur Unaire</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATEUR_UNAIRE_OPERATION_COUNT = OPERATION_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link tableur.OperateurUnaireType <em>Operateur Unaire Type</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see tableur.OperateurUnaireType
	 * @see tableur.impl.TableurPackageImpl#getOperateurUnaireType()
	 * @generated
	 */
	int OPERATEUR_UNAIRE_TYPE = 8;

	/**
	 * The meta object id for the '{@link tableur.OperateurBinaireType <em>Operateur Binaire Type</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see tableur.OperateurBinaireType
	 * @see tableur.impl.TableurPackageImpl#getOperateurBinaireType()
	 * @generated
	 */
	int OPERATEUR_BINAIRE_TYPE = 9;

	/**
	 * Returns the meta object for class '{@link tableur.Tableur <em>Tableur</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Tableur</em>'.
	 * @see tableur.Tableur
	 * @generated
	 */
	EClass getTableur();

	/**
	 * Returns the meta object for the attribute '{@link tableur.Tableur#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see tableur.Tableur#getName()
	 * @see #getTableur()
	 * @generated
	 */
	EAttribute getTableur_Name();

	/**
	 * Returns the meta object for the containment reference list '{@link tableur.Tableur#getTable <em>Table</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Table</em>'.
	 * @see tableur.Tableur#getTable()
	 * @see #getTableur()
	 * @generated
	 */
	EReference getTableur_Table();

	/**
	 * Returns the meta object for the containment reference list '{@link tableur.Tableur#getCatalogues <em>Catalogues</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Catalogues</em>'.
	 * @see tableur.Tableur#getCatalogues()
	 * @see #getTableur()
	 * @generated
	 */
	EReference getTableur_Catalogues();

	/**
	 * Returns the meta object for the containment reference list '{@link tableur.Tableur#getScripts <em>Scripts</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Scripts</em>'.
	 * @see tableur.Tableur#getScripts()
	 * @see #getTableur()
	 * @generated
	 */
	EReference getTableur_Scripts();

	/**
	 * Returns the meta object for class '{@link tableur.Table <em>Table</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Table</em>'.
	 * @see tableur.Table
	 * @generated
	 */
	EClass getTable();

	/**
	 * Returns the meta object for the attribute '{@link tableur.Table#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see tableur.Table#getName()
	 * @see #getTable()
	 * @generated
	 */
	EAttribute getTable_Name();

	/**
	 * Returns the meta object for the containment reference list '{@link tableur.Table#getColonne <em>Colonne</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Colonne</em>'.
	 * @see tableur.Table#getColonne()
	 * @see #getTable()
	 * @generated
	 */
	EReference getTable_Colonne();

	/**
	 * Returns the meta object for class '{@link tableur.Colonne <em>Colonne</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Colonne</em>'.
	 * @see tableur.Colonne
	 * @generated
	 */
	EClass getColonne();

	/**
	 * Returns the meta object for the attribute '{@link tableur.Colonne#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see tableur.Colonne#getName()
	 * @see #getColonne()
	 * @generated
	 */
	EAttribute getColonne_Name();

	/**
	 * Returns the meta object for class '{@link tableur.ColonneInput <em>Colonne Input</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Colonne Input</em>'.
	 * @see tableur.ColonneInput
	 * @generated
	 */
	EClass getColonneInput();

	/**
	 * Returns the meta object for class '{@link tableur.ColonneOutput <em>Colonne Output</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Colonne Output</em>'.
	 * @see tableur.ColonneOutput
	 * @generated
	 */
	EClass getColonneOutput();

	/**
	 * Returns the meta object for the reference '{@link tableur.ColonneOutput#getAlgo <em>Algo</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Algo</em>'.
	 * @see tableur.ColonneOutput#getAlgo()
	 * @see #getColonneOutput()
	 * @generated
	 */
	EReference getColonneOutput_Algo();

	/**
	 * Returns the meta object for the reference list '{@link tableur.ColonneOutput#getColonnes <em>Colonnes</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Colonnes</em>'.
	 * @see tableur.ColonneOutput#getColonnes()
	 * @see #getColonneOutput()
	 * @generated
	 */
	EReference getColonneOutput_Colonnes();

	/**
	 * Returns the meta object for the containment reference '{@link tableur.ColonneOutput#getOperation <em>Operation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Operation</em>'.
	 * @see tableur.ColonneOutput#getOperation()
	 * @see #getColonneOutput()
	 * @generated
	 */
	EReference getColonneOutput_Operation();

	/**
	 * Returns the meta object for class '{@link tableur.Operation <em>Operation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Operation</em>'.
	 * @see tableur.Operation
	 * @generated
	 */
	EClass getOperation();

	/**
	 * Returns the meta object for class '{@link tableur.OperateurBinaire <em>Operateur Binaire</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Operateur Binaire</em>'.
	 * @see tableur.OperateurBinaire
	 * @generated
	 */
	EClass getOperateurBinaire();

	/**
	 * Returns the meta object for the attribute '{@link tableur.OperateurBinaire#getKind <em>Kind</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Kind</em>'.
	 * @see tableur.OperateurBinaire#getKind()
	 * @see #getOperateurBinaire()
	 * @generated
	 */
	EAttribute getOperateurBinaire_Kind();

	/**
	 * Returns the meta object for class '{@link tableur.OperateurUnaire <em>Operateur Unaire</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Operateur Unaire</em>'.
	 * @see tableur.OperateurUnaire
	 * @generated
	 */
	EClass getOperateurUnaire();

	/**
	 * Returns the meta object for the attribute '{@link tableur.OperateurUnaire#getKind <em>Kind</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Kind</em>'.
	 * @see tableur.OperateurUnaire#getKind()
	 * @see #getOperateurUnaire()
	 * @generated
	 */
	EAttribute getOperateurUnaire_Kind();

	/**
	 * Returns the meta object for enum '{@link tableur.OperateurUnaireType <em>Operateur Unaire Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Operateur Unaire Type</em>'.
	 * @see tableur.OperateurUnaireType
	 * @generated
	 */
	EEnum getOperateurUnaireType();

	/**
	 * Returns the meta object for enum '{@link tableur.OperateurBinaireType <em>Operateur Binaire Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Operateur Binaire Type</em>'.
	 * @see tableur.OperateurBinaireType
	 * @generated
	 */
	EEnum getOperateurBinaireType();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	TableurFactory getTableurFactory();

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
		 * The meta object literal for the '{@link tableur.impl.TableurImpl <em>Tableur</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see tableur.impl.TableurImpl
		 * @see tableur.impl.TableurPackageImpl#getTableur()
		 * @generated
		 */
		EClass TABLEUR = eINSTANCE.getTableur();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TABLEUR__NAME = eINSTANCE.getTableur_Name();

		/**
		 * The meta object literal for the '<em><b>Table</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TABLEUR__TABLE = eINSTANCE.getTableur_Table();

		/**
		 * The meta object literal for the '<em><b>Catalogues</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TABLEUR__CATALOGUES = eINSTANCE.getTableur_Catalogues();

		/**
		 * The meta object literal for the '<em><b>Scripts</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TABLEUR__SCRIPTS = eINSTANCE.getTableur_Scripts();

		/**
		 * The meta object literal for the '{@link tableur.impl.TableImpl <em>Table</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see tableur.impl.TableImpl
		 * @see tableur.impl.TableurPackageImpl#getTable()
		 * @generated
		 */
		EClass TABLE = eINSTANCE.getTable();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TABLE__NAME = eINSTANCE.getTable_Name();

		/**
		 * The meta object literal for the '<em><b>Colonne</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TABLE__COLONNE = eINSTANCE.getTable_Colonne();

		/**
		 * The meta object literal for the '{@link tableur.impl.ColonneImpl <em>Colonne</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see tableur.impl.ColonneImpl
		 * @see tableur.impl.TableurPackageImpl#getColonne()
		 * @generated
		 */
		EClass COLONNE = eINSTANCE.getColonne();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute COLONNE__NAME = eINSTANCE.getColonne_Name();

		/**
		 * The meta object literal for the '{@link tableur.impl.ColonneInputImpl <em>Colonne Input</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see tableur.impl.ColonneInputImpl
		 * @see tableur.impl.TableurPackageImpl#getColonneInput()
		 * @generated
		 */
		EClass COLONNE_INPUT = eINSTANCE.getColonneInput();

		/**
		 * The meta object literal for the '{@link tableur.impl.ColonneOutputImpl <em>Colonne Output</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see tableur.impl.ColonneOutputImpl
		 * @see tableur.impl.TableurPackageImpl#getColonneOutput()
		 * @generated
		 */
		EClass COLONNE_OUTPUT = eINSTANCE.getColonneOutput();

		/**
		 * The meta object literal for the '<em><b>Algo</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference COLONNE_OUTPUT__ALGO = eINSTANCE.getColonneOutput_Algo();

		/**
		 * The meta object literal for the '<em><b>Colonnes</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference COLONNE_OUTPUT__COLONNES = eINSTANCE.getColonneOutput_Colonnes();

		/**
		 * The meta object literal for the '<em><b>Operation</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference COLONNE_OUTPUT__OPERATION = eINSTANCE.getColonneOutput_Operation();

		/**
		 * The meta object literal for the '{@link tableur.impl.OperationImpl <em>Operation</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see tableur.impl.OperationImpl
		 * @see tableur.impl.TableurPackageImpl#getOperation()
		 * @generated
		 */
		EClass OPERATION = eINSTANCE.getOperation();

		/**
		 * The meta object literal for the '{@link tableur.impl.OperateurBinaireImpl <em>Operateur Binaire</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see tableur.impl.OperateurBinaireImpl
		 * @see tableur.impl.TableurPackageImpl#getOperateurBinaire()
		 * @generated
		 */
		EClass OPERATEUR_BINAIRE = eINSTANCE.getOperateurBinaire();

		/**
		 * The meta object literal for the '<em><b>Kind</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute OPERATEUR_BINAIRE__KIND = eINSTANCE.getOperateurBinaire_Kind();

		/**
		 * The meta object literal for the '{@link tableur.impl.OperateurUnaireImpl <em>Operateur Unaire</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see tableur.impl.OperateurUnaireImpl
		 * @see tableur.impl.TableurPackageImpl#getOperateurUnaire()
		 * @generated
		 */
		EClass OPERATEUR_UNAIRE = eINSTANCE.getOperateurUnaire();

		/**
		 * The meta object literal for the '<em><b>Kind</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute OPERATEUR_UNAIRE__KIND = eINSTANCE.getOperateurUnaire_Kind();

		/**
		 * The meta object literal for the '{@link tableur.OperateurUnaireType <em>Operateur Unaire Type</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see tableur.OperateurUnaireType
		 * @see tableur.impl.TableurPackageImpl#getOperateurUnaireType()
		 * @generated
		 */
		EEnum OPERATEUR_UNAIRE_TYPE = eINSTANCE.getOperateurUnaireType();

		/**
		 * The meta object literal for the '{@link tableur.OperateurBinaireType <em>Operateur Binaire Type</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see tableur.OperateurBinaireType
		 * @see tableur.impl.TableurPackageImpl#getOperateurBinaireType()
		 * @generated
		 */
		EEnum OPERATEUR_BINAIRE_TYPE = eINSTANCE.getOperateurBinaireType();

	}

} //TableurPackage
