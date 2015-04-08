package controller;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

import rmi.base.DataRequestInterface;
import rmi.base.DatabaseRequest;
import rmi.base.RequestResponse;
import rmi.base.RmiStarter;

public class RequestLauncher extends RmiStarter {
	private DatabaseRequest database_request;
	private RequestResponse request_response;
	
	public RequestLauncher(DatabaseRequest request) {
		this.database_request = request;
		this.request_response = null;
		super();
	}
	
	public void start() {
		try {
			Registry registry = LocateRegistry.getRegistry();
			DataRequestInterface request_interface = (DataRequestInterface) registry.lookup(DataRequestInterface.SERVICE_NAME);
			RequestResponse response = request_interface.executeRequest(database_request);
			this.request_response = response;
		}
		catch (Exception e) {
			System.err.println(e.getMessage());
		}
	}
	
	public RequestResponse getResponse() {
		return this.request_response;
	}

}
