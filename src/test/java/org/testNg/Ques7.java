package org.testNg;

import java.io.IOException;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.utilities.BaseClass;

import loginPagePojo.FlipkartLoginPage;


public class Ques7 extends BaseClass {
	
	@Parameters({"browser"})
	@Test
	private void flipkart_login(String browserName) throws IOException, InterruptedException {
		
		if (browserName.equals("chrome")) {
			launchChrome();
		}else if (browserName.equals("ff")) {
			launchFirefox();
		}else {
			launchEdge();
		}
		
		loadUrl("https://www.flipkart.com/account/login");
		String loginPageTitle = pageTitle();
		FlipkartLoginPage f=new FlipkartLoginPage();
		
		insertValues(f.getUsrname(), getExcelData("flipkart_det", 1, 0));
		insertValues(f.getPassword(), getExcelData("flipkart_det", 1, 1));
		btnClick(f.getLogin());
		//waitsec(30);//doubt
		Thread.sleep(1000);
		String homePageTitle = pageTitle();
		if (!loginPageTitle.equals(homePageTitle)) {
			System.out.println("Login Successful"+"\n"+"The entered credentials are correct!");
		}else {
			System.out.println("Login Unsuccessful"+"\n"+"The entered credentials are not correct!Pls Check");
		}
		closeBrowser();
	}
}
