package utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import pageObjects.HomePage;

public class BaseClass {
	
	public static WebDriver driver;
	Properties prop;
	FileInputStream fis;
	
	
	
	public WebDriver invokeBrowser() {
		ChromeOptions co = new ChromeOptions();
		co.addArguments("--remote-allow-origins=*");
		//System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "//src//test//java//Drivers//chromedriver.exe");
		driver = new ChromeDriver(co);
		//driver.get("https://www.google.com");
		return driver;
	}
	
	public void openUrl() throws IOException {
		prop = new Properties();
		fis = new FileInputStream(System.getProperty("user.dir")+ "//src//test//java//resources//resource.properties");
		prop.load(fis);
		String URL = prop.getProperty("url");
		System.out.println(URL);
		driver.get(URL);
		driver.manage().window().maximize();
		
		
	}
	
	public HomePage ReturnToMainPage(WebDriver driver, String ParentId) {
		driver.close();
		driver.switchTo().window(ParentId);
		HomePage hp = new HomePage(driver);
		return hp;
	}
	
	
	
	public void quitBrowser() {
		driver.quit();
	}

}
	