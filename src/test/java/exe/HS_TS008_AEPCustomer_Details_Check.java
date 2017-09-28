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
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;
import jxl.write.biff.RowsExceededException;

import org.testng.Reporter;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterClass;

public class HS_TS008_AEPCustomer_Details_Check 
{
	public static String TC020c=null;
	public static String TC020s=null;
	public static String TC020r=null;
	public static String TC021c=null;
	public static String TC021s=null;
	public static String TC021r=null;
	public static String TC022c=null;
	public static String TC022s=null;
	public static String TC022r=null;
	public static String TC023c=null;
	public static String TC023s=null;
	public static String TC023r=null;
	public static String TC024c=null;
	public static String TC024s=null;
	public static String TC024r=null;
	public static String TC020tr=null;
	public static String TC021tr=null;
	public static String TC022tr=null;
	public static String TC023tr=null;
	public static String TC024tr=null;
	public static String TC020rc=null;
	public static String TC021rc=null;
	public static String TC022rc=null;
	public static String TC023rc=null;
	public static String TC024rc=null;
	
	@Test(priority=1)
	public void HS_AEPCustomer_FirstName_Check_TC020() throws SQLException,BiffException, IOException 
	{
		Workbook w;
		TC020c=this.getClass().getName().split("_")[1];
		TC020s=Thread.currentThread().getStackTrace()[1].getMethodName().split("_")[Thread.currentThread().getStackTrace()[1].getMethodName().split("_").length-1];
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3307/homeserve", "root", "mysql");
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM homeserve.aepcustomer where FirstName is not null");
			w = Workbook.getWorkbook(new File("C:\\Artha\\TransToPartner_MDU_11042015_002020.xls"));
			Sheet s = w.getSheet("AEPCustomer20150801");
			int c = 0;
			List<String> exceldata=new ArrayList<String>();
			List<String> dbdata=new ArrayList<String>();
			for (int i = 1; i < s.getRows(); i++) 
			{
				exceldata.add(s.getCell(0, i).getContents());
			}
			while (rs.next()) 
			{
				dbdata.add(rs.getString("FirstName"));
			}
			for(int i=0;i<exceldata.size();i++)
			{
				if(exceldata.get(i).equalsIgnoreCase(dbdata.get(i)))
				{
					TC020r="AEP Partner First name Check is as Expected";
					TC020tr="PASSED";
					TC020rc=Integer.toString(exceldata.size());
					Assert.assertEquals("AEP Partner First name Check is as Expected",exceldata.get(i), dbdata.get(i));
				}
				else
				{
					TC020r="AEP Partner First name Check is Failed";
					TC020tr="Failed";
					TC020rc=Integer.toString(exceldata.size());
					Assert.assertEquals("AEP Partner First name Check is Failed",exceldata.get(i), dbdata.get(i));
				}
			}
		}
		catch (ClassNotFoundException e1) 
		{
			e1.printStackTrace();
		}
	}

	
	@Test(priority=1)
	public void HS_AEPCustomer_LastName_Check_TC021() throws SQLException,BiffException, IOException 
	{
		TC021c=this.getClass().getName().split("_")[1];
		TC021s=Thread.currentThread().getStackTrace()[1].getMethodName().split("_")[Thread.currentThread().getStackTrace()[1].getMethodName().split("_").length-1];
		Workbook w;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3307/homeserve", "root", "mysql");
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT LastName,UID,UniqueID FROM homeserve.aepcustomer");
			w = Workbook.getWorkbook(new File("C:\\Artha\\TransToPartner_MDU_11042015_002020.xls"));
			Sheet s = w.getSheet("AEPCustomer20150801");
			List<String> exceldata=new ArrayList<String>();
			List<String> dbdata=new ArrayList<String>();
			int c=0;
			for (int i = 1; i < s.getRows(); i++) 
			{
				if(s.getCell(2, i).getContents().equalsIgnoreCase(""))
				{
					exceldata.add(s.getCell(0, i).getContents());
				}
				else
				{
					exceldata.add(s.getCell(2, i).getContents());
				}
			}
			while (rs.next()) 
			{
				dbdata.add(rs.getString("LastName"));
			}
			for(int i=0;i<exceldata.size();i++)
			  {
				if(exceldata.get(i).equalsIgnoreCase(dbdata.get(i)))
				{
					TC021r="AEP Partner Last name Check is Failed Due to records Mismatch";
					TC021tr="PASSED";
					int s1=exceldata.size()-dbdata.size();
					TC021rc=Integer.toString(s1);
					Assert.assertEquals("AEP Partner Last name Check is as Expected",exceldata.get(i), dbdata.get(i));
				}
				else
				{
					TC021r="AEP Partner Last name Check is Failed Due to records Mismatch";
					TC021tr="Failed";
					int s1=exceldata.size()-dbdata.size();
					TC021rc=Integer.toString(s1);
					Assert.assertEquals("AEP Partner Last name Check is Failed",exceldata.get(i), dbdata.get(i));
					
				}
			}
		} 
		catch (ClassNotFoundException e1) 
		{
			e1.printStackTrace();
		}
	}
	@Test(priority=2)
	public void HS_AEPCustomer_MailingAddressState_Check_TC022() throws SQLException,BiffException, IOException 
	{
		TC022c=this.getClass().getName().split("_")[1];
		TC022s=Thread.currentThread().getStackTrace()[1].getMethodName().split("_")[Thread.currentThread().getStackTrace()[1].getMethodName().split("_").length-1];

		Workbook w;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3307/homeserve", "root", "mysql");
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT distinct MailingAddressState as MailingAddressState FROM homeserve.aepcustomer");
			w = Workbook.getWorkbook(new File("C:\\Artha\\TransToPartner_MDU_11042015_002020.xls"));
			Sheet s = w.getSheet("AEPCustomer20150801");
			TC022rc="1";
			List<String> exceldata=new ArrayList<String>();
			List<String> dbdata=new ArrayList<String>();
			exceldata.add("AA");
			exceldata.add("AL");
			exceldata.add("AK");
			exceldata.add("AS");
			exceldata.add("AZ");
			exceldata.add("AR");
			exceldata.add("CA");
			exceldata.add("CO");
			exceldata.add("CT");
			exceldata.add("DE");
			exceldata.add("DC");
			exceldata.add("FM");
			exceldata.add("FL");
			exceldata.add("GA");
			exceldata.add("GU");
			exceldata.add("HI");
			exceldata.add("ID");
			exceldata.add("IL");
			exceldata.add("IN");
			exceldata.add("IA");
			exceldata.add("KS");
			exceldata.add("KY");
			exceldata.add("LA");
			exceldata.add("ME");
			exceldata.add("MH");
			exceldata.add("MD");
			exceldata.add("MA");
			exceldata.add("MI");
			exceldata.add("MN");
			exceldata.add("MS");
			exceldata.add("MO");
			exceldata.add("MT");
			exceldata.add("NE");
			exceldata.add("NV");
			exceldata.add("NH");
			exceldata.add("NJ");
			exceldata.add("NM");
			exceldata.add("NY");
			exceldata.add("NC");
			exceldata.add("ND");
			exceldata.add("MP");
			exceldata.add("OH");
			exceldata.add("OK");
			exceldata.add("OR");
			exceldata.add("PW");
			exceldata.add("PA");
			exceldata.add("PR");
			exceldata.add("RI");
			exceldata.add("SC");
			exceldata.add("SD");
			exceldata.add("TN");
			exceldata.add("TX");
			exceldata.add("UT");
			exceldata.add("VT");
			exceldata.add("VI");
			exceldata.add("VA");
			exceldata.add("WA");
			exceldata.add("WV");
			exceldata.add("WI");
			exceldata.add("WY");
				while (rs.next()) 
				{
					dbdata.add(rs.getString("MailingAddressState"));
				}
				for(String exdata:exceldata)
				{
					for(String dbdd:dbdata)
					{
						if(exdata.equalsIgnoreCase(dbdd))
						{
							  TC022r="Mailing Address State Check is as Expected";
							  TC022tr="PASSED";
							  Reporter.log("Mailing Address State Check is as Expected");
						}
						else
						{
							  TC022r="Mailing Address State Check is Failed";
							  TC022rc="1";
							  TC022tr="Failed";
							  Reporter.log("Mailing Address State Check is Failed");
						}
					}
				}
		} 
		catch (ClassNotFoundException e1) 
		{
			e1.printStackTrace();
		}
	}
	@Test(priority=3)
	public void HS_AEPCustomer_PremisesAddressZipPlus4_Check_TC023() throws SQLException,BiffException, IOException 
	{
		TC023c=this.getClass().getName().split("_")[1];
		TC023s=Thread.currentThread().getStackTrace()[1].getMethodName().split("_")[Thread.currentThread().getStackTrace()[1].getMethodName().split("_").length-1];
		Workbook w;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3307/homeserve", "root", "mysql");
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT PremisesAddressZipPlus4 FROM homeserve.aepcustomer");
			w = Workbook.getWorkbook(new File("C:\\Artha\\TransToPartner_MDU_11042015_002020.xls"));
			Sheet s = w.getSheet("AEPCustomer20150801");
			List<String> exceldata=new ArrayList<String>();
			List<String> dbdata=new ArrayList<String>();
			for (int i = 1; i < s.getRows(); i++) 
			{
				exceldata.add(s.getCell(12, i).getContents());
			}
			while (rs.next()) 
			{
				dbdata.add(rs.getString("PremisesAddressZipPlus4"));
			}
			for(int i=0;i<exceldata.size();i++)
			{
				if(exceldata.get(i).length()==5)
				{
					TC023r="AEP Partner Premises Address Zip Plus4 Pattern Check is Failed";
					  TC023tr="Failed";
					  TC023rc="1";
					Assert.assertEquals("AEP Partner Premises Address Zip Plus4 Check is as Expected",exceldata.get(i), dbdata.get(i));
				}
				else
				{
					boolean Z=dbdata.get(i).matches("[0-9]{5}_[0-9]{4}");
					  if(Z==true)
					  {
						  TC023r="AEP Partner Premises Address Zip Plus4 Pattern Check is Failed AT PremisesAddressZipPlus4="+rs.getString("PremisesAddressZipPlus4");
						  TC023tr="Failed";
						  TC023rc="1"; 
						  Assert.assertEquals("AEP Partner Premises Address Zip Plus4 Pattern Check is as Expected", Z,true);
					  }
					  else
					  {
						  TC023r="AEP Partner Premises Address Zip Plus4 Pattern Check is Failed AT PremisesAddressZipPlus4="+rs.getString("PremisesAddressZipPlus4");
						  TC023tr="Failed";
						  TC023rc="1";
						  Assert.assertEquals("AEP Partner Premises Address Zip Plus4 Pattern Check is Failed", Z,true);
					  }
				}
			}
		}
		catch (ClassNotFoundException e1) 
		{
			e1.printStackTrace();
		}
	}
	@Test(priority=4)
	public void HS_AEPCustomer_UniqueID_Check_TC024() throws SQLException,BiffException, IOException 
	{
		TC024c=this.getClass().getName().split("_")[1];
		TC024s=Thread.currentThread().getStackTrace()[1].getMethodName().split("_")[Thread.currentThread().getStackTrace()[1].getMethodName().split("_").length-1];
		Workbook w;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3307/homeserve", "root", "mysql");
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT UniqueID FROM homeserve.aepcustomer");
			w = Workbook.getWorkbook(new File("C:\\Artha\\TransToPartner_MDU_11042015_002020.xls"));
			Sheet s = w.getSheet("AEPCustomer20150801");
			List<String> exceldata=new ArrayList<String>();
			List<String> dbdata=new ArrayList<String>();
			for (int i = 1; i < s.getRows(); i++) 
			{
				exceldata.add(s.getCell(14, i).getContents());
			}
			while (rs.next()) 
			{
				dbdata.add(rs.getString("UniqueID"));
			}
			for(int i=0;i<exceldata.size();i++)
			{
					if(exceldata.get(i).equalsIgnoreCase(dbdata.get(i)))
					{
						TC024r="AEP Partner UniqueID Check is as Expected";
						TC024tr="PASSED";
						Assert.assertEquals("AEP Partner UniqueID Check is as Expected",exceldata.get(i), dbdata.get(i));
					}
					else
					{
						TC024tr="Failed";
						TC024r="AEP Partner UniqueID Check is Failed at UniqueID="+rs.getString("UniqueID");
						Assert.assertEquals("AEP Partner UniqueID Check is Failed",exceldata.get(i), dbdata.get(i));
					}
					boolean Z=dbdata.get(i).matches("[a-zA-Z0-9]{20}");
					int cl=0;
					  if(Z==false)
					  {
						  cl++;
						  TC024r="AEP Partner UniqueID Pattern Check is not Expected";
						  TC024tr="PASSED";
						  TC024rc=cl+"";
						  Assert.assertEquals("AEP Partner UniqueID Pattern Check is as Expected", Z,false);
					  }
					  else
					  {
						  cl++;
						  TC024r="AEP Partner UniqueID Check is Failed at UniqueID="+rs.getString("UniqueID");
						  TC024tr="Failed";
						  TC024rc=cl+"";
						  Assert.assertEquals("AEP Partner UniqueID Pattern Check is Failed",Z,true);
					  }
			}
		}
		catch (ClassNotFoundException e1) 
		{
			e1.printStackTrace();
		}
	}
}
