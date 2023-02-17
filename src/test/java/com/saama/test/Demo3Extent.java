package com.saama.test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class Demo3Extent {
	
	public static void main(String[] args) {
		
		
		//should runs once before triggering any of the @Test method - @BeforeSuite
		ExtentReports extent = new ExtentReports();
		ExtentSparkReporter spark = new ExtentSparkReporter("target/Spark.html");
		extent.attachReporter(spark);
		
		
		
		//before the @Test method trigger - @BeforeMethod
		ExtentTest test= extent.createTest("MyFirstTest-BALA");
		
		//runs @Test method
		
		//after the @Test method completed - @AfterMethod 
		test.log(Status.PASS, "This is a logging event for MyFirstTest, and it passed! DONE BY BALAJI");
		
		
		
		
		//should run at the end of all @Test method - AfterSuite
		extent.flush();
		
		
	}

}
