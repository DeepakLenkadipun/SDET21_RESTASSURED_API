package SDET21.RMGY.CRUD.PRACTICE;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class DeleteProject {
	@Test
	
	public void deleteproject() 
	{
		
		Response res=RestAssured.delete("http://localhost:8084/projects/TY_PROJ_214");
		res.then().assertThat().statusCode(204);
		
	}

}
