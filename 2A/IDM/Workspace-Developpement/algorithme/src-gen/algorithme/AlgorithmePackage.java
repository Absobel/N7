/**
 */
package algorithme;

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
 * @see algorithme.AlgorithmeFactory
 * @model kind="package"
 * @generated
 */
public interface AlgorithmePackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "algorithme";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://algorithme.ecore";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "algorithme";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	AlgorithmePackage eINSTANCE = algorithme.impl.AlgorithmePackageImpl.init();

	/**
	 * The meta object id for the '{@link algorithme.impl.CatalogueImpl <em>Catalogue</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see algorithme.impl.CatalogueImpl
	 * @see algorithme.impl.AlgorithmePackageImpl#getCatalogue()
	 * @generated
	 */
	int CATALOGUE = 0;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CATALOGUE__NAME = 0;

	/**
	 * The feature id for the '<em><b>Algorithmes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CATALOGUE__ALGORITHMES = 1;

	/**
	 * The number of structural features of the '<em>Catalogue</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CATALOGUE_FEATURE_COUNT = 2;

	/**
	 * The number of operations of the '<em>Catalogue</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CATALOGUE_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link algorithme.impl.AlgorithmeElementImpl <em>Element</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see algorithme.impl.AlgorithmeElementImpl
	 * @see algorithme.impl.AlgorithmePackageImpl#getAlgorithmeElement()
	 * @generated
	 */
	int ALGORITHME_ELEMENT = 1;

	/**
	 * The number of structural features of the '<em>Element</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ALGORITHME_ELEMENT_FEATURE_COUNT = 0;

	/**
	 * The number of operations of the '<em>Element</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ALGORITHME_ELEMENT_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link algorithme.impl.AlgorithmeImpl <em>Algorithme</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see algorithme.impl.AlgorithmeImpl
	 * @see algorithme.impl.AlgorithmePackageImpl#getAlgorithme()
	 * @generated
	 */
	int ALGORITHME = 2;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ALGORITHME__NAME = ALGORITHME_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Ressource</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ALGORITHME__RESSOURCE = ALGORITHME_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Documentation</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ALGORITHME__DOCUMENTATION = ALGORITHME_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Algorithme</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ALGORITHME_FEATURE_COUNT = ALGORITHME_ELEMENT_FEATURE_COUNT + 3;

	/**
	 * The number of operations of the '<em>Algorithme</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ALGORITHME_OPERATION_COUNT = ALGORITHME_ELEMENT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link algorithme.impl.RessourceImpl <em>Ressource</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see algorithme.impl.RessourceImpl
	 * @see algorithme.impl.AlgorithmePackageImpl#getRessource()
	 * @generated
	 */
	int RESSOURCE = 3;

	/**
	 * The feature id for the '<em><b>File</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESSOURCE__FILE = 0;

	/**
	 * The feature id for the '<em><b>Stdin</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESSOURCE__STDIN = 1;

	/**
	 * The feature id for the '<em><b>Stdout</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESSOURCE__STDOUT = 2;

	/**
	 * The number of structural features of the '<em>Ressource</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESSOURCE_FEATURE_COUNT = 3;

	/**
	 * The number of operations of the '<em>Ressource</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESSOURCE_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link algorithme.impl.DocumentationImpl <em>Documentation</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see algorithme.impl.DocumentationImpl
	 * @see algorithme.impl.AlgorithmePackageImpl#getDocumentation()
	 * @generated
	 */
	int DOCUMENTATION = 4;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOCUMENTATION__DESCRIPTION = 0;

	/**
	 * The number of structural features of the '<em>Documentation</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOCUMENTATION_FEATURE_COUNT = 1;

	/**
	 * The number of operations of the '<em>Documentation</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOCUMENTATION_OPERATION_COUNT = 0;

	/**
	 * Returns the meta object for class '{@link algorithme.Catalogue <em>Catalogue</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Catalogue</em>'.
	 * @see algorithme.Catalogue
	 * @generated
	 */
	EClass getCatalogue();

	/**
	 * Returns the meta object for the attribute '{@link algorithme.Catalogue#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see algorithme.Catalogue#getName()
	 * @see #getCatalogue()
	 * @generated
	 */
	EAttribute getCatalogue_Name();

	/**
	 * Returns the meta object for the containment reference list '{@link algorithme.Catalogue#getAlgorithmes <em>Algorithmes</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Algorithmes</em>'.
	 * @see algorithme.Catalogue#getAlgorithmes()
	 * @see #getCatalogue()
	 * @generated
	 */
	EReference getCatalogue_Algorithmes();

	/**
	 * Returns the meta object for class '{@link algorithme.AlgorithmeElement <em>Element</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Element</em>'.
	 * @see algorithme.AlgorithmeElement
	 * @generated
	 */
	EClass getAlgorithmeElement();

	/**
	 * Returns the meta object for class '{@link algorithme.Algorithme <em>Algorithme</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Algorithme</em>'.
	 * @see algorithme.Algorithme
	 * @generated
	 */
	EClass getAlgorithme();

	/**
	 * Returns the meta object for the attribute '{@link algorithme.Algorithme#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see algorithme.Algorithme#getName()
	 * @see #getAlgorithme()
	 * @generated
	 */
	EAttribute getAlgorithme_Name();

	/**
	 * Returns the meta object for the containment reference '{@link algorithme.Algorithme#getRessource <em>Ressource</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Ressource</em>'.
	 * @see algorithme.Algorithme#getRessource()
	 * @see #getAlgorithme()
	 * @generated
	 */
	EReference getAlgorithme_Ressource();

	/**
	 * Returns the meta object for the reference '{@link algorithme.Algorithme#getDocumentation <em>Documentation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Documentation</em>'.
	 * @see algorithme.Algorithme#getDocumentation()
	 * @see #getAlgorithme()
	 * @generated
	 */
	EReference getAlgorithme_Documentation();

	/**
	 * Returns the meta object for class '{@link algorithme.Ressource <em>Ressource</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Ressource</em>'.
	 * @see algorithme.Ressource
	 * @generated
	 */
	EClass getRessource();

	/**
	 * Returns the meta object for the attribute '{@link algorithme.Ressource#getFile <em>File</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>File</em>'.
	 * @see algorithme.Ressource#getFile()
	 * @see #getRessource()
	 * @generated
	 */
	EAttribute getRessource_File();

	/**
	 * Returns the meta object for the reference list '{@link algorithme.Ressource#getStdin <em>Stdin</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Stdin</em>'.
	 * @see algorithme.Ressource#getStdin()
	 * @see #getRessource()
	 * @generated
	 */
	EReference getRessource_Stdin();

	/**
	 * Returns the meta object for the reference list '{@link algorithme.Ressource#getStdout <em>Stdout</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Stdout</em>'.
	 * @see algorithme.Ressource#getStdout()
	 * @see #getRessource()
	 * @generated
	 */
	EReference getRessource_Stdout();

	/**
	 * Returns the meta object for class '{@link algorithme.Documentation <em>Documentation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Documentation</em>'.
	 * @see algorithme.Documentation
	 * @generated
	 */
	EClass getDocumentation();

	/**
	 * Returns the meta object for the attribute '{@link algorithme.Documentation#getDescription <em>Description</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Description</em>'.
	 * @see algorithme.Documentation#getDescription()
	 * @see #getDocumentation()
	 * @generated
	 */
	EAttribute getDocumentation_Description();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	AlgorithmeFactory getAlgorithmeFactory();

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
		 * The meta object literal for the '{@link algorithme.impl.CatalogueImpl <em>Catalogue</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see algorithme.impl.CatalogueImpl
		 * @see algorithme.impl.AlgorithmePackageImpl#getCatalogue()
		 * @generated
		 */
		EClass CATALOGUE = eINSTANCE.getCatalogue();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CATALOGUE__NAME = eINSTANCE.getCatalogue_Name();

		/**
		 * The meta object literal for the '<em><b>Algorithmes</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CATALOGUE__ALGORITHMES = eINSTANCE.getCatalogue_Algorithmes();

		/**
		 * The meta object literal for the '{@link algorithme.impl.AlgorithmeElementImpl <em>Element</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see algorithme.impl.AlgorithmeElementImpl
		 * @see algorithme.impl.AlgorithmePackageImpl#getAlgorithmeElement()
		 * @generated
		 */
		EClass ALGORITHME_ELEMENT = eINSTANCE.getAlgorithmeElement();

		/**
		 * The meta object literal for the '{@link algorithme.impl.AlgorithmeImpl <em>Algorithme</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see algorithme.impl.AlgorithmeImpl
		 * @see algorithme.impl.AlgorithmePackageImpl#getAlgorithme()
		 * @generated
		 */
		EClass ALGORITHME = eINSTANCE.getAlgorithme();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ALGORITHME__NAME = eINSTANCE.getAlgorithme_Name();

		/**
		 * The meta object literal for the '<em><b>Ressource</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ALGORITHME__RESSOURCE = eINSTANCE.getAlgorithme_Ressource();

		/**
		 * The meta object literal for the '<em><b>Documentation</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ALGORITHME__DOCUMENTATION = eINSTANCE.getAlgorithme_Documentation();

		/**
		 * The meta object literal for the '{@link algorithme.impl.RessourceImpl <em>Ressource</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see algorithme.impl.RessourceImpl
		 * @see algorithme.impl.AlgorithmePackageImpl#getRessource()
		 * @generated
		 */
		EClass RESSOURCE = eINSTANCE.getRessource();

		/**
		 * The meta object literal for the '<em><b>File</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute RESSOURCE__FILE = eINSTANCE.getRessource_File();

		/**
		 * The meta object literal for the '<em><b>Stdin</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference RESSOURCE__STDIN = eINSTANCE.getRessource_Stdin();

		/**
		 * The meta object literal for the '<em><b>Stdout</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference RESSOURCE__STDOUT = eINSTANCE.getRessource_Stdout();

		/**
		 * The meta object literal for the '{@link algorithme.impl.DocumentationImpl <em>Documentation</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see algorithme.impl.DocumentationImpl
		 * @see algorithme.impl.AlgorithmePackageImpl#getDocumentation()
		 * @generated
		 */
		EClass DOCUMENTATION = eINSTANCE.getDocumentation();

		/**
		 * The meta object literal for the '<em><b>Description</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DOCUMENTATION__DESCRIPTION = eINSTANCE.getDocumentation_Description();

	}

} //AlgorithmePackage
