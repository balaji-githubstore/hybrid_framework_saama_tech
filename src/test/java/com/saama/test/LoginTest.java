package com.saama.test;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.saama.base.AutomationWrapper;
import com.saama.pages.LoginPage;
import com.saama.utilities.DataUtils;

/**
 * 
 * @author Balaji Dinakaran
 *
 */
public class LoginTest extends AutomationWrapper {

	@Test(groups = {"smoke","login"})
	public void validLoginTest() {
	
		LoginPage loginPage=new LoginPage(driver);
		loginPage.enterUsername("Admin");
		loginPage.enterPassword("admin123");
		loginPage.clickOnLogin();
		

		String actualHeader = driver.findElement(By.xpath("//h6[normalize-space()='Dashboard']")).getText();
		Assert.assertEquals(actualHeader, "Dashboard");
	}

	@Test(dataProvider = "commonDataProvider",dataProviderClass = DataUtils.class,groups = {"login"})
	public void invalidLoginTest(String username, String password, String expectedError) 
	{
		LoginPage loginPage=new LoginPage(driver);
		loginPage.enterUsername(username);
		loginPage.enterPassword(password);
		loginPage.clickOnLogin();

		String actualError = driver.findElement(By.xpath("//p[contains(@class,'oxd-alert-content-text')]")).getText();
		Assert.assertTrue(actualError.contains(expectedError)); // expect true
	}
}
