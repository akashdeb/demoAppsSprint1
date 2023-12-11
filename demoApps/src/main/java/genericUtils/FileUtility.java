package genericUtils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class FileUtility {
	
	public String fetchDataFromPropertyFile(String key) throws IOException {
		
		FileInputStream fis = new FileInputStream(
				"C:\\Users\\User\\Desktop\\Scripts\\eclipse-workspace_September2023_10AM\\demoApps\\src\\test\\resources\\testData\\demoAppsPropertyData.properties");

		Properties prop = new Properties();
		prop.load(fis);
 
		return prop.getProperty(key);

		
	}
	
	public String fetchStringDataFromExcelFile(String sheetName, int rowNo, int cellNo) throws EncryptedDocumentException, IOException {
		
		FileInputStream fis = new FileInputStream(
				"C:\\Users\\User\\Desktop\\Scripts\\eclipse-workspace_September2023_10AM\\demoApps\\src\\test\\resources\\testData\\demoAppsTestData.xlsx");

		
		return WorkbookFactory.create(fis).getSheet(sheetName).getRow(rowNo).getCell(cellNo).getStringCellValue();
		
		
	}
	
	public double fetchNumericDataFromExcelFile(String sheetName, int rowNo, int cellNo) throws EncryptedDocumentException, IOException {
		
		FileInputStream fis = new FileInputStream(
				"C:\\Users\\User\\Desktop\\Scripts\\eclipse-workspace_September2023_10AM\\demoApps\\src\\test\\resources\\testData\\demoAppsTestData.xlsx");

		
		return WorkbookFactory.create(fis).getSheet(sheetName).getRow(rowNo).getCell(cellNo).getNumericCellValue();
		
		
	}
	
public boolean fetchBooleanDataFromExcelFile(String sheetName, int rowNo, int cellNo) throws EncryptedDocumentException, IOException {
		
		FileInputStream fis = new FileInputStream(
				"C:\\Users\\User\\Desktop\\Scripts\\eclipse-workspace_September2023_10AM\\demoApps\\src\\test\\resources\\testData\\demoAppsTestData.xlsx");

		
		return WorkbookFactory.create(fis).getSheet(sheetName).getRow(rowNo).getCell(cellNo).getBooleanCellValue();
		
		
	}

}
