package controller;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

import rmi.base.DataRequestInterface;
import rmi.base.DatabaseRequest;
import rmi.base.RequestResponse;
import rmi.base.RmiStarter;

public class RequestLauncher extends RmiStarter {
	
	public RequestLauncher() {
		super();
	}
	
	public void start() {
		try {
			// Get the request from the controller
			DatabaseRequest database_request = RetrieveDataController.GetDatabaseRequest();
			Registry registry = LocateRegistry.getRegistry();
			DataRequestInterface request_interface = (DataRequestInterface) registry.lookup(DataRequestInterface.SERVICE_NAME);
			RequestResponse response = request_interface.executeRequest(database_request);
			
			// Write the response in the controller
			RetrieveDataController.SetRequestResponse(response);
			RetrieveDataController.onCompleteRmi();
		}
		catch (Exception e) {
			System.err.println(e.getMessage());
		}
	}
}
