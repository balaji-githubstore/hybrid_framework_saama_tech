package com.saama.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.saama.base.AutomationKeywords;

public class MainPage extends AutomationKeywords {
	
	private By pimMenuLocator=By.xpath("//span[text()='PIM']");
	private By adminMenuLocator=By.xpath("//span[text()='Admin']");

	private WebDriver driver;

	public MainPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}
	
	public void clickOnPIMMenu()
	{
		super.clickOnElement(pimMenuLocator);
	}
	
	public void clickOnAdmin()
	{
		clickOnElement(adminMenuLocator);
	}

}
