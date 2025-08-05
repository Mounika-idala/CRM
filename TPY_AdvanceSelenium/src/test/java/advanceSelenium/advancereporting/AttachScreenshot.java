package advanceSelenium.advancereporting;

import java.io.File;
import java.time.Duration;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class AttachScreenshot 
{
	public ExtentReports report;
	@BeforeSuite
	public void beforeConfig()
	{
		ExtentSparkReporter spark=new ExtentSparkReporter("./AdvanceReports/SampleFailedScreenshot.html");
		spark.config().setDocumentTitle("FailedScreeenshots");
		spark.config().setReportName("Failed");
		spark.config().setTheme(Theme.STANDARD);
	    report=new ExtentReports();
		report.attachReporter(spark);
		report.setSystemInfo("OS", "Windows-10");	
		
	}
	@AfterSuite
	public void afterConfig()
	{
		report.flush();
	}
	@Test
	public void HomePagetest() 
	{
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://demowebshop.tricentis.com/");
		TakesScreenshot ts=(TakesScreenshot)driver;
		String src = ts.getScreenshotAs(OutputType.BASE64);
		ExtentTest test = report.createTest("HomePagetest");
		test.addScreenCaptureFromBase64String(src,"failedTC");
		test.log(Status.INFO, "HomePage is displaying");
		String title=driver.getTitle();
		if(title.equals("Demo Web ShopPPP"))
			test.log(Status.PASS, "Title is verified");
		else
			test.log(Status.FAIL, "Mismatch in title");
		
		
		
	}

}
