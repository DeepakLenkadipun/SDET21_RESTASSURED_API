package SDET21.RMGY.CRUD.PRACTICE;

import static org.junit.Assert.assertThat;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class UpdateProject {
	@Test
	public void updateproject() {
		JSONObject js = new JSONObject();

		js.put("createdBy", "Deepak");
		js.put("projectName", "TYSS");
		js.put("status", "Completed");
		js.put("teamSize", 40);
		RequestSpecification req = RestAssured.given();
		req.contentType(ContentType.JSON);
		req.body(js);
		Response res = req.put("http://localhost:8084/projects/TY_PROJ_202");
		res.then().assertThat().statusCode(200);
	}
}
