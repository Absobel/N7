/**
 */
package algorithme.provider;


import algorithme.AlgorithmeFactory;
import algorithme.AlgorithmePackage;
import algorithme.Comment;

import java.util.Collection;
import java.util.List;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EStructuralFeature;

import org.eclipse.emf.edit.provider.ComposeableAdapterFactory;
import org.eclipse.emf.edit.provider.IItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.ItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.ViewerNotification;

/**
 * This is the item provider adapter for a {@link algorithme.Comment} object.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class CommentItemProvider extends AlgorithmeElementItemProvider {
	/**
	 * This constructs an instance from a factory and a notifier.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CommentItemProvider(AdapterFactory adapterFactory) {
		super(adapterFactory);
	}

	/**
	 * This returns the property descriptors for the adapted class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public List<IItemPropertyDescriptor> getPropertyDescriptors(Object object) {
		if (itemPropertyDescriptors == null) {
			super.getPropertyDescriptors(object);

			addCommentPropertyDescriptor(object);
		}
		return itemPropertyDescriptors;
	}

	/**
	 * This adds a property descriptor for the Comment feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addCommentPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_Comment_comment_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_Comment_comment_feature", "_UI_Comment_type"),
				 AlgorithmePackage.Literals.COMMENT__COMMENT,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This specifies how to implement {@link #getChildren} and is used to deduce an appropriate feature for an
	 * {@link org.eclipse.emf.edit.command.AddCommand}, {@link org.eclipse.emf.edit.command.RemoveCommand} or
	 * {@link org.eclipse.emf.edit.command.MoveCommand} in {@link #createCommand}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Collection<? extends EStructuralFeature> getChildrenFeatures(Object object) {
		if (childrenFeatures == null) {
			super.getChildrenFeatures(object);
			childrenFeatures.add(AlgorithmePackage.Literals.COMMENT__ALGORITHME_ELEMENT);
		}
		return childrenFeatures;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EStructuralFeature getChildFeature(Object object, Object child) {
		// Check the type of the specified child object and return the proper feature to use for
		// adding (see {@link AddCommand}) it as a child.

		return super.getChildFeature(object, child);
	}

	/**
	 * This returns Comment.gif.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object getImage(Object object) {
		return overlayImage(object, getResourceLocator().getImage("full/obj16/Comment"));
	}

	/**
	 * This returns the label text for the adapted class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getText(Object object) {
		String label = ((Comment)object).getComment();
		return label == null || label.length() == 0 ?
			getString("_UI_Comment_type") :
			getString("_UI_Comment_type") + " " + label;
	}


	/**
	 * This handles model notifications by calling {@link #updateChildren} to update any cached
	 * children and by creating a viewer notification, which it passes to {@link #fireNotifyChanged}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void notifyChanged(Notification notification) {
		updateChildren(notification);

		switch (notification.getFeatureID(Comment.class)) {
			case AlgorithmePackage.COMMENT__COMMENT:
				fireNotifyChanged(new ViewerNotification(notification, notification.getNotifier(), false, true));
				return;
			case AlgorithmePackage.COMMENT__ALGORITHME_ELEMENT:
				fireNotifyChanged(new ViewerNotification(notification, notification.getNotifier(), true, false));
				return;
		}
		super.notifyChanged(notification);
	}

	/**
	 * This adds {@link org.eclipse.emf.edit.command.CommandParameter}s describing the children
	 * that can be created under this object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected void collectNewChildDescriptors(Collection<Object> newChildDescriptors, Object object) {
		super.collectNewChildDescriptors(newChildDescriptors, object);

		newChildDescriptors.add
			(createChildParameter
				(AlgorithmePackage.Literals.COMMENT__ALGORITHME_ELEMENT,
				 AlgorithmeFactory.eINSTANCE.createAlgorithmeElement()));

		newChildDescriptors.add
			(createChildParameter
				(AlgorithmePackage.Literals.COMMENT__ALGORITHME_ELEMENT,
				 AlgorithmeFactory.eINSTANCE.createAlgorithme()));

		newChildDescriptors.add
			(createChildParameter
				(AlgorithmePackage.Literals.COMMENT__ALGORITHME_ELEMENT,
				 AlgorithmeFactory.eINSTANCE.createData()));

		newChildDescriptors.add
			(createChildParameter
				(AlgorithmePackage.Literals.COMMENT__ALGORITHME_ELEMENT,
				 AlgorithmeFactory.eINSTANCE.createRessource()));

		newChildDescriptors.add
			(createChildParameter
				(AlgorithmePackage.Literals.COMMENT__ALGORITHME_ELEMENT,
				 AlgorithmeFactory.eINSTANCE.createStdin()));

		newChildDescriptors.add
			(createChildParameter
				(AlgorithmePackage.Literals.COMMENT__ALGORITHME_ELEMENT,
				 AlgorithmeFactory.eINSTANCE.createStdout()));

		newChildDescriptors.add
			(createChildParameter
				(AlgorithmePackage.Literals.COMMENT__ALGORITHME_ELEMENT,
				 AlgorithmeFactory.eINSTANCE.createComment()));
	}

}
