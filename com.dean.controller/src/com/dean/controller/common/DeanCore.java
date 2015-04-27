package com.dean.controller.common;

import java.lang.reflect.Method;
import java.util.ArrayList;

/* To expose the functionality of the Dean Core */
public interface DeanCore {
	public boolean register(DeanComponent controller);
	public ArrayList<DeanControllerPlugin> getControllers();
}
