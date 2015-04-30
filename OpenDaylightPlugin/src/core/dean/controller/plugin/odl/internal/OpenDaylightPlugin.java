package core.dean.controller.plugin.odl.internal;

import com.dean.controller.commonService.DeanComponent;
import com.dean.controller.commonService.DeanControllerPlugin;
import com.dean.controller.feature.topologyManagerService.Graph;

public class OpenDaylightPlugin implements DeanControllerPlugin{
	
	String openDaylightPluginId = "ODLHELIUM"; 
	
	public Graph getGraph(){
		Graph graph = new Graph();
		System.out.println("Getting Graph from ODL controller");
		return graph;
	}

	@Override
	public Class<DeanComponent> provideClass() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getId() {
		return openDaylightPluginId;
	}
}
