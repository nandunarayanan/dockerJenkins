import io.appium.java_client.android.AndroidDriver;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.apache.commons.io.FileUtils;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;

public class screenshotLib
{
	 static String destDir;
	 static DateFormat dateFormat;
	 static Dimension size;
	 public static void captureScreenshot(String imageName,AppiumDriver<MobileElement> driver)
	 {
		 //set folder name to store screenshots
		 destDir = "screenshot";
		 //capture screenshot
		 File srcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		 //set Date format
		 dateFormat = new SimpleDateFormat("dd-MMM-yyyy__hh_mm_ssaa");
		 //create folder under project with name "screenshots"
		 new File(destDir).mkdirs();
		 //Set file name
		 String destFile = imageName+ dateFormat.format(new Date()) + ".png";
		 
		 try {
			 //copy paste file at destination folder location
			 FileUtils.copyFile(srcFile, new File(destDir + "/" + destFile));
			 
		 }
		 catch (IOException e) {
			 e.printStackTrace();
		 }
	 }
}