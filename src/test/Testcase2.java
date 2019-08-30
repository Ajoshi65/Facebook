package test;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import pages.CommonUtility;
import pages.ReadData;

public class Testcase2
{

	ReadData objExcelFile=new ReadData();
	CommonUtility objCommon=new CommonUtility();
	public String filePath = System.getProperty("user.dir")+"\\src\\data\\";
	
	
	@Test(priority=1,description="Verify Facebook Login Page with valid Credentials")
	
	public void register() throws Exception
	{
		objExcelFile.readExcel(filePath,"Book1.xlsx","Sheet1");
		CommonUtility.driver.findElement(By.xpath("//input[@name='firstname']")).sendKeys(objExcelFile.objsheet.getRow(1).getCell(2).getStringCellValue());
		CommonUtility.driver.findElement(By.xpath("//input[@name=\"lastname\"]")).sendKeys(objExcelFile.objsheet.getRow(1).getCell(3).getStringCellValue());
		CommonUtility.driver.findElement(By.xpath("//input[@name=\"reg_email__\"]")).sendKeys(objExcelFile.objsheet.getRow(1).getCell(4).getStringCellValue());
	}
}
