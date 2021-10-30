package SDET21.Genericutils;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import  static io.restassured.RestAssured.*;

public class BaseApiClass {
	public DatabaseUtility dlib=new DatabaseUtility();
	public RestassuredUtilities rlib=new RestassuredUtilities();
	public JavaUtility jlib=new JavaUtility();
	
	
	@BeforeSuite
	public void bsConfig() throws Throwable {
		dlib.connecttoDB();
		baseURI="http://localhost";
		port=8084;
	}
	@AfterSuite
	public void asConfig() throws Throwable {
		dlib.closeDB();
	}
}
