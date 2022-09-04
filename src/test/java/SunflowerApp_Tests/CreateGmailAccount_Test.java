package SunflowerApp_Tests;

import java.io.FileInputStream;
import java.io.IOException;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import testBase.BaseTest;

public class CreateGmailAccount_Test extends BaseTest{
	public static XSSFWorkbook workbook;
	public static XSSFSheet worksheet;
	static String SheetName= "CreateGmailAccount";
	public static String file_location = System.getProperty("user.dir")+"//src//test//resources//testData//SunflowerApp_TestData.xlsx";
	public static DataFormatter formatter= new DataFormatter();

	@Test(dataProvider = "CreateAccount")
	public void CreateGmailAccountFunc(String FirstName, String Day, String Year) {
		addPlantpage.click_add_plant();
		addPlantpage.click_add_bougainvillea_button();
		shareGmailpage.click_share_button();
		shareGmailpage.click_gmail_icon();
		shareGmailpage.click_next_icon();
		shareGmailpage.click_done_button();
		shareGmailpage.click_add_email_address();
		shareGmailpage.click_google_icon();
		waitForElement();
		shareGmailpage.click_create_account();
		waitForElement();
		shareGmailpage.click_menu_icon();
		waitForElement();
		shareGmailpage.click_firstName();
		waitForElement();
		shareGmailpage.EnterText_FirstName(FirstName);
		pressKeyEvent();
		waitForElement();
		shareGmailpage.click_next_button();
		waitForElement();
		shareGmailpage.click_Month();
		shareGmailpage.select_Month_radioButton();
		waitForElement();
		shareGmailpage.click_Day();
		shareGmailpage.EnterText_Day(Day);
		waitForElement();
		shareGmailpage.click_Year();
		shareGmailpage.EnterText_Year(Year);
		waitForElement();
		shareGmailpage.click_Gender();
		shareGmailpage.click_FemaleOption();
		waitForElement();
		shareGmailpage.click_next_button();
		
	}
	@DataProvider
	public static Object[][] CreateAccount() throws IOException
	{
	FileInputStream fileInputStream= new FileInputStream(file_location); //Excel sheet file location get mentioned here
		workbook = new XSSFWorkbook (fileInputStream); //get my workbook 
		worksheet=workbook.getSheet(SheetName);// get my sheet from workbook
   	    XSSFRow Row=worksheet.getRow(0);   	 //get my Row which start from 0   
   	
    	int RowNum = worksheet.getPhysicalNumberOfRows();// count my number of Rows
    	int ColNum= Row.getLastCellNum(); // get last ColNum 
    	
    	Object Data[][]= new Object[RowNum-1][ColNum]; // pass my  count data in array
    	
    		for(int i=0; i<RowNum-1; i++) //Loop work for Rows
    		{  
    			XSSFRow row= worksheet.getRow(i+1);
    			
    			for (int j=0; j<ColNum; j++) //Loop work for colNum
    			{
    				if(row==null)
    					Data[i][j]= "";
    				else 
    				{
    					XSSFCell cell= row.getCell(j);
    					if(cell==null)
    						Data[i][j]= ""; //if it get Null value it pass no data 
    					else
    					{
    						String value=formatter.formatCellValue(cell);
    						Data[i][j]=value; //This formatter get my all values as string i.e integer, float all type data value
    					}
    				}
    			}
    		}

    	return Data;
    }
}
