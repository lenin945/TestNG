package org.adactinPOJO;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.utilities.BaseClass;

public class LoginPage extends BaseClass{

	public LoginPage() {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="username")
	private WebElement usrnme;
	
	@FindBy(id="password")
	private WebElement passwd;
	
	@FindBy(id="login")
	private WebElement loginbtn;

	public WebElement getUsrnme() {
		return usrnme;
	}

	public WebElement getPasswd() {
		return passwd;
	}

	public WebElement getLoginbtn() {
		return loginbtn;
	}
}
