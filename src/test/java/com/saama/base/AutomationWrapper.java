package com.saama.base;

import java.io.IOException;
import java.lang.reflect.Method;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.saama.utilities.PropUtils;

public class AutomationWrapper {

	protected WebDriver driver;

	private ExtentReports extent;
	protected ExtentTest test;

	@BeforeSuite
	public void init() {
		extent = new ExtentReports();
		ExtentSparkReporter spark = new ExtentSparkReporter("target/Spark.html");
		extent.attachReporter(spark);
	}

	@AfterSuite
	public void end() {
		extent.flush();
	}

	@BeforeMethod(alwaysRun = true)
	@Parameters({ "browser" })
	public void setup(@Optional("edge") String browserName, Method method) throws IOException {

		test = extent.createTest(method.getName());
		
		//high preference to properties file
		if(!PropUtils.getValue("test_data/data.properties", "browser").equalsIgnoreCase("na"))
		{
			browserName=PropUtils.getValue("test_data/data.properties", "browser");
		}


		if (browserName.equalsIgnoreCase("ff")) {
			driver = new FirefoxDriver();
		} else if (browserName.equalsIgnoreCase("edge")) {
			driver = new EdgeDriver();
		} else {
//			System.setProperty("webdriver.chrome.driver", "driver/chromedriver.exe");
			driver = new ChromeDriver();
		}

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		
		String baseUrl=PropUtils.getValue("test_data/data.properties", "url");
		
		driver.get(baseUrl);
	}

	@AfterMethod(alwaysRun = true)
	public void teardown(ITestResult result) {

		if (result.getStatus() == ITestResult.FAILURE) {
			test.log(Status.FAIL, MarkupHelper.createLabel(result.getName() + " FAILED ", ExtentColor.RED));
			test.fail(result.getThrowable());
		} else if (result.getStatus() == ITestResult.SUCCESS) {
			test.log(Status.PASS, MarkupHelper.createLabel(result.getName() + " PASSED ", ExtentColor.GREEN));
		} else {
			test.log(Status.SKIP, MarkupHelper.createLabel(result.getName() + " SKIPPED ", ExtentColor.ORANGE));
			test.skip(result.getThrowable());
		}

		driver.quit();
	}

}
