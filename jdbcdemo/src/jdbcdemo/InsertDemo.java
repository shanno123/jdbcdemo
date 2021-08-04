package jdbcdemo;

import java.sql.*;

//For inserting data value
public class InsertDemo {

	public static void main(String[] args) {
		
		Connection con;
		Statement stmt;
		ResultSet rs;
		int count;
		
		try
		{
			con=ConnectionUtil.createConnection();
			
			String str="insert into skills(name) values('VB.net')";
			
			stmt=con.createStatement();
			
			count=stmt.executeUpdate(str);//return no. of records affected
			
			if(count>0)
			{
				System.out.println("Record inserted Successfully");
			}
			
			//count is returning only aggregate value which is 6 in this case
			//so that row will be affected
			String str1="select count(id) from skills";
			rs=stmt.executeQuery(str1);
			int cnt=0;
			while(rs.next())
			{
				cnt=rs.getInt(1);
			}
			System.out.println("Total no. of records is :"+cnt);
		}
		catch(Exception e)
		{
			System.out.println(e);
		}

	}

}
