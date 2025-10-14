package com.client.NM_HospitalManage.genericUtility;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelUtility {

	public String getDataFromExcelFile(String sheetName, int rowNum, int cellNum) throws IOException {
		Workbook workbook = null;
		String data = null;
		try {
			FileInputStream fis = new FileInputStream("");
			workbook = WorkbookFactory.create(fis);
			Sheet sheet = workbook.getSheet(sheetName);
			Row row = sheet.getRow(rowNum);
			Cell cell = row.getCell(cellNum);
			data = cell.toString();
		} catch (Exception e) {
			e.printStackTrace();
		}
		workbook.close();
		return data;
	}

	public void writeDataBackToExcel(String sheetName, int rowNum, int cellNum, String value) throws IOException {
		Workbook workbook = null;
		try {
			FileInputStream fis = new FileInputStream("");
			workbook = WorkbookFactory.create(fis);
			Sheet sheet = workbook.getSheet(sheetName);
			Row row = sheet.getRow(rowNum);
			Cell cell = row.createCell(cellNum, CellType.STRING);
			cell.setCellValue(value);
		} catch (Exception e) {
			e.printStackTrace();
		}

		FileOutputStream fos = new FileOutputStream("");
		workbook.write(fos);
		workbook.close();
	}

	public int getRowCount(String sheetName) throws IOException {
		Workbook workbook = null;
		int rowCount = 0;
		try {
			FileInputStream fis = new FileInputStream("");
			workbook = WorkbookFactory.create(fis);
			Sheet sheet = workbook.getSheet(sheetName);
			rowCount = sheet.getLastRowNum();
		} catch (Exception e) {
			e.printStackTrace();
		}
		workbook.close();
		return rowCount;
	}
}
