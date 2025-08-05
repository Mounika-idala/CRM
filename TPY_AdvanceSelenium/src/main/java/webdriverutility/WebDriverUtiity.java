package webdriverutility;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class WebDriverUtiity 
{
	public void waitPageToLoad(WebDriver driver)
	{
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
	}
	public void switchingWindows(WebDriver driver,String partialurl)
	{
		String parentwin = driver.getWindowHandle();
		Set<String> childwin = driver.getWindowHandles();
		for(String windows:childwin)
		{
			if(windows.contains(partialurl))
			{
				driver.switchTo().window(windows);
				
			}
		}
		driver.switchTo().window(parentwin);
	}

}
