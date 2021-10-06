package org.testNg;

import org.testng.annotations.Test;
import org.utilities.BaseClass;

public class Ques8 extends BaseClass{

	@Test
	private void tc() {
		launchChrome();
		winMax();
		loadUrl("http://www.greenstechnologys.com/");
	}
}
