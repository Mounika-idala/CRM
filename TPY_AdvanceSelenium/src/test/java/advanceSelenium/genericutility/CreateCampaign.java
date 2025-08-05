package advanceSelenium.genericutility;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import genericutility.FileUtility;
import genericutility.FileUtilityUsingExcel;
import javaUtility.JavaUtility;


public class CreateCampaign
{
	@Test()
	public void createCampaign() throws Throwable
	{
		WebDriver driver;
		FileUtility fl=new FileUtility();
		String browser = fl.getDataFromProperties("Browser");
		String url=fl.getDataFromProperties("URL");
		String uname=fl.getDataFromProperties("Username");
		String pwd=fl.getDataFromProperties("Password");
		if(browser.equals("Chrome"))
			driver=new ChromeDriver();
		else if(browser.equals("Edge"))
			driver=new EdgeDriver();
		else if(browser.equals("Firefox"))
			driver=new FirefoxDriver();
		else
			driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get(url);
		driver.findElement(By.xpath("//input[@name='username']")).sendKeys(uname);
		driver.findElement(By.xpath("//input[@name='password']")).sendKeys(pwd);
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		driver.findElement(By.xpath("//span[text()='Create Campaign']")).click();
		FileUtilityUsingExcel flexcel=new FileUtilityUsingExcel();
		JavaUtility ju=new JavaUtility();
		
		
		String cname = flexcel.getDatafromExcel("CreateCampaignTestData", 1, 0)+ ju.getRand();
		String size=flexcel.getDatafromExcel("CreateCampaignTestData", 1, 1);
		driver.findElement(By.name("campaignName")).sendKeys(cname);
		driver.findElement(By.name("targetSize")).sendKeys(size);
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		
	}

}
