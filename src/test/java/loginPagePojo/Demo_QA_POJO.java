package loginPagePojo;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.utilities.BaseClass;

public class Demo_QA_POJO extends BaseClass{

	public Demo_QA_POJO() {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="firstName")
	private WebElement firstName;
	
	@FindBy(id="lastName")
	private WebElement lastName;
	
	@FindBy(id="userEmail")
	private WebElement userEmail;
	
	@FindBy(xpath="//label[text()='Male']")
	private WebElement male;
	
	@FindBy(id="userNumber")
	private WebElement mobNum;
	
	//Date of Birth
	@FindBy(id="dateOfBirthInput")
	private WebElement DOB;
	
	@FindBy(xpath="//select[@class='react-datepicker__year-select']")
	private WebElement year;
	
	@FindBy(xpath="//select[@class='react-datepicker__month-select']")
	private WebElement month;
	
	@FindBy(xpath="//div[@class='react-datepicker__day react-datepicker__day--010']")
	private WebElement day;
	
	@CacheLookup
	@FindAll({
	@FindBy(id="subjectsContainer"),
	@FindBy(className=" css-2b097c-container"),
	@FindBy(className="subjects-auto-complete__control css-yk16xz-control")
	})
	private WebElement subject;
	
	@FindBy(xpath="//label[text()='Sports']")
	private WebElement sportsHobby;
	
	@FindBy(xpath="//label[text()='Reading']")
	private WebElement readingHobby;
	
	@FindBy(xpath="//label[text()='Music']")
	private WebElement musicHobby;
	
	@FindBy(xpath="//textarea[@id='currentAddress']")
	private WebElement address;
	
	@FindBy(xpath="//div[text()='Select State']")
	private WebElement state;
	
	@FindBy(xpath="//div[text()='Select City']")
	private WebElement city;
	
	@FindBy(id="submit")
	private WebElement submit;
	
	@FindBy(tagName="iframe")
	private WebElement givenDetails;
	
	@FindBy(xpath="//a[@id='close-fixedban']")
	private WebElement closeAd;

	public WebElement getYear() {
		return year;
	}

	public WebElement getMonth() {
		return month;
	}

	public WebElement getDay() {
		return day;
	}

	public WebElement getGivenDetails() {
		return givenDetails;
	}

	public WebElement getCloseAd() {
		return closeAd;
	}

	public WebElement getFirstName() {
		return firstName;
	}

	public WebElement getLastName() {
		return lastName;
	}

	public WebElement getUserEmail() {
		return userEmail;
	}

	public WebElement getMale() {
		return male;
	}

	public WebElement getMobNum() {
		return mobNum;
	}

	public WebElement getDOB() {
		return DOB;
	}

	public WebElement getSubject() {
		return subject;
	}

	public WebElement getSportsHobby() {
		return sportsHobby;
	}

	public WebElement getReadingHobby() {
		return readingHobby;
	}

	public WebElement getMusicHobby() {
		return musicHobby;
	}

	public WebElement getAddress() {
		return address;
	}

	public WebElement getState() {
		return state;
	}

	public WebElement getCity() {
		return city;
	}

	public WebElement getSubmit() {
		return submit;
	}
}
