package advanceSelenium.cmdline;

import java.io.FileInputStream;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class SCM_LoginUsingMaven_cmd 
{
	@Test
	public void LoginTest()
	{
		WebDriver driver;
		String browser=System.getProperty("Browser");
		String url=System.getProperty("URL");
		String uname=System.getProperty("Username");
		String pwd=System.getProperty("Password");
		
		
		if(browser.equals("Chrome"))
		{
			driver=new ChromeDriver();
		}
		else if(browser.equals("Edge"))
		{
			driver=new EdgeDriver();
		}
		else if(browser.equals("Firefox"))
		{
			driver=new FirefoxDriver();
		}
		else
		driver=new ChromeDriver();
		driver.get(url);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.findElement(By.cssSelector("[type='text']")).sendKeys(uname);
		driver.findElement(By.cssSelector("[type='password']")).sendKeys(pwd);
		WebElement logintype = driver.findElement(By.id("login:type"));
		logintype.click();
		Select sel =new Select(logintype);
		sel.selectByValue("admin");
		driver.findElement(By.cssSelector("[value='Login']")).click();
	}
	

}
