package genericutility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;

public class FileUtility 
{
	public String getDataFromProperties(String Key) throws Throwable
	{
		FileInputStream fis=new FileInputStream("./src/main/resources/CRM_CommonData.properties");
		Properties pro=new Properties();
		pro.load(fis);
		String data = pro.getProperty(Key);
		return data;
	}
}
