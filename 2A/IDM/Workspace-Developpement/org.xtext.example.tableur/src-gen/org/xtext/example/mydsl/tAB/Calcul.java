/**
 * generated by Xtext 2.32.0
 */
package org.xtext.example.mydsl.tAB;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Calcul</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.xtext.example.mydsl.tAB.Calcul#getOperation <em>Operation</em>}</li>
 * </ul>
 *
 * @see org.xtext.example.mydsl.tAB.TABPackage#getCalcul()
 * @model
 * @generated
 */
public interface Calcul extends EObject
{
  /**
   * Returns the value of the '<em><b>Operation</b></em>' containment reference list.
   * The list contents are of type {@link org.xtext.example.mydsl.tAB.OperationScript}.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Operation</em>' containment reference list.
   * @see org.xtext.example.mydsl.tAB.TABPackage#getCalcul_Operation()
   * @model containment="true"
   * @generated
   */
  EList<OperationScript> getOperation();

} // Calcul
