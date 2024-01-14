/**
 */
package Bonjour.impl;

import Bonjour.BonjourPackage;
import Bonjour.connard;
import Bonjour.fdp;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>fdp</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link Bonjour.impl.fdpImpl#getVfjdo <em>Vfjdo</em>}</li>
 *   <li>{@link Bonjour.impl.fdpImpl#getConnard <em>Connard</em>}</li>
 * </ul>
 *
 * @generated
 */
public class fdpImpl extends MinimalEObjectImpl.Container implements fdp {
	/**
	 * The default value of the '{@link #getVfjdo() <em>Vfjdo</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getVfjdo()
	 * @generated
	 * @ordered
	 */
	protected static final String VFJDO_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getVfjdo() <em>Vfjdo</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getVfjdo()
	 * @generated
	 * @ordered
	 */
	protected String vfjdo = VFJDO_EDEFAULT;

	/**
	 * The cached value of the '{@link #getConnard() <em>Connard</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getConnard()
	 * @generated
	 * @ordered
	 */
	protected connard connard;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected fdpImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return BonjourPackage.Literals.FDP;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getVfjdo() {
		return vfjdo;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setVfjdo(String newVfjdo) {
		String oldVfjdo = vfjdo;
		vfjdo = newVfjdo;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, BonjourPackage.FDP__VFJDO, oldVfjdo, vfjdo));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public connard getConnard() {
		if (connard != null && connard.eIsProxy()) {
			InternalEObject oldConnard = (InternalEObject)connard;
			connard = (connard)eResolveProxy(oldConnard);
			if (connard != oldConnard) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, BonjourPackage.FDP__CONNARD, oldConnard, connard));
			}
		}
		return connard;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public connard basicGetConnard() {
		return connard;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setConnard(connard newConnard) {
		connard oldConnard = connard;
		connard = newConnard;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, BonjourPackage.FDP__CONNARD, oldConnard, connard));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case BonjourPackage.FDP__VFJDO:
				return getVfjdo();
			case BonjourPackage.FDP__CONNARD:
				if (resolve) return getConnard();
				return basicGetConnard();
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
			case BonjourPackage.FDP__VFJDO:
				setVfjdo((String)newValue);
				return;
			case BonjourPackage.FDP__CONNARD:
				setConnard((connard)newValue);
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
			case BonjourPackage.FDP__VFJDO:
				setVfjdo(VFJDO_EDEFAULT);
				return;
			case BonjourPackage.FDP__CONNARD:
				setConnard((connard)null);
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
			case BonjourPackage.FDP__VFJDO:
				return VFJDO_EDEFAULT == null ? vfjdo != null : !VFJDO_EDEFAULT.equals(vfjdo);
			case BonjourPackage.FDP__CONNARD:
				return connard != null;
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
		result.append(" (vfjdo: ");
		result.append(vfjdo);
		result.append(')');
		return result.toString();
	}

} //fdpImpl
