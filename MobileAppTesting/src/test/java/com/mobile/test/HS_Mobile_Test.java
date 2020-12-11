package com.mobile.test;

import org.testng.annotations.Test;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;

public class HS_Mobile_Test 
{
	public final boolean Debug_code = false;
	public static DesiredCapabilities cap;
	public static AppiumDriver<MobileElement> driver;
	

	String Test_text = "This app was built for an older version of Android and may not work properly. Try checking for updates, or contact the developer.";
	
	
	@Test(priority = 3, description = "3. Permission Screen Test Case for disabling Microphone")
	public void HS_PermissionScreen_TC_3() 
	{
		try
		{					  
			System.out.println("Heart Sense Application started & loaded permission Page !!!!");
			System.out.println("Disabling Microphone..");
			
			/*Permission Screen while disabling a pop-window will appear and clicking deny anyway*/
			MobileElement el31 = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.recyclerview.widget.RecyclerView/android.widget.LinearLayout[3]/android.widget.LinearLayout[2]/android.widget.Switch");
			el31.click();
			MobileElement el32 = (MobileElement) driver.findElementById("android:id/button1");
			el32.click();
			/*Permission Screen clicking continue button*/
			MobileElement el33 = (MobileElement) driver.findElementById("com.android.permissioncontroller:id/continue_button");
				
			el33.click();
			/*Pop-up message Window*/
			Assert.assertEquals(((driver.findElementById("android:id/message")).getText()),Test_text);
			MobileElement el34 = (MobileElement) driver.findElementById("android:id/button1");
			el34.click();
		}
		catch (Exception e) 
		{

			System.out.println("Error Cause is:- "+e.getCause());
			System.out.println("Error Message is:- "+e.getMessage());
			e.printStackTrace();
		}
		
	}
	
	@Test(priority = 2, description = "2. Permission Screen Test Case for disabling Storage")
	public void HS_PermissionScreen_TC_2() 
	{
		try
		{					  
			System.out.println("Heart Sense Application started & loaded permission Page !!!!");
			System.out.println("Disabling Storage..");
			
			/*Permission Screen while disabling a pop-window will appear and clicking deny anyway*/
			MobileElement el21 = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.recyclerview.widget.RecyclerView/android.widget.LinearLayout[2]/android.widget.LinearLayout[2]/android.widget.Switch");
			el21.click();
			MobileElement el22 = (MobileElement) driver.findElementById("android:id/button1");
			el22.click();
			
			/*Permission Screen clicking continue button*/
			MobileElement el23 = (MobileElement) driver.findElementById("com.android.permissioncontroller:id/continue_button");				
			el23.click();
			
			/*Pop-up message Window*/
			Assert.assertEquals(((driver.findElementById("android:id/message")).getText()),Test_text);
			MobileElement el24 = (MobileElement) driver.findElementById("android:id/button1");
			el24.click();
		}
		catch (Exception e) 
		{

			System.out.println("Error Cause is:- "+e.getCause());
			System.out.println("Error Message is:- "+e.getMessage());
			e.printStackTrace();
		}
		
	}
	
	@Test(priority = 1, description = "1. Permission Screen Test for disabling Camera")
	public void HS_PermissionScreen_TC_1() 
	{
		try
		{					  
			System.out.println("Heart Sense Application started & loaded permission Page !!!!");
			System.out.println("Disabling Camera..");
			
			/*Permission Screen while disabling a pop-window will appear and clicking deny anyway*/
			MobileElement el11 = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.recyclerview.widget.RecyclerView/android.widget.LinearLayout[1]/android.widget.LinearLayout[2]/android.widget.Switch");
			el11.click();
			MobileElement el12 = (MobileElement) driver.findElementById("android:id/button1");
			el12.click();
			/*Permission Screen clicking continue button*/
			MobileElement el13 = (MobileElement) driver.findElementById("com.android.permissioncontroller:id/continue_button");

			//if(driver.findElementsById("com.android.permissioncontroller:id/continue_button").size()!=0)
				
			el13.click();
			/*Pop-up message Window*/
			Assert.assertEquals(((driver.findElementById("android:id/message")).getText()),Test_text);
			MobileElement el14 = (MobileElement) driver.findElementById("android:id/button1");
			el14.click();
		}
		catch (Exception e) 
		{

			System.out.println("Error Cause is:- "+e.getCause());
			System.out.println("Error Message is:- "+e.getMessage());
			e.printStackTrace();
		}
	}
	
	@BeforeTest
	public void setUp()
	{
	  	System.out.println("Setting up desired capabilities");
	  	cap = new DesiredCapabilities();
		cap.setCapability("username", "SAUCE_USERNAME");
		cap.setCapability("accessKey", "SAUCE_ACCESS_KEY");
		cap.setCapability("deviceName", "Samsung_Galaxy_S9_free");
		cap.setCapability("deviceOrientation", "portrait");
		cap.setCapability("browserName", "");
		cap.setCapability("platformVersion", "10");
		cap.setCapability("platformName", "Android");
		cap.setCapability("app", "https://github.com/nandunarayanan/apk/blob/main/heartsense_19_feb_19_1_0_19_2.apk?raw=true");
		cap.setCapability("appPackage", "com.tcs.mumbailab.heartsense");
		cap.setCapability("appActivity", "com.tcs.mumbailab.heartsense.LoginActivity");
		
		System.out.println("Trying to connect the Application......");  
		
		try
		{
			URL url;
			url = new URL("https://bastin:7b287c70-064e-432c-b9b4-c570ca11d3bd@ondemand.us-west-1.saucelabs.com:443/wd/hub");
			System.out.println("Setting up the URL...........");
			driver = new AppiumDriver<MobileElement>(url,cap);		  
			System.out.println("Heart Sense Application started!!!!");
		}
		catch (MalformedURLException e) 
		{
			System.out.println("Error Cause is:- "+e.getCause());
			System.out.println("Error Message is:- "+e.getMessage());
			e.printStackTrace();
		}
		
  }
	@AfterTest
	public void tearDown()
	{
		//driver.close();
		driver.quit();
	}

}
