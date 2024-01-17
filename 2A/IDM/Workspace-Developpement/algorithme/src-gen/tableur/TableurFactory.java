/**
 */
package tableur;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see tableur.TableurPackage
 * @generated
 */
public interface TableurFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	TableurFactory eINSTANCE = tableur.impl.TableurFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>Tableur</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Tableur</em>'.
	 * @generated
	 */
	Tableur createTableur();

	/**
	 * Returns a new object of class '<em>Table</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Table</em>'.
	 * @generated
	 */
	Table createTable();

	/**
	 * Returns a new object of class '<em>Colonne Input</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Colonne Input</em>'.
	 * @generated
	 */
	ColonneInput createColonneInput();

	/**
	 * Returns a new object of class '<em>Colonne Output</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Colonne Output</em>'.
	 * @generated
	 */
	ColonneOutput createColonneOutput();

	/**
	 * Returns a new object of class '<em>Operateur Binaire</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Operateur Binaire</em>'.
	 * @generated
	 */
	OperateurBinaire createOperateurBinaire();

	/**
	 * Returns a new object of class '<em>Operateur Unaire</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Operateur Unaire</em>'.
	 * @generated
	 */
	OperateurUnaire createOperateurUnaire();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	TableurPackage getTableurPackage();

} //TableurFactory
