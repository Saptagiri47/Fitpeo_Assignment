package com.testCases;

import com.pageObjects.HomePage;

public class HomePageTest {
	public static void main(String[] args) {
		HomePage hmpg = new HomePage();
		hmpg.launchHome();
		hmpg.tearDown();
	}
}
