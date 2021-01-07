package tcsLib;


import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.util.Properties;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.remote.DesiredCapabilities;


public class applicationLaunchLib
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
	public String getPropValues(String path,String s) throws IOException 
	{		
		try 
		{
			Properties prop = new Properties();
			String propFileName = "config.properties";
			testStream = new FileInputStream(path);
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
	public AppiumDriver<MobileElement> appLaunch(String path,String s) throws IOException 
	{
				
		try 
		{			
			cap = new DesiredCapabilities();
			cap.setCapability("username", getPropValues(path,"username"));
			cap.setCapability("accessKey", getPropValues(path,"accessKey"));
			if(Tab)
			{
				cap.setCapability("deviceName", getPropValues(path,"deviceName_Tab"));
				cap.setCapability("platformVersion", getPropValues(path,"platformVersion_Tab"));
				cap.setCapability("deviceOrientation", getPropValues(path,"deviceOrientation_Tab"));	
			}
			else
			{
				cap.setCapability("deviceName", getPropValues(path,"deviceName"));
				cap.setCapability("platformVersion", getPropValues(path,"platformVersion"));	
				cap.setCapability("deviceOrientation", getPropValues(path,"deviceOrientation"));					
			}	
			if(APP_CHEAT)
			{
				cap.setCapability("app", getPropValues(path,"app_1"));
			}
			else
			{
				cap.setCapability("app", getPropValues(path,"app"));
			}
			cap.setCapability("browserName", "");
			cap.setCapability("platformName", getPropValues(path,"platformName"));
			cap.setCapability("appPackage", getPropValues(path,"appPackage"));
			cap.setCapability("appActivity", getPropValues(path,"appActivity"));
			String getUrl = getPropValues(path,s);
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
