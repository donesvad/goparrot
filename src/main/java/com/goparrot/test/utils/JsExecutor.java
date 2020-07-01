package com.goparrot.test.utils;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

import static com.goparrot.test.utils.WebDriverManager.DRIVER_WAIT_TIME;
import static com.goparrot.test.utils.WebDriverManager.getWebDriver;

public class JsExecutor {

	private static WebDriverWait wait = new WebDriverWait(getWebDriver(), DRIVER_WAIT_TIME);

	public static void waitForPageToLoad() {
		ExpectedCondition<Boolean> jsLoad = driver -> getJs().executeScript("return document.readyState")
				.toString().equals("complete");
		wait.until(jsLoad);
	}

	private static JavascriptExecutor getJs() {
		return (JavascriptExecutor) getWebDriver();
	}
}
