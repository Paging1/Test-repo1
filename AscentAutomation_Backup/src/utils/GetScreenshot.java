package utils;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;


public class GetScreenshot extends GetBrowserInstance{
	
	//Captures the screenshot, taking screenshot name as parameter
	public static String capture(String screenshotName){
		TakesScreenshot screenshot = (TakesScreenshot)driver;
		File source = screenshot.getScreenshotAs(OutputType.FILE);
		String dest = System.getProperty("user.dir") + "/Error_Screenshots/" + screenshotName +".png";
		File destination = new File(dest);
		try {
			FileUtils.copyFile(source, destination);
		} catch (IOException e) {
		
			e.printStackTrace();
		}
		return dest;

	}

}
