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

import org.testng.Reporter;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;

public class HS_TS003_Record_Type_DataValidation 
{
//Debt_Cancel Data Validations
	  @Test
	  public void HS_Record_Type_AS_Debt_Cancel_TC004() throws SQLException, BiffException, IOException 
	  {
		  Workbook w;
		  try 
		  {
			  Class.forName("com.mysql.jdbc.Driver");
			  Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3307/homeserve","root","mysql");   
			  Statement stmt=con.createStatement();  
			  ResultSet rs=stmt.executeQuery("select * from transtopartner_mdu where Record_Type='Debt_Cancel'"); 
			  w = Workbook.getWorkbook(new File("C:\\Artha\\TransToPartner_MDU_11042015_002020.xls"));
			  Sheet s = w.getSheet("MDU_11042015");
			  int c=0;
			  for(int i=0;i<s.getRows();i++)
			  {
				  if(s.getCell(0,i).getContents().equalsIgnoreCase("Debt_Cancel"))
				  {
					  c=c+1;
				  }	
			  } 
			  while (rs.next()) 
			  {
				  rs.last();
				  int t=rs.getRow();
				 
				  if(t==c)
				  {
					  Assert.assertEquals("Debt_Cancel counts are Equal",c, t);
					  System.out.println("Debt_Cancel counts are Equal");
				  }
				  else
				  {
					  Assert.assertEquals("Debt_Cancel counts are Not Equal",c, t);
					  System.out.println("Debt_Cancel counts are Not Equal");	  
				  }
			  }
		  }
			  catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}  
  }
  @Test
  public void HS_Record_Type_AS_Debt_Delinquent_Letter_TC005() throws SQLException, BiffException, IOException 
  {
////Debt_Delinquent_Letter Data Validations
		  Workbook w;
		  try 
		  {
			  Class.forName("com.mysql.jdbc.Driver");
			  Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3307/homeserve","root","mysql");   
			  Statement stmt=con.createStatement();  
			  ResultSet rs=stmt.executeQuery("select * from transtopartner_mdu where Record_Type='Debt_Delinquent_Letter'"); 
			  w = Workbook.getWorkbook(new File("C:\\Artha\\TransToPartner_MDU_11042015_002020.xls"));
			  Sheet s = w.getSheet("MDU_11042015");
			  int c=0;
			  for(int i=0;i<s.getRows();i++)
			  {
				  if(s.getCell(0,i).getContents().equalsIgnoreCase("Debt_Delinquent_Letter"))
				  {
					  c=c+1;
				  }	
			  } 
			  while (rs.next()) 
			  {
				  rs.last();
				  int t=rs.getRow();
				  if(t==c)
				  {
					  Assert.assertEquals("Debt_Delinquent_Letter counts are Equal",c, t);
					  System.out.println("Debt_Delinquent_Letter counts are Equal");
				  }
				  else
				  {
					  Assert.assertEquals("Debt_Delinquent_Letter counts are Not Equal",c, t);
					  System.out.println("Debt_Delinquent_Letter counts are Not Equal");	  
				  }
			  }
		  }
			  catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}  
  }
  @Test
  public void HS_Record_Type_AS_HS_DownGrade_TC006() throws SQLException, BiffException, IOException 
  {
// HS_DownGrade validations
	  Workbook w;
	  try 
	  {
		  Class.forName("com.mysql.jdbc.Driver");
		  Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3307/homeserve","root","mysql");   
		  Statement stmt=con.createStatement();  
		  ResultSet rs=stmt.executeQuery("select * from transtopartner_mdu where Record_Type='HS_DownGrade'"); 
		  w = Workbook.getWorkbook(new File("C:\\Artha\\TransToPartner_MDU_11042015_002020.xls"));
		  Sheet s = w.getSheet("MDU_11042015");
		  int c=0;
		  for(int i=0;i<s.getRows();i++)
		  {
			  if(s.getCell(0,i).getContents().equalsIgnoreCase("HS_DownGrade"))
			  {
				  c=c+1;
			  }	
		  } 
		  while (rs.next()) 
		  {
			  rs.last();
			  int t=rs.getRow();
			  if(t==c)
			  {
				  Assert.assertEquals("HS_DownGrade counts are Equal",c, t);
				  System.out.println("HS_DownGrade counts are Equal");
			  }
			  else
			  {
				  Assert.assertEquals("HS_DownGrade counts are Not Equal",c, t);
				  System.out.println("HS_DownGrade counts are Not Equal");	  
			  }
		  }
	  }
		  catch (ClassNotFoundException e1) {
		// TODO Auto-generated catch block
		e1.printStackTrace();
	}  
  }
  @Test
  public void HS_Record_Type_AS_HS_Price_Increase_TC007() throws SQLException, BiffException, IOException 
  {
//HS_Price_Increase Data validations
	  Workbook w;
	  try 
	  {
		  Class.forName("com.mysql.jdbc.Driver");
		  Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3307/homeserve","root","mysql");   
		  Statement stmt=con.createStatement();  
		  ResultSet rs=stmt.executeQuery("select * from transtopartner_mdu where Record_Type='HS_Price_Increase'"); 
		  w = Workbook.getWorkbook(new File("C:\\Artha\\TransToPartner_MDU_11042015_002020.xls"));
		  Sheet s = w.getSheet("MDU_11042015");
		  int c=0;
		  for(int i=0;i<s.getRows();i++)
		  {
			  if(s.getCell(0,i).getContents().equalsIgnoreCase("HS_Price_Increase"))
			  {
				  c=c+1;
			  }	
		  } 
		  while (rs.next()) 
		  {
			  rs.last();
			  int t=rs.getRow();
			  if(t==c)
			  {
				  Assert.assertEquals("HS_Price_Increase counts are Equal",c, t);
				  System.out.println("HS_Price_Increase counts are Equal");
			  }
			  else
			  {
				  Assert.assertEquals("HS_Price_Increase counts are Not Equal",c, t);
				  System.out.println("HS_Price_Increase counts are Not Equal");	  
			  }
		  }
	  }
		  catch (ClassNotFoundException e1) {
		// TODO Auto-generated catch block
		e1.printStackTrace();
	}  
  }
  @Test
  public void HS_Record_Type_AS_NULL_TC008() throws SQLException, BiffException, IOException 
  {
//Null check
	  Workbook w;
	  try 
	  {
		  Class.forName("com.mysql.jdbc.Driver");
		  Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3307/homeserve","root","mysql");   
		  Statement stmt=con.createStatement();  
		  ResultSet rs=stmt.executeQuery("select * from transtopartner_mdu where Record_Type is null"); 
		  w = Workbook.getWorkbook(new File("C:\\Artha\\TransToPartner_MDU_11042015_002020.xls"));
		  Sheet s = w.getSheet("MDU_11042015");
		  int c=0;
		  for(int i=0;i<s.getRows();i++)
		  {
			  if(s.getCell(0,i).getContents().equalsIgnoreCase(""))
			  {
				  System.out.println("Record_Type can not be Empty / Null");
			  }	
		  } 
		  while (rs.next()) 
		  {
			  rs.last();
			  int t=rs.getRow();
			  if(t==c)
			  {
				  Assert.assertEquals("Record_Type can not be Empty / Null",c, t);
				  System.out.println("Record_Type can not be Empty / Null");
			  }
		  }
	  }
		  catch (ClassNotFoundException e1) 
	  {
			  // TODO Auto-generated catch block
			  e1.printStackTrace();
	  }  
  }
}
