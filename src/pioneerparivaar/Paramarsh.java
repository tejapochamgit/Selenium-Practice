package pioneerparivaar;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Paramarsh {

	
	public static void main(String[] args) throws InterruptedException {
		
		System.setProperty("webdriver.gecko.driver", "D:/Tej/Test Automation/Downloads/geckodriver-v0.23.0-win32/geckodriver.exe");
		WebDriver driver = new FirefoxDriver();
		driver.get("http://pioneer.empover.com");
		driver.manage().window().maximize();
		WebDriverWait wait = new WebDriverWait (driver, 20);
		wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.id("mobile"))));
		driver.findElement(By.id("mobile")).sendKeys("8125576564");
		driver.findElement(By.id("password")).sendKeys("Sun$1234");
		driver.findElement(By.id("chkIAgree")).click();
		driver.findElement(By.xpath("//button[contains(text(),'SIGN IN')]")).click();
		
		Thread.sleep(3000);
		driver.findElement(By.xpath("//img[contains(@src,'Content/images/paramarsa.png')]")).click();
		Thread.sleep(2000);
		
		

	}

}
