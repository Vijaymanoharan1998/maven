package mvn;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class amazon {
	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.amazon.in/");
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		WebElement srch = driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']"));
		srch.sendKeys("iphone13",Keys.ENTER);
        WebElement fnd = driver.findElement(By.id("a-autoid-0-announce"));	   
        fnd.click();
        WebElement fnd1 = driver.findElement(By.id("s-result-sort-select_1"));	   
        fnd1.click();
        List<WebElement> price = driver.findElements(By.xpath("//span[@class='a-price-whole']"));
        System.out.println(price);
        List<String> a = new ArrayList<String>();
        for (int i = 0; i < price.size(); i++) {
        	System.out.println(price.get(i).getText());
        	a.add(price.get(i).getText());
		}
        Collections.sort(a);
        System.out.println(a);
        Set<String> set =new TreeSet<String>();
        boolean addAll = set.addAll(a);
        System.out.println(set);
        
		}
	 
	}    
	


