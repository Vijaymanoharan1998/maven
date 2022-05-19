package org.testng;

import java.util.Date;

import org.openqa.selenium.WebDriver;
import org.pom.Adacinpage2;
import org.pom.Page;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;


import mvn.LibGlobal;

public class vijay {
	LibGlobal l = new LibGlobal();
	public static WebDriver driver;
	@BeforeClass(groups="kumar")
	private void beforeclass() {
		l.getdriver("chrome");
		l.geturl("http://adactinhotelapp.com/index.php");
		l.waitsss();
	}
//	@AfterClass
//	private void afterclass() {
//		l.quit();
//	}
	@BeforeMethod
	private void beforemethod() {
		Date d = new Date();
		System.out.println("Start time is:"+d);
	}
	@AfterMethod
	private void aftermethod() {
		Date d= new Date();
		System.out.println("End time is"+d);
	}
	@Parameters({"username","password"})
	@Test(priority=-5,groups="kumar",dataProvider="login")
	private void login(String user,String pass) {
		Page u= new Page();
		l.inserttextbox(u.getTextuser(), user);
		l.inserttextbox(u.getTextpass(), pass);
		l.btnclk(u.getBtnlgn());
	}
	@Parameters({"location","hotel","roomtype","number","checkin","checkout","adult","children"})
	@Test(priority=-4,groups="kumar",retryAnalyzer=Manualrerun.class)
	public void page2(@Optional("London")String location, @Optional("Hotel Hervey")String hotel,String Roomtype,String number,String checkin,String checkout,String adult,String children) {
		Adacinpage2 u = new Adacinpage2();
		l.select(u.getLocation(), location);
		l.select(u.getHotels(), hotel);
		l.select(u.getRoom_type(), Roomtype);
		l.select(u.getRoom_nos(), number);
		l.inserttextbox(u.getDatepick_in(), checkin);
		l.inserttextbox(u.getDatepick_out(), checkout);
		l.select(u.getAdult_room(), adult);
		l.select(u.getChild_room(), children);
		l.btnclk(u.getSubmit());
	}
	@DataProvider(name ="login")
	public Object[][] data() {
     return new Object[][] {
    	 {"vijay","123456"},
    	 {"vijayvijay","2564895"},
    	 {"vijayram000","123456789"}
     };
     }
	}
