package testng;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;

public class excelDataSupllier {
	
//	@DataProvider(name="login")
//	public static String[][]getexceldata() throws Exception  {
//		File file=new File("./src/test/java/testng/datasheet.xlsx");
//		FileInputStream stream=new FileInputStream(file);
//		XSSFWorkbook wb=new XSSFWorkbook(stream);
//		XSSFSheet sheet=wb.getSheet("sheet1");
//		DataFormatter df=new DataFormatter();
//		int row=sheet.getPhysicalNumberOfRows();
//		int col=sheet.getRow(0).getLastCellNum();
//		
//		String[][]data=new String[row-1][col];
//		for(int i=0;i<row-1;i++) {
//			for(int j=0;j<col;j++) {
//				data[i][j]=df.formatCellValue(sheet.getRow(i+1).getCell(j));
//			}
//		}
//		wb.close();
//		stream.close();
//		return data;
//	}
	@DataProvider(name="loginData")
	public String[][] getData() throws Exception {
		File excelFile = new File("./src/test/java/datasheet.xlsx");
		FileInputStream fis = new FileInputStream(excelFile);
		XSSFWorkbook workbook = new XSSFWorkbook(fis);
		XSSFSheet sheet = workbook.getSheet("Sheet1");
		int noOfRows = sheet.getLastRowNum();
		int noOfColumns = sheet.getRow(0).getLastCellNum();
		DataFormatter df = new DataFormatter();
	
		String data[][] = new String[noOfRows][noOfColumns];
		for (int i = 0; i < noOfRows; i++) {
			for (int j = 0; j < noOfColumns; j++) {				
				data[i][j] =  df.formatCellValue(sheet.getRow(i+1).getCell(j));
			}
		}
		workbook.close();
		fis.close();
		return data;
}
}
