package topologyManager.com.dean.controller.feature.internal;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;

import topologyManager.com.dean.controller.feature.topologyManagerService.Graph;
import topologyManager.com.dean.controller.feature.topologyManagerService.Port;
import topologyManager.com.dean.controller.feature.topologyManagerService.Switch;
import topologyManager.com.dean.controller.feature.topologyManagerService.TopologyMangerServices;

import com.dean.controller.commonService.DeanComponent;
import com.dean.controller.commonService.DeanControllerPlugin;
import com.dean.controller.commonService.DeanCoreServices;
import com.dean.controller.commonService.DeanFeature;

enum TopologyMethods {
    GETGRAPH ("getGraph"),
    GETSWITCHS ("getSwitchs"),
    GETLINKS ("getLinks");

    private final String name;       

    private TopologyMethods(String s) {
        name = s;
    }

    public boolean equalsName(String otherName){
        return (otherName == null)? false:name.equals(otherName);
    }

    public String toString(){
       return name;
    }
}

public class TopologyManager implements TopologyMangerServices,DeanFeature{

	private String topologyFeatureId = "TOPOLOGYMNGR01";
	DeanCoreServices deanCore = null;
	
	public TopologyManager(DeanCoreServices deanCore) {
		// TODO Auto-generated constructor stub
		this.deanCore = deanCore;
	}

	@Override
	public ArrayList<Switch> getAllSwitch(Graph graph) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<Switch> getAllLinks(Graph graph) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<Port> getAllPorts(Switch switz) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<Graph> getAllGraph() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Class<DeanComponent> provideClass() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getId() {
		return topologyFeatureId;
	}

	@Override
	public void start() {
		System.out.println("Topology Manager Service started by the Dean Core");
		while(true) {
			ArrayList<DeanControllerPlugin> controllerList = deanCore.getControllers();
			for(DeanControllerPlugin deanController : controllerList) {
				getTopologyDetails(deanController);
			}
			try {
				Thread.sleep(4000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	private void getTopologyDetails(DeanControllerPlugin deanController) {
		System.out.println("Getting Topology information from controller:" + deanController.getId());
		Method getTopologyMethod = null;
		try {
			Class<? extends DeanControllerPlugin> clazz = deanController.getClass();
			getTopologyMethod = clazz.getMethod(TopologyMethods.GETGRAPH.toString(), null);
			if(getTopologyMethod == null) {
				System.out.println("Topology Info method could not be extracted from controller Object for Controlelr:" + deanController.getId());
			}
			try {
				Object graphObject = getTopologyMethod.invoke(deanController, null);
				if(graphObject == null) {
					System.out.println("No graph has been found for controller: " + deanController.getId());
				}
				else {
					Graph graph = (Graph)graphObject;
					System.out.println("Graph has been received from the controller : " + deanController.getId());
				}
			} catch (IllegalAccessException | IllegalArgumentException
					| InvocationTargetException e) {
				System.out.println("Topology Info method could not be invoked from controller Object for Controlelr:" + deanController.getId());
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (NoSuchMethodException | SecurityException e) {
			// TODO Auto-generated catch block
			System.out.println("Got the method: exception");
			e.printStackTrace();
		}
	}
}
