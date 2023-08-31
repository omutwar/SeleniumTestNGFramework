package utils;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class DataReader {
	private static Properties property;

	static {
		try {
			// /SeleniumTestNGFramework/src/test/resources/properties/Config.properties
			File file = new File("./src/test/resources/properties/Config.properties");
			FileInputStream input = new FileInputStream(file);
			property = new Properties();
			property.load(input);
			input.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static String getProperty(String key) {
		return property.getProperty(key);
	}

}
