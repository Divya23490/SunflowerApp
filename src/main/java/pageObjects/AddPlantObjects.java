package pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import testBase.BaseTest;

public class AddPlantObjects extends BaseTest{

	@AndroidFindBy(xpath="//android.widget.Button[@text='ADD PLANT']")
	WebElement Add_Plant;
	
	@AndroidFindBy(xpath="//android.widget.TextView[@text='Apple']")
	WebElement Apple_button;
	
	@AndroidFindBy(xpath="//android.widget.TextView[@text='Beet']")
	WebElement Beet_button;
	
	@AndroidFindBy(xpath="//android.widget.TextView[@text='Bougainvillea']")
	WebElement Bougainvillea_button;
	
	@AndroidFindBy(accessibility="Add plant")
	WebElement Add_Plant_Icon;
	
	@AndroidFindBy(xpath="//android.widget.TextView[@text='Added plant to garden']")
	WebElement Verify_Message;
	
	@AndroidFindBy(accessibility="Navigate up")
	WebElement Navigate_Back;
	
	@AndroidFindBy(accessibility="My garden")
	WebElement My_garden;
	
	
	public void click_add_plant() {
		Add_Plant.click();
	}
	public void click_apple_button() {
		Apple_button.click();
		
	}
	public void click_add_plant_button() {
		Add_Plant_Icon.click();;
	}
	public void click_add_bougainvillea_button() {
		Bougainvillea_button.click();
	}
	public void click_add_beet_button() {
		Beet_button.click();
	}
	public String getTextToVerify() {
		String value=Verify_Message.getText();
		return value;
	}
	@AndroidFindBy(xpath="//android.widget.TextView[@text='Apple']")
	WebElement Apple_Cart;
	
	public AddPlantObjects(AndroidDriver driver) {
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}
	public void click_Navigate_button() {
		Navigate_Back.click();
	}
	public void click_My_garden() {
		My_garden.click();
	}
	public String getcartText() {
		return Apple_Cart.getText();
	}

}
