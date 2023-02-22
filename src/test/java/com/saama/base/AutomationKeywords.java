package com.saama.base;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
//all keywords will be available here
public class AutomationKeywords {

	private WebDriver driver;

	public AutomationKeywords(WebDriver driver) {
		this.driver = driver;
	}

	public void clickOnElement(By locator) {
		driver.findElement(locator).click();
	}

	public void typeOnElement(By locator, String text) {
		driver.findElement(locator).sendKeys(text);
	}

	public String getTextFromElement(By locator) {
		return driver.findElement(locator).getText();
	}
}
