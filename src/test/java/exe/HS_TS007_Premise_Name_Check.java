package exe;

import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import junit.framework.Assert;
import jxl.Workbook;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;
import jxl.write.biff.RowsExceededException;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;

public class HS_TS007_Premise_Name_Check 
{
	
	public static String TC018c=null;
	public static String TC018s=null;
	public static String TC018r=null;
	public static String TC018tr=null;
	public static String TC019tr=null;
	public static String TC019c=null;
	public static String TC019s=null;
	public static String TC019r=null;
	public static String TC018rc=null;
	public static String TC019rc=null;
	 @Test(priority=1)
	  public void HS_Premise_First_Name_Check_TC018() throws SQLException, RowsExceededException, WriteException, IOException 
	  {
		 StringBuffer TC018rec=new StringBuffer();
		  TC018c=this.getClass().getName().split("_")[1];
		  TC018s=Thread.currentThread().getStackTrace()[1].getMethodName().split("_")[Thread.currentThread().getStackTrace()[1].getMethodName().split("_").length-1];
		  try
		  {
			  Class.forName("com.mysql.jdbc.Driver");
			  Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3307/homeserve","root","mysql");   
			  Statement stmt=con.createStatement();  
			  ResultSet rs=stmt.executeQuery("SELECT *,count(*) AS reccount FROM homeserve.transtopartner_mdu where First_Name is null"); 
			  while (rs.next()) 
			  {
				  rs.last();
				  int t=rs.getRow();
				  if(t!=0)
				  {
					  TC018r="Premise First Name is Mandatory column at 'transtopartner_mdu'";
					  TC018tr="Failed";
					  TC018rc=rs.getString("reccount");
					  Assert.assertEquals("Premise_First_Name is Mandatory, it's failed", 0, t);
				  }
				  else
				  {
					  TC018tr="PASSED";
					  Assert.assertEquals("Premise_First_Name Check is PASSED", 0, t);
				  }
			  }
		  }
		  catch (ClassNotFoundException e1) 
		  {
				  e1.printStackTrace();
		  } 		  
	  }
	 @Test(priority=2)
	  public void HS_Premise_Last_Name_Check_TC019() throws SQLException, RowsExceededException, WriteException, IOException 
	  {
		  TC019c=this.getClass().getName().split("_")[1];
		  TC019s=Thread.currentThread().getStackTrace()[1].getMethodName().split("_")[Thread.currentThread().getStackTrace()[1].getMethodName().split("_").length-1];
		  try
		  {
			  StringBuffer TC019rec=new StringBuffer();
			  Class.forName("com.mysql.jdbc.Driver");
			  Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3307/homeserve","root","mysql");   
			  Statement stmt=con.createStatement();  
			  ResultSet rs=stmt.executeQuery("SELECT *,count(*) AS reccount FROM homeserve.transtopartner_mdu where Last_Name is null"); 
			  List<String> TC001rs=new ArrayList<String>();
			  while (rs.next()) 
			  {
				  rs.last();
				  int t=rs.getRow();
				  TC001rs.add(rs.getString("UniqueID"));
				  if(t!=0)
				  {
					  for(int i=0;i<TC001rs.size();i++)
						{
						  	TC019rec.append(TC001rs.get(i)+","); 
						}
					  TC019r="Premise Last Name is Failed at UniqueID="+TC019rec+"Mandatory Column at 'transtopartner_mdu'";
					  TC019tr="Failed";
					  TC019rc=rs.getString("reccount");
					  Assert.assertEquals("Premise_Last_Name is Mandatory", 0, t);
				  }
				  else
				  {
					  TC019r="Premise Last Name Check is PASSED";
					  TC019tr="PASSED";
					  TC019rc=rs.getString("reccount");

					  Assert.assertEquals("Premise_Last_Name Check is PASSED", 0, t);
				  }
			  }
		  }
		  catch (ClassNotFoundException e1) 
		  {
				  e1.printStackTrace();
		  }
	  }
}
