package com.test.lib;

import org.testng.annotations.Test;

import io.appium.java_client.MobileElement;
import org.testng.Assert;

public class TestLib extends ApplicationLaunch
{
	String Test_text = "This app was built for an older version of Android and may not work properly. Try checking for updates, or contact the developer.";
	
	
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
			driver = appLaunch("heartsense");
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


}
