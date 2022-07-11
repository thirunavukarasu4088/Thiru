package com.utilities;

import java.awt.AWTException;
import java.awt.List;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.jsoup.helper.DataUtil;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import io.github.bonigarcia.wdm.WebDriverManager;
public class BaseClass1{
	public static WebDriver driver;
	public static Actions a ;
	public static Robot r;
	public static Alert ale;
	public static Select s;
	public static WebDriverWait w;
	public static JavascriptExecutor js;
	public static TakesScreenshot t;
	public static String webtext;
	;
//1
	public static void launchChrome() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
	}
//2
	public static void gotUrl(String url) {
		driver.get(url);
	}
//3	
	public static void winMaximize() {
		driver.manage().window().maximize();
	}
//4
	public static void printTitle() {
		String title = driver.getTitle();
		System.out.println(title);
	}
//5	
	public static void printCurrentUrl() {
		System.out.println(driver.getCurrentUrl());
	}
//6	
	public static void sendKey(WebElement ele, String value) {
		ele.sendKeys(value);
	}
//7	
	public static void btnClick(WebElement ele) {
		ele.click();
	}
//8	
	public static void closeTab() {
		driver.close();
	}
//9	
	public static void quitTab() {
		driver.quit();
	}
//10
	public static void gotText(WebElement ele) {
		String webtext = ele.getText();
		System.out.println(webtext);
	}
//11	
	public static void rightClick(WebElement ele) {
		a = new Actions(driver);
		a.contextClick(ele).perform();
	}
//12
	public static void doubleCli(WebElement ele) {
		a = new Actions(driver);
		a.doubleClick(ele).perform();
	}	
//13
	public static void moveElement(WebElement ele) {
		a = new Actions(driver);
		a.moveToElement(ele).perform();
	}
//14
	public static void dragAndDro(WebElement ele) {
		a = new Actions(driver);
		a.dragAndDrop(ele, ele).perform();
	}
//15
	public static void keyPres() throws AWTException {
		r= new Robot();
		r.keyPress(KeyEvent.VK_TAB);
		r.keyRelease(KeyEvent.VK_TAB);
	}
//16	
	public static void keyUpp() throws AWTException {
		r = new Robot();
		r.keyPress(KeyEvent.VK_DOWN);
		r.keyRelease(KeyEvent.VK_DOWN);
		r.keyPress(KeyEvent.VK_ENTER);
		r.keyRelease(KeyEvent.VK_ENTER);
	}
//17	
	public static void isEnable(WebElement ele) {
		ele.isDisplayed();
		ele.click();
	}
//18	
	public static void isDisplay(WebElement ele) {
		ele.isDisplayed();
	}
//19	
	public static void isSelect(WebElement ele) {
		ele.isSelected();
	}
//20	
	public static void alertSwitch() {
		ale = driver.switchTo().alert();
	}
//21
	public static void frameId(String id) {
		driver.switchTo().frame(id);
	}
//22	
	public static void frameName(String name) {
		driver.switchTo().frame(name);
	}
//23	
	public static void frameEle(WebElement ele) {
		driver.switchTo().frame(ele);
	}
//24
	public static void frameInt(int index) {
		driver.switchTo().frame(index);
	}
//25	
	public static void frameParent() {
		driver.switchTo().parentFrame();
	}
//26	
	public static void frameDefault() {
		driver.switchTo().defaultContent();
	}
//27	
	public static void parentWindow() {
		driver.getWindowHandle();
	}
//28	
	public static void childWindow() {
		driver.getWindowHandles();
	}
//29	
	public static void switchWindowUrl(String id ) {
		driver.switchTo().window(id);
	}
//30
	public static void selectIndex(WebElement ele,int ind) {
		s = new Select(ele);
		s.selectByIndex(ind);
	}
//31
	public static void selectVisibleText(WebElement ele,String name) {
		s = new Select(ele);
		s.selectByVisibleText(name);	
	}
//32
	public static void selectValue(WebElement ele,String nam) {
		s = new Select(ele);
		s.selectByValue(nam);
	}
//33
	public static void multiple() {
		s.isMultiple();
	}
//34
	public static void getOption() {
		s.getOptions();
	}
//35
	public static void gotAllSelectedOptions() {
		s.getAllSelectedOptions();
	}
//36	
	public static void gotFirstSelectedOption() {
		s.getFirstSelectedOption();
	}
//37	
	public static void deselectIndex(int num) {
		s.deselectByIndex(num);
	}
//38	
	public static void deselectVisibleText(String name) {
		s.deselectByVisibleText(name);
	}
//39	
	public static void deselectValue(String name1) {
		s.deselectByValue(name1);
	}
//40	
	public static void deselectAl() {
		s.deselectAll();
	}
//41
	public static void elementToBeClick(WebElement ele,long e) {
		w = new WebDriverWait(driver, e);
		w.until(ExpectedConditions.elementToBeClickable(ele));
	}
//42	
	public static void elementToSelected(WebElement ele,long e) {
		w = new WebDriverWait(driver, e);
		w.until(ExpectedConditions.elementToBeSelected(ele));
	}
//43	
	public static void alertPresent(long e) {
		w = new WebDriverWait(driver, e);
		w.until(ExpectedConditions.alertIsPresent());
	}
//44	
	public static void elementSelectionsState(WebElement ele,long e) {
		w = new WebDriverWait(driver, e);
		w.until(ExpectedConditions.elementSelectionStateToBe(ele, true));
	}
//45	
	public static void visibilityOff(WebElement ele, long e) {
		w = new WebDriverWait(driver, e);
		w.until(ExpectedConditions.visibilityOf(ele));
	}
//46	
	public static void visibilityOfElement(WebElement ele,int sec) {
		w = new WebDriverWait(driver, sec);
		w.until(ExpectedConditions.visibilityOfAllElements(ele));
	}
//47	
	public static void visibilityOfElementLocate(By locator, long e) {
		w = new WebDriverWait(driver, e);
		w.until(ExpectedConditions.visibilityOfElementLocated(locator));
	}
//48
	public static void visibilityOfElementLocateBy(By locator, long e) {
		w = new WebDriverWait(driver, e);
		w.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(locator));
	}
//49	
	public static void titleis1(String title, long e) {
		w= new WebDriverWait(driver, e);
		w.until(ExpectedConditions.titleIs(title));
	}
//50
	public static void titleContain(String title, long e) {
		w= new WebDriverWait(driver, e);
		w.until(ExpectedConditions.titleContains(title));
	}
//51
	public static void attributeContain(long e,By loc,String attri, String val) {
		w= new WebDriverWait(driver, e);
		w.until(ExpectedConditions.attributeContains(loc, attri, val));
	}
//52	
	public static void attributeContainElement(long e,WebElement ele,String attribute, String value) {
		w= new WebDriverWait(driver, e);
		w.until(ExpectedConditions.attributeContains(ele, attribute, value));
	}
//53
	public static void textToBePresentInEle(WebElement ele, long e,String title) {
		w= new WebDriverWait(driver, e);
		w.until(ExpectedConditions.textToBePresentInElement(ele, title));
	}
//54	
	public static void textToBePresentInElementLocate(By loc,long e,String title) {
		w= new WebDriverWait(driver, e);
		w.until(ExpectedConditions.textToBePresentInElementLocated(loc, title));
	}
//55	
	public static void textToBePresentInElementValues(By locate,long e ,String text) {
		w= new WebDriverWait(driver, e);
		w.until(ExpectedConditions.textToBePresentInElementValue(locate, text));
	}
//56	
	public static void presenceOfAllElementsLocate(By locate, long e) {
		w= new WebDriverWait(driver, e);
		w.until(ExpectedConditions.presenceOfElementLocated(locate));
	}
//57	
	public static void presenceOfAllElementsLocateBy(By locate, long e) {
		w= new WebDriverWait(driver, e);
		w.until(ExpectedConditions.presenceOfAllElementsLocatedBy(locate));
	}
//58	
	public static void invisibilityOfElementLocate(By locate, long e) {
		w= new WebDriverWait(driver, e);
		w.until(ExpectedConditions.invisibilityOfElementLocated(locate));
	}
//59	
	public static void invisibilityOfElementwithtex(By locate,long e, String text) {
		w= new WebDriverWait(driver, e);
		w.until(ExpectedConditions.invisibilityOfElementWithText(locate, text));
	}
//60	
	public static void frameToBeAvailableAndSwitchTo(By locate, long e) {
		w= new WebDriverWait(driver, e);
		w.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(locate));
	}
//61	
	public static void ScrollIntoViewDown(WebElement ele) {
		js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].scrollIntoView(true)", ele);
	}
//62	
	public static void ScrollIntoViewAbove(WebElement ele) {
		js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].scrollIntoView(false)", ele);
	}
//63	
	public static void sendkeysReplace(WebElement ele) {
		js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].setAttribute('value','values')", ele);
	}
//64	
	public static void getAttributeReplace(WebElement ele) {
		js = (JavascriptExecutor)driver;
		js.executeScript("return arguments[0].getAttribute('values')", ele);
	}
//65	
	public static void clickReplace(WebElement ele) {
		js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].click()", ele);
	}
//66
	public static void takesScreenshot() throws IOException {
		
		Date d = new Date();
		t = (TakesScreenshot)driver;
		File src = t.getScreenshotAs(OutputType.FILE);
		File dest = new File("C:\\Users\\SATHY\\eclipse-workspace\\TESTNG\\screenshot\\"+d.toString().replace(":","_")+".png");
		FileUtils.copyFile(src, dest);
		
	}
//67
	public static void navigatesUrl(String url) {
		driver.navigate().to(url);
	}
//68	
	public static void navigatesRefresh() {
		driver.navigate().refresh();
	}
//69
	public static String excelRead(int r,int c) throws IOException {
		
		String path = "target\\data\\Excel Data.xlsx";
		
		File f = new File(path);
		
		FileInputStream fin = new FileInputStream(f);
		
		Workbook w = new XSSFWorkbook(fin);
		
		Sheet s = w.getSheet("Data");

		Row row = s.getRow(r);
	
		Cell cell = row.getCell(c);
	
		//CellType cells = cell.getCellType();
	
		//String Value = " ";
		
		DataFormatter d = new DataFormatter();
		
		String value = d.formatCellValue(cell);
		
		System.out.println(value);
		
		/*if (cells==CellType.) {
			Value = cell.getStringCellValue();
				
		}else if (DateUtil.isCellDateFormatted(cell)) {
			
			Date d = cell.getDateCellValue();
			
			SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
		}
		else {
			
			double d = cell.getNumericCellValue();

			long l = (long)d;
			
			Value =String.valueOf(l);
		}*/
		return value;	
	}
	
//70	
	public static void gotAttribute(WebElement ele) {
	webtext = ele.getAttribute("value");
	System.out.println(webtext);

	}
//71
	public static void excelRead1(String r) throws IOException {
	
	File f = new File("C:\\Users\\SATHY\\eclipse-workspace\\Maven\\target\\Data\\Data.xlsx");
	
	FileInputStream fin = new FileInputStream(f);
	
	Workbook w = new XSSFWorkbook(fin);
	
	Sheet s = w.getSheet("Student");

	Row cr = s.createRow(3);
	
	Cell cc = cr.createCell(2);
	
	cc.setCellValue(r);
	
	FileOutputStream fout = new FileOutputStream(f);
	
	w.write(fout);
	}	

//72

	public static void dateAndTime() {
	
		Date d = new Date();
		System.out.println(d);
	}
//73
	public static void launchFirefox() {
		WebDriverManager.firefoxdriver().setup();
		driver = new FirefoxDriver();
	}
//74
	public static void launchIe() {
		WebDriverManager.iedriver().setup();
		driver = new InternetExplorerDriver();
	}
}