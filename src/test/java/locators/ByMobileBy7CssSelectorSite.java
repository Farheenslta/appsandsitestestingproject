package locators;

import java.net.URL;

import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

public class ByMobileBy7CssSelectorSite 
{
	public static void main(String[] args) throws Exception
	{
		//start appium server
		Runtime.getRuntime().exec("cmd.exe /c start cmd.exe /k\"appium\"");
		//connect to appium server
		URL u=new URL("http://0.0.0.0:4723/wd/hub");
		//Details of app and device(ARD)
		DesiredCapabilities dc=new DesiredCapabilities();
		dc.setCapability(CapabilityType.BROWSER_NAME,"chrome");
		dc.setCapability("deviceName", "33003962e6e144fd");
		dc.setCapability("platformName", "android");
		dc.setCapability("platformVersion", "8.1.0");
		//Locate element uniquely using CssSelector and use it
		
		/*
		driver.findElement(By.cssSelector("xxxxxx")).click();
		driver.findElement(MobileBy.cssSelector("xxxxxx")).click();
		driver.findElementByCssSelector("xxxxxxx").click();
		*/
	}
}
