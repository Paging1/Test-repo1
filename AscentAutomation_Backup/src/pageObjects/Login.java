package pageObjects;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import utils.Constants;
import utils.Keywords;
import utils.GetBrowserInstance;

public class Login extends GetBrowserInstance 
{
    
	Keywords keys = new Keywords();

	//----------------------- Page Objects ----------------------
	//Page objects for login function:
	
	public By username = By.xpath("//input[@name='email']");
	public By password = By.xpath("//input[@name='password']");
	public By Login_btn = By.xpath("//button[@type='submit'][1]");
	public By error= By.xpath("//*[@id='email-error']");
	public String errorMessage= "These credentials do not match our records.";


	
	//Page objects for logout function:
	
	public By nav_menu= By.className("full_name");
	public By logout_link=By.xpath("//span[contains(text(),'LOG OUT')]");
	


	//--------------------Page functions -----------------------------


	public void login(WebDriver driver,String User, String pwd)


	{
	   driver.get(Constants.BaseURL);
	    keys.enterText(driver, username, User);
		keys.enterText(driver,password , pwd);
		keys.click(driver, Login_btn);
		keys.pause(2);
		String currentURL= driver.getCurrentUrl();
		keys.containsText(driver,currentURL, Constants.DASH_URL);
	}
	
	public void unSuccessfulLogin(WebDriver driver, String User, String pwd)
	{
		driver.get(Constants.BaseURL);
		keys.enterText(driver, username, User);
		keys.enterText(driver,password , pwd);
		keys.click(driver, Login_btn);
		keys.wait(driver, error);
		keys.containsText(driver, error, errorMessage);
			
	}

	public void logout(WebDriver driver)
	{
		keys.click(driver,nav_menu);
		keys.click(driver,logout_link);
	}

}
