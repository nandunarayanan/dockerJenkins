/*****************************************************************************
 * File Name 	: ScreenLaunch.java
 * 
 * Version		: 0.1
 * 
 * Author		: Bastin
 * 
 * Type			:(Test Scripts/Libraries) Test Scripts
 * 
 * Description	: This .java file is written to launch the different screens
 * 				  as part of the scripting. This file will be reused at
 * 				  different places.
 * 
 * Test cases	: NA
 *****************************************************************************/
package utility;
/*Inclusion of required libraries*/
import io.appium.java_client.MobileElement;
import tcslibs_android.ApplicationLaunch;
/*Below class contains the utility class for launching different screen*/
public class ScreenLaunch extends ApplicationLaunch
{

	String app_id="";
	/*****************************************************************************
	 * Function/Test Name  : Launch_Login_Screen
	 * 
	 * Test ID	  		   : NA
	 * 
	 * Type		           :NA
	 * 
	 * Group	           :NA
	 * 
	 * Description         : This function helps in launching the Login screen
	 *****************************************************************************/
	public void Launch_Login_Screen()
	{
		 /*Permission Pop-up*/
		 if(APP_CHEAT)
		 {
			 System.out.println("Permission PopUp");
			 MobileElement el001 = (MobileElement) driver.findElementById("com.android.packageinstaller:id/permission_allow_button");
			 el001.click();
			 System.out.println("1 click");
			 el001.click();
			 System.out.println("2 click");
			 el001.click();
			 System.out.println("3 click");
			 el001.click();
			 System.out.println("4 click");
			 System.out.println("Permission screen over");
		 }
		 else
		 {
			 /*Need to  verify and go ahead*/
		 }
		
	}
	
	/*****************************************************************************
	 * Function/Test Name  : Launch_IP_Screen
	 * 
	 * Test ID	  		   : NA
	 * 
	 * Type		           :NA
	 * 
	 * Group	           :NA
	 * 
	 * Description         : This function helps in launching the IP screen
	 *****************************************************************************/
	public void Launch_IP_Screen()
	{
		Launch_Login_Screen();

		/*Clicking the ip button*/
		MobileElement el02 = (MobileElement) driver.findElementById(app_id+":id/editIP");
		el02.click();
		System.out.println("editButton");
	}
	
	/*****************************************************************************
	 * Function/Test Name  : Launch_Add_Patient_Screen
	 * 
	 * Test ID	  		   : NA
	 * 
	 * Type		           :NA
	 * 
	 * Group	           :NA
	 * 
	 * Description         : This function helps in launching the Add Patient
	 * 						 screen
	 *****************************************************************************/
	public void Launch_Add_Patient_Screen()
	{
		String uid = "";
		String pwd = "";
		Launch_Login_Screen();
		MobileElement el62 = (MobileElement) driver.findElementById(app_id+":id/userName");
		el62.sendKeys(uid);
		MobileElement el63 = (MobileElement) driver.findElementById(app_id+":id/password");
		el63.sendKeys(pwd);
		if(APP_CHEAT)
		{
			MobileElement el64 = (MobileElement) driver.findElementById(app_id+":id/loginButton");
			el64.click();			
			
			/*Need to test the next screen detail here once Sujit gave the stand alone version of the apk*/
			
		}
		else
		{
			/*Need to write script for clicking the Next*/
		}
	}
	/*****************************************************************************
	 * Function/Test Name  : Launch_Patient_Info_Screen
	 * 
	 * Test ID	  		   : NA
	 * 
	 * Type		           :NA
	 * 
	 * Group	           :NA
	 * 
	 * Description         : This function helps in launching the Patient Info
	 * 						 screen
	 *****************************************************************************/
	public void Launch_Patient_Info_Screen()
	{
		Launch_Add_Patient_Screen();
		/*Need to write script for adding the details & clicking the Next Button*/
	}
	/*****************************************************************************
	 * Function/Test Name  : Launch_Patient_Meta_Data_Screen
	 * 
	 * Test ID	  		   : NA
	 * 
	 * Type		           :NA
	 * 
	 * Group	           :NA
	 * 
	 * Description         : This function helps in launching the Patient Meta
	 * 						 Data screen
	 *****************************************************************************/
	public void Launch_Patient_Meta_Data_Screen()
	{
		Launch_Patient_Info_Screen();
		/*Need to write script for adding the details & clicking the Next Button.*/
	}
	/*****************************************************************************
	 * Function/Test Name  : Launch_CAD_Risk_Screen
	 * 
	 * Test ID	  		   : NA
	 * 
	 * Type		           :NA
	 * 
	 * Group	           :NA
	 * 
	 * Description         : This function helps in launching the CAD
	 * 						 risk output screen
	 *****************************************************************************/
	public void Launch_CAD_Risk_Screen()
	{
		Launch_Patient_Meta_Data_Screen();
		/*Need to write script for adding the details & clicking the Next
		Button for risk category.*/
	}

	/*****************************************************************************
	 * Function/Test Name  : Launch_CAD_wo_Risk_Screen
	 * 
	 * Test ID	  		   : NA
	 * 
	 * Type		           :NA
	 * 
	 * Group	           :NA
	 * 
	 * Description         : This function helps in launching the CAD
	 * 						 risk output screen
	 *****************************************************************************/
	public void Launch_CAD_wo_Risk_Screen()
	{
		Launch_Patient_Meta_Data_Screen();
		/*Need to write script for adding the details & clicking the Next
		Button for non-risk category.*/
	}


	/*****************************************************************************
	 * Function/Test Name  : Launch_Data_capture_Screen
	 * 
	 * Test ID	  		   : NA
	 * 
	 * Type		           :NA
	 * 
	 * Group	           :NA
	 * 
	 * Description         : This function helps in launching the Data
	 * 						 capture screen
	 *****************************************************************************/
	public void Launch_Data_capture_Screen()
	{
		Launch_CAD_Risk_Screen();
		/*Need to write script for clicking the Perform Test Button.*/
	}

	
	/*****************************************************************************
	 * Function/Test Name  : Launch_Board_Config_Screen
	 * 
	 * Test ID	  		   : NA
	 * 
	 * Type		           :NA
	 * 
	 * Group	           :NA
	 * 
	 * Description         : This function helps in launching the Board Config
	 * 						 screen
	 *****************************************************************************/
	public void Launch_Board_Config_Screen()
	{
		String uid = "";
		String pwd = "";
		Launch_Login_Screen();
		/*Admin credentials*/
		MobileElement el62 = (MobileElement) driver.findElementById(app_id+":id/userName");
		el62.sendKeys(uid);
		MobileElement el63 = (MobileElement) driver.findElementById(app_id+":id/password");
		el63.sendKeys(pwd);
		if(APP_CHEAT)
		{
			MobileElement el64 = (MobileElement) driver.findElementById(app_id+":id/loginButton");
			el64.click();			
			
			/*Need to test the next screen detail here once Sujit gave the stand alone version of the apk*/
			
		}
		else
		{
			/*Need to write script for clicking the Next*/
		}
		
		/*Add script for clicking board config button*/
	}

	/*****************************************************************************
	 * Function/Test Name  : Launch_Factory_Reset_Screen
	 * 
	 * Test ID	  		   : NA
	 * 
	 * Type		           :NA
	 * 
	 * Group	           :NA
	 * 
	 * Description         : This function helps in launching the Factory 
	 * 						 Reset screen
	 *****************************************************************************/
	public void Launch_Factory_Reset_Screen()
	{
		String uid = "";
		String pwd = "";
		Launch_Login_Screen();
		/*Admin credentials*/
		MobileElement el62 = (MobileElement) driver.findElementById(app_id+":id/userName");
		el62.sendKeys(uid);
		MobileElement el63 = (MobileElement) driver.findElementById(app_id+":id/password");
		el63.sendKeys(pwd);
		if(APP_CHEAT)
		{
			MobileElement el64 = (MobileElement) driver.findElementById(app_id+":id/loginButton");
			el64.click();			
			
			/*Need to test the next screen detail here once Sujit gave the stand alone version of the apk*/
			
		}
		else
		{
			/*Need to write script for clicking the Next*/
		}
		
		/*Add script for clicking Reset button*/
	}
	
}
