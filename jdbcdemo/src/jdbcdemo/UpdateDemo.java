package jdbcdemo;

//for updating a value
//Using OOPS logic
import java.sql.*;
import java.util.Scanner;
class Candidates
{
	Connection con;
    PreparedStatement pstmt; // Accepts values at run time - pre compiled statements
    ResultSet rs;
    int cnt=0;
    String sqlUpdate;String lastname;
    Scanner s;int eid;
    
    public void getConnection() throws Exception
    {
    	con=ConnectionUtil.createConnection();
    }
    
    public void UpdateCandidate() throws Exception
    {
    	sqlUpdate="update candidates set last_name=? where id=?";
    	
    	pstmt=con.prepareStatement(sqlUpdate);
    	
    	// prepare data for update
        s=new Scanner(System.in);
        System.out.println("enter Employee id:");
        eid=s.nextInt();
        System.out.println("enter employee's new last name :");
        lastname=s.next();
              
        // passing values to prepared statement using setter methods
        pstmt.setString(1,lastname);
        pstmt.setInt(2,eid);
        
        cnt=pstmt.executeUpdate();
        System.out.println(String.format("Row affected :%d",cnt));
        
     // reuse the prepared statement
        lastname = "Bush";
        eid = 101;
        pstmt.setString(1, lastname);
        pstmt.setInt(2, eid);

        cnt = pstmt.executeUpdate();
        System.out.println(String.format("Row affected :%d", cnt));
        con.close();
    }
}
public class UpdateDemo {

	public static void main(String[] args) {

		Candidates c1=new Candidates();
		try
		{
			c1.getConnection();
			c1.UpdateCandidate();
		}
		catch(Exception e)
		{
			System.out.println(e);
		}

	}

}
