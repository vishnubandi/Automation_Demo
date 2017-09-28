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

public class HS_TS005_Contract_SchedRef_Check 
{
  @Test
  public void HS_Contract_SchedRef_TC012() throws SQLException 
  {
	  try
	  {
		  Class.forName("com.mysql.jdbc.Driver");
		  Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3307/homeserve","root","mysql");   
		  Statement stmt=con.createStatement();  
		  ResultSet rs=stmt.executeQuery("SELECT * FROM homeserve.transtopartner_mdu where HS_Contract_SchedRef=0"); 
		  while (rs.next()) 
		  {
			  rs.last();
			  int t=rs.getRow();
			  if(t!=0)
			  {
				  Assert.assertEquals("HS_Contract_SchedRef can not be Zero", 0, t);
			  }
			  else
			  {
				  Assert.assertEquals("HS_Contract_SchedRef Check is PASSED", 0, t);
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
	  public void HS_Contract_SchedRef_TC013() throws SQLException 
	  {
		  try
		  {
			  Class.forName("com.mysql.jdbc.Driver");
			  Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3307/homeserve","root","mysql");   
			  Statement stmt=con.createStatement();  
			  ResultSet rs=stmt.executeQuery("SELECT * FROM homeserve.transtopartner_mdu where HS_Contract_SchedRef is null or length(HS_Contract_SchedRef)=0 or HS_Contract_SchedRef=' ';"); 
			  while (rs.next()) 
			  {
				  rs.last();
				  int t=rs.getRow();
				  if(t!=0)
				  {
					  Assert.assertEquals("HS_Contract_SchedRef Is Mandatory", 0, t);
				  }
				  else
				  {
					  Assert.assertEquals("HS_Contract_SchedRef Check is PASSED", 0, t);
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
