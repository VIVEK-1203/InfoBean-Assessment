package testsuite;

import java.io.IOException;

import org.junit.Test;

import pageObjects.ContactUsPage;
import pageObjects.HomePage;
import pageObjects.ResultPage;
import pageObjects.RydePage;
import utilities.BaseClass;

public class RedBus extends BaseClass {
	
	HomePage hp;
	ResultPage re;
	ContactUsPage cp;
	RydePage rp;
	@Test
	public void trial () throws IOException {
		
		invokeBrowser();				// open browser
		openUrl();						// go to redbus.in
		hp = new HomePage(driver); 
		hp.EnterSource("Indore");  		  // Entering Source
		hp.EnterDestination("Pune");	 // Entering Destination
		hp.EnterDate();					 // Entering Date
		hp.Search();					 // Clicking on Search
		re = new ResultPage(driver);
		re.RetunHome();					// Returning Home
		cp = hp.ClickContactUs();		// Scrolling down and clicking Contact Us
		rp = cp.ClickRyde();			// Clicking Ryde
		rp.playVideo();					//	Playing the video for 5 sec
		hp = ReturnToMainPage(rp.driver, rp.ParentId);  	// Navigating back to home page
		hp.ClickTwittweButton();							// Clicking on Twitter Icon
		quitBrowser();										// Closing driver Instance
		
		
	}
	
}
