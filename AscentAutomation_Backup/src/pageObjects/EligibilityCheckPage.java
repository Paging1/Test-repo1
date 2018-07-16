package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import utils.GetBrowserInstance;
import utils.Keywords;

public class EligibilityCheckPage  extends GetBrowserInstance 
{
	Keywords keys = new Keywords();
	 
	//...............Page objects for eligibility check...................
	public By school_state = By.id("school_state");
	public By school_list= By.xpath("//*[@role='presentation']");
    public By cosigner= By.id("has_cosigner");
    public By loan_amount= By.xpath("//input[@placeholder='Type loan amount']");
    public By cancel_btn = By.name("cancel");
    public By ReApply_Btn= By.xpath("//*[@data-hover='ReApply']");
    public By school_search_field = By.xpath("//input[@type='search']");
    public By selected_school= By.className("select2-results");   
    public By confirm_btn=By.xpath("//input[@value='Confirm']");
    public By health_product=By.xpath(".//img[contains(@src,'Producttext-3')]");
    public By tution_product=By.xpath("//img[contains(@src,'Producttext-2')]");
    public By independent_product=By.xpath(".//img[contains(@src,'Producttext-1')]");
    public By product_cancel_btn= By.xpath("(//input[@value='Cancel'])[2]");
    

   //............Page functions.....................
    public void reApply_Btn()
    {
    	keys.click(driver, ReApply_Btn);
    	keys.pause(2000);
        keys.click(driver,cancel_btn); 
        keys.enterText(driver,loan_amount,"10000");
    }
    
    public void ConfirmProduct(String val_product)
    
    { 
    	keys.elementPresent(driver, health_product);
        keys.elementPresent(driver,tution_product);
        keys.elementPresent(driver, independent_product);
    }
  
    public void eligibilityTest(String val_school_state,String val_school_search_field, String val_cosigner)
  
    {
        keys.selectDropDownValue(driver,school_state, val_school_state);
	    keys.pause(2000);
	    keys.click(driver,school_list);
	    keys.enterText(driver,school_search_field, val_school_search_field);
	    keys.click(driver,selected_school);
        keys.selectDropDownValue(driver,cosigner,val_cosigner);
	    keys.click(driver,confirm_btn);
	    keys.pause(2000);
	    keys.click(driver,product_cancel_btn);
	
 }








}
