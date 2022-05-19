package org.junit;

import java.util.Date;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import mvn.LibGlobal;

public class Junit {
	static LibGlobal l = new LibGlobal();
	@BeforeClass
	public static void beforeclass() {
		l.getdriver("chrome");
		WebDriver driver = new ChromeDriver();
		l.geturl("https://www.facebook.com/");
	}
	@AfterClass
	public static void afterclass() {
		l.quit();
	}
	@Before
	public void before() {
		Date d = new Date();
		System.out.println("start at"+d);
	}
	@After
	public void after() {
		Date d = new Date();
		System.out.println("end at"+d);
	}
	@Test
	public void txtemail() {
		WebElement txtuser = l.findElementByid("email");
		l.inserttextbox(txtuser, "vijay@123");
	}
	@Test
	public void txtpass() {
		WebElement txtpass = l.findElementByid("pass");
		l.inserttextbox(txtpass, "12345678");
	}
}
