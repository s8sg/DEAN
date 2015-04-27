package com.dean.controller.common;

/* Interface to identify a dean component */
public interface DeanComponent {
	/* To get the class of the specific Component */
	public Class<DeanComponent> provideClass();
	/* To get the unique ID of the Component */
	public String getId();
}
