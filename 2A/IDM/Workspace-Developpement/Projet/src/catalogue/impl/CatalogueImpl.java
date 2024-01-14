/**
 */
package catalogue.impl;

import catalogue.AlgorithmeElement;
import catalogue.Catalogue;
import catalogue.CataloguePackage;

import java.util.Collection;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.EObjectResolvingEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Catalogue</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link catalogue.impl.CatalogueImpl#getAlgorithmeelement <em>Algorithmeelement</em>}</li>
 * </ul>
 *
 * @generated
 */
public class CatalogueImpl extends MinimalEObjectImpl.Container implements Catalogue {
	/**
	 * The cached value of the '{@link #getAlgorithmeelement() <em>Algorithmeelement</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAlgorithmeelement()
	 * @generated
	 * @ordered
	 */
	protected EList<AlgorithmeElement> algorithmeelement;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected CatalogueImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return CataloguePackage.Literals.CATALOGUE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<AlgorithmeElement> getAlgorithmeelement() {
		if (algorithmeelement == null) {
			algorithmeelement = new EObjectResolvingEList<AlgorithmeElement>(AlgorithmeElement.class, this, CataloguePackage.CATALOGUE__ALGORITHMEELEMENT);
		}
		return algorithmeelement;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case CataloguePackage.CATALOGUE__ALGORITHMEELEMENT:
				return getAlgorithmeelement();
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
			case CataloguePackage.CATALOGUE__ALGORITHMEELEMENT:
				getAlgorithmeelement().clear();
				getAlgorithmeelement().addAll((Collection<? extends AlgorithmeElement>)newValue);
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
			case CataloguePackage.CATALOGUE__ALGORITHMEELEMENT:
				getAlgorithmeelement().clear();
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
			case CataloguePackage.CATALOGUE__ALGORITHMEELEMENT:
				return algorithmeelement != null && !algorithmeelement.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //CatalogueImpl
