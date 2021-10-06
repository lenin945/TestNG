package org.data_provider;

import java.awt.AWTException;
import java.io.IOException;
import org.adactinPOJO.BookHotelPage;
import org.adactinPOJO.LoginPage;
import org.adactinPOJO.SearchHotelPage;
import org.adactinPOJO.SelectHotelPage;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.utilities.BaseClass;

public class Adactin_Dp extends BaseClass{
	@BeforeClass
	public static void launchBrowser() {
		launchChrome();
		winMax();
		deleteCookies();
	}
	@AfterClass
	public static void quitBrowser() {
		closeBrowser();
	}
	@BeforeMethod
	public void startTime() {
		printDateAndTime();
	}
	@AfterClass
	public void endTime() {
		printDateAndTime();
	}
	@Test(dataProvider="logindata",dataProviderClass=Dataprovider_Class_adactin.class)
	public void tc1(String usr,String pass) throws IOException {
		loadUrl("http://www.adactin.com/HotelApp");
		LoginPage l=new LoginPage();
		insertValues(l.getUsrnme(), usr);
		insertValues(l.getPasswd(), pass);
		btnClick(l.getLoginbtn());
		waitsec(2);
	}
	@Test(dataProvider="searchHotel",dataProviderClass=Dataprovider_Class_adactin.class)
	public void tc2(String location,String Hotel,String roomType,
			String roomNos,String chkin,String chkout,String adultRm,String childRm) throws IOException, AWTException, InterruptedException {
		SearchHotelPage s=new SearchHotelPage();
		selectValue(s.getLoc(), location);
		selectValue(s.getHotel(), Hotel);
		selectValue(s.getRoomtype(), roomType);
		selectValue(s.getRoomnos(), roomNos);
		clearText(s.getChkin());

		insertValues(s.getChkin(), chkin);
		clearText(s.getChkout());
		insertValues(s.getChkout(), chkout);
		
		selectValue(s.getAdultrm(), adultRm);
		selectValue(s.getChildrm(), childRm);
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
	@Test(dataProvider="bookhotel",dataProviderClass=Dataprovider_Class_adactin.class)
	public void tc4(String fname,String lname,String add,String ccnum,
			String cardType,String expMonth,String expYear,String cvv) throws IOException, InterruptedException {
		BookHotelPage b=new BookHotelPage();
		insertValues(b.getFirstnm(), fname);
		insertValues(b.getLastnm(), lname);
		insertValues(b.getAddress(), add);
		insertValues(b.getCc_num(), ccnum);
		selectVisbleText(b.getCc_type(), cardType);
		selectVisbleText(b.getCc_exp_month(), expMonth);
		selectVisbleText(b.getCc_exp_year(), expYear);
		insertValues(b.getCc_cvv(), cvv);
		btnClick(b.getBook_now());
		//waitsec(2)
		Thread.sleep(4000);
	}
	@Test
	public void tc5() {
		BookHotelPage b=new BookHotelPage();
		System.out.print("Order No: ");
		printAttribute(b.getOrder_no(), "value");
	}

}
