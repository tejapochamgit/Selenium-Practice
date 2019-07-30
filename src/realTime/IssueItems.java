package realTime;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class IssueItems {

	
	public static void main(String[] args) throws IOException {
		
		 //create an object of Workbook and pass the FileInputStream object into it to create a pipeline between the sheet and eclipse.
		 FileInputStream fis = new FileInputStream("C:/Users/Teja.p/Desktop/items.xlsx");
		 Workbook wb = WorkbookFactory.create(fis);
		 //call the getSheet() method of Workbook and pass the Sheet Name here. 
		 //In this case I have given the sheet name as “TestData” 
		 //or if you use the method getSheetAt(), you can pass sheet number starting from 0. Index starts with 0.
		 //XSSFSheet sheet = workbook.getSheetAt(0);
		 Sheet sheet1 = wb.getSheetAt(3);
		 Sheet sheet2 = wb.getSheetAt(4);
		 
		 //get last row number of sheet2
		 int lastRow = sheet1.getLastRowNum();
		 //System.out.println(lastRow);
		 
		
		 ArrayList<String> item = new ArrayList<String>();
		 for (int i=0;i<=5;i++){
			 String itemName=sheet1.getRow(0).getCell(i+2).getStringCellValue();
			 item.add(itemName);
		 }
		 int lastRowSh1 = 1;
		 for (int j=0;j<=lastRow-1;j++){
			 
			 String buildingName=sheet1.getRow(j+1).getCell(1).getStringCellValue();
			 System.out.println(buildingName);
			 
			 double qty1=sheet1.getRow(j+1).getCell(2).getNumericCellValue();
			 System.out.println(qty1);
			 for (int k=1;k<=qty1;k++)
			 {
				 System.out.println("in loop");
				 Row row = sheet2.createRow(lastRowSh1);
				 Cell cell1=row.createCell(1);
				 lastRowSh1=lastRowSh1+1;
				 System.out.println(item.get(0));
				 cell1.setCellValue(item.get(0));
			 }
			 double qty2=sheet1.getRow(j+1).getCell(3).getNumericCellValue();
			 System.out.println(qty1);
			 for (int k=1;k<=qty2;k++)
			 {
				 System.out.println("in loop");
				 Row row = sheet2.createRow(lastRowSh1);
				 Cell cell1=row.createCell(1);
				 lastRowSh1=lastRowSh1+1;
				 System.out.println(item.get(0));
				 cell1.setCellValue(item.get(0));
			 }
				 
			 
		 }
		 FileOutputStream fos = new FileOutputStream("C:/Users/Teja.p/Desktop/items.xlsx");
		 wb.write(fos);
		 fos.close();
		 
		 System.out.println("END OF WRITING DATA IN EXCEL..Please check the file at Location 'C:/Users/Teja.p/Desktop/items.xlsx'");
		 
	}
}
	


