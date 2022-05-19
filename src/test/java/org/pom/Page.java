package org.pom;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import mvn.LibGlobal;

public class Page extends LibGlobal {
	public Page() {
		PageFactory.initElements(driver, this);
	}
	@FindBy(id="username")
	private WebElement textuser;
	@FindBy(id="password")
	private WebElement textpass;
	@FindBy(id="login")
	private WebElement btnlgn;
	public WebElement getTextuser() {
		return textuser;
	}
	public WebElement getTextpass() {
		return textpass;
	}
	public WebElement getBtnlgn() {
		return btnlgn;
	}
	

}
