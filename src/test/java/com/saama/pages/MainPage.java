package com.saama.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MainPage {
	
	private By pimMenuLocator=By.xpath("//span[text()='PIM']");

	private WebDriver driver;

	public MainPage(WebDriver driver) {
		this.driver = driver;
	}
	
	public void clickOnPIMMenu()
	{
		driver.findElement(pimMenuLocator).click();
	}

}
