package reportsutilityobject;

import com.aventstack.extentreports.ExtentTest;

public class UtilityObject 
{
	public static ThreadLocal<ExtentTest> test=new ThreadLocal<ExtentTest>();
	
	public static ExtentTest getTest()
	{
		return test.get();
	}
	public static void setTest(ExtentTest ts)
	{
		test.set(ts);
	}

}
