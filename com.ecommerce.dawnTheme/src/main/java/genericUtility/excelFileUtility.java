package genericUtility;

import java.io.FileInputStream;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class excelFileUtility {

	/**
	 * This method will read data from excel file
	 * 
	 * @throws Exception
	 */

	public String toReadDataFromExcelFile(String sheetName, int row, int cell) throws Exception {
		FileInputStream fis = new FileInputStream(iConstantUtility.excelPath);
		Workbook book = WorkbookFactory.create(fis);
		String value = book.getSheet(sheetName).getRow(row).getCell(cell).getStringCellValue();
		return value;
	}

	public int toGetRowCount(String sheetName) throws Exception {
		FileInputStream fis = new FileInputStream("iConstantUtility.excelPath");
		Workbook book = WorkbookFactory.create(fis);
		Sheet sheet = book.getSheet(sheetName);
		int row = sheet.getLastRowNum();
		return row;
	}
}
