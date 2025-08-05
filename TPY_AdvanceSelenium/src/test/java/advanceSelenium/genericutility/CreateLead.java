package advanceSelenium.genericutility;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import genericutility.FileUtility;
import genericutility.FileUtilityUsingExcel;
import javaUtility.JavaUtility;
import webdriverutility.WebDriverUtiity;

public class CreateLead 
{
	@Test()
	public void createLeadPage() throws Throwable
	{
		WebDriver driver;
		FileUtility fl=new FileUtility();
		WebDriverUtiity wu=new WebDriverUtiity();
		FileUtilityUsingExcel flexcel=new FileUtilityUsingExcel();
		JavaUtility ju=new JavaUtility();
		String browser=fl.getDataFromProperties("Browser");
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
		driver.get(url);
		driver.manage().window().maximize();
		wu.waitPageToLoad(driver);
		driver.findElement(By.xpath("//input[@name='username']")).sendKeys(uname);
		driver.findElement(By.xpath("//input[@name='password']")).sendKeys(pwd);
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		driver.findElement(By.xpath("//a[text()='Leads']")).click();
		driver.findElement(By.xpath("//span[text()='Create Lead']")).click();
		String ls = flexcel.getDatafromExcel("CreateLeadTestData", 1, 0);
		String ln = flexcel.getDatafromExcel("CreateLeadTestData", 1, 1)+ ju.getRand();
		String cmp = flexcel.getDatafromExcel("CreateLeadTestData", 1, 2);
		String lsource = flexcel.getDatafromExcel("CreateLeadTestData", 1, 3);
		String ind = flexcel.getDatafromExcel("CreateLeadTestData", 1, 4);
		String ph = flexcel.getDatafromExcel("CreateLeadTestData", 1, 5);
		String rating = flexcel.getDatafromExcel("CreateLeadTestData", 1, 6);
		driver.findElement(By.xpath("//input[@name='name']")).sendKeys(ln);
		driver.findElement(By.name("company")).sendKeys(cmp);
		driver.findElement(By.name("leadSource")).sendKeys(lsource);
		driver.findElement(By.name("industry")).sendKeys(ind);
		driver.findElement(By.name("phone")).sendKeys(ph);
		driver.findElement(By.name("leadStatus")).sendKeys(ls);
		driver.findElement(By.name("rating")).sendKeys(rating);
		driver.findElement(By.xpath("(//button[@type='button'])[2]")).click();
		wu.switchingWindows(driver, "selectCampaign");
		driver.findElement(By.xpath("//button[@class='select-btn']")).click();
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		
		
		
		
		
	}

}
