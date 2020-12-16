/*
 * File Header
 * ----------
 * 
 * File Name: HS_IP_ScreenTest.java
 * Suite xml: HS_IP_ScreenTest.xml
 */

package com.mobile.test;

import org.testng.annotations.Test;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.AfterTest;

public class HS_IP_ScreenTest 
{
	public static DesiredCapabilities cap;
	public static AppiumDriver<MobileElement> driver;
	
	String IP_Seperator = ".";
	String IP_chk_init = "Existing Server IP Address :\nhttps://";
	String IP_End = "/";
	/*Parameterized ip for the input fields*/
	
	/*
	 * Function Header
	 * ----------
	 * 
	 * Test Name: HS_IP_Screen_TC_1
	 * Description: IP screen testing with parameterized ip fields input with parameterized functionality of TestNG
	 */
	
	@Parameters({"IP_1","IP_2","IP_3","IP_4"})
	@Test(priority = 0, description = "1. IP screen testing with parameterized ip fields input")
	public void HS_IP_Screen_TC_1(String i1,String i2,String i3,String i4) 
	{
		String IP_chk = IP_chk_init+(i1)+IP_Seperator+i2+IP_Seperator+i3+IP_Seperator+i4+IP_End;
		
		/*Permission Screen Continue button to navigate to Login screen*/		
		MobileElement el10 = (MobileElement) driver.findElementById("com.android.permissioncontroller:id/continue_button");			
		el10.click();
		
		
		/*warning pop-up OK button to navigate to Login Screen*/
		
		MobileElement el11 = (MobileElement) driver.findElementById("android:id/button1");
		el11.click();
		
		/*Clicking the ip button*/
		MobileElement el12 = (MobileElement) driver.findElementById("com.tcs.mumbailab.heartsense:id/editIP");
		el12.click();
		
		/*Sending the ip to the corresponding Fields*/
		MobileElement el13 = (MobileElement) driver.findElementById("com.tcs.mumbailab.heartsense:id/editText1");
		el13.sendKeys(i1);
		MobileElement el14 = (MobileElement) driver.findElementById("com.tcs.mumbailab.heartsense:id/editText2");
		el14.sendKeys(i2);
		MobileElement el15 = (MobileElement) driver.findElementById("com.tcs.mumbailab.heartsense:id/editText3");
		el15.sendKeys(i3);
		MobileElement el16 = (MobileElement) driver.findElementById("com.tcs.mumbailab.heartsense:id/editText4");
		el16.sendKeys(i4);
		
		/*Saving*/
		MobileElement el17 = (MobileElement) driver.findElementById("com.tcs.mumbailab.heartsense:id/savebutton");
		el17.click();
		/*Closing*/
		MobileElement el18 = (MobileElement) driver.findElementById("com.tcs.mumbailab.heartsense:id/closebutton");
		el18.click();
		/*Again taking ip screen and checking the entered ip is present*/
		MobileElement el19 = (MobileElement) driver.findElementById("com.tcs.mumbailab.heartsense:id/editIP");
		el19.click();
		

		/*Verifying the saved ip is displayed in the screen or not*/
		Assert.assertEquals(((driver.findElementById("com.tcs.mumbailab.heartsense:id/existingIP")).getText()),IP_chk);
		System.out.println("IP Verification Done!!");			

		/*Closing*/
		el18.click();
	}
	
	/*
	 * Function Header
	 * ----------
	 * 
	 * Test Name: HS_IP_Screen_TC_0
	 * Description: IP screen testing of the contents present in the screen; are they as per the SRS
	 */
	
	@Test(priority = 1, description = "0. IP screen testing of the contents present in the screen; are they as per the SRS")
	public void HS_IP_Screen_TC_0() 
	{
			
		/*Clicking the ip button*/
		MobileElement el12 = (MobileElement) driver.findElementById("com.tcs.mumbailab.heartsense:id/editIP");
		el12.click();
		
		
		//String Ex_IP = "Existing Server IP Address:\n";
		//Assert.assertEquals(((driver.findElementById("com.tcs.mumbailab.heartsense:id/existingIP")).getText()),Ex_IP);
		Assert.assertEquals(((driver.findElementById("com.tcs.mumbailab.heartsense:id/existingIP")).isDisplayed()),true);
		Assert.assertEquals(((driver.findElementById("com.tcs.mumbailab.heartsense:id/savebutton")).getText()),"SAVE IP");
		Assert.assertEquals(((driver.findElementById("com.tcs.mumbailab.heartsense:id/closebutton")).getText()),"CLOSE");

		
		Assert.assertEquals(((driver.findElementById("com.tcs.mumbailab.heartsense:id/savebutton")).isEnabled()),true);
		Assert.assertEquals(((driver.findElementById("com.tcs.mumbailab.heartsense:id/closebutton")).isEnabled()),true);	
		Assert.assertEquals(((driver.findElementById("com.tcs.mumbailab.heartsense:id/savebutton")).isDisplayed()),true);
		Assert.assertEquals(((driver.findElementById("com.tcs.mumbailab.heartsense:id/closebutton")).isDisplayed()),true);	
		Assert.assertEquals(((driver.findElementById("com.tcs.mumbailab.heartsense:id/ipaddressfield")).isEnabled()),true);
		Assert.assertEquals(((driver.findElementById("com.tcs.mumbailab.heartsense:id/input_layout_name1")).isEnabled()),true);	
		Assert.assertEquals(((driver.findElementById("com.tcs.mumbailab.heartsense:id/input_layout_name2")).isEnabled()),true);
		Assert.assertEquals(((driver.findElementById("com.tcs.mumbailab.heartsense:id/input_layout_name3")).isEnabled()),true);	
		Assert.assertEquals(((driver.findElementById("com.tcs.mumbailab.heartsense:id/input_layout_name4")).isEnabled()),true);

		Assert.assertEquals(((driver.findElementById("com.tcs.mumbailab.heartsense:id/ipaddressfield")).isDisplayed()),true);
		Assert.assertEquals(((driver.findElementById("com.tcs.mumbailab.heartsense:id/input_layout_name1")).isDisplayed()),true);	
		Assert.assertEquals(((driver.findElementById("com.tcs.mumbailab.heartsense:id/input_layout_name2")).isDisplayed()),true);
		Assert.assertEquals(((driver.findElementById("com.tcs.mumbailab.heartsense:id/input_layout_name3")).isDisplayed()),true);	
		Assert.assertEquals(((driver.findElementById("com.tcs.mumbailab.heartsense:id/input_layout_name4")).isDisplayed()),true);	
		System.out.println("IP screen Verified!!");
		

		/*Closing*/
		MobileElement el18 = (MobileElement) driver.findElementById("com.tcs.mumbailab.heartsense:id/closebutton");
		el18.click();
		
		//Assert.assertEquals(((driver.findElementById("com.tcs.mumbailab.heartsense:id/editIP")).isEnabled()),true);
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
		//driver.close();
		driver.quit();
	}
}
