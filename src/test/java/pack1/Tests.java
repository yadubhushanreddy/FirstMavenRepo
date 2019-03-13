package pack1;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentTest;


public class Tests 
{
	public ExtentTest logger,logger1;
	
	ReusableMethods reuse = new ReusableMethods();
	
	@BeforeSuite
	public void preSetup()
	{
		ReusableMethods.configureExtentReports();
	
	}
	  
	  @Test
	  public void testCase1() throws InterruptedException 
	  {
		  WebDriver driver = null;
		  logger = reuse.startReportingForThisTestcase(logger,"Sample TestCase1");
		  driver = reuse.openBrowser(driver,"Chrome",logger);
		  reuse.waitFor(4);
		  reuse.navigateUrl(driver,"http://newtours.demoaut.com/",logger);
		  reuse.waitFor(4);
		  reuse.clickElement(driver,"//a[text()='REGISTER']", "Register", logger);
		  reuse.waitFor(4);
		  reuse.enterData(driver,"//input[@name='firstName']", "First Name", "Yadu bhushan", logger);
		  reuse.enterData(driver,"//input[@name='lastName']", "Last Name", "Allatipalli", logger);
		  reuse.waitFor(4);
		  reuse.closeBrowser(driver,logger);
	  }
	  
	  @Test
	  public void testCase2() throws InterruptedException 
	  {
		  WebDriver driver = null;
		  logger1 = reuse.startReportingForThisTestcase(logger1,"Sample TestCase2");
		  driver = reuse.openBrowser(driver,"Chrome",logger1);
		  reuse.waitFor(4);
		  reuse.navigateUrl(driver,"http://newtours.demoaut.com/",logger1);
		  reuse.waitFor(4);
		  reuse.clickElement(driver,"//a[text()='REGISTER']", "Register", logger1);
		  reuse.waitFor(4);
		  reuse.enterData(driver,"//input[@name='firstName']", "First Name", "Yadu bhushan", logger1);
		  reuse.enterData(driver,"//input[@name='lastName']", "Last Name", "Allatipalli", logger1);
		  reuse.waitFor(4);
		  reuse.closeBrowser(driver,logger1);
	  }
	  
	  @AfterSuite
	  public void tearDown()
	  {
		  reuse.finishAndSaveReport();
	  }

}
