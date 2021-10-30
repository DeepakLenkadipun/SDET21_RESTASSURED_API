package SDET21.RMGY.CRUD.PRACTICE;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class GetAllProjects {
	@Test
	
	public void getAllProjects() {
		//send the request
		Response res=RestAssured.get("http://localhost:8084/projects");
		
		//print the Response
		System.out.println(res.prettyPrint());  //print only the response body
		System.out.println(res.prettyPeek());  //print entire body with header
		System.out.println(res.getStatusCode());
	}

}
