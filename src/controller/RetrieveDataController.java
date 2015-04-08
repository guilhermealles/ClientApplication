package controller;

import model.DatabaseRequest;
import model.RequestResponse;

public class RetrieveDataController {
	
	private RequestResponse request_response;
	
	public RetrieveDataController() {
		
	}
	
	public void execute(int mode, int outlet) {
		try {
			// Create the DatabaseRequest
			DatabaseRequest request = new DatabaseRequest(mode, outlet);
			RequestLauncher rmi_launcher = new RequestLauncher(request);
		}
		catch (Exception e) {
			System.err.println(e.getMessage());
		}
	}
	
	public RequestResponse getResponse() {
		return this.request_response;
	}
}
