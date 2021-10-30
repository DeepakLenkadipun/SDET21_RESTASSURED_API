package SDET21.ParametersAndAuthentication;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

public class Pathparameter {
	
	@Test
	
	public void pathParameter()
	{
		baseURI=("http://localhost");
		port=8084;
		
		given()
		.pathParam("projectId", "TY_PROJ_209")
		
		.when()
	    .get("/projects/{projectId}")
	
	    .then()
	    .assertThat()
	    .statusCode(200)
	    .log().all();
	
	}

}
