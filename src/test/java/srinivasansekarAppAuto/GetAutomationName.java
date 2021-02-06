package srinivasansekarAppAuto;

import java.net.URL;

import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.connection.ConnectionState;

public class GetAutomationName
{
	public static void main(String[] args) throws Exception
	{
		//Get details of app and device(ARD)
		DesiredCapabilities dc=new DesiredCapabilities();
		dc.setCapability(CapabilityType.BROWSER_NAME, "");
		dc.setCapability("deviceName", "emulator-5554");
		dc.setCapability("platformName", "android");
		dc.setCapability("platformVersion", "8.1.0");
		dc.setCapability("appPackage", "com.vodqareactnative");
		dc.setCapability("appActivity", "com.vodqareactnative.MainActivity");
		//Start appium server
		Runtime.getRuntime().exec("cmd.exe /c start cmd.exe /k \"appium\"");
		//Get details of appium server
		URL u=new URL("http://0.0.0.0:4723/wd/hub");
		//Create object to AndroidDriver
		AndroidDriver driver;
		while(2>1)
		{
			try
			{
				driver=new AndroidDriver(u,dc);
				break;
			}
			catch(Exception ex)
			{				
			}
		}
		//Automation code
		try
		{
			//Get connection details of WIFI, DATA, AIRPLANE related to device
			ConnectionState cs=driver.getConnection();
			//About WIFI
			if(cs.isWiFiEnabled())
			{
				System.out.println("Wifi is ON");
			}
			else
			{
				System.out.println("Wifi is OFF");
			}
			//About DATA
			if(cs.isDataEnabled())
			{
				System.out.println("DATA is ON");
			}
			else
			{
				System.out.println("DATA is OFF");
			}
			//About Airplane
			if(cs.isAirplaneModeEnabled())
			{
				System.out.println("AirplaneMode is ON");
			}
			else
			{
				System.out.println("AirplaneMode is OFF");
			}
			String autoname=driver.getAutomationName();
			System.out.println(autoname);
		}
		catch(Exception ex)
		{
			System.out.println(ex.getMessage());
		}
		//close app
		driver.closeApp();
		//stop appium server
		Runtime.getRuntime().exec("taskkill /F /IM node.exe");
		Runtime.getRuntime().exec("taskkill /F /IM cmd.exe");		
	}
}
