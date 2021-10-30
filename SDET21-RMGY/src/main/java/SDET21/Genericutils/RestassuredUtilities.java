package SDET21.Genericutils;

import io.restassured.response.Response;

public class RestassuredUtilities {

	
	public String getJsonData(Response res,String jsonPath) {
		
		String value=res.jsonPath().get(jsonPath);
		return value;
		}
}
