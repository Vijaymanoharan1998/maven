package org.pom;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import mvn.LibGlobal;

public class Adacinpage3 extends LibGlobal {
	public Adacinpage3() {
		PageFactory.initElements(driver, this);
	}
	@FindBy(id="radiobutton_0")
	private WebElement radiobutton_0;
	@FindBy(id="continue")
	private WebElement contin;
	public WebElement getRadiobutton_0() {
		return radiobutton_0;
	}
	public WebElement getContin() {
		return contin;
	} ;
}
