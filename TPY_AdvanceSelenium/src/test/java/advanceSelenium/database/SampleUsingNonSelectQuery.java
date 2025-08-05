package advanceSelenium.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.jdbc.Driver;

public class SampleUsingNonSelectQuery {

	public static void main(String[] args) throws SQLException 
	{
		Connection conn=null;
		try
		{
			//Load/register the database
			Driver driver=new Driver();
			DriverManager.registerDriver(driver);
			
		    //Connect to database
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/student", "root", "root");
			System.out.println("Database connection done");
			//Create sql statement
			Statement st = conn.createStatement();
			int rs = st.executeUpdate("Insert into studentdetails(id,name)values(4,'Shannvika');");
			ResultSet rs1 = st.executeQuery("Select * from studentdetails;");
			while(rs1.next())
			{
				System.out.println(rs1.getInt(1)+"\t"+rs1.getString(2));
			}
			
		}
		catch(Exception e)
		{
			System.out.println("Exception handled");
		}
		finally {
			conn.close();
		}
	}

}
