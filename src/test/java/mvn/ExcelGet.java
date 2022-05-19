package mvn;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelGet {
	public static void main(String[] args) throws IOException {
		File file = new File("C:\\Users\\ADMIN\\eclipse-workspace\\mvn\\TESTDATA\\vj.xlsx");
		FileInputStream stream = new FileInputStream(file);
		Workbook wrbk = new XSSFWorkbook(stream);
		Sheet sheet = wrbk.getSheet("Sheet1");
//		Row row = sheet.getRow(1);
//		Cell cell = row.getCell(1);
//		String stringCellValue = cell.getStringCellValue();
//		System.out.println(stringCellValue);
		for (int i = 0; i < sheet.getPhysicalNumberOfRows(); i++) {
			Row row = sheet.getRow(i);
			for (int j = 0; j < row.getPhysicalNumberOfCells(); j++) {
				Cell cell = row.getCell(j);
				String sc = cell.getStringCellValue();
				System.out.println(sc);
				
			}
			
		}
	}

}
