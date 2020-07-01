package com.goparrot.test.step_definition;

import com.goparrot.test.page_object.LocationsPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class LocationsDefinitions {
	private LocationsPage locationsPage;

	@Given("user is on Location page")
	public void userIsOnLocationPage() {
		locationsPage.verifyPageIsLoaded();
	}

	@When("user is looking for {string} location using button")
	public void userIsLookingForUsingButton(String value) {
		locationsPage.searchUsingButton(value);
	}

	@When("user is looking for {string} location using enter")
	public void userIsLookingForUsingEnter(String value) {
		locationsPage.searchUsingEnter(value);
	}

	@When("user fills in {string} value into Search Field")
	public void userFillsInValueIntoSearchField(String value) {
		locationsPage.fillInValueIntoSearchField(value);
	}

	@When("user clear input Search field")
	public void userClearsSearchField() {
		locationsPage.clearSearchField();
	}

	@When("user selects {string} item from search drop down")
	public void userSelectItemFromSearchDropDown(String item) {
		locationsPage.selectItemFromSearchDropDown(item);
	}

	@Then("user should be asked for being more specific")
	public void userShouldBeAskedForBeingMoreSpecific() {
		locationsPage.verifyAskingForBeingMoreSpecific();
	}

	@Then("search input field should be empty")
	public void searchInputFieldShouldBeEmpty() {
		locationsPage.verifySearchInputFieldIsEmpty();
	}

	@Then("search input field should contain value {string}")
	public void searchInputFieldShouldBeEmpty(String value) {
		locationsPage.verifySearchInputFieldContainsValue(value);
	}
}
