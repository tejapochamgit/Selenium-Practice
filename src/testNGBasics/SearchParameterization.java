package testNGBasics;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class SearchParameterization {
	
	
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
	
	@Test(dataProvider="getData")
	public void setData(String searchValue){
		
	driver.findElement(By.id("q")).sendKeys(searchValue);	
	System.out.println(searchValue+": Search Value");
		
	}
	
	@DataProvider
	public Object[][] getData(){
		
		Object[][] data= new Object[2][1];
		
	
		return data;
		
		
	}
	
	@AfterMethod
	public void closeApp(){
		driver.quit();
	}
	

}
