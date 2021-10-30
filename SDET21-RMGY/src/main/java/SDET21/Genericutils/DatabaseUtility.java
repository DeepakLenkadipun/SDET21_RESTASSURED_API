package SDET21.Genericutils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.cj.jdbc.Driver;
import com.mysql.cj.xdevapi.Result;

public class DatabaseUtility {
	Driver driverref;
	Connection con;
	ResultSet result;
	public void connecttoDB() throws Throwable {
		DriverManager.registerDriver(driverref);
		con=DriverManager.getConnection(IpathConstants.dbUrl,IpathConstants.dbUsername,IpathConstants.dbPassword);
		
	}
	
	public void closeDB() throws Throwable {
		con.close();
	}
	
	public String executeQueryAndGetData(String query,int columnIndex,String expData) throws Throwable {
		Boolean flag=false;
		 result=con.createStatement().executeQuery(query);
		 while(result.next()) {
			 
			 String actData=result.getString(columnIndex);
			 if(actData.equalsIgnoreCase(expData)) {
				 flag=true;
				 break;
			 }
		 }
		 if(flag) {
			 System.out.println(expData+"data verified sucessfully");
			 return expData;
		 }else {
			 System.out.println(expData+" data not verified in db");
			 return "";
		 }
	}

}
