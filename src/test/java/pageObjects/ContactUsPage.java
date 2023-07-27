package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactUsPage {
	
	WebDriver driver;
	final String ParentId;
	HomePage hp;
	RydePage rp;
	
	
	
	
	
	@FindBy( css = "#rYde")
	WebElement go_to_ryde;
	
	public ContactUsPage(WebDriver driver,String ParentId) {
		this.ParentId = ParentId;
		this.driver = driver;
		PageFactory.initElements(driver,this);
	}
	
	public RydePage ClickRyde() {
		go_to_ryde.click();
		rp = new RydePage(driver,ParentId);
		return rp;
	}
	
	public HomePage GoToMainPage() {
		driver.close();
		driver.switchTo().window(ParentId);
		hp = new HomePage(driver);
		return hp;
		
	}

}
