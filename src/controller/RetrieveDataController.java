package controller;

import rmi.base.DatabaseRequest;
import rmi.base.RequestResponse;

public class RetrieveDataController {
	
	private static DatabaseRequest database_request;
	private static RequestResponse request_response;
	
	public RetrieveDataController() {
		
	}
	
	public void execute(int mode, int outlet) {
		try {
			// Create the DatabaseRequest
			database_request = new DatabaseRequest(mode, outlet);
			new RequestLauncher();
		}
		catch (Exception e) {
			System.err.println(e.getMessage());
		}
	}
	
	public RequestResponse getResponse() {
		return request_response;
	}
	
	public static void SetRequestResponse(RequestResponse to_set) {
		request_response = to_set;
	}
	
	public static DatabaseRequest GetDatabaseRequest() {
		return database_request;
	}
	
	public static void onCompleteRmi() {
		System.out.println(request_response.toString());
	}
}
