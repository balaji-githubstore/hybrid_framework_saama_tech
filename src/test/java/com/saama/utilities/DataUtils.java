package com.saama.utilities;

import java.io.IOException;
import java.lang.reflect.Method;

import org.testng.annotations.DataProvider;

public class DataUtils {

	@DataProvider
	public Object[][] commonDataProvider(Method method) throws IOException 
	{
		// currentTestMethodName is the sheetname
		
		String currentTestMethodName = method.getName();
		Object[][] data = ExcelUtils.getSheetIntoTwoDimArray("test_data/orange_test_data.xlsx", currentTestMethodName);
		return data;
	}

	@DataProvider
	public Object[][] invalidLoginData() {
		Object[][] data = new Object[2][3];
		// i->number of testcase
		// j->number of parameters

		data[0][0] = "john";
		data[0][1] = "john123";
		data[0][2] = "Invalid credentials";

		data[1][0] = "peter";
		data[1][1] = "peter123";
		data[1][2] = "Invalid credentials";

		return data;
	}

	@DataProvider
	public Object[][] addEmployeeData() {
		Object[][] data = new Object[2][6];

		data[0][0] = "Admin";
		data[0][1] = "admin123";
		data[0][2] = "Saul";
		data[0][3] = "K";
		data[0][4] = "Goodman";
		data[0][5] = "Saul Goodman";

		data[1][0] = "Admin";
		data[1][1] = "admin123";
		data[1][2] = "Peter";
		data[1][3] = "ken";
		data[1][4] = "Henry";
		data[1][5] = "Peter Henry";

		return data;
	}

}
