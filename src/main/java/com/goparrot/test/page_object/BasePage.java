package com.goparrot.test.page_object;

import lombok.Getter;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import ru.yandex.qatools.htmlelements.loader.decorator.HtmlElementDecorator;
import ru.yandex.qatools.htmlelements.loader.decorator.HtmlElementLocatorFactory;

import static com.goparrot.test.utils.WebDriverManager.DRIVER_WAIT_TIME;
import static com.goparrot.test.utils.WebDriverManager.getWebDriver;

@Log4j2
@Getter
public abstract class BasePage {

	private WebDriver driver;
	private WebDriverWait wait;

	public BasePage() {
		this.driver = getWebDriver();
		this.wait = new WebDriverWait(driver, DRIVER_WAIT_TIME);
		PageFactory.initElements(new HtmlElementDecorator(new HtmlElementLocatorFactory(driver)), this);
	}
}
