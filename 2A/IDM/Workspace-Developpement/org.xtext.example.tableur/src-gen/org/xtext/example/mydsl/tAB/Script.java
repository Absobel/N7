/**
 * generated by Xtext 2.32.0
 */
package org.xtext.example.mydsl.tAB;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Script</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.xtext.example.mydsl.tAB.Script#getName <em>Name</em>}</li>
 *   <li>{@link org.xtext.example.mydsl.tAB.Script#getEntrees <em>Entrees</em>}</li>
 *   <li>{@link org.xtext.example.mydsl.tAB.Script#getSorties <em>Sorties</em>}</li>
 *   <li>{@link org.xtext.example.mydsl.tAB.Script#getCalculs <em>Calculs</em>}</li>
 * </ul>
 *
 * @see org.xtext.example.mydsl.tAB.TABPackage#getScript()
 * @model
 * @generated
 */
public interface Script extends EObject
{
  /**
   * Returns the value of the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Name</em>' attribute.
   * @see #setName(String)
   * @see org.xtext.example.mydsl.tAB.TABPackage#getScript_Name()
   * @model
   * @generated
   */
  String getName();

  /**
   * Sets the value of the '{@link org.xtext.example.mydsl.tAB.Script#getName <em>Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Name</em>' attribute.
   * @see #getName()
   * @generated
   */
  void setName(String value);

  /**
   * Returns the value of the '<em><b>Entrees</b></em>' containment reference list.
   * The list contents are of type {@link org.xtext.example.mydsl.tAB.EntreeScript}.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Entrees</em>' containment reference list.
   * @see org.xtext.example.mydsl.tAB.TABPackage#getScript_Entrees()
   * @model containment="true"
   * @generated
   */
  EList<EntreeScript> getEntrees();

  /**
   * Returns the value of the '<em><b>Sorties</b></em>' containment reference list.
   * The list contents are of type {@link org.xtext.example.mydsl.tAB.SortieScript}.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Sorties</em>' containment reference list.
   * @see org.xtext.example.mydsl.tAB.TABPackage#getScript_Sorties()
   * @model containment="true"
   * @generated
   */
  EList<SortieScript> getSorties();

  /**
   * Returns the value of the '<em><b>Calculs</b></em>' containment reference list.
   * The list contents are of type {@link org.xtext.example.mydsl.tAB.Calcul}.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Calculs</em>' containment reference list.
   * @see org.xtext.example.mydsl.tAB.TABPackage#getScript_Calculs()
   * @model containment="true"
   * @generated
   */
  EList<Calcul> getCalculs();

} // Script
