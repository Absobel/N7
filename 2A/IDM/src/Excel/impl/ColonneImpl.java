/**
 */
package Excel.impl;

import Excel.Colonne;
import Excel.ExcelPackage;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Colonne</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link Excel.impl.ColonneImpl#getIdentifiant <em>Identifiant</em>}</li>
 * </ul>
 *
 * @generated
 */
public abstract class ColonneImpl extends DataImpl implements Colonne {
	/**
	 * The default value of the '{@link #getIdentifiant() <em>Identifiant</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getIdentifiant()
	 * @generated
	 * @ordered
	 */
	protected static final int IDENTIFIANT_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getIdentifiant() <em>Identifiant</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getIdentifiant()
	 * @generated
	 * @ordered
	 */
	protected int identifiant = IDENTIFIANT_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ColonneImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ExcelPackage.Literals.COLONNE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getIdentifiant() {
		return identifiant;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setIdentifiant(int newIdentifiant) {
		int oldIdentifiant = identifiant;
		identifiant = newIdentifiant;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ExcelPackage.COLONNE__IDENTIFIANT, oldIdentifiant, identifiant));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case ExcelPackage.COLONNE__IDENTIFIANT:
				return getIdentifiant();
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
			case ExcelPackage.COLONNE__IDENTIFIANT:
				setIdentifiant((Integer)newValue);
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
			case ExcelPackage.COLONNE__IDENTIFIANT:
				setIdentifiant(IDENTIFIANT_EDEFAULT);
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
			case ExcelPackage.COLONNE__IDENTIFIANT:
				return identifiant != IDENTIFIANT_EDEFAULT;
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
		result.append(" (Identifiant: ");
		result.append(identifiant);
		result.append(')');
		return result.toString();
	}

} //ColonneImpl
