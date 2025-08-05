 package advanceSelenium.properties;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class SCM_LoginUsingPropertiesFile {

	public static void main(String[] args) throws Exception
	{
		WebDriver driver;
		FileInputStream fis=new FileInputStream("F:\\QSP Course\\TekPyramid\\SCM_CommonData.properties");
		Properties pro=new Properties();
		pro.load(fis);
		String browser = pro.getProperty("Browser");
		String url = pro.getProperty("URL");
		String uname = pro.getProperty("UserName");
		String pwd=pro.getProperty("Password");
		
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
