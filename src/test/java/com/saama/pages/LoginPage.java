package com.saama.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.saama.base.AutomationKeywords;

public class LoginPage extends AutomationKeywords {

	private By usernameLocator = By.name("username");
	private By passwordLocator = By.cssSelector("input[name='password']");
	private By loginLocator = By.xpath("//button[normalize-space()='Login']");
	private By errorLocator = By.xpath("//p[contains(@class,'oxd-alert-content-text')]");

	private WebDriver driver;

	public LoginPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}

	public void enterUsername(String username) {
//		driver.findElement(usernameLocator).sendKeys(username);
		super.typeOnElement(usernameLocator, username);
	}

	public void enterPassword(String password) {
//		driver.findElement(passwordLocator).sendKeys(password);
		super.typeOnElement(passwordLocator, password);
	}

	public void clickOnLogin() {
		clickOnElement(loginLocator);
	}

	public String getInvalidErrorMessage() {
		return getTextFromElement(errorLocator);
	}

}
