package com.dean.controller.commonService;

import java.util.ArrayList;

/* To expose the functionality of the Dean Core */
public interface DeanCoreServices {
	public boolean register(DeanComponent controller);
	public ArrayList<DeanControllerPlugin> getControllers();
}
