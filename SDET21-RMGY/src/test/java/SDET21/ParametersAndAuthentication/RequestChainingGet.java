package SDET21.ParametersAndAuthentication;

import org.testng.annotations.Test;

import SDET21.Genericutils.JavaUtility;
import SDET21.POJOCLASS.ProjectLibrary;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

public class RequestChainingGet {
	
	@Test
	
	public void requestChainigForGet() {
		JavaUtility jLib=new JavaUtility();
		baseURI="http://localhost";
		port=8084;
		
		//create a project
		ProjectLibrary pLib=new ProjectLibrary("Deepak"+jLib.getRandomNumber(), "amex "+jLib.getRandomNumber(), "Completed", 50);
	     Response res=	given()
		.contentType(ContentType.JSON)
		.body(pLib)
		.when()
		.post("/addProject");
	     
	    String myprojID =res.jsonPath().get("projectId");
	    System.out.println(myprojID);
	    
	    res.then().log().all();
		
		//this is string request to read the same project created in 1sr request
	    given()
	    .pathParam("projID", myprojID)
	    
	    .when()
	    .get("/projects/{projID}")
	    
	    .then().assertThat().statusCode(200).log().all();
		
	}

}
