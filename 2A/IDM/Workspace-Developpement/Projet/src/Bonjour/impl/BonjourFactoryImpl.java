/**
 */
package Bonjour.impl;

import Bonjour.*;

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
public class BonjourFactoryImpl extends EFactoryImpl implements BonjourFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static BonjourFactory init() {
		try {
			BonjourFactory theBonjourFactory = (BonjourFactory)EPackage.Registry.INSTANCE.getEFactory(BonjourPackage.eNS_URI);
			if (theBonjourFactory != null) {
				return theBonjourFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new BonjourFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public BonjourFactoryImpl() {
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
			case BonjourPackage.CONNARD: return createconnard();
			case BonjourPackage.FDP: return createfdp();
			case BonjourPackage.ENCULE: return createencule();
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
	public connard createconnard() {
		connardImpl connard = new connardImpl();
		return connard;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public fdp createfdp() {
		fdpImpl fdp = new fdpImpl();
		return fdp;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public encule createencule() {
		enculeImpl encule = new enculeImpl();
		return encule;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public BonjourPackage getBonjourPackage() {
		return (BonjourPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static BonjourPackage getPackage() {
		return BonjourPackage.eINSTANCE;
	}

} //BonjourFactoryImpl
