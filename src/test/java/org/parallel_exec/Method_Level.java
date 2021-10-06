package org.parallel_exec;

import java.io.IOException;
import org.testng.annotations.Test;
import org.utilities.BaseClass;
import loginPagePojo.FacebookLoginPage;

public class Method_Level  extends BaseClass {
	//Invalid Username and Password
		@Test()
		private void tc1() throws IOException {
			launchChrome();
			winMax();
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
			takeSnap(f.getErrormsg(), "fbtc1"); 
			closeBrowser();
		}
		//Invalid Username and Valid Password
		@Test()
		private void tc2() throws IOException {
			launchChrome();
			winMax();
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
			}takeSnap(f.getErrormsg(), "fbtc2");
			deleteCookies(); closeBrowser();
		}
		
		//Valid Username and Invalid Password
		@Test()
		private void tc3() throws IOException {
			launchChrome();
			winMax();
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
			}takeSnap(f.getErrormsg(), "fbtc3");
			deleteCookies(); closeBrowser();
		}
		
		//Valid Username and Valid Password
		@Test()
		private void tc4() throws IOException {
			launchChrome();
			winMax();
			String homePageTitle = "Facebook";
			FacebookLoginPage f = new FacebookLoginPage();
			loadUrl("https://en-gb.facebook.com/");
			insertValues(f.getUsrname(), "ganapathyraja945@gmail.com");
			insertValues(f.getPasswd(), "Pgr.pgr@1");
			btnClick(f.getLogin());
			waitsec(5);
			pageTitle();
			System.out.println("Valid Username and Valid Password");
			if (pageTitle().equals(homePageTitle)) {
				System.out.println("Login Successful-Entered credentials are correct!");
			} else {
				System.out.println("Login Unsuccessful");
				printText(f.getErrormsg());
			}
			takeSnap(f.getErrormsg(), "fbtc4");
			deleteCookies(); 
			closeBrowser();
		}
	
}


