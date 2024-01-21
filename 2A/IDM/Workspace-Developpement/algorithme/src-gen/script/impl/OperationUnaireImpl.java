/**
 */
package script.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import script.FonctionType;
import script.OperationUnaire;
import script.Output;
import script.ScriptPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Operation Unaire</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link script.impl.OperationUnaireImpl#getFonction <em>Fonction</em>}</li>
 *   <li>{@link script.impl.OperationUnaireImpl#getOutput <em>Output</em>}</li>
 * </ul>
 *
 * @generated
 */
public class OperationUnaireImpl extends OperationImpl implements OperationUnaire {
	/**
	 * The default value of the '{@link #getFonction() <em>Fonction</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFonction()
	 * @generated
	 * @ordered
	 */
	protected static final FonctionType FONCTION_EDEFAULT = FonctionType.OPP;

	/**
	 * The cached value of the '{@link #getFonction() <em>Fonction</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFonction()
	 * @generated
	 * @ordered
	 */
	protected FonctionType fonction = FONCTION_EDEFAULT;

	/**
	 * The cached value of the '{@link #getOutput() <em>Output</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOutput()
	 * @generated
	 * @ordered
	 */
	protected Output output;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected OperationUnaireImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ScriptPackage.Literals.OPERATION_UNAIRE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public FonctionType getFonction() {
		return fonction;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setFonction(FonctionType newFonction) {
		FonctionType oldFonction = fonction;
		fonction = newFonction == null ? FONCTION_EDEFAULT : newFonction;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ScriptPackage.OPERATION_UNAIRE__FONCTION, oldFonction,
					fonction));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Output getOutput() {
		return output;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetOutput(Output newOutput, NotificationChain msgs) {
		Output oldOutput = output;
		output = newOutput;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET,
					ScriptPackage.OPERATION_UNAIRE__OUTPUT, oldOutput, newOutput);
			if (msgs == null)
				msgs = notification;
			else
				msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setOutput(Output newOutput) {
		if (newOutput != output) {
			NotificationChain msgs = null;
			if (output != null)
				msgs = ((InternalEObject) output).eInverseRemove(this,
						EOPPOSITE_FEATURE_BASE - ScriptPackage.OPERATION_UNAIRE__OUTPUT, null, msgs);
			if (newOutput != null)
				msgs = ((InternalEObject) newOutput).eInverseAdd(this,
						EOPPOSITE_FEATURE_BASE - ScriptPackage.OPERATION_UNAIRE__OUTPUT, null, msgs);
			msgs = basicSetOutput(newOutput, msgs);
			if (msgs != null)
				msgs.dispatch();
		} else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ScriptPackage.OPERATION_UNAIRE__OUTPUT, newOutput,
					newOutput));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
		case ScriptPackage.OPERATION_UNAIRE__OUTPUT:
			return basicSetOutput(null, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
		case ScriptPackage.OPERATION_UNAIRE__FONCTION:
			return getFonction();
		case ScriptPackage.OPERATION_UNAIRE__OUTPUT:
			return getOutput();
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
		case ScriptPackage.OPERATION_UNAIRE__FONCTION:
			setFonction((FonctionType) newValue);
			return;
		case ScriptPackage.OPERATION_UNAIRE__OUTPUT:
			setOutput((Output) newValue);
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
		case ScriptPackage.OPERATION_UNAIRE__FONCTION:
			setFonction(FONCTION_EDEFAULT);
			return;
		case ScriptPackage.OPERATION_UNAIRE__OUTPUT:
			setOutput((Output) null);
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
		case ScriptPackage.OPERATION_UNAIRE__FONCTION:
			return fonction != FONCTION_EDEFAULT;
		case ScriptPackage.OPERATION_UNAIRE__OUTPUT:
			return output != null;
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
		if (eIsProxy())
			return super.toString();

		StringBuilder result = new StringBuilder(super.toString());
		result.append(" (fonction: ");
		result.append(fonction);
		result.append(')');
		return result.toString();
	}

} //OperationUnaireImpl
