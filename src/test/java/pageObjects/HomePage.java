package pageObjects;

import java.time.Duration;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage  {
	
	private WebDriver driver;
	WebDriverWait wait;
	ContactUsPage cp;



	
@CacheLookup
@FindBy (css = "#src")
WebElement source;

@CacheLookup
@FindBy (css = "#dest")
WebElement destination;

@CacheLookup
@FindBy (css = "#search_button")
WebElement search;

@CacheLookup
@FindBy (css = "#onwardCal")
WebElement date;

@CacheLookup
@FindBy (xpath = "//ul[starts-with(@class,'sc')]" )
WebElement drop;

@CacheLookup
@FindBy (css = "#contact_us_footer")
WebElement contact_us;

@CacheLookup
@FindBy( css = "#redbus_twitter")
WebElement twitter;

public HomePage(WebDriver driver) {
	this.driver = driver;
	PageFactory.initElements(driver, this);
}




public void EnterSource(String src) {
	source.sendKeys(src);
	wait = new WebDriverWait(driver, Duration.ofSeconds(3));
	try {
	wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//ul[starts-with(@class,'sc')]")));
	List<WebElement> sel = driver.findElements(By.xpath("//ul[starts-with(@class,'sc')]/li"));
	sel.get(0).click();}
	catch(TimeoutException e) {
		source.sendKeys(Keys.TAB);
	}
	//source.sendKeys(Keys.ENTER);
}

public void EnterDestination(String dest) {
	destination.sendKeys(dest);
	wait = new WebDriverWait(driver, Duration.ofSeconds(2));
	try {
	wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//ul[starts-with(@class,'sc')]")));
	List<WebElement> sel = driver.findElements(By.xpath("//ul[starts-with(@class,'sc')]/li"));
	sel.get(0).click();
	}
	catch(TimeoutException e) {
		e.printStackTrace();
	}
//	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
//	destination.sendKeys(Keys.ENTER);
//	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
}

public void EnterDate() {
	date.click();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
   WebElement dtable = driver.findElement(By.xpath("//div[contains(@class,'DayNavigator__CalendarHeader')]"));
   System.out.print("Date Table is displayed");
   if(dtable.isDisplayed()) {
	   WebElement arrow = driver.findElement(By.cssSelector("svg#Layer_1"));
	  Actions a = new Actions(driver);
	  a.moveToElement(arrow).build().perform();
	while(!dtable.findElement(By.xpath("//div[starts-with(@class,'DayNavigator__CalendarHeader')]//div[2] ")).getText().contains("Dec")) {
		a.click().build().perform();
		
	}
	wait = new WebDriverWait(driver, Duration.ofSeconds(5));
	wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[starts-with(@class,'DayTiles__CalendarDays')]/span[text()='1']")));
	WebElement dates   = dtable.findElement(By.xpath("//div[starts-with(@class,'DayTiles__CalendarDays')]/span[text()='1']"));
	a.moveToElement(dates).click().build().perform();	
	
   }
      else
	   System.out.println("Date Table isn't displayed ");
	   
}

public ContactUsPage ClickContactUs() {
	JavascriptExecutor js = (JavascriptExecutor) driver;
	js.executeScript("arguments[0].scrollIntoView();", contact_us);
	wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	wait.until(ExpectedConditions.visibilityOf(contact_us));
	contact_us.click();
	Set<String> h = driver.getWindowHandles();
	Iterator<String> itr = h.iterator();
	
	final String parentId = itr.next();
	final String childId = itr.next();
	
	driver.switchTo().window(childId);
	
	cp = new ContactUsPage(driver,parentId);
	return cp;
}

public void ClickTwittweButton() {
	JavascriptExecutor js = (JavascriptExecutor) driver;
	js.executeScript("arguments[0].scrollIntoView();", twitter);
	wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	wait.until(ExpectedConditions.visibilityOf(twitter));
	twitter.click();
	try {
		Thread.sleep(3000);
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}

public void Search() {
	search.click();
}



}
