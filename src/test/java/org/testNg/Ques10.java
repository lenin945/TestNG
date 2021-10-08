package org.testNg;

import java.awt.AWTException;
import java.io.IOException;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.utilities.BaseClass;

import loginPagePojo.Demo_QA_POJO;

public class Ques10 extends BaseClass{

	@BeforeClass
	private void browserlaunch() {
		launchChrome();
	}
	@AfterClass
	private void exitbrowser() {
		closeBrowser();
	}
	@BeforeMethod
	private void startTime() {
		printDateAndTime();
	}
	@AfterMethod
	private void endTime() {
		printDateAndTime();
	}
	@Test
	private void tc1() throws Exception {
	
		winMax();
		loadUrl("https://demoqa.com/automation-practice-form");
	}
	@Test(enabled=true)
	private void tc2() throws IOException, InterruptedException, AWTException {
		Demo_QA_POJO d=new Demo_QA_POJO();
		
		insertValues(d.getFirstName(), getExcelData("demoqa_reg", 1	, 0));
		insertValues(d.getLastName(), getExcelData("demoqa_reg", 1, 1));
		insertValues(d.getUserEmail(), getExcelData("demoqa_reg", 1, 2));
		btnClick(d.getMale());
		insertValues(d.getMobNum(), getExcelData("demoqa_reg", 1, 3));
	}
	@Test(enabled=true)
	private void tc3() throws Exception {
		
		Demo_QA_POJO d=new Demo_QA_POJO();
		btnClick(d.getDOB());selectAll();
		insertValues(d.getDOB(), getExcelData("demoqa_reg", 1, 4));	
		enterKey();
		btnClick(d.getCloseAd());
		Thread.sleep(2000);
		insertValues(d.getSubject(), getExcelData("demoqa_reg", 1, 7));
	}
	@Test
	private void tc4() throws Exception {
		Demo_QA_POJO d=new Demo_QA_POJO();
		scrollDown(d.getSubmit());
		btnClick(d.getSportsHobby());
		btnClick(d.getReadingHobby());
		btnClick(d.getMusicHobby());
		insertValues(d.getAddress(), getExcelData("demoqa_reg", 1, 8));
		btnClick(d.getState());
		for (int i = 0; i < 3; i++) {
			downKey();
		}enterKey();
		btnClick(d.getCity());
		downKey();enterKey();
		btnClick(d.getSubmit());
	}
	@Test
	private void tc5() throws IOException {
		Demo_QA_POJO d=new Demo_QA_POJO();
		takeSnap("ques10");
	}
}
