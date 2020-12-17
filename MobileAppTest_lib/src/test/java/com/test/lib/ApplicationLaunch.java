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
	boolean Tab = false;
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
			cap = new DesiredCapabilities();
			cap.setCapability("username", getPropValues("username"));
			cap.setCapability("accessKey", getPropValues("accessKey"));
			cap.setCapability("deviceOrientation", getPropValues("deviceOrientation"));	
			if(Tab)
			{
				cap.setCapability("deviceName", getPropValues("deviceName_Tab"));
				cap.setCapability("platformVersion", getPropValues("platformVersion_Tab"));
			}
			else
			{
				cap.setCapability("deviceName", getPropValues("deviceName"));
				cap.setCapability("platformVersion", getPropValues("platformVersion"));					
			}	
			cap.setCapability("browserName", "");
			cap.setCapability("platformName", getPropValues("platformName"));
			cap.setCapability("app", getPropValues("app"));
			cap.setCapability("appPackage", getPropValues("appPackage"));
			cap.setCapability("appActivity", getPropValues("appActivity"));
			String getUrl = getPropValues(s);
			URL url;
			url = new URL(getUrl);
			driver = new AppiumDriver<MobileElement>(url,cap);
			File_name = getPropValues("Test_IP_File");
			File_sheet = getPropValues("Test_IP_Sheet");
			
		} catch (Exception e) {
			System.out.println("Exception: " + e);
		} finally {
			
		}
		return driver;
	}

}
