package SDET.RMGY.TESTCASEAUTOMATED;

import static io.restassured.RestAssured.*;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;

public class CreatetheprojectwithJsonFile_04 {
	
	@Test
	
	public void createTheProjectwithJsonFile() throws Throwable {
		//read the file
				FileInputStream fis=new FileInputStream("./data.json");
				
				//request specification
				given()
			    .contentType(ContentType.JSON)
				.body(fis)
				
				//actual request
				.when()
				.post("http://localhost:8084/addProject")
				
				//validation
				.then()
				.assertThat()
				.statusCode(201)
				.contentType(ContentType.JSON)
				.log().all();
				
			}
	

}
