package exe;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import junit.framework.Assert;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;

public class HS_TS004_Mandatory_Column_Check 
{
	  @Test
	  public void HS_Premise_City_Mandatory_Check_TC008() throws SQLException 
	  {
		  try
		  {
			  Class.forName("com.mysql.jdbc.Driver");
			  Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3307/homeserve","root","mysql");   
			  Statement stmt=con.createStatement();  
			  ResultSet rs=stmt.executeQuery("SELECT * FROM homeserve.transtopartner_mdu where Premise_City is null or Premise_City=' ' or Premise_City=''"); 
			  while (rs.next()) 
			  {
				  rs.last();
				  int t=rs.getRow();
				  if(t!=0)
				  {
					  Assert.assertEquals("Premise_City is not Null | Mandatory", 0, t);
				  }
				  else
				  {
					  Assert.assertEquals("Premise_City Mandatory Check is PASSED", 0, t);
				  }
			  }
		  }
		  catch (ClassNotFoundException e1) 
		  {
				  // TODO Auto-generated catch block
				  e1.printStackTrace();
		  } 
	  }
	  @Test
	  public void HS_Premise_State_Mandatory_Check_TC009() throws SQLException 
	  {
		  try
		  {
			  Class.forName("com.mysql.jdbc.Driver");
			  Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3307/homeserve","root","mysql");   
			  Statement stmt=con.createStatement();  
			  ResultSet rs=stmt.executeQuery("SELECT * FROM homeserve.transtopartner_mdu where Premise_State is null or Premise_State=' ' or Premise_State=''"); 
			  while (rs.next()) 
			  {
				  rs.last();
				  int t=rs.getRow();
				  if(t!=0)
				  {
					  Assert.assertEquals("Premise_State is not Null | Mandatory", 0, t);
				  }
				  else
				  {
					  Assert.assertEquals("Premise_State Mandatory Check is PASSED", 0, t);
				  }
			  }
		  }
		  catch (ClassNotFoundException e1) 
		  {
				  // TODO Auto-generated catch block
				  e1.printStackTrace();
		  } 
	  }
	  @Test
	  public void HS_Mailing_City_Mandatory_Check_TC010() throws SQLException 
	  {
		  try
		  {
			  Class.forName("com.mysql.jdbc.Driver");
			  Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3307/homeserve","root","mysql");   
			  Statement stmt=con.createStatement();  
			  ResultSet rs=stmt.executeQuery("SELECT * FROM homeserve.transtopartner_mdu where Mailing_City is null or Mailing_City=' ' or Mailing_City=''"); 
			  while (rs.next()) 
			  {
				  rs.last();
				  int t=rs.getRow();
				  if(t!=0)
				  {
					  Assert.assertEquals("Mailing_City is not Null | Mandatory", 0, t);
				  }
				  else
				  {
					  Assert.assertEquals("Mailing_City Mandatory Check is PASSED", 0, t);
				  }
			  }
		  }
		  catch (ClassNotFoundException e1) 
		  {
				  // TODO Auto-generated catch block
				  e1.printStackTrace();
		  } 
	  }
	  @Test
	  public void HS_Partner_Account_Number_Mandatory_And_Length_Check_TC011() throws SQLException 
	  {
		  try
		  {
			  Class.forName("com.mysql.jdbc.Driver");
			  Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3307/homeserve","root","mysql");   
			  Statement stmt=con.createStatement();  
			  ResultSet rs=stmt.executeQuery("SELECT * FROM homeserve.transtopartner_mdu where length(Partner_Account_Number)<10 or Partner_Account_Number is null or Partner_Account_Number=' ' or Partner_Account_Number=''"); 
			  while (rs.next()) 
			  {
				  rs.last();
				  int t=rs.getRow();
				  if(t!=0)
				  {
					  Assert.assertEquals("Partner_Account_Number is not Null or Length of Account number is not Correct", 0, t);
				  }
				  else
				  {
					  Assert.assertEquals("Partner_Account_Number Check is PASSED", 0, t);
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
