package SunflowerApp_Tests;

import org.testng.annotations.Test;

import testBase.BaseTest;

public class CopyToClipboard_Test extends BaseTest{

	@Test
	public void copyToClipCoard() {
		addPlantpage.click_add_plant();
		addPlantpage.click_add_beet_button();
		shareGmailpage.click_share_button();
		shareGmailpage.click_CopyToClipboard();
	}
}
