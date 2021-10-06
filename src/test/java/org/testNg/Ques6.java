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
		takeSnap(locateWebelement(By.id("head-wrapper")), "GT_paralle_exec");
		closeBrowser();
	}
}
