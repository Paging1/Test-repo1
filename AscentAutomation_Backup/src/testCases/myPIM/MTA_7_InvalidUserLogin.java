package testCases.myPIM;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pageObjects.Login;
import utils.Constants;
import utils.GetBrowserInstance;
import utils.Keywords;

//This is comment

public class MTA_7_InvalidUserLogin extends GetBrowserInstance {
	GetBrowserInstance browser = new GetBrowserInstance();         	//Creating object for GetBrowserInstance class.
	Login login = new Login();										//Creating object for Login class.
	Keywords keys = new Keywords();	


	WebDriver driver;



	String User = Constants.userName;
	String pwd = Constants.password;

	@BeforeClass
	public void openBrowser(){
		driver = browser.getBrowser();
	}

	@Test
	public void InvalidUserLogin() {
		login.unSuccessfulLogin(driver,"ascent.team@gmail.com", "invalidpassword");


	}

	@AfterClass
	public void closeBrowser()
	{
		driver.close();
		driver.quit();
	}


}
