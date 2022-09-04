package SunflowerApp_Tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import testBase.BaseTest;

public class ShareFuncGmail_Test extends BaseTest{

	@Test
	
	public void ShareFunctionality() {
		addPlantpage.click_add_plant();
		addPlantpage.click_add_bougainvillea_button();
		shareGmailpage.click_share_button();
		shareGmailpage.click_gmail_icon();
		shareGmailpage.click_next_icon();
		shareGmailpage.click_done_button();
		shareGmailpage.click_add_email_address();
		waitForElement();
		shareGmailpage.click_google_icon();
		waitForElement();
		shareGmailpage.click_create_account();
		waitForElement();
		shareGmailpage.click_menu_icon();
		waitForElement();
		shareGmailpage.click_next_button();
		String error_message = shareGmailpage.getText_errormessage();
		Assert.assertEquals(error_message, "Enter first name");
	}
}
