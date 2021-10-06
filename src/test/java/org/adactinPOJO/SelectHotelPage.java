package org.adactinPOJO;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.utilities.BaseClass;

public class SelectHotelPage extends BaseClass {
	public SelectHotelPage() {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="radiobutton_0")
	private WebElement selectHotel;
	
	@FindBy(id="continue")
	private WebElement cont;

	public WebElement getSelectHotel() {
		return selectHotel;
	}

	public WebElement getCont() {
		return cont;
	}
	
}
