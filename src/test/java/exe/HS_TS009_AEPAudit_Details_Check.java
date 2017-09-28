package exe;

import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import junit.framework.Assert;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

import org.testng.Reporter;
import org.testng.annotations.Test;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;

public class HS_TS009_AEPAudit_Details_Check 
{
	public static String TC025c=null;
	public static String TC025s=null;
	public static String TC025r=null;
	public static String TC025rc=null;
	public static String TC025tr=null;
	public static String TC026tr=null;
	public static String TC026c=null;
	public static String TC026s=null;
	public static String TC026r=null;
	public static String TC026rc=null;
	@Test
	public void HS_AEPAudit_Date_Check_TC025() throws SQLException,BiffException, IOException 
	{
		  TC025c=this.getClass().getName().split("_")[1];
		  TC025s=Thread.currentThread().getStackTrace()[1].getMethodName().split("_")[Thread.currentThread().getStackTrace()[1].getMethodName().split("_").length-1];
		Workbook w;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3307/homeserve", "root", "mysql");
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT *,count(*) AS reccount1  FROM homeserve.aepaudit where datediff(ExpDate,EffDate)<0");
			while (rs.next()) 
			{
			   	int t=rs.getRow();
				if(rs.getRow()<0)
				{
					TC025r="AEPAudit Date Check is as Expected at UniqueID= "+rs.getString("UniqueID");
					TC025tr="PASSED";
					TC025rc=rs.getString("reccount1");
					Assert.assertEquals("AEPAudit Date Check is as Expected at UniqueID= "+rs.getString("UniqueID")+" Reason as ",0, t);
				}
				else
				{
					TC025r="AEPAudit Date Check is Failed at UniqueID= "+rs.getString("UniqueID");
					TC025tr="Failed";
					TC025rc=rs.getString("reccount1");
					Assert.assertEquals("AEPAudit Date Check is Failed at UniqueID= "+rs.getString("UniqueID")+" Reason as ",0, t);					
				}
			}
		}
		catch (ClassNotFoundException e1) 
		{
			e1.printStackTrace();
		}
	}
	@Test(priority=1)
	public void HS_AEPAudit_ProductCodes_Null_Check_TC026() throws SQLException,BiffException, IOException 
	{
		  TC026c=this.getClass().getName().split("_")[1];
		  TC026s=Thread.currentThread().getStackTrace()[1].getMethodName().split("_")[Thread.currentThread().getStackTrace()[1].getMethodName().split("_").length-1];
		Workbook w;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3307/homeserve", "root", "mysql");
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT *,count(*) AS reccount1 FROM homeserve.aepaudit where ProdCodes is null");
			while (rs.next()) 
			{
			   	int t=rs.getRow();
				if(rs.getRow()<0)
				{
					TC026r="AEPAudit Product Codes Check is as Expected at UniqueID= "+rs.getString("UniqueID");
					TC026tr="PASSED";
					TC026rc=rs.getString("reccount1");
					Assert.assertEquals("AEPAudit Product Codes Check is as Expected at UniqueID= "+rs.getString("UniqueID")+" Reason as ",0, t);
				}
				else
				{
					TC026r="AEPAudit Product Codes Check is Failed at UniqueID= "+rs.getString("UniqueID");
					TC026tr="Failed";
					TC026rc=rs.getString("reccount1");
					Assert.assertEquals("AEPAudit Product Codes Check is Failed at UniqueID= "+rs.getString("UniqueID")+" Reason as ",0, t);					
				}
			}
		}
		catch (ClassNotFoundException e1) 
		{
			e1.printStackTrace();
		}
	}
}
