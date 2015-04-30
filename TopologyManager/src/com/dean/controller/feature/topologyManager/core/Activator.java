package com.dean.controller.feature.topologyManager.core;

import java.util.Hashtable;

import org.osgi.framework.BundleContext;
import org.osgi.framework.BundleException;
import org.osgi.framework.ServiceReference;
import org.osgi.util.tracker.ServiceTracker;

import com.dean.controller.commonService.DeanBundleActivator;
import com.dean.controller.commonService.DeanCoreServices;
import com.dean.controller.feature.topologyManager.internal.TopologyManager;
import com.dean.controller.feature.topologyManagerService.TopologyMangerServices;

public class Activator extends DeanBundleActivator{

	private static BundleContext context;
	private ServiceTracker deanCoreTracker;

	static BundleContext getContext() {
		return context;
	}

	@Override
	public void stopBundle(BundleContext context) {
		// TODO Auto-generated method stub
		System.out.println("Dean Feature Topology Manager is getting Stopped !");
	}

	@Override
	public void startBundle(BundleContext context) {
		System.out.println("Dean Feature Topology Manager is getting Started !");
		DeanCoreServices deanCore = null; 
		
		deanCoreTracker = new ServiceTracker(context, DeanCoreServices.class.getName(), null);
		deanCoreTracker.open();
		deanCore =  (DeanCoreServices) deanCoreTracker.getService();
		if(deanCore == null) {
			System.out.println("DeanCore service unavailable for TopologyManager Feature");
			try {
				context.getBundle().stop();
			} catch (BundleException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}			
		}
		else {
			/* Initialize the Feature Core */
			TopologyManager topologyManager = new TopologyManager(deanCore);
			/* Register the feature to the Dean Core */
			deanCore.register(topologyManager);
		}
	}

}
