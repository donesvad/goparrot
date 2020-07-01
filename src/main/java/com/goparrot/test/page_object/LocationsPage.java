package com.goparrot.test.page_object;

import com.goparrot.test.components.SearchBox;
import com.goparrot.test.utils.JsExecutor;
import lombok.Getter;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import ru.yandex.qatools.htmlelements.element.HtmlElement;

import static org.assertj.core.api.Assertions.assertThat;

@Getter
public class LocationsPage extends BasePage {
	@FindBy(className = "header")
	private HtmlElement header;

	@FindBy(className = "stores")
	private HtmlElement locationList;

	@FindBy(className = "map-container")
	private HtmlElement mapElement;

	private SearchBox searchBox;

	public void searchUsingButton(String request) {
		searchBox.searchWithButton(request);
	}

	public void searchUsingEnter(String request) {
		searchBox.searchWithEnter(request);
	}

	public void fillInValueIntoSearchField(String value) {
		searchBox.fillInValueIntoSearchField(value);
	}

	public void clearSearchField() {
		getWait().until(ExpectedConditions.elementToBeClickable(searchBox.getClearButton()));
		searchBox.clearInputSearchField();
	}

	public void selectItemFromSearchDropDown(String item) {
		searchBox.selectDropDownItem(item);
	}

	public void verifyPageIsLoaded() {
		JsExecutor.waitForPageToLoad();
		assertThat(searchBox.isDisplayed()).as("Search Box is not displayed").isTrue();
		assertThat(header.isDisplayed()).as("Header is not displayed").isTrue();
		assertThat(mapElement.isDisplayed()).as("Map is not displayed").isTrue();
		assertThat(locationList.isEnabled()).as("Location list is not displayed").isTrue();
	}

	public void verifyAskingForBeingMoreSpecific() {
		assertThat(searchBox.getHelpBoxMessage())
				.as("Help message is not equals to expected")
				.isEqualTo("Please be more specific");
	}

	public void verifySearchInputFieldIsEmpty() {
		getWait().until(ExpectedConditions.attributeToBe(searchBox.getSearchInput(), "value", ""));
		assertThat(searchBox.getSearchFieldValue())
				.as("Search Field is not empty")
				.isEqualTo("");
	}

	public void verifySearchInputFieldContainsValue(String value) {
		getWait().until(ExpectedConditions.attributeToBe(searchBox.getSearchInput(), "value", value));
		assertThat(searchBox.getSearchFieldValue())
				.as("Search Field does not contain value: " + value)
				.isEqualTo(value);
	}
}
