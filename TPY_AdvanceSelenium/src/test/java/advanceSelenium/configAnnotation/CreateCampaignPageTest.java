package advanceSelenium.configAnnotation;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import POM_Pages.CRM_Createcampaign;
import advanceSelenium.listeners.ListImplementation;
import baseclass.BaseTest;
import genericutility.FileUtilityUsingExcel;
import javaUtility.JavaUtility;
import reportsutilityobject.UtilityObject;
import webdriverutility.WebDriverUtiity;


@Listeners(ListImplementation.class)
public class CreateCampaignPageTest extends BaseTest
{
	@Test(groups="smokeTest")
	public void createCampaignTest() throws Exception
	{
		log.createCampaignlink();
		FileUtilityUsingExcel fexcel=new FileUtilityUsingExcel();
		

		String cname=fexcel.getDatafromExcel("CreateCampaignTestData", 1, 0);
		String size=fexcel.getDatafromExcel("CreateCampaignTestData", 1, 1);
		UtilityObject.getTest().log(Status.INFO, "Create a Campaign");
		CRM_Createcampaign camp=new CRM_Createcampaign(driver);
		camp.createCampaignfeild(cname);
		camp.targetSizefeild(size);
		camp.campaignButton();
		UtilityObject.getTest().log(Status.INFO, "Campaign Created");
		Thread.sleep(7000);
	}
	@Test(groups="regressionTest")
	public void createCampaignWithClosedDateTest() throws Exception
	{
		log.createCampaignlink();
		FileUtilityUsingExcel fexcel=new FileUtilityUsingExcel();
		JavaUtility ju=new JavaUtility();
	   
		String cname=fexcel.getDatafromExcel("CreateCampaignTestData", 1, 0);
		String size=fexcel.getDatafromExcel("CreateCampaignTestData", 1, 1);
		UtilityObject.getTest().log(Status.INFO, "Create a Campaign");
		CRM_Createcampaign camp=new CRM_Createcampaign(driver);
		camp.createCampaignfeild(cname);
		camp.targetSizefeild(size);
		
		String dt=ju.getDate();
	    camp.expectedCloseDate(dt);
		camp.campaignButton();
		UtilityObject.getTest().log(Status.INFO, "Campaign Created");
		Thread.sleep(7000);
	}
	

}
