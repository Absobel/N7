/**
 */
package catalogue.impl;

import catalogue.CataloguePackage;
import catalogue.Ressource;
import catalogue.Stdin;
import catalogue.Stdout;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EObjectResolvingEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Ressource</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link catalogue.impl.RessourceImpl#getStdout <em>Stdout</em>}</li>
 *   <li>{@link catalogue.impl.RessourceImpl#getStdin <em>Stdin</em>}</li>
 *   <li>{@link catalogue.impl.RessourceImpl#getFile <em>File</em>}</li>
 * </ul>
 *
 * @generated
 */
public class RessourceImpl extends AlgorithmeElementImpl implements Ressource {
	/**
	 * The cached value of the '{@link #getStdout() <em>Stdout</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getStdout()
	 * @generated
	 * @ordered
	 */
	protected EList<Stdout> stdout;

	/**
	 * The cached value of the '{@link #getStdin() <em>Stdin</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getStdin()
	 * @generated
	 * @ordered
	 */
	protected EList<Stdin> stdin;

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
		return CataloguePackage.Literals.RESSOURCE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<Stdout> getStdout() {
		if (stdout == null) {
			stdout = new EObjectResolvingEList<Stdout>(Stdout.class, this, CataloguePackage.RESSOURCE__STDOUT);
		}
		return stdout;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<Stdin> getStdin() {
		if (stdin == null) {
			stdin = new EObjectResolvingEList<Stdin>(Stdin.class, this, CataloguePackage.RESSOURCE__STDIN);
		}
		return stdin;
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
			eNotify(new ENotificationImpl(this, Notification.SET, CataloguePackage.RESSOURCE__FILE, oldFile, file));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case CataloguePackage.RESSOURCE__STDOUT:
				return getStdout();
			case CataloguePackage.RESSOURCE__STDIN:
				return getStdin();
			case CataloguePackage.RESSOURCE__FILE:
				return getFile();
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
			case CataloguePackage.RESSOURCE__STDOUT:
				getStdout().clear();
				getStdout().addAll((Collection<? extends Stdout>)newValue);
				return;
			case CataloguePackage.RESSOURCE__STDIN:
				getStdin().clear();
				getStdin().addAll((Collection<? extends Stdin>)newValue);
				return;
			case CataloguePackage.RESSOURCE__FILE:
				setFile((String)newValue);
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
			case CataloguePackage.RESSOURCE__STDOUT:
				getStdout().clear();
				return;
			case CataloguePackage.RESSOURCE__STDIN:
				getStdin().clear();
				return;
			case CataloguePackage.RESSOURCE__FILE:
				setFile(FILE_EDEFAULT);
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
			case CataloguePackage.RESSOURCE__STDOUT:
				return stdout != null && !stdout.isEmpty();
			case CataloguePackage.RESSOURCE__STDIN:
				return stdin != null && !stdin.isEmpty();
			case CataloguePackage.RESSOURCE__FILE:
				return FILE_EDEFAULT == null ? file != null : !FILE_EDEFAULT.equals(file);
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
		result.append(" (file: ");
		result.append(file);
		result.append(')');
		return result.toString();
	}

} //RessourceImpl
