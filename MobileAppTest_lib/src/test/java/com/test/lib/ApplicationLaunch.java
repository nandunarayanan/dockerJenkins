/**
 * 
 */
package com.test.lib;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.util.Properties;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;

import org.openqa.selenium.remote.DesiredCapabilities;

/**
 * @author Bastin
 *
 */
public class ApplicationLaunch 
{

	public AppiumDriver<MobileElement> driver;
	public DesiredCapabilities cap;
	String value;
	FileInputStream testStream;
	boolean Tab = true;
	boolean APP_CHEAT = false;
	String File_name = "";
	String File_sheet = "";
 
	public String getPropValues(String s) throws IOException 
	{		
		try 
		{
			Properties prop = new Properties();
			String propFileName = "config.properties";
			
 
			//inputStream = String.class.getClassLoader().getResourceAsStream("config.properties");
			 testStream = new FileInputStream("E:\\Eclipse\\Workspace\\Test_HS_Lib\\src\\test\\java\\com\\test\\lib\\config.properties");
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
	
	public AppiumDriver<MobileElement> appLaunch(String s) throws IOException 
	{
				
		try 
		{
			/*
			DesiredCapabilities caps = DesiredCapabilities.android();
			caps.setCapability("username", "SAUCE_USERNAME");
			caps.setCapability("accessKey", "SAUCE_ACCESS_KEY");
			//caps.setCapability("appiumVersion", "1.18.1");
			caps.setCapability("deviceName","Samsung Galaxy Tab A 10 GoogleAPI Emulator");
			caps.setCapability("deviceOrientation", "landscape");
			caps.setCapability("browserName", "");
			caps.setCapability("platformVersion","7.0");
			caps.setCapability("platformName","Android");
			caps.setCapability("app", "https://github.com/nandunarayanan/apk/blob/main/heartsense_19_feb_19_1_0_19_2.apk?raw=true");
			caps.setCapability("appPackage", "com.tcs.mumbailab.heartsense");
			caps.setCapability("appActivity", "com.tcs.mumbailab.heartsense.LoginActivity");
			URL url;
			url = new URL("https://bastin:7b287c70-064e-432c-b9b4-c570ca11d3bd@ondemand.us-west-1.saucelabs.com:443/wd/hub");
			driver = new AppiumDriver<MobileElement>(url,caps);
			*/
			
			
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
			File_name = getPropValues("Test_IP_File");
			File_sheet = getPropValues("Test_IP_Sheet");
		}
		catch (Exception e) 
		{
			System.out.println("Exception: " + e);
		} 
		finally
		{
			
		}
		
		return driver;
	}

}
