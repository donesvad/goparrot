package com.goparrot.test.utils;


import com.goparrot.test.enums.DriverType;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import static com.goparrot.test.enums.DriverType.CHROME;
import static com.goparrot.test.enums.DriverType.FIREFOX;

public class TestDataFileReader {
	private static final Properties properties = new Properties();

	final static String PROPERTY_FILE_PATH =
			"src" + File.separator + "main" + File.separator + "resources" + File.separator + "test.properties";

	static {
		try {
			properties.load(new FileReader(PROPERTY_FILE_PATH));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static String getApplicationUri() {
		String uri = properties.getProperty("base.uri");
		if (uri != null)
			return uri;
		else
			throw new RuntimeException("Application Url not specified in the test.properties file for the Key: base.uri");
	}

	public static DriverType getBrowser() {
		String browserName = properties.getProperty("browser");
		if (browserName == null || browserName.equals(CHROME.getName()))
			return CHROME;
		else if (browserName.equalsIgnoreCase(FIREFOX.getName()))
			return FIREFOX;
		else
			throw new RuntimeException("Browser Name Key value in test.properties is not matched : " + browserName);
	}
}
