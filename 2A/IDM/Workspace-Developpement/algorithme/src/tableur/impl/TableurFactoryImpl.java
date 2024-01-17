/**
 */
package tableur.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

import tableur.*;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class TableurFactoryImpl extends EFactoryImpl implements TableurFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static TableurFactory init() {
		try {
			TableurFactory theTableurFactory = (TableurFactory) EPackage.Registry.INSTANCE
					.getEFactory(TableurPackage.eNS_URI);
			if (theTableurFactory != null) {
				return theTableurFactory;
			}
		} catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new TableurFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TableurFactoryImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EObject create(EClass eClass) {
		switch (eClass.getClassifierID()) {
		case TableurPackage.TABLEUR:
			return createTableur();
		case TableurPackage.TABLE:
			return createTable();
		case TableurPackage.COLONNE_INPUT:
			return createColonneInput();
		case TableurPackage.COLONNE_OUTPUT:
			return createColonneOutput();
		case TableurPackage.OPERATEUR_BINAIRE:
			return createOperateurBinaire();
		case TableurPackage.OPERATEUR_UNAIRE:
			return createOperateurUnaire();
		default:
			throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object createFromString(EDataType eDataType, String initialValue) {
		switch (eDataType.getClassifierID()) {
		case TableurPackage.OPERATEUR_UNAIRE_TYPE:
			return createOperateurUnaireTypeFromString(eDataType, initialValue);
		case TableurPackage.OPERATEUR_BINAIRE_TYPE:
			return createOperateurBinaireTypeFromString(eDataType, initialValue);
		default:
			throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String convertToString(EDataType eDataType, Object instanceValue) {
		switch (eDataType.getClassifierID()) {
		case TableurPackage.OPERATEUR_UNAIRE_TYPE:
			return convertOperateurUnaireTypeToString(eDataType, instanceValue);
		case TableurPackage.OPERATEUR_BINAIRE_TYPE:
			return convertOperateurBinaireTypeToString(eDataType, instanceValue);
		default:
			throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Tableur createTableur() {
		TableurImpl tableur = new TableurImpl();
		return tableur;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Table createTable() {
		TableImpl table = new TableImpl();
		return table;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public ColonneInput createColonneInput() {
		ColonneInputImpl colonneInput = new ColonneInputImpl();
		return colonneInput;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public ColonneOutput createColonneOutput() {
		ColonneOutputImpl colonneOutput = new ColonneOutputImpl();
		return colonneOutput;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public OperateurBinaire createOperateurBinaire() {
		OperateurBinaireImpl operateurBinaire = new OperateurBinaireImpl();
		return operateurBinaire;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public OperateurUnaire createOperateurUnaire() {
		OperateurUnaireImpl operateurUnaire = new OperateurUnaireImpl();
		return operateurUnaire;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public OperateurUnaireType createOperateurUnaireTypeFromString(EDataType eDataType, String initialValue) {
		OperateurUnaireType result = OperateurUnaireType.get(initialValue);
		if (result == null)
			throw new IllegalArgumentException(
					"The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertOperateurUnaireTypeToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public OperateurBinaireType createOperateurBinaireTypeFromString(EDataType eDataType, String initialValue) {
		OperateurBinaireType result = OperateurBinaireType.get(initialValue);
		if (result == null)
			throw new IllegalArgumentException(
					"The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertOperateurBinaireTypeToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public TableurPackage getTableurPackage() {
		return (TableurPackage) getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static TableurPackage getPackage() {
		return TableurPackage.eINSTANCE;
	}

} //TableurFactoryImpl
