package SDET.RMGY.CRUDUSINGBDD.PRACTICE;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import io.restassured.response.Response;

public class DeleteProjectUsingBDD {
	
	@Test
	
	public void deleteProjectUsingBDD() {
		
		when()
		.delete("http://localhost:8084/projects/TY_PROJ_207")
		.then()
		.log().all()
		.assertThat()
		.statusCode(204);
		
	}
	

}
