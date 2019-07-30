package realTime;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class GetReviewtext {

	
	public static void main(String[] args) throws EncryptedDocumentException, IOException, InterruptedException {
		System.setProperty("webdriver.gecko.driver", "D:/Tej/Test Automation/Downloads/geckodriver-v0.23.0-win32/geckodriver.exe");
		WebDriver driver = new FirefoxDriver();
		driver.get("https://play.google.com/store/apps/details?id=com.pioneer.india.directsales&hl=en&showAllReviews=true");
		driver.manage().window().maximize();
		Thread.sleep(3000);
		
		List<WebElement> userName = driver.findElements(By.xpath("//span[@class='X43Kjb']"));
		List<WebElement> rating = driver.findElements(By.xpath("//span[@class='X43Kjb']/parent::div/div/span/div[@class='pf5lIe']/div"));
		List<WebElement> reviewText = driver.findElements(By.xpath("//span[@class='X43Kjb']/parent::div/parent::div/following-sibling::div/span[@jsname='bN97Pc']"));
		
		FileInputStream fis = new FileInputStream("C:/Users/Teja.p/Desktop/review.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sheet1 = wb.getSheet("Sheet1");
		System.out.println(userName.size());
		System.out.println(rating.size());
		System.out.println(reviewText.size());
		int lastRowSh1 = 1;
		for (int i=0;i<userName.size();i++){
			Row row = sheet1.createRow(lastRowSh1);
			Cell cell1=row.createCell(1);
			Cell cell2=row.createCell(2);
			Cell cell3=row.createCell(3);
			cell1.setCellType(CellType.STRING);
			cell1.setCellValue(userName.get(i).getText());
			cell2.setCellType(CellType.STRING);
			cell2.setCellValue(rating.get(i).getAttribute("aria-label").substring(5, 7));
			cell3.setCellType(CellType.STRING);
			cell3.setCellValue(reviewText.get(i).getText());
			lastRowSh1=lastRowSh1+1;
		}
		FileOutputStream fos = new FileOutputStream("C:/Users/Teja.p/Desktop/review.xlsx");
		wb.write(fos);
		fos.close();
		
		System.out.println("END OF WRITING DATA IN EXCEL..Please check the file at Location 'C:/Users/Teja.p/Desktop/review.xlsx'");

	}
}
