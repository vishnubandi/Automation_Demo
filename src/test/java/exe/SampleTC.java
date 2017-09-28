package exe;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import junit.framework.Assert;
import jxl.write.WriteException;
import jxl.write.biff.RowsExceededException;

import org.testng.annotations.Test;

public class SampleTC 

{
	public static int Noc;
  @Test
  public void PremisesAddressZipPlus4() throws ClassNotFoundException, SQLException 
  {
	  Class.forName("com.mysql.jdbc.Driver");
	  Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3307/arthadb","root","mysql"); 
	  Statement stmt=con.createStatement();  
	  ResultSet rs=stmt.executeQuery("SELECT * FROM arthadb.customers where PremisesAddressZipPlus4 is null or length(PremisesAddressZipPlus4)=0"); 
	  List<String> Zip_RS=new ArrayList<String>();
	  while (rs.next()) 
	  {
		  Noc=rs.getRow();
		  Zip_RS.add(rs.getString("SSN"));
	  }
	  if(Noc==0)
	  {
		  Assert.assertEquals("CUSTOMER - PremisesAddressZipPlus4 check is PASSED", 0, Noc);
		  System.out.println("CUSTOMER - PremisesAddressZipPlus4 check is PASSED");
	  }
	  else
	  {
		  StringBuffer Zip_R=new StringBuffer();
		  for(int k=0;k<Zip_RS.size();k++)
		  {
			  Zip_R.append(Zip_RS.get(k)+","); 
		  }
		  Assert.assertEquals("CUSTOMER - PremisesAddressZipPlus4 check is Failed at SSN="+Zip_R, 0, Noc);
	  }
  }
}
