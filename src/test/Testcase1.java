package test;

import org.testng.annotations.Test;

import pages.CommonUtility;
import pages.ReadData;

public class Testcase1 
{
	ReadData objExcelFile=new ReadData();
	CommonUtility objCommon=new CommonUtility();
	
	
	 public String filePath = System.getProperty("user.dir")+"\\src\\data\\";
	
	 
	@Test(priority=1 ,description="To Read Data from excel")
	public void readDataFromExcel() throws Exception
	{
		//Call read file method of the class to read data
		objExcelFile.readExcel(filePath,"Book1.xlsx","Sheet1");
	}
		
}