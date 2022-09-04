package testBase;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

import io.appium.java_client.android.AndroidDriver;
import pageObjects.AddPlantObjects;
import pageObjects.ShareGmailObjects;


public class ObjectsRepo {

	public AndroidDriver driver;
	public AddPlantObjects addPlantpage;
	public static ExtentReports extent;
	public static ExtentTest test;
	public ShareGmailObjects shareGmailpage;
	
}
