package com.base;

import java.awt.AWTException;
import java.awt.Desktop;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class Base_Class {
	public static WebDriver driver;
	public static ExtentReports extentReports;
	public static File file;

	protected static WebDriver launchBrowser(String browserName) {
		try {
			if (browserName.equalsIgnoreCase("chrome")) {
				driver = new ChromeDriver();

			} else if (browserName.equalsIgnoreCase("firefox")) {
				driver = new FirefoxDriver();

			} else if (browserName.equalsIgnoreCase("edge")) {

				driver = new EdgeDriver();
			}
		} catch (Exception e) {

			Assert.fail("ERROR:OCCURRED DURING BROWSER LAUNCH");
		}

		driver.manage().window().maximize();
		return driver;

	}

	protected static void launchUrl(String Url) {
		try {
			driver.get(Url);
		} catch (Exception e) {
			Assert.fail("ERROR:OCCURRED DURING URL LAUNCH");
		}

	}

	protected static void elementClick(WebElement element) {
		try {
			element.click();
		} catch (Exception e) {
			Assert.fail("ERROR: OCCURRED DURING CLICKING OF ELEMENT");
		}

	}

	protected static void closeBrowser() {
		try {
			driver.close();
		} catch (Exception e) {
			Assert.fail("ERROR: OCCURRED DURING CLOSING BROWSER");
		}
	}

	protected static void passInput(WebElement element, String value) {
		try {

			element.clear();
			element.sendKeys(value);
		} catch (Exception e) {
			Assert.fail("ERROR: OCCURRED DURING PASSING OF VALUES");
		}

	}

	protected static void windowHandling(int num) {
		try {
			List<String> allwindow = new ArrayList<>(driver.getWindowHandles());
			driver.switchTo().window(allwindow.get(num));
		} catch (Exception e) {
			Assert.fail("ERROR: OCCURED DURING WINDOWHANDLING");
		}

	}

	protected static void selectOption(WebElement element, String type, String value) {
		try {
			Select select = new Select(element);
			boolean multiple = select.isMultiple();
			System.out.println(multiple);
			if (type.equalsIgnoreCase("text")) {
				select.selectByVisibleText(value);
			} else if (type.equalsIgnoreCase("index")) {
				select.selectByIndex(Integer.parseInt(value));
			} else if (type.equalsIgnoreCase("value")) {
				select.deselectByValue(value);
			}
		} catch (Exception e) {
			Assert.fail("ERROR: OCCURRED DURING VALUE SELECT");
		}

	}

	protected static void deselectOption(WebElement element, String type, String value) {
		try {
			Select select = new Select(element);
			if (type.equalsIgnoreCase("text")) {
				select.deselectByVisibleText(value);
			} else if (type.equalsIgnoreCase("index")) {
				select.deselectByIndex(Integer.parseInt(value));
			} else if (type.equalsIgnoreCase("value")) {
				select.deselectByValue(value);
			}
		} catch (Exception e) {
			Assert.fail("ERROR : OCCURRED DURING VALUE DESELECT ");
		}

	}

	//	protected static void takeScreenshots(String fileName, String location) {
	//		try {
	//			TakesScreenshot ts = (TakesScreenshot) driver;
	//			File src = ts.getScreenshotAs(OutputType.FILE);
	//			String timestamp = String.valueOf(System.currentTimeMillis());
	//			File destination = new File(location + fileName + "_" + timestamp + ".png");
	//			FileHandler.copy(src, destination);
	//		} catch (Exception e) {
	//			Assert.fail("ERROR : OCCURRED DURING TAKING SCREENSHOT");
	//		}
	//	}

	protected static void Implicit_Wait(int duration) {
		try {
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(duration));
		} catch (Exception e) {
			System.out.println("ERROR: OCCURRED DURING Implicit_Wait");
		}

	}

	protected static void Explicit_Wait(int duration, WebElement element) {
		try {

			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(duration));
			wait.until(ExpectedConditions.visibilityOf(element));
			wait.until(ExpectedConditions.elementToBeClickable(element));

		} catch (Exception e) {
			System.out.println("ERROR: OCCURRED DURING  Explicit_Wait");
		}

	}

	protected static void getText(WebElement element) {
		try {
			String text = element.getText();
			System.out.println(text);
		} catch (Exception e) {
			Assert.fail("ERROR : OCCURRED DURING GETTEXT");
		}

	}

	protected static void handeling_Alert(String type) {
		try {
			Alert a = driver.switchTo().alert();
			if (type.equalsIgnoreCase("simple")) {
				String text = a.getText();
				System.out.println(text);
				a.accept();
			} else if (type.equalsIgnoreCase("confirm_ok")) {
				a.accept();
			} else if (type.equalsIgnoreCase("confirm_cancel")) {
				a.dismiss();
			}
		} catch (Exception e) {
			Assert.fail("ERROR: OCCURRED DURING HANDLING ALERT");
		}
	}

	protected static void mouse_Actions(WebElement element, String action_Type) {
		try {

			Actions action = new Actions(driver);
			if (action_Type.equalsIgnoreCase("click")) {

				action.click(element);
			} else if (action_Type.equalsIgnoreCase("right click")) {
				action.contextClick(element);
			} else if (action_Type.equalsIgnoreCase("move element")) {
				action.moveToElement(element);
			} else if (action_Type.equalsIgnoreCase("click and hold")) {
				action.clickAndHold(element);
			} else if (action_Type.equalsIgnoreCase("release")) {
				action.release(element);
			}

		} catch (Exception e) {
			Assert.fail("ERROR: OCCURRED DURING MOUSE ACTIONS");
		}

	}

	protected static void drag_And_Drop(WebElement element_A, WebElement element_B) {
		try {
			Actions action = new Actions(driver);
			action.dragAndDrop(element_A, element_B);
		} catch (Exception e) {
			Assert.fail("ERROR: OCCURRED DURING DRAG AND DROP");
		}
	}

	protected static void robot_Enter() {
		try {
			Robot r = new Robot();
			r.keyPress(KeyEvent.VK_ENTER);
			r.keyRelease(KeyEvent.VK_ENTER);
		} catch (Exception e) {
			Assert.fail("ERROR: OCCURRED DURING ROBOT ENTER KEY PRESS");
		}

	}

	protected static void robot_TypeString(String text) {
		try {
			Robot r = new Robot();
			for (char c : text.toCharArray()) {

				int keyCode = KeyEvent.getExtendedKeyCodeForChar(c);

				if (KeyEvent.CHAR_UNDEFINED == keyCode) {
					throw new RuntimeException("Key code not found for character: " + c);
				}

				r.keyPress(keyCode);
				r.keyRelease(keyCode);
				r.delay(50);
			}
		} catch (Exception e) {
			Assert.fail("ERROR: OCCURRED DURING ROBOT TYPESTRING");
		}
	}

	protected static void handeling_Frame(String id) {
		try {

			driver.switchTo().frame(id);

		} catch (Exception e) {
			Assert.fail("ERROR: OCCURRED DURING HANDLING FRAMES USING ID");
		}

	}

	protected static void handeling_Frame(int index) {
		try {

			driver.switchTo().frame(index);

		} catch (Exception e) {
			Assert.fail("ERROR: OCCURRED DURING HANDLING FRAMES USING INDEX");
		}

	}

	protected static void handeling_Frame(WebElement element) {
		try {

			driver.switchTo().frame(element);

		} catch (Exception e) {
			Assert.fail("ERROR: OCCURRED DURING HANDLING FRAMES USING WEBELEMENT");
		}

	}

	protected static void js_Executor(WebElement element, String action_Type) {
		try {
			JavascriptExecutor js = (JavascriptExecutor) driver;
			if (action_Type.equalsIgnoreCase("view")) {
				js.executeScript("arguments[0].scrollIntoView();", element);

			} else if (action_Type.equalsIgnoreCase("click")) {
				js.executeScript("arguments[0].click();", element);
			}

		} catch (Exception e) {
			Assert.fail("ERROR: OCCURRED DURING JS_EXECUTOR USING ELEMENT");
		}
	}

	protected static void js_Executor(String action_Type, int value) {
		try {
			JavascriptExecutor js = (JavascriptExecutor) driver;
			if (action_Type.equalsIgnoreCase("down")) {
				js.executeScript("window.scrollBy(0, " + value + ");");
			} else if (action_Type.equalsIgnoreCase("up")) {
				js.executeScript("window.scrollBy(0," + -value + ");");
			} else if (action_Type.equalsIgnoreCase("range")) {
				js.executeScript("window.scrollBy(0," + value + ");");
			}

		} catch (Exception e) {
			Assert.fail("ERROR: OCCURRED DURING JS_EXECUTOR USING SCROLL");
		}
	}

	protected static void js_Executor_Value(WebElement element, String value) {
		try {
			JavascriptExecutor js = (JavascriptExecutor) driver;
			element.clear();
			js.executeScript("arguments[0].value='" + value + "';", element);
			System.out.println(value);
		} catch (Exception e) {
			Assert.fail("ERROR: OCCURRED DURING JS_EXECUTOR PASSING VALUES");
		}
	}

	protected static void resume_Uploader(String pdflocation) {
		try {
			Robot robot;
			robot = new Robot();
			StringSelection ss = new StringSelection(pdflocation);
			Toolkit.getDefaultToolkit().getSystemClipboard().setContents(ss, null);
			robot.delay(2000);
			robot.keyPress(KeyEvent.VK_CONTROL);
			robot.keyPress(KeyEvent.VK_V);
			robot.keyPress(KeyEvent.VK_ENTER);
		} catch (Exception e) {

			Assert.fail("ERROR: OCCURRED DURING RESUME UPLOAD");
		}

	}

	public static void extentReportStart(String location) {
		try {
			extentReports = new ExtentReports();
			file = new File(location);
			ExtentSparkReporter sparkReporter = new ExtentSparkReporter(file);
			extentReports.attachReporter(sparkReporter);
			extentReports.setSystemInfo("OS", System.getProperty("os.name"));
			extentReports.setSystemInfo("Java Version", System.getProperty("java.version"));
		} catch (Exception e) {

			Assert.fail("ERROR: OCCURRED DURING EXTENTREPORTSTART");
		}
	}

	public static void extentReportTearDown(String location) throws IOException {
		try {
			extentReports.flush();
			file = new File(location);
			Desktop.getDesktop().browse(file.toURI());
		} catch (Exception e) {

			Assert.fail("ERROR: OCCURRED DURING EXTENTREPORT TEARDOWN");
		}
	}

	protected static String takeScreenshot() throws IOException {

		TakesScreenshot screenshot = (TakesScreenshot) driver;
		String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
		File scrfile = screenshot.getScreenshotAs(OutputType.FILE);
		File destfile = new File("Screenshot\\.png" + "_" + timeStamp + ".png");
		FileHandler.copy(scrfile, destfile);
		return destfile.getAbsolutePath();

	}

}
