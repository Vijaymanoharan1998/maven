package org.pom;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import mvn.LibGlobal;

public class Adacinpage5 extends LibGlobal {
	public Adacinpage5() {
		PageFactory.initElements(driver, this);
	}
	@FindBy(id="order_no")
	private WebElement order_no;

	public WebElement getOrder_no() {
		return order_no;
	}

}
