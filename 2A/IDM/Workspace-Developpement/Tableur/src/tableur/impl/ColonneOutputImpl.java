/**
 */
package tableur.impl;

import algorithme.Algorithme;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EObjectResolvingEList;

import tableur.Colonne;
import tableur.ColonneOutput;
import tableur.Operation;
import tableur.TableurPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Colonne Output</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link tableur.impl.ColonneOutputImpl#getAlgo <em>Algo</em>}</li>
 *   <li>{@link tableur.impl.ColonneOutputImpl#getColonnes <em>Colonnes</em>}</li>
 *   <li>{@link tableur.impl.ColonneOutputImpl#getOperation <em>Operation</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ColonneOutputImpl extends ColonneImpl implements ColonneOutput {
	/**
	 * The cached value of the '{@link #getAlgo() <em>Algo</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAlgo()
	 * @generated
	 * @ordered
	 */
	protected Algorithme algo;

	/**
	 * The cached value of the '{@link #getColonnes() <em>Colonnes</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getColonnes()
	 * @generated
	 * @ordered
	 */
	protected EList<Colonne> colonnes;

	/**
	 * The cached value of the '{@link #getOperation() <em>Operation</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOperation()
	 * @generated
	 * @ordered
	 */
	protected Operation operation;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ColonneOutputImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return TableurPackage.Literals.COLONNE_OUTPUT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Algorithme getAlgo() {
		if (algo != null && algo.eIsProxy()) {
			InternalEObject oldAlgo = (InternalEObject)algo;
			algo = (Algorithme)eResolveProxy(oldAlgo);
			if (algo != oldAlgo) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, TableurPackage.COLONNE_OUTPUT__ALGO, oldAlgo, algo));
			}
		}
		return algo;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Algorithme basicGetAlgo() {
		return algo;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setAlgo(Algorithme newAlgo) {
		Algorithme oldAlgo = algo;
		algo = newAlgo;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TableurPackage.COLONNE_OUTPUT__ALGO, oldAlgo, algo));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<Colonne> getColonnes() {
		if (colonnes == null) {
			colonnes = new EObjectResolvingEList<Colonne>(Colonne.class, this, TableurPackage.COLONNE_OUTPUT__COLONNES);
		}
		return colonnes;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Operation getOperation() {
		return operation;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetOperation(Operation newOperation, NotificationChain msgs) {
		Operation oldOperation = operation;
		operation = newOperation;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, TableurPackage.COLONNE_OUTPUT__OPERATION, oldOperation, newOperation);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setOperation(Operation newOperation) {
		if (newOperation != operation) {
			NotificationChain msgs = null;
			if (operation != null)
				msgs = ((InternalEObject)operation).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - TableurPackage.COLONNE_OUTPUT__OPERATION, null, msgs);
			if (newOperation != null)
				msgs = ((InternalEObject)newOperation).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - TableurPackage.COLONNE_OUTPUT__OPERATION, null, msgs);
			msgs = basicSetOperation(newOperation, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TableurPackage.COLONNE_OUTPUT__OPERATION, newOperation, newOperation));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case TableurPackage.COLONNE_OUTPUT__OPERATION:
				return basicSetOperation(null, msgs);
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
			case TableurPackage.COLONNE_OUTPUT__ALGO:
				if (resolve) return getAlgo();
				return basicGetAlgo();
			case TableurPackage.COLONNE_OUTPUT__COLONNES:
				return getColonnes();
			case TableurPackage.COLONNE_OUTPUT__OPERATION:
				return getOperation();
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
			case TableurPackage.COLONNE_OUTPUT__ALGO:
				setAlgo((Algorithme)newValue);
				return;
			case TableurPackage.COLONNE_OUTPUT__COLONNES:
				getColonnes().clear();
				getColonnes().addAll((Collection<? extends Colonne>)newValue);
				return;
			case TableurPackage.COLONNE_OUTPUT__OPERATION:
				setOperation((Operation)newValue);
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
			case TableurPackage.COLONNE_OUTPUT__ALGO:
				setAlgo((Algorithme)null);
				return;
			case TableurPackage.COLONNE_OUTPUT__COLONNES:
				getColonnes().clear();
				return;
			case TableurPackage.COLONNE_OUTPUT__OPERATION:
				setOperation((Operation)null);
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
			case TableurPackage.COLONNE_OUTPUT__ALGO:
				return algo != null;
			case TableurPackage.COLONNE_OUTPUT__COLONNES:
				return colonnes != null && !colonnes.isEmpty();
			case TableurPackage.COLONNE_OUTPUT__OPERATION:
				return operation != null;
		}
		return super.eIsSet(featureID);
	}

} //ColonneOutputImpl
