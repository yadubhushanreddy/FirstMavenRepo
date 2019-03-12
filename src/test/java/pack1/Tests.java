package pack1;

import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentTest;


public class Tests 
{
	public ExtentTest logger;
	
	ReusableMethods reuse = new ReusableMethods();
	  
	  @Test
	  public void testCase1() throws InterruptedException 
	  {
		  reuse.configureExtentReports();
		  logger = reuse.startReportingForThisTestcase(logger,"Sample TestCase");
		  System.out.println("Report Configuration Successful");
		  reuse.openBrowser("Chrome",logger);
		  reuse.waitFor(4);
		  reuse.navigateUrl("http://newtours.demoaut.com/",logger);
		  reuse.waitFor(4);
		  reuse.clickElement("//a[text()='REGISTER']", "Register", logger);
		  reuse.waitFor(4);
		  reuse.enterData("//input[@name='firstName']", "First Name", "Yadu bhushan", logger);
		  reuse.enterData("//input[@name='lastName']", "Last Name", "Allatipalli", logger);
		  reuse.waitFor(4);
		  reuse.closeBrowser(logger);
		  reuse.finishAndSaveReport(logger);
	  }

}
