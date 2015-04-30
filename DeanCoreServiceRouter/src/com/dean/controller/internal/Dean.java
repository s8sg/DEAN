package com.dean.controller.internal;
import java.util.ArrayList;

import com.dean.controller.commonService.DeanComponent;
import com.dean.controller.commonService.DeanControllerPlugin;
import com.dean.controller.commonService.DeanCoreServices;
import com.dean.controller.commonService.DeanFeature;

public class Dean implements DeanCoreServices{

	private BundleRegistry bundleReg = null;
	
	public Dean() {
		bundleReg = new BundleRegistry();
	}
	
	@Override
	public boolean register(DeanComponent deanComponent) {
		
		System.out.println("Registering the DeanComponent : " + deanComponent.getId());
		/* Check if a Dean Controller */
		if(deanComponent instanceof DeanControllerPlugin){
			String controllerId = null;
			/* Get controller ID */
			controllerId = deanComponent.getId();
			/* Check if controller Id is generated as null */
			if(controllerId == null) {
				System.out.println("Controller Id could not be NULL");
				return false;
			}
			/* Check if the controller is already added */
			if(bundleReg.getController(controllerId)!= null && bundleReg.getController(controllerId).equals(deanComponent)) {
				System.out.println("The value is already added to the Controller");
				return true;
			}
			else {
				bundleReg.addController(controllerId, (DeanControllerPlugin) deanComponent);
			}
		}
		/* Check if a Dean Feature */
		else if(deanComponent instanceof DeanFeature){
			/* Start the dean feature*/
			FeatureThread fthread = new FeatureThread((DeanFeature) deanComponent);
			fthread.start();
		}
		return true;
	}

	@Override
	public ArrayList<DeanControllerPlugin> getControllers() {
		ArrayList<DeanControllerPlugin> allControllers = null;
		allControllers = bundleReg.getAllControllers();
		return allControllers;
	}
}


class FeatureThread extends Thread{
	
	private DeanFeature feature = null;
	
	public FeatureThread(DeanFeature feature){
		this.feature = feature;
	}
	
	public void run(){
		feature.start();
	}
}