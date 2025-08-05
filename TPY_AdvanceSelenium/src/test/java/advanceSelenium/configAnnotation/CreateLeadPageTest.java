package advanceSelenium.configAnnotation;

import java.util.Set;

import org.openqa.selenium.By;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import POM_Pages.CRM_Createlead;
import advanceSelenium.listeners.ListImplementation;
import baseclass.BaseTest;
import genericutility.FileUtilityUsingExcel;
import javaUtility.JavaUtility;
import reportsutilityobject.UtilityObject;

@Listeners(ListImplementation.class)
public class CreateLeadPageTest extends BaseTest
{
	@Test(groups="smokeTest")
	public void createLeadtest() throws Exception
	{
		log.lead();
		log.createLeadLink();
		CRM_Createlead lead=new CRM_Createlead(driver);
		FileUtilityUsingExcel fexcel=new FileUtilityUsingExcel();
		JavaUtility ju=new JavaUtility();
		String leadstatus=fexcel.getDatafromExcel("CreateLeadTestData", 1, 0);
		String leadname=fexcel.getDatafromExcel("CreateLeadTestData", 1, 1)+ju.getRand();
		String cmpny=fexcel.getDatafromExcel("CreateLeadTestData", 1, 2);
		String leadsource=fexcel.getDatafromExcel("CreateLeadTestData", 1, 3);
		String indstry=fexcel.getDatafromExcel("CreateLeadTestData", 1, 4);
		String phn=fexcel.getDatafromExcel("CreateLeadTestData", 1, 5);
		String rtng=fexcel.getDatafromExcel("CreateLeadTestData", 1, 6);
		lead.leadStatusField(leadstatus);
		lead.leadNameField(leadname);
		lead.comapnyField(cmpny);
		lead.leadSourceField(leadsource);
		lead.industryField(indstry);
		lead.phoneField(phn);
		lead.ratingField(rtng);
		lead.campaign();
		String parent = driver.getWindowHandle();
		Set<String> child = driver.getWindowHandles();
		System.out.println(parent);
		System.out.println(child);
		for(String win:child)
		{
			if(!win.equals(parent))
			{
				driver.switchTo().window(win);
				driver.findElement(By.xpath("//button[@class='select-btn']")).click();
			}
		}
		driver.switchTo().window(parent);
		lead.createLeadButton();
		UtilityObject.getTest().log(Status.INFO, "Lead is Created");
		Thread.sleep(7000);
	}

}
