package SeleniumFramework;

import java.io.IOException;
import java.util.Iterator;
import java.util.Set;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageObject.CredentialsPage;
import pageObject.loginHome;
import resource.Base;

public class textNGparameterizing extends Base {
	public static Logger log= LogManager.getLogger(Base.class.getName());

	//this will ensure parallel execution as noe the instance for driver is copied to our local instance and are not using same instance.
	public WebDriver driver;

	@BeforeTest
	public void driveropen() throws IOException {
		driver = driverInitialize();
		driver.get(prop.getProperty("url"));

	}

	@Test(dataProvider = "setdata")

	public void initialNavigation(String mail, String pass) {

		loginHome l = new loginHome(driver);
		l.login().click();
		CredentialsPage cd = new CredentialsPage(driver);

		Set<String> s = driver.getWindowHandles();
		Iterator<String> It = s.iterator();
		String p_id = It.next();
		String c_id = It.next();
		driver.switchTo().window(c_id);
		cd.returnEmail().sendKeys(mail);
		cd.returnPassword().sendKeys(pass);
		log.info("Password passed");

	}

	@DataProvider
	public Object[][] setdata() {

		Object[][] data = new Object[2][2];// [1][1] cauz we'll be providing 2 data values 2 time(different) so 2 rows
											// and two columns 0 and 1 that's what 1,1
		// Array size is 2 but the index will be 0 and 1
		data[0][0] = " profacc.nikita.nainwal@gmail.com";// data in 1st row 1st column
		data[0][1] = "Niki@7890";

		data[1][0] = "nikitanainwal1997@gmail.com";
		data[1][1] = "Niki@7890";

		return data;

	}

	@AfterTest
	public void closedriver() {

		driver.quit();

	}

}
