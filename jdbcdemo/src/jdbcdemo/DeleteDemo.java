package jdbcdemo;

//for deleting a record
import java.sql.*;
public class DeleteDemo {

	public static void main(String[] args) {

		Connection con;
		Statement stmt;
		int cnt=0;
		
		try
		{
			con=ConnectionUtil.createConnection();
			//we can pass multiple queries for deleting
			String sql="delete from candidates where rtrim(last_name) "
						+"like \'K%g\'";
			String sql1="delete from candidates where id=101";
					;
			stmt=con.createStatement();
			cnt=stmt.executeUpdate(sql1);
			if(cnt>0)
			{
				System.out.println(cnt+" Records Deleted");
			}
			else
			{
				System.out.println("Records Not found");
			}
			con.close();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}

	}

}
