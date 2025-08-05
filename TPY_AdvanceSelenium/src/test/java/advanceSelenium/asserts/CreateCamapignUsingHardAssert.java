package advanceSelenium.asserts;

import java.io.FileInputStream;
import java.time.Duration;
import java.util.Properties;
import java.util.Random;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import POM_Pages.CRM_Createcampaign;
import POM_Pages.CRM_LoginandHomepage;

import genericutility.FileUtilityUsingExcel;
import javaUtility.JavaUtility;

public class CreateCamapignUsingHardAssert
{
	@Test
	public void createCampaign() throws Exception
	{
		WebDriver driver;
		FileInputStream fis=new FileInputStream("F:\\QSP Course\\TekPyramid\\CRM_CommonData.properties");
		Properties pro=new Properties();
		pro.load(fis);
		String browser=pro.getProperty("Browser");
		String url=pro.getProperty("URL");
		String name=pro.getProperty("Username");
		String psword=pro.getProperty("Password");
		
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
		
		CRM_LoginandHomepage log=new CRM_LoginandHomepage(driver);
		log.usernamefeild(name);
		log.passwordfeild(psword);
		log.signinbutton();
		log.createCampaignlink();
		
		FileInputStream fis1=new FileInputStream("F:\\QSP Course\\TekPyramid\\CRM_TestData.xlsx");
		Workbook wb=WorkbookFactory.create(fis1);
		Sheet sh = wb.getSheet("CreateCampaignTestData");
		Row row = sh.getRow(1);
		String cname = row.getCell(0).getStringCellValue();
		String no = row.getCell(1).getStringCellValue();
		wb.close();
		CRM_Createcampaign cc=new CRM_Createcampaign(driver);
		cc.createCampaignfeild(cname);
		cc.targetSizefeild(no);
		
		
		cc.campaignButton();
		WebDriverWait mywait=new WebDriverWait(driver,Duration.ofSeconds(10));
		WebElement txt=driver.findElement(By.xpath("//div[@class='Toastify__toast-body']"));
		mywait.until(ExpectedConditions.visibilityOf(txt));
		String TEXT = txt.getText();
		System.out.println(TEXT);
		//Assert.assertTrue(true, TEXT);
		Assert.assertTrue(TEXT.contains(cname), "It doesn't contain expected campaign name: " + cname);

		//Assert.assertEquals(cname, TEXT.contains(cname));

		
	}

}
