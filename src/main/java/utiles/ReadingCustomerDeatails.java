package utiles;


import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;

public class ReadingCustomerDeatails {
	
WebDriver browserobject;
	
	public ReadingCustomerDeatails(WebDriver browserobject)
	{
		this.browserobject= browserobject;
	}
	
	public static String ReadingData(int row ,int col) throws IOException
	{
		
		 File src=new File("CustomerDetails.xlsx");
	     FileInputStream fis= new FileInputStream(src);

	   
	     XSSFWorkbook wb = new XSSFWorkbook(fis);
	     XSSFSheet sh1= wb.getSheetAt(0);
	     
	     DataFormatter formatter = new DataFormatter();
	     String val = formatter.formatCellValue(sh1.getRow(row).getCell(col));
	   
	     return val;
	     
	    
	       
	}


}