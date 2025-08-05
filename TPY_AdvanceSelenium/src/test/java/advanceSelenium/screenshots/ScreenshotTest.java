package advanceSelenium.screenshots;

import java.io.File;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.annotations.Test;

import POM_Pages.CRM_LoginandHomepage;
import genericutility.FileUtility;

public class ScreenshotTest 
{
	@Test
	public void screenshottest() throws Throwable 
	{
		//WebDriver driver=new ChromeDriver();
		ChromeDriver driver=new ChromeDriver();
		//driver.getS
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		CRM_LoginandHomepage log=new CRM_LoginandHomepage(driver);
		FileUtility fl=new FileUtility();
		String url=fl.getDataFromProperties("URL");
		String user=fl.getDataFromProperties("Username");
		String pwd=fl.getDataFromProperties("Password");
		driver.get(url);
		log.usernamefeild(user);
		log.passwordfeild(pwd);
		log.signinbutton();
		TakesScreenshot ts=(TakesScreenshot)driver;
		File src=ts.getScreenshotAs(OutputType.FILE);
		File dest=new File("./Screenshot/fullpage.png");
		FileHandler.copy(src, dest);
		WebElement element=driver.findElement(By.cssSelector("[placeholder='Search by Campaign Id']"));
		File src1=element.getScreenshotAs(OutputType.FILE);
		File dest1=new File("./Screenshot/CreateCampaign.png");
		FileHandler.copy(src1, dest1);
	}
	
	
	

}
