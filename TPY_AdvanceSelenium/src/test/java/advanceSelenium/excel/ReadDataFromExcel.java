package advanceSelenium.excel;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ReadDataFromExcel {

	public static void main(String[] args) throws Exception
	{
		//Get the java representation object of physical file
		FileInputStream fis=new FileInputStream("F:\\QSP Course\\Selenium\\QSP_Selenium notes\\Book1.xlsx");
		//Open workbook in read mode
		Workbook wb = WorkbookFactory.create(fis);
		//Navigate into sheet
		Sheet sh = wb.getSheet("Sheet1");
		//Navigate to row
		Row row = sh.getRow(3);
		//Navigate into cell and read the data
		Cell cell = row.getCell(4);
		String data = cell.getStringCellValue();
		System.out.println(data);
		//close the workbook
		wb.close();
		

	}

}
