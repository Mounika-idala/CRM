package advanceSelenium.excel;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class WriteDataIntoExcel {

	public static void main(String[] args) throws Exception
	{
		FileInputStream fis=new FileInputStream("F:\\QSP Course\\TekPyramid\\SampleTestData.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet("Sheet1");
		Row row = sh.createRow(9);
		row.createCell(0).setCellValue("03");
		row.createCell(1).setCellValue("Lenovo");
		row.createCell(2).setCellValue("30,000");
		FileOutputStream fos=new FileOutputStream("F:\\QSP Course\\TekPyramid\\SampleTestData.xlsx");
		wb.write(fos);
		wb.close();
		
		

	}

}
