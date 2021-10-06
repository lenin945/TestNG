package org.testNg;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.utilities.BaseClass;

import loginPagePojo.Redbus_LoginPage;

public class Ques2 extends BaseClass {
	@BeforeClass
	public static void launchBrowser() {
		System.out.println("Start");
		launchChrome();
		winMax();
	} 

	@AfterClass
	public static void quitBrowser() {
		System.out.println("Close");
		closeBrowser();
	}

	@BeforeMethod
	public void startTime() {
		System.out.println("\n");
		printDateAndTime();
	}

	@AfterMethod
	public void endTime() {
		printDateAndTime();
		System.out.println("\n");
	}

	@Test(invocationCount=2)
	public void tc1() throws InterruptedException {
		
		
		loadUrl("https://www.redbus.in/");
		winMax();
	
		Redbus_LoginPage r = new Redbus_LoginPage();
		btnClick(r.getSinginBtn());
		btnClick(r.getSignInLink());
		switchToFrame(r.getSignInFrame());
		waitsec(5);
		btnClick(r.getSignInFb());
		waitsec(5);
		switchWindow(1);
		insertValues(r.getFbUsr(), "ganapathyraja945@gmail.com");
		insertValues(r.getFbPass(), "Pgr.pgr@1");
		btnClick(r.getFbLogin());
	
		List<WebElement> frame = driver.findElements(By.tagName("iframe"));
		switchWindow(0);
		waitsec(5);
		//Redbus_LoginPage r = new Redbus_LoginPage();
		System.out.println(frame.size());
		if (frame.size()>0) {
			System.out.println("Login Failed");
		}else {
			System.out.println("Login Successful");
		}
		deleteCookies();driver.navigate().refresh();
	}
	
}
