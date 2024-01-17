/**
 */
package tableur.impl;

import algorithme.Catalogue;

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

import tableur.Table;
import tableur.Tableur;
import tableur.TableurPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Tableur</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link tableur.impl.TableurImpl#getName <em>Name</em>}</li>
 *   <li>{@link tableur.impl.TableurImpl#getTable <em>Table</em>}</li>
 *   <li>{@link tableur.impl.TableurImpl#getCatalogues <em>Catalogues</em>}</li>
 * </ul>
 *
 * @generated
 */
public class TableurImpl extends MinimalEObjectImpl.Container implements Tableur {
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
	 * The cached value of the '{@link #getTable() <em>Table</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTable()
	 * @generated
	 * @ordered
	 */
	protected EList<Table> table;

	/**
	 * The cached value of the '{@link #getCatalogues() <em>Catalogues</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCatalogues()
	 * @generated
	 * @ordered
	 */
	protected EList<Catalogue> catalogues;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected TableurImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return TableurPackage.Literals.TABLEUR;
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
			eNotify(new ENotificationImpl(this, Notification.SET, TableurPackage.TABLEUR__NAME, oldName, name));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<Table> getTable() {
		if (table == null) {
			table = new EObjectContainmentEList<Table>(Table.class, this, TableurPackage.TABLEUR__TABLE);
		}
		return table;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<Catalogue> getCatalogues() {
		if (catalogues == null) {
			catalogues = new EObjectContainmentEList<Catalogue>(Catalogue.class, this,
					TableurPackage.TABLEUR__CATALOGUES);
		}
		return catalogues;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
		case TableurPackage.TABLEUR__TABLE:
			return ((InternalEList<?>) getTable()).basicRemove(otherEnd, msgs);
		case TableurPackage.TABLEUR__CATALOGUES:
			return ((InternalEList<?>) getCatalogues()).basicRemove(otherEnd, msgs);
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
		case TableurPackage.TABLEUR__NAME:
			return getName();
		case TableurPackage.TABLEUR__TABLE:
			return getTable();
		case TableurPackage.TABLEUR__CATALOGUES:
			return getCatalogues();
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
		case TableurPackage.TABLEUR__NAME:
			setName((String) newValue);
			return;
		case TableurPackage.TABLEUR__TABLE:
			getTable().clear();
			getTable().addAll((Collection<? extends Table>) newValue);
			return;
		case TableurPackage.TABLEUR__CATALOGUES:
			getCatalogues().clear();
			getCatalogues().addAll((Collection<? extends Catalogue>) newValue);
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
		case TableurPackage.TABLEUR__NAME:
			setName(NAME_EDEFAULT);
			return;
		case TableurPackage.TABLEUR__TABLE:
			getTable().clear();
			return;
		case TableurPackage.TABLEUR__CATALOGUES:
			getCatalogues().clear();
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
		case TableurPackage.TABLEUR__NAME:
			return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
		case TableurPackage.TABLEUR__TABLE:
			return table != null && !table.isEmpty();
		case TableurPackage.TABLEUR__CATALOGUES:
			return catalogues != null && !catalogues.isEmpty();
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

} //TableurImpl
