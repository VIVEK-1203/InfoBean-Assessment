package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ResultPage {
	
	WebDriver driver;
	@CacheLookup
	@FindBy(css = ".home-redirect.redbus-logo")
	WebElement ret_home;
	
	
	public ResultPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver,this);
	}
	
	public void RetunHome() {
		ret_home.click();
	}

}
