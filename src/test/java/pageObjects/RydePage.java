package pageObjects;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class RydePage {

	@FindBy(xpath = "//div[contains(text(),'More about rYde')]")
	WebElement more_abt_ryde;
	
	@FindBy( css = "#player")
	WebElement player;
	
	
	
	public WebDriver driver;
	WebDriverWait wait;
	public final String ParentId;
	
	public RydePage(WebDriver driver, String ParentId) {
		this.ParentId = ParentId;
		this.driver = driver;
		PageFactory.initElements(driver,this);
	}
	
	
	public void playVideo()  {
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView();", more_abt_ryde);
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(more_abt_ryde));
		driver.switchTo().frame(player);
		Actions a = new Actions(driver);
		
		a.click(driver.findElement(By.xpath("//button[contains(@class,\"ytp-large-play-button\")]"))).build().perform();
		driver.switchTo().defaultContent();
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
