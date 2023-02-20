package com.saama.test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import com.saama.utilities.PropUtils;

public class Demo4Properties {

	public static void main(String[] args) throws IOException {
		
		FileInputStream file=new FileInputStream("test_data/data.properties");

		Properties prop=new Properties();
		prop.load(file);
		
		String value=prop.getProperty("browser");
		System.out.println(value);
		
		
		String baseUrl=PropUtils.getValue("test_data/data.properties", "url");
		System.out.println(baseUrl);
	}

}
