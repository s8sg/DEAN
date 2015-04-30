package com.dean.controller.internal;

import java.util.ArrayList;
import java.util.HashMap;

import com.dean.controller.commonService.DeanBundleActivator;
import com.dean.controller.commonService.DeanControllerPlugin;

public class BundleRegistry {

	HashMap<String, DeanControllerPlugin> controllerList;
	HashMap<String, DeanControllerPlugin> featureList;
	Object lock;
	
	public BundleRegistry(){
		controllerList = new HashMap<String, DeanControllerPlugin>();
		lock = new Object();
	}
	
	public DeanControllerPlugin getController(String controllerId){
		DeanControllerPlugin controllerPlugin = null;
		synchronized(lock){
			controllerPlugin = controllerList.get(controllerId);
		}
		return controllerPlugin;
	}
	
	public ArrayList<DeanControllerPlugin> getAllControllers(){
		ArrayList<DeanControllerPlugin> controllerPlugins = null;
		synchronized(lock){
			controllerPlugins = new ArrayList<DeanControllerPlugin>(controllerList.values());
		}
		return controllerPlugins;
	}
	
	public void addController(String controllerId, DeanControllerPlugin controllerPlugin) {
		synchronized(lock){
			controllerList.put(controllerId, controllerPlugin);
		}
	}
}
