package jdbcdemo;

import java.sql.*;
import java.util.Scanner;

public class PreparedStatementDemo {

	public static void main(String[] args) {
		Connection con=null;
		PreparedStatement pstmt;
		ResultSet rs;
		Scanner scan;
		try 
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/classicmodels","root","admin");
			
			//create a preparedstatement object for passing the values at runtime
			pstmt=con.prepareStatement("select customerNumber,customerName,city,country from customers"
					+ " where country=?");
			
			scan=new Scanner(System.in);
			System.out.println("Enter Country name of customers to be displayed :");
			String country=scan.next();
			
			//assign value for input parameter of pstmt
			pstmt.setString(1, country);
			
			rs=pstmt.executeQuery();
			
			while(rs.next())
			{
				System.out.println(rs.getInt(1)+"\t"+rs.getString(2)+"\t"+
						rs.getString(3)+"\t"+rs.getString(4));
			}
			
			System.out.println("***************************************");
			
			scan=new Scanner(System.in);
			System.out.println("Enter Country name of customers to be displayed :");
			String country1=scan.next();
			
			//reuse for pstmt
			pstmt.setString(1, country1);
			
			rs=pstmt.executeQuery();
			
			while(rs.next())
			{
				System.out.println(rs.getInt(1)+"\t"+rs.getString(2)+"\t"+
						rs.getString(3)+"\t"+rs.getString(4));
			}
			
			con.close();
		}
		catch(Exception e)
		{
			System.out.println(e);
		}

	}
}