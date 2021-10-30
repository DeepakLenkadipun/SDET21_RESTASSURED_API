package SDET21.ParametersAndAuthentication;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

public class BasicAuthn {
	
	@Test
	
	public void basicAuthn() {
		baseURI="http://localhost";
		port=8084;
		given()
		.auth()
		.basic("rmgyantra", "rmgy@9999")
		
		.when()
		.get("/login")
		
        .then().assertThat().statusCode(202).log().all();	
}

}
