package pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import testBase.BaseTest;

public class ShareGmailObjects extends BaseTest {
	
	@AndroidFindBy(xpath="//android.widget.Button[@content-desc='Share']")
	WebElement Share;
	
	@AndroidFindBy(xpath="//android.widget.TextView[@text='Gmail']")
	WebElement Gmail_Icon;
	
	@AndroidFindBy(accessibility="Next")
	WebElement Next_Icon;
	
	@AndroidFindBy(xpath="//android.widget.TextView[@text='DONE']")
	WebElement Done_Button;
	
	@AndroidFindBy(xpath="//android.widget.TextView[@text='Add an email address']")
	WebElement AddEmailAddress;
	
	@AndroidFindBy(xpath="//android.widget.TextView[@text='Google']")
	WebElement GoogleIcon;
	
	@AndroidFindBy(xpath="//android.widget.TextView[@text='Copy to clipboard']")
	WebElement CopyToClipboardIcon;
	
	@AndroidFindBy(xpath="//android.widget.Spinner[@text='Create account']")
	WebElement CreateAccountIcon;
	
	@AndroidFindBy(xpath="//android.view.MenuItem[@text='For myself']")
	WebElement MenuIcon;
	
	@AndroidFindBy(xpath="//android.widget.Button[@text='Next']")
	WebElement Next_Button;
	
	@AndroidFindBy(xpath="//android.view.View[@text='Enter first name']")
	WebElement Error_Message;
	
	@AndroidFindBy(xpath="//android.widget.EditText[@resource-id='firstName']")
	WebElement FirstName;
	
	@AndroidFindBy(xpath="//android.widget.Spinner[@text='Month']")
	WebElement Month;
	
	@AndroidFindBy(xpath="//android.widget.EditText[@resource-id='day']")
	WebElement Day;
	
	@AndroidFindBy(xpath="//android.widget.EditText[@resource-id='year']")
	WebElement Year;
	
	@AndroidFindBy(xpath="//android.widget.Spinner[@text='Gender']")
	WebElement Gender;
	
	@AndroidFindBy(xpath="//android.widget.CheckedTextView[@text='April']")
	WebElement April;
	
	@AndroidFindBy(xpath="//android.widget.CheckedTextView[@text='Female']")
	WebElement Female;
	
	public ShareGmailObjects(AppiumDriver driver) {
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}
	
	public void click_share_button() {
		Share.click();	
	}
	public void click_gmail_icon() {
		Gmail_Icon.click();
	}
	public void click_next_icon() {
		Next_Icon.click();
	}
	public void click_done_button() {
		Done_Button.click();
	}
	public void click_add_email_address() {
		AddEmailAddress.click();
	}
	public void click_google_icon() {
		GoogleIcon.click();
	}
	public void click_create_account() {
		CreateAccountIcon.click();
	}
	public void click_menu_icon() {
		MenuIcon.click();
	}
	public void click_next_button() {
		Next_Button.click();
	}
	public void click_firstName() {
		FirstName.click();
	}
	public void EnterText_FirstName(String text) {
		sendKeys(FirstName, text);
	}
	public void click_Month() {
		Month.click();
	}
	
	public void select_Month_radioButton() {
		April.click();
	}
	
	public void click_Day() {
		Day.click();
	}
	
	public void EnterText_Day(String Text) {
		sendKeys(Day, Text);
	}
	
	public void click_Year() {
		Year.click();
	}
	public void EnterText_Year(String textValue) {
		sendKeys(Year, textValue);
	}
	public void click_Gender() {
		Gender.click();
	}
	public void click_FemaleOption() {
		Female.click();
	}
	
	public void click_CopyToClipboard() {
		CopyToClipboardIcon.click();
	}
	
	public String getText_errormessage() {
		return Error_Message.getText();
	}
	
}
