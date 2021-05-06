package util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Write {
	public static void updateResult(String testCaseName, String testStatus) throws IOException {

		try {
			String excellocation = System.getProperty("user.dir") +"\\src\\test\\java\\resources\\testdata\\run script (1).xlsx";
			String sheetName="Run1 - Scripts";
			FileInputStream file = new FileInputStream(new File(excellocation));

			// Create Workbook instance holding reference to .xlsx file
			XSSFWorkbook workbook = new XSSFWorkbook(file);

			// Get first/desired sheet from the workbook
			XSSFSheet sheet = workbook.getSheet(sheetName);
			// count number of active tows
			int totalRow = sheet.getLastRowNum() + 1;
			// count number of active columns in row
			for (int i = 1; i < totalRow; i++) {
				XSSFRow r = sheet.getRow(i);
				String ce = r.getCell(1).getStringCellValue();
				if (ce.contains(testCaseName)) {
					r.createCell(2).setCellValue(testStatus);
					file.close();
					FileOutputStream outFile = new FileOutputStream(new File(excellocation));
					workbook.write(outFile);
					outFile.close();
					break;
				}

			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
