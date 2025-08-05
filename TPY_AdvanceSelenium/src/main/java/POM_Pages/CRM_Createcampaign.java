package POM_Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CRM_Createcampaign 
{
	public CRM_Createcampaign(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	@FindBy(name = "campaignName")
	WebElement campaignname;
	@FindBy(name = "targetSize")
	WebElement size;
	@FindBy(name="expectedCloseDate")
	WebElement expdate;
	@FindBy(xpath = "//button[@type='submit']")
	WebElement campbutton;
	public void createCampaignfeild(String name)
	{
		campaignname.sendKeys(name);
	}
	public void targetSizefeild(String n)
	{
		size.sendKeys(n);
	}
	public void expectedCloseDate(String dt)
	{
		expdate.sendKeys(dt);
	}
	public void campaignButton()
	{
		campbutton.click();
	}

}
