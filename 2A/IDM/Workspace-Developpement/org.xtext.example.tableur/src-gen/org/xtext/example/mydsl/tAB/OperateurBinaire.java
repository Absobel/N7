/**
 * generated by Xtext 2.32.0
 */
package org.xtext.example.mydsl.tAB;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Operateur Binaire</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.xtext.example.mydsl.tAB.OperateurBinaire#getKind <em>Kind</em>}</li>
 * </ul>
 *
 * @see org.xtext.example.mydsl.tAB.TABPackage#getOperateurBinaire()
 * @model
 * @generated
 */
public interface OperateurBinaire extends Operation
{
  /**
   * Returns the value of the '<em><b>Kind</b></em>' attribute.
   * The literals are from the enumeration {@link org.xtext.example.mydsl.tAB.OperationBinaireType}.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Kind</em>' attribute.
   * @see org.xtext.example.mydsl.tAB.OperationBinaireType
   * @see #setKind(OperationBinaireType)
   * @see org.xtext.example.mydsl.tAB.TABPackage#getOperateurBinaire_Kind()
   * @model
   * @generated
   */
  OperationBinaireType getKind();

  /**
   * Sets the value of the '{@link org.xtext.example.mydsl.tAB.OperateurBinaire#getKind <em>Kind</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Kind</em>' attribute.
   * @see org.xtext.example.mydsl.tAB.OperationBinaireType
   * @see #getKind()
   * @generated
   */
  void setKind(OperationBinaireType value);

} // OperateurBinaire
