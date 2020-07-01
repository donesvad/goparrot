package com.goparrot.test;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
		strict = true,
		features = {"src/test/resources/features"},
		glue = {"com.goparrot.test.step_definition", "com.goparrot.test.hooks"},
		monochrome = true,
		tags = {"@SearchBox"},
		plugin = {"pretty",
				"json:test-output/cucumber-reports/Cucumber.json",
				"junit:test-output/cucumber-reports/Cucumber.xml",
				"html:test-output/cucumber-reports"}
)
public class Runner extends AbstractTestNGCucumberTests {}
