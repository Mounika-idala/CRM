package advanceSelenium.testNG;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import genericutility.FileUtility;
import genericutility.FileUtilityUsingExcel;
import javaUtility.JavaUtility;

public class CreateCampaignUsingDataProvider 
{
	@DataProvider
	public Object[][] getData() throws Exception
	{
		JavaUtility jul=new JavaUtility();
		FileUtilityUsingExcel fexcel=new FileUtilityUsingExcel();
		int rowcount = fexcel.getRowcount("CreateCampaignTestData");
		Object[][] myobj=new Object[rowcount][2];
		for(int i=0;i<rowcount;i++)
		{
			myobj[i][0]=fexcel.getDatafromExcel("CreateCampaignTestData",i+1,0)+jul.getRand();
			myobj[i][1]=fexcel.getDatafromExcel("CreateCampaignTestData",i+1,1);
			System.out.println("Data:" + myobj[i][0] + " |"  + myobj[i][1]);
			
		}
		return myobj;
	}
	@Test(dataProvider = "getData")
	public void createCampaigntest(String campaignName, String targetSize) throws Throwable
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
		
		driver.findElement(By.name("campaignName")).sendKeys(campaignName);
		driver.findElement(By.name("targetSize")).sendKeys(targetSize);
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		driver.quit();
		
	}
	
	
}
