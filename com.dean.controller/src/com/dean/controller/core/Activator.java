package com.dean.controller.core;

import org.osgi.framework.BundleContext;

import com.dean.controller.common.DeanBundleActivator;
import com.dean.controller.common.DeanCore;
import com.dean.controller.internal.Dean;

public class Activator extends DeanBundleActivator {

	
	
	private static BundleContext context;

	static BundleContext getContext() {
		return context;
	}
	
	@Override
	public void stopBundle(BundleContext context) {
		System.out.println("Bundle is getting started");
	}

	@Override
	public void startBundle(BundleContext context) {
		System.out.println("DEAN is starting !");
		System.out.println("Initiating DEAN core");
		Dean dean = new Dean();
		context.registerService(DeanCore.class, dean, null);
	}
}
