package advanceSelenium.listeners;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import baseclass.BaseTest;



public class HomePage_CRM extends BaseTest
{
	@Test
	public void homepagetest()
	{
		String expecteddata="Campaigns";
		String actdata=driver.findElement(By.xpath("//b[.='Campaigns']")).getText();
		Assert.assertEquals(actdata, expecteddata);
	}

}
