package com.javarticles.yaml;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.util.HashMap;
import java.util.Map;
import java.net.URL;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import java.util.HashMap;
import java.util.Map;

import io.appium.java_client.android.AndroidDriver;
import org.apache.commons.io.FileUtils;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.yaml.snakeyaml.Yaml;

import com.google.common.io.ByteStreams;

class diff_library
{
	public static void yamlWrite( Map<String, Object> map, String path) throws IOException
    {
		Yaml yaml = new Yaml();
    	diff_library yamlWrt = new diff_library();
    	
    	
    	FileWriter writer = new FileWriter(path);
    	yaml.dump(map, writer);
    	
    }
	
	public static Map<String, String> yamlRead(String FilePath) throws IOException
    {
    	Yaml yaml = new Yaml();
    	diff_library yamlWrite = new diff_library();
    	
    	Map<String, String> map = (Map<String, String>) yaml.load(new FileInputStream(new File(FilePath)));
    	return map;
    }
}

 class screenshot
{
	 static String destDir;
	 static DateFormat dateFormat;
	 static Dimention size;
	 public static void captureScreenshot(String imageName,AppiumDriver<MobileElement> driver)
	 {
		 //set folder name to store screenshots
		 destDir = "screenshot";
		 //capture screenshot
		 File srcFile = ((TakeScreenshot) driver).getScreenshotAs(OutputType.FILE);
		 //set Date format
		 dateFormat = new SimpleDateFormat("dd-MMM-yyyy__hh_mm_ssaa");
		 //create folder under project with name "screenshots"
		 new File(destDir).mkdirs();
		 //Set file name
		 String destFIle = imageName+ dateFormat.format(new Date()) + ".png";
		 
		 try {
			 //copy paste file at destination folder location
			 FileUtils.copyFile(scrFile, new File(destDir + "/" + destFile));
			 
		 }
		 catch (IOException e) {
			 e.printStackTrace();
		 }
	 }
}

