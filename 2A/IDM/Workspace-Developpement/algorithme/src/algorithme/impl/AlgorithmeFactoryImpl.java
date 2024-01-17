/**
 */
package algorithme.impl;

import algorithme.*;

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
public class AlgorithmeFactoryImpl extends EFactoryImpl implements AlgorithmeFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static AlgorithmeFactory init() {
		try {
			AlgorithmeFactory theAlgorithmeFactory = (AlgorithmeFactory) EPackage.Registry.INSTANCE
					.getEFactory(AlgorithmePackage.eNS_URI);
			if (theAlgorithmeFactory != null) {
				return theAlgorithmeFactory;
			}
		} catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new AlgorithmeFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AlgorithmeFactoryImpl() {
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
		case AlgorithmePackage.CATALOGUE:
			return createCatalogue();
		case AlgorithmePackage.ALGORITHME_ELEMENT:
			return createAlgorithmeElement();
		case AlgorithmePackage.ALGORITHME:
			return createAlgorithme();
		case AlgorithmePackage.RESSOURCE:
			return createRessource();
		case AlgorithmePackage.DOCUMENTATION:
			return createDocumentation();
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
	public Catalogue createCatalogue() {
		CatalogueImpl catalogue = new CatalogueImpl();
		return catalogue;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public AlgorithmeElement createAlgorithmeElement() {
		AlgorithmeElementImpl algorithmeElement = new AlgorithmeElementImpl();
		return algorithmeElement;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Algorithme createAlgorithme() {
		AlgorithmeImpl algorithme = new AlgorithmeImpl();
		return algorithme;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Ressource createRessource() {
		RessourceImpl ressource = new RessourceImpl();
		return ressource;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Documentation createDocumentation() {
		DocumentationImpl documentation = new DocumentationImpl();
		return documentation;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public AlgorithmePackage getAlgorithmePackage() {
		return (AlgorithmePackage) getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static AlgorithmePackage getPackage() {
		return AlgorithmePackage.eINSTANCE;
	}

} //AlgorithmeFactoryImpl
