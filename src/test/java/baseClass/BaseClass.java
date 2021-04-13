package baseClass;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class BaseClass extends ExtentReport{

	public static AppiumDriver<MobileElement> driver;
	DateFormat df;
	String direktori = "D:\\BankMantap\\CaptureMantap\\";
//	protected AppiumDriver driver;
	
	@BeforeTest
	@Parameters({"deviceName","udid", "platformVersion","url"})
	public void setup(String deviceName, String udid,String platformVersion,String url) throws InterruptedException, MalformedURLException
	{
		
		DesiredCapabilities cap=new DesiredCapabilities();
		cap.setCapability("deviceName", deviceName);
		cap.setCapability("udid", udid);
		cap.setCapability("appPackage", "com.mantap.pac");
		cap.setCapability("appActivity", "com.mantap.pac.activity.IntroActivity");
		cap.setCapability("platformName", "Android");
		cap.setCapability("platformVersion", platformVersion);
		cap.setCapability("noReset", "true");
		cap.setCapability("fullReset", "false");
		cap.setCapability("autoGrantPermissions", "true"); 
		
		URL server  = new URL(url);
//		driver = new AppiumDriver<MobileElement>(server, cap);
		driver = new AndroidDriver<MobileElement>(server, cap);
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		Thread.sleep(5000);
		
	}
	
	//Capture ScreehShoot
  	public void takeScreenshoot(String modulName, String caseType) throws IOException {
  		File f  = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
  		df = new  SimpleDateFormat("dd-MMM-yyyy__hh_mm_ssaa");
  		File dir = new File(direktori + modulName + "\\" + caseType);
  		if (!dir.exists()) {
  			dir.mkdir();
  			String file_name=df.format(new Date())+".png";
  			FileUtils.copyFile(f, new File(dir + "\\" + file_name));
  		}else {
  			String file_name=df.format(new Date())+".png";
  			FileUtils.copyFile(f, new File(dir + "\\" + file_name));
  		}
  	}

}