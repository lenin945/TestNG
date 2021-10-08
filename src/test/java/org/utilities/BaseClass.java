package org.utilities;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	public static WebDriver driver;
	static Actions a;
	static Robot r;
	static JavascriptExecutor js;
	static Alert al;
	static Select s;
	public static void launchChrome() {
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
	}
	public static void launchFirefox() {
		WebDriverManager.firefoxdriver().setup();
		driver=new FirefoxDriver();
	}
	public static void launchEdge() {
		WebDriverManager.edgedriver().setup();
		driver=new EdgeDriver();
	}
	public static void winMax() {
		driver.manage().window().maximize();
	}
	public static void loadUrl(String url) {
		driver.get(url);
	}
	public static String pageTitle() {
		String title = driver.getTitle();
		//System.out.println(title);
		return title;
	}
	public static void pageUrl() {
		System.out.println(driver.getCurrentUrl());
	}
	public static WebElement locateWebelement(By locator) {
		return driver.findElement(locator);
	}
	public static void insertValues(WebElement ref, String input) {
		ref.sendKeys(input);
	}
	public static void btnClick(WebElement ref) {
		ref.click();
	}
	public static void closeBrowser() {
		driver.quit();
	}
	public static void closeCurrentTab() {
		driver.close();
	}
	public static void printText(WebElement ref) {
		System.out.println(ref.getText());
	}
	public static void printAttribute(WebElement ref, String value) {
		System.out.println(ref.getAttribute(value));
	}
	
	
	//Action Class
	public static void mouseOver(WebElement ref) {
		a=new Actions(driver);
		a.moveToElement(ref).perform();
	}
	public static void dragDrop(WebElement src, WebElement tar) {
		a=new Actions(driver);
		a.dragAndDrop(src, tar).perform();
	}
	public static void leftclick(WebElement ref) {
		a=new Actions(driver);
		a.doubleClick(ref).perform();
	}
	public static void rightClick(WebElement ref) {
		a=new Actions(driver);
		a.contextClick(ref).perform();
	}
	
	//robot
	public static void selectAll() throws AWTException {
		r=new Robot();
		r.keyPress(KeyEvent.VK_CONTROL);
		r.keyPress(KeyEvent.VK_A);
		r.keyRelease(KeyEvent.VK_CONTROL);
		r.keyRelease(KeyEvent.VK_A);
	}
	public static void copyKey() throws AWTException {
		r=new Robot();
		r.keyPress(KeyEvent.VK_CONTROL);
		r.keyPress(KeyEvent.VK_C);
		r.keyRelease(KeyEvent.VK_CONTROL);
		r.keyRelease(KeyEvent.VK_C);
	}
	public static void pasteKey() throws AWTException {
		r=new Robot();
		r.keyPress(KeyEvent.VK_CONTROL);
		r.keyPress(KeyEvent.VK_V);
		r.keyRelease(KeyEvent.VK_CONTROL);
		r.keyRelease(KeyEvent.VK_V);
	}
	public static void downKey() throws AWTException {
		r=new Robot();
		r.keyPress(KeyEvent.VK_DOWN);
		r.keyRelease(KeyEvent.VK_DOWN);
	}
	public static void upKey() throws AWTException {
		r=new Robot();
		r.keyPress(KeyEvent.VK_UP);
		r.keyRelease(KeyEvent.VK_UP);
	}
	public static void enterKey() throws AWTException {
		r=new Robot();
		r.keyPress(KeyEvent.VK_ENTER);
		r.keyRelease(KeyEvent.VK_ENTER);
	}
	public static void tabKey() throws AWTException {
		r=new Robot();
		r.keyPress(KeyEvent.VK_TAB);
		r.keyRelease(KeyEvent.VK_TAB);
	}
	
	public static void deleteKey() throws AWTException {
		r=new Robot();
		r.keyPress(KeyEvent.VK_DELETE);
		r.keyRelease(KeyEvent.VK_DELETE);
	}
	
	//jsexecutor
	public static void scrollDown(WebElement ref) {
		js=(JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true)", ref);
	}
	public static void scrollUp(WebElement ref) {
		js=(JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(false)", ref);
	}
	public static void jsClick(WebElement ref) {
		js=(JavascriptExecutor) driver;
		js.executeScript("arguments[0].click()", ref);
	}
	public static void jsInsertvalue(WebElement ref, String input) {
		js=(JavascriptExecutor) driver;
		js.executeScript("arguments[0].setAttribute('value'," +input+")", ref);
	}
	public static void jsPrintText(WebElement ref) {
		js=(JavascriptExecutor) driver;
		js.executeScript("arguments[0].getAttribute('value')", ref);
	}
	
	
	//alert
	public static void acceptAlert() {
		al=driver.switchTo().alert();
		al.accept();
	}
	public static void cancelAlert() {
		al=driver.switchTo().alert();
		al.dismiss();
	}
	public static void insertValuesToAlert(String input) {
		al=driver.switchTo().alert();
		al.sendKeys(input);
	}
	public static void printTextFromAlert() {
		al=driver.switchTo().alert();
		al.getText();
	}
	//frame
	public static void frameCount(String tagname) {
		List<WebElement> allFrames = driver.findElements(By.tagName(tagname));
		System.out.println("No of Frames: "+allFrames.size());
	}
	public static void switchToFrame(WebElement ref) {
		driver.switchTo().frame(ref);
	}
	
	//select class
	public static void isMultipleDropdown(WebElement ref) {
		s=new Select(ref);
		boolean multiple = s.isMultiple();
		if (multiple==true) {
			System.out.println("THe Dropdown is multiple");
		}else {
			System.out.println("The dropdown is not multiple");
		}
	}
	
	public static void selectValue(WebElement ref, String value) {
		s=new Select(ref);
		s.selectByValue(value);
	}
	public static void selectIndex(WebElement ref, int index) {
		s=new Select(ref);
		s.selectByIndex(index);
	}
	public static void selectVisbleText(WebElement ref, String text) {
		s=new Select(ref);
		s.selectByVisibleText(text);
	}
	
	public static void deselectValue(WebElement ref, String value) {
		s=new Select(ref);
		s.deselectByValue(value);
	}
	public static void deselectIndex(WebElement ref, int index) {
		s=new Select(ref);
		s.deselectByIndex(index);
	}
	public static void deselectVisbleText(WebElement ref, String text) {
		s=new Select(ref);
		s.deselectByVisibleText(text);
	}
	public static void deSelectAll(WebElement ref) {
		s=new Select(ref);
		s.deselectAll();
	}
	public static void getAllOptions(WebElement ref) {
		s=new Select(ref);
		List<WebElement> allOptions = s.getOptions();
		for (WebElement each : allOptions) {
			System.out.println(each.getText());
		}
	}
	public static void printAllSelectedOptions(WebElement ref) {
		s=new Select(ref);
		List<WebElement> allSelected = s.getAllSelectedOptions();
		for (int i = 0; i < allSelected.size(); i++) {
			WebElement eachOpt = allSelected.get(i);
			System.out.println(eachOpt.getText());
		}
	}
	
	public static void printNotSelectedOptions(WebElement ref) {
		s=new Select(ref);
		List<WebElement> allOptions = s.getOptions();
		List<WebElement> allSelected = s.getAllSelectedOptions();
		allOptions.removeAll(allSelected);
		for (WebElement eachNonSelOpt : allOptions) {
			System.out.println(eachNonSelOpt);
		}
		}
	
	
	public static void printFirstSelectedOptions(WebElement ref) {
		s=new Select(ref);
		WebElement firstSelectedOption = s.getFirstSelectedOption();
		System.out.println(firstSelectedOption.getText());
	}
	
	
	//TakeScreenShot
	public static void takeSnap(String imageName) throws IOException {
		TakesScreenshot tk= (TakesScreenshot) driver;
		File src = tk.getScreenshotAs(OutputType.FILE);
		File des=new File("C:\\Users\\Satz\\eclipse-workspace\\TESTNG\\Screenshots\\"+imageName+".png");
		FileUtils.copyFile(src, des);
	}
	
	//Datadriven using Excel
	public static String getExcelData(String sheetname,int rowNumber,int columnNumber) throws IOException {
	File f=new File("C:\\Users\\Satz\\eclipse-workspace\\TESTNG\\Excel_input\\Login_Details.xlsx");
	FileInputStream fIn= new FileInputStream(f);
	
	Workbook w=new XSSFWorkbook(fIn);
	Sheet sh = w.getSheet(sheetname);
	Row row = sh.getRow(rowNumber);
	
	Cell cell = row.getCell(columnNumber);
	
	int cellType = cell.getCellType();
	
	String value = "";
	if (cellType==1) {
		value = cell.getStringCellValue();
	}
	else if (cellType==0) {
		if (DateUtil.isCellDateFormatted(cell)) {
			Date d = cell.getDateCellValue();
			SimpleDateFormat sim=new SimpleDateFormat("dd/MM/yyyy");
			value = sim.format(d);
		}
		else {
			double d = cell.getNumericCellValue();
			long l=(long)d;
			value = String.valueOf(l);
		}}
	return value;
}
	  public static void insertCellValue(String sheetname,int rowNumber,int cellNumber,String value) throws IOException {
			
			File f=new File("C:\\Users\\Satz\\eclipse-workspace\\Framework\\Data\\Login_Details.xlsx");
			FileInputStream fIn=new FileInputStream(f);
			Workbook w=new XSSFWorkbook(fIn);
			Sheet sh = w.getSheet(sheetname);
			
			Row row = sh.getRow(rowNumber);
			Cell cell = row.getCell(cellNumber);
			cell.setCellValue(value);
			FileOutputStream fOut=new FileOutputStream(f);
			w.write(fOut);
	}
	  
	  //wait
	  public static void waitsec(long sec) {
		  driver.manage().timeouts().implicitlyWait(sec, TimeUnit.SECONDS);
	}
	  
	  //Date And Time
	  public static void printDateAndTime() {
		  Date d=new Date();
		  System.out.println(d);
	}
	  //Clear Cache
	  public static void deleteCookies() {
		  driver.manage().deleteAllCookies();
	}
	 //switch to window 
	  public static void switchWindow(int i) {
		  Set<String> allWinId = driver.getWindowHandles();
		  List <String> li=new ArrayList<String>();
		  li.addAll(allWinId);
		  driver.switchTo().window(li.get(i));
	}
	  public static boolean elementDisplayed(WebElement ref) {
		  boolean displayed = ref.isDisplayed();
		  return displayed;
	}
	  public static void clearText(WebElement ref) {
		  ref.clear();
	}
}