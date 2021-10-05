package SeleniumFramework;

import java.io.IOException;
import java.util.Iterator;
import java.util.Set;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pageObject.CredentialsPage;
import pageObject.loginHome;
import resource.Base;

public class homePageNavigation extends Base {
	public static Logger log= LogManager.getLogger(Base.class.getName());

	//this will ensure parallel execution as noe the instance for driver is copied to our local instance and are not using same instance.
	public WebDriver driver;
	@BeforeTest
	public void driveropen() throws IOException {


		driver = driverInitialize();
		driver.get(prop.getProperty("url"));
	}

	@Test

	public void initialNavigation() {
		loginHome l = new loginHome(driver);
		l.login().click();
		CredentialsPage cd = new CredentialsPage(driver);

		Set<String> s = driver.getWindowHandles();
		Iterator<String> It = s.iterator();
		String p_id = It.next();
		String c_id = It.next();
		driver.switchTo().window(c_id);
		cd.returnEmail().sendKeys("profacc.nikita.nainwal@gmail.com");
		cd.returnPassword().sendKeys("Niki@7890");
		log.info("Password passed");
	}

	@AfterTest
	public void driverclose() {
		driver.quit();

	}

}
