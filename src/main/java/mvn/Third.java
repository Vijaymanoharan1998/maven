package mvn;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Third {
	public static void main(String[] args) throws IOException {
		File file = new File("C:\\Users\\ADMIN\\eclipse-workspace\\mvn\\TESTDATA\\vj.xlsx");
		FileInputStream stream = new FileInputStream(file);
		Workbook wrbk = new XSSFWorkbook(stream);
		Sheet sheet = wrbk.getSheet("Sheet1");
		for (int i = 0; i < sheet.getPhysicalNumberOfRows(); i++) {
			Row row = sheet.getRow(i);
			for (int j = 0; j < row.getPhysicalNumberOfCells(); j++) {
				Cell cell = row.getCell(j);
				CellType cellType = cell.getCellType();
				switch(cellType){
				case STRING:
					String stringCellValue = cell.getStringCellValue();
					System.out.println(stringCellValue);
					break;
				case NUMERIC:
					if(DateUtil.isCellDateFormatted(cell)) {
						Date dcv = cell.getDateCellValue();
						SimpleDateFormat format = new SimpleDateFormat("dd-MMM-yyyy");
						String format2 = format.format(dcv);
						System.out.println(format2);
					}
					else {
					double numericCellValue = cell.getNumericCellValue();
					long l = (long) numericCellValue;
					System.out.println(l);
					break;
				}
			}
		}
	}
}
}