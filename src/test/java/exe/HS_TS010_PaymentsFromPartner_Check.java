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
import java.util.List;

import junit.framework.Assert;
import jxl.Sheet;
import jxl.Workbook;
import jxl.format.Alignment;
import jxl.format.Colour;
import jxl.read.biff.BiffException;
import jxl.write.Border;
import jxl.write.BorderLineStyle;
import jxl.write.Label;
import jxl.write.WritableCellFormat;
import jxl.write.WritableFont;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;
import jxl.write.biff.RowsExceededException;

import org.testng.annotations.Test;

public class HS_TS010_PaymentsFromPartner_Check 
{
	public static String TC028c=null;
	public static String TC028s=null;
	public static String TC028r=null;
	public static String TC028rc=null;
	public static String TC028tr=null;
	public static String TC029tr=null;
	public static String TC029c=null;
	public static String TC029s=null;
	public static String TC029r=null;
	public static String TC029rc=null;
	public static String TC030c=null;
	public static String TC030s=null;
	public static String TC030r=null;
	public static String TC030rc=null;
	public static String TC030tr=null;
	public static String TC031tr=null;
	public static String TC031c=null;
	public static String TC031s=null;
	public static String TC031r=null;
	public static String TC031rc=null;
	public static String TC032c=null;
	public static String TC032s=null;
	public static String TC032r=null;
	public static String TC032rc=null;
	public static String TC033c=null;
	public static String TC032tr=null;
	public static String TC033tr=null;
	public static String TC033s=null;
	public static String TC033r=null;
	public static String TC033rc=null;
	@Test
	public void HS_SJPayments_AccountNumber_Check_TC028() throws SQLException,BiffException, IOException 
	{
		  TC028c=this.getClass().getName().split("_")[1];
		  TC028s=Thread.currentThread().getStackTrace()[1].getMethodName().split("_")[Thread.currentThread().getStackTrace()[1].getMethodName().split("_").length-1];

		Workbook w;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3307/homeserve", "root", "mysql");
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT *,count(*) AS reccount FROM homeserve.sjpaymentsfrompartner where Partner_Account_Number like '0%'");
			  //ResultSetMetaData rsmd = rs.getMetaData();
			  while(rs.next())
			  {
				  rs.last();
				  int k=rs.getRow();
				  if(k==0)
				  {
					  TC028r="Payments From Partner Account Number check is as Expected ";
					  TC028rc=rs.getString("reccount"); 
					  TC028tr="PASSED";
					  Assert.assertEquals("Payments From Partner Account Number check is as Expected ",0, k);
				  }
				  else
				  {
					  TC028rc=rs.getString("reccount");  
					  TC028r="Payments From Partner Account Number can not be All Zeros(0), for HS_Invoice_Number="+rs.getString("reccount")+" sjpaymentsfrompartner";
					  TC028tr="Failed";
					  Assert.assertEquals("Payments From Partner Account Number can not be All Zeros(0), for HS_Invoice_Number="+rs.getString("reccount"),0, k);
				  }
			  }
		}
		catch (ClassNotFoundException e1) 
		{
			e1.printStackTrace();
		}
	}
	@Test
	public void HS_SJPayments_ChargeType_Check_TC029() throws SQLException,BiffException, IOException 
	{
		  TC029c=this.getClass().getName().split("_")[1];
		  TC029s=Thread.currentThread().getStackTrace()[1].getMethodName().split("_")[Thread.currentThread().getStackTrace()[1].getMethodName().split("_").length-1];
		  Workbook w;
		  try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3307/homeserve", "root", "mysql");
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT *,count(*) AS reccount  FROM homeserve.sjpaymentsfrompartner where Partner_ChargeType not in('J','N')");
			  while(rs.next())
			  {
				  rs.last();
				  int k=rs.getRow();
				  if(k==0)
				  {
					  Assert.assertEquals("Payments From Partner Charge Type Check is as Expected ",0, k);	
				  }
				  else
				  {
					  TC029rc=rs.getString("reccount");
					  TC029r="Payments From Partner Charge Type Check is Failed at Partner_Account_Number= "+rs.getString("Partner_Account_Number");
					  TC029tr="Failed";
					  Assert.assertEquals("Payments From Partner Charge Type Check is Failed at Partner_Account_Number= "+rs.getString("Partner_Account_Number")+" Reason as ",0, k);	
				  }
			  }
		}
		catch (ClassNotFoundException e1) 
		{
			e1.printStackTrace();
		}
	}
	@Test
	public void HS_SJPayments_Invoice_Number_Check_TC030() throws SQLException,BiffException, IOException 
	{
		  TC030c=this.getClass().getName().split("_")[1];
		  TC030s=Thread.currentThread().getStackTrace()[1].getMethodName().split("_")[Thread.currentThread().getStackTrace()[1].getMethodName().split("_").length-1];

		Workbook w;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3307/homeserve", "root", "mysql");
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT *,count(*) AS reccount  FROM homeserve.sjpaymentsfrompartner where HS_Invoice_Number like '0%'");
			while(rs.next())
			  {
				  rs.last();
				  int k=rs.getRow();
				  if(k==0)
				  {
					  Assert.assertEquals("Payments From Partner Charge Type Check is as Expected ",0, k);	
				  }
				  else
				  {
					  TC030rc=rs.getString("reccount");
					  TC030r="Payments From Partner Charge Type Check is Failed at Partner_Account_Number= "+rs.getString("Partner_Account_Number");
					  TC030tr="Failed";
					  Assert.assertEquals("Payments From Partner Charge Type Check is Failed at Partner_Account_Number= "+rs.getString("Partner_Account_Number")+" Reason as ",0, k);	
				  }
			  }
		}
		catch (ClassNotFoundException e1) 
		{
			e1.printStackTrace();
		}
	}
	@Test
	public void HS_SJPayments_Transaction_Amount_Check_TC031() throws SQLException,BiffException, IOException 
	{
		  TC031c=this.getClass().getName().split("_")[1];
		  TC031s=Thread.currentThread().getStackTrace()[1].getMethodName().split("_")[Thread.currentThread().getStackTrace()[1].getMethodName().split("_").length-1];

		Workbook w;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3307/homeserve", "root", "mysql");
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT *,count(*) AS reccount FROM homeserve.sjpaymentsfrompartner where Partner_Transaction_Amount=0");
			while(rs.next())
			  {
				  rs.last();
				  int k=rs.getRow();
				  if(k==0)
				  {
					  Assert.assertEquals("Payments From Partner Partner Transaction Amount Check is as Expected ",0, k);	
				  }
				  else
				  {
					  TC031rc=rs.getString("reccount");
					  TC031r="Payments From Partner Partner Transaction Amount Check is Failed";
					  TC031tr="Failed";
					  Assert.assertEquals("Payments From Partner Partner Transaction Amount Check is Failed",0, k);	
				  }
			  }
		}
		catch (ClassNotFoundException e1) 
		{
			e1.printStackTrace();
		}
	}
	@Test
	public void HS_SJPayments_Partner_ChargeSign_Check_TC032() throws SQLException,BiffException, IOException 
	{
		  TC032c=this.getClass().getName().split("_")[1];
		  TC032s=Thread.currentThread().getStackTrace()[1].getMethodName().split("_")[Thread.currentThread().getStackTrace()[1].getMethodName().split("_").length-1];

		Workbook w;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3307/homeserve", "root", "mysql");
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT *,count(*) AS reccount FROM homeserve.sjpaymentsfrompartner where Partner_ChargeType='N' and Partner_ChargeSign!='D' and Partner_ChargeSign in('C','D')");
			while(rs.next())
			  {
				  rs.last();
				  int k=rs.getRow();
				  if(k==0)
				  {
					  Assert.assertEquals("Payments From Partner Charge Sign Check is as Expected ",0, k);	
				  }
				  else
				  {
					  TC032rc=rs.getString("reccount");
					  TC032r="Payments From Partner Charge Sign Check is Failed at Partner_Account_Number= "+rs.getString("Partner_Account_Number");
					  TC032tr="Failed";
					  Assert.assertEquals("Payments From Partner Charge Sign Check is Failed at Partner_Account_Number= "+rs.getString("Partner_Account_Number"),0, k);	
				  }
			  }
		}
		catch (ClassNotFoundException e1) 
		{
			e1.printStackTrace();
		}
	}
	@Test
	public void HS_SJPayments_Partner_Record_Type_Check_TC033() throws SQLException,BiffException, IOException 
	{
		  TC033c=this.getClass().getName().split("_")[1];
		  TC033s=Thread.currentThread().getStackTrace()[1].getMethodName().split("_")[Thread.currentThread().getStackTrace()[1].getMethodName().split("_").length-1];

		Workbook w;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3307/homeserve", "root", "mysql");
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT *,count(*) as reccount FROM homeserve.sjpaymentsfrompartner where (Partner_ChargeType='N' and Partner_ChargeSign='D' and Record_Type!='Partner_Payment_Debit_R5') or (Partner_ChargeType='J' and Partner_ChargeSign='D' and Record_Type!='Partner_Payment_Debit_R6') or (Partner_ChargeType='J' and Partner_ChargeSign='C' and Record_Type!='Partner_Payment_Credit_R5')");
			while(rs.next())
			  {
				  rs.last();
				  int k=rs.getRow();
				  if(k==0)
				  {
					  Assert.assertEquals("Payments From Partner Record Type Check is as Expected ",0, k);	
				  }
				  else
				  {
					  TC033rc=rs.getString("reccount");
					  TC033r="Payments From Partner Record Type Check is Failed at Partner_Account_Number= "+rs.getString("Partner_Account_Number");
					  TC033tr="Failed";
					  Assert.assertEquals("Payments From Partner Record Type Check is Failed at Partner_Account_Number= "+rs.getString("Partner_Account_Number"),0, k);	
				  }
			  }
		}
		catch (ClassNotFoundException e1) 
		{
			e1.printStackTrace();
		}
	}
	@Test
	public void excelw() throws IOException, RowsExceededException, WriteException
	{
			WritableWorkbook myFirstWbook = Workbook.createWorkbook(new File("C:\\Artha\\Homeserve_Automation_TestResults.xls"));
			WritableSheet excelSheet = myFirstWbook.createSheet("TestResults", 0);
			
		    WritableFont cellFont = new WritableFont(WritableFont.COURIER, 12);
		    cellFont.setColour(Colour.BLUE);
		    WritableCellFormat cellFormat = new WritableCellFormat(cellFont);
		    cellFormat.setBackground(Colour.BLACK);
		    cellFormat.setAlignment(Alignment.CENTRE);
		    cellFormat.setBorder(Border.ALL, BorderLineStyle.MEDIUM,Colour.BLACK);
		    
		    WritableFont cellFont1 = new WritableFont(WritableFont.TAHOMA, 10);
		    cellFont1.setColour(Colour.BLACK);
		    WritableCellFormat cellFormat1 = new WritableCellFormat(cellFont1);
		    cellFormat1.setBackground(Colour.BLACK);
		    cellFormat1.setAlignment(Alignment.LEFT);
		    cellFormat1.setBorder(Border.ALL, BorderLineStyle.THIN,Colour.BLACK);

			excelSheet.setColumnView(0,25);
			excelSheet.setColumnView(1,18);
			excelSheet.setColumnView(2,90);
			excelSheet.setColumnView(3,18);
			excelSheet.setColumnView(4,35);
			
		    excelSheet.addCell(new Label(0, 0, "Testscenario ID", cellFormat));
	        excelSheet.addCell(new Label(1, 0, "Testcase ID", cellFormat));
	        excelSheet.addCell(new Label(2, 0, "Reason", cellFormat));
	        excelSheet.addCell(new Label(3, 0, "Test Result", cellFormat));
	        excelSheet.addCell(new Label(4, 0, "Pass/Failure Rec Count", cellFormat));
	        
	        excelSheet.addCell( new Label(0,1,HS_TS007_Premise_Name_Check.TC018c, cellFormat1));
	        excelSheet.addCell( new Label(1,1,HS_TS007_Premise_Name_Check.TC018s, cellFormat1));
	        excelSheet.addCell( new Label(2,1, HS_TS007_Premise_Name_Check.TC018r, cellFormat1));
	        excelSheet.addCell( new Label(3,1, HS_TS007_Premise_Name_Check.TC018tr, cellFormat1));
	        excelSheet.addCell( new Label(4,1, HS_TS007_Premise_Name_Check.TC018rc, cellFormat1));
	        
	        excelSheet.addCell( new Label(0,2,HS_TS007_Premise_Name_Check.TC019c, cellFormat1));
	        excelSheet.addCell( new Label(1,2,HS_TS007_Premise_Name_Check.TC019s, cellFormat1));
	        excelSheet.addCell( new Label(2,2, HS_TS007_Premise_Name_Check.TC019r, cellFormat1));
	        excelSheet.addCell( new Label(3,2, HS_TS007_Premise_Name_Check.TC019tr, cellFormat1));
	        excelSheet.addCell( new Label(4,2, HS_TS007_Premise_Name_Check.TC019rc, cellFormat1));
	        
	        excelSheet.addCell( new Label(0,3,HS_TS008_AEPCustomer_Details_Check.TC020c, cellFormat1));
	        excelSheet.addCell( new Label(1,3,HS_TS008_AEPCustomer_Details_Check.TC020s, cellFormat1));
	        excelSheet.addCell( new Label(2,3,HS_TS008_AEPCustomer_Details_Check.TC020r, cellFormat1));
	        excelSheet.addCell( new Label(3,3,HS_TS008_AEPCustomer_Details_Check.TC020tr, cellFormat1));
	        excelSheet.addCell( new Label(4,3,HS_TS008_AEPCustomer_Details_Check.TC020rc, cellFormat1));

	        excelSheet.addCell( new Label(0,4,HS_TS008_AEPCustomer_Details_Check.TC021c, cellFormat1));
	        excelSheet.addCell( new Label(1,4,HS_TS008_AEPCustomer_Details_Check.TC021s, cellFormat1));
	        excelSheet.addCell( new Label(2,4,HS_TS008_AEPCustomer_Details_Check.TC021r, cellFormat1));
	        excelSheet.addCell( new Label(3,4,HS_TS008_AEPCustomer_Details_Check.TC021tr, cellFormat1));
	        excelSheet.addCell( new Label(4,4,HS_TS008_AEPCustomer_Details_Check.TC021rc, cellFormat1));

	        excelSheet.addCell( new Label(0,5,HS_TS008_AEPCustomer_Details_Check.TC022c, cellFormat1));
	        excelSheet.addCell( new Label(1,5,HS_TS008_AEPCustomer_Details_Check.TC022s, cellFormat1));
	        excelSheet.addCell( new Label(2,5,HS_TS008_AEPCustomer_Details_Check.TC022r, cellFormat1));
	        excelSheet.addCell( new Label(3,5,HS_TS008_AEPCustomer_Details_Check.TC022tr, cellFormat1));
	        excelSheet.addCell( new Label(4,5,HS_TS008_AEPCustomer_Details_Check.TC022rc, cellFormat1));

	        excelSheet.addCell( new Label(0,6,HS_TS008_AEPCustomer_Details_Check.TC023c, cellFormat1));
	        excelSheet.addCell( new Label(1,6,HS_TS008_AEPCustomer_Details_Check.TC023s, cellFormat1));
	        excelSheet.addCell( new Label(2,6,HS_TS008_AEPCustomer_Details_Check.TC023r, cellFormat1));
	        excelSheet.addCell( new Label(3,6,HS_TS008_AEPCustomer_Details_Check.TC023tr, cellFormat1));
	        excelSheet.addCell( new Label(4,6,HS_TS008_AEPCustomer_Details_Check.TC023rc, cellFormat1));

	        excelSheet.addCell( new Label(0,7,HS_TS008_AEPCustomer_Details_Check.TC024c, cellFormat1));
	        excelSheet.addCell( new Label(1,7,HS_TS008_AEPCustomer_Details_Check.TC024s, cellFormat1));
	        excelSheet.addCell( new Label(2,7,HS_TS008_AEPCustomer_Details_Check.TC024r, cellFormat1));
	        excelSheet.addCell( new Label(3,7,HS_TS008_AEPCustomer_Details_Check.TC024tr, cellFormat1));
	        excelSheet.addCell( new Label(4,7,HS_TS008_AEPCustomer_Details_Check.TC024rc, cellFormat1));

	        excelSheet.addCell( new Label(0,8,HS_TS009_AEPAudit_Details_Check.TC025c, cellFormat1));
	        excelSheet.addCell( new Label(1,8,HS_TS009_AEPAudit_Details_Check.TC025s, cellFormat1));
	        excelSheet.addCell( new Label(2,8,HS_TS009_AEPAudit_Details_Check.TC025r, cellFormat1));
	        excelSheet.addCell( new Label(3,8,HS_TS009_AEPAudit_Details_Check.TC025tr, cellFormat1));
	        excelSheet.addCell( new Label(4,8,HS_TS009_AEPAudit_Details_Check.TC025rc, cellFormat1));

	        excelSheet.addCell( new Label(0,9,HS_TS009_AEPAudit_Details_Check.TC026c, cellFormat1));
	        excelSheet.addCell( new Label(1,9,HS_TS009_AEPAudit_Details_Check.TC026s, cellFormat1));
	        excelSheet.addCell( new Label(2,9,HS_TS009_AEPAudit_Details_Check.TC026r, cellFormat1));
	        excelSheet.addCell( new Label(3,9,HS_TS009_AEPAudit_Details_Check.TC026tr, cellFormat1));
	        excelSheet.addCell( new Label(4,9,HS_TS009_AEPAudit_Details_Check.TC026rc, cellFormat1));

	        excelSheet.addCell( new Label(0,10,TC028c, cellFormat1));
	        excelSheet.addCell( new Label(1,10,TC028s, cellFormat1));
	        excelSheet.addCell( new Label(2,10,TC028r, cellFormat1));
	        excelSheet.addCell( new Label(3,10,TC028tr, cellFormat1));
	        excelSheet.addCell( new Label(4,10,TC028rc, cellFormat1));

	        excelSheet.addCell( new Label(0,11,TC029c, cellFormat1));
	        excelSheet.addCell( new Label(1,11,TC029s, cellFormat1));
	        excelSheet.addCell( new Label(2,11,TC029r, cellFormat1));
	        excelSheet.addCell( new Label(3,11,TC029tr, cellFormat1));
	        excelSheet.addCell( new Label(4,11,TC029rc, cellFormat1));

	        excelSheet.addCell( new Label(0,12,TC030c, cellFormat1));
	        excelSheet.addCell( new Label(1,12,TC030s, cellFormat1));
	        excelSheet.addCell( new Label(2,12,TC030r, cellFormat1));
	        excelSheet.addCell( new Label(3,12,TC030tr, cellFormat1));
	        excelSheet.addCell( new Label(4,12,TC030rc, cellFormat1));

	        excelSheet.addCell( new Label(0,13,TC031c, cellFormat1));
	        excelSheet.addCell( new Label(1,13,TC031s, cellFormat1));
	        excelSheet.addCell( new Label(2,13,TC031r, cellFormat1));
	        excelSheet.addCell( new Label(3,13,TC031tr, cellFormat1));
	        excelSheet.addCell( new Label(4,13,TC031rc, cellFormat1));

	        excelSheet.addCell( new Label(0,14,TC032c, cellFormat1));
	        excelSheet.addCell( new Label(1,14,TC032s, cellFormat1));
	        excelSheet.addCell( new Label(2,14,TC032r, cellFormat1));
	        excelSheet.addCell( new Label(3,14,TC032tr, cellFormat1));
	        excelSheet.addCell( new Label(4,14,TC032rc, cellFormat1));

	        excelSheet.addCell( new Label(0,15,TC033c, cellFormat1));
	        excelSheet.addCell( new Label(1,15,TC033s, cellFormat1));
	        excelSheet.addCell( new Label(2,15,TC033r, cellFormat1));
	        excelSheet.addCell( new Label(3,15,TC033tr, cellFormat1));
	        excelSheet.addCell( new Label(4,15,TC033rc, cellFormat1));
			
			myFirstWbook.write();
			myFirstWbook.close();			
		}
}
