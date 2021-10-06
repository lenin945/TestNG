package loginPagePojo;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.utilities.BaseClass;

public class Redbus_LoginPage extends BaseClass {
	public Redbus_LoginPage() {
		PageFactory.initElements(driver, this);
	}

	@CacheLookup
	@FindBy(id = "i-icon-profile")
	private WebElement singinBtn;
	
	@CacheLookup
	@FindBy(id="signInLink")
	private WebElement signInLink;
	
	@CacheLookup
	@FindAll({
	@FindBy(xpath="//iframe[@src='/login?offerType=PaymentOffers&defaultSlide=home&isOnlyMobile=false']"),	
	@FindBy(xpath="//iframe[@class='modalIframe']")
	})
	private WebElement signInFrame;
	
	@CacheLookup
	@FindBy(id="mobileNoInp")
	private WebElement mobNo;
	
	@CacheLookup
	@FindBy(xpath="//div[text()='Facebook']")
	private WebElement signInFb;
	
	@CacheLookup
	@FindBy(id="signOutLink")
	private WebElement signoutLink;
	
	@FindBy(id="email")
	private WebElement fbUsr;
	
	@FindBy(id="pass")
	private WebElement fbPass;
	
	@FindBy(name="login")
	private WebElement fbLogin;
	

	public WebElement getSignoutLink() {
		return signoutLink;
	}

	public WebElement getSinginBtn() {
		return singinBtn;
	}

	public WebElement getSignInLink() {
		return signInLink;
	}

	
	public WebElement getSignInFrame() {
		return signInFrame;
	}

	public WebElement getMobNo() {
		return mobNo;
	}

	public WebElement getSignInFb() {
		return signInFb;
	}

	public WebElement getFbUsr() {
		return fbUsr;
	}

	public WebElement getFbPass() {
		return fbPass;
	}

	public WebElement getFbLogin() {
		return fbLogin;
	}
	
}
