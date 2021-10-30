package SDET21_EndToEndRMGY;

import org.testng.annotations.Test;

import SDET21.Genericutils.BaseApiClass;
import SDET21.Genericutils.EndPoints;
import SDET21.POJOCLASS.ProjectLibrary;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import junit.framework.Assert;

import static io.restassured.RestAssured.*;

public class CreateProjectandVerifyInDataBase extends BaseApiClass {
	
	@Test
	public void createProjectAndVerifyInDB() throws Throwable {
		//create a project through Api
		ProjectLibrary pLib=new ProjectLibrary("DeepakLenka"+jlib.getRandomNumber(), "Google"+jlib.getRandomNumber(), "Created", 40);
		Response res=given()
		.contentType(ContentType.JSON)	
		.body(pLib)
		.when()
		.post(EndPoints.addProject);
		res.then().log().all();
		
		//capture the expected data
		String expData=rlib.getJsonData(res, "projectName");
		System.out.println(expData);
		//verify in the database
		String query="select * from project";
		String actData=dlib.executeQueryAndGetData(query, 4, expData);
		
		//validate
		Assert.assertEquals(actData, expData);
		System.out.println("Sucessful");
		
	}

}
