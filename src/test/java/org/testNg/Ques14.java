package org.testNg;

import org.openqa.selenium.By;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.utilities.BaseClass;

import loginPagePojo.Gmail_Login_POJO;

public class Ques14 extends BaseClass{
	
	@BeforeClass
	private void startBrowser() {
		launchChrome();
		winMax();
		
	}
	@AfterClass
	private void endBrowser() {
		//closeBrowser();
	}
	//@Parameters({"username","password"})
	@Test
	private void tc1() throws InterruptedException {
		Gmail_Login_POJO g=new Gmail_Login_POJO();
		loadUrl("https://mail.google.com/");
		
		
		//btnClick(g.getSignIn());
		insertValues(locateWebelement(By.xpath("//input[@type='email']")), "parameter1");
		btnClick(g.getNextButton());
		insertValues(g.getPassword(), "parameter2");
		btnClick(g.getNextButton());
	}
}
