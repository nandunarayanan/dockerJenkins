/*****************************************************************************
 * File Name 	: HS_Login_Screen.java
 * 
 * Version		: 0.1
 * 
 * Author		: Bastin
 * 
 * Type			:(Test Scripts/Libraries) Test Scripts
 * 
 * Description	: This .java file is written to test the IP screen of the 
 * 				  Heart sense application.
 * 
 * Test cases	: HS_Login_Screen_TC_DataDriven_valid_normal, 
 * 				  HS_Login_Screen_TC_DataDriven_valid_admin,
 * 				  HS_Login_Screen_TC_DataDriven_invalid, HS_Login_Screen_TC_1
 *****************************************************************************/
package testscripts;
/*Inclusion of required libraries*/
import org.testng.annotations.Test;
import io.appium.java_client.MobileElement;
import tcslibs_android.ApplicationLaunch;
import utility.ExcelUtils;
import org.testng.annotations.DataProvider;
import org.testng.annotations.BeforeTest;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
/*Below class contains the test cases for the IP screen*/
/*TestNG settings for run all the defined test cases*/
public class HS_Login_Screen extends ApplicationLaunch
{	
	/*Data provider with excel settings in the name of AuthenticationNormal*/
	@DataProvider
	public Object[][] AuthenticationNormal() 
	{
	  try
		{
			ExcelUtils.setExcelFile("E:\\Eclipse\\Workspace\\Test_HS_Mobile_App\\src\\test\\java\\testdata\\Login_Test.xlsx","Sheet4");			
			Object[][] testObjArray = ExcelUtils.getTableArray("E:\\Eclipse\\Workspace\\Test_HS_Mobile_App\\src\\test\\java\\testdata\\Login_Test.xlsx","Sheet4");		
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
	/*Data provider with excel settings in the name of AuthenticationAdmin*/
	@DataProvider
	public Object[][] AuthenticationAdmin() 
	{
	  try
		{
			ExcelUtils.setExcelFile("E:\\Eclipse\\Workspace\\Test_HS_Mobile_App\\src\\test\\java\\testdata\\Login_Test.xlsx","Sheet2");			
			Object[][] testObjArray = ExcelUtils.getTableArray("E:\\Eclipse\\Workspace\\Test_HS_Mobile_App\\src\\test\\java\\testdata\\Login_Test.xlsx","Sheet2");		
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
	/*Data provider with excel settings in the name of InvalidAuthentication*/
	@DataProvider
	public Object[][] InvalidAuthentication() 
	{
	  try
		{
			ExcelUtils.setExcelFile("E:\\Eclipse\\Workspace\\Test_HS_Mobile_App\\src\\test\\java\\testdata\\Login_Test.xlsx","Sheet3");			
			Object[][] testObjArray = ExcelUtils.getTableArray("E:\\Eclipse\\Workspace\\Test_HS_Mobile_App\\src\\test\\java\\testdata\\Login_Test.xlsx","Sheet3");		
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
/*****************************************************************************
 * Test Name  : HS_Login_Screen_TC_DataDriven_valid_normal
 * 
 * Test ID	  : TC_DataDriven_valid_normal
 * 
 * Type		  :(Parameterized/Data Driven/other) Data Driven
 * 
 * Group	  :(Smoke/Sanity/Regression) Regression
 * 
 * Description:  
 *
 *****************************************************************************/
	@Test(priority = 0,dataProvider = "AuthenticationNormal")
	public void HS_Login_Screen_TC_DataDriven_valid_normal(String sUserName, String sPassword) throws Exception 
	{
		MobileElement el62 = (MobileElement) driver.findElementById("com.tcs.mumbailab.heartsense:id/userName");
		el62.sendKeys(sUserName);
		MobileElement el63 = (MobileElement) driver.findElementById("com.tcs.mumbailab.heartsense:id/password");
		el63.sendKeys(sPassword);
		if(APP_CHEAT)
		{
			MobileElement el64 = (MobileElement) driver.findElementById("com.tcs.mumbailab.heartsense:id/loginButton");
			el64.click();		
			
			/*Need to test the next screen detail here once Sujit gave the stand alone version of the apk*/	
		}
	}
/*****************************************************************************
 * Test Name  : HS_Login_Screen_TC_DataDriven_valid_admin
 * 
 * Test ID	  : TC_DataDriven_valid_admin
 * 
 * Type		  :(Parameterized/Data Driven/other) Data Driven
 * 
 * Group	  :(Smoke/Sanity/Regression) Regression
 * 
 * Description:  
 *
 *****************************************************************************/
	@Test(priority = 3,dataProvider = "AuthenticationAdmin")
	public void HS_Login_Screen_TC_DataDriven_valid_admin(String sUserName, String sPassword) throws Exception 
	{
		MobileElement el62 = (MobileElement) driver.findElementById("com.tcs.mumbailab.heartsense:id/userName");
		el62.sendKeys(sUserName);
		MobileElement el63 = (MobileElement) driver.findElementById("com.tcs.mumbailab.heartsense:id/password");
		el63.sendKeys(sPassword);
		if(APP_CHEAT)
		{
			MobileElement el64 = (MobileElement) driver.findElementById("com.tcs.mumbailab.heartsense:id/loginButton");
			el64.click();	
			
			/*Need to test the next screen detail here once Sujit gave the stand alone version of the apk*/		
		}
	}
/*****************************************************************************
 * Test Name  : HS_Login_Screen_TC_DataDriven_invalid
 * 
 * Test ID	  : TC_DataDriven_invalid
 * 
 * Type		  :(Parameterized/Data Driven/other) Data Driven
 * 
 * Group	  :(Smoke/Sanity/Regression) Regression
 * 
 * Description:  
 *
 *****************************************************************************/
	@Test(priority = 2,dataProvider = "InvalidAuthentication")
	public void HS_Login_Screen_TC_DataDriven_invalid(String sUserName, String sPassword) throws Exception 
	{
		MobileElement el62 = (MobileElement) driver.findElementById("com.tcs.mumbailab.heartsense:id/userName");
		el62.sendKeys(sUserName);
		MobileElement el63 = (MobileElement) driver.findElementById("com.tcs.mumbailab.heartsense:id/password");
		el63.sendKeys(sPassword);
		if(APP_CHEAT)
		{
			MobileElement el64 = (MobileElement) driver.findElementById("com.tcs.mumbailab.heartsense:id/loginButton");
			el64.click();			
			
			/*Need to test the next screen detail here once Sujit gave the stand alone version of the apk*/
		}
	}
/*****************************************************************************
 * Test Name  : HS_Login_Screen_TC_1
 * 
 * Test ID	  : TC_1
 * 
 * Type		  :(Parameterized/Data Driven/other) Data Driven
 * 
 * Group	  :(Smoke/Sanity/Regression) Regression
 * 
 * Description:  
 *
 *****************************************************************************/
	@Test(priority = -1, description = "1. Login Screen Test for credentials "
			+ "and parameters in the Login Page")
	public void HS_Login_Screen_TC_1() 
	{
		/*Permission Pop-up*/
		 if(APP_CHEAT)
		 {
			 System.out.println("Permission PopUp");
			 MobileElement el001 = (MobileElement) driver.findElementById
					 ("com.android.packageinstaller:id"
					 		+ "/permission_allow_button");
			 el001.click();
			 System.out.println("1 click");
			 MobileElement el002 = (MobileElement) driver.findElementById
					 ("com.android.packageinstaller:id"
					 		+ "/permission_allow_button");
			 el002.click();
			 System.out.println("2 click");
			 el002.click();
			 System.out.println("3 click");
			 el002.click();
			 System.out.println("4 click");
			 System.out.println("Permission screen over");
		 }
		 
		/*checks of the Login Screen*/
		
		Assert.assertEquals(((driver.findElementById
				("com.tcs.mumbailab.heartsense:id/heartsenseVersion")).
				getText()),"v 1.0.19_2");
		Assert.assertEquals(((driver.findElementById
				("com.tcs.mumbailab.heartsense:id/tcscopyright")).getText())
							,"© 2019   Tata Consultancy Services Limited.");
		Assert.assertEquals(((driver.findElementById
				("com.tcs.mumbailab.heartsense:id/editIP"))
				.isDisplayed()),true);
		Assert.assertEquals(((driver.findElementById
				("com.tcs.mumbailab.heartsense:id/editIP"))
				.isEnabled()),true);
		Assert.assertEquals(((driver.findElementById
				("com.tcs.mumbailab.heartsense:id/iconImage"))
				.isDisplayed()),true);
		Assert.assertEquals(((driver.findElementById
				("com.tcs.mumbailab.heartsense:id/userName"))
				.isEnabled()),true);
		Assert.assertEquals(((driver.findElementById
				("com.tcs.mumbailab.heartsense:id/userName"))
				.isDisplayed()),true);
		Assert.assertEquals(((driver.findElementById
				("com.tcs.mumbailab.heartsense:id/userName"))
				.getText()),"User Name");
		Assert.assertEquals(((driver.findElementById
				("com.tcs.mumbailab.heartsense:id/password"))
				.isEnabled()),true);
		Assert.assertEquals(((driver.findElementById
				("com.tcs.mumbailab.heartsense:id/password"))
				.isDisplayed()),true);
		Assert.assertEquals(((driver.findElementById
				("com.tcs.mumbailab.heartsense:id/password"))
				.getText()),"Password");				
		Assert.assertEquals(((driver.findElementById
				("com.tcs.mumbailab.heartsense:id/loginButton"))
				.isEnabled()),true);
		Assert.assertEquals(((driver.findElementById
				("com.tcs.mumbailab.heartsense:id/loginButton"))
				.isDisplayed()),true);
		Assert.assertEquals(((driver.findElementById
				("com.tcs.mumbailab.heartsense:id/loginButton"))
				.getText()),"LOGIN");
		
	}
	 /* As per test NG this is the function which will call before the test
	  *  automatically.*/
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
	 /*As per test NG this is the function which will call after the test 
	  * automatically.*/
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
