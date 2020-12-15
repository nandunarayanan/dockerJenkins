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

public class HS_Login_ScreenTest
{
	public static DesiredCapabilities cap;
	public static AppiumDriver<MobileElement> driver;
	
	/*Normal User Credentials*/
	String uid = "tcsasha";
	String pwd = "asha@123";
	
	/*Administrator Credentials*/
	String admin_uid = "tcsasha";
	String admin_pwd = "asha@123";
	
	@Test(priority = 1, description = "1. Login Screen Test for credentials and parameters in the Login Page")
	public void HS_Login_Screen_TC_1() 
	{
		/*Permission Screen Continue button to navigate to Login screen*/
		MobileElement el10 = (MobileElement) driver.findElementById("com.android.permissioncontroller:id/continue_button");			
		el10.click();
		
		/*warning pop-up OK button to navigate to Login Screen*/
		MobileElement el11 = (MobileElement) driver.findElementById("android:id/button1");
		el11.click();
		
		/*checks of the Login Screen*/
		Assert.assertEquals(((driver.findElementById("com.tcs.mumbailab.heartsense:id/heartsenseVersion")).getText()),"v 1.0.19_2");
		Assert.assertEquals(((driver.findElementById("com.tcs.mumbailab.heartsense:id/tcscopyright")).getText()),"© 2019   Tata Consultancy Services Limited.");
		Assert.assertEquals(((driver.findElementById("com.tcs.mumbailab.heartsense:id/editIP")).isDisplayed()),true);
		Assert.assertEquals(((driver.findElementById("com.tcs.mumbailab.heartsense:id/editIP")).isEnabled()),true);
		Assert.assertEquals(((driver.findElementById("com.tcs.mumbailab.heartsense:id/iconImage")).isDisplayed()),true);
		Assert.assertEquals(((driver.findElementById("com.tcs.mumbailab.heartsense:id/userName")).isEnabled()),true);
		Assert.assertEquals(((driver.findElementById("com.tcs.mumbailab.heartsense:id/userName")).isDisplayed()),true);
		Assert.assertEquals(((driver.findElementById("com.tcs.mumbailab.heartsense:id/userName")).getText()),"User Name");
		Assert.assertEquals(((driver.findElementById("com.tcs.mumbailab.heartsense:id/password")).isEnabled()),true);
		Assert.assertEquals(((driver.findElementById("com.tcs.mumbailab.heartsense:id/password")).isDisplayed()),true);
		Assert.assertEquals(((driver.findElementById("com.tcs.mumbailab.heartsense:id/password")).getText()),"Password");
			/*Getting an error due to login button is not displayed due to screen */
		Assert.assertEquals(((driver.findElementById("com.tcs.mumbailab.heartsense:id/loginButton")).isEnabled()),true);
		Assert.assertEquals(((driver.findElementById("com.tcs.mumbailab.heartsense:id/loginButton")).isDisplayed()),true);
		Assert.assertEquals(((driver.findElementById("com.tcs.mumbailab.heartsense:id/loginButton")).getText()),"LOGIN");
				
		MobileElement el12 = (MobileElement) driver.findElementById("com.tcs.mumbailab.heartsense:id/userName");
		el12.sendKeys(uid);
		MobileElement ell3 = (MobileElement) driver.findElementById("com.tcs.mumbailab.heartsense:id/password");
		ell3.sendKeys(pwd);
		MobileElement el14 = (MobileElement) driver.findElementById("com.tcs.mumbailab.heartsense:id/loginButton");
		el14.click();
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
