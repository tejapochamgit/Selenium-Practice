package testNGBasics;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class GoogleTest {
	WebDriver driver;
	@BeforeMethod
	public void openApp(){
	
		System.setProperty("webdriver.gecko.driver","D:/Tej/Test Automation/Downloads/geckodriver-v0.23.0-win32/geckodriver.exe");
		driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.get("http://www.google.com");
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	}
	
	@Test(priority=1)
	public void checkLogo(){
		Boolean b = driver.findElement(By.id("hplogo")).isDisplayed();
		Assert.assertTrue(b);
	}
	
	@Test(priority=2)
	public void checkTitle(){
		String title = driver.getTitle();
		Assert.assertEquals(title,"Google");
	}
	@Test(priority=3,groups="first")
	public void checkLink(){
		String title = driver.getTitle();
		Assert.assertEquals(title,"Google");
	}
	@Test(priority=4,groups="first",invocationCount=2)
	public void checkSearch(){
		driver.findElement(By.name("q")).sendKeys("teja");
		
		Actions action = new Actions(driver);
		action.sendKeys(Keys.ENTER).build().perform();
	}
	
	@AfterMethod
	public void closeApp(){
		driver.quit();
	}

}
