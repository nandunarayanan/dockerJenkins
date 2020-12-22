/*****************************************************************************
 * File Name 	: ApplicationLaunch.java
 * 
 * Version		: 0.1
 * 
 * Author		: Sachin
 * 
 * Type			:(Test Scripts/Libraries) Libraries
 * 
 * Description	: This file is used for the common functionalities.
 * 				  This will get the data's defined in the 
 * 				  configuration file.
 * 
 * Libraries	: This includes the  library functionalities of application
 * 				  Launch.
 * 
 *****************************************************************************/
package tcslibs_android;
/*Inclusion of required libraries*/
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.util.Properties;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.remote.DesiredCapabilities;

/*Below class contains the library functions of the Application 
 * & this is the parent class*/
public class ApplicationLaunch 
{
	/*Below variables are used for setting particular devices or app version*/
	public AppiumDriver<MobileElement> driver;
	public DesiredCapabilities cap;
	String value;
	FileInputStream testStream;
	public boolean Tab = true;
	public boolean APP_CHEAT = false;
	
	/*****************************************************************************
	 * Test Name  	: getPropValues
	 * 
	 * Test ID	  	:NA
	 * 
	 * Type		 	:(Parameterized/Data Driven/Behavioral)NA
	 * 
	 * Group	  	:(Smoke/Sanity/Regression)NA
	 * 
	 * Description	: This function is to get the detail/data from the 
	 * 				  configuration file.
	 *****************************************************************************/ 
	public String getPropValues(String s) throws IOException 
	{		
		try 
		{
			Properties prop = new Properties();
			String propFileName = "config.properties";
			 testStream = new FileInputStream("E:\\Eclipse\\Workspace\\Test_HS_Mobile_App\\src\\test\\java\\tcslibs_android\\config.properties");
			if (testStream != null)
			{
				prop.load(testStream);
			}
			else 
			{
				throw new FileNotFoundException("property file '" + propFileName + "' not found in the classpath");
			}
 
			 value = prop.getProperty(s);
		} 
		catch (Exception e)
		{
			System.out.println("Exception: " + e);
		} 
		finally 
		{
			testStream.close();
		}
		return value;
	}
	/*****************************************************************************
	 * Test Name  	: appLaunch
	 * 
	 * Test ID	  	:NA
	 * 
	 * Type		 	:(Parameterized/Data Driven/Behavioral)NA
	 * 
	 * Group	  	:(Smoke/Sanity/Regression)NA
	 * 
	 * Description	:  This function is to set the settings of the test device,
	 * 				   version, orientation and etc; and will return the object.
	 *****************************************************************************/ 
	public AppiumDriver<MobileElement> appLaunch(String s) throws IOException 
	{
				
		try 
		{			
			cap = new DesiredCapabilities();
			cap.setCapability("username", getPropValues("username"));
			cap.setCapability("accessKey", getPropValues("accessKey"));
			if(Tab)
			{
				cap.setCapability("deviceName", getPropValues("deviceName_Tab"));
				cap.setCapability("platformVersion", getPropValues("platformVersion_Tab"));
				cap.setCapability("deviceOrientation", getPropValues("deviceOrientation_Tab"));	
			}
			else
			{
				cap.setCapability("deviceName", getPropValues("deviceName"));
				cap.setCapability("platformVersion", getPropValues("platformVersion"));	
				cap.setCapability("deviceOrientation", getPropValues("deviceOrientation"));					
			}	
			if(APP_CHEAT)
			{
				cap.setCapability("app", getPropValues("app_1"));
			}
			else
			{
				cap.setCapability("app", getPropValues("app"));
			}
			cap.setCapability("browserName", "");
			cap.setCapability("platformName", getPropValues("platformName"));
			cap.setCapability("appPackage", getPropValues("appPackage"));
			cap.setCapability("appActivity", getPropValues("appActivity"));
			String getUrl = getPropValues(s);
			URL url;
			url = new URL(getUrl);
			driver = new AppiumDriver<MobileElement>(url,cap);
		}
		catch (Exception e) 
		{
			System.out.println("Exception: " + e);
		} 	
		return driver;
	}

}
