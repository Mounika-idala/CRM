package POM_Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class CRM_LoginandHomepage
{
	
	public CRM_LoginandHomepage(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}
	@FindBy(xpath = "//input[@name='username']")
	WebElement Username;
	@FindBy(xpath ="//input[@name='password']")
	WebElement Password;
	@FindBy(xpath = "//button[@type='submit']")
	WebElement SignIn;
	@FindBy(xpath = "//span[text()='Create Campaign']")
	WebElement createCamapign;
	@FindBy(xpath="//a[text()='Leads']")
	WebElement leadlink;
	@FindBy(xpath="//span[text()='Create Lead']")
	WebElement createLead;
	@FindBy (className = "form-control")
	WebElement selectdopdown;
	@FindBy(xpath="//input[@type='text']")
	WebElement searchfeild;
	@FindBy(xpath = "//div[@class='user-icon']")
	WebElement logout;
	
	public void usernamefeild(String uname)
	{
		Username.sendKeys(uname);
	}
	public void passwordfeild(String pwd)
	{
		Password.sendKeys(pwd);
	}
	public void signinbutton()
	{
		SignIn.click();
	}
	public void createCampaignlink()
	{
		createCamapign.click();
	}
	public void lead()
	{
		leadlink.click();
	}
	public void createLeadLink()
	{
		createLead.click();
	}
	public void select(String txt)
	{
		
		Select myselect=new Select(selectdopdown);
		 myselect.selectByContainsVisibleText("Search by Campaign Name");
		 searchfeild.sendKeys(txt);
	}
	
}
