package exe;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class MDM_Test_Automation 
{
  @Test
  public void MDM_Login() 
  {
	  	System.setProperty("webdriver.chrome.driver", "F:\\ADS_Automation\\Jars\\chromedriver_win32\\chromedriver.exe");
		WebDriver d = new ChromeDriver();
		d.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		d.get("http://192.168.1.26:8180/talendmdm/auth/login.jsp");
		d.findElement(By.name("j_username")).sendKeys("administrator");
		d.findElement(By.name("j_password")).sendKeys("administrator");
		d.findElement(By.name("login")).click();
		WebElement Datacontainer = d.findElement(By.id("general-x-auto-17-input"));
		Select dropdown= new Select(Datacontainer);
		dropdown.selectByVisibleText("Artha_DM");
  }
}
