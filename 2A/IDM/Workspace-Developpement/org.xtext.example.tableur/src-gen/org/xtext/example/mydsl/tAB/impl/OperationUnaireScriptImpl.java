/**
 * generated by Xtext 2.32.0
 */
package org.xtext.example.mydsl.tAB.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

import org.xtext.example.mydsl.tAB.Operand;
import org.xtext.example.mydsl.tAB.OperateurUnaireType;
import org.xtext.example.mydsl.tAB.OperationUnaireScript;
import org.xtext.example.mydsl.tAB.TABPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Operation Unaire Script</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.xtext.example.mydsl.tAB.impl.OperationUnaireScriptImpl#getOperation <em>Operation</em>}</li>
 *   <li>{@link org.xtext.example.mydsl.tAB.impl.OperationUnaireScriptImpl#getOperands <em>Operands</em>}</li>
 * </ul>
 *
 * @generated
 */
public class OperationUnaireScriptImpl extends OperationScriptImpl implements OperationUnaireScript
{
  /**
   * The default value of the '{@link #getOperation() <em>Operation</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getOperation()
   * @generated
   * @ordered
   */
  protected static final OperateurUnaireType OPERATION_EDEFAULT = OperateurUnaireType.OPP;

  /**
   * The cached value of the '{@link #getOperation() <em>Operation</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getOperation()
   * @generated
   * @ordered
   */
  protected OperateurUnaireType operation = OPERATION_EDEFAULT;

  /**
   * The cached value of the '{@link #getOperands() <em>Operands</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getOperands()
   * @generated
   * @ordered
   */
  protected EList<Operand> operands;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected OperationUnaireScriptImpl()
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
    return TABPackage.Literals.OPERATION_UNAIRE_SCRIPT;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public OperateurUnaireType getOperation()
  {
    return operation;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void setOperation(OperateurUnaireType newOperation)
  {
    OperateurUnaireType oldOperation = operation;
    operation = newOperation == null ? OPERATION_EDEFAULT : newOperation;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, TABPackage.OPERATION_UNAIRE_SCRIPT__OPERATION, oldOperation, operation));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EList<Operand> getOperands()
  {
    if (operands == null)
    {
      operands = new EObjectContainmentEList<Operand>(Operand.class, this, TABPackage.OPERATION_UNAIRE_SCRIPT__OPERANDS);
    }
    return operands;
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
      case TABPackage.OPERATION_UNAIRE_SCRIPT__OPERANDS:
        return ((InternalEList<?>)getOperands()).basicRemove(otherEnd, msgs);
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
      case TABPackage.OPERATION_UNAIRE_SCRIPT__OPERATION:
        return getOperation();
      case TABPackage.OPERATION_UNAIRE_SCRIPT__OPERANDS:
        return getOperands();
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
      case TABPackage.OPERATION_UNAIRE_SCRIPT__OPERATION:
        setOperation((OperateurUnaireType)newValue);
        return;
      case TABPackage.OPERATION_UNAIRE_SCRIPT__OPERANDS:
        getOperands().clear();
        getOperands().addAll((Collection<? extends Operand>)newValue);
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
      case TABPackage.OPERATION_UNAIRE_SCRIPT__OPERATION:
        setOperation(OPERATION_EDEFAULT);
        return;
      case TABPackage.OPERATION_UNAIRE_SCRIPT__OPERANDS:
        getOperands().clear();
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
      case TABPackage.OPERATION_UNAIRE_SCRIPT__OPERATION:
        return operation != OPERATION_EDEFAULT;
      case TABPackage.OPERATION_UNAIRE_SCRIPT__OPERANDS:
        return operands != null && !operands.isEmpty();
    }
    return super.eIsSet(featureID);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public String toString()
  {
    if (eIsProxy()) return super.toString();

    StringBuilder result = new StringBuilder(super.toString());
    result.append(" (operation: ");
    result.append(operation);
    result.append(')');
    return result.toString();
  }

} //OperationUnaireScriptImpl