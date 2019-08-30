package pages;

import java.io.File;
import java.io.FileInputStream;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadData 

{

	 public Workbook objWB = null;
	 public Sheet objsheet =null;
	 public  Row row=null;
	 public File file=null;
	 FileInputStream inputStream =null;
	 
	 public void readExcel(String filePath,String fileName,String sheetName) throws Exception
		{

		    //Create an object of File class to open xlsx file

		    file =    new File(filePath+"\\"+fileName);

		    //Create an object of FileInputStream class to read excel file

		     inputStream = new FileInputStream(file);

		   
		    
		    //Find the file extension by splitting file name in substring  and getting only extension name

		    String fileExtensionName = fileName.substring(fileName.indexOf("."));

		    //Check condition if the file is xlsx file

		    if(fileExtensionName.equals(".xlsx"))
		    {

		    //If it is xlsx file then create object of XSSFWorkbook class

		    	objWB = new XSSFWorkbook(inputStream);

		    }

		    //Check condition if the file is xls file

		    else if(fileExtensionName.equals(".xls")){

		        //If it is xls file then create object of XSSFWorkbook class

		        objWB = new HSSFWorkbook(inputStream);

		    }

		    //Read sheet inside the workbook by its name

		    objsheet = objWB.getSheet(sheetName);

		    //Find number of rows in excel file

		    int rowCount = objsheet.getLastRowNum()-objsheet.getFirstRowNum();
		    System.out.println(rowCount);

		    //Create a loop over all the rows of excel file to read it
		    //FormulaEvaluator objForm= objWB.getCreationHelper().createFormulaEvaluator();

		    for (int i = 0; i < rowCount+1; i++) 
		    {

		        row = objsheet.getRow(i);

		        //Create a loop to print cell values in a row

		        for (int j = 0; j < row.getLastCellNum(); j++) 
		        {
		        	
		        	System.out.print((j)+ " "+ row.getCell(j).getStringCellValue()+"|| ");        	
		        	
		        }
		        	
		                        
		      }

		     

		    }   
}


		    
		/*
		      CellType cell = row.getCell(j).getCellTypeEnum();

		            switch(cell)
		            {
		                case NUMERIC:
		                    int intVal = (int) row.getCell(j).getNumericCellValue();
		                    System.out.print("int "+intVal);
		                    break;
		                case STRING:
		                    String stringVal = row.getCell(j).getStringCellValue();
		                    System.out.print("string "+stringVal);
		                    break;
					default:
						break;
		            }
		 */
		
		



