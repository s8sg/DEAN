package floodlightplugin.core.dean.controller.plugin.internal;

import topologyManager.com.dean.controller.feature.topologyManagerService.Graph;

import com.dean.controller.commonService.DeanComponent;
import com.dean.controller.commonService.DeanControllerPlugin;

public class FloodlightPlugin implements DeanControllerPlugin {

	String floodlightPluginId = "FLOODLIGHT"; 
	
	public Graph getGraph(){
		Graph graph = new Graph();
		System.out.println("Getting Graph from Floodlight controller");
		return graph;
	}
	
	@Override
	public Class<DeanComponent> provideClass() {
		return null;
	}

	@Override
	public String getId() {
		return floodlightPluginId;
	}
}
