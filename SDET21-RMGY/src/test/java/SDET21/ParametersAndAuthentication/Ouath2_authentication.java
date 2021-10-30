package SDET21.ParametersAndAuthentication;

import static io.restassured.RestAssured.*;

import org.testng.annotations.Test;

import io.restassured.response.Response;

public class Ouath2_authentication {
	@Test
	public void ouath() {
		Response res=given()
		.formParam("client_id", "SDET21-RMGY-TYSS-REST")
		.formParam("client_secret", "0df0fb455a2242624c776e82763528fd")
		.formParam("grant_type", "client_credentials")
		.formParam("redirect_uri", "http://example.com")
		.formParam("code", "authorization_code")
		
		.when()
		.post("http://coop.apps.symfonycasts.com/token");
		
		//capture the token
		String Token=res.jsonPath().get("access_token");
		System.out.println(Token);
		
		//create a new request to acess the token
		
		given()
		.auth()
		.oauth2(Token)
		.pathParam("USER_ID", "2422")
		
		.when()
		.post("http://coop.apps.symfonycasts.com/api/{USER_ID}/eggs-collect")
		.then().log().all();
		
	}

}
