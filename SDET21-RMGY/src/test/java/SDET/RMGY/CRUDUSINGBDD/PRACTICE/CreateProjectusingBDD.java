package SDET.RMGY.CRUDUSINGBDD.PRACTICE;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

public class CreateProjectusingBDD {
	@Test
	
	public void createProjectusingBDD() {
		JSONObject jobj=new JSONObject();
		jobj.put("createdBy","Deepak");
		jobj.put("projectName","imfosys");
		jobj.put("status","completed");
		jobj.put("teamSize",30);
		
		given()
		.contentType(ContentType.JSON)
		.body(jobj)
		
		.when()
		.post("http://localhost:8084/addProject")
		
		.then()
		.assertThat()
		.statusCode(201)
		.log().all();
	}

}
