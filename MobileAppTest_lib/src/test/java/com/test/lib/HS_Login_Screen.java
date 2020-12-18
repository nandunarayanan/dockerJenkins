package com.test.lib;

import org.testng.annotations.Test;

import io.appium.java_client.MobileElement;
import utility.ExcelUtils;

import org.testng.annotations.DataProvider;
import org.testng.annotations.BeforeTest;
import org.testng.Assert;
import org.testng.annotations.AfterTest;

public class HS_Login_Screen extends ApplicationLaunch
{	
	/*
	 * Function Header
	 * ----------
	 * 
	 * Function Name: Authentication_Normal
	 * Description: Setting up the data provider in the name of Authentication_Normal to verify the normal user authentication
	 */
	@DataProvider
	public Object[][] AuthenticationNormal() 
	{
	  try
		{
			/*
			 
			ExcelUtils.setExcelFile(File_name,File_name);
			
			Object[][] testObjArray = ExcelUtils.getTableArray(File_name,File_name);
			 
			 */
			ExcelUtils.setExcelFile("E:\\Eclipse\\Workspace\\Test_HS_Lib\\src\\test\\java\\TestData\\Login_Test.xlsx","Sheet1");
			
			Object[][] testObjArray = ExcelUtils.getTableArray("E:\\Eclipse\\Workspace\\Test_HS_Lib\\src\\test\\java\\TestData\\Login_Test.xlsx","Sheet1");
		
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
	/*
	 * Function Header
	 * ----------
	 * 
	 * Function Name: Authentication_Admin
	 * Description: Setting up the data provider in the name of Authentication_Admin to verify the normal user authentication
	 */
	@DataProvider
	public Object[][] AuthenticationAdmin() 
	{
	  try
		{
			/*
			 
			ExcelUtils.setExcelFile(File_name,File_name);
			
			Object[][] testObjArray = ExcelUtils.getTableArray(File_name,File_name);
			 
			 */
			ExcelUtils.setExcelFile("E:\\Eclipse\\Workspace\\Test_HS_Lib\\src\\test\\java\\TestData\\Login_Test.xlsx","Sheet2");
			
			Object[][] testObjArray = ExcelUtils.getTableArray("E:\\Eclipse\\Workspace\\Test_HS_Lib\\src\\test\\java\\TestData\\Login_Test.xlsx","Sheet2");
		
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
	/*
	 * Function Header
	 * ----------
	 * 
	 * Function Name: InvalidAuthentication
	 * Description: Setting up the data provider in the name of InvalidAuthentication to verify the invalid authentication
	 */
	@DataProvider
	public Object[][] InvalidAuthentication() 
	{
	  try
		{
			/*
			 
			ExcelUtils.setExcelFile(File_name,File_name);
			
			Object[][] testObjArray = ExcelUtils.getTableArray(File_name,File_name);
			 
			 */
			ExcelUtils.setExcelFile("E:\\Eclipse\\Workspace\\Test_HS_Lib\\src\\test\\java\\TestData\\Login_Test.xlsx","Sheet3");
			
			Object[][] testObjArray = ExcelUtils.getTableArray("E:\\Eclipse\\Workspace\\Test_HS_Lib\\src\\test\\java\\TestData\\Login_Test.xlsx","Sheet3");
		
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
	
	@Test(priority = 4,dataProvider = "AuthenticationNormal")
	public void HS_Login_Screen_TC_DataDriven_valid_normal(String sUserName, String sPassword) throws Exception 
	{
		MobileElement el62 = (MobileElement) driver.findElementById("com.tcs.mumbailab.heartsense:id/userName");
		el62.sendKeys(sUserName);
		MobileElement el63 = (MobileElement) driver.findElementById("com.tcs.mumbailab.heartsense:id/password");
		el63.sendKeys(sPassword);
		//MobileElement el64 = (MobileElement) driver.findElementById("com.tcs.mumbailab.heartsense:id/loginButton");
		//el64.click();
	}
	
	@Test(priority = 3,dataProvider = "AuthenticationAdmin")
	public void HS_Login_Screen_TC_DataDriven_valid_admin(String sUserName, String sPassword) throws Exception 
	{
		MobileElement el62 = (MobileElement) driver.findElementById("com.tcs.mumbailab.heartsense:id/userName");
		el62.sendKeys(sUserName);
		MobileElement el63 = (MobileElement) driver.findElementById("com.tcs.mumbailab.heartsense:id/password");
		el63.sendKeys(sPassword);
		//MobileElement el64 = (MobileElement) driver.findElementById("com.tcs.mumbailab.heartsense:id/loginButton");
		//el64.click();
	}
	

	@Test(priority = 2,dataProvider = "InvalidAuthentication")
	public void HS_Login_Screen_TC_DataDriven_invalid(String sUserName, String sPassword) throws Exception 
	{
		MobileElement el62 = (MobileElement) driver.findElementById("com.tcs.mumbailab.heartsense:id/userName");
		el62.sendKeys(sUserName);
		MobileElement el63 = (MobileElement) driver.findElementById("com.tcs.mumbailab.heartsense:id/password");
		el63.sendKeys(sPassword);
		//MobileElement el64 = (MobileElement) driver.findElementById("com.tcs.mumbailab.heartsense:id/loginButton");
		//el64.click();
		
		/*Need to test the next screen detail here once Sujit gave the stand alone version of the apk*/
	}
		
	/*
	 * Function Header
	 * ----------
	 * 
	 * Test Name: HS_Login_Screen_TC_1
	 * Description: Login Screen Test for elements check in the Login Page
	 */
	
	@Test(priority = 1, description = "1. Login Screen Test for credentials and parameters in the Login Page")
	public void HS_Login_Screen_TC_1() 
	{
		
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
				
		Assert.assertEquals(((driver.findElementById("com.tcs.mumbailab.heartsense:id/loginButton")).isEnabled()),true);
		Assert.assertEquals(((driver.findElementById("com.tcs.mumbailab.heartsense:id/loginButton")).isDisplayed()),true);
		Assert.assertEquals(((driver.findElementById("com.tcs.mumbailab.heartsense:id/loginButton")).getText()),"LOGIN");
		
	}
	
	 /*
	 * Function Header
	 * ----------
	 * Function Name: beforeTest
	 * Description: As per test NG this is the function which will call before the test automatically.
	 */
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
	 /*
	 * Function Header
	 * ----------
	 * Function Name: afterTest
	 * Description: As per test NG this is the function which will call after the test automatically.
	 */
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
