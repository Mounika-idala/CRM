package advanceSelenium.excel;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ReadMultipleRowDataBasedOnCondition {

	public static void main(String[] args) throws Exception
	{
		String exp_data="1";
		String data1="";
		String data2="";
		String data3="";
		FileInputStream fis=new FileInputStream("F:\\QSP Course\\TekPyramid\\SampleTestData.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet("Sheet1");
		int rowcount = sh.getPhysicalNumberOfRows();
		int colcount=sh.getRow(0).getPhysicalNumberOfCells();
//		System.out.println(rowcount);
//		System.out.println(colcount);
//		
			for(int i=0;i<=rowcount;i++)
			{
				try 
				{
					Row row = sh.getRow(i);
					String data = row.getCell(0).toString();
					if(data.equals(exp_data))
					{
						data1=row.getCell(0).toString();
						data2=row.getCell(1).toString();
						data3=row.getCell(2).toString();
						
					}
					
					
				}catch(Exception e) {}
				
			
			}
			System.out.print(data1+"\t"+data2+"\t"+data3);
			
			
		

	}

}
