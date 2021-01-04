/*****************************************************************************
 * File Name 	: HS_IP_Screen.java
 * 
 * Version		: 0.1
 * 
 * Author		: Bastin
 * 
 * Type			:(Test Scripts/Libraries) Test Scripts
 * 
 * Description	: This .java file is written to test the IP screen of the 
 * 		  application.
 * 
 * Test cases	: HS_IP_Screen_TC_1, HS_IP_Screen_TC_2, HS_IP_Screen_TC_3
 * 
 *****************************************************************************/
package testscripts;

/*Inclusion of required libraries*/
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import io.appium.java_client.MobileElement;
import tcslibs_android.ApplicationLaunch;
import utility.ExcelUtils;
/*Below class contains the test cases for the IP screen*/

/*TestNG settings for run all the defined test cases*/
public class HS_IP_Screen extends ApplicationLaunch
{
	/*Below strings are to check the ip screen after saving the ip*/
	String IP_Seperator = ".";
	String IP_chk_init = "Existing Server IP Address :\nhttps://";
	String IP_End = "/";
	String app_id="";
	
	/*Data provider with excel settings in the name of IP_Check*/
	@DataProvider
	public Object[][] IP_Check() throws Exception
	{	
		try
		{
			ExcelUtils.setExcelFile("E:\\Eclipse\\Workspace\\Test_HS_Mobile_App\\src\\test\\java\\testdata\\IP_Test.xlsx","Sheet1");			
			Object[][] testObjArray = ExcelUtils.getTableArray("E:\\Eclipse\\Workspace\\Test_HS_Mobile_App\\src\\test\\java\\testdata\\IP_Test.xlsx","Sheet1");		
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
 * Test Name  : HS_IP_Screen_TC_1
 * 
 * Test ID	  : TC_1
 * 
 * Type		  :(Parameterized/Data Driven/other) other
 * 
 * Group	  :(Smoke/Sanity/Regression) Regression
 * 
 * Description: This test case will check and confirm all the elements in the 
 * 				IP screen page are present and as per the SRS
 *****************************************************************************/
	 @Test
	public void HS_IP_Screen_TC_1() 
	{
		 
		 /*Permission Pop-up*/
		 if(APP_CHEAT)
		 {
			 System.out.println("Permission PopUp");
			 MobileElement el001 = (MobileElement) driver.findElementById("com.android.packageinstaller:id/permission_allow_button");
			 el001.click();
			 System.out.println("1 click");
			 MobileElement el002 = (MobileElement) driver.findElementById("com.android.packageinstaller:id/permission_allow_button");
			 el002.click();
			 System.out.println("2 click");
			 el002.click();
			 System.out.println("3 click");
			 el002.click();
			 System.out.println("4 click");
			 System.out.println("Permission screen over");
		 }
		 
		
		/*Clicking the ip button*/
		MobileElement el02 = (MobileElement) driver.findElementById(app_id+":id/editIP");
		el02.click();
		System.out.println("editButton");
		
		Assert.assertEquals(((driver.findElementById(app_id+":id/existingIP")).isDisplayed()),true);
		Assert.assertEquals(((driver.findElementById(app_id+":id/savebutton")).getText()),"SAVE IP");
		Assert.assertEquals(((driver.findElementById(app_id+":id/closebutton")).getText()),"CLOSE");

		
		Assert.assertEquals(((driver.findElementById(app_id+":id/savebutton")).isEnabled()),true);
		Assert.assertEquals(((driver.findElementById(app_id+":id/closebutton")).isEnabled()),true);	
		Assert.assertEquals(((driver.findElementById(app_id+":id/savebutton")).isDisplayed()),true);
		Assert.assertEquals(((driver.findElementById(app_id+":id/closebutton")).isDisplayed()),true);	
		Assert.assertEquals(((driver.findElementById(app_id+":id/ipaddressfield")).isEnabled()),true);
		Assert.assertEquals(((driver.findElementById(app_id+":id/input_layout_name1")).isEnabled()),true);	
		Assert.assertEquals(((driver.findElementById(app_id+":id/input_layout_name2")).isEnabled()),true);
		Assert.assertEquals(((driver.findElementById(app_id+":id/input_layout_name3")).isEnabled()),true);	
		Assert.assertEquals(((driver.findElementById(app_id+":id/input_layout_name4")).isEnabled()),true);

		Assert.assertEquals(((driver.findElementById(app_id+":id/ipaddressfield")).isDisplayed()),true);
		Assert.assertEquals(((driver.findElementById(app_id+":id/input_layout_name1")).isDisplayed()),true);	
		Assert.assertEquals(((driver.findElementById(app_id+":id/input_layout_name2")).isDisplayed()),true);
		Assert.assertEquals(((driver.findElementById(app_id+":id/input_layout_name3")).isDisplayed()),true);	
		Assert.assertEquals(((driver.findElementById(app_id+":id/input_layout_name4")).isDisplayed()),true);	
		System.out.println("IP screen Verified!!");
		
		/*Sending the ip to the corresponding Fields*/
		MobileElement el03 = (MobileElement) driver.findElementById(app_id+":id/editText1");
		el03.sendKeys("0");
		MobileElement el04 = (MobileElement) driver.findElementById(app_id+":id/editText2");
		el04.sendKeys("0");
		MobileElement el05 = (MobileElement) driver.findElementById(app_id+":id/editText3");
		el05.sendKeys("0");
		MobileElement el06 = (MobileElement) driver.findElementById(app_id+":id/editText4");
		el06.sendKeys("0");
		
		/*Saving*/
		MobileElement el07 = (MobileElement) driver.findElementById(app_id+":id/savebutton");
		el07.click();
		System.out.println("save Button");
		/*closing*/
		MobileElement el08 = (MobileElement) driver.findElementById(app_id+":id/closebutton");
		el08.click();
		System.out.println("Testing over");
	} 
/*****************************************************************************
 * Test Name  : HS_IP_Screen_TC_2
 * 
 * Test ID	  : TC_2
 * 
 * Type		  :(Parameterized/Data Driven/other) Data Driven
 * 
 * Group	  :(Smoke/Sanity/Regression) Regression
 * 
 * Description: This test case will check and confirm all the IP elements 
 * 				from the excel are picked & given to the IP fields in the  
 * 				IP screen page and check in the next time when IP screen is 
 * 				pop-up the existing ip is filled as per the filled data.
 *****************************************************************************/	
	 @Test(dataProvider="IP_Check")
	public void HS_IP_Screen_TC_2(String sIP_1,String sIP_2,String sIP_3,String sIP_4) 
	{
		String i1=sIP_1,i2=sIP_2, i3=sIP_3, i4=sIP_4;
		
		String IP_chk = IP_chk_init+(i1)+IP_Seperator+i2+IP_Seperator+i3+IP_Seperator+i4+IP_End;
		
		
		/*Clicking the ip button*/
		MobileElement el12 = (MobileElement) driver.findElementById(app_id+":id/editIP");
		el12.click();
		
		/*Sending the ip to the corresponding Fields*/
		MobileElement el13 = (MobileElement) driver.findElementById(app_id+":id/editText1");
		el13.sendKeys(i1);
		MobileElement el14 = (MobileElement) driver.findElementById(app_id+":id/editText2");
		el14.sendKeys(i2);
		MobileElement el15 = (MobileElement) driver.findElementById(app_id+":id/editText3");
		el15.sendKeys(i3);
		MobileElement el16 = (MobileElement) driver.findElementById(app_id+":id/editText4");
		el16.sendKeys(i4);
		
		/*Saving*/
		MobileElement el17 = (MobileElement) driver.findElementById(app_id+":id/savebutton");
		el17.click();
		/*Closing*/
		MobileElement el18 = (MobileElement) driver.findElementById(app_id+":id/closebutton");
		el18.click();
		/*Again taking ip screen and checking the entered ip is present*/
		MobileElement el19 = (MobileElement) driver.findElementById(app_id+":id/editIP");
		el19.click();
		

		/*Verifying the saved ip is displayed in the screen or not*/
		Assert.assertEquals(((driver.findElementById(app_id+":id/existingIP")).getText()),IP_chk);
		System.out.println("IP Verification Done using Data Driven method!!");			

		/*Closing*/
		el18.click();
	}	 	
 /*****************************************************************************
 * Test Name  : HS_IP_Screen_TC_3
 * 
 * Test ID	  : TC_3
 * 
 * Type		  :(Parameterized/Data Driven/other) Parameterized
 * 
 * Group	  :(Smoke/Sanity/Regression) Regression
 * 
 * Description: This test case will check and confirm all the IP elements 
 * 				from the excel are picked & given to the IP fields in the  
 * 				IP screen page and check in the next time when IP screen is 
 * 				pop-up the existing ip is filled as per the filled data.
 *****************************************************************************/	
	 @Parameters({"IP_1","IP_2","IP_3","IP_4"})
	 @Test( description = "IP screen testing with parameterized ip fields input", dependsOnMethods = {"HS_IP_Screen_TC_1"})
	public void HS_IP_Screen_TC_3(String sIP_1,String sIP_2,String sIP_3,String sIP_4) 
	{
		String i1=sIP_1,i2=sIP_2, i3=sIP_3, i4=sIP_4;
		
		String IP_chk = IP_chk_init+(i1)+IP_Seperator+i2+IP_Seperator+i3+IP_Seperator+i4+IP_End;
		
		
		/*Clicking the ip button*/
		MobileElement el12 = (MobileElement) driver.findElementById(app_id+":id/editIP");
		el12.click();
		
		/*Sending the ip to the corresponding Fields*/
		MobileElement el13 = (MobileElement) driver.findElementById(app_id+":id/editText1");
		el13.sendKeys(i1);
		MobileElement el14 = (MobileElement) driver.findElementById(app_id+":id/editText2");
		el14.sendKeys(i2);
		MobileElement el15 = (MobileElement) driver.findElementById(app_id+":id/editText3");
		el15.sendKeys(i3);
		MobileElement el16 = (MobileElement) driver.findElementById(app_id+":id/editText4");
		el16.sendKeys(i4);
		
		/*Saving*/
		MobileElement el17 = (MobileElement) driver.findElementById(app_id+":id/savebutton");
		el17.click();
		/*Closing*/
		MobileElement el18 = (MobileElement) driver.findElementById(app_id+":id/closebutton");
		el18.click();
		/*Again taking ip screen and checking the entered ip is present*/
		MobileElement el19 = (MobileElement) driver.findElementById(app_id+":id/editIP");
		el19.click();
		

		/*Verifying the saved ip is displayed in the screen or not*/
		Assert.assertEquals(((driver.findElementById(app_id+":id/existingIP")).getText()),IP_chk);
		System.out.println("IP Verification Done using parameterized method!!");			

		/*Closing*/
		el18.click();
	}
	 /* As per test NG this is the function which will call before the test
	  *  automatically.*/	 
	@BeforeTest
	public void beforeTest() 
	{
		try
		{	
			driver = appLaunch("test");		
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
		}
		catch(Exception e)
		{
			System.out.println("Error Cause is:- "+e.getCause());
			System.out.println("Error Message is:- "+e.getMessage());
			e.printStackTrace();
		}
	}

}
