package com.dean.controller.common;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;

public abstract class DeanBundleActivator implements BundleActivator{
	

	@Override
	public void start(BundleContext context) throws Exception {
		this.startBundle(context);
	}

	@Override
	public void stop(BundleContext context) throws Exception {
		this.stopBundle(context);
	}

	/* Should be implemented by the Dean Bundle */
	public abstract void stopBundle(BundleContext context);

	/* Should be implemented by the Dean Bundle */
	public abstract void startBundle(BundleContext context);

}

