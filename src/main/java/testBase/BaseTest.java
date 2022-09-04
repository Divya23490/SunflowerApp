package testBase;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.google.common.collect.ImmutableMap;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import io.appium.java_client.service.local.flags.GeneralServerFlag;
import pageObjects.AddPlantObjects;
import pageObjects.ShareGmailObjects;



public class BaseTest extends ObjectsRepo
{
	
	public AppiumDriverLocalService service;
	public void ConfigureAppium() throws MalformedURLException
	{
		Map<String, String> env = new HashMap<String, String>(System.getenv());
        env.put("PATH", "C://Users//DELL//AppData//Local//Android//Sdk:%ANDROID_HOME%/emulator:%ANDROID_HOME%/tools:%ANDROID_HOME%/platform-tools:%ANDROID_HOME%/build-tools/33.0.0:" + env.get("PATH"));
		 service = new AppiumServiceBuilder().withEnvironment(env).usingDriverExecutable(new File("C://Program Files//nodejs//node.exe")).withAppiumJS(new File("C://Users//DELL//node_modules//appium//build//lib//main.js"))
				 .withIPAddress("0.0.0.0").usingPort(4723).withArgument(GeneralServerFlag.BASEPATH, "/wd/hub").build();
			service.start();
			
								
			UiAutomator2Options options = new UiAutomator2Options();
			
			options.setDeviceName("emulator-5554");
			
			
			options.setChromedriverExecutable("D://downloads//chromedriver_6");
			
			options.setApp("C://Users//DELL//Desktop//sunflower.apk");	
			options.setUiautomator2ServerLaunchTimeout(Duration.ofSeconds(50));
			options.setAdbExecTimeout(Duration.ofMillis(30000));
			options.getAdbExecTimeout();
			options.getUiautomator2ServerInstallTimeout();	
			options.setCapability("noResetValue", true);
			 driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), options);
			 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	}
	public void longPressAction(WebElement ele)
	{
		((JavascriptExecutor)driver).executeScript("mobile: longClickGesture",
				ImmutableMap.of("elementId",((RemoteWebElement)ele).getId(),
						"duration",2000));
	}
	public void scrollToEndAction()
	{
		boolean canScrollMore;
		do
		{
		 canScrollMore = (Boolean) ((JavascriptExecutor) driver).executeScript("mobile: scrollGesture", ImmutableMap.of(
			    "left", 100, "top", 100, "width", 200, "height", 200,
			    "direction", "down",
			    "percent", 3.0
			    
			));
		}while(canScrollMore);
	}
	
	public void swipeAction(WebElement ele,String direction)
	{
		((JavascriptExecutor) driver).executeScript("mobile: swipeGesture", ImmutableMap.of(
				"elementId", ((RemoteWebElement)ele).getId(),
			 
			    "direction", direction,
			    "percent", 0.75
			));
		
		
	}
	@BeforeMethod   /// it will get execute before each test method within current class
	public void setupMethod() throws Exception {
		ConfigureAppium();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		addPlantpage= new AddPlantObjects(driver);
		shareGmailpage=new ShareGmailObjects(driver);
		
	}
	public void pressKeyEvent() {
		driver.pressKey(new KeyEvent(AndroidKey.BACK));
	}
	
	public void waitForElement() {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));
	}
	public void sendKeys(WebElement we, String txt) {
		we.sendKeys(txt);
	}

	@AfterMethod
	public void tearDown()
	{
		driver.quit();
        service.stop();
		}
	

}
