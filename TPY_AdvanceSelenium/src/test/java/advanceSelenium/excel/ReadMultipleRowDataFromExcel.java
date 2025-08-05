package advanceSelenium.excel;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ReadMultipleRowDataFromExcel {

	public static void main(String[] args) throws Exception
	{
		FileInputStream fis=new FileInputStream("F:\\QSP Course\\Manual Testing Project\\Assignments\\TypesOfApplications.xlsx");
		Workbook wb=WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet("Sheet1");
		int rowcount=sh.getPhysicalNumberOfRows();
		int colcount=sh.getRow(0).getPhysicalNumberOfCells();
		System.out.println(rowcount);
		System.out.println(colcount);
		for(int i=1;i<rowcount;i++)
		{
			Row row = sh.getRow(i);
			for(int j=0;j<colcount;j++)
			{
				String data = row.getCell(j).getStringCellValue();
				System.out.print(data+"\t");
			}
			System.out.println();
		}
		wb.close();

	}

}
