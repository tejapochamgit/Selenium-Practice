package seleniumPractice;

import java.io.File;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class CheckBrokenLinks {

	
	public static void main(String[] args) throws MalformedURLException, IOException 
	{
		System.setProperty("webdriver.gecko.driver", "D:/Tej/Test Automation/Downloads/geckodriver-v0.23.0-win32/geckodriver.exe");
		WebDriver driver = new FirefoxDriver();
		driver.get("http://www.google.com/");
		
		File src=((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		
		FileUtils.copyFile(src, new File("C://Users//Teja.p//Desktop//Claim//test.png"));
		
		
		List<WebElement> linksList = driver.findElements(By.tagName("a"));
		linksList.addAll(driver.findElements(By.tagName("img")));
		
		ArrayList<WebElement> activeLinks = new ArrayList<WebElement>();
				
		
		for (int i=0; i<linksList.size();i++){
		
		if((linksList.get(i).getAttribute("href")!=null)&&!(linksList.get(i).getAttribute("href").contains("javascript"))){
		activeLinks.add(linksList.get(i));	
		}
		}
		
		System.out.println("All Links in Page are"+linksList.size());
		System.out.println("Active Links in Page are"+activeLinks.size());
		int k=0;
		for (int j=0;j<activeLinks.size();j++){
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
