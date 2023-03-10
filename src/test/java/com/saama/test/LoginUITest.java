package com.saama.test;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.saama.base.AutomationWrapper;

/**
 * 
 * @author Balaji Dinakaran
 *
 *         Description - This class contains methods for validating UI
 *         components
 */
public class LoginUITest extends AutomationWrapper {

	@Test(priority = 1, groups = { "smoke", "UI" })
	public void validateTitleTest() {
		test.log(Status.INFO, "Validating Title Of the LoginPage");
		String actualTitle = driver.getTitle();
		test.log(Status.INFO, "Actual Title: " + actualTitle);
		Assert.assertEquals(actualTitle, "OrangeHRM");
		test.log(Status.INFO, "Successfully completed validation");
	}

	@Test(priority = 2, groups = { "UI" })
	public void validateHeaderTest() {
		String actualHeader = driver.findElement(By.xpath("//h5")).getText();
		Assert.assertEquals(actualHeader, "Login");
	}
}
