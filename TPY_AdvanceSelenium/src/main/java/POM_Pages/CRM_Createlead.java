package POM_Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CRM_Createlead 
{
	public CRM_Createlead(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	@FindBy(name="leadStatus")
	WebElement leadstatus;
	@FindBy(xpath = "//input[@name='name']")
	WebElement leadname;
	@FindBy(name="company")
	WebElement companyname;
	@FindBy(name="leadSource")
	WebElement leadsource;
	@FindBy(name="industry")
	WebElement industry;
	@FindBy(name="phone")
	WebElement phone;
	@FindBy(xpath = "(//button[@type='button'])[2]")
	WebElement campaign;
	@FindBy(xpath="//button[@type='submit']")
	WebElement createlead;
	@FindBy(name="rating")
	WebElement rating;
	public void leadStatusField(String ls)
	{
		leadstatus.sendKeys(ls);
	}
	public void leadNameField(String lname)
	{
		leadname.sendKeys(lname);
	}
	public void comapnyField(String cmp)
	{
		companyname.sendKeys(cmp);
	}
	public void leadSourceField(String lsource)
	{
		leadsource.sendKeys(lsource);
	}
	public void industryField(String ind)
	{
		industry.sendKeys(ind);
	}
	public void phoneField(String ph)
	{
		phone.sendKeys(ph);
	}
	public void ratingField(String r)
	{
		rating.sendKeys(r);
	}
	public void campaign()
	{
		campaign.click();
	}
	public void createLeadButton()
	{
		createlead.click();
	}


}
