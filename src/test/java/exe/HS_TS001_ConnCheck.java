package exe;

import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;

import org.testng.Reporter;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;

public class HS_TS001_ConnCheck 
{
// Database Connection Check
  @Test
  public void HS_DBConnCheck_TC001() 
  {
	  try
	  {
		  	Class.forName("com.mysql.jdbc.Driver");  
		  	Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3307/homeserve","root","mysql");
		  	Statement stmt=con.createStatement();  
			ResultSet rs=stmt.executeQuery("select * from transtopartner_mdu");  
			while(rs.next()) 
			{
				Reporter.log("Database Connection is Passed");
			}
	  }
	  catch(Exception e)
	  {
		  System.out.println(e);
	  }
	  
  }
// File Existance
  @Test
  public void HS_InputFileExistance_TC002() throws WriteException 
  {
	  try
	  {
		  Workbook w=Workbook.getWorkbook(new File("C:\\Artha\\TransToPartner_MDU_11042015_002020.xls"));
		  Sheet wrksheet = w.getSheet("Sheet1");
		  File file = new File("C:\\Artha\\TransToPartner_MDU_11042015_002020.xls");  
		     if (!file.exists()) 
		     {  
		    	 Reporter.log("Input File Check is Passed");
		     }
		     w.close();
	  }
	  catch(IOException e) 
	  {
          e.printStackTrace();
      } catch (BiffException e) 
	  {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
  }
}
