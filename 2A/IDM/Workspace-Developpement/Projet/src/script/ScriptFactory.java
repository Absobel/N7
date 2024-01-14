/**
 */
package script;

import org.eclipse.emf.ecore.EFactory;

import script.impl.*;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see script.ScriptPackage
 * @generated
 */
public interface ScriptFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	ScriptFactory eINSTANCE = ScriptFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>script</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>script</em>'.
	 * @generated
	 */
	script createscript();

	/**
	 * Returns a new object of class '<em>blocs</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>blocs</em>'.
	 * @generated
	 */
	blocs createblocs();

	/**
	 * Returns a new object of class '<em>Operations</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Operations</em>'.
	 * @generated
	 */
	Operations createOperations();

	/**
	 * Returns a new object of class '<em>Unaire</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Unaire</em>'.
	 * @generated
	 */
	Unaire createUnaire();

	/**
	 * Returns a new object of class '<em>Binaire</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Binaire</em>'.
	 * @generated
	 */
	Binaire createBinaire();

	/**
	 * Returns a new object of class '<em>Data</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Data</em>'.
	 * @generated
	 */
	Data createData();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	ScriptPackage getScriptPackage();

} //ScriptFactory
