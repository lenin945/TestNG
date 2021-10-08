package org.parallel_exec;

import java.io.IOException;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.utilities.BaseClass;

import loginPagePojo.FacebookLoginPage;

public class Test_level extends BaseClass {
	@Parameters({"usr","pass"})
	@Test()
	private void login(String s1,String s2) throws IOException {
		launchChrome();
		winMax();
		String homePageTitle = "Facebook";
		FacebookLoginPage f = new FacebookLoginPage();
		loadUrl("https://en-gb.facebook.com/");
		insertValues(f.getUsrname(), s1);
		insertValues(f.getPasswd(), s2);
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
		takeSnap("fbtc1"); 
		closeBrowser();
	}
}
