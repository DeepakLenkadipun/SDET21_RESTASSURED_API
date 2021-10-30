package SDET.RMGY.TESTCASEAUTOMATED;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

import java.util.HashMap;

public class CreatetheprojectwithkeyValuePair_07 {
	
	@Test
	
	public void createtheprojectwithkeyValuePair() {
		HashMap map=new HashMap();
		map.put("createdBy", "dipunLenka");
		map.put("projectName", "FireFox");
		map.put("status", "Completed");
		map.put("teamSize", "20");
		
		//pre condition
		given()
		.contentType(ContentType.JSON)
		.body(map)
		
		//actual request
		.when()
		.post("http://localhost:8084/addProject")
		
		//validation
		.then()
		.assertThat()
		.statusCode(201)
		.contentType(ContentType.JSON)
		.log().all();
	}
	

}
