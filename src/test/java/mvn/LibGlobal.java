package mvn;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LibGlobal {
	public void waitsss() {
      driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
	}
	public void quit() {
		driver.quit();
	}
	
	public static WebDriver driver;
	public void getdriver(String browser) {
		if (browser.equals("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		}
		else if(browser.equals("gecko")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		}
		else {
			WebDriverManager.iedriver().setup();
			driver = new InternetExplorerDriver();
		}
	}
	public void geturl(String url) {
		driver.get(url);
	}
	public WebElement findElementByid(String value) {
		WebElement textbox = driver.findElement(By.id(value));
		return textbox;
	}
	public void inserttextbox(WebElement ele,String value) {
		ele.sendKeys(value);
	}
	public void btnclk(WebElement ele) {
		ele.click();
	}
	public  Select select(WebElement ele,String ele2) {
		Select ele1 = new Select(ele);
		ele1.selectByValue(ele2);
		return ele1;
	}
	public String getExcel(String sheet,int value,int value1) throws IOException {
		File file = new File("C:\\Users\\ADMIN\\eclipse-workspace\\mvn\\TESTDATA\\vj.xlsx");
		FileInputStream stream = new FileInputStream(file);
		Workbook wrbk = new XSSFWorkbook(stream);
		Sheet s = wrbk.getSheet(sheet);
		Row row = s.getRow(value);
		Cell cell = row.getCell(value1);
		String value3 ="";
		int Type = cell.getCellType();
		if (Type==1) {
			value3 = cell.getStringCellValue();
		}
		else {
			if (DateUtil.isCellDateFormatted(cell)) {
				Date d = cell.getDateCellValue();
				SimpleDateFormat da = new SimpleDateFormat("dd-MMM-YYYY");
				value3 = da.format(d);
			}
			else {
				double nc = cell.getNumericCellValue();
				long l =(long)nc;
				value3 = String.valueOf(l);
			}
		}
		return value3;
	}
	public String getvalue(WebElement ele) {
		String txt = ele.getAttribute("value");
		System.out.println(txt);
		return txt;
		
	}
	public void writeexcel(String sheet,int row,int cell,String value) throws IOException {
		File file = new File("C:\\Users\\ADMIN\\eclipse-workspace"
				+ "\\mvn\\TESTDATA\\vj.xlsx");
		FileInputStream stream = new FileInputStream(file);
		Workbook wrbk = new XSSFWorkbook(stream);
		Sheet s = wrbk.getSheet(sheet);
		Row r = s.createRow(row);
		Cell c = r.createCell(cell);
		c.setCellValue(value);
		FileOutputStream stream1 = new FileOutputStream(file);
		wrbk.write(stream1);
	}
	public Actions actionmove(WebElement ele) {
		Actions action = new Actions(driver);
		action.moveToElement(ele).perform();
		return action;
	}
	public Actions actiondrag(WebElement ele,WebElement ele1) {
		Actions action = new Actions(driver);
		return action.dragAndDrop(ele, ele1);
	}
	public Actions actionsContext(WebElement ele) {
		Actions action = new Actions(driver);
		action.contextClick(ele).perform();
		return action;
	}
	public Actions Actiondouble(WebElement ele) {
		Actions action = new Actions(driver);
		action.doubleClick(ele);
		return action;
	}
	public void screenshot(String value) throws IOException {
		TakesScreenshot ts = (TakesScreenshot)driver;
		File sc = ts.getScreenshotAs(OutputType.FILE);
		File file = new File("F:\\"+value+"\\.png");
		FileUtils.copyFile(sc, file);
	}
	public Set<String> singlewindow() {
		String prnt = driver.getWindowHandle();
		Set<String> allwin = driver.getWindowHandles();
		for (String x : allwin) {
			if(!(prnt==x)) {
			  driver.switchTo().window(x);	
		}
}
		return allwin;
}
	public void multipleWindow() {
		String prnt = driver.getWindowHandle();
		Set<String> allwin = driver.getWindowHandles();
		for (String x : allwin) {
			if(!(prnt==x)) {
			  driver.switchTo().window(x);	
		}
}
		driver.switchTo().window(prnt);
		Set<String> all1 = driver.getWindowHandles();
		int count=0;
		for (String x1 : all1) {
			if (count==2) {
				driver.switchTo().window(x1);
			}
			count++;
		}
		}
	
	public WebElement findElementbyxpath(String value) {
		WebElement textbox = driver.findElement(By.xpath(value));
		return textbox;
	}
}
	
	
	
	
	
	
	
	


