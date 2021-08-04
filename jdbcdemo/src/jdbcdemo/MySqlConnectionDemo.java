package jdbcdemo;

import java.sql.*;
public class MySqlConnectionDemo {

	public static void main(String[] args) {
		//these interfaces are in the sql package
		Connection con=null;
		Statement stmt;
		ResultSet rs;
		try {
			//Load & register the Driver
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			//Create a connection object..using getConnection of DriverManager class
			//this will create a session between Java(client) & MySQL
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/classicmodels","root","admin");
			
			//Create a statement object
			stmt=con.createStatement();
			
			//Execute a query & store in the ResultSet(virtual table)
			rs=stmt.executeQuery("select * from employees");
			
			//traversing ResultSet
			while(rs.next())
			{
				System.out.println(rs.getInt(1)+" "+rs.getString(3)+" "+rs.getString(5)
				+" "+rs.getString(8));
			}
			
			//it will not work as the traversing by default is only in forward direction
			//look for ScrollableDemo.java for implementation
			/*System.out.println("Display specific record from a db");
			rs.absolute(3);//move the cursor to 3rd row in rs
			System.out.println(rs.getInt(1)+" "+rs.getString(3)+" "+rs.getString(5)
			+" "+rs.getString(8));*/
			
			con.close();
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}

	}

}
