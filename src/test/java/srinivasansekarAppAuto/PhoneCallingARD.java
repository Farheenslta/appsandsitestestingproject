package srinivasansekarAppAuto;

import java.net.URL;
import java.util.Scanner;

import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.android.AndroidDriver;

public class PhoneCallingARD
{
	public static void main(String[] args) throws Exception
	{
		// Give a mobile number
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter 1st 10 digit mobile number to dial");
		String mbno1=sc.nextLine();
		System.out.println("Enter 2nd 10 digit mobile number to dial");
		String mbno2=sc.nextLine();
		sc.close();
		
		//Desired Capabilities of app and device(ARD)
		DesiredCapabilities dc=new DesiredCapabilities();
		dc.setCapability(CapabilityType.BROWSER_NAME, "");
		dc.setCapability("deviceName", "33003962e6e144fd");
		dc.setCapability("platformName", "android");
		dc.setCapability("platformVersion", "8.1.0");
		dc.setCapability("appPackage", "");
		dc.setCapability("appActivity", "");
		//Start appium server
		Runtime.getRuntime().exec("cmd.exe /c start cmd.exe /k \"appium\"");
		//connect to server
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
		//App automation
		try
		{
			
			
			try
			{
				
			}
			catch(Exception ex)
			{				
			}
			//ipadd-192.168.0.2
			
			//close app
			driver.closeApp();
		}
		catch(Exception ex)
		{
			System.out.println(ex.getMessage());
		}
		//Stop appium
		Runtime.getRuntime().exec("taskkill /F /IM node.exe");
		Runtime.getRuntime().exec("taskkill /F /IM cmd.exe");		
	}
}
