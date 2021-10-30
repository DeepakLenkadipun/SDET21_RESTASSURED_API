package SDET21.ParametersAndAuthentication;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

import java.util.HashMap;

public class BarerToken {
	
	@Test
	
	public void barertoken() {
		
		//create the data
		HashMap map=new HashMap();
		map.put("name", "REST-SDET-BARER-Token");
		
		given()
		.auth()
		.oauth2("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")
		.body(map)
		.when()
		.post("https://api.github.com/user/repos")
		
		.then().log().all()	;	
	}

}
