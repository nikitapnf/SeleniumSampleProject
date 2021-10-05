package resource;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.google.common.io.Files;

public class Base {
	
	   public WebDriver driver; 
	   public Properties prop;
	public WebDriver driverInitialize() throws IOException {
		prop= new Properties();
		FileInputStream fileinput= new FileInputStream("D:\\Projects\\Selenium\\SampleProject\\src\\main\\java\\resource\\data.properties");
	    prop.load(fileinput);	
	    String browserSelect=prop.getProperty("browser"); 
	    
	    System.out.println(browserSelect);
	    
	    if(browserSelect.startsWith("chr"))   	
	    	
	    {
	    	System.setProperty("webdriver.chrome.driver", "C://Work//Drivers//chromedriver.exe");
	    	driver= new ChromeDriver();
	    		  
	    }
	    
	    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	   	 return driver;

	}
	
	public void getScreenShot(String tcname, WebDriver driver) throws IOException {
		//this sc variable is responsible to capture ss
		TakesScreenshot sc= (TakesScreenshot) driver;
		//At this stage ss have been taken but it is at a virtual location we have to save it in local file
		File f_Scource=sc.getScreenshotAs(OutputType.FILE);
		//will give location of your current project path
		String destFile= System.getProperty("user.dir")+"\\reports\\"+tcname+".png";
			FileUtils.copyFile(f_Scource, new File(destFile));
	}
	

}
