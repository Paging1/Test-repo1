package testCases.myPIM;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pageObjects.EligibilityCheckPage;
import pageObjects.Login;
import utils.Constants;
import utils.GetBrowserInstance;
import utils.Keywords;

public class EligibilityCheck extends GetBrowserInstance{

	GetBrowserInstance browser = new GetBrowserInstance(); 
	Login login = new Login();										//Creating object for Login class.
	Keywords keys = new Keywords();	
	EligibilityCheckPage eligibilitycheckpage= new EligibilityCheckPage();

	String User = Constants.userName;
	String pwd = Constants.password;

	@BeforeClass
	public void openBrowser()
	{
		driver = browser.getBrowser();
	}

	@Test
	public void ValidUserLogin() 
	{
		login.login(driver,User, pwd);
	}

	@Test
	public void healthEligibiltyTest()
	{
		eligibilitycheckpage.reApply_Btn();
		eligibilitycheckpage.eligibilityTest("CO", "Denver College of Nursing", "Without a Cosigner");
		eligibilitycheckpage.eligibilityTest("AL", "University of Alabama at Birmingham", "Without a Cosigner");
	    eligibilitycheckpage.eligibilityTest("AL", "University of Alabama at Birmingham", "With a Cosigner");
	}

}












