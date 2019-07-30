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


public class ExcelWrite {

	
	public static void main(String[] args) throws IOException {
		
		 //create an object of Workbook and pass the FileInputStream object into it to create a pipeline between the sheet and eclipse.
		 FileInputStream fis = new FileInputStream("C:/Users/Teja.p/Desktop/items.xlsx");
		 Workbook wb = WorkbookFactory.create(fis);
		 //call the getSheet() method of Workbook and pass the Sheet Name here. 
		 //In this case I have given the sheet name as “TestData” 
		 //or if you use the method getSheetAt(), you can pass sheet number starting from 0. Index starts with 0.
		 //XSSFSheet sheet = workbook.getSheetAt(0);
		 Sheet sheet1 = wb.getSheetAt(0);
		 Sheet sheet2 = wb.getSheetAt(1);
		 
		 //get last row number of sheet2
		 int lastRow = sheet2.getLastRowNum();
		 //System.out.println(lastRow);
		 
		 //storing items & quantity in array
		 ArrayList<String> items = new ArrayList<String>();
		 ArrayList<Double> itemsCount = new ArrayList<Double>();
		 
		 for (int i=1;i<=lastRow;i++){
			 
			 String itemName=sheet2.getRow(i).getCell(1).getStringCellValue();
			 double quantity=sheet2.getRow(i).getCell(2).getNumericCellValue();
			 //System.out.println(itemName+"  "+quantity);
			 items.add(itemName);
			 itemsCount.add(quantity);
			 
		 }
		 
		 System.out.println("No of Items in Sheet are-->"+items.size());
		 //System.out.println(itemsCount.size());
		 
		 int lastRowSh1 = 1; //Sheet1
		 
		 for (int k=0;k<items.size();k++){
			 
			 //System.out.println("Last Row No after first item"+lastRowSh1);
			 
			 for (int j=1;j<=itemsCount.get(k);j++){
				 Row row = sheet1.createRow(lastRowSh1);
				 Cell cell1=row.createCell(0);
				 Cell cell2=row.createCell(2);
				 Cell cell3=row.createCell(3);
				 Cell cell4=row.createCell(4);
				 cell1.setCellType(CellType.STRING);
				 cell2.setCellType(CellType.STRING);
				 cell3.setCellType(CellType.STRING);
				 cell4.setCellType(CellType.STRING);
				 //System.out.println(items.get(k));
				 cell1.setCellValue(items.get(k));
				 cell2.setCellValue("1");
				 cell3.setCellValue("1");
				 cell4.setCellValue("1");
				 lastRowSh1=lastRowSh1+1;
			 }
			 
			 //System.out.println("K loop completed"+k);
			 
		 }
			 FileOutputStream fos = new FileOutputStream("C:/Users/Teja.p/Desktop/items.xlsx");
			 wb.write(fos);
			 fos.close();
			 
			 System.out.println("END OF WRITING DATA IN EXCEL..Please check the file at Location 'C:/Users/Teja.p/Desktop/items.xlsx'");
	}
}

	


