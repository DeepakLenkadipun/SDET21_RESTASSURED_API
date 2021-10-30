package SDET21.ComplexResponsevalidation;

import static io.restassured.RestAssured.*;

import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.response.Response;

public class DynamicResponse {
	
	@Test
	public void dynamicResponse() {
		baseURI="http://localhost";
		port=8084;
		
		String expdata="FireFox";
		
		//store the response
		Response res=when().get("/projects");
		
		//capture all the project name and store in a string
		List<String> ProjName=res.jsonPath().get("projectName");
		
		for(String actData:ProjName) 
		{
			System.out.println(actData);
			if(actData.equals(expdata)) {
				
				Assert.assertEquals(actData, expdata);
				System.out.println(actData+" data present");
				break;
			}
		}
		
		//validation
		res.then().log().all();
		
	}

}
