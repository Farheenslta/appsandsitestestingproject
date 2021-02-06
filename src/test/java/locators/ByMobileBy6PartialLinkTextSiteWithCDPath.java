package locators;

import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.android.AndroidDriver;

public class ByMobileBy6PartialLinkTextSiteWithCDPath
{
	public static void main(String[] args) throws Exception
	{
		//Start appium server
		Runtime.getRuntime().exec("cmd.exe /c start cmd.exe /k \"appium\"");
		//Connect to appium server
		URL u=new URL("http://0.0.0.0:4723/wd/hub");
		//Details of app and device(ARD)
		DesiredCapabilities dc=new DesiredCapabilities();
		dc.setCapability(CapabilityType.BROWSER_NAME, "chrome");
		dc.setCapability("deviceName", "33003962e6e144fd");
		dc.setCapability("platformName", "android");
		dc.setCapability("platformVersion", "8.1.0");
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
			Thread.sleep(5000);
			//Launch site
			driver.get("http://demo.guru99.com/test/newtours/");
			WebDriverWait wait=new WebDriverWait(driver,20);
			wait.until(ExpectedConditions.elementToBeClickable(By.partialLinkText("REGISTER")));
			driver.findElement(By.partialLinkText("REGISTER")).click();
			//driver.findElement(MobileBy.partialLinkText("REGISTER")).click();
			driver.findElementByPartialLinkText("REGISTER").click();
			Thread.sleep(5000);
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
