package com.saama.test;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.saama.base.AutomationWrapper;
/*
 * Add Employee Test
 */
public class EmployeeTest extends AutomationWrapper {

	
	@Test
	public void addEmployeeTest()
	{
		driver.findElement(By.name("username")).sendKeys("Admin");
		driver.findElement(By.cssSelector("input[name='password']")).sendKeys("admin123");
		driver.findElement(By.xpath("//button[normalize-space()='Login']")).click();
		
		//Click On PIM Menu
		driver.findElement(By.xpath("//span[text()='PIM']")).click();
		
		//Click on Add Employee
		driver.findElement(By.linkText("Add Employee")).click();
		
		//Enter FirstName
		driver.findElement(By.name("firstName")).sendKeys("John");
	
		//Enter middle name 
		driver.findElement(By.name("middleName")).sendKeys("J");
		
		//Enter Lastname
		driver.findElement(By.name("lastName")).sendKeys("Wick");
		
		//Click on save 
		driver.findElement(By.xpath("//button[normalize-space()='Save']")).click();
		
		//Assert the added employee name
		String actualAddedName= driver.findElement(By.xpath("//h6[normalize-space()='John Wick']")).getText();
		Assert.assertEquals(actualAddedName, "John Wick");
		
	}
}
