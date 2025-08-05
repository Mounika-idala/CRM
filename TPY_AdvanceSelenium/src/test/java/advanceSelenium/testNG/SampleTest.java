package advanceSelenium.testNG;

import org.testng.annotations.Test;

public class SampleTest
{
	@Test
	public void createContacttest()
	{
		System.out.println("Contact created");
	}
	@Test(dependsOnMethods = "createContacttest",invocationCount = 5)
	public void modifyContacttest()
	{
		System.out.println("Contact modified");
	}
	@Test(enabled = false)
	public void deleteContacttest()
	{
		System.out.println("Contact deleted");
	}
	@Test(priority = 1)
	public void logintest()
	{
		System.out.println("logged in");
	}
	

}
