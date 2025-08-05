package advanceSelenium.excel;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.time.Duration;
import java.util.Properties;

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
import org.openqa.selenium.support.ui.Select;

public class SCM_AddRetailers {

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
		
		driver.findElement(By.xpath("//a[.='Add Retailers']")).click();
		//TestScript Data
		FileInputStream fis1=new FileInputStream("F:\\QSP Course\\TekPyramid\\AddRetailersTestData.xlsx");
		Workbook wb = WorkbookFactory.create(fis1);
		Sheet sh = wb.getSheet("Sheet1");
		Row row = sh.getRow(1);
		String username = row.getCell(0).toString();
		String password = row.getCell(1).toString();
		String phone = row.getCell(2).toString();
		String eml = row.getCell(3).toString();
		String address = row.getCell(4).toString();
		wb.close();
		driver.findElement(By.name("txtRetailerUname")).sendKeys(username);
		driver.findElement(By.name("txtRetailerPassword")).sendKeys(password);
		WebElement areacode = driver.findElement(By.id("retailer:areaCode"));
		areacode.click();
		Select sl=new Select(areacode);
		sl.selectByValue("2");
		driver.findElement(By.id("retailer:phone")).sendKeys(phone);
		driver.findElement(By.name("txtRetailerEmail")).sendKeys(eml);
		driver.findElement(By.id("retailer:address")).sendKeys(address);
		driver.findElement(By.cssSelector("[type='submit']")).click();
		


	

}

}
