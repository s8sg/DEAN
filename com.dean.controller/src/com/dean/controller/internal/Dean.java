package com.dean.controller.internal;

import java.util.ArrayList;

import com.dean.controller.common.DeanComponent;
import com.dean.controller.common.DeanControllerPlugin;
import com.dean.controller.common.DeanCore;
import com.dean.controller.common.DeanFeature;

public class Dean implements DeanCore{

	
	
	@Override
	public boolean register(DeanComponent deanComponent) {
		
		/* Check if a Dean Controller */
		if(deanComponent.getClass().equals(DeanControllerPlugin.class)){
			
		}
		/* Check if a Dean Feature */
		else if(deanComponent.getClass().equals(DeanFeature.class)){
			
		}
		return false;
	}

	@Override
	public ArrayList<DeanControllerPlugin> getControllers() {
	
		return null;
	}

}
