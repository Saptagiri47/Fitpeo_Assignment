package com.pageObjects;

import java.time.Duration;

import org.openqa.selenium.WebDriver;

import com.base.BaseClass;

public class HomePage extends BaseClass {
	WebDriver driver;
	RevenueCalculatorPage revenue;

	public HomePage() {
		driver = BaseClass.setup();
	}

	public RevenueCalculatorPage launchHome() {
		driver.get("https://www.fitpeo.com/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		System.out.println("Launched the application Fitpeo.");
		return new RevenueCalculatorPage();
	}

	public void tearDown() {
		if (driver != null) {
			driver.quit();
			System.out.println("Closed the application Fitpeo.");
		}
	}
}
