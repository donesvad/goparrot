package com.goparrot.test.hooks;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import lombok.extern.log4j.Log4j2;

import static com.goparrot.test.utils.TestDataFileReader.getApplicationUri;
import static com.goparrot.test.utils.WebDriverManager.closeDriver;
import static com.goparrot.test.utils.WebDriverManager.getWebDriver;

@Log4j2
public class TestHook {
	@Before
	public void setUp(Scenario scenario) {
		log.debug("Starting scenario: {}", scenario.getName());
		getWebDriver().get(getApplicationUri());
		getWebDriver().switchTo().frame(0);
	}

	@After
	public void tearDown(Scenario scenario) {
		log.debug("Finished scenario: {}", scenario.getName());
		closeDriver();
	}
}
