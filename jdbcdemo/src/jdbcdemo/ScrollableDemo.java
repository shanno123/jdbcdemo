package jdbcdemo;

import java.sql.*;

public class ScrollableDemo {

	public static void main(String[] args) {
		Connection con=null;
		Statement stmt;
		ResultSet rs;

		try 
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/mysqljdbc","root","admin");
			
			//Create Scrollable ResultSet
			stmt=con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
			
			rs=stmt.executeQuery("select * from skills");
			
			while(rs.next())
            {
				System.out.println(rs.getInt(1)+"  "+rs.getString(2));
            }
			System.out.println("*********Display Records from bottom to top**********");
			rs.afterLast();
			while(rs.previous())
            {
				System.out.println(rs.getInt(1)+"  "+rs.getString(2));
            }
			
			System.out.println("**********Display 3rd record**********");
			rs.absolute(3); // move the cursor to 3rd record
			System.out.println(rs.getInt(1)+"  "+rs.getString(2));
			
			System.out.println("**********Display 2nd record using relative()**********");
			//it can be +value also
			rs.relative(2); // move the cursor to 2nd record using relative
			System.out.println(rs.getInt(1)+"  "+rs.getString(2));
			
			System.out.println("**********Display 1st record using first()**********");
			//it can be +value also
			rs.first(); // move the cursor to 1st record using first
			System.out.println(rs.getInt(1)+"  "+rs.getString(2));
			
			System.out.println("**********Display Last record using last()**********");
			//it can be +value also
			rs.last(); // move the cursor to last record using last
			System.out.println(rs.getInt(1)+"  "+rs.getString(2));
			
			System.out.println();
			rs.absolute(4);
			System.out.println("Current Cursor position :"+rs.getRow());
			
			//after moving the last record we can display the total no. of records
			rs.last();
			System.out.println("Total no. of Records :"+rs.getRow());
			
			con.close();
		}
        catch(Exception e)
		{   
               System.out.println(e);
               } 

	}
}
