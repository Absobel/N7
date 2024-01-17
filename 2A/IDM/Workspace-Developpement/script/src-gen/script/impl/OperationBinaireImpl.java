/**
 */
package script.impl;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import script.Inputs;
import script.OperationBinaire;
import script.OperationBinaireType;
import script.Output;
import script.ScriptPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Operation Binaire</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link script.impl.OperationBinaireImpl#getOperateur <em>Operateur</em>}</li>
 *   <li>{@link script.impl.OperationBinaireImpl#getOutput <em>Output</em>}</li>
 *   <li>{@link script.impl.OperationBinaireImpl#getInput1 <em>Input1</em>}</li>
 *   <li>{@link script.impl.OperationBinaireImpl#getInput2 <em>Input2</em>}</li>
 * </ul>
 *
 * @generated
 */
public class OperationBinaireImpl extends OperationImpl implements OperationBinaire {
	/**
	 * The default value of the '{@link #getOperateur() <em>Operateur</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOperateur()
	 * @generated
	 * @ordered
	 */
	protected static final OperationBinaireType OPERATEUR_EDEFAULT = OperationBinaireType.ADD;

	/**
	 * The cached value of the '{@link #getOperateur() <em>Operateur</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOperateur()
	 * @generated
	 * @ordered
	 */
	protected OperationBinaireType operateur = OPERATEUR_EDEFAULT;

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
	 * The cached value of the '{@link #getInput1() <em>Input1</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInput1()
	 * @generated
	 * @ordered
	 */
	protected Inputs input1;

	/**
	 * The cached value of the '{@link #getInput2() <em>Input2</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInput2()
	 * @generated
	 * @ordered
	 */
	protected Inputs input2;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected OperationBinaireImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ScriptPackage.Literals.OPERATION_BINAIRE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public OperationBinaireType getOperateur() {
		return operateur;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setOperateur(OperationBinaireType newOperateur) {
		OperationBinaireType oldOperateur = operateur;
		operateur = newOperateur == null ? OPERATEUR_EDEFAULT : newOperateur;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ScriptPackage.OPERATION_BINAIRE__OPERATEUR,
					oldOperateur, operateur));
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
					ScriptPackage.OPERATION_BINAIRE__OUTPUT, oldOutput, newOutput);
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
						EOPPOSITE_FEATURE_BASE - ScriptPackage.OPERATION_BINAIRE__OUTPUT, null, msgs);
			if (newOutput != null)
				msgs = ((InternalEObject) newOutput).eInverseAdd(this,
						EOPPOSITE_FEATURE_BASE - ScriptPackage.OPERATION_BINAIRE__OUTPUT, null, msgs);
			msgs = basicSetOutput(newOutput, msgs);
			if (msgs != null)
				msgs.dispatch();
		} else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ScriptPackage.OPERATION_BINAIRE__OUTPUT, newOutput,
					newOutput));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Inputs getInput1() {
		if (input1 != null && input1.eIsProxy()) {
			InternalEObject oldInput1 = (InternalEObject) input1;
			input1 = (Inputs) eResolveProxy(oldInput1);
			if (input1 != oldInput1) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, ScriptPackage.OPERATION_BINAIRE__INPUT1,
							oldInput1, input1));
			}
		}
		return input1;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Inputs basicGetInput1() {
		return input1;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setInput1(Inputs newInput1) {
		Inputs oldInput1 = input1;
		input1 = newInput1;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ScriptPackage.OPERATION_BINAIRE__INPUT1, oldInput1,
					input1));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Inputs getInput2() {
		if (input2 != null && input2.eIsProxy()) {
			InternalEObject oldInput2 = (InternalEObject) input2;
			input2 = (Inputs) eResolveProxy(oldInput2);
			if (input2 != oldInput2) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, ScriptPackage.OPERATION_BINAIRE__INPUT2,
							oldInput2, input2));
			}
		}
		return input2;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Inputs basicGetInput2() {
		return input2;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setInput2(Inputs newInput2) {
		Inputs oldInput2 = input2;
		input2 = newInput2;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ScriptPackage.OPERATION_BINAIRE__INPUT2, oldInput2,
					input2));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
		case ScriptPackage.OPERATION_BINAIRE__OUTPUT:
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
		case ScriptPackage.OPERATION_BINAIRE__OPERATEUR:
			return getOperateur();
		case ScriptPackage.OPERATION_BINAIRE__OUTPUT:
			return getOutput();
		case ScriptPackage.OPERATION_BINAIRE__INPUT1:
			if (resolve)
				return getInput1();
			return basicGetInput1();
		case ScriptPackage.OPERATION_BINAIRE__INPUT2:
			if (resolve)
				return getInput2();
			return basicGetInput2();
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
		case ScriptPackage.OPERATION_BINAIRE__OPERATEUR:
			setOperateur((OperationBinaireType) newValue);
			return;
		case ScriptPackage.OPERATION_BINAIRE__OUTPUT:
			setOutput((Output) newValue);
			return;
		case ScriptPackage.OPERATION_BINAIRE__INPUT1:
			setInput1((Inputs) newValue);
			return;
		case ScriptPackage.OPERATION_BINAIRE__INPUT2:
			setInput2((Inputs) newValue);
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
		case ScriptPackage.OPERATION_BINAIRE__OPERATEUR:
			setOperateur(OPERATEUR_EDEFAULT);
			return;
		case ScriptPackage.OPERATION_BINAIRE__OUTPUT:
			setOutput((Output) null);
			return;
		case ScriptPackage.OPERATION_BINAIRE__INPUT1:
			setInput1((Inputs) null);
			return;
		case ScriptPackage.OPERATION_BINAIRE__INPUT2:
			setInput2((Inputs) null);
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
		case ScriptPackage.OPERATION_BINAIRE__OPERATEUR:
			return operateur != OPERATEUR_EDEFAULT;
		case ScriptPackage.OPERATION_BINAIRE__OUTPUT:
			return output != null;
		case ScriptPackage.OPERATION_BINAIRE__INPUT1:
			return input1 != null;
		case ScriptPackage.OPERATION_BINAIRE__INPUT2:
			return input2 != null;
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
		result.append(" (operateur: ");
		result.append(operateur);
		result.append(')');
		return result.toString();
	}

} //OperationBinaireImpl
