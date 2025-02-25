/**
 * generated by Xtext 2.32.0
 */
package org.xtext.example.mydsl.tAB.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

import org.xtext.example.mydsl.tAB.Entree;
import org.xtext.example.mydsl.tAB.Parametre;
import org.xtext.example.mydsl.tAB.TABPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Entree</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.xtext.example.mydsl.tAB.impl.EntreeImpl#getParametres <em>Parametres</em>}</li>
 * </ul>
 *
 * @generated
 */
public class EntreeImpl extends MinimalEObjectImpl.Container implements Entree
{
  /**
   * The cached value of the '{@link #getParametres() <em>Parametres</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getParametres()
   * @generated
   * @ordered
   */
  protected EList<Parametre> parametres;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected EntreeImpl()
  {
    super();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  protected EClass eStaticClass()
  {
    return TABPackage.Literals.ENTREE;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EList<Parametre> getParametres()
  {
    if (parametres == null)
    {
      parametres = new EObjectContainmentEList<Parametre>(Parametre.class, this, TABPackage.ENTREE__PARAMETRES);
    }
    return parametres;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs)
  {
    switch (featureID)
    {
      case TABPackage.ENTREE__PARAMETRES:
        return ((InternalEList<?>)getParametres()).basicRemove(otherEnd, msgs);
    }
    return super.eInverseRemove(otherEnd, featureID, msgs);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Object eGet(int featureID, boolean resolve, boolean coreType)
  {
    switch (featureID)
    {
      case TABPackage.ENTREE__PARAMETRES:
        return getParametres();
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
  public void eSet(int featureID, Object newValue)
  {
    switch (featureID)
    {
      case TABPackage.ENTREE__PARAMETRES:
        getParametres().clear();
        getParametres().addAll((Collection<? extends Parametre>)newValue);
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
  public void eUnset(int featureID)
  {
    switch (featureID)
    {
      case TABPackage.ENTREE__PARAMETRES:
        getParametres().clear();
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
  public boolean eIsSet(int featureID)
  {
    switch (featureID)
    {
      case TABPackage.ENTREE__PARAMETRES:
        return parametres != null && !parametres.isEmpty();
    }
    return super.eIsSet(featureID);
  }

} //EntreeImpl
