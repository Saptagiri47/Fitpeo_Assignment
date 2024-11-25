package com.base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BaseClass {
	private static WebDriver driver;

	public static WebDriver setup() {
		if (driver == null) {
			driver = new ChromeDriver();
			driver.manage().window().maximize();

		}
		return driver;
	}

}
