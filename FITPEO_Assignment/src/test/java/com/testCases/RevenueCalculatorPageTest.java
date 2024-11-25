package com.testCases;

import com.pageObjects.HomePage;
import com.pageObjects.RevenueCalculatorPage;

public class RevenueCalculatorPageTest {
	public static void main(String[] args) throws Exception {
		HomePage hmpg = new HomePage();
		hmpg.launchHome();

		RevenueCalculatorPage rcp = new RevenueCalculatorPage();
		rcp.openRevenueCalculatorInNewTab();
		rcp.scrollToSlider();
		rcp.updateSliderTo820();
		rcp.updateTextFieldTo560();
		rcp.selectTargetCPTs();
		rcp.validateTotalRecurringReimbursement();
		rcp.validateHeaderAndReimbursementValue();

		hmpg.tearDown();

	}

}
