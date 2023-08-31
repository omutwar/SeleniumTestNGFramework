package tests;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class TestProperties {
	public static Logger logger = LogManager.getLogger(TestProperties.class);
	public static final String PROJECT_PATH = System.getProperty("user.dir");

	public static void main(String[] args) throws IOException {
		// Print out the project root directory
		logger.info("Printing project path: " + PROJECT_PATH);
		System.out.println(PROJECT_PATH);
		
		// Read data from config.properties file
		logger.info("Initiating properties file");
		Properties config = new Properties();
		FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"\\src\\test\\resources\\properties\\Config.properties");
		config.load(fis);
		
		
		// Read data from ObjectRepository.properties file
		Properties locators = new Properties();
		fis = new FileInputStream(System.getProperty("user.dir")+"\\src\\test\\resources\\properties\\OR.properties");
		locators.load(fis);
		
		// /SeleniumProject/src/test/resources/properties/Config.properties
		logger.info("Printing browser: " + config.getProperty("browser"));
		System.out.println(config.getProperty("browser"));
		logger.info("Printing website url: " + config.getProperty("indeed_url"));
		System.out.println(config.getProperty("indeed_url"));
		
		
		// print the locator value >> /SeleniumProject/src/test/resources/properties/ObjectRepository.properties
		logger.info("Reading locator value: " + locators.getProperty("sign_in_btn"));
		System.out.println(locators.get("sign_in_btn"));
		
//		System.out.println(config.get("implicit_wait"));
//		System.out.println(config.getProperty("implicit_wait").getClass());
	}

}
