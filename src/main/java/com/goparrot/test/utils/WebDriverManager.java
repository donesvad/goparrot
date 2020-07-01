package com.goparrot.test.utils;

import com.goparrot.test.enums.DriverType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.File;
import java.util.concurrent.TimeUnit;

import static com.goparrot.test.utils.TestDataFileReader.getBrowser;

public class WebDriverManager {
	public static final long DRIVER_WAIT_TIME = 10;
	public static final String chromePath = "src" + File.separator + "test" + File.separator
			+ "resources" + File.separator + "drivers" + File.separator + "chromedriver.exe";
	private static final DriverType driverType = getBrowser();
	private static WebDriver driver;

	public static WebDriver getWebDriver() {
		if (driver == null)
			driver = createDriver();
		return driver;
	}

	private static WebDriver createDriver() {
		switch (driverType) {
			case CHROME:
				System.setProperty("webdriver.chrome.driver", chromePath);
				driver = new ChromeDriver();
				break;
			case FIREFOX:
				driver = new FirefoxDriver();
				break;
		}
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
		driver.manage().timeouts().setScriptTimeout(30, TimeUnit.SECONDS);

		return driver;
	}

	public static void closeDriver() {
		driver.close();
		driver.quit();
		driver = null;
	}
}
