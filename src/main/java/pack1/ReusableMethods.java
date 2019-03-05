package pack1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ReusableMethods 
{
	
WebDriver driver;
	
	public void openBrowser(String browserName)
	{
		if(browserName.equalsIgnoreCase("Chrome"))
		{
			System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"//Drivers//chromedriver");
			driver = new ChromeDriver();
			driver.manage().window().maximize();
			System.out.println("Opening browser Successful");
		}
	}
	
	public void navigateUrl(String url)
	{
		try
		{
		 driver.get(url);
		 System.out.println("Navigation to "+url+" Successful");
		}
		catch(Exception e)
		{
			System.out.println("Navigation to "+url+" Failed");
		}
	}
	
	public void enterData(String xpath,String data)
	{
		driver.findElement(By.xpath(xpath)).sendKeys(data);
		System.out.println("Entering data Successful");
	}
	
	public void closeBrowser()
	{
		driver.close();
		System.out.println("Closing browser Successful");
	}
	
	public void waitFor(int seconds) throws InterruptedException
	{
		System.out.println("Waiting for "+String.valueOf(seconds)+" Seconds");
		Thread.sleep(seconds * 1000);
	}

}
