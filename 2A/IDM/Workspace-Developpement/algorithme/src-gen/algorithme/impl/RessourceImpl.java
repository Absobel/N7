/**
 */
package algorithme.impl;

import algorithme.AlgorithmePackage;
import algorithme.Ressource;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.EObjectResolvingEList;

import script.Script;

import tableur.ColonneInput;
import tableur.ColonneOutput;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Ressource</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link algorithme.impl.RessourceImpl#getFile <em>File</em>}</li>
 *   <li>{@link algorithme.impl.RessourceImpl#getStdin <em>Stdin</em>}</li>
 *   <li>{@link algorithme.impl.RessourceImpl#getStdout <em>Stdout</em>}</li>
 *   <li>{@link algorithme.impl.RessourceImpl#getScript <em>Script</em>}</li>
 * </ul>
 *
 * @generated
 */
public class RessourceImpl extends MinimalEObjectImpl.Container implements Ressource {
	/**
	 * The default value of the '{@link #getFile() <em>File</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFile()
	 * @generated
	 * @ordered
	 */
	protected static final String FILE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getFile() <em>File</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFile()
	 * @generated
	 * @ordered
	 */
	protected String file = FILE_EDEFAULT;

	/**
	 * The cached value of the '{@link #getStdin() <em>Stdin</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getStdin()
	 * @generated
	 * @ordered
	 */
	protected EList<ColonneInput> stdin;

	/**
	 * The cached value of the '{@link #getStdout() <em>Stdout</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getStdout()
	 * @generated
	 * @ordered
	 */
	protected ColonneOutput stdout;

	/**
	 * The cached value of the '{@link #getScript() <em>Script</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getScript()
	 * @generated
	 * @ordered
	 */
	protected Script script;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected RessourceImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return AlgorithmePackage.Literals.RESSOURCE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getFile() {
		return file;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setFile(String newFile) {
		String oldFile = file;
		file = newFile;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, AlgorithmePackage.RESSOURCE__FILE, oldFile, file));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<ColonneInput> getStdin() {
		if (stdin == null) {
			stdin = new EObjectResolvingEList<ColonneInput>(ColonneInput.class, this,
					AlgorithmePackage.RESSOURCE__STDIN);
		}
		return stdin;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public ColonneOutput getStdout() {
		if (stdout != null && stdout.eIsProxy()) {
			InternalEObject oldStdout = (InternalEObject) stdout;
			stdout = (ColonneOutput) eResolveProxy(oldStdout);
			if (stdout != oldStdout) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, AlgorithmePackage.RESSOURCE__STDOUT,
							oldStdout, stdout));
			}
		}
		return stdout;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ColonneOutput basicGetStdout() {
		return stdout;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setStdout(ColonneOutput newStdout) {
		ColonneOutput oldStdout = stdout;
		stdout = newStdout;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, AlgorithmePackage.RESSOURCE__STDOUT, oldStdout,
					stdout));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Script getScript() {
		if (script != null && script.eIsProxy()) {
			InternalEObject oldScript = (InternalEObject) script;
			script = (Script) eResolveProxy(oldScript);
			if (script != oldScript) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, AlgorithmePackage.RESSOURCE__SCRIPT,
							oldScript, script));
			}
		}
		return script;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Script basicGetScript() {
		return script;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setScript(Script newScript) {
		Script oldScript = script;
		script = newScript;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, AlgorithmePackage.RESSOURCE__SCRIPT, oldScript,
					script));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
		case AlgorithmePackage.RESSOURCE__FILE:
			return getFile();
		case AlgorithmePackage.RESSOURCE__STDIN:
			return getStdin();
		case AlgorithmePackage.RESSOURCE__STDOUT:
			if (resolve)
				return getStdout();
			return basicGetStdout();
		case AlgorithmePackage.RESSOURCE__SCRIPT:
			if (resolve)
				return getScript();
			return basicGetScript();
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
		case AlgorithmePackage.RESSOURCE__FILE:
			setFile((String) newValue);
			return;
		case AlgorithmePackage.RESSOURCE__STDIN:
			getStdin().clear();
			getStdin().addAll((Collection<? extends ColonneInput>) newValue);
			return;
		case AlgorithmePackage.RESSOURCE__STDOUT:
			setStdout((ColonneOutput) newValue);
			return;
		case AlgorithmePackage.RESSOURCE__SCRIPT:
			setScript((Script) newValue);
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
		case AlgorithmePackage.RESSOURCE__FILE:
			setFile(FILE_EDEFAULT);
			return;
		case AlgorithmePackage.RESSOURCE__STDIN:
			getStdin().clear();
			return;
		case AlgorithmePackage.RESSOURCE__STDOUT:
			setStdout((ColonneOutput) null);
			return;
		case AlgorithmePackage.RESSOURCE__SCRIPT:
			setScript((Script) null);
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
		case AlgorithmePackage.RESSOURCE__FILE:
			return FILE_EDEFAULT == null ? file != null : !FILE_EDEFAULT.equals(file);
		case AlgorithmePackage.RESSOURCE__STDIN:
			return stdin != null && !stdin.isEmpty();
		case AlgorithmePackage.RESSOURCE__STDOUT:
			return stdout != null;
		case AlgorithmePackage.RESSOURCE__SCRIPT:
			return script != null;
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
		result.append(" (file: ");
		result.append(file);
		result.append(')');
		return result.toString();
	}

} //RessourceImpl
