package org.pom;

import java.io.IOException;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebElement;

import mvn.LibGlobal;

public class Launch {
	static LibGlobal l = new LibGlobal();
	@BeforeClass
	public static void beforeclass() {
		l.getdriver("chrome");
		l.geturl("http://adactinhotelapp.com/");
		l.waitsss();
	}
	@AfterClass
	public static void afterclass() {
		l.quit();
	}
	@Test
	public void login() throws IOException {
		Page u = new Page();
		l.inserttextbox(u.getTextuser(),l.getExcel("Sheet2", 0, 0));
		l.inserttextbox(u.getTextpass(), l.getExcel("sheet2", 1, 0));
		l.btnclk(u.getBtnlgn());
	}
	@Test
	public void page2() throws IOException {
		Adacinpage2 u = new Adacinpage2();
		l.select(u.getLocation(), l.getExcel("Sheet2", 2, 0));
		l.select(u.getHotels(), l.getExcel("Sheet2", 3, 0));
		l.select(u.getRoom_type(), l.getExcel("Sheet2", 4, 0));
		l.select(u.getRoom_nos(), l.getExcel("Sheet2", 5, 0));
		l.inserttextbox(u.getDatepick_in(), l.getExcel("Sheet2", 6, 0));
		l.inserttextbox(u.getDatepick_out(),l.getExcel("Sheet2", 7, 0));
		l.select(u.getAdult_room(), l.getExcel("Sheet2", 8, 0));
		l.select(u.getChild_room(), l.getExcel("Sheet2", 9, 0));
		l.btnclk(u.getSubmit());
	}
	@Test
	public void page3() {
		Adacinpage3 u = new Adacinpage3();
		l.btnclk(u.getRadiobutton_0());
		l.btnclk(u.getContin());
	}
	@Test
	public void page4() throws IOException {
		Adacinpage4 u = new Adacinpage4();
		l.inserttextbox(u.getFirst_name(), l.getExcel("Sheet2", 10, 0));
		l.inserttextbox(u.getLast_name(), l.getExcel("Sheet2", 11, 0));
		l.inserttextbox(u.getAddress(), l.getExcel("Sheet2", 12, 0));
		l.inserttextbox(u.getCc_num(), l.getExcel("Sheet2", 13, 0));
		l.select(u.getCc_type(), l.getExcel("Sheet2", 14, 0));
		l.select(u.getCc_exp_month(), l.getExcel("Sheet2", 15, 0));
		l.select(u.getCc_exp_year(), l.getExcel("Sheet2", 16, 0));
		l.inserttextbox(u.getCc_cvv(), l.getExcel("Sheet2", 17, 0));
		l.btnclk(u.getBook_now());
	}
	@Test
	public void page5() throws InterruptedException {
		Adacinpage5 u = new Adacinpage5();
		WebElement no = u.getOrder_no();
		String getvalue = l.getvalue(no);
	}
}
