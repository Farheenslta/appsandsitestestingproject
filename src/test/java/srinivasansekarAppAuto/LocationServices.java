package srinivasansekarAppAuto;

import java.net.URL;

import org.openqa.selenium.html5.Location;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.android.AndroidDriver;

public class LocationServices
{
	public static void main(String[] args) throws Exception
	{
		//Details of apps and devices (AVD)
		DesiredCapabilities dc=new DesiredCapabilities();
		dc.setCapability(CapabilityType.BROWSER_NAME, "");
		dc.setCapability("deviceName", "emulator-5554");
		dc.setCapability("platformName", "android");
		dc.setCapability("platformVersion", "8.1.0");
		dc.setCapability("appPackage", "com.google.android.apps.maps");
		dc.setCapability("appActivity", "com.google.android.maps.MapsActivity");
		dc.setCapability("locationServicesEnabled", true);
		dc.setCapability("locationServicesAutorized", true);
		dc.setCapability("noReset", "true");
		dc.setCapability("fullReset", "false");
		//Start appium server
		Runtime.getRuntime().exec("cmd.exe /c start cmd.exe /k \"appium\"");
		//Get details of server
		URL u=new URL("http://0.0.0.0:4723/wd/hub");
		//Create driver object
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
		//Automation
		try
		{
			Thread.sleep(50000);
			//Get current location
			Location current_location=driver.location();
			System.out.println("Latitude of current location "+ current_location.getLatitude());
			System.out.println("Longitude of current location "+ current_location.getLongitude());
			System.out.println("Altitude of current location "+ current_location.getAltitude());
			//Set location using latitude, longitude and altitude
			//Set location to Goa
			Location l1=new Location(15.299326,74.123993,100000);
			driver.setLocation(l1);
			Thread.sleep(5000);
			//Set location to kerela
			Location l2=new Location(10.850516,76.271080,100000);
			driver.setLocation(l2);
			Thread.sleep(5000);
			//Set location to minneapolis
			Location l3=new Location(44.977753,-93.265015,100000);
			driver.setLocation(l3);
			Thread.sleep(5000);
			//Set location to chicago
			Location l4=new Location(41.881832, -87.623177, 100000);
			driver.setLocation(l4);
			Thread.sleep(5000);
		}
		catch(Exception ex)
		{
			System.out.println(ex.getMessage());
		}
		//close app
		driver.closeApp();
		//Stop appium server
		Runtime.getRuntime().exec("taskkill /F /IM node.exe");
		Runtime.getRuntime().exec("taskkill /F /IM cmd.exe");
	}
}
