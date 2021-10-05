package pageObject;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;

public class CredentialsPage {
	
	public WebDriver driver;
	
	public CredentialsPage(WebDriver driver) {
		
	this.driver=driver;	
	
	} 
	
	By emailLocator= By.xpath("//*[@type='email']"); 
	By passwordLocator= By.xpath("//input[@id='inputPassword']");
    
			
	public WebElement returnEmail() {
	
			return driver.findElement(emailLocator);
		
	}
	
	public WebElement returnPassword() {
		
	 		return driver.findElement(passwordLocator);
	
				
	}


}
