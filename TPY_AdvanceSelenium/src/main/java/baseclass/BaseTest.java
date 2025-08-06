package baseclass;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import POM_Pages.CRM_LoginandHomepage;
import genericutility.FileUtility;
import io.github.bonigarcia.wdm.WebDriverManager;
import webdriverutility.WebDriverUtiity;

public class BaseTest
{
	public WebDriver driver;
	public FileUtility fl=new FileUtility();
	public WebDriverUtiity wul=new WebDriverUtiity();
	public CRM_LoginandHomepage log=new CRM_LoginandHomepage(driver);
	public static WebDriver sdriver;
	
	@Parameters("browser")
	@BeforeClass(groups= {"smokeTest","regressionTest"})
	public void beforeClass() throws Throwable
	{	
		//String browser = fl.getDataFromProperties("Browser");
		//String browser=BROWSER ;
		String browser=System.getProperty("Browser",fl.getDataFromProperties("Browser"));
		if(browser.equals("Chrome"))
			driver=new ChromeDriver();
		
		else if(browser.equals("Edge"))
		{
			WebDriverManager.edgedriver().setup();
			driver=new EdgeDriver();
		}
		else if(browser.equals("Firefox"))
			driver=new FirefoxDriver();
		else
			driver=new ChromeDriver();
		sdriver=driver;
	}
	@BeforeMethod(groups= {"smokeTest","regressionTest"})
	public void beforeMethod() throws Throwable
	{
//		   String url = fl.getDataFromProperties("URL");
//	        String usname = fl.getDataFromProperties("Username");
//	        String passwd = fl.getDataFromProperties("Password");
		//Passing data through maven
		String url=System.getProperty("Url",fl.getDataFromProperties("URL"));
		String usname=System.getProperty("Username",fl.getDataFromProperties("Username"));
		String passwd=System.getProperty("Password",fl.getDataFromProperties("Password"));

	        driver.manage().window().maximize();
	        wul.waitPageToLoad(driver);
	        driver.get(url);

	        log = new CRM_LoginandHomepage(driver);

	        log.usernamefeild(usname);
	        log.passwordfeild(passwd);
	        log.signinbutton();
	}
	@AfterMethod(groups= {"smokeTest","regressionTest"})
	public void afterMethod() throws InterruptedException
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
	    Actions myact = new Actions(driver);

	    WebElement userIcon = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".user-icon")));
	    myact.moveToElement(userIcon).perform();

	    WebElement logoutBtn = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".dropdown-item.logout")));
	    logoutBtn.click();
	}
	@AfterClass(groups= {"smokeTest","regressionTest"})
	public void afterClass()
	{
		driver.quit();
	}



}
