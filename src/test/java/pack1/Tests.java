package pack1;

import org.testng.annotations.Test;


public class Tests 
{
	
	ReusableMethods reuse = new ReusableMethods();
	  
	  @Test
	  public void testCase1() throws InterruptedException 
	  {
		  reuse.openBrowser("Chrome");
		  reuse.waitFor(4);
		  reuse.navigateUrl("http://newtours.demoaut.com/");
		  reuse.waitFor(4);
		  reuse.closeBrowser();	  
	  }

}
