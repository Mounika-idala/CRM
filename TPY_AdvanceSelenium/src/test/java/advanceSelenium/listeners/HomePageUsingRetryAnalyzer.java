package advanceSelenium.listeners;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import baseclass.BaseTest;

public class HomePageUsingRetryAnalyzer extends BaseTest
{
	@Test(retryAnalyzer = RetryAnalyzerImp.class)
	public void Homepage()
	{
		String expecteddata="Campaign";
		String actdata=driver.findElement(By.xpath("//b[.='Campaigns']")).getText();
		Assert.assertEquals(actdata, expecteddata);
	}

}
