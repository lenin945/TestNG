package loginPagePojo;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.utilities.BaseClass;

public class FacebookLoginPage extends BaseClass{
	
	public FacebookLoginPage() {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="email")
	private WebElement usrname;
	
	@FindBy(id="pass")
	private WebElement passwd;
	
	@FindBy(name="login")
	private WebElement login;
	
	@FindBy(xpath="//div[@class='_9ay7']")
	private WebElement errormsg;

	public WebElement getErrormsg() {
		return errormsg;
	}

	public WebElement getUsrname() {
		return usrname;
	}

	public WebElement getPasswd() {
		return passwd;
	}

	public WebElement getLogin() {
		return login;
	}

}
