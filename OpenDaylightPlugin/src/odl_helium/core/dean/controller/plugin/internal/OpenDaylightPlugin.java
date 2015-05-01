package odl_helium.core.dean.controller.plugin.internal;

import java.util.logging.Level;
import java.util.logging.Logger;

import topologyManager.com.dean.controller.feature.topologyManagerService.Graph;

import com.dean.controller.commonService.DeanComponent;
import com.dean.controller.commonService.DeanControllerPlugin;

public class OpenDaylightPlugin implements DeanControllerPlugin{
	
	String openDaylightPluginId = "ODLHELIUM"; 
	private static Logger logger = Logger.getLogger(OpenDaylightPlugin.class.getName());
	
	public Graph getGraph(){
		Graph graph = new Graph();
		logger.log(Level.INFO, "Getting Graph from ODL controller");
		return graph;
	}

	@Override
	public Class<DeanComponent> provideClass() {
		return null;
	}

	@Override
	public String getId() {
		return openDaylightPluginId;
	}
}
