package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;

//1st web pages's POM
public class loginHome {

	public WebDriver driver;

	public loginHome(WebDriver driver) {
		this.driver = driver;
	}

	By loginLocate = By.linkText("Login");
	By text= By.id("PHPTRAVELS");
	By navbar= By.className("clearfix");
	
	public WebElement login() {

		return driver.findElement(loginLocate);

	}
	
	public WebElement returntext()
	
	{
		return driver.findElement(text);
		
		
	}
	
	public WebElement returnnav() {
		
     return driver.findElement(navbar);		
			
		
	}
	
	
	
	
	
}
