/*
 * generated by Xtext 2.32.0
 */
package org.xtext.example.mydsl.ui;

import com.google.inject.Injector;
import org.eclipse.xtext.ui.guice.AbstractGuiceAwareExecutableExtensionFactory;
import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;
import org.xtext.example.tableur.ui.internal.TableurActivator;

/**
 * This class was generated. Customizations should only happen in a newly
 * introduced subclass. 
 */
public class TABExecutableExtensionFactory extends AbstractGuiceAwareExecutableExtensionFactory {

	@Override
	protected Bundle getBundle() {
		return FrameworkUtil.getBundle(TableurActivator.class);
	}
	
	@Override
	protected Injector getInjector() {
		TableurActivator activator = TableurActivator.getInstance();
		return activator != null ? activator.getInjector(TableurActivator.ORG_XTEXT_EXAMPLE_MYDSL_TAB) : null;
	}

}