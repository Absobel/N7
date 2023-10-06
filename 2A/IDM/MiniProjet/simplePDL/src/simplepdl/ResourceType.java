/**
 */
package simplepdl;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.util.Enumerator;

/**
 * <!-- begin-user-doc -->
 * A representation of the literals of the enumeration '<em><b>Resource Type</b></em>',
 * and utility methods for working with them.
 * <!-- end-user-doc -->
 * @see simplepdl.SimplepdlPackage#getResourceType()
 * @model
 * @generated
 */
public enum ResourceType implements Enumerator {
	/**
	 * The '<em><b>Concepteur</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #CONCEPTEUR_VALUE
	 * @generated
	 * @ordered
	 */
	CONCEPTEUR(0, "concepteur", "concepteur"),

	/**
	 * The '<em><b>Développeur</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #DÉVELOPPEUR_VALUE
	 * @generated
	 * @ordered
	 */
	DÉVELOPPEUR(1, "développeur", "d\u00e9veloppeur"),

	/**
	 * The '<em><b>Machine</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #MACHINE_VALUE
	 * @generated
	 * @ordered
	 */
	MACHINE(2, "machine", "machine"),

	/**
	 * The '<em><b>Rédacteur</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #RÉDACTEUR_VALUE
	 * @generated
	 * @ordered
	 */
	RÉDACTEUR(3, "rédacteur", "r\u00e9dacteur"),

	/**
	 * The '<em><b>Testeur</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #TESTEUR_VALUE
	 * @generated
	 * @ordered
	 */
	TESTEUR(4, "testeur", "testeur");

	/**
	 * The '<em><b>Concepteur</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #CONCEPTEUR
	 * @model name="concepteur"
	 * @generated
	 * @ordered
	 */
	public static final int CONCEPTEUR_VALUE = 0;

	/**
	 * The '<em><b>Développeur</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #DÉVELOPPEUR
	 * @model name="développeur"
	 * @generated
	 * @ordered
	 */
	public static final int DÉVELOPPEUR_VALUE = 1;

	/**
	 * The '<em><b>Machine</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #MACHINE
	 * @model name="machine"
	 * @generated
	 * @ordered
	 */
	public static final int MACHINE_VALUE = 2;

	/**
	 * The '<em><b>Rédacteur</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #RÉDACTEUR
	 * @model name="rédacteur"
	 * @generated
	 * @ordered
	 */
	public static final int RÉDACTEUR_VALUE = 3;

	/**
	 * The '<em><b>Testeur</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #TESTEUR
	 * @model name="testeur"
	 * @generated
	 * @ordered
	 */
	public static final int TESTEUR_VALUE = 4;

	/**
	 * An array of all the '<em><b>Resource Type</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static final ResourceType[] VALUES_ARRAY =
		new ResourceType[] {
			CONCEPTEUR,
			DÉVELOPPEUR,
			MACHINE,
			RÉDACTEUR,
			TESTEUR,
		};

	/**
	 * A public read-only list of all the '<em><b>Resource Type</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final List<ResourceType> VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

	/**
	 * Returns the '<em><b>Resource Type</b></em>' literal with the specified literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param literal the literal.
	 * @return the matching enumerator or <code>null</code>.
	 * @generated
	 */
	public static ResourceType get(String literal) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			ResourceType result = VALUES_ARRAY[i];
			if (result.toString().equals(literal)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Resource Type</b></em>' literal with the specified name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param name the name.
	 * @return the matching enumerator or <code>null</code>.
	 * @generated
	 */
	public static ResourceType getByName(String name) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			ResourceType result = VALUES_ARRAY[i];
			if (result.getName().equals(name)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Resource Type</b></em>' literal with the specified integer value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the integer value.
	 * @return the matching enumerator or <code>null</code>.
	 * @generated
	 */
	public static ResourceType get(int value) {
		switch (value) {
			case CONCEPTEUR_VALUE: return CONCEPTEUR;
			case DÉVELOPPEUR_VALUE: return DÉVELOPPEUR;
			case MACHINE_VALUE: return MACHINE;
			case RÉDACTEUR_VALUE: return RÉDACTEUR;
			case TESTEUR_VALUE: return TESTEUR;
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
	private ResourceType(int value, String name, String literal) {
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
	
} //ResourceType
