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

public class HS_TS006_Phone_Number_Check 
{
	 @Test
	  public void HS_Premise_Home_Phone_Check_TC013() throws SQLException 
	  {
		  try
		  {
			  Class.forName("com.mysql.jdbc.Driver");
			  Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3307/homeserve","root","mysql");   
			  Statement stmt=con.createStatement();  
			  ResultSet rs=stmt.executeQuery("SELECT * FROM homeserve.transtopartner_mdu where Premise_Home_Phone_Number is null or length(Premise_Home_Phone_Number)=0 or Premise_Home_Phone_Number=' '"); 
			  while (rs.next()) 
			  {
				  rs.last();
				  int t=rs.getRow();
				  if(t!=0)
				  {
					  Assert.assertEquals("Premise_Home_Phone_Number is Mandatory", 0, t);
				  }
				  else
				  {
					  Assert.assertEquals("Premise_Home_Phone_Number Check is PASSED", 0, t);
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
	  public void HS_Premise_Home_Phone_Check_TC014() throws SQLException 
	  {
		  try
		  {
			  Class.forName("com.mysql.jdbc.Driver");
			  Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3307/homeserve","root","mysql");   
			  Statement stmt=con.createStatement();  
			  ResultSet rs=stmt.executeQuery("SELECT * FROM homeserve.transtopartner_mdu where length(Premise_Home_Phone_Number)<10"); 
			  while (rs.next()) 
			  {
				  rs.last();
				  int t=rs.getRow();
				  if(t!=0)
				  {
					  Assert.assertEquals("Premise_Home_Phone_Number length not less than 10 Digits", 0, t);
				  }
				  else
				  {
					  Assert.assertEquals("Premise_Home_Phone_Number Check is PASSED", 0, t);
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
	  public void HS_Premise_Work_Phone_Check_TC015() throws SQLException 
	  {
		  try
		  {
			  Class.forName("com.mysql.jdbc.Driver");
			  Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3307/homeserve","root","mysql");   
			  Statement stmt=con.createStatement();  
			  ResultSet rs=stmt.executeQuery("SELECT * FROM homeserve.transtopartner_mdu where length(Premise_Work_Phone_Number)<10"); 
			  while (rs.next()) 
			  {
				  rs.last();
				  int t=rs.getRow();
				  if(t!=0)
				  {
					  Assert.assertEquals("Premise_Work_Phone_Number length not less than 10 Digits", 0, t);
				  }
				  else
				  {
					  Assert.assertEquals("Premise_Work_Phone_Number Check is PASSED", 0, t);
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
	  public void HS_Premise_Work_Phone_Check_TC016() throws SQLException 
	  {
		  try
		  {
			  Class.forName("com.mysql.jdbc.Driver");
			  Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3307/homeserve","root","mysql");   
			  Statement stmt=con.createStatement();  
			  ResultSet rs=stmt.executeQuery("SELECT * FROM homeserve.transtopartner_mdu where length(Premise_Work_Phone_Number)<10"); 
			  while (rs.next()) 
			  {
				  rs.last();
				  int t=rs.getRow();
				  if(t!=0)
				  {
					  Assert.assertEquals("Premise_Work_Phone_Number length not less than 10 Digits", 0, t);
				  }
				  else
				  {
					  Assert.assertEquals("Premise_Work_Phone_Number Check is PASSED", 0, t);
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
	  public void HS_Premise_Work_Phone_Check_TC017() throws SQLException 
	  {
		  try
		  {
			  Class.forName("com.mysql.jdbc.Driver");
			  Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3307/homeserve","root","mysql");   
			  Statement stmt=con.createStatement();  
			  ResultSet rs=stmt.executeQuery("SELECT * FROM homeserve.transtopartner_mdu where Premise_Work_Phone_Number is null or length(Premise_Work_Phone_Number)=0 or Premise_Work_Phone_Number=' '"); 
			  while (rs.next()) 
			  {
				  rs.last();
				  int t=rs.getRow();
				  if(t!=0)
				  {
					  Assert.assertEquals("Premise_Work_Phone_Number Is Mandatory", 0, t);
				  }
				  else
				  {
					  Assert.assertEquals("Premise_Work_Phone_Number Check is PASSED", 0, t);
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
