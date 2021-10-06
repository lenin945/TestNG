package loginPagePojo;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.utilities.BaseClass;

public class Gmail_Login_POJO extends BaseClass{
	
	public Gmail_Login_POJO() {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//a[text()='Sign in']")
	private WebElement signIn;
	
	@FindAll({
	@FindBy(xpath="//div[text()='Email or phone']"),
	@FindBy(xpath="//input[@type='email']")
	})private WebElement username;
	
	@FindBy(xpath="//input[@type='password']")
	private WebElement password;
	
	@FindBy(xpath="//span[text()='Next']")
	private WebElement nextButton;
	
	public WebElement getSignIn() {
		return signIn;
	}

	public WebElement getUsername() {
		return username;
	}

	public WebElement getPassword() {
		return password;
	}

	public WebElement getNextButton() {
		return nextButton;
	}

	
	
}
