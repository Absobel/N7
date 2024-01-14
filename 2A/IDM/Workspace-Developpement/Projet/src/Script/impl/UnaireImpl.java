/**
 */
package Script.impl;

import Script.FonctionsType;
import Script.ScriptPackage;
import Script.Unaire;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Unaire</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link Script.impl.UnaireImpl#getFonctions <em>Fonctions</em>}</li>
 * </ul>
 *
 * @generated
 */
public class UnaireImpl extends OperationsImpl implements Unaire {
	/**
	 * The default value of the '{@link #getFonctions() <em>Fonctions</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFonctions()
	 * @generated
	 * @ordered
	 */
	protected static final FonctionsType FONCTIONS_EDEFAULT = FonctionsType.OPP;

	/**
	 * The cached value of the '{@link #getFonctions() <em>Fonctions</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFonctions()
	 * @generated
	 * @ordered
	 */
	protected FonctionsType fonctions = FONCTIONS_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected UnaireImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ScriptPackage.Literals.UNAIRE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public FonctionsType getFonctions() {
		return fonctions;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setFonctions(FonctionsType newFonctions) {
		FonctionsType oldFonctions = fonctions;
		fonctions = newFonctions == null ? FONCTIONS_EDEFAULT : newFonctions;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ScriptPackage.UNAIRE__FONCTIONS, oldFonctions, fonctions));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case ScriptPackage.UNAIRE__FONCTIONS:
				return getFonctions();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case ScriptPackage.UNAIRE__FONCTIONS:
				setFonctions((FonctionsType)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case ScriptPackage.UNAIRE__FONCTIONS:
				setFonctions(FONCTIONS_EDEFAULT);
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case ScriptPackage.UNAIRE__FONCTIONS:
				return fonctions != FONCTIONS_EDEFAULT;
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuilder result = new StringBuilder(super.toString());
		result.append(" (fonctions: ");
		result.append(fonctions);
		result.append(')');
		return result.toString();
	}

} //UnaireImpl
