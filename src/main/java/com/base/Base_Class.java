package com.base;

import java.io.File;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.Alert;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Base_Class {
	public static WebDriver driver;

	protected static WebDriver launchBrowser(String browserName) {
		try {
			if (browserName.equalsIgnoreCase("chrome")) {
				driver = new ChromeDriver();

			} else if (browserName.equalsIgnoreCase("firefox")) {
				driver = new FirefoxDriver();

			} else if (browserName.equalsIgnoreCase("edge")) {
				System.setProperty("webdriver.edge.driver","C:\\Users\\prabu_tek3zm1\\Downloads\\edgedriver_win64\\msedgedriver.exe");
				driver = new EdgeDriver();
			}
		} catch (Exception e) {
			Assert.fail("Error: occured During Browser launch");
		}

		driver.manage().window().maximize();
		return driver;

	}

	protected static void launchUrl(String Url) {
		try {
			driver.get(Url);
		} catch (Exception e) {
			Assert.fail("Error: occured During url launch");
		}

	}

	protected static void elementClick(WebElement element) {
		try {
			element.click();
		} catch (Exception e) {
			Assert.fail("Error: occured During clicking the element");
		}

	}

	protected static void closeBrowser() {
		try {
			driver.close();
		} catch (Exception e) {
			Assert.fail("Error: occured During closing the browser");
		}
	}

	protected static void passInput(WebElement element, String value) {
		try {
			element.clear();
			element.sendKeys(value);
		} catch (Exception e) {
			Assert.fail("Error: occured During passing the values");
		}

	}

	protected static void windowHandling(int num) {
		try {
			List<String> allwindow = new ArrayList<>(driver.getWindowHandles());
			driver.switchTo().window(allwindow.get(num));
		} catch (Exception e) {
			Assert.fail("Error: occured During window handling");
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
			Assert.fail("Error: occured During value deselect");
		}

	}

	protected static void deSelectoption(WebElement element, String type, String value) {
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
			Assert.fail("Error: occured During value deselect");
		}

	}

	protected static void takeScreenshot(String fileName) {
		try {
			TakesScreenshot ts = (TakesScreenshot) driver;
			File src = ts.getScreenshotAs(OutputType.FILE);
			String timestamp = String.valueOf(System.currentTimeMillis());
			File destination = new File(
					"C:\\Users\\prabu_tek3zm1\\eclipse-workspace\\Day_1_TaskFinal\\Screenshot\\shots" + fileName + "_"
							+ timestamp + ".png");
			FileHandler.copy(src, destination);
		} catch (Exception e) {
			System.out.println("Screenshot failed");
		}
	}

	protected static void Implicit_Wait(String duration) {
		try {
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(Integer.parseInt(duration)));
		} catch (Exception e) {
			System.out.println("Error: occured During wait");
		}
		;
	}

	protected static void Explicit_Wait(String duration, WebElement element) {
		try {

			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(Integer.parseInt(duration)));
			wait.until(ExpectedConditions.visibilityOf(element));
			wait.until(ExpectedConditions.elementToBeClickable(element));

		} catch (Exception e) {
			System.out.println("Error: occured During wait");
		}
		;
	}

	protected static void getText(WebElement element) {
		try {
			String text = element.getText();
			System.out.println(text);
		} catch (Exception e) {
			Assert.fail("Error: occured During url launch");
		}

	}

	protected static void handeling_Alert(String type) {
		try {
			Alert a = driver.switchTo().alert();
			if (type.equalsIgnoreCase("simple")) {
				String text = a.getText();
				System.out.println(text);
				a.accept();

			}
		} catch (Exception e) {
			Assert.fail("Error: occured During clicking the element");
		}
	}

}
