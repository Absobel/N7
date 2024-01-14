/**
 */
package Script.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.ENotificationImpl;

import Script.Binaire;
import Script.OperationsBinairesType;
import Script.ScriptPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Binaire</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link Script.impl.BinaireImpl#getOperateur <em>Operateur</em>}</li>
 * </ul>
 *
 * @generated
 */
public class BinaireImpl extends OperationsImpl implements Binaire {
	/**
	 * The default value of the '{@link #getOperateur() <em>Operateur</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOperateur()
	 * @generated
	 * @ordered
	 */
	protected static final OperationsBinairesType OPERATEUR_EDEFAULT = OperationsBinairesType.ADD;

	/**
	 * The cached value of the '{@link #getOperateur() <em>Operateur</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOperateur()
	 * @generated
	 * @ordered
	 */
	protected OperationsBinairesType operateur = OPERATEUR_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected BinaireImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ScriptPackage.Literals.BINAIRE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public OperationsBinairesType getOperateur() {
		return operateur;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setOperateur(OperationsBinairesType newOperateur) {
		OperationsBinairesType oldOperateur = operateur;
		operateur = newOperateur == null ? OPERATEUR_EDEFAULT : newOperateur;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ScriptPackage.BINAIRE__OPERATEUR, oldOperateur, operateur));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case ScriptPackage.BINAIRE__OPERATEUR:
				return getOperateur();
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
			case ScriptPackage.BINAIRE__OPERATEUR:
				setOperateur((OperationsBinairesType)newValue);
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
			case ScriptPackage.BINAIRE__OPERATEUR:
				setOperateur(OPERATEUR_EDEFAULT);
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
			case ScriptPackage.BINAIRE__OPERATEUR:
				return operateur != OPERATEUR_EDEFAULT;
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
		result.append(" (operateur: ");
		result.append(operateur);
		result.append(')');
		return result.toString();
	}

} //BinaireImpl
