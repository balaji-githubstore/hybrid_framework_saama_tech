package com.saama.utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropUtils {

	public static String getValue(String filePath, String key) throws IOException {
		FileInputStream file = new FileInputStream(filePath);

		Properties prop = new Properties();
		prop.load(file);

		return prop.getProperty(key);
	}
}
