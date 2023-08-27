package tests;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

public class TestBase {
	
	/*
	 * WebDriver
	 * Properties
	 * Logs
	 * ExtendedReports
	 * DB
	 * Excel
	 * Main
	 */
	
	public static WebDriver driver;
	
	@BeforeSuite
	public void setup() {
		
		
	}
	
	@AfterSuite
	public void teardown() {
		
	}
}
