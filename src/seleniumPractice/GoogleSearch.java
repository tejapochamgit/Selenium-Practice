package seleniumPractice;


import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Iterator;
import java.util.Properties;
import java.util.Scanner;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import org.apache.commons.io.FileUtils;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class GoogleSearch 
{

	public static void main(String[] args) throws IOException 
	{
		System.setProperty("webdriver.gecko.driver","D:/Tej/Test Automation/Downloads/geckodriver-v0.23.0-win32/geckodriver.exe");
		WebDriver driver = new FirefoxDriver();
		driver.get("http://www.yahoo.com");
		
		//Maximize and Delete all cookies
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		driver.manage().deleteAllCookies();
		
		//Alerts
		Alert alert = driver.switchTo().alert();
		alert.accept();
		alert.dismiss();
		
		//select Class
		Select s=new Select(driver.findElement(By.xpath("//input[contains(text(),'test')]")));
		s.selectByIndex(1);
		s.selectByValue("india");
		s.selectByVisibleText("india");
		
		//Actions class
		Actions action = new Actions(driver);
		action.moveToElement(driver.findElement(By.xpath("//input[@text='test']")));
		action.clickAndHold(driver.findElement(By.xpath("//input[@text='test']"))).moveToElement(driver.findElement(By.xpath("//input[@text='test']")));
		
		//Window handles
		
		Set<String> handler = driver.getWindowHandles();
		Iterator<String> it = handler.iterator();
		String value1= it.next();
		
		driver.switchTo().window(value1);
		driver.close();
		
		//Read Properties
		
		Properties prop = new Properties();
		FileInputStream fis = new FileInputStream("c:\\test.xlsx");
		prop.load(fis);
		
		String value = prop.getProperty("test");
		System.out.println(value);
		
		//Excel read & write
		
		FileInputStream fis1= new FileInputStream("fasdfasdf");
		Workbook wb=WorkbookFactory.create(fis1);
		
		Sheet sh1=wb.getSheetAt(0);
		sh1.getRow(1).getCell(1).getStringCellValue();
		
		Row row =sh1.createRow(1);
		Cell cell = row.createCell(1);
		cell.setCellValue("test");
		
		FileOutputStream fop = new FileOutputStream("test.xlsx");
		wb.write(fop);
		fop.close();		
		
		//Input from Keyboard
		Scanner sc = new Scanner(System.in);
		sc.next();
		sc.close();
		
		//Screenshot
		
		File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(src,new File("test.test"));
		
		
 		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}
}

