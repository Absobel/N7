/**
 */
package script.impl;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import script.Fonctions;
import script.ScriptPackage;
import script.Unaire;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Unaire</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link script.impl.UnaireImpl#getFonctions <em>Fonctions</em>}</li>
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
	protected static final Fonctions FONCTIONS_EDEFAULT = Fonctions.OPP;

	/**
	 * The cached value of the '{@link #getFonctions() <em>Fonctions</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFonctions()
	 * @generated
	 * @ordered
	 */
	protected Fonctions fonctions = FONCTIONS_EDEFAULT;

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
	public Fonctions getFonctions() {
		return fonctions;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setFonctions(Fonctions newFonctions) {
		Fonctions oldFonctions = fonctions;
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
				setFonctions((Fonctions)newValue);
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
		result.append(" (Fonctions: ");
		result.append(fonctions);
		result.append(')');
		return result.toString();
	}

} //UnaireImpl
