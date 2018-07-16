package utils;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;



public class GetBrowserInstance {

	protected static  WebDriver driver;
	
	private String browsername = Constants.Browser;           //Gets browser name from Constants file for which test needs to be executed.
	
	
	public static Logger Log = Logger.getLogger(GetBrowserInstance.class.getName());  //Initializing logger class.
	
	//Checks which browser needs to be invoked.
	public WebDriver getBrowser()
	{
		
		if(browsername.equals("Firefox"))
			driver= launchFirefox();
		else if(browsername.equals("Chrome"))
			driver = launchChrome();
		
		return driver;
		
	}

	//Function to launch Firefox.
	public WebDriver launchFirefox()
	{
		System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir")+"\\Drivers\\geckodriver.exe");
		driver = new FirefoxDriver();
		return driver;
	}

	//function to launch Chrome Browser.
	public WebDriver launchChrome()
	{
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\Drivers\\chromedriver.exe");
		Log.error("For testing purpose only, throwing uncollectable error");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		return driver;
	}
	
	public String getBrowserUrl()
	{
		return driver.getCurrentUrl();
		
	}
	
	//Function will close the browser.
	/*@AfterClass
	public void closeBrowser(){
		driver.quit();
	}*/

}
