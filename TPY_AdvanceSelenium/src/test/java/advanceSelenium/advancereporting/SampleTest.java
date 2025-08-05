package advanceSelenium.advancereporting;

import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class SampleTest 
{
	@Test
	public void createContactTest()
	{
		//Report Configuration
		ExtentSparkReporter spark=new ExtentSparkReporter("./AdvanceReports/SampleReport.html");
		spark.config().setDocumentTitle("CreateContactReports");
		spark.config().setReportName("Reports");
		spark.config().setTheme(Theme.STANDARD);
		//Report Environment information and create Test
		ExtentReports report=new ExtentReports();
		report.attachReporter(spark);
		report.setSystemInfo("OS", "Windows-10");
		ExtentTest test = report.createTest("createContactTest");
		test.log(Status.INFO, "login to app");
		test.log(Status.INFO, "Navigate to contact");
		test.log(Status.INFO,"Create contact");
		if("Mounika".equals("Mounika"))
			test.log(Status.PASS, "Contact created");
		else
			test.log(Status.FAIL, "Contact created");
		report.flush();
		
	}

}
