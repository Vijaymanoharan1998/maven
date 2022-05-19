package mvn;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Seconday {
	public static void main(String[] args) throws IOException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("http://demo.automationtesting.in/Register.html");

		WebElement sel = driver.findElement(By.id("Skills"));
		Select select = new Select(sel);
		List<WebElement> options = select.getOptions();
		File file = new File("C:\\Users\\ADMIN\\eclipse-workspace\\mvn\\TESTDATA\\vj.xlsx");

		FileInputStream stream = new FileInputStream(file);
		Workbook wrkbk = new XSSFWorkbook(stream);
		Sheet createSheet = wrkbk.createSheet("vij");

		for (int i = 0; i <options.size() ; i++) {
			WebElement sel2 = options.get(i);
			String text = sel2.getText();
			System.out.println(text);
			Row createRow = createSheet.createRow(i);
			Cell createCell = createRow.createCell(0);
			createCell.setCellValue(text);
		}

		FileOutputStream stream2 = new FileOutputStream(file);
		wrkbk.write(stream2);
		System.out.println("done");
	}
}

