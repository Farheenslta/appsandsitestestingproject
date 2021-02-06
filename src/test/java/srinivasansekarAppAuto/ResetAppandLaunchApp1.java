package srinivasansekarAppAuto;

import java.net.URL;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.android.Activity;
import io.appium.java_client.android.AndroidDriver;

public class ResetAppandLaunchApp1 
{
	public static void main(String[] args) throws Exception
	{
		//Details of app and device(AVD)
		DesiredCapabilities dc=new DesiredCapabilities();
		dc.setCapability(CapabilityType.BROWSER_NAME, "");
		dc.setCapability("deviceName", "33003962e6e144fd");
		dc.setCapability("platformName", "android");
		dc.setCapability("platfromVersion", "8.1.0");
		dc.setCapability("appPackage", "com.sec.android.app.popupcalculator");
		dc.setCapability("appActivity", "com.sec.android.app.popupcalculator.Calculator");
		//Start appium serve
		Runtime.getRuntime().exec("cmd.exe /c start cmd.exe /k \"appium\"");
		//connet to appium server
		URL u=new URL("http://0.0.0.0:4723/wd/hub");
		//create androiddriver object
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
			WebDriverWait wait=new WebDriverWait(driver,20);
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@text='9']")));
			driver.findElement(By.xpath("//*[@text='9']")).click();
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@content-desc='Plus']")));
			driver.findElement(By.xpath("//*[@content-desc='Plus']")).click();
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@text='5']")));
			driver.findElement(By.xpath("//*[@text='5']")).click();
			Thread.sleep(5000);
			/*wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@content-desc='Equal']")));
			driver.findElement(By.xpath("//*[@content-desc='Equal']")).click();
			String x=driver.findElement(By.xpath("//*[@class='android.widget.EditText']")).getAttribute("text");*/
			driver.activateApp("com.cricbuzz.android");
			Thread.sleep(5000);
			driver.launchApp();
			Thread.sleep(5000);
			driver.runAppInBackground(Duration.ofSeconds(15));
			Thread.sleep(3000);
			driver.terminateApp("com.cricbuzz.android.lithium.app.view.activity.NyitoActivity");
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@text='9']")));
			Activity a=new Activity("com.samsung.android.contacts","com.android.dialer.DialtactsActivity");
			driver.startActivity(a);
			Thread.sleep(5000);
			driver.resetApp();
			Thread.sleep(5000);
			driver.runAppInBackground(Duration.ofSeconds(15));
			Thread.sleep(3000);
			driver.terminateApp("com.samsung.android.contacts");
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@text='9']")));
			Thread.sleep(3000);
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
