package org.testNg;

import org.utilities.BaseClass;

public class sample extends BaseClass {
public static void main(String[] args) {
	launchEdge();
	loadUrl("https://demoqa.com/automation-practice-form");
	closeBrowser();
	
	launchFirefox();
	loadUrl("https://demoqa.com/automation-practice-form");
	closeBrowser();
	
	launchChrome();
	loadUrl("https://demoqa.com/automation-practice-form");
	closeBrowser();
}
}
