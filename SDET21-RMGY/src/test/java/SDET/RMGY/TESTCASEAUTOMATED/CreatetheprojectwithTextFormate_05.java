package SDET.RMGY.TESTCASEAUTOMATED;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.port;

import org.testng.annotations.Test;

import SDET21.POJOCLASS.ProjectLibrary;
import static io.restassured.RestAssured.*;
import io.restassured.http.ContentType;

public class CreatetheprojectwithTextFormate_05 {
	
	@Test
	
	public void createtheprojectWithTextFormate() {
	
		
		baseURI="http://localhost";
		port=8084;
		
		//read data through pojo class
		ProjectLibrary pLib=new ProjectLibrary("rmg1", "rmgProject12", "created", 10);
		given()
		.contentType(ContentType.TEXT)
		.body(pLib)
		
		//actual request
		.when()
		.post("/addProject")
		
		//validation
		.then()
		.assertThat()
		.statusCode(201)
		.contentType(ContentType.TEXT)
		.log().all();
	}
	

}
