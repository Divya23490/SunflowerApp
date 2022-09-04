package SunflowerApp_Tests;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import testBase.BaseTest;


public class AddPlant_Test extends BaseTest
{
	public static XSSFWorkbook workbook;
	public static XSSFSheet worksheet;
	static String SheetName= "SunflowerTest";
	public static String file_location = System.getProperty("user.dir")+"//src//test//resources//testData//SunflowerApp_TestData.xlsx";
	public static DataFormatter formatter= new DataFormatter();
	
	
    
	@Test(dataProvider = "ReadVariant")
    public 	void AddPlantTestCase(String Plant_Name) 
    {
    	
    	addPlantpage.click_add_plant();
    	addPlantpage.click_apple_button();
    	addPlantpage.click_add_plant_button();
    	String message=addPlantpage.getTextToVerify();
    	Assert.assertEquals(message, "Added plant to garden");
    	addPlantpage.click_Navigate_button();
    	addPlantpage.click_My_garden();
    	String cart_value=addPlantpage.getcartText();
    	Assert.assertEquals(cart_value,Plant_Name,"The values are matching");
    }
	@DataProvider
	public static Object[][] ReadVariant() throws IOException
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

