/**
 */
package script;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.util.Enumerator;

/**
 * <!-- begin-user-doc -->
 * A representation of the literals of the enumeration '<em><b>Fonction Type</b></em>',
 * and utility methods for working with them.
 * <!-- end-user-doc -->
 * @see script.ScriptPackage#getFonctionType()
 * @model
 * @generated
 */
public enum FonctionType implements Enumerator {
	/**
	 * The '<em><b>OPP</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #OPP_VALUE
	 * @generated
	 * @ordered
	 */
	OPP(0, "OPP", "OPP"),

	/**
	 * The '<em><b>INV</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #INV_VALUE
	 * @generated
	 * @ordered
	 */
	INV(1, "INV", "INV"),

	/**
	 * The '<em><b>COS</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #COS_VALUE
	 * @generated
	 * @ordered
	 */
	COS(2, "COS", "COS"),

	/**
	 * The '<em><b>SIN</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #SIN_VALUE
	 * @generated
	 * @ordered
	 */
	SIN(3, "SIN", "SIN"),

	/**
	 * The '<em><b>SQR</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #SQR_VALUE
	 * @generated
	 * @ordered
	 */
	SQR(4, "SQR", "SQR"),

	/**
	 * The '<em><b>EXP</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #EXP_VALUE
	 * @generated
	 * @ordered
	 */
	EXP(5, "EXP", "EXP"),

	/**
	 * The '<em><b>LOG</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #LOG_VALUE
	 * @generated
	 * @ordered
	 */
	LOG(6, "LOG", "LOG");

	/**
	 * The '<em><b>OPP</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #OPP
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int OPP_VALUE = 0;

	/**
	 * The '<em><b>INV</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #INV
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int INV_VALUE = 1;

	/**
	 * The '<em><b>COS</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #COS
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int COS_VALUE = 2;

	/**
	 * The '<em><b>SIN</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #SIN
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int SIN_VALUE = 3;

	/**
	 * The '<em><b>SQR</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #SQR
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int SQR_VALUE = 4;

	/**
	 * The '<em><b>EXP</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #EXP
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int EXP_VALUE = 5;

	/**
	 * The '<em><b>LOG</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #LOG
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int LOG_VALUE = 6;

	/**
	 * An array of all the '<em><b>Fonction Type</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static final FonctionType[] VALUES_ARRAY = new FonctionType[] { OPP, INV, COS, SIN, SQR, EXP, LOG, };

	/**
	 * A public read-only list of all the '<em><b>Fonction Type</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final List<FonctionType> VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

	/**
	 * Returns the '<em><b>Fonction Type</b></em>' literal with the specified literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param literal the literal.
	 * @return the matching enumerator or <code>null</code>.
	 * @generated
	 */
	public static FonctionType get(String literal) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			FonctionType result = VALUES_ARRAY[i];
			if (result.toString().equals(literal)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Fonction Type</b></em>' literal with the specified name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param name the name.
	 * @return the matching enumerator or <code>null</code>.
	 * @generated
	 */
	public static FonctionType getByName(String name) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			FonctionType result = VALUES_ARRAY[i];
			if (result.getName().equals(name)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Fonction Type</b></em>' literal with the specified integer value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the integer value.
	 * @return the matching enumerator or <code>null</code>.
	 * @generated
	 */
	public static FonctionType get(int value) {
		switch (value) {
		case OPP_VALUE:
			return OPP;
		case INV_VALUE:
			return INV;
		case COS_VALUE:
			return COS;
		case SIN_VALUE:
			return SIN;
		case SQR_VALUE:
			return SQR;
		case EXP_VALUE:
			return EXP;
		case LOG_VALUE:
			return LOG;
		}
		return null;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private final int value;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private final String name;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private final String literal;

	/**
	 * Only this class can construct instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private FonctionType(int value, String name, String literal) {
		this.value = value;
		this.name = name;
		this.literal = literal;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int getValue() {
		return value;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getName() {
		return name;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getLiteral() {
		return literal;
	}

	/**
	 * Returns the literal value of the enumerator, which is its string representation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		return literal;
	}

} //FonctionType
