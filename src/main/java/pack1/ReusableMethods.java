package pack1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

public class ReusableMethods 
{
	
public static ExtentReports extentReports;
	
	public WebDriver openBrowser(WebDriver driver, String browserName, ExtentTest logger)
	{
		if(browserName.equalsIgnoreCase("Chrome"))
		{
			System.out.println(System.getProperty("os.name"));
			if(System.getProperty("os.name").contains("Mac"))
			{
			System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"//Drivers//MacDrivers//chromedriver");
			}
			else
			{
				System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"//Drivers//WindowsDrivers//chromedriver.exe");
			}
			driver = new ChromeDriver();
			driver.manage().window().maximize();
			System.out.println("Opening browser Successful");
			logger.log(Status.PASS, "Opening browser Successful");
		}
		
		return driver;
	}
	
	public static void configureExtentReports()
	{
		extentReports = ReportConfig.configure();
	}
	
	public ExtentTest startReportingForThisTestcase(ExtentTest logger, String tcName)
	{
		logger= extentReports.createTest(tcName);
		return logger;
	}
	
	public void finishAndSaveReport()
	{
		extentReports.flush();
	}
	
	public void navigateUrl(WebDriver driver, String url, ExtentTest logger)
	{
		try
		{
		 driver.get(url);
		 System.out.println("Navigation to "+url+" Successful");
		 logger.log(Status.PASS, "Navigation to "+url+" Successful");
		}
		catch(Exception e)
		{
			System.out.println("Navigation to "+url+" Failed");
			logger.log(Status.FAIL, "Navigation to "+url+" Failed");
			System.out.println(e.getMessage());
			Assert.fail("Navigation to "+url+" Failed");
		}
	}
	
	public WebElement waitForElement(WebDriver driver, String xpath, ExtentTest logger)
	{
		WebElement element = null;
		try
		{
		WebDriverWait ewait = new WebDriverWait(driver, 20);
		element = ewait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath(xpath))));
		return element;
		}
		catch(Exception e)
		{
			System.out.println("Required element does not exist or not displayed");
			System.out.println(e.getMessage());
			logger.log(Status.FAIL, "Required element does not exist or not displayed----"+e.getMessage());
			Assert.fail("Required element does not exist or not displayed");
			return null;
		}
	}
	
	public void enterData(WebDriver driver, String xpath,String element,String data,ExtentTest logger)
	{
		try
		{
		waitForElement(driver, xpath, logger).sendKeys(data);
		System.out.println("Entering "+"\""+data+"\""+" into "+element+" Successful");
		logger.log(Status.PASS, "Entering "+"\""+data+"\""+" into "+element+" Successful");
		}
		catch(Exception e)
		{
			System.out.println("Entering "+"\""+data+"\""+" into "+element+" Failed");
			logger.log(Status.FAIL, "Entering "+"\""+data+"\""+" into "+element+" Failed");
			System.out.println(e.getMessage());
			Assert.fail("Entering "+"\""+data+"\""+" into "+element+" Failed");
		}
		
	}
	
	public void clickElement(WebDriver driver, String xpath,String element,ExtentTest logger)
	{
		try
		{
			waitForElement(driver, xpath, logger).click();
			System.out.println("Clicking on "+element+" Successful");
			logger.log(Status.PASS, "Clicking on "+element+" Successful");
		}
		catch(Exception e)
		{
			System.out.println("Clicking on "+element+" Failed");
			logger.log(Status.FAIL, "Clicking on "+element+" Failed");
			System.out.println(e.getMessage());
			Assert.fail("Clicking on "+element+" Failed");
		}
	}
	
	public void closeBrowser(WebDriver driver, ExtentTest logger)
	{
		driver.close();
		System.out.println("Closing browser Successful");
		logger.log(Status.PASS, "Browser closed successfully");
	}
	
	public void waitFor(int seconds) throws InterruptedException
	{
		System.out.println("Waiting for "+String.valueOf(seconds)+" Seconds");
		Thread.sleep(seconds * 1000);
	}
	
	

}
