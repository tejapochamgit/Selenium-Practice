package seleniumPractice;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class WindowHandles {

	
	public static void main(String[] args) {
		
		System.setProperty("webdriver.gecko.driver", "D:/Tej/Test Automation/Downloads/geckodriver-v0.23.0-win32/geckodriver.exe");
		WebDriver driver = new FirefoxDriver();
		driver.get("http://google.com");
		driver.manage().window().maximize();
		
		Set<String> handler = driver.getWindowHandles();
		System.out.println(handler.size());
		
		Iterator<String> it=handler.iterator();
		
		String ParentWindowId = it.next();
		System.out.println(ParentWindowId);
		
		driver.quit();
	}
}
