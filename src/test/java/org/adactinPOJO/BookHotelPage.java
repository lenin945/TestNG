package org.adactinPOJO;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.utilities.BaseClass;

public class BookHotelPage extends BaseClass{
	
	public BookHotelPage() {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(name="first_name")
	private WebElement firstnm;
	@FindBy(name="last_name")
	private WebElement lastnm;
	@FindBy(name="address")
	private WebElement address;
	@FindBy(name="cc_num")
	private WebElement cc_num;
	@FindBy(name="cc_type")
	private WebElement cc_type;
	@FindBy(name="cc_exp_month")
	private WebElement cc_exp_month;
	@FindBy(name="cc_exp_year")
	private WebElement cc_exp_year;
	@FindBy(name="cc_cvv")
	private WebElement cc_cvv;
	@FindBy(id="book_now")
	private WebElement book_now;
	
	@CacheLookup
	@FindAll({
		@FindBy(name="order_no"),
		@FindBy(id="order_no")
	})
	private WebElement order_no;
	
	
	@FindBy(name="logout")
	private WebElement logoutbtn;
	
	public WebElement getLogoutbtn() {
		return logoutbtn;
	}

	public WebElement getFirstnm() {
		return firstnm;
	}

	public WebElement getLastnm() {
		return lastnm;
	}

	public WebElement getAddress() {
		return address;
	}

	public WebElement getCc_num() {
		return cc_num;
	}

	public WebElement getCc_type() {
		return cc_type;
	}

	public WebElement getCc_exp_month() {
		return cc_exp_month;
	}

	public WebElement getCc_exp_year() {
		return cc_exp_year;
	}

	public WebElement getCc_cvv() {
		return cc_cvv;
	}

	public WebElement getBook_now() {
		return book_now;
	}

	public WebElement getOrder_no() {
		return order_no;
	}
}
