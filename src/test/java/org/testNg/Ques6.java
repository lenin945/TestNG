package org.testNg;

import java.io.IOException;

import org.openqa.selenium.By;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.utilities.BaseClass;

public class Ques6 extends BaseClass{
	@Parameters({"browser"})
	@Test
	private void tc(String browserName) throws IOException {
		if(browserName.equals("ff")) {
			launchFirefox();
		}else if (browserName.equals("chrome")) {
			launchChrome();
		}else {
			launchEdge();
		}
		winMax();
		loadUrl("http://www.greenstechnologys.com/");
		System.out.println(browserName+"--->"+pageTitle());
		if(browserName.equals("ff")) {
			takeSnap("GT_paralle_exec1");
		}else if (browserName.equals("chrome")) {
			takeSnap("GT_paralle_exec");
		}else {
			takeSnap("GT_paralle_exec2");
		}
		closeBrowser();
	}
}
