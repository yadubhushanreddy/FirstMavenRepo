package pack1;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class ReportConfig 
{
	
	public static ExtentReports configure() 
	{
		ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter(System.getProperty("user.dir")+"/TestReport/TestReport.html");
		//htmlReporter.loadXMLConfig("ReportConfig.xml");
		ExtentReports extent = new ExtentReports();
		extent.attachReporter(htmlReporter);
		return extent;
	}

}
