/*
 * File Header
 * ----------
 * 
 * File Name: HS_Permission_ScreenTest.java
 * Suite xml: HS_Permission_ScreenTest.xml
 */
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

public class HS_Permission_ScreenTest 
{
	public final boolean Debug_code = false;
	public static DesiredCapabilities cap;
	public static AppiumDriver<MobileElement> driver;
	

	String Test_text = "This app was built for an older version of Android and may not work properly. Try checking for updates, or contact the developer.";
	
	/*
	 * Function Header
	 * ----------
	 * 
	 * Test Name: HS_PermissionScreen_TC_2
	 * Description: Permission Screen Test for without disabling Camera and checking the pop-ups related to it
	 */
	
	@Test(priority = 2, description = "2. Permission Screen Test for disabling Camera", dependsOnMethods = "HS_PermissionScreen_TC_1")
	public void HS_PermissionScreen_TC_2() 
	{
		try
		{					  
			System.out.println("Heart Sense Application started & loaded permission Page !!!!");
			System.out.println("Without Disabling Camera trying to continue..");
			
			String Test_text2 = "Choose what to allow HeartSense to access";
			/*Checking the Permission screen parameters*/
			Assert.assertEquals(((driver.findElementById("com.android.permissioncontroller:id/permissions_message")).getText()),Test_text2);			
			Assert.assertEquals(((driver.findElementById("com.android.permissioncontroller:id/continue_button")).getText()),"Continue");
			Assert.assertEquals(((driver.findElementById("com.android.permissioncontroller:id/cancel_button")).getText()),"Cancel");
			Assert.assertEquals(((driver.findElementById("com.android.permissioncontroller:id/continue_button")).isEnabled()),true);
			Assert.assertEquals(((driver.findElementById("com.android.permissioncontroller:id/cancel_button")).isEnabled()),true);
			
			/*Permission Screen clicking continue button*/
			MobileElement el23 = (MobileElement) driver.findElementById("com.android.permissioncontroller:id/continue_button");				
			el23.click();
			
			/*checking the pop-up message Window*/
			Assert.assertEquals(((driver.findElementById("android:id/message")).getText()),Test_text);
			Assert.assertEquals(((driver.findElementById("android:id/alertTitle")).getText()),"HeartSense");			
			Assert.assertEquals(((driver.findElementById("android:id/button1")).getText()),"OK");
			Assert.assertEquals(((driver.findElementById("android:id/button3")).getText()),"Check for update");
			Assert.assertEquals(((driver.findElementById("android:id/button1")).isEnabled()),true);
			Assert.assertEquals(((driver.findElementById("android:id/button3")).isEnabled()),true);
			/*Clicking the ok button*/
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
	
	/*
	 * Function Header
	 * ----------
	 * 
	 * Test Name: HS_PermissionScreen_TC_1
	 * Description: Permission Screen Test for disabling Camera and checking the pop-ups related to it 
	 */
	
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
			/*checking the pop-up message Window*/
			String Test_text1 = "This app was designed for an older version of Android. Denying permission may cause it to no longer function as intended.";
			Assert.assertEquals(((driver.findElementById("android:id/message")).getText()),Test_text1);
			Assert.assertEquals(((driver.findElementById("android:id/button1")).isEnabled()),true);
			Assert.assertEquals(((driver.findElementById("android:id/button2")).isEnabled()),true);
			Assert.assertEquals(((driver.findElementById("android:id/button2")).getText()),"Cancel");
			Assert.assertEquals(((driver.findElementById("android:id/button1")).getText()),"Deny anyway");
			/*Clicking Deny button*/
			MobileElement el12 = (MobileElement) driver.findElementById("android:id/button1");
			el12.click();
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
		cap.setCapability("app", "https://github.com/nandunarayanan/apk/blob/main/heartsense_16_dec_20_1_0_19_2_CHEAT.apk?raw=true");
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
		driver.quit();
	}

}
