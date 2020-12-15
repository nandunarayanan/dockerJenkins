package com.mobile.test;

import org.testng.annotations.Test;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;

import org.testng.annotations.BeforeTest;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.AfterTest;

public class HS_IP_ScreenTest 
{
	public static DesiredCapabilities cap;
	public static AppiumDriver<MobileElement> driver;
	
	String IP_1 = "192";
	String IP_2 = "168";
	String IP_3 = "20";
	String IP_4 = "101";

	String IP_Seperator = ".";
	String IP_chk_init = "Existing Server IP Address : https://";
	String IP_End = "/";
	String IP_chk = IP_chk_init+IP_1+IP_Seperator+IP_2+IP_Seperator+IP_3+IP_Seperator+IP_4+IP_End;
	
	@Test(priority = 1, description = "1. IP screen testing entered ip")
	public void HS_IP_Screen_TC_1() 
	{
		/*Permission Screen Continue button to navigate to Login screen*/
		MobileElement el0 = (MobileElement) driver.findElementById("com.android.permissioncontroller:id/continue_button");			
		el0.click();
		
		/*warning pop-up OK button to navigate to Login Screen*/
		MobileElement el1 = (MobileElement) driver.findElementById("android:id/button1");
		el1.click();
		
		/*Clicking the ip button*/
		MobileElement el2 = (MobileElement) driver.findElementById("com.tcs.mumbailab.heartsense:id/editIP");
		el2.click();
		
		/*Sending the ip to the corresponding Fields*/
		MobileElement el3 = (MobileElement) driver.findElementById("com.tcs.mumbailab.heartsense:id/editText1");
		el3.sendKeys(IP_1);
		MobileElement el4 = (MobileElement) driver.findElementById("com.tcs.mumbailab.heartsense:id/editText2");
		el4.sendKeys(IP_2);
		MobileElement el5 = (MobileElement) driver.findElementById("com.tcs.mumbailab.heartsense:id/editText3");
		el5.sendKeys(IP_3);
		MobileElement el6 = (MobileElement) driver.findElementById("com.tcs.mumbailab.heartsense:id/editText4");
		el6.sendKeys(IP_4);
		
		/*Saving*/
		MobileElement el7 = (MobileElement) driver.findElementById("com.tcs.mumbailab.heartsense:id/savebutton");
		el7.click();
		/*Closing*/
		MobileElement el8 = (MobileElement) driver.findElementById("com.tcs.mumbailab.heartsense:id/closebutton");
		el8.click();
		/*Again taking ip screen and checking the entered ip is present*/
		MobileElement el9 = (MobileElement) driver.findElementById("com.tcs.mumbailab.heartsense:id/editIP");
		el9.click();
		
		//Assert.assertEquals(((driver.findElementById("com.tcs.mumbailab.heartsense:id/existingIP")).getText()),IP_chk);
				
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
