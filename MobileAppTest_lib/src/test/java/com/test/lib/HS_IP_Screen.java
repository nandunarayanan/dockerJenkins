package com.test.lib;

import org.testng.annotations.Test;

import io.appium.java_client.MobileElement;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import utility.ExcelUtils;

public class HS_IP_Screen extends ApplicationLaunch
{
	String IP_Seperator = ".";
	String IP_chk_init = "Existing Server IP Address :\nhttps://";
	String IP_End = "/";
	
	
	@DataProvider
	public Object[][] IP_Check() throws Exception
	{	
		try
		{
			/*
			 
			ExcelUtils.setExcelFile(File_name,File_name);
			
			Object[][] testObjArray = ExcelUtils.getTableArray(File_name,File_name);
			 
			 */
			ExcelUtils.setExcelFile("E:\\Eclipse\\Workspace\\Test_HS_Lib\\src\\test\\java\\TestData\\IP_Test.xlsx","Sheet1");
			
			Object[][] testObjArray = ExcelUtils.getTableArray("E:\\Eclipse\\Workspace\\Test_HS_Lib\\src\\test\\java\\TestData\\IP_Test.xlsx","Sheet1");
		
	    	return (testObjArray);	
		}
		
		catch(Exception e)
		{
			System.out.println("Error Cause is:- "+e.getCause());
			System.out.println("Error Message is:- "+e.getMessage());
			e.printStackTrace();
		}
		return null;
	}

	 @Test
	public void HS_IP_Screen_TC_1() 
	{
		 /*Permission Screen Continue button to navigate to Login screen*/		
			MobileElement el00 = (MobileElement) driver.findElementById("com.android.permissioncontroller:id/continue_button");			
			el00.click();			
			
			/*warning pop-up OK button to navigate to Login Screen*/
			
			MobileElement el01 = (MobileElement) driver.findElementById("android:id/button1");
			el01.click();
			
			/*Clicking the ip button*/
			MobileElement el02 = (MobileElement) driver.findElementById("com.tcs.mumbailab.heartsense:id/editIP");
			el02.click();
			
			/*Sending the ip to the corresponding Fields*/
			MobileElement el03 = (MobileElement) driver.findElementById("com.tcs.mumbailab.heartsense:id/editText1");
			el03.sendKeys("0");
			MobileElement el04 = (MobileElement) driver.findElementById("com.tcs.mumbailab.heartsense:id/editText2");
			el04.sendKeys("0");
			MobileElement el05 = (MobileElement) driver.findElementById("com.tcs.mumbailab.heartsense:id/editText3");
			el05.sendKeys("0");
			MobileElement el06 = (MobileElement) driver.findElementById("com.tcs.mumbailab.heartsense:id/editText4");
			el06.sendKeys("0");
			
			/*Saving*/
			MobileElement el07 = (MobileElement) driver.findElementById("com.tcs.mumbailab.heartsense:id/savebutton");
			el07.click();

			MobileElement el08 = (MobileElement) driver.findElementById("com.tcs.mumbailab.heartsense:id/closebutton");
			el08.click();
			System.out.println("Testin over");
	}
	
	 @Test(dataProvider="IP_Check")
	public void HS_IP_Screen_TC_2(String sIP_1,String sIP_2,String sIP_3,String sIP_4) 
	{
		String i1=sIP_1,i2=sIP_2, i3=sIP_3, i4=sIP_4;
		
		String IP_chk = IP_chk_init+(i1)+IP_Seperator+i2+IP_Seperator+i3+IP_Seperator+i4+IP_End;
		
		
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
	@BeforeTest
	public void beforeTest() 
	{
		try
		{	
			driver = appLaunch("heartsense");
			System.out.println("Heart Sense Application started !!!!");			
		}
		catch(Exception e)
		{
			System.out.println("Error Cause is:- "+e.getCause());
			System.out.println("Error Message is:- "+e.getMessage());
			e.printStackTrace();
		}
	}
	
	@AfterTest
	public void afterTest() 
	{
		try
		{	
			driver.quit();
			System.out.println("Heart Sense Application Ended !!!!");			
		}
		catch(Exception e)
		{
			System.out.println("Error Cause is:- "+e.getCause());
			System.out.println("Error Message is:- "+e.getMessage());
			e.printStackTrace();
		}
	}

}
