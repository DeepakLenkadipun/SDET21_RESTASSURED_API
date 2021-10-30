package SDET.RMGY.TESTCASEAUTOMATED;

import org.testng.annotations.Test;

import SDET21.POJOCLASS.ProjectLibrary;
import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

public class CreatetheprojectWithStatusCreated_08 {

	@Test
	
	public void CreatetheprojectWithStatusCreated() {
		baseURI="http://localhost";
		port=8084;
		//read data through pojo class
		ProjectLibrary pLib=new ProjectLibrary("rmgTY", "rmgProjectmps", "created", 10);
		given()
		.contentType(ContentType.JSON)
		.body(pLib)
		
		//actual request
		.when()
		.post("/addProject")
		
		//validation
		.then()
		.assertThat()
		.statusCode(201)
		.contentType(ContentType.JSON)
		.log().all();
	}
	
}
