package loginPagePojo;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;
import org.utilities.BaseClass;

public class FlipkartLoginPage extends BaseClass{
	public FlipkartLoginPage() {
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath="//input[@class='_2IX_2- VJZDxU']")
	private WebElement usrname;
	
	@FindBy(xpath="//input[@type='password']")
	private WebElement password;
	
	@FindBys({
		@FindBy(xpath="//span[text()='Login']"),
		@FindBy(xpath="//div[@class='_1D1L_j']")
	})
	private WebElement login;

	public WebElement getUsrname() {
		return usrname;
	}

	public WebElement getPassword() {
		return password;
	}

	public WebElement getLogin() {
		return login;
	}
}
