/**
 */
package algorithme.impl;

import algorithme.AlgorithmeElement;
import algorithme.AlgorithmePackage;
import algorithme.Comment;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Comment</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link algorithme.impl.CommentImpl#getComment <em>Comment</em>}</li>
 *   <li>{@link algorithme.impl.CommentImpl#getAlgorithmeElement <em>Algorithme Element</em>}</li>
 * </ul>
 *
 * @generated
 */
public class CommentImpl extends AlgorithmeElementImpl implements Comment {
	/**
	 * The default value of the '{@link #getComment() <em>Comment</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getComment()
	 * @generated
	 * @ordered
	 */
	protected static final String COMMENT_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getComment() <em>Comment</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getComment()
	 * @generated
	 * @ordered
	 */
	protected String comment = COMMENT_EDEFAULT;

	/**
	 * The cached value of the '{@link #getAlgorithmeElement() <em>Algorithme Element</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAlgorithmeElement()
	 * @generated
	 * @ordered
	 */
	protected AlgorithmeElement algorithmeElement;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected CommentImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return AlgorithmePackage.Literals.COMMENT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getComment() {
		return comment;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setComment(String newComment) {
		String oldComment = comment;
		comment = newComment;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, AlgorithmePackage.COMMENT__COMMENT, oldComment, comment));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public AlgorithmeElement getAlgorithmeElement() {
		return algorithmeElement;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetAlgorithmeElement(AlgorithmeElement newAlgorithmeElement, NotificationChain msgs) {
		AlgorithmeElement oldAlgorithmeElement = algorithmeElement;
		algorithmeElement = newAlgorithmeElement;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, AlgorithmePackage.COMMENT__ALGORITHME_ELEMENT, oldAlgorithmeElement, newAlgorithmeElement);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setAlgorithmeElement(AlgorithmeElement newAlgorithmeElement) {
		if (newAlgorithmeElement != algorithmeElement) {
			NotificationChain msgs = null;
			if (algorithmeElement != null)
				msgs = ((InternalEObject)algorithmeElement).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - AlgorithmePackage.COMMENT__ALGORITHME_ELEMENT, null, msgs);
			if (newAlgorithmeElement != null)
				msgs = ((InternalEObject)newAlgorithmeElement).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - AlgorithmePackage.COMMENT__ALGORITHME_ELEMENT, null, msgs);
			msgs = basicSetAlgorithmeElement(newAlgorithmeElement, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, AlgorithmePackage.COMMENT__ALGORITHME_ELEMENT, newAlgorithmeElement, newAlgorithmeElement));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case AlgorithmePackage.COMMENT__ALGORITHME_ELEMENT:
				return basicSetAlgorithmeElement(null, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case AlgorithmePackage.COMMENT__COMMENT:
				return getComment();
			case AlgorithmePackage.COMMENT__ALGORITHME_ELEMENT:
				return getAlgorithmeElement();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case AlgorithmePackage.COMMENT__COMMENT:
				setComment((String)newValue);
				return;
			case AlgorithmePackage.COMMENT__ALGORITHME_ELEMENT:
				setAlgorithmeElement((AlgorithmeElement)newValue);
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
			case AlgorithmePackage.COMMENT__COMMENT:
				setComment(COMMENT_EDEFAULT);
				return;
			case AlgorithmePackage.COMMENT__ALGORITHME_ELEMENT:
				setAlgorithmeElement((AlgorithmeElement)null);
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
			case AlgorithmePackage.COMMENT__COMMENT:
				return COMMENT_EDEFAULT == null ? comment != null : !COMMENT_EDEFAULT.equals(comment);
			case AlgorithmePackage.COMMENT__ALGORITHME_ELEMENT:
				return algorithmeElement != null;
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuilder result = new StringBuilder(super.toString());
		result.append(" (comment: ");
		result.append(comment);
		result.append(')');
		return result.toString();
	}

} //CommentImpl
