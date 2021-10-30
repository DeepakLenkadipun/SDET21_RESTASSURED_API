package SDET21.RMGY.CRUD.PRACTICE;

import static io.restassured.RestAssured.*;

import org.testng.annotations.Test;

import SDET21.Genericutils.JavaUtility;
import SDET21.POJOCLASS.ProjectLibrary;
import io.restassured.http.ContentType;

public class CreateProjectUsingPOJO {
	
	@Test
	
	public void createProjectUsingPOJO() 
	
	{
		JavaUtility jlib=new JavaUtility();
		baseURI="http://localhost";
		port=8084;
		//read data through pojo class
		ProjectLibrary pLib=new ProjectLibrary("DEEpakkumarLenka "+jlib.getRandomNumber(), 
				                                     "ActionLabs "+jlib.getRandomNumber(), "Completed", 20);
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
