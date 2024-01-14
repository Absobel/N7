/**
 */
package Excelbis.impl;

import Excelbis.Data;
import Excelbis.ExcelbisPackage;
import Excelbis.OperationsBinaires;

import java.util.Collection;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.util.EObjectResolvingEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Operations Binaires</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link Excelbis.impl.OperationsBinairesImpl#getDatas <em>Datas</em>}</li>
 * </ul>
 *
 * @generated
 */
public class OperationsBinairesImpl extends OperationsImpl implements OperationsBinaires {
	/**
	 * The cached value of the '{@link #getDatas() <em>Datas</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDatas()
	 * @generated
	 * @ordered
	 */
	protected EList<Data> datas;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected OperationsBinairesImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ExcelbisPackage.Literals.OPERATIONS_BINAIRES;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<Data> getDatas() {
		if (datas == null) {
			datas = new EObjectResolvingEList<Data>(Data.class, this, ExcelbisPackage.OPERATIONS_BINAIRES__DATAS);
		}
		return datas;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case ExcelbisPackage.OPERATIONS_BINAIRES__DATAS:
				return getDatas();
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
			case ExcelbisPackage.OPERATIONS_BINAIRES__DATAS:
				getDatas().clear();
				getDatas().addAll((Collection<? extends Data>)newValue);
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
			case ExcelbisPackage.OPERATIONS_BINAIRES__DATAS:
				getDatas().clear();
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
			case ExcelbisPackage.OPERATIONS_BINAIRES__DATAS:
				return datas != null && !datas.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //OperationsBinairesImpl
