package com.pageObjects;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import com.base.BaseClass;

public class RevenueCalculatorPage extends BaseClass {
	WebDriver driver;

	public RevenueCalculatorPage() {
		driver = BaseClass.setup();
	}

	public void openRevenueCalculatorInNewTab() {
		driver.switchTo().newWindow(WindowType.TAB);
		driver.navigate().to("https://fitpeo.com/revenue-calculator");
	}

	public void scrollToSlider() {
		WebElement sliderElement = driver
				.findElement(By.cssSelector(".MuiSlider-root.MuiSlider-colorPrimary.MuiSlider-sizeMedium.css-16i48op"));
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		jsExecutor.executeScript("window.scrollBy(0, 300)");
		System.out.println("Slider is visible: " + sliderElement.isDisplayed());
	}

	public void updateSliderTo820() {
		WebElement sliderInput = driver.findElement(By.cssSelector("input[type='range']"));

		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		jsExecutor.executeScript("arguments[0].value='820';", sliderInput);

		try {
			String currentSliderValue = sliderInput.getAttribute("value");
			if (currentSliderValue.equals("820")) {
				System.out.println("Slider value successfully updated to: " + currentSliderValue);
			} else {
				System.out.println("Failed to update slider value. Current value: " + currentSliderValue);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void updateTextFieldTo560() {
		WebElement textFieldInput = driver.findElement(By.cssSelector("input[value='200']"));

		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		jsExecutor.executeScript("arguments[0].value='560';", textFieldInput);

		try {
			String currentTextFieldValue = textFieldInput.getAttribute("value");
			if (currentTextFieldValue.equals("560")) {
				System.out.println("Text field value successfully updated to: " + currentTextFieldValue);
			} else {
				System.out.println("Failed to update text field value. Current value: " + currentTextFieldValue);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void selectTargetCPTs() {
		List<WebElement> cptElements = driver.findElements(By.xpath("//div[contains(@class, 'css-1eynrej')]"));
		List<String> targetCPTCodes = Arrays.asList("CPT-99091", "CPT-99453", "CPT-99454", "CPT-99474");

		for (WebElement cptElement : cptElements) {
			String[] cptCodes = cptElement.getText().split("\n");
			for (String code : cptCodes) {
				if (targetCPTCodes.contains(code)) {
					if (!cptElement.findElement(By.xpath(".//input[@type='checkbox']")).isSelected())
						cptElement.findElement(By.xpath(".//input[@type='checkbox']")).click();
					System.out.println("Selected checkbox for: " + code);
					driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
				}
			}
		}
	}

	public void validateTotalRecurringReimbursement() {
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		jsExecutor.executeScript("window.scrollBy(0, -400)");

		List<WebElement> elements = driver.findElements(By.xpath("//div[contains(@class, 'css-1eynrej')]"));
		List<String> targetCPTs = Arrays.asList("CPT-99457", "CPT-99458", "CPT-G2012", "CPT-99473", "CPT-99490",
				"CPT-99439", "CPT-99487", "CPT-G2064", "CPT-G2065", "CPT-99489");

		try {
			for (WebElement element : elements) {
				String text = element.getText();
				for (String target : targetCPTs) {
					if (text.contains(target)) {
						element.findElement(By.xpath(".//input[@type='checkbox']")).click();
						System.out.println("Clicked on checkbox: " + target);
						driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
						break;
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		String expectedTotalValue = "110800";
		WebElement actualTotalElement = driver.findElement(By.xpath("//div[@class='MuiBox-root css-m1khva']/p[2]"));
		String actualTotalValue = actualTotalElement.getText().replace("$", "").trim();

		if (expectedTotalValue.equals(actualTotalValue)) {
			System.out.println("The total recurring reimbursement is validated: " + expectedTotalValue);
		} else {
			System.out.println("Failed to validate the total recurring reimbursement. Expected: " + expectedTotalValue
					+ ", Found: " + actualTotalValue);
		}
	}

	public void validateHeaderAndReimbursementValue() {
		WebElement headerElement = driver.findElement(
				By.xpath("//p[contains(text(), 'Total Recurring Reimbursement for all Patients Per Month:')]"));
		String expectedHeader = "Total Recurring Reimbursement for all Patients Per Month:";
		String expectedValue = "110800";

		String headerText = headerElement.getText();
		String[] headerParts = headerText.split("\\$");

		List<String> actualValues = Arrays.asList(headerParts[0].trim(), headerParts[1].trim());
		List<String> expectedValues = Arrays.asList(expectedHeader, expectedValue);

		for (int i = 0; i < actualValues.size(); i++) {
			if (actualValues.get(i).equals(expectedValues.get(i))) {
				System.out.println("Validation successful: " + actualValues.get(i));
			} else {
				System.out.println(
						"Validation failed. Expected: " + expectedValues.get(i) + ", Found: " + actualValues.get(i));
			}
		}
	}
}
