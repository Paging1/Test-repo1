package utils;

import java.awt.AWTException;
import java.awt.Robot;
import java.io.File;
import java.util.UUID;

import org.apache.commons.lang3.RandomStringUtils;
//import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;




public class Keywords {
	
	WebDriver driver;
	Actions action;
	Robot robot;
	
	String downloadpathFirefox ="";

	//Method to enter text in any text field.
	public void enterText(WebDriver driver, By element , String text)
	{
		driver.findElement(element).sendKeys(text);
		
	}

	//Method to click  on any  of the web element 
	public void click(WebDriver driver, By element)
	{
		driver.findElement(element).click();
	
	}
	
	//Navigate to given URL
	public void navigate(WebDriver driver, String URL)
	{
		driver.get(URL);
	}
	
	//Method for wait.
	public void wait(WebDriver driver, By element)
	{
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(element));
	}
	
	//Method to pause the execution flow.
	public void pause(int i){
		try {
			Thread.sleep(i+000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	//Function to generate random dummy text.
	public String textgenerator(int x){
		Long.toHexString(Double.doubleToLongBits(Math.random())); 
		UUID.randomUUID().toString(); 
		RandomStringUtils.randomAlphabetic(x);
		return toString();
	}
	
	//Function to refresh current page.
	public void refresh(WebDriver driver) {
		driver.navigate().refresh();
	}
	
	
	//Function to close the driver
	public void close(WebDriver driver)
	{
	   driver.close();
	}
	
	//Function to get text from web element.
	public String getText(WebDriver driver, By element){
		
		String elementText = driver.findElement(element).getText();
		return elementText;
		
	}
	
	
	/**
	 * Method to check if actual contains expected.
	 * @param driver
	 * @param actual, type: By
	 * @param expected, type: String
	 */
	public void assertText(WebDriver driver, By actual, String expected){
		String Actual = driver.findElement(actual).getText();
		Actual.contains(expected);
	}
	
	public void assertText(WebDriver driver, String actual, String expected){
		actual.contentEquals(expected);
		
	}
	
	public void containsText(WebDriver driver, String actual, String expected)
	{
		actual.contains(expected);
	}
	
	public void containsText(WebDriver driver, By actual, String expected)
	{
		String actualTxt = driver.findElement(actual).getText();
	    Assert.assertTrue(actualTxt.contains(expected));	
	}
	
	public void textnotPresent(WebDriver driver, By actual, String expected){
		String Actual = driver.findElement(actual).getText();
		if(Actual.isEmpty()){
			System.out.println(expected+" donot matches with "+actual);
			}
		}
		

		
		
	/**
	 * Method to match actual and expected text.
	 * @param driver
	 * @param actual, type: By
	 * @param expected, type: By
	 */
	public void matchtext(WebDriver driver, By actual, By expected){
		String Actual = driver.findElement(actual).getText();
		String Expected = driver.findElement(expected).getText();
		Actual.matches(Expected);
	}

	public void dragdrop(WebDriver driver, By source, int xOffset, int yOffset){
		action = new Actions(driver);
		action.dragAndDropBy((WebElement) source, xOffset, yOffset);
	
	}
	
	public void drag(WebDriver driver, int xOffset, int yOffset) throws AWTException{
		robot = new Robot();
		robot.mouseMove(xOffset, yOffset);
	
	}
	
	private File getLatestFilefromDir(String downloadpathFirefox2) {
		
		File dir = new File(downloadpathFirefox);
	    File[] files = dir.listFiles();
	    if (files == null || files.length == 0) {
	        return null;
	    }
	
	    File lastModifiedFile = files[0];
	    for (int i = 1; i < files.length; i++) {
	       if (lastModifiedFile.lastModified() < files[i].lastModified()) {
	           lastModifiedFile = files[i];
	       }
	    }
	    return lastModifiedFile;
	}

	
	//@SuppressWarnings("deprecation")
	public void downloadFile(WebDriver driver, String browser) {
		if(browser.matches("Firefox")){
			File getLatestFile = getLatestFilefromDir(downloadpathFirefox);
		    String fileName = getLatestFile.getName();
		    Assert.assertTrue(fileName.startsWith("ExportUser"));
		    
		}
		else {
			System.out.println("Not handled for chrome yet");
		}
		
	}

	public void selectDropDownValue(WebDriver driver, By webelement ,String dropDownValue)
	{
		WebElement element = driver.findElement(webelement);
		Select dropDownElement = new Select(element);
		dropDownElement.selectByVisibleText(dropDownValue);
	}


   public void elementPresent(WebDriver driver , By element)
   {
	   boolean iselementPresent= driver.findElements(element).size()!=0;
	    if (iselementPresent==true)
	    { 
	    	System.out.println("Element is  present");
	    }
   
   }

}



