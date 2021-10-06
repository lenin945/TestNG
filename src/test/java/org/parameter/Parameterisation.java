package org.parameter;

import java.awt.AWTException;
import java.io.IOException;

import org.adactinPOJO.BookHotelPage;
import org.adactinPOJO.LoginPage;
import org.adactinPOJO.SearchHotelPage;
import org.adactinPOJO.SelectHotelPage;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.utilities.BaseClass;

public class Parameterisation extends BaseClass {
	@BeforeClass
	private void browserLaunch() {
		launchChrome();
		winMax();
	}
	@AfterClass
	private void quitBrowser() {
		closeBrowser();
	}
	@BeforeMethod
	private void startTime() {
		printDateAndTime();
	}
	@AfterMethod
	private void endTime() {
		printDateAndTime();
	}
	
	@Parameters({"username","password"})
	@Test
	public void tc1(String name, String pass) throws IOException {
		loadUrl("http://www.adactin.com/HotelApp");
		LoginPage l=new LoginPage();
		insertValues(l.getUsrnme(), name);
		insertValues(l.getPasswd(), pass);
		btnClick(l.getLoginbtn());
		waitsec(2);
	}
	@Parameters({"chkin","chkout"})
	@Test
	public void tc2(@Optional("20/10/2021")String checkin, @Optional("22/10/2021")String checkout) throws IOException, AWTException, InterruptedException {
		SearchHotelPage s=new SearchHotelPage();
		selectValue(s.getLoc(), getExcelData("adactin_login_details", 1, 2));
		selectValue(s.getHotel(), getExcelData("adactin_login_details", 1, 3));
		selectValue(s.getRoomtype(), getExcelData("adactin_login_details", 1, 4));
		selectValue(s.getRoomnos(), getExcelData("adactin_login_details", 1, 5));
		
//		btnClick(s.getChkin());selectAll();deleteKey();
//		jsInsertvalue(s.getChkin(), checkin);
//		
//		btnClick(s.getChkin());selectAll();deleteKey();
//		jsInsertvalue(s.getChkout(), checkout);
		
		selectValue(s.getAdultrm(), getExcelData("adactin_login_details", 1, 8));
		selectValue(s.getChildrm(), getExcelData("adactin_login_details", 1, 9));
		btnClick(s.getSubmitBtn());
		waitsec(2);
	}
	@Test
	public void tc3() {
		SelectHotelPage sl=new SelectHotelPage();
		btnClick(sl.getSelectHotel());
		btnClick(sl.getCont());
		waitsec(2);
	}
	@Test
	public void tc4() throws IOException, InterruptedException {
		BookHotelPage b=new BookHotelPage();
		insertValues(b.getFirstnm(), getExcelData("adactin_login_details", 1, 10));
		insertValues(b.getLastnm(), getExcelData("adactin_login_details", 1, 11));
		insertValues(b.getAddress(), getExcelData("adactin_login_details", 1, 12));
		insertValues(b.getCc_num(), getExcelData("adactin_login_details", 1, 13));
		selectVisbleText(b.getCc_type(), getExcelData("adactin_login_details", 1, 14));
		selectVisbleText(b.getCc_exp_month(), getExcelData("adactin_login_details", 1, 15));
		selectVisbleText(b.getCc_exp_year(), getExcelData("adactin_login_details", 1, 16));
		insertValues(b.getCc_cvv(), getExcelData("adactin_login_details", 1, 17));
		btnClick(b.getBook_now());
		//waitsec(2)
		Thread.sleep(4000);
	}
	@Test
	public void tc5() throws IOException, InterruptedException {
		BookHotelPage b=new BookHotelPage();
		Thread.sleep(2000);
		scrollDown(b.getOrder_no());
		takeSnap(b.getOrder_no(), "adactin_orderNo");
		System.out.print("Order No: ");
		printAttribute(b.getOrder_no(), "value");
		
	}
}
