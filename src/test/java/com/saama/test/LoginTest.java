package com.saama.test;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.saama.base.AutomationWrapper;
/**
 * 
 * @author Balaji Dinakaran
 *
 */
public class LoginTest extends AutomationWrapper {
	
	@Test
	public void validLoginTest()
	{
		driver.findElement(By.name("username")).sendKeys("Admin");
		driver.findElement(By.cssSelector("input[name='password']")).sendKeys("admin123");
		driver.findElement(By.xpath("//button[normalize-space()='Login']")).click();
		
		String actualHeader= driver.findElement(By.xpath("//h6[normalize-space()='Dashboard']")).getText();
		Assert.assertEquals(actualHeader, "Dashboard");
	}
	
	@Test
	public void invalidLoginTest()
	{
		driver.findElement(By.name("username")).sendKeys("john");
		driver.findElement(By.cssSelector("input[name='password']")).sendKeys("admin123");
		driver.findElement(By.xpath("//button[normalize-space()='Login']")).click();
		
		String actualError=driver.findElement(By.xpath("//p[contains(@class,'oxd-alert-content-text')]")).getText();
		Assert.assertTrue(actualError.contains("Invalid credentials")); //expect true
	}
}
