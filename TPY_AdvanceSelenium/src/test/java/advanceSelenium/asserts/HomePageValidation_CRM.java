package advanceSelenium.asserts;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import advanceSelenium.listeners.ListImplementation;
import baseclass.BaseTest;


@Listeners(ListImplementation.class)
public class HomePageValidation_CRM extends BaseTest
{
	@Test
	public void homepagetest()
	{
		String expecteddata="Campaign";
		String actdata=driver.findElement(By.xpath("//b[.='Campaigns']")).getText();
		Assert.assertEquals(actdata, expecteddata);
	}

}
