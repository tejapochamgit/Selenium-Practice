package pioneerparivaar;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TestBrokenLinksHomepage {

	public static void main(String[] args) throws MalformedURLException, IOException {
		System.setProperty("webdriver.gecko.driver", "D:/Tej/Test Automation/Downloads/geckodriver-v0.23.0-win32/geckodriver.exe");
		WebDriver driver = new FirefoxDriver();
		driver.get("http://pioneer.empover.com");
		driver.manage().window().maximize();
		WebDriverWait wait = new WebDriverWait (driver, 20);
		wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.id("mobile"))));
		driver.findElement(By.id("mobile")).sendKeys("7702277392");
		driver.findElement(By.id("password")).sendKeys("Sun$1234");
		driver.findElement(By.id("chkIAgree")).click();
		driver.findElement(By.xpath("//button[contains(text(),'SIGN IN')]")).click();
		String curUrl=driver.getCurrentUrl();
		
		//check for broken links
		List<WebElement> linksList = driver.findElements(By.tagName("a"));
		linksList.addAll(driver.findElements(By.tagName("img")));
		
		ArrayList<WebElement> activeLinks = new ArrayList<WebElement>();
				
		
		for (int i=0; i<linksList.size();i++){
		
		if((linksList.get(i).getAttribute("href")!=null)){
		activeLinks.add(linksList.get(i));	
		}
		}
		
		System.out.println("All Links in Page are"+linksList.size());
		System.out.println("Active Links in Page are"+activeLinks.size());
		int k=0;
		for (int j=0;j<activeLinks.size();j++){
			System.out.println(activeLinks.get(j).getAttribute("href"));
			HttpURLConnection connection = (HttpURLConnection) new URL(activeLinks.get(j).getAttribute("href")).openConnection();
			connection.connect();
			System.out.println(activeLinks.get(j).getAttribute("href")+"----------------->"+connection.getResponseMessage());
			
			if (!connection.getResponseMessage().equalsIgnoreCase("OK")){
				k=k+1;
				System.out.println("Broken Link is--------------->" + activeLinks.get(j).getAttribute("href"));
			}
		}
				System.out.println("Broken Links are------------->"+k);
	}

}
