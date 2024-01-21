/**
 */
package script.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

import script.Operation;
import script.Output;
import script.RealInputs;
import script.Script;
import script.ScriptPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Script</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link script.impl.ScriptImpl#getName <em>Name</em>}</li>
 *   <li>{@link script.impl.ScriptImpl#getInitialInputs <em>Initial Inputs</em>}</li>
 *   <li>{@link script.impl.ScriptImpl#getOperation <em>Operation</em>}</li>
 *   <li>{@link script.impl.ScriptImpl#getFinalOutputs <em>Final Outputs</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ScriptImpl extends MinimalEObjectImpl.Container implements Script {
	/**
	 * The default value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected static final String NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected String name = NAME_EDEFAULT;

	/**
	 * The cached value of the '{@link #getInitialInputs() <em>Initial Inputs</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInitialInputs()
	 * @generated
	 * @ordered
	 */
	protected EList<RealInputs> initialInputs;

	/**
	 * The cached value of the '{@link #getOperation() <em>Operation</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOperation()
	 * @generated
	 * @ordered
	 */
	protected EList<Operation> operation;

	/**
	 * The cached value of the '{@link #getFinalOutputs() <em>Final Outputs</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFinalOutputs()
	 * @generated
	 * @ordered
	 */
	protected EList<Output> finalOutputs;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ScriptImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ScriptPackage.Literals.SCRIPT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getName() {
		return name;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setName(String newName) {
		String oldName = name;
		name = newName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ScriptPackage.SCRIPT__NAME, oldName, name));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<RealInputs> getInitialInputs() {
		if (initialInputs == null) {
			initialInputs = new EObjectContainmentEList<RealInputs>(RealInputs.class, this,
					ScriptPackage.SCRIPT__INITIAL_INPUTS);
		}
		return initialInputs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<Operation> getOperation() {
		if (operation == null) {
			operation = new EObjectContainmentEList<Operation>(Operation.class, this, ScriptPackage.SCRIPT__OPERATION);
		}
		return operation;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<Output> getFinalOutputs() {
		if (finalOutputs == null) {
			finalOutputs = new EObjectContainmentEList<Output>(Output.class, this, ScriptPackage.SCRIPT__FINAL_OUTPUTS);
		}
		return finalOutputs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
		case ScriptPackage.SCRIPT__INITIAL_INPUTS:
			return ((InternalEList<?>) getInitialInputs()).basicRemove(otherEnd, msgs);
		case ScriptPackage.SCRIPT__OPERATION:
			return ((InternalEList<?>) getOperation()).basicRemove(otherEnd, msgs);
		case ScriptPackage.SCRIPT__FINAL_OUTPUTS:
			return ((InternalEList<?>) getFinalOutputs()).basicRemove(otherEnd, msgs);
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
		case ScriptPackage.SCRIPT__NAME:
			return getName();
		case ScriptPackage.SCRIPT__INITIAL_INPUTS:
			return getInitialInputs();
		case ScriptPackage.SCRIPT__OPERATION:
			return getOperation();
		case ScriptPackage.SCRIPT__FINAL_OUTPUTS:
			return getFinalOutputs();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
		case ScriptPackage.SCRIPT__NAME:
			setName((String) newValue);
			return;
		case ScriptPackage.SCRIPT__INITIAL_INPUTS:
			getInitialInputs().clear();
			getInitialInputs().addAll((Collection<? extends RealInputs>) newValue);
			return;
		case ScriptPackage.SCRIPT__OPERATION:
			getOperation().clear();
			getOperation().addAll((Collection<? extends Operation>) newValue);
			return;
		case ScriptPackage.SCRIPT__FINAL_OUTPUTS:
			getFinalOutputs().clear();
			getFinalOutputs().addAll((Collection<? extends Output>) newValue);
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
		case ScriptPackage.SCRIPT__NAME:
			setName(NAME_EDEFAULT);
			return;
		case ScriptPackage.SCRIPT__INITIAL_INPUTS:
			getInitialInputs().clear();
			return;
		case ScriptPackage.SCRIPT__OPERATION:
			getOperation().clear();
			return;
		case ScriptPackage.SCRIPT__FINAL_OUTPUTS:
			getFinalOutputs().clear();
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
		case ScriptPackage.SCRIPT__NAME:
			return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
		case ScriptPackage.SCRIPT__INITIAL_INPUTS:
			return initialInputs != null && !initialInputs.isEmpty();
		case ScriptPackage.SCRIPT__OPERATION:
			return operation != null && !operation.isEmpty();
		case ScriptPackage.SCRIPT__FINAL_OUTPUTS:
			return finalOutputs != null && !finalOutputs.isEmpty();
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
		result.append(" (name: ");
		result.append(name);
		result.append(')');
		return result.toString();
	}

} //ScriptImpl
