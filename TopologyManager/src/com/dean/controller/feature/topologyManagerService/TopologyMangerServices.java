package com.dean.controller.feature.topologyManagerService;

import java.util.ArrayList;

public interface TopologyMangerServices {
	
	ArrayList<Switch> getAllSwitch(Graph graph);
	ArrayList<Switch> getAllLinks(Graph graph);
	ArrayList<Port> getAllPorts(Switch switz);
	ArrayList<Graph> getAllGraph();
}
