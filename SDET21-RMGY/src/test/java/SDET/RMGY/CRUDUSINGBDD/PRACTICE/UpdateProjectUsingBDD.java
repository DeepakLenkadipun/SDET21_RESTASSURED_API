package SDET.RMGY.CRUDUSINGBDD.PRACTICE;

import static org.junit.Assert.assertThat;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import io.restassured.http.ContentType;
import  io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class UpdateProjectUsingBDD {
	@Test
	public void updateProjectUsingDD() {
	JSONObject js = new JSONObject();

	js.put("createdBy", "Deepak");
	js.put("projectName", "QualiTest");
	js.put("status", "running");
	js.put("teamSize", 30);
	
     given()
	.contentType(ContentType.JSON)
	.body(js)
	.when()
	.put("http://localhost:8084/projects/TY_PROJ_206")
	.then()
	.log().all()
	.assertThat().statusCode(200)
	.assertThat().contentType(ContentType.JSON);
	}
}
