package com.dean.controller.internal;

import java.util.HashMap;

import com.dean.controller.common.DeanBundleActivator;

public class BundleRegistry {

	HashMap<String,DeanBundleActivator>  bundleMap;
	
	public BundleRegistry(){
		bundleMap = new HashMap<String,DeanBundleActivator>();
	}
	
	
}
