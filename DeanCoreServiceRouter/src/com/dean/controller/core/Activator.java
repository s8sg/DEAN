package com.dean.controller.core;

import java.util.Hashtable;

import org.osgi.framework.BundleContext;

import com.dean.controller.commonService.DeanBundleActivator;
import com.dean.controller.commonService.DeanCoreServices;
import com.dean.controller.internal.Dean;

public class Activator extends DeanBundleActivator {
	
	private static BundleContext context;

	static BundleContext getContext() {
		return context;
	}
	
	@Override
	public void stopBundle(BundleContext context) {
		System.out.println("Dean Core Service Bundle is getting stopped !");
	}

	@Override
	public void startBundle(BundleContext context) {
		System.out.println("Dean Core Service Bundle is starting !");
		System.out.println("Initializing and exporting DEAN core");
		Hashtable<String, String> props = new Hashtable<>();
		props.put("description", "This is DEAN");
		Dean dean = new Dean();
		/* Register Dean services */
		context.registerService(DeanCoreServices.class.getName(), dean, props);
	}
}
