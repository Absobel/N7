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
import org.eclipse.emf.ecore.util.EObjectResolvingEList;
import org.eclipse.emf.ecore.util.InternalEList;

import script.Blocs;
import script.Data;
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
 *   <li>{@link script.impl.ScriptImpl#getBlocs <em>Blocs</em>}</li>
 *   <li>{@link script.impl.ScriptImpl#getNitialInput <em>Nitial Input</em>}</li>
 *   <li>{@link script.impl.ScriptImpl#getFinalOutput <em>Final Output</em>}</li>
 *   <li>{@link script.impl.ScriptImpl#getName <em>Name</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ScriptImpl extends MinimalEObjectImpl.Container implements Script {
	/**
	 * The cached value of the '{@link #getBlocs() <em>Blocs</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBlocs()
	 * @generated
	 * @ordered
	 */
	protected EList<Blocs> blocs;

	/**
	 * The cached value of the '{@link #getNitialInput() <em>Nitial Input</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getNitialInput()
	 * @generated
	 * @ordered
	 */
	protected EList<Data> nitialInput;

	/**
	 * The cached value of the '{@link #getFinalOutput() <em>Final Output</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFinalOutput()
	 * @generated
	 * @ordered
	 */
	protected EList<Data> finalOutput;

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
	public EList<Blocs> getBlocs() {
		if (blocs == null) {
			blocs = new EObjectContainmentEList<Blocs>(Blocs.class, this, ScriptPackage.SCRIPT__BLOCS);
		}
		return blocs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<Data> getNitialInput() {
		if (nitialInput == null) {
			nitialInput = new EObjectContainmentEList<Data>(Data.class, this, ScriptPackage.SCRIPT__NITIAL_INPUT);
		}
		return nitialInput;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<Data> getFinalOutput() {
		if (finalOutput == null) {
			finalOutput = new EObjectResolvingEList<Data>(Data.class, this, ScriptPackage.SCRIPT__FINAL_OUTPUT);
		}
		return finalOutput;
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
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case ScriptPackage.SCRIPT__BLOCS:
				return ((InternalEList<?>)getBlocs()).basicRemove(otherEnd, msgs);
			case ScriptPackage.SCRIPT__NITIAL_INPUT:
				return ((InternalEList<?>)getNitialInput()).basicRemove(otherEnd, msgs);
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
			case ScriptPackage.SCRIPT__BLOCS:
				return getBlocs();
			case ScriptPackage.SCRIPT__NITIAL_INPUT:
				return getNitialInput();
			case ScriptPackage.SCRIPT__FINAL_OUTPUT:
				return getFinalOutput();
			case ScriptPackage.SCRIPT__NAME:
				return getName();
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
			case ScriptPackage.SCRIPT__BLOCS:
				getBlocs().clear();
				getBlocs().addAll((Collection<? extends Blocs>)newValue);
				return;
			case ScriptPackage.SCRIPT__NITIAL_INPUT:
				getNitialInput().clear();
				getNitialInput().addAll((Collection<? extends Data>)newValue);
				return;
			case ScriptPackage.SCRIPT__FINAL_OUTPUT:
				getFinalOutput().clear();
				getFinalOutput().addAll((Collection<? extends Data>)newValue);
				return;
			case ScriptPackage.SCRIPT__NAME:
				setName((String)newValue);
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
			case ScriptPackage.SCRIPT__BLOCS:
				getBlocs().clear();
				return;
			case ScriptPackage.SCRIPT__NITIAL_INPUT:
				getNitialInput().clear();
				return;
			case ScriptPackage.SCRIPT__FINAL_OUTPUT:
				getFinalOutput().clear();
				return;
			case ScriptPackage.SCRIPT__NAME:
				setName(NAME_EDEFAULT);
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
			case ScriptPackage.SCRIPT__BLOCS:
				return blocs != null && !blocs.isEmpty();
			case ScriptPackage.SCRIPT__NITIAL_INPUT:
				return nitialInput != null && !nitialInput.isEmpty();
			case ScriptPackage.SCRIPT__FINAL_OUTPUT:
				return finalOutput != null && !finalOutput.isEmpty();
			case ScriptPackage.SCRIPT__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
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
		result.append(" (name: ");
		result.append(name);
		result.append(')');
		return result.toString();
	}

} //ScriptImpl
