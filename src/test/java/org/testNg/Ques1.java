package org.testNg;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import org.utilities.BaseClass;

import loginPagePojo.FacebookLoginPage;

public class Ques1 extends BaseClass {

	@BeforeClass
	private void browserlaunch() {
		launchChrome();
		winMax();
	}

	@BeforeMethod
	private void startTime() {
		System.out.println("\n");
		printDateAndTime();
	}

	@AfterMethod
	private void endTime() {
		printDateAndTime();
		System.out.println("\n");
	}

	@AfterClass
	private void quitBrowser() {
		closeBrowser();
	}
	//Invalid Username and Password
	@Test(priority=4, enabled=false)
	private void tc1() {
		String homePageTitle = "Facebook";

		FacebookLoginPage f = new FacebookLoginPage();
		loadUrl("https://en-gb.facebook.com/");
		Assert.assertTrue(pageTitle().contains("Facebook "), "Please check the url");
		
		insertValues(f.getUsrname(), "hjhvhgchg");
		insertValues(f.getPasswd(), "09876hgg");
		btnClick(f.getLogin());
		waitsec(5);
		pageTitle();
		System.out.println("Condition: Invalid Username and Password");
		if (pageTitle().equals(homePageTitle)) {
			System.out.println("Msg: Login Successful-Entered credentials are correct!");
		} else {
			System.out.println("Msg: Login Unsuccessful");
			printText(f.getErrormsg());
		}
	}
	//Invalid Username and Valid Password
	@Test(priority=3,enabled=false)
	private void tc2() {
		String homePageTitle = "Facebook";

		FacebookLoginPage f = new FacebookLoginPage();

		loadUrl("https://en-gb.facebook.com/");

		SoftAssert s=new SoftAssert();
		s.assertTrue(pageTitle().contains("Facebook "), "Please check the url");
		
		insertValues(f.getUsrname(), "ganpthy@gmail.com");
		insertValues(f.getPasswd(), "Pgr.pgr@1");
		btnClick(f.getLogin());
		waitsec(5);
		pageTitle();
		
		System.out.println("Condition: Invalid Username and Valid Password");
		if (pageTitle().equals(homePageTitle)) {
			System.out.println("Msg: Login Successful-Entered credentials are correct!");
		} else {
			System.out.println("Msg: Login Unsuccessful");
			printText(f.getErrormsg());
		}
		//Assertall_SoftAssert
		s.assertAll();
		deleteCookies();
	}
	
	//Valid Username and Invalid Password
	@Test(priority=2,enabled=false)
	private void tc3() {
		String homePageTitle = "Facebook";

		FacebookLoginPage f = new FacebookLoginPage();

		loadUrl("https://en-gb.facebook.com/");
		insertValues(f.getUsrname(), "ganapathyraja945@gmail.com");
		insertValues(f.getPasswd(), "123456");
		btnClick(f.getLogin());
		waitsec(5);
		pageTitle();
		
		System.out.println("Condition: Valid Username and Invalid Password");
		if (pageTitle().equals(homePageTitle)) {
			System.out.println("Msg: Login Successful-Entered credentials are correct!");
		} else {
			System.out.println("Msg: Login Unsuccessful");
			printText(f.getErrormsg());
		}deleteCookies();
	}
	
	//Valid Username and Valid Password
	@Test(priority=1,invocationCount=3)
	private void tc4() {
		String homePageTitle = "Facebook";

		FacebookLoginPage f = new FacebookLoginPage();

		loadUrl("https://en-gb.facebook.com/");
		insertValues(f.getUsrname(), "ganapathyraja945@gmail.com");
		insertValues(f.getPasswd(), "Pgr.pgr@1");
		btnClick(f.getLogin());
		waitsec(5);
		pageTitle();
		
		System.out.println("Condition: Valid Username and Valid Password");
		if (pageTitle().equals(homePageTitle)) {
			System.out.println("Msg: Login Successful-Entered credentials are correct!");
		} else {
			System.out.println("Msg: Login Unsuccessful");
			printText(f.getErrormsg());
		}deleteCookies();
	}
}
