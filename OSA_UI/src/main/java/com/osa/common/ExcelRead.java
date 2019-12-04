 package com.osa.common;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelRead {
	
	public static  Object[][] getTestData(String filePath,String sheetName) throws IOException {
		Object data[][]=null;
		DataFormatter formatter=new DataFormatter();

		try {
			XSSFWorkbook workbook=new XSSFWorkbook(new FileInputStream(new File(filePath)));
			XSSFSheet sheet=workbook.getSheet(sheetName);
			//get row and col size to create a two dimentional array
			int rowSize=sheet.getPhysicalNumberOfRows();
			int colSize=sheet.getRow(0).getLastCellNum();
			//creating two dimentional arry object
			data=new Object[rowSize][colSize];
			Iterator<Row> rowIterator=sheet.rowIterator();
			//Is there any value in the row
			int rowCount=0;
			
			while(rowIterator.hasNext()) {
				Row row=rowIterator.next();
				Iterator<Cell> cellIterator=row.cellIterator();
				int colCount=0;
				//is there any value in the cell
				while(cellIterator.hasNext()) {
					Cell cell=cellIterator.next();
					data[rowCount][colCount]=formatter.formatCellValue(cell);
					colCount++;
				}
				rowCount++;
			}	
			
		} catch (Exception e) {	
       System.out.println(e.getMessage());
		}
		return data;
		
	}

}
