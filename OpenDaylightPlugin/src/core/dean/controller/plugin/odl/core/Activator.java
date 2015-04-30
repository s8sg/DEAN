package core.dean.controller.plugin.odl.core;

import org.osgi.framework.BundleContext;
import org.osgi.framework.BundleException;
import org.osgi.util.tracker.ServiceTracker;

import com.dean.controller.commonService.DeanBundleActivator;
import com.dean.controller.commonService.DeanCoreServices;

import core.dean.controller.plugin.odl.internal.OpenDaylightPlugin;

public class Activator extends DeanBundleActivator {

	private static BundleContext context;
	private ServiceTracker deanCoreTracker;

	static BundleContext getContext() {
		return context;
	}

	@Override
	public void stopBundle(BundleContext context) {
		// TODO Auto-generated method stub
		System.out.println("Dean Opendaylight Plugin is getting Stopped !");
	}

	@Override
	public void startBundle(BundleContext context) {
		System.out.println("Dean Opendaylight Plugin is getting Started !");	
		DeanCoreServices deanCore = null; 
		
		deanCoreTracker = new ServiceTracker(context, DeanCoreServices.class.getName(), null);
		deanCoreTracker.open();
		deanCore =  (DeanCoreServices) deanCoreTracker.getService();
		if(deanCore == null) {
			System.out.println("DeanCore service unavailable for TopologyManager Feature");
			try {
				context.getBundle().stop();
			} catch (BundleException e) {
				e.printStackTrace();
			}			
		}
		else {
			/* Initialize the plugin Core */
			OpenDaylightPlugin odlPlugin = new OpenDaylightPlugin(); 
			/* Register the plugin to the Dean Core */
			deanCore.register(odlPlugin);
		}
	}

}
