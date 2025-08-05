package advanceSelenium.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.jdbc.Driver;

public class SampleProgramUsingSelectquery {

	public static void main(String[] args) throws Throwable
	{
		//Load/Register the database driver
		Driver driver=new Driver();
		DriverManager.registerDriver(driver);
		//Connect to database
		Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/employeetable", "root", "root");
		System.out.println("done");
		//Create sql statement
		Statement st=conn.createStatement();
		ResultSet rs=st.executeQuery("Select * from employeetble;");
		while(rs.next())
		{
			System.out.println(rs.getInt(1)+"\t"+rs.getString(2));
		}
		//Close the connection
		conn.close();

	}

}
