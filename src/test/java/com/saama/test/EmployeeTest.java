package com.saama.test;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.saama.base.AutomationWrapper;
import com.saama.pages.LoginPage;
import com.saama.pages.MainPage;
import com.saama.utilities.DataUtils;
/*
 * Add Employee Test
 */
public class EmployeeTest extends AutomationWrapper {

	@Test(dataProviderClass = DataUtils.class,dataProvider = "commonDataProvider",groups = {"smoke"})
	public void addEmployeeTest(String username,String password,String firstName,String middleName,String lastName,String expectedName)
	{
		LoginPage loginPage=new LoginPage(driver);
		loginPage.enterUsername(username);
		loginPage.enterPassword(password);
		loginPage.clickOnLogin();
		
		//Click On PIM Menu
		MainPage mainPage=new MainPage(driver);
		mainPage.clickOnPIMMenu();
		
		//Click on Add Employee
		driver.findElement(By.linkText("Add Employee")).click();
		
		//Enter FirstName
		driver.findElement(By.name("firstName")).sendKeys(firstName);
	
		//Enter middle name 
		driver.findElement(By.name("middleName")).sendKeys(middleName);
		
		//Enter Lastname
		driver.findElement(By.name("lastName")).sendKeys(lastName);
		
		//Click on save 
		driver.findElement(By.xpath("//button[normalize-space()='Save']")).click();
		
		//Assert the added employee name
		String actualAddedName= driver.findElement(By.xpath("//h6[normalize-space()='"+expectedName+"']")).getText();
		Assert.assertEquals(actualAddedName, expectedName);
		
	}
}
