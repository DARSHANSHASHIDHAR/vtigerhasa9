package genericlibraries;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * This class contains all reusable methods of WebDriver
 * @author Darshan S
 *
 */
public class WebDriverUtility {
	public WebDriver driver;
	/**
	 * This method is used to launch browser
	 * @param browser
	 * @return
	 */
	public WebDriver launchBrowser(String browser) {
		switch(browser) {
		case "chrome": driver = new ChromeDriver(); break;
		case "firefox": driver = new FirefoxDriver(); break;
		case "edge": driver = new EdgeDriver(); break;
		default: 
			System.out.println("Invalid browser");
			break;
			
		}
		return driver;
	}
	/**
	 * This method is used to maximize the browser
	 */
	public void maximizeBrowser() {
		driver.manage().window().maximize();
	}
	/**
	 * This method is used to navigate to the web application
	 * @param url
	 */
	public void navigateToApplication(String url) {
		driver.get(url);
	}
	/**
	 * This method is used to wait till WebElement is found
	 * @param time
	 */
	public void waitTillElementFound(long time) {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(time));
	}
	
	public WebDriver openApplication(String browser, String url, long time) {
		driver = launchBrowser(browser);
		maximizeBrowser();
		navigateToApplication(url);
		waitTillElementFound(time);
		return driver;
	}
	/**
	 * This method is used to explicitly wait till the WebElement is found
	 * @param time
	 * @param element
	 */
	public void explicitWait(long time, WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(time));
		wait.until(ExpectedConditions.visibilityOf(element));
	}
	/**
	 * This method is used to perform mouse hover on WebElement
	 * @param element
	 */
	public void mouseHover(WebElement element) {
		Actions a = new Actions(driver);
		a.moveToElement(element).perform();
	}
	/**
	 * This method is used to double click on WebElement
	 * @param element
	 */
	public void doubleClickOnElement(WebElement element) {
		Actions a = new Actions(driver);
		a.doubleClick(element).perform();
	}
	/**
	 * This method is used to right click on WebElement
	 * @param element
	 */
	public void rightClick(WebElement element) {
		Actions a = new Actions(driver);
		a.contextClick(element).perform();
	}
	/**
	 * This method is used to drag and drop WebElement
	 * @param src
	 * @param dest
	 */
	public void dragAnddrop(WebElement src, WebElement dest) {
		Actions a = new Actions(driver);
		a.dragAndDrop(src, dest).perform();
	}
	/**
	 * This method is used to select dropdown based on value
	 * @param value
	 * @param element
	 */
	public void dropdown(String value, WebElement element) {
		Select s = new Select(element);
		s.selectByValue(value);
	}
	/**
	 * This method is used to select dropdown based on index
	 * @param index
	 * @param element
	 */
	public void dropdown(int index, WebElement element) {
		Select s = new Select(element);
		s.selectByIndex(index);
	}
	/**
	 * This method is used to select dropdown based on visible text on the webpage
	 * @param element
	 * @param text
	 */
	public void dropdown(WebElement element,String text) {
		Select s = new Select(element);
		s.selectByVisibleText(text);
	}
	/**
	 * This method is used to get the WindowID of parent window or main window
	 * @return
	 */
	public String getParentWindowID() {
		return driver.getWindowHandle();
	}
	/**
	 * This method is used to switch control to child browser popup
	 */
	public void childBrowserPopup() {
		Set<String> set = driver.getWindowHandles();
		for(String window: set) {
			driver.switchTo().window(window);
		}
	}
	/**
	 * This method is used to switch control to a frame or embedded webpage based on text
	 * @param index
	 */
	public void switchToFrame(String text) {
		driver.switchTo().frame(text);
	}
	/**
	 * This method is used to switch control to a frame or embedded webpage based on WebElement
	 * @param element
	 */
	public void switchToFrame(WebElement element) {
		driver.switchTo().frame(element);
	}
	/**
	 * This method is used to switch control to a frame or embedded webpage based on index
	 * @param index
	 */
	public void switchToFrame(int index) {
		driver.switchTo().frame(index);
	}
	/**
	 * This method is used to handle javascript alerts by clicking on 'OK'
	 */
	public void alertOK() {
		driver.switchTo().alert().accept();
	}
	/**
	 * This method is used to handle javascript alerts by clicking on 'Cancel' 
	 */
	public void alertCancel() {
		driver.switchTo().alert().dismiss();
	}
	/**
	 * This method is used to disable notifications in the Chrome browser
	 * @return
	 */
	public ChromeOptions disableNotifications() {
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");
		return options;
	}
	/**
	 * This method is used to fetch the Screenshot of the webpage in File png format
	 * @param classname
	 * @param javaUtil
	 */
	public String getScreenshot(String classname, JavaUtility javaUtil) {
		TakesScreenshot ts = (TakesScreenshot) driver;
		String currentTime = javaUtil.getCurrentTime();
		File src = ts.getScreenshotAs(OutputType.FILE);
		File dest = new File("./screenshot/"+classname+"_"+currentTime+".png");
		try {
			FileUtils.copyFile(src, dest);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return dest.getAbsolutePath();
	}
	/**
	 * This method is used to get Screenshot based on Base64 format
	 * @return
	 */
	public String getScreenshot() {
		TakesScreenshot ts = (TakesScreenshot) driver;
		return ts.getScreenshotAs(OutputType.BASE64);
	}
	/**
	 * This method is used to scroll the page till the WebElement
	 * @param element
	 */
	public void scrollTillElement(WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true)",element);
	}
	/**
	 * This method is used to close current window
	 */
	public void closeCurrentWindow() {
		driver.close();
	}
	/**
	 * This method is used to close all the windows and exit browser
	 */
	public void closeAllWindows() {
		driver.quit();
	}
}
