package advanceSelenium;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class SampleDateProgram {

	public static void main(String[] args)
	{
		Date dt=new Date();
		System.out.println(dt);//prints current date and time
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
		String date=sdf.format(dt);
		System.out.println(date);//Prints only date in specified format
		
		Calendar cl=sdf.getCalendar();
		cl.add(Calendar.DAY_OF_WEEK,7);
		String req_date = sdf.format(cl.getTime());
		System.out.println(req_date);
	}

}
