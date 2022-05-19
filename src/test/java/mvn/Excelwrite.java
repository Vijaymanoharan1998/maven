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
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Excelwrite {
	public static void main(String[] args) throws IOException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("http://www.adactin.com/HotelApp/");
		WebElement txtuser = driver.findElement(By.id("username"));
		WebElement pass = driver.findElement(By.id("password"));
		WebElement login = driver.findElement(By.id("login"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].setAttribute('value','vijayram000')",txtuser );
		js.executeScript("arguments[0].setAttribute('value','123456789')", pass);
		js.executeScript("arguments[0].click()",login);
		File file = new File("C:\\Users\\ADMIN\\eclipse-workspace\\mvn\\TESTDATA\\vj.xlsx");
		FileInputStream stream = new FileInputStream(file);
		Workbook wrbk = new XSSFWorkbook(stream);
		Sheet sheet = wrbk.createSheet("location");
		WebElement loc = driver.findElement(By.xpath("//*[@id=\"location\"]"));
		Select select = new Select(loc);
		List<WebElement> options = select.getOptions();
		for (int i = 0; i < options.size(); i++) {
			WebElement get = options.get(i);
			String text = get.getText();
			Row row = sheet.createRow(i);
			Cell cell = row.createCell(0);
			cell.setCellValue(text);
		}
		WebElement hstl = driver.findElement(By.xpath("//*[@id=\"hotels\"]"));
		Select select2 = new Select(hstl);
		List<WebElement> options2 = select2.getOptions();
		for (int i = 0; i < options2.size(); i++) {
			WebElement txt = options2.get(i);
			String text = txt.getText();
			Row cr = sheet.createRow(i);
			Cell cc = cr.createCell(1);
			cc.setCellValue(text);
			
		}
		FileOutputStream stream2 = new FileOutputStream(file);
		wrbk.write(stream2);
		System.out.println("done");
		
		
	}

}
