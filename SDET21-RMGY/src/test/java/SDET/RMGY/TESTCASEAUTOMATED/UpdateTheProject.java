package SDET.RMGY.TESTCASEAUTOMATED;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.port;

import org.testng.annotations.Test;

import SDET21.POJOCLASS.ProjectLibrary;
import io.restassured.http.ContentType;

public class UpdateTheProject {
	
	@Test
	
	public void updateTheProject() {
		baseURI="http://localhost";
		port=8084;
		//read data through pojo class
		ProjectLibrary pLib=new ProjectLibrary("rmgTestYantra", "rmgProjectmp", "Ok", 10);
		given()
		.contentType(ContentType.JSON)
		.body(pLib)
		
		//actual request
		.when()
		.put("/projects/TY_PROJ_813")
		
		//validation
		.then()
		.assertThat()
		.statusCode(200)
		.contentType(ContentType.JSON)
		.log().all();
		
		
	}
	

}
