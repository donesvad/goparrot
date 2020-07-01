package com.goparrot.test.components;

import lombok.Getter;
import lombok.SneakyThrows;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import ru.yandex.qatools.htmlelements.annotations.Name;
import ru.yandex.qatools.htmlelements.element.Button;
import ru.yandex.qatools.htmlelements.element.HtmlElement;
import ru.yandex.qatools.htmlelements.element.TextInput;

import static com.goparrot.test.utils.WebDriverManager.DRIVER_WAIT_TIME;
import static com.goparrot.test.utils.WebDriverManager.getWebDriver;
import static org.openqa.selenium.Keys.ENTER;

@Name("Search component")
@FindBy(className = "ant-layout-sider-children")
@Getter
public class SearchBox extends HtmlElement {

	@Name("Search request input")
	@FindBy(id = "searchBox")
	private TextInput searchInput;

	@Name("Find button")
	@FindBy(css = ".searchbox-group > button")
	private Button findButton;

	@Name("Show all locations button")
	@FindBy(css = ".showall-button-group > button")
	private Button showAllButton;

	@Name("Your location button")
	@FindBy(className = "ant-input-group-addon")
	private Button locationButton;

	@Name("Clear button")
	@FindBy(className = "ant-input-suffix")
	private Button clearButton;

	public void searchWithButton(String value) {
		searchInput.sendKeys(value);
		findButton.click();
	}

	public void searchWithEnter(String value) {
		searchInput.sendKeys(value + ENTER);
	}

	public String getSearchFieldValue() {
		return searchInput.getText();
	}

	@SneakyThrows public void fillInValueIntoSearchField(String value) {
		searchInput.click();
		searchInput.sendKeys(value);
	}

	public void clearInputSearchField() {
		clearButton.click();
	}

	public String getHelpBoxMessage() {
		return this.findElement(By.className("searchbox-help")).getText();
	}

	public void selectDropDownItem(String item) {
	getWebDriver().findElements(By.className("pac-item")).stream()
			.filter(e -> e.getText().equals(item))
			.findAny()
			.orElseThrow(() -> new NoSuchElementException("There is no one item with value: " + item))
			.click();
	}

}
