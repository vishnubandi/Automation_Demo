    /* 
    	Author: Artha Data Solutions Testing Team
    	Date: 2017-10-04
    	Description: This code Will Automate 13 Test cases  for Customer, Audit, Payment & Partners
    */

//Package Statement
package exe;

// Import statement for Files, Excel, Mysql & TestNG
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
import jxl.format.Colour;
import jxl.write.Label;
import jxl.write.WritableCellFormat;
import jxl.write.WritableFont;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;
import jxl.write.biff.RowsExceededException;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;

//Class Declaration 
public class Arthadb_Automation 
{
	//public static int Noc;
	Connection con;
	Statement stmt;
		
	//Database Connection Statement
	@BeforeMethod
	public void DB_Details() throws ClassNotFoundException, SQLException 
	  {
		Class.forName("com.mysql.jdbc.Driver");
		  con=DriverManager.getConnection("jdbc:mysql://localhost:3307/arthadb","root","mysql"); 
		  stmt=con.createStatement(); 
	  }
	
	//Audit ProdCodes_Check Test Script
	@Test(priority=1)
	public void ArthaDB_ProdCodes_Check_TC001() throws SQLException, RowsExceededException, WriteException, IOException 
	  {
		 StringBuffer TC001r=new StringBuffer();
		  try
		  {	
			  int Noc=0; 
			ResultSet rs=stmt.executeQuery("SELECT * FROM arthadb.audit where ProdCodes is null"); 
			  List<String> TC001rs=new ArrayList<String>();
			  while (rs.next()) 
			  {
				  Noc=rs.getRow();
				  TC001rs.add(rs.getString("UniqueID"));
			  }
			  if(Noc==0)
				  {
			        Assert.assertEquals("AUDIT-Product Codes check is PASSED", 0, Noc);
				  }
				  else
				  {
						for(int i=0;i<TC001rs.size();i++)
						{
							  TC001r.append(TC001rs.get(i)+","); 
						}
				        Assert.assertEquals("AUDIT-Product Codes check is Failed at UniqueID="+TC001r, 0, Noc);
				  }  
		  }
		  catch (Exception e1) 
		  {
				  e1.printStackTrace();
		  } 
	}
	
	//Audit Dates_Check Test Script
	@Test(priority=2)
	public void ArthaDB_AuditDates_Check_TC002() throws SQLException, RowsExceededException, WriteException, IOException 
	{
		 StringBuffer TC002r=new StringBuffer();
		  try
		  {
			  int Noc=0; 
			  ResultSet rs=stmt.executeQuery("SELECT *FROM arthadb.audit where datediff(ExpDate,EffDate)<0"); 
			  List<String> TC002rs=new ArrayList<String>();
			  while (rs.next()) 
			  {
				  Noc=rs.getRow();
				  TC002rs.add(rs.getString("UniqueID"));
				  
			  }
			  if(Noc==0)
				  {
			        Assert.assertEquals("AUDIT-Exp and Eff Date check is PASSED", 0, Noc);
			        
				  }
				  else
				  {
						for(int i=0;i<TC002rs.size();i++)
						{
							  TC002r.append(TC002rs.get(i)+","); 
							  
						}
				        Assert.assertEquals("AUDIT-Exp and Eff Date check is Failed at UniqueID="+TC002r, 0, Noc);
				  }  
		  }
		  catch (Exception e1) 
		  {
				  e1.printStackTrace();
		  } 
	}
	
	//payments Account_Number_Check Test Script
	@Test(priority=3)
	public void ArthaDB_Account_Number_Check_TC003() throws SQLException, RowsExceededException, WriteException, IOException 
	{
		 StringBuffer TC003r=new StringBuffer();
		  try
		  { 
			  int Noc=0; 
			  ResultSet rs=stmt.executeQuery("SELECT * FROM arthadb.payments where Account_Number like '0%'"); 
			  List<String> TC003rs=new ArrayList<String>();
			  while (rs.next()) 
			  {
				  Noc=rs.getRow();
				  TC003rs.add(rs.getString("Invoice_Number"));
				  
			  }
			  if(Noc==0)
				  {
			        Assert.assertEquals("PAYMENTS-Account Number check is PASSED", 0, Noc);
			        
				  }
				  else
				  {
						for(int i=0;i<TC003rs.size();i++)
						{
							  TC003r.append(TC003rs.get(i)+","); 
							  
						}
				        Assert.assertEquals("PAYMENTS-Account Number check is Failed at Invoice_Number="+TC003r, 0, Noc);
				  }  
		  }
		  catch (Exception e1) 
		  {
				  e1.printStackTrace();
		  } 
	}

	//payments ChargeType_Check Test Script
	@Test(priority=4)
	public void ArthaDB_ChargeType_Check_TC004() throws SQLException, RowsExceededException, WriteException, IOException 
	{
			  	StringBuffer TC004r=new StringBuffer();
				  try
				  {  
					  int Noc=0; 
					  ResultSet rs=stmt.executeQuery("SELECT * fROM arthadb.payments where ChargeType not in('J','N')"); 
					  List<String> TC004rs=new ArrayList<String>();
					  while (rs.next()) 
					  {
						  Noc=rs.getRow();
						  TC004rs.add(rs.getString("Account_Number"));
						  
					  }
					  if(Noc==0)
						  {
					        Assert.assertEquals("PAYMENTS-Charge Type Codes check is PASSED", 0, Noc);
					        
						  }
						  else
						  {
								for(int i=0;i<TC004rs.size();i++)
								{
									  TC004r.append(TC004rs.get(i)+","); 
									  
								}
						        Assert.assertEquals("PAYMENTS-Charge Type check is Failed at Account_Number(s)="+TC004r, 0, Noc);
						  }  
				  }
				  catch (Exception e1) 
				  {
						  e1.printStackTrace();
				  } 
	}

	//payments Invoice_Number_Check Test Script
	@Test(priority=5)
	public void ArthaDB_Invoice_Number_Check_TC005() throws SQLException, RowsExceededException, WriteException, IOException 
	{
			  StringBuffer TC005r=new StringBuffer();
				  try
				  {
					  int Noc=0; 
					  ResultSet rs=stmt.executeQuery("SELECT *  FROM arthadb.payments where Invoice_Number like '0%'"); 
					  List<String> TC005rs=new ArrayList<String>();
					  while (rs.next()) 
					  {
						  Noc=rs.getRow();
						  TC005rs.add(rs.getString("Account_Number"));
						  
					  }
					  if(Noc==0)
						  {
					        Assert.assertEquals("PAYMENTS-Invoice Number check is PASSED", 0, Noc);
					        
						  }
						  else
						  {
								for(int i=0;i<TC005rs.size();i++)
								{
									  TC005r.append(TC005rs.get(i)+","); 
									  
								}
								
						        Assert.assertEquals("PAYMENTS-Invoice Number check is Failed at Account_Number(s)="+TC005r, 0, Noc);
						  }  
				  }
				  catch (Exception e1) 
				  {
						  e1.printStackTrace();
				  } 
	}
	
	//payments Transaction_Amount_Check Test Script
	@Test(priority=6)
	public void ArthaDB_Transaction_Amount_Check_TC006() throws SQLException, RowsExceededException, WriteException, IOException 
	{
			  StringBuffer TC006r=new StringBuffer();
				  try
				  {
					  int Noc=0; 
					  ResultSet rs=stmt.executeQuery("SELECT * from arthadb.payments where Transaction_Amount=0"); 
					  List<String> TC006rs=new ArrayList<String>();
					  while (rs.next()) 
					  {
						  Noc=rs.getRow();
						  TC006rs.add(rs.getString("Account_Number"));
						  
					  }
					  if(Noc==0)
						  {
					        Assert.assertEquals("PAYMENTS-Transaction Amount check is PASSED", 0, Noc);
						  }
						  else
						  {
								for(int i=0;i<TC006rs.size();i++)
								{
									  TC006r.append(TC006rs.get(i)+","); 
									  
								}
						        Assert.assertEquals("PAYMENTS-Transaction Amount check is Failed at Account_Number="+TC006r, 0, Noc);
						  }  
				  }
				  catch (Exception e1) 
				  {
						  e1.printStackTrace();
				  } 
	}
	
	//payments ChargeSign_Check Test Script	
	@Test(priority=7)
	public void ArthaDB_ChargeSign_Check_TC007() throws SQLException, RowsExceededException, WriteException, IOException 
	{
			  StringBuffer TC007r=new StringBuffer();
				  try
				  {
					  int Noc=0; 
					  ResultSet rs=stmt.executeQuery("SELECT * from arthadb.payments where ChargeType='N' and ChargeSign!='D' and ChargeSign in('C','D')"); 
					  List<String> TC007rs=new ArrayList<String>();
					  while (rs.next()) 
					  {
						  Noc=rs.getRow();
						  TC007rs.add(rs.getString("Account_Number"));
						  
					  }
					  if(Noc==0)
						  {
					        Assert.assertEquals("PAYMENTS-Charge Sign Codes check is PASSED", 0, Noc);
						  }
						  else
						  {
								for(int i=0;i<TC007rs.size();i++)
								{
									  TC007r.append(TC007rs.get(i)+","); 
								}
						        Assert.assertEquals("PAYMENTS-Charge Sign Codes check is Failed at Account_Number="+TC007r, 0, Noc);
						  }  
				  }
				  catch (Exception e1) 
				  {
						  e1.printStackTrace();
				  } 
	}
	
	//payments Record_Type_Check Test Script
	@Test(priority=8)
	public void ArthaDB_Record_Type_Check_TC008() throws SQLException, RowsExceededException, WriteException, IOException 
	{
			  StringBuffer TC008r=new StringBuffer();
				  try
				  { 
					  int Noc=0; 
					  ResultSet rs=stmt.executeQuery("SELECT * FROM arthadb.payments where (ChargeType='N' and ChargeSign='D' and Record_Type!='Debit_R5') or (ChargeType='J' and ChargeSign='D' and Record_Type!='Debit_R6') or (ChargeType='J' and ChargeSign='C' and Record_Type!='Credit_R5')"); 
					  List<String> TC008rs=new ArrayList<String>();
					  while (rs.next()) 
					  {
						  Noc=rs.getRow();
						  TC008rs.add(rs.getString("Invoice_Number"));
					  }
					  if(Noc==0)
						  {
					        Assert.assertEquals("PAYMENTS-Record Type check is PASSED", 0, Noc);
					        
						  }
						  else
						  {
								for(int i=0;i<TC008rs.size();i++)
								{
									  TC008r.append(TC008rs.get(i)+","); 
								}
						        Assert.assertEquals("PAYMENTS-Record Type check is Failed at Invoice_Number="+TC008r, 0, Noc);
						  }  
				  }
				  catch (Exception e1) 
				  {
						  e1.printStackTrace();
				  } 
	}
	
	//Partners Record_Type_Check Test Script
	@Test(priority=9)
	public void ArthaDB_Record_Type_Check_TC009() throws SQLException, RowsExceededException, WriteException, IOException 
	{
			  StringBuffer TC011r=new StringBuffer();
				  try
				  {
					  int Noc=0; 
					  ResultSet rs=stmt.executeQuery("SELECT * FROM arthadb.partners where Record_Type is null"); 
					  List<String> TC011rs=new ArrayList<String>();
					  while (rs.next()) 
					  {
						  Noc=rs.getRow();
						  TC011rs.add(rs.getString("Partner_Account_Number"));
					  }
					  if(Noc==0)
						  {
					        Assert.assertEquals("PARTNERS-Record Type check is PASSED", 0, Noc);
					        
						  }
						  else
						  {
								for(int i=0;i<TC011rs.size();i++)
								{
									  TC011r.append(TC011rs.get(i)+","); 
									  
								}
						        Assert.assertEquals("PARTNERS-Record Type check is Failed at Partner_Account_Number="+TC011r, 0, Noc);
						  }  
				  }
				  catch (Exception e1) 
				  {
						  e1.printStackTrace();
				  } 
	}
	
	//Partners Premise_City_Check Test Script
	@Test(priority=10)
	public void ArthaDB_Premise_City_Check_TC010() throws SQLException, RowsExceededException, WriteException, IOException 
	{
			  StringBuffer TC012r=new StringBuffer();
				  try
				  {
					  int Noc=0; 
					  ResultSet rs=stmt.executeQuery("SELECT * FROM arthadb.partners where (Premise_City is null or Premise_City=' ' or Premise_City='')"); 
					  List<String> TC012rs=new ArrayList<String>();
					  while (rs.next()) 
					  {
						  Noc=rs.getRow();
						  TC012rs.add(rs.getString("Partner_Account_Number"));
					  }
					  if(Noc==0)
						  {
					        Assert.assertEquals("PARTNERS-City check is PASSED", 0, Noc);
						  }
						  else
						  {
								for(int i=0;i<TC012rs.size();i++)
								{
									  TC012r.append(TC012rs.get(i)+",");   
								}
						        Assert.assertEquals("PARTNERS-City check is Failed at Partner_Account_Number="+TC012r, 0, Noc);
						  }  
				  }
				  catch (Exception e1) 
				  {
						  e1.printStackTrace();
				  } 
	} 

	/*
	 * Customer Name Check
	 * 			1. Here we are Validating Both First & Last Name
	 * 			2. Both are Mandatory
	 * 			3. Both Names Allow Only Alphabets (a to z / A to Z)
	 */
	@Test(priority=11)
	public void ArthaDB_Customer_First_Last_Name_Check_TC011() throws SQLException, RowsExceededException, WriteException, IOException 
	{
			  StringBuffer TC009r=new StringBuffer();
				  try
				  { 
					  int Noc=0; 
					  ResultSet rs=stmt.executeQuery("SELECT * FROM customers WHERE FirstName RLIKE '[[:<:]][a-z][[:>:]]' or LastName RLIKE '[[:<:]][a-z][[:>:]]' or FirstName is null or LastName is null"); 
					  List<String> TC009rs=new ArrayList<String>();
					  while (rs.next()) 
					  {
						  Noc=rs.getRow();
						  TC009rs.add(rs.getString("SSN"));
						  
					  }
					  if(Noc==0)
						  {
					        Assert.assertEquals("CUSTOMERS-First & Last Name check is PASSED", 0, Noc);
						  }
						  else
						  {
								for(int i=0;i<TC009rs.size();i++)
								{
									  TC009r.append(TC009rs.get(i)+","); 	  
								}
						        Assert.assertEquals("CUSTOMERS-First & Last Name check is Failed at SSN="+TC009r, 0, Noc);
						  }  
				  }
				  catch (Exception e1) 
				  {
						  e1.printStackTrace();
				  } 
	}
	
	/*
	 * Here we will Check Customer SSN Format
	 * 		1. SSN is Mandatory
	 * 		2. SSN is in Specified Format like 123-45-6796 
	 */
	@Test(priority=12)
	public void ArthaDB_Customers_SSN_Check_TC012() throws SQLException, RowsExceededException, WriteException, IOException 
	{
			 StringBuffer TC010r=new StringBuffer();
				  try
				  { 
					  int Noc=0; 
					  ResultSet rs=stmt.executeQuery("SELECT * FROM customers WHERE SSN not RLIKE '[[:<:]][0-9]{3}[[:>:]](-)[[:<:]][0-9]{2}[[:>:]](-)[[:<:]][0-9]{4}[[:>:]]' or SSN is null"); 
					  List<String> TC010rs=new ArrayList<String>();
					  while (rs.next()) 
					  {
						  Noc=rs.getRow();
						  TC010rs.add(rs.getString("CustomerPK"));
						  
					  }
					  if(Noc==0)
						  {
					        Assert.assertEquals("CUSTOMERS- SSN check is PASSED", 0, Noc);
					        
						  }
						  else
						  {
								for(int i=0;i<TC010rs.size();i++)
								{
									  TC010r.append(TC010rs.get(i)+","); 
								}
						        Assert.assertEquals("CUSTOMERS- SSN check is Failed at CustomerPK="+TC010r, 0, Noc);
						  }  
				  }
				  catch (Exception e1) 
				  {
						  e1.printStackTrace();
				  } 
	}
	
	/*
	 * Customer Phone number is mandatory and it is in specified format (for example +1 333 333 4444)
	 * Input Excel Phone number does not contain PLUS (+) symbol, it contain hyphen(-)
	 * Need to replay hyphen symbol into Space. 
	 */
	@Test(priority=13)
	public void ArthaDB_PrimaryPhoneNumber_TC013() throws SQLException
	{
		int Noc=0; 
		ResultSet rs=stmt.executeQuery("SELECT * FROM customers WHERE PrimaryPhoneNumber not REGEXP '[+][1] [0-9]{3} [0-9]{3} [0-9]{4}' or PrimaryPhoneNumber is null");
		List<String> Phone_rs=new ArrayList<String>();
		while(rs.next())
		{
			Noc=rs.getRow();
			Phone_rs.add(rs.getString("SSN"));
		}
		if(Noc==0)
		{
			Assert.assertEquals("Customer - PrimaryPhoneNumber check is Passed",0,Noc);
		}
		else
		{
			StringBuffer Phone_r=new StringBuffer();
			for(int k=0;k<Phone_rs.size();k++)
			{
				Phone_r.append(Phone_rs.get(k)+",");
			}
			Assert.assertEquals("Customer - PrimaryPhoneNumber check is Failed at SSN="+Phone_r, 0, Noc);
		}
	}

	/*
	 * Customer Details Update Check
	 * Here If any Customer Change Those respective Details, we will find those SSN Numbers.
	 */
	@Test(priority=14)
	public void ArthaDB_Customer_Details_Update_Check_TC014() throws SQLException
	{
		int Noc=0; 
		ResultSet rs=stmt.executeQuery("SELECT * FROM arthadb.customers_audit_table where action='Update'");
		List<String> Update_rs=new ArrayList<String>();
		while(rs.next())
		{
			Noc=rs.getRow();
			Update_rs.add(rs.getString("SSN"));
		}
		if(Noc==0)
		{
			Assert.assertEquals("Customer - Details check is Passed",0,Noc);
		}
		else
		{
			StringBuffer Update_r=new StringBuffer();
			for(int k=0;k<Update_rs.size();k++)
			{
				Update_r.append(Update_rs.get(k)+",");
			}
			Assert.assertEquals("Customer - Details are updated at Customer SSN= "+Update_r, 0, Noc);
		}
	}
}
