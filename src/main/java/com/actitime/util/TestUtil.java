package com.actitime.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.actitime.base.TestBase;


public class TestUtil extends TestBase {

	public static long PAGE_LOAD_TIMEOUT =40;
	public static long IMPLICIT_WAIT = 40;
	
	
	public void swithToFrame(String frameName) {
		
		driver.switchTo().frame(frameName);
		
	}
	
	public static String TESTDATA_SHEET_PATH = "C:\\workspace\\assignment\\TestData.xlsx";

//	static Workbook book;
//	static Sheet sheet;
	static JavascriptExecutor js;
	static XSSFWorkbook book;
	static XSSFSheet sheet;


	public void switchToFrame() {
		driver.switchTo().frame("mainpanel");
	}

	public static Object[][] getTestData(String sheetName) {
		FileInputStream file = null;
		try {
			file = new FileInputStream(TESTDATA_SHEET_PATH);
			System.out.println("TestFile = " + file);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		try {
			book = new XSSFWorkbook(file);
			System.out.println("****TestBook " + book);
			sheet = book.getSheetAt(0);
			System.out.println("****TestSheet " + sheet);
		} catch (IOException e) {
			e.printStackTrace();
		}
		//sheet = wBook.getSheet(sheetName);
		
	//	String data = null;
		//Row row = null;
		
//		for (int i = 0; i < sheet.getPhysicalNumberOfRows(); i++) {
//			Row row = sheet.getRow(i);
//			for (int j =0; j<row.getPhysicalNumberOfCells();j++) {
//				Cell cell = row.getCell(j);
//				data = cell.getStringCellValue();
//			}
//		}
	try {
//		
		Object[][] data = new Object[(sheet).getLastRowNum()][(sheet).getRow(0).getLastCellNum()];
		
		for (int i = 0; i < (sheet).getLastRowNum(); i++) {
			for (int k = 0; k < (sheet).getRow(0).getLastCellNum(); k++) {
				data[i][k] = (sheet).getRow(i + 1).getCell(k).getStringCellValue().trim();
				
			}
			
		}
		return data;
		}
catch(NullPointerException ex) {
			ex.printStackTrace();
		}
//		Object[][] data = null;
		return null;

	}
	
//	public static Object[][] getTestData(String sheetName) {
//		FileInputStream file = null;
//		try {
//			file = new FileInputStream(TESTDATA_SHEET_PATH);
//			System.out.println("TestFile = " + file);
//		} catch (FileNotFoundException e) {
//			e.printStackTrace();
//		}
//		try {
//			book = WorkbookFactory.create(file);
//			//book = new XSSFWorkbook(file);
//			System.out.println("TestBook " + book);
//		} catch (InvalidFormatException e) {
//			e.printStackTrace();
//		}catch (IOException e) {
//			e.printStackTrace();
//		}
//		sheet = book.getSheet(sheetName);
//		
//	//	String data = null;
//		//Row row = null;
//		
////		for (int i = 0; i < sheet.getPhysicalNumberOfRows(); i++) {
////			Row row = sheet.getRow(i);
////			for (int j =0; j<row.getPhysicalNumberOfCells();j++) {
////				Cell cell = row.getCell(j);
////				data = cell.getStringCellValue();
////			}
////		}
//		try {
//		
//		Object[][] data = new Object[(sheet).getLastRowNum()][(sheet).getRow(0).getLastCellNum()];
//		
//		for (int i = 0; i < (sheet).getLastRowNum(); i++) {
//			for (int k = 0; k < (sheet).getRow(0).getLastCellNum(); k++) {
//				data[i][k] = (sheet).getRow(i + 1).getCell(k).getStringCellValue().trim();
//				
//			}
//			
//		}
//		return data;
//		}catch(NullPointerException ex) {
//			ex.printStackTrace();
//		}
//		
//		return null;
//
//	}
	
	public static void takeScreenshotAtEndOfTest() throws IOException {
		File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		String currentDir = System.getProperty("user.dir");
		FileUtils.copyFile(scrFile, new File(currentDir + "/screenshots/" + System.currentTimeMillis() + ".png"));
	}
}