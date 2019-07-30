package seleniumPractice;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class CheckBrokenLinks1 {

	public static void main(String[] args) throws MalformedURLException, IOException {
		
		System.setProperty("webdriver.gecko.driver", "D:/Tej/Test Automation/Downloads/geckodriver-v0.23.0-win32/geckodriver.exe");
		WebDriver driver;
		driver = new FirefoxDriver();
		driver.get("http://localhost:8080/AMS");
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		
		//1.List of all links
		
		List<WebElement> list = driver.findElements(By.tagName("a"));
		list.addAll(driver.findElements(By.tagName("img")));
		
		System.out.println("All Links count in the List are--->"+list.size());
		
		//2.List all active links
		
		ArrayList<WebElement> activeLinks = new ArrayList<WebElement>();
		
		for(int i=0;i<list.size();i++){
			
			if(list.get(i).getAttribute("href")!=null && !(list.get(i).getAttribute("href").contains("javascript"))){
			activeLinks.add(list.get(i));
			}
			
		}
		System.out.println("Active links count is----------->"+activeLinks.size());
		
		for (int j=0;j<activeLinks.size();j++){
			
			HttpURLConnection connection = (HttpURLConnection)new URL(activeLinks.get(j).getAttribute("href")).openConnection();
			connection.connect();
			
			if(connection.getResponseMessage().equals("OK")){
				System.out.println(activeLinks.get(j).getAttribute("href")+"------------------->OK");
			}
		}
		

	}

}
