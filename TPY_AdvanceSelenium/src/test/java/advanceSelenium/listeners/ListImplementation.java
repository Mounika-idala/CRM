package advanceSelenium.listeners;

import java.io.File;
import java.io.IOException;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.io.FileHandler;
import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import baseclass.BaseTest;
import reportsutilityobject.UtilityObject;



public class ListImplementation implements ITestListener,ISuiteListener
{
	public ExtentReports report;
	public ExtentTest  test;

	@Override
	public void onStart(ISuite suite) 
	{
		ExtentSparkReporter spark=new ExtentSparkReporter("./AdvanceReports/CRM_Screenshots.html");
		spark.config().setDocumentTitle("CRM");
		spark.config().setReportName("CRM Report");
		spark.config().setTheme(Theme.STANDARD);
	    report=new ExtentReports();
		report.attachReporter(spark);
		report.setSystemInfo("OS", "Windows-10");
	}

	@Override
	public void onFinish(ISuite suite) {
		// TODO Auto-generated method stub
		report.flush();
	}

	@Override
	public void onTestStart(ITestResult result)
	{
		String testname=result.getName();
		test = report.createTest(testname);
		
	    UtilityObject.setTest(test);
		
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		UtilityObject.setTest(test);
		String testname=result.getName();
		test.log(Status.PASS, "Test is passed");
		TakesScreenshot ts=(TakesScreenshot)BaseTest.sdriver;
		String src=ts.getScreenshotAs(OutputType.BASE64);
		test.addScreenCaptureFromBase64String(src, testname);
		
	}

	@Override
	public void onTestFailure(ITestResult result)
	{
		UtilityObject.setTest(test);
		String dt=new Date().toString().replace(" ", "_").replace(":", "_");
		String testname=result.getName();
		TakesScreenshot ts=(TakesScreenshot)BaseTest.sdriver;
		String src=ts.getScreenshotAs(OutputType.BASE64);
		test.addScreenCaptureFromBase64String(src, testname+"_"+dt);
				
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

}
