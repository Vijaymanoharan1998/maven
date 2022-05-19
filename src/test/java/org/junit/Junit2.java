package org.junit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import mvn.LibGlobal;

public class Junit2 {
	static LibGlobal l = new LibGlobal();
	@BeforeClass
	public static void beforeclass() {
		l.getdriver("chrome");
		l.geturl("https://www.facebook.com/");
	}
	@AfterClass
	public static void afterclass() {
		l.quit();
	}
	@Test
	public void user() {
		WebElement txtuser = l.findElementByid("email");
		l.inserttextbox(txtuser, "vijay");
		String get = l.getvalue(txtuser);
		boolean c = get.contains("vijay");
		Assert.assertTrue(c);
	}
	@Test
	public void txtpass() {
		WebElement pass = l.findElementByid("pass");
		l.inserttextbox(pass, "123456789");
		String att = pass.getAttribute("value");
		Assert.assertEquals("verify", "123456789", att);
	}
	
	
	

}
