package org.testNg;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.utilities.BaseClass;

import loginPagePojo.FacebookLoginPage;

public class Ques11 extends BaseClass {
	
	@BeforeClass(alwaysRun=true)
	private void browserlaunch() {
		launchChrome();
		winMax();
	}

	@BeforeMethod(alwaysRun=true)
	private void startTime() {
		System.out.println("\n");
		printDateAndTime();
	}

	@AfterMethod(alwaysRun=true)
	private void endTime() {
		printDateAndTime();
		System.out.println("\n");
	}

	@AfterClass(alwaysRun=true)
	private void quitBrowser() {
		closeBrowser();
	}
	//Invalid Username and Password
	@Test(groups= {"orange,apple"})
	private void tc1() {
		String homePageTitle = "Facebook";

		FacebookLoginPage f = new FacebookLoginPage();

		loadUrl("https://en-gb.facebook.com/");
		insertValues(f.getUsrname(), "hjhvhgchg");
		insertValues(f.getPasswd(), "09876hgg");
		btnClick(f.getLogin());
		waitsec(5);
		pageTitle();
		System.out.println("Invalid Username and Password");
		if (pageTitle().equals(homePageTitle)) {
			System.out.println("Login Successful-Entered credentials are correct!");
		} else {
			System.out.println("Login Unsuccessful");
			printText(f.getErrormsg());
		}
	}
	//Invalid Username and Valid Password
	@Test(groups= {"apple","grapes"})
	private void tc2() {
		String homePageTitle = "Facebook";

		FacebookLoginPage f = new FacebookLoginPage();

		loadUrl("https://en-gb.facebook.com/");
		insertValues(f.getUsrname(), "ganpthy@gmail.com");
		insertValues(f.getPasswd(), "Pgr.pgr@1");
		btnClick(f.getLogin());
		waitsec(5);
		pageTitle();
		
		System.out.println("Invalid Username and Valid Password");
		if (pageTitle().equals(homePageTitle)) {
			System.out.println("Login Successful-Entered credentials are correct!");
		} else {
			System.out.println("Login Unsuccessful");
			printText(f.getErrormsg());
		}deleteCookies();
	}
	
	//Valid Username and Invalid Password
	@Test(groups= {"grapes"})
	private void tc3() {
		System.out.println("Test case AND operator");
		String homePageTitle = "Facebook";

		FacebookLoginPage f = new FacebookLoginPage();

		loadUrl("https://en-gb.facebook.com/");
		insertValues(f.getUsrname(), "ganapathyraja945@gmail.com");
		insertValues(f.getPasswd(), "123456");
		btnClick(f.getLogin());
		waitsec(5);
		pageTitle();
		
		System.out.println("Valid Username and Invalid Password");
		if (pageTitle().equals(homePageTitle)) {
			System.out.println("Login Successful-Entered credentials are correct!");
		} else {
			System.out.println("Login Unsuccessful");
			printText(f.getErrormsg());
		}deleteCookies();
	}
	
	//Valid Username and Valid Password
	@Test(groups="apple")
	private void tc4() {
		String homePageTitle = "Facebook";

		FacebookLoginPage f = new FacebookLoginPage();

		loadUrl("https://en-gb.facebook.com/");
		insertValues(f.getUsrname(), "Greens");
		insertValues(f.getPasswd(), "123456");
		btnClick(f.getLogin());
		waitsec(5);
		pageTitle();
		
		System.out.println("Valid Username and Invalid Password");
		if (pageTitle().equals(homePageTitle)) {
			System.out.println("Login Successful-Entered credentials are correct!");
		} else {
			System.out.println("Login Unsuccessful");
			printText(f.getErrormsg());
		}deleteCookies();
	}
}
