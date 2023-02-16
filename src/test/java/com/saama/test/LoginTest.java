package com.saama.test;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.saama.base.AutomationWrapper;

/**
 * 
 * @author Balaji Dinakaran
 *
 */
public class LoginTest extends AutomationWrapper {

	@Test
	public void validLoginTest() {
		driver.findElement(By.name("username")).sendKeys("Admin");
		driver.findElement(By.cssSelector("input[name='password']")).sendKeys("admin123");
		driver.findElement(By.xpath("//button[normalize-space()='Login']")).click();

		String actualHeader = driver.findElement(By.xpath("//h6[normalize-space()='Dashboard']")).getText();
		Assert.assertEquals(actualHeader, "Dashboard");
	}
	
	@DataProvider
	public String[][] invalidLoginData()
	{
		String[][] data=new String[2][3]; 
		
		data[0][0]="john";
		data[0][1]="john123";
		data[0][2]="Invalid credentials";
		
		data[1][0]="peter";
		data[1][1]="peter123";
		data[1][2]="Invalid credentials";
		
		return data;
	}

	@Test(dataProvider = "invalidLoginData")
	public void invalidLoginTest(String username, String password, String expectedError) 
	{
		driver.findElement(By.name("username")).sendKeys(username);
		driver.findElement(By.cssSelector("input[name='password']")).sendKeys(password);
		driver.findElement(By.xpath("//button[normalize-space()='Login']")).click();

		String actualError = driver.findElement(By.xpath("//p[contains(@class,'oxd-alert-content-text')]")).getText();
		Assert.assertTrue(actualError.contains(expectedError)); // expect true
	}
}
