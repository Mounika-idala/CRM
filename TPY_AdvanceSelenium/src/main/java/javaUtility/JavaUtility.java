package javaUtility;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;

public class JavaUtility {

	public int getRand()
	{
		 Random rd = new Random();
		 return rd.nextInt(500);
	}
	public String getDate()
	{
		Date dt=new Date();
		SimpleDateFormat sdf=new SimpleDateFormat("dd-MM-yyyy");
		sdf.format(dt);
		Calendar cl=sdf.getCalendar();
		cl.add(Calendar.DAY_OF_MONTH,5);
		String req_date = sdf.format(cl.getTime());
		return req_date;
		
				
	}
	

}
