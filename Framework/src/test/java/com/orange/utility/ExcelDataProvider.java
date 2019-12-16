package com.orange.utility;

import java.io.File;
import java.io.FileInputStream;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelDataProvider {
	XSSFWorkbook wb;
	public ExcelDataProvider()
	{
		File src = new File("./TestData/Data.xlsx");
		
		try {
			FileInputStream fis = new FileInputStream(src);
			wb = new XSSFWorkbook(fis);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("Unable to read the workbook "+e.getMessage());
		} 
	}
	
	public String getStringData(String sheetName, int row, int colNo)
	{
		return wb.getSheet(sheetName).getRow(row).getCell(colNo).getStringCellValue();
	}
	
	public String getStringData(int sheetIndex, int row, int colNo)
	{
		return wb.getSheetAt(sheetIndex).getRow(row).getCell(colNo).getStringCellValue();
	}
	
	public int getNumericData(int sheetIndex, int row, int colNo)
	{
		return (int) (wb.getSheetAt(sheetIndex).getRow(row).getCell(colNo).getNumericCellValue());
	}
	
	public int getNumericData(String sheetName, int row, int colNo)
	{
		return (int) (wb.getSheet(sheetName).getRow(row).getCell(colNo).getNumericCellValue());
	}
	
	
	

}
