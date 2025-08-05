package genericutility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class FileUtilityUsingExcel 
{
	public String getDatafromExcel(String sheet,int row, int cell) throws Exception 
	{
		FileInputStream fis=new FileInputStream("./src/test/resources/CRM_TestData.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		String data=wb.getSheet(sheet).getRow(row).getCell(cell).toString();
		wb.close();
		return data;
	}
	public int getRowcount(String sheet) throws Exception
	{
		FileInputStream fis=new FileInputStream("./src/test/resources/CRM_TestData.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		int rcount=wb.getSheet(sheet).getLastRowNum();
		wb.close();
		return rcount;
		
	}
}
