package odl_helium.core.dean.controller.plugin.core;

import java.util.logging.Level;
import java.util.logging.Logger;

import odl_helium.core.dean.controller.plugin.internal.OpenDaylightPlugin;

import org.osgi.framework.BundleContext;
import org.osgi.framework.BundleException;
import org.osgi.util.tracker.ServiceTracker;

import com.dean.controller.commonService.DeanBundleActivator;
import com.dean.controller.commonService.DeanCoreServices;

public class Activator extends DeanBundleActivator {

	private static Logger logger = Logger.getLogger(Activator.class.getName());
	
	private static BundleContext context;
	private ServiceTracker deanCoreTracker;

	static BundleContext getContext() {
		return context;
	}

	@Override
	public void stopBundle(BundleContext context) {
		// TODO Auto-generated method stub
		logger.log(Level.INFO, "Dean Opendaylight Plugin is getting Stopped !");
	}

	@Override
	public void startBundle(BundleContext context) {
		logger.log(Level.INFO, "Dean Opendaylight Plugin is getting Started !");	
		DeanCoreServices deanCore = null; 
		
		deanCoreTracker = new ServiceTracker(context, DeanCoreServices.class.getName(), null);
		deanCoreTracker.open();
		deanCore =  (DeanCoreServices) deanCoreTracker.getService();
		if(deanCore == null) {
			logger.log(Level.INFO, "DeanCore service unavailable for TopologyManager Feature");
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
