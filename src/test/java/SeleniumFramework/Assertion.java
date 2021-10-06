package SeleniumFramework;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pageObject.loginHome;
import resource.Base;

public class Assertion extends Base {
	
	public static Logger log= LogManager.getLogger(Base.class.getName());
 
	//this will ensure parallel execution as noe the instance for driver is copied to our local instance and are not using same instance.
	public WebDriver driver;

	@BeforeTest
	public void openbrowser() throws IOException {

		driver = driverInitialize();
		log.info("Driver called");

		driver.get(prop.getProperty("url"));
		log.info("Navigated to URL");
	
	}

	@Test

	public void assertionTest(){

		loginHome as = new loginHome(driver);
		Assert.assertEquals(as.returntext().getText(), "PHPTRAVELS");
		log.info("Checked for Equality");

		Assert.assertTrue(as.returnnav().isDisplayed()); // it expects that what condition is passed is true. if not
		// present it'll pass error

		log.info("Checked for navigation");

	}
	
	
	@AfterTest
	public void atest() {
		System.out.print("hi");
		
	}

	@AfterTest
	public void browserclose() {

		driver.quit();
		log.info("Browser Closed");
	

	}

}
