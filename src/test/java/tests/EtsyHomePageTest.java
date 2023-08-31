package tests;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pages.EtsyHomePage;
import utils.BrowserUtils;
import utils.Driver;

public class EtsyHomePageTest {
	private static Logger log = LogManager.getLogger(EtsyHomePageTest.class);
	private static Properties config = new Properties();
	private static FileInputStream fis;
	private static WebDriver driver;
	private static BrowserUtils utils;
	private static EtsyHomePage etsyHomePage = new EtsyHomePage();
	
	@BeforeTest(alwaysRun = true)
	public static void setup() {
		log.info("** <setup> hook initializing the driver object");
		System.out.println(System.getProperty("user.dir")+"\\src\\test\\resources\\properties\\Config.properties");
		try {
			// /SeleniumTestNGFramework/src/test/resources/properties/Config.properties
			fis = new FileInputStream(System.getProperty("user.dir")+"\\src\\test\\resources\\properties\\Config.properties");
			config.load(fis);
		} catch (IOException e) {
			log.error("*** Reading Config Properties File Has Failed: ", e);
			e.printStackTrace();
		}
		driver = Driver.getDriver();
		utils = new BrowserUtils();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.manage().window().maximize();
	}
	
	@Test
	public static void navCategoryTest() {
		log.info("Check the navigation page is displaying correctly");
		System.out.println(config.getProperty("etsy_url"));
		driver.get(config.getProperty("etsy_url"));
		
		utils.waitForElementsToBeDisplayed(etsyHomePage.home_page_top_nav_categories);
		System.out.println("Number of categories displayed at the top of the page is: "+ etsyHomePage.home_page_top_nav_categories.size());
		etsyHomePage.home_page_top_nav_categories.forEach(cat -> System.out.println(cat.getText()));
		
		etsyHomePage.home_page_top_nav_categories.get(4).click();
	}
	
	@AfterTest(alwaysRun = true)
	public static void teardown() {
		log.info("*** <teardown> Method Has Been Executed");
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			log.info("- Added Thread.sleep to give a few seconds of lag time");
			e.printStackTrace();
		}
		driver.quit();
	}

}
