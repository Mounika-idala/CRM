package advanceSelenium.jsonfile;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.time.Duration;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class SCM_LoginUsingJSON 
{
	@Test
	public void logintest() throws FileNotFoundException, IOException, ParseException
	{
		WebDriver driver;
		JSONParser parser=new JSONParser();
		Object obj = parser.parse(new FileReader("F:\\QSP Course\\TekPyramid\\SCM_CommonDataUsingJSON.json"));
		JSONObject map=(JSONObject)obj;
		String browser=map.get("Browser").toString();
		String url=map.get("URL").toString();
		String uname=map.get("UserName").toString();
		String pwd=map.get("Password").toString();
		
		
		
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
