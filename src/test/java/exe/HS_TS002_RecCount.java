package exe;

import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

import junit.framework.Assert;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;

import org.testng.Reporter;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;

public class HS_TS002_RecCount 
{
	  @Test
	  public void HS_FileLevelRecCount_TC003() throws ClassNotFoundException, SQLException 
	  {
		  try 
		  {
			  Workbook w=Workbook.getWorkbook(new File("C:\\Artha\\TransToPartner_MDU_11042015_002020.xls"));
			  Sheet wrksheet = w.getSheet("MDU_11042015");
		// File level Rows Count
			  int rows=wrksheet.getRows();
			  
		// File level Columns Count
			  int cols=wrksheet.getColumns();
			  
			  w.close();
			  Class.forName("com.mysql.jdbc.Driver");  
			  Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3307/homeserve","root","mysql");   
			  Statement stmt=con.createStatement();  
			  ResultSet rs=stmt.executeQuery("select * from transtopartner_mdu"); 
		// Database Level Columns Count
			  ResultSetMetaData rsmd = rs.getMetaData();
			  int columnsNumber = rsmd.getColumnCount();
			  		  
			
			 if(cols==columnsNumber)
			  {
				 Assert.assertEquals("Columns Count check is Passed",cols, columnsNumber);
			  }
			  else
			  {
				  Assert.assertEquals("Column Counts are Mismatched",cols, columnsNumber);
			  }
		 // Database Level Row Count
			  while (rs.next()) 
			  {
				  rs.last();
				  int t=rs.getRow();	
				  if(rows==t)
				  {
					  Assert.assertEquals("Row count Check Pass",rows, t);
				  }
				  else
				  {
					  Assert.assertEquals("Row count Check Fail",rows, t);
				  }
			  }
		  } 
		  catch (BiffException e) 
		  {
			// TODO Auto-generated catch block
			e.printStackTrace();
		  } 
		  catch (IOException e) 
		  {
			// TODO Auto-generated cat cols=wrksheetch block
			e.printStackTrace();
		}
	  }
}
